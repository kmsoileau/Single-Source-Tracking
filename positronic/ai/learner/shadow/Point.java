package positronic.ai.learner.shadow;

import positronic.ai.learner.AbstractPoint;
import positronic.ai.learner.IImage;
import positronic.ai.learner.ILearner;
import positronic.ai.learner.IPoint;

/**
 * <p>Title: Shadow Point</p>
 * <p>Copyright (c) 2012</p>
 * <p>Company: Positronic Software</p>
 * @author Kerry M. Soileau
 * @version 1.0
 */

public class Point extends AbstractPoint implements IPoint
{
  private static final double EPSILON = .005;
  private double x;
  private IImage image;

	public Point(double x, IImage value)
  {
    this.x=x;
    this.image=value;
  }

	public double distance(IPoint p1)
  {
    return Math.abs(((Point)p1).x-this.x);
  }

	public IImage getImage()
  {
    return this.image;
  }
  public double getX()
	{
		return x;
	}

  public void setImage(IImage x)
  {
    this.image=x;
  }

  public void setX(double x)
	{
		this.x = x;
	}

  public String toString()
  {
    return "("+x+")\t\t-->"+((Image)image).getValue();
  }
  
  public void train(ILearner lrn)
  {
	  Value y=((Image)this.getImage()).getValue();
	  if((Double)y.getValue()!=1.)
		  return;
	  if(lrn.size()==0)
	  {
		  this.learn(lrn);
		  //lrn.learn(this);
		  return;
	  }
	
	IPoint res=this.consult(lrn);
	if(this.getImage().distance(res.getImage())>EPSILON)
		this.learn(lrn);
	else
		if(Math.random()<=1./lrn.getQuality()-1.)
			((AbstractPoint)res).forget(lrn);
	System.out.println(lrn.size());
  }
}
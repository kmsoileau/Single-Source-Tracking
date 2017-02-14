package positronic.ai.learner.adder;

import positronic.ai.learner.AbstractPoint;
import positronic.ai.learner.IImage;
import positronic.ai.learner.IPoint;

/**
 * <p>Title: Point Object</p>
 * <p>Copyright (c) 2004</p>
 * <p>Company: Positronic Software</p>
 * @author Kerry M. Soileau
 * @version 1.0
 */

public class Point extends AbstractPoint implements IPoint
{
  private double x;
  private double y;
	private IImage image;

	public Point(double x, double y, IImage value)
  {
    this.x=x;
    this.y=y;
    this.image=value;
  }

	public double distance(IPoint p1)
  {
    double deltax=((Point)p1).x-this.x;
    double deltay=((Point)p1).y-this.y;
    return Math.sqrt(deltax*deltax+deltay*deltay);
  }

	public IImage getImage()
  {
    return this.image;
  }
  public double getX()
	{
		return x;
	}

  public double getY()
	{
		return y;
	}

  public void setImage(IImage x)
  {
    this.image=x;
  }

  public void setX(double x)
	{
		this.x = x;
	}

  public void setY(double y)
	{
		this.y = y;
	}

  public String toString()
  {
    return "("+x+","+y+")\t\t-->"+((Image)image).getValue();
  }
}
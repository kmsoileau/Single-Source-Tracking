package positronic.ai.learner.glint;

import positronic.ai.learner.AbstractPoint;
import positronic.ai.learner.IImage;
import positronic.ai.learner.IPoint;

public class Point extends AbstractPoint implements IPoint
{
  public double lambda;
  public double beta;
  public IImage image;

  public Point(double lambda, double beta, IImage value)
  {
    this.lambda=lambda;
    this.beta=beta;
    this.image=value;
  }

  public double distance(IPoint p2)
  {
    double deltax=this.lambda-((Point)p2).lambda;
    double deltay=this.beta-((Point)p2).beta;
    return Math.sqrt(deltax*deltax+deltay*deltay);
  }

  public IImage getImage()
  {
    return this.image;
  }

  public void setImage(IImage x)
  {
    this.image=x;
  }

  public String toMathematicaStyle()
  {
    return "{"+this.lambda+","+this.beta+","+((Image)image).getValue()+"}";
  }

  public String toString()
  {
    return "("+lambda+","+beta+")\t\t-->"+((Image)image).getValue();
  }
  
  public String toTabSeparated()
  {
    return this.lambda+"\t"+this.beta+"\t"+((Image)image).getValue();
  }
}
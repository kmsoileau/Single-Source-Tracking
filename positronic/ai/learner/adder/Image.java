package positronic.ai.learner.adder;

import positronic.ai.learner.IImage;

/**
 * <p>Title: TBS</p>
 * <p>Description: TBS</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Positronic Software</p>
 * @author Kerry Michael Soileau
 * @version 1.0
 */

public class Image implements IImage
{
  private Value value=new Value();

  public Image(double value)
  {
    this.value.setValue(value);
  }

  public double distance(IImage p1)
  {
	  Object y1=((Image)p1).value.getValue();
	  Double z1=(Double) y1;
	  Object y2=this.value.getValue();
	  Double z2=(Double) y2;
	  double deltax=z1-z2;
	  return Math.abs(deltax);
  }

  public String toString()
  {
    return ""+(String)(this.value.getValue());
  }

  public Value getValue()
  {
    return value;
  }
}
package positronic.ai.learner.shadow;

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
    double deltax=(Double)((Image)p1).value.getValue()-(Double)((Image)this).value.getValue();
    return Math.abs(deltax);
  }

  public String toString()
  {
    return ""+(Double)value.getValue();
  }

  public Value getValue()
  {
    return this.value;
  }

public double distance(IImage a, IImage b) {
	// TODO Auto-generated method stub
	return 0;
}
}
package positronic.ai.learner.blobs;

import positronic.ai.learner.IImage;
import positronic.ai.learner.adder.Value;

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
    double deltax=(Double)((Image)p1).value.getValue()-(Double)this.value.getValue();
    return Math.abs(deltax);
  }

  public String toString()
  {
    return value+"="+value;
  }

  public Value getValue()
  {
    return this.value;
  }
}
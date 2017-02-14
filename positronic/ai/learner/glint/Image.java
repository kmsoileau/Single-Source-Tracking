package positronic.ai.learner.glint;

import positronic.ai.learner.IImage;

public class Image implements IImage
{
  private Value value=new Value();
  
  public Image(double val)
  {
    this.value.setValue(val);
  }

  public double distance(IImage p2)
  {
    double deltax=(Double)this.value.getValue()-(Double)((Image)p2).value.getValue();
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
package positronic.math.statistics.creature;

public class Mean //implements Measurable 
{
	private double value;
	
	public Mean(double x)
	{
		this.value=x;
	}
	
	public double measure() 
	{
		return value;
	}
}

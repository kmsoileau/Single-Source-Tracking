package positronic.math;

public class Maths 
{
	public static double cliff(double x)
	{
		return cliff(10,x);
	}
	
	public static double cliff(int N, double x)
	{
		return 1./2+(-1+Math.sqrt(1+4*N*N*x*x))/4/N/x;
	}
}

package trackingsat;

public class rdotR
{
	private static double m0;
	
	public static double eval(Measurement m, double r)
	{
		m0=m.m0;
		return (1 - m0 + Measurement.power(r,2))/2.;
	}
}



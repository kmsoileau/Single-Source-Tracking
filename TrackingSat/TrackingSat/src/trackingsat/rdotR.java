package trackingsat;

public class rdotR
{
	private static double m0;
	
	public double eval(Measurement m, double r, double rdotv)
	{
		m0=m.m0;
		return (1 - m0 + Measurement.power(r,2))/2.;
	}
}



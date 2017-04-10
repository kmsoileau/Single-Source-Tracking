package trackingsat;

public class vdotT
{
	private static double m0,m2;
	
	public double eval(trackingsat.Measurement m, double r, double rdotv, double v)
	{
		m0=m.m0;
		m2=m.m2;
		return (1 - Measurement.power(r,2) + Measurement.power(r,5) - m0*(1 + Measurement.power(r,3)) + Measurement.power(r,3)*(1 - m2 + 2*Measurement.power(v,2)))/(4.*Measurement.power(r,3));
	}
}


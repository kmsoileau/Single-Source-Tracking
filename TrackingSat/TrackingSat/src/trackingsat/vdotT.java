package trackingsat;

public class vdotT
{
	private static double m0,m2;
	
	public static double eval(trackingsat.Measurement m, double r, double rdotv, double v)
	{
		m0=m.m0;
		m2=m.m2;
		return (1 - Measurement.Power(r,2) + Measurement.Power(r,5) - m0*(1 + Measurement.Power(r,3)) 
				+ Measurement.Power(r,3)*(1 - m2 + 2*Measurement.Power(v,2)))/(4.*Measurement.Power(r,3));
	}
}


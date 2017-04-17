package trackingsat;

public class vdotR
{
	private static double m0,m1,m3;
	
	public static double eval(Measurement m, double r, double rdotv)
	{
		m0=m.m0;
		m1=m.m1;
		m3=m.m3;
		return (m3*Measurement.Power(r,5) + m1*Measurement.Power(r,2)*(3 + Measurement.Power(r,3)) 
				- (-3 + 3*m0 + Measurement.Power(r,2) + 2*Measurement.Power(r,5))*rdotv)/
				(4.*Measurement.Power(r,2)*(-1 + Measurement.Power(r,3)));
	}
}



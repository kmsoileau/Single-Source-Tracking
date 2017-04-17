package trackingsat;

public class rdotT
{
	private static double m0,m1,m3;
	
	public static double eval(trackingsat.Measurement m, double r, double rdotv)
	{
		m0=m.m0;
		m1=m.m1;
		m3=m.m3;
		double r2=Measurement.Power(r,2);
		double r3=Measurement.Power(r,3);
		double r5=Measurement.Power(r,5);
		return (-(r2*(m1 + 3*m1*r3 + m3*r3)) 
				+ 3*(-1 + m0 - r2 + 2*r5)*rdotv)/
				(4.*r2*(-1 + r3));
	}
}



package trackingsat;

public class rdotT
{
	private static double m0,m1,m3;
	
	public double eval(trackingsat.Measurement m, double r, double rdotv)
	{
		m0=m.m0;
		m1=m.m1;
		m3=m.m3;
		return (-(Measurement.power(r,2)*(m1 + 3*m1*Measurement.power(r,3) + m3*Measurement.power(r,3))) + 3*(-1 + m0 - Measurement.power(r,2) + 2*Measurement.power(r,5))*rdotv)/
				(4.*Measurement.power(r,2)*(-1 + Measurement.power(r,3)));
	}
}



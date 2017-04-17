package trackingsat;

public class vdotv
{
	private static double m0,m1,m2,m3,m4;
	
	public static double eval(Measurement m, double r, double rdotv)
	{
		m0=m.m0;
		m1=m.m1;
		m2=m.m2;
		m3=m.m3;
		m4=m.m4;
		
		return (-4*(-1 + m0)*r + (6*m0 - 2*(3 + m2))*Measurement.Power(r,4) - 8*Measurement.Power(r,6) - (-3 + 3*m0 + m4)*Measurement.Power(r,7) + 7*Measurement.Power(r,9) + 
			     (-1 + m0 + 2*m2 + m4)*Measurement.Power(r,10) - Measurement.Power(r,12) + 3*m1*Measurement.Power(r,2)*rdotv - 3*Measurement.Power(r,5)*(5*m1 + m3 - 3*rdotv)*rdotv - 
			     6*(-1 + m0)*Measurement.Power(rdotv,2) + Measurement.Power(r,3)*(2 + 15*(-1 + m0)*Measurement.Power(rdotv,2)))/
			   (Measurement.Power(r,2)*(-1 + Measurement.Power(r,3))*(-3 + 3*m0 - Measurement.Power(r,2) + 4*Measurement.Power(r,5)));
	}
}
package trackingsat;

public class rdotv
{
	private static double m0,m1,m2,m3,m4;
	
	public static double eval(Measurement m, double r, double v)
	{
		m0=m.m0;
		m1=m.m1;
		m2=m.m2;
		m3=m.m3;
		m4=m.m4;
		double p2=Measurement.power(r,2);
		double p3=Measurement.power(r,3);
		double p4=Measurement.power(r,4);
		double p5=Measurement.power(r,5);
		double p6=Measurement.power(r,6);
		double r7=Measurement.power(r,7);
		double p9=Measurement.power(r,9);
		
		double p10=Measurement.power(r,10);
		double p11=Measurement.power(r,11);
		double r12=Measurement.power(r,12);
		double p13=Measurement.power(r,13);
		double r14=Measurement.power(r,14);
		//double p15=Measurement.power(r,15);
		double p16=Measurement.power(r,16);
		//double p17=Measurement.power(r,17);
		//double p18=Measurement.power(r,18);
		//double p19=Measurement.power(r,19);
		
		double v2=Measurement.power(v,2);
		return 
				-32 - 16*p2 + 56*p5 + 96*p10 - 84*p13 + 12*p16 + 24*r*v2 - 
				   84*p4*v2 + 4*p11*(28 + 3*m4 - 15*v2) - 4*r14*(2 + 6*m2 + 3*m4 - 12*v2) + 
				   20*r12*(-1 + 2*m2 + m4 - 4*v2) + 12*r7*(-2 + 5*v2) - 
				   2*p6*(72 + 15*m1*m1 + 20*m2 + 3*m1*m3 - 4*m4 + 12*v2) + 
				   p9*(68 + 75*m1*m1 - 16*m2 + 30*m1*m3 + 3*m3*m3 - 28*m4 + 96*v2) - 
				   4*m0*m0*(2 - 7*p3 + 5*p6)*(4 - 2*p3 + p6 - 3*r*v2) + 
				   p3*(3*m1*m1 + 8*(16 + 2*m2 + v2)) + 
				   4*m0*(16 + 4*p2 - 14*p5 - 28*p11 + 2*r14 - 12*r*v2 + 42*p4*v2 - 
				      30*r7*v2 + p9*(-34 + 4*m2 + 7*m4 - 24*v2) - 
				      5*r12*(-2 + 2*m2 + m4 - 4*v2) - 2*p3*(32 + 2*m2 + v2) + 
				      2*p6*(36 + 5*m2 - m4 + 3*v2));
	}
}
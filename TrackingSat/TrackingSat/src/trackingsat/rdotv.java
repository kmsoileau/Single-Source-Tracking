package trackingsat;

import java.util.ArrayList;

public class rdotv
{
	static double m0,m1,m2,m3,m4;
	
	private static double alpha(double r)
	{
		return Measurement.Power(r,5)*(-15*m3 + 15*m0*m3 - 21*m3*Measurement.Power(r,2)) + 
		   m1*Measurement.Power(r,2)*(15 - 15*m0 + Measurement.Power(r,2)*(21 + r*(-75 + 75*m0 
				   - 105*Measurement.Power(r,2))));
	}
	
	private static double beta(double r, double v)
	{
		return r*(-2400 + 9600*m0 - 14400*Measurement.Power(m0,2) + 9600*Measurement.Power(m0,3) - 2400*Measurement.Power(m0,4) + 
			     r*(1800*Measurement.Power(v,2) - 7200*m0*Measurement.Power(v,2) + 10800*Measurement.Power(m0,2)*Measurement.Power(v,2) - 7200*Measurement.Power(m0,3)*Measurement.Power(v,2) + 
			    	        1800*Measurement.Power(m0,4)*Measurement.Power(v,2) + r*(-7920 + 23760*m0 - 23760*Measurement.Power(m0,2) + 7920*Measurement.Power(m0,3) + 
			    	           r*(9600 - 38400*m0 + 57600*Measurement.Power(m0,2) - 38400*Measurement.Power(m0,3) + 9600*Measurement.Power(m0,4) + 225*Measurement.Power(m1,2) - 
			    	              450*m0*Measurement.Power(m1,2) + 225*Measurement.Power(m0,2)*Measurement.Power(m1,2) + 1200*m2 - 3600*m0*m2 + 3600*Measurement.Power(m0,2)*m2 - 
			    	              1200*Measurement.Power(m0,3)*m2 + 5640*Measurement.Power(v,2) - 16920*m0*Measurement.Power(v,2) + 16920*Measurement.Power(m0,2)*Measurement.Power(v,2) - 
			    	              5640*Measurement.Power(m0,3)*Measurement.Power(v,2) + r*(-8064 + 16128*m0 - 8064*Measurement.Power(m0,2) - 6300*Measurement.Power(v,2) + 
			    	                 25200*m0*Measurement.Power(v,2) - 37800*Measurement.Power(m0,2)*Measurement.Power(v,2) + 25200*Measurement.Power(m0,3)*Measurement.Power(v,2) - 
			    	                 6300*Measurement.Power(m0,4)*Measurement.Power(v,2) + r*(31080 - 93240*m0 + 93240*Measurement.Power(m0,2) - 31080*Measurement.Power(m0,3) + 
			    	                    630*Measurement.Power(m1,2) - 630*m0*Measurement.Power(m1,2) + 3360*m2 - 6720*m0*m2 + 3360*Measurement.Power(m0,2)*m2 + 5208*Measurement.Power(v,2) - 
			    	                    10416*m0*Measurement.Power(v,2) + 5208*Measurement.Power(m0,2)*Measurement.Power(v,2) + 
			    	                    r*(-13152 + 45552*m0 - 64800*Measurement.Power(m0,2) + 43200*Measurement.Power(m0,3) - 10800*Measurement.Power(m0,4) - 2250*Measurement.Power(m1,2) + 
			    	                       4500*m0*Measurement.Power(m1,2) - 2250*Measurement.Power(m0,2)*Measurement.Power(m1,2) - 3000*m2 + 9000*m0*m2 - 9000*Measurement.Power(m0,2)*m2 + 
			    	                       3000*Measurement.Power(m0,3)*m2 - 450*m1*m3 + 900*m0*m1*m3 - 450*Measurement.Power(m0,2)*m1*m3 + 600*m4 - 1800*m0*m4 + 
			    	                       1800*Measurement.Power(m0,2)*m4 - 600*Measurement.Power(m0,3)*m4 - 19440*Measurement.Power(v,2) + 58320*m0*Measurement.Power(v,2) - 
			    	                       58320*Measurement.Power(m0,2)*Measurement.Power(v,2) + 19440*Measurement.Power(m0,3)*Measurement.Power(v,2) + 
			    	                       r*(28776 - 57552*m0 + 28776*Measurement.Power(m0,2) + 441*Measurement.Power(m1,2) + 2352*m2 - 2352*m0*m2 + 5676*Measurement.Power(v,2) - 
			    	                          19176*m0*Measurement.Power(v,2) + 27000*Measurement.Power(m0,2)*Measurement.Power(v,2) - 18000*Measurement.Power(m0,3)*Measurement.Power(v,2) + 
			    	                          4500*Measurement.Power(m0,4)*Measurement.Power(v,2) + 
			    	                          r*(-41040 + 123120*m0 - 123120*Measurement.Power(m0,2) + 41040*Measurement.Power(m0,3) - 6300*Measurement.Power(m1,2) + 
			    	                             6300*m0*Measurement.Power(m1,2) - 6600*m2 + 13200*m0*m2 - 6600*Measurement.Power(m0,2)*m2 - 1260*m1*m3 + 
			    	                             1260*m0*m1*m3 + 1680*m4 - 3360*m0*m4 + 1680*Measurement.Power(m0,2)*m4 - 16488*Measurement.Power(v,2) + 
			    	                             32976*m0*Measurement.Power(v,2) - 16488*Measurement.Power(m0,2)*Measurement.Power(v,2) + 
			    	                             r*(8292 - 23592*m0 + 30600*Measurement.Power(m0,2) - 20400*Measurement.Power(m0,3) + 5100*Measurement.Power(m0,4) + 
			    	                                5625*Measurement.Power(m1,2) - 11250*m0*Measurement.Power(m1,2) + 5625*Measurement.Power(m0,2)*Measurement.Power(m1,2) - 1200*m2 + 
			    	                                3600*m0*m2 - 3600*Measurement.Power(m0,2)*m2 + 1200*Measurement.Power(m0,3)*m2 + 2250*m1*m3 - 4500*m0*m1*m3 + 
			    	                                2250*Measurement.Power(m0,2)*m1*m3 + 225*Measurement.Power(m3,2) - 450*m0*Measurement.Power(m3,2) + 
			    	                                225*Measurement.Power(m0,2)*Measurement.Power(m3,2) - 2100*m4 + 6300*m0*m4 - 6300*Measurement.Power(m0,2)*m4 + 
			    	                                2100*Measurement.Power(m0,3)*m4 + 19800*Measurement.Power(v,2) - 59400*m0*Measurement.Power(v,2) + 
			    	                                59400*Measurement.Power(m0,2)*Measurement.Power(v,2) - 19800*Measurement.Power(m0,3)*Measurement.Power(v,2) + 
			    	                                r*(-44208 + 88416*m0 - 44208*Measurement.Power(m0,2) - 4410*Measurement.Power(m1,2) - 840*m2 + 840*m0*m2 - 
			    	                                   882*m1*m3 + 1176*m4 - 1176*m0*m4 - 1008*Measurement.Power(v,2) + 1008*m0*Measurement.Power(v,2) + 
			    	                                   r*(19152 - 68040*m0 + 68040*Measurement.Power(m0,2) - 22680*Measurement.Power(m0,3) + 15750*Measurement.Power(m1,2) - 
			    	                                      15750*m0*Measurement.Power(m1,2) - 3360*m2 + 6720*m0*m2 - 3360*Measurement.Power(m0,2)*m2 + 6300*m1*m3 - 
			    	                                      6300*m0*m1*m3 + 630*Measurement.Power(m3,2) - 630*m0*Measurement.Power(m3,2) - 4980*m4 + 9960*m0*m4 - 
			    	                                      4980*Measurement.Power(m0,2)*m4 + 24480*Measurement.Power(v,2) - 48960*m0*Measurement.Power(v,2) + 
			    	                                      24480*Measurement.Power(m0,2)*Measurement.Power(v,2) + 
			    	                                      r*(-2508 + 7008*m0 - 9000*Measurement.Power(m0,2) + 6000*Measurement.Power(m0,3) - 1500*Measurement.Power(m0,4) + 
			    	                                         6528*m2 - 9000*m0*m2 + 9000*Measurement.Power(m0,2)*m2 - 3000*Measurement.Power(m0,3)*m2 + 1500*m4 - 
			    	                                         4500*m0*m4 + 4500*Measurement.Power(m0,2)*m4 - 1500*Measurement.Power(m0,3)*m4 - 4236*Measurement.Power(v,2) + 
			    	                                         18000*m0*Measurement.Power(v,2) - 18000*Measurement.Power(m0,2)*Measurement.Power(v,2) + 6000*Measurement.Power(m0,3)*Measurement.Power(v,2) + 
			    	                                         r*(27216 - 54432*m0 + 27216*Measurement.Power(m0,2) + 11025*Measurement.Power(m1,2) - 2352*m2 + 
			    	                                           2352*m0*m2 + 4410*m1*m3 + 441*Measurement.Power(m3,2) - 1596*m4 + 1596*m0*m4 + 
			    	                                           1512*Measurement.Power(v,2) - 1512*m0*Measurement.Power(v,2) + 
			    	                                           r*(9312 + 14400*m0 - 14400*Measurement.Power(m0,2) + 4800*Measurement.Power(m0,3) + 6600*m2 - 
			    	                                           13200*m0*m2 + 6600*Measurement.Power(m0,2)*m2 + 3300*m4 - 6600*m0*m4 + 3300*Measurement.Power(m0,2)*m4 - 
			    	                                           13200*Measurement.Power(v,2) + 26400*m0*Measurement.Power(v,2) - 13200*Measurement.Power(m0,2)*Measurement.Power(v,2) + 
			    	                                           r*(-1176 + 1176*m0 + 1764*m4 - 8820*Measurement.Power(v,2) + 
			    	                                           r*(-3720 + 7440*m0 - 3720*Measurement.Power(m0,2) + 840*m2 - 840*m0*m2 + 420*m4 - 
			    	                                           420*m0*m4 - 1680*Measurement.Power(v,2) + 1680*m0*Measurement.Power(v,2) + 
			    	                                           r*(-12348 + 
			    	                                           r*(1344 - 1344*m0 - 3528*m2 - 1764*m4 + 1764*Measurement.Power(r,2) + 7056*Measurement.Power(v,2)))))))))
			    	                                   )))))))))));
	}
	
	public static ArrayList eval(Measurement m, double r, double v)
	{
		double p2=Measurement.Power(r,2);
		double p3=Measurement.Power(r,3);
		double p4=Measurement.Power(r,4);
		double p5=Measurement.Power(r,5);
		double p6=Measurement.Power(r,6);
		double r7=Measurement.Power(r,7);
		double p9=Measurement.Power(r,9);
		
		double p10=Measurement.Power(r,10);
		double p11=Measurement.Power(r,11);
		double r12=Measurement.Power(r,12);
		double p13=Measurement.Power(r,13);
		double r14=Measurement.Power(r,14);
		//double p15=Measurement.Power(r,15);
		double p16=Measurement.Power(r,16);
		//double p17=Measurement.Power(r,17);
		//double p18=Measurement.Power(r,18);
		//double p19=Measurement.Power(r,19);
		
		ArrayList<Double> ret=new ArrayList<Double>();
		double a=alpha(r);
		double b=beta(r,v);
		double g=gamma(r);
		double ret1=(a + Math.sqrt(b))/g;
		if(Math.abs(ret1) <= r*v)
			ret.add(ret1);
		double ret2=(alpha(r) - Math.sqrt(beta(r,v)))/gamma(r);
		if(Math.abs(ret2) <= r*v)
			ret.add(ret2);
		return ret;
	}
	
	private static double gamma(double r)
	{
		return -60 + 120*m0 - 60*Measurement.Power(m0,2) + Measurement.Power(r,2)*(-84 + 84*m0 + 
			      r*(150 - 300*m0 + 150*Measurement.Power(m0,2) + Measurement.Power(r,2)*(120 - 120*m0 
			    		  - 126*Measurement.Power(r,2))));
	}
	
	public static void init(Measurement m)
	{
		m0=m.m0;
		m1=m.m1;
		m2=m.m2;
		m3=m.m3;
		m4=m.m4;
	}
}
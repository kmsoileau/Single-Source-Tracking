package trackingsat;

public class rdotv
{
	private static double m0,m1,m2,m3,m6;
	
	public static double eval(Measurement m, double r, double v)
	{
		m0=m.m0;
		m1=m.m1;
		m2=m.m2;
		m3=m.m3;
		m6=m.m6;
		return 
				-(3*m1*Measurement.power(r,2) - 7*m1*Measurement.power(r,5) - m3*Measurement.power(r,5))/(12.*(2 - 2*m0 - 3*Measurement.power(r,3) + 3*m0*Measurement.power(r,3) + Measurement.power(r,5))) - 
				Sqrt(Measurement.power(3*m1*Measurement.power(r,2) - 7*m1*Measurement.power(r,5) - m3*Measurement.power(r,5),2)/
				    (36.*Measurement.power(2 - 2*m0 - 3*Measurement.power(r,3) + 3*m0*Measurement.power(r,3) + Measurement.power(r,5),2)) - 
				   (34*r - 34*m0*r + 6*Measurement.power(r,3) - 46*Measurement.power(r,4) + 46*m0*Measurement.power(r,4) - 9*m2*Measurement.power(r,4) + 6*Measurement.power(r,7) - 
				      6*m0*Measurement.power(r,7) + 9*m2*Measurement.power(r,7) - 33*Measurement.power(r,2)*Measurement.power(v,2) + 33*m0*Measurement.power(r,2)*Measurement.power(v,2) - 
				      3*Measurement.power(r,4)*Measurement.power(v,2) + 42*Measurement.power(r,5)*Measurement.power(v,2) - 42*m0*Measurement.power(r,5)*Measurement.power(v,2) - 6*Measurement.power(r,7)*Measurement.power(v,2))/
				    (21.*(2 - 2*m0 - 3*Measurement.power(r,3) + 3*m0*Measurement.power(r,3) + Measurement.power(r,5))) - 
				   (-34*r + 34*m0*r - 6*Measurement.power(r,3) + 46*Measurement.power(r,4) - 46*m0*Measurement.power(r,4) + 9*m2*Measurement.power(r,4) - 6*Measurement.power(r,7) + 
				      6*m0*Measurement.power(r,7) - 9*m2*Measurement.power(r,7) + 33*Measurement.power(r,2)*Measurement.power(v,2) - 33*m0*Measurement.power(r,2)*Measurement.power(v,2) + 
				      3*Measurement.power(r,4)*Measurement.power(v,2) - 42*Measurement.power(r,5)*Measurement.power(v,2) + 42*m0*Measurement.power(r,5)*Measurement.power(v,2) + 6*Measurement.power(r,7)*Measurement.power(v,2))/
				    (63.*(2 - 2*m0 - 3*Measurement.power(r,3) + 3*m0*Measurement.power(r,3) + Measurement.power(r,5))) + 
				   (Measurement.power(2,0.3333333333333333)*(225*Measurement.power(-34*r + 34*m0*r - 6*Measurement.power(r,3) + 46*Measurement.power(r,4) - 46*m0*Measurement.power(r,4) + 
				           9*m2*Measurement.power(r,4) - 6*Measurement.power(r,7) + 6*m0*Measurement.power(r,7) - 9*m2*Measurement.power(r,7) + 33*Measurement.power(r,2)*Measurement.power(v,2) - 
				           33*m0*Measurement.power(r,2)*Measurement.power(v,2) + 3*Measurement.power(r,4)*Measurement.power(v,2) - 42*Measurement.power(r,5)*Measurement.power(v,2) + 
				           42*m0*Measurement.power(r,5)*Measurement.power(v,2) + 6*Measurement.power(r,7)*Measurement.power(v,2),2) + 
				        4725*(-3*m1*Measurement.power(r,2) + 7*m1*Measurement.power(r,5) + m3*Measurement.power(r,5))*
				         (9*m1*Measurement.power(r,3) - 20*m1*Measurement.power(r,6) - m3*Measurement.power(r,6) + 3*m1*Measurement.power(r,9) - m3*Measurement.power(r,9) - 
				           9*m1*Measurement.power(r,4)*Measurement.power(v,2) + 21*m1*Measurement.power(r,7)*Measurement.power(v,2) + 3*m3*Measurement.power(r,7)*Measurement.power(v,2)) + 
				        3780*(2 - 2*m0 - 3*Measurement.power(r,3) + 3*m0*Measurement.power(r,3) + Measurement.power(r,5))*
				         (46*Measurement.power(r,2) - 46*m0*Measurement.power(r,2) + 14*Measurement.power(r,4) - 62*Measurement.power(r,5) + 62*m0*Measurement.power(r,5) - 24*m2*Measurement.power(r,5) - 
				           10*Measurement.power(r,7) + 18*Measurement.power(r,8) - 18*m0*Measurement.power(r,8) + 34*m2*Measurement.power(r,8) + 4*Measurement.power(r,10) - 4*Measurement.power(r,11) + 
				           4*m0*Measurement.power(r,11) - 7*m2*Measurement.power(r,11) - m6*Measurement.power(r,11) - 10*Measurement.power(r,13) + 2*Measurement.power(r,14) - 2*m0*Measurement.power(r,14) - 
				           3*m2*Measurement.power(r,14) + m6*Measurement.power(r,14) + 2*Measurement.power(r,16) - 93*Measurement.power(r,3)*Measurement.power(v,2) + 93*m0*Measurement.power(r,3)*Measurement.power(v,2) - 
				           25*Measurement.power(r,5)*Measurement.power(v,2) + 111*Measurement.power(r,6)*Measurement.power(v,2) - 111*m0*Measurement.power(r,6)*Measurement.power(v,2) + 
				           27*m2*Measurement.power(r,6)*Measurement.power(v,2) + 23*Measurement.power(r,8)*Measurement.power(v,2) - 18*Measurement.power(r,9)*Measurement.power(v,2) + 
				           18*m0*Measurement.power(r,9)*Measurement.power(v,2) - 27*m2*Measurement.power(r,9)*Measurement.power(v,2) - 4*Measurement.power(r,11)*Measurement.power(v,2) + 
				           6*Measurement.power(r,14)*Measurement.power(v,2) + 45*Measurement.power(r,4)*Measurement.power(v,4) - 45*m0*Measurement.power(r,4)*Measurement.power(v,4) + 9*Measurement.power(r,6)*Measurement.power(v,4) - 
				           45*Measurement.power(r,7)*Measurement.power(v,4) + 45*m0*Measurement.power(r,7)*Measurement.power(v,4) - 9*Measurement.power(r,9)*Measurement.power(v,4))))/
				    (945.*(2 - 2*m0 - 3*Measurement.power(r,3) + 3*m0*Measurement.power(r,3) + Measurement.power(r,5))*
				      Measurement.power(-6750*Measurement.power(-34*r + 34*m0*r - 6*Measurement.power(r,3) + 46*Measurement.power(r,4) - 46*m0*Measurement.power(r,4) + 9*m2*Measurement.power(r,4) - 
				           6*Measurement.power(r,7) + 6*m0*Measurement.power(r,7) - 9*m2*Measurement.power(r,7) + 33*Measurement.power(r,2)*Measurement.power(v,2) - 33*m0*Measurement.power(r,2)*Measurement.power(v,2) + 
				           3*Measurement.power(r,4)*Measurement.power(v,2) - 42*Measurement.power(r,5)*Measurement.power(v,2) + 42*m0*Measurement.power(r,5)*Measurement.power(v,2) + 6*Measurement.power(r,7)*Measurement.power(v,2),3)
				         - 212625*(-3*m1*Measurement.power(r,2) + 7*m1*Measurement.power(r,5) + m3*Measurement.power(r,5))*
				         (-34*r + 34*m0*r - 6*Measurement.power(r,3) + 46*Measurement.power(r,4) - 46*m0*Measurement.power(r,4) + 9*m2*Measurement.power(r,4) - 6*Measurement.power(r,7) + 
				           6*m0*Measurement.power(r,7) - 9*m2*Measurement.power(r,7) + 33*Measurement.power(r,2)*Measurement.power(v,2) - 33*m0*Measurement.power(r,2)*Measurement.power(v,2) + 
				           3*Measurement.power(r,4)*Measurement.power(v,2) - 42*Measurement.power(r,5)*Measurement.power(v,2) + 42*m0*Measurement.power(r,5)*Measurement.power(v,2) + 6*Measurement.power(r,7)*Measurement.power(v,2))*
				         (9*m1*Measurement.power(r,3) - 20*m1*Measurement.power(r,6) - m3*Measurement.power(r,6) + 3*m1*Measurement.power(r,9) - m3*Measurement.power(r,9) - 
				           9*m1*Measurement.power(r,4)*Measurement.power(v,2) + 21*m1*Measurement.power(r,7)*Measurement.power(v,2) + 3*m3*Measurement.power(r,7)*Measurement.power(v,2)) + 
				        1913625*(2 - 2*m0 - 3*Measurement.power(r,3) + 3*m0*Measurement.power(r,3) + Measurement.power(r,5))*
				         Measurement.power(9*m1*Measurement.power(r,3) - 20*m1*Measurement.power(r,6) - m3*Measurement.power(r,6) + 3*m1*Measurement.power(r,9) - m3*Measurement.power(r,9) - 
				           9*m1*Measurement.power(r,4)*Measurement.power(v,2) + 21*m1*Measurement.power(r,7)*Measurement.power(v,2) + 3*m3*Measurement.power(r,7)*Measurement.power(v,2),2) + 
				        297675*Measurement.power(-3*m1*Measurement.power(r,2) + 7*m1*Measurement.power(r,5) + m3*Measurement.power(r,5),2)*
				         (46*Measurement.power(r,2) - 46*m0*Measurement.power(r,2) + 14*Measurement.power(r,4) - 62*Measurement.power(r,5) + 62*m0*Measurement.power(r,5) - 24*m2*Measurement.power(r,5) - 
				           10*Measurement.power(r,7) + 18*Measurement.power(r,8) - 18*m0*Measurement.power(r,8) + 34*m2*Measurement.power(r,8) + 4*Measurement.power(r,10) - 4*Measurement.power(r,11) + 
				           4*m0*Measurement.power(r,11) - 7*m2*Measurement.power(r,11) - m6*Measurement.power(r,11) - 10*Measurement.power(r,13) + 2*Measurement.power(r,14) - 2*m0*Measurement.power(r,14) - 
				           3*m2*Measurement.power(r,14) + m6*Measurement.power(r,14) + 2*Measurement.power(r,16) - 93*Measurement.power(r,3)*Measurement.power(v,2) + 93*m0*Measurement.power(r,3)*Measurement.power(v,2) - 
				           25*Measurement.power(r,5)*Measurement.power(v,2) + 111*Measurement.power(r,6)*Measurement.power(v,2) - 111*m0*Measurement.power(r,6)*Measurement.power(v,2) + 
				           27*m2*Measurement.power(r,6)*Measurement.power(v,2) + 23*Measurement.power(r,8)*Measurement.power(v,2) - 18*Measurement.power(r,9)*Measurement.power(v,2) + 
				           18*m0*Measurement.power(r,9)*Measurement.power(v,2) - 27*m2*Measurement.power(r,9)*Measurement.power(v,2) - 4*Measurement.power(r,11)*Measurement.power(v,2) + 
				           6*Measurement.power(r,14)*Measurement.power(v,2) + 45*Measurement.power(r,4)*Measurement.power(v,4) - 45*m0*Measurement.power(r,4)*Measurement.power(v,4) + 9*Measurement.power(r,6)*Measurement.power(v,4) - 
				           45*Measurement.power(r,7)*Measurement.power(v,4) + 45*m0*Measurement.power(r,7)*Measurement.power(v,4) - 9*Measurement.power(r,9)*Measurement.power(v,4)) + 
				        340200*(2 - 2*m0 - 3*Measurement.power(r,3) + 3*m0*Measurement.power(r,3) + Measurement.power(r,5))*
				         (-34*r + 34*m0*r - 6*Measurement.power(r,3) + 46*Measurement.power(r,4) - 46*m0*Measurement.power(r,4) + 9*m2*Measurement.power(r,4) - 6*Measurement.power(r,7) + 
				           6*m0*Measurement.power(r,7) - 9*m2*Measurement.power(r,7) + 33*Measurement.power(r,2)*Measurement.power(v,2) - 33*m0*Measurement.power(r,2)*Measurement.power(v,2) + 
				           3*Measurement.power(r,4)*Measurement.power(v,2) - 42*Measurement.power(r,5)*Measurement.power(v,2) + 42*m0*Measurement.power(r,5)*Measurement.power(v,2) + 6*Measurement.power(r,7)*Measurement.power(v,2))*
				         (46*Measurement.power(r,2) - 46*m0*Measurement.power(r,2) + 14*Measurement.power(r,4) - 62*Measurement.power(r,5) + 62*m0*Measurement.power(r,5) - 24*m2*Measurement.power(r,5) - 
				           10*Measurement.power(r,7) + 18*Measurement.power(r,8) - 18*m0*Measurement.power(r,8) + 34*m2*Measurement.power(r,8) + 4*Measurement.power(r,10) - 4*Measurement.power(r,11) + 
				           4*m0*Measurement.power(r,11) - 7*m2*Measurement.power(r,11) - m6*Measurement.power(r,11) - 10*Measurement.power(r,13) + 2*Measurement.power(r,14) - 2*m0*Measurement.power(r,14) - 
				           3*m2*Measurement.power(r,14) + m6*Measurement.power(r,14) + 2*Measurement.power(r,16) - 93*Measurement.power(r,3)*Measurement.power(v,2) + 93*m0*Measurement.power(r,3)*Measurement.power(v,2) - 
				           25*Measurement.power(r,5)*Measurement.power(v,2) + 111*Measurement.power(r,6)*Measurement.power(v,2) - 111*m0*Measurement.power(r,6)*Measurement.power(v,2) + 
				           27*m2*Measurement.power(r,6)*Measurement.power(v,2) + 23*Measurement.power(r,8)*Measurement.power(v,2) - 18*Measurement.power(r,9)*Measurement.power(v,2) + 
				           18*m0*Measurement.power(r,9)*Measurement.power(v,2) - 27*m2*Measurement.power(r,9)*Measurement.power(v,2) - 4*Measurement.power(r,11)*Measurement.power(v,2) + 
				           6*Measurement.power(r,14)*Measurement.power(v,2) + 45*Measurement.power(r,4)*Measurement.power(v,4) - 45*m0*Measurement.power(r,4)*Measurement.power(v,4) + 9*Measurement.power(r,6)*Measurement.power(v,4) - 
				           45*Measurement.power(r,7)*Measurement.power(v,4) + 45*m0*Measurement.power(r,7)*Measurement.power(v,4) - 9*Measurement.power(r,9)*Measurement.power(v,4)) + 
				        Sqrt(-4*Measurement.power(225*Measurement.power(-34*r + 34*m0*r - 6*Measurement.power(r,3) + 46*Measurement.power(r,4) - 46*m0*Measurement.power(r,4) + 9*m2*Measurement.power(r,4) - 
				                6*Measurement.power(r,7) + 6*m0*Measurement.power(r,7) - 9*m2*Measurement.power(r,7) + 33*Measurement.power(r,2)*Measurement.power(v,2) - 
				                33*m0*Measurement.power(r,2)*Measurement.power(v,2) + 3*Measurement.power(r,4)*Measurement.power(v,2) - 42*Measurement.power(r,5)*Measurement.power(v,2) + 
				                42*m0*Measurement.power(r,5)*Measurement.power(v,2) + 6*Measurement.power(r,7)*Measurement.power(v,2),2) + 
				             4725*(-3*m1*Measurement.power(r,2) + 7*m1*Measurement.power(r,5) + m3*Measurement.power(r,5))*
				              (9*m1*Measurement.power(r,3) - 20*m1*Measurement.power(r,6) - m3*Measurement.power(r,6) + 3*m1*Measurement.power(r,9) - m3*Measurement.power(r,9) - 
				                9*m1*Measurement.power(r,4)*Measurement.power(v,2) + 21*m1*Measurement.power(r,7)*Measurement.power(v,2) + 3*m3*Measurement.power(r,7)*Measurement.power(v,2)) + 
				             3780*(2 - 2*m0 - 3*Measurement.power(r,3) + 3*m0*Measurement.power(r,3) + Measurement.power(r,5))*
				              (46*Measurement.power(r,2) - 46*m0*Measurement.power(r,2) + 14*Measurement.power(r,4) - 62*Measurement.power(r,5) + 62*m0*Measurement.power(r,5) - 24*m2*Measurement.power(r,5) - 
				                10*Measurement.power(r,7) + 18*Measurement.power(r,8) - 18*m0*Measurement.power(r,8) + 34*m2*Measurement.power(r,8) + 4*Measurement.power(r,10) - 4*Measurement.power(r,11) + 
				                4*m0*Measurement.power(r,11) - 7*m2*Measurement.power(r,11) - m6*Measurement.power(r,11) - 10*Measurement.power(r,13) + 2*Measurement.power(r,14) - 
				                2*m0*Measurement.power(r,14) - 3*m2*Measurement.power(r,14) + m6*Measurement.power(r,14) + 2*Measurement.power(r,16) - 93*Measurement.power(r,3)*Measurement.power(v,2) + 
				                93*m0*Measurement.power(r,3)*Measurement.power(v,2) - 25*Measurement.power(r,5)*Measurement.power(v,2) + 111*Measurement.power(r,6)*Measurement.power(v,2) - 
				                111*m0*Measurement.power(r,6)*Measurement.power(v,2) + 27*m2*Measurement.power(r,6)*Measurement.power(v,2) + 23*Measurement.power(r,8)*Measurement.power(v,2) - 
				                18*Measurement.power(r,9)*Measurement.power(v,2) + 18*m0*Measurement.power(r,9)*Measurement.power(v,2) - 27*m2*Measurement.power(r,9)*Measurement.power(v,2) - 
				                4*Measurement.power(r,11)*Measurement.power(v,2) + 6*Measurement.power(r,14)*Measurement.power(v,2) + 45*Measurement.power(r,4)*Measurement.power(v,4) - 
				                45*m0*Measurement.power(r,4)*Measurement.power(v,4) + 9*Measurement.power(r,6)*Measurement.power(v,4) - 45*Measurement.power(r,7)*Measurement.power(v,4) + 
				                45*m0*Measurement.power(r,7)*Measurement.power(v,4) - 9*Measurement.power(r,9)*Measurement.power(v,4)),3) + 
				          Measurement.power(-6750*Measurement.power(-34*r + 34*m0*r - 6*Measurement.power(r,3) + 46*Measurement.power(r,4) - 46*m0*Measurement.power(r,4) + 9*m2*Measurement.power(r,4) - 
				               6*Measurement.power(r,7) + 6*m0*Measurement.power(r,7) - 9*m2*Measurement.power(r,7) + 33*Measurement.power(r,2)*Measurement.power(v,2) - 
				               33*m0*Measurement.power(r,2)*Measurement.power(v,2) + 3*Measurement.power(r,4)*Measurement.power(v,2) - 42*Measurement.power(r,5)*Measurement.power(v,2) + 
				               42*m0*Measurement.power(r,5)*Measurement.power(v,2) + 6*Measurement.power(r,7)*Measurement.power(v,2),3) - 
				            212625*(-3*m1*Measurement.power(r,2) + 7*m1*Measurement.power(r,5) + m3*Measurement.power(r,5))*
				             (-34*r + 34*m0*r - 6*Measurement.power(r,3) + 46*Measurement.power(r,4) - 46*m0*Measurement.power(r,4) + 9*m2*Measurement.power(r,4) - 6*Measurement.power(r,7) + 
				               6*m0*Measurement.power(r,7) - 9*m2*Measurement.power(r,7) + 33*Measurement.power(r,2)*Measurement.power(v,2) - 33*m0*Measurement.power(r,2)*Measurement.power(v,2) + 
				               3*Measurement.power(r,4)*Measurement.power(v,2) - 42*Measurement.power(r,5)*Measurement.power(v,2) + 42*m0*Measurement.power(r,5)*Measurement.power(v,2) + 6*Measurement.power(r,7)*Measurement.power(v,2)
				               )*(9*m1*Measurement.power(r,3) - 20*m1*Measurement.power(r,6) - m3*Measurement.power(r,6) + 3*m1*Measurement.power(r,9) - m3*Measurement.power(r,9) - 
				               9*m1*Measurement.power(r,4)*Measurement.power(v,2) + 21*m1*Measurement.power(r,7)*Measurement.power(v,2) + 3*m3*Measurement.power(r,7)*Measurement.power(v,2)) + 
				            1913625*(2 - 2*m0 - 3*Measurement.power(r,3) + 3*m0*Measurement.power(r,3) + Measurement.power(r,5))*
				             Measurement.power(9*m1*Measurement.power(r,3) - 20*m1*Measurement.power(r,6) - m3*Measurement.power(r,6) + 3*m1*Measurement.power(r,9) - m3*Measurement.power(r,9) - 
				               9*m1*Measurement.power(r,4)*Measurement.power(v,2) + 21*m1*Measurement.power(r,7)*Measurement.power(v,2) + 3*m3*Measurement.power(r,7)*Measurement.power(v,2),2) + 
				            297675*Measurement.power(-3*m1*Measurement.power(r,2) + 7*m1*Measurement.power(r,5) + m3*Measurement.power(r,5),2)*
				             (46*Measurement.power(r,2) - 46*m0*Measurement.power(r,2) + 14*Measurement.power(r,4) - 62*Measurement.power(r,5) + 62*m0*Measurement.power(r,5) - 24*m2*Measurement.power(r,5) - 
				               10*Measurement.power(r,7) + 18*Measurement.power(r,8) - 18*m0*Measurement.power(r,8) + 34*m2*Measurement.power(r,8) + 4*Measurement.power(r,10) - 4*Measurement.power(r,11) + 
				               4*m0*Measurement.power(r,11) - 7*m2*Measurement.power(r,11) - m6*Measurement.power(r,11) - 10*Measurement.power(r,13) + 2*Measurement.power(r,14) - 
				               2*m0*Measurement.power(r,14) - 3*m2*Measurement.power(r,14) + m6*Measurement.power(r,14) + 2*Measurement.power(r,16) - 93*Measurement.power(r,3)*Measurement.power(v,2) + 
				               93*m0*Measurement.power(r,3)*Measurement.power(v,2) - 25*Measurement.power(r,5)*Measurement.power(v,2) + 111*Measurement.power(r,6)*Measurement.power(v,2) - 
				               111*m0*Measurement.power(r,6)*Measurement.power(v,2) + 27*m2*Measurement.power(r,6)*Measurement.power(v,2) + 23*Measurement.power(r,8)*Measurement.power(v,2) - 
				               18*Measurement.power(r,9)*Measurement.power(v,2) + 18*m0*Measurement.power(r,9)*Measurement.power(v,2) - 27*m2*Measurement.power(r,9)*Measurement.power(v,2) - 
				               4*Measurement.power(r,11)*Measurement.power(v,2) + 6*Measurement.power(r,14)*Measurement.power(v,2) + 45*Measurement.power(r,4)*Measurement.power(v,4) - 
				               45*m0*Measurement.power(r,4)*Measurement.power(v,4) + 9*Measurement.power(r,6)*Measurement.power(v,4) - 45*Measurement.power(r,7)*Measurement.power(v,4) + 
				               45*m0*Measurement.power(r,7)*Measurement.power(v,4) - 9*Measurement.power(r,9)*Measurement.power(v,4)) + 
				            340200*(2 - 2*m0 - 3*Measurement.power(r,3) + 3*m0*Measurement.power(r,3) + Measurement.power(r,5))*
				             (-34*r + 34*m0*r - 6*Measurement.power(r,3) + 46*Measurement.power(r,4) - 46*m0*Measurement.power(r,4) + 9*m2*Measurement.power(r,4) - 6*Measurement.power(r,7) + 
				               6*m0*Measurement.power(r,7) - 9*m2*Measurement.power(r,7) + 33*Measurement.power(r,2)*Measurement.power(v,2) - 33*m0*Measurement.power(r,2)*Measurement.power(v,2) + 
				               3*Measurement.power(r,4)*Measurement.power(v,2) - 42*Measurement.power(r,5)*Measurement.power(v,2) + 42*m0*Measurement.power(r,5)*Measurement.power(v,2) + 6*Measurement.power(r,7)*Measurement.power(v,2)
				               )*(46*Measurement.power(r,2) - 46*m0*Measurement.power(r,2) + 14*Measurement.power(r,4) - 62*Measurement.power(r,5) + 62*m0*Measurement.power(r,5) - 
				               24*m2*Measurement.power(r,5) - 10*Measurement.power(r,7) + 18*Measurement.power(r,8) - 18*m0*Measurement.power(r,8) + 34*m2*Measurement.power(r,8) + 4*Measurement.power(r,10) - 
				               4*Measurement.power(r,11) + 4*m0*Measurement.power(r,11) - 7*m2*Measurement.power(r,11) - m6*Measurement.power(r,11) - 10*Measurement.power(r,13) + 2*Measurement.power(r,14) - 
				               2*m0*Measurement.power(r,14) - 3*m2*Measurement.power(r,14) + m6*Measurement.power(r,14) + 2*Measurement.power(r,16) - 93*Measurement.power(r,3)*Measurement.power(v,2) + 
				               93*m0*Measurement.power(r,3)*Measurement.power(v,2) - 25*Measurement.power(r,5)*Measurement.power(v,2) + 111*Measurement.power(r,6)*Measurement.power(v,2) - 
				               111*m0*Measurement.power(r,6)*Measurement.power(v,2) + 27*m2*Measurement.power(r,6)*Measurement.power(v,2) + 23*Measurement.power(r,8)*Measurement.power(v,2) - 
				               18*Measurement.power(r,9)*Measurement.power(v,2) + 18*m0*Measurement.power(r,9)*Measurement.power(v,2) - 27*m2*Measurement.power(r,9)*Measurement.power(v,2) - 
				               4*Measurement.power(r,11)*Measurement.power(v,2) + 6*Measurement.power(r,14)*Measurement.power(v,2) + 45*Measurement.power(r,4)*Measurement.power(v,4) - 
				               45*m0*Measurement.power(r,4)*Measurement.power(v,4) + 9*Measurement.power(r,6)*Measurement.power(v,4) - 45*Measurement.power(r,7)*Measurement.power(v,4) + 
				               45*m0*Measurement.power(r,7)*Measurement.power(v,4) - 9*Measurement.power(r,9)*Measurement.power(v,4)),2)),0.3333333333333333)) + 
				   Measurement.power(-6750*Measurement.power(-34*r + 34*m0*r - 6*Measurement.power(r,3) + 46*Measurement.power(r,4) - 46*m0*Measurement.power(r,4) + 9*m2*Measurement.power(r,4) - 
				         6*Measurement.power(r,7) + 6*m0*Measurement.power(r,7) - 9*m2*Measurement.power(r,7) + 33*Measurement.power(r,2)*Measurement.power(v,2) - 33*m0*Measurement.power(r,2)*Measurement.power(v,2) + 
				         3*Measurement.power(r,4)*Measurement.power(v,2) - 42*Measurement.power(r,5)*Measurement.power(v,2) + 42*m0*Measurement.power(r,5)*Measurement.power(v,2) + 6*Measurement.power(r,7)*Measurement.power(v,2),3) - 
				      212625*(-3*m1*Measurement.power(r,2) + 7*m1*Measurement.power(r,5) + m3*Measurement.power(r,5))*
				       (-34*r + 34*m0*r - 6*Measurement.power(r,3) + 46*Measurement.power(r,4) - 46*m0*Measurement.power(r,4) + 9*m2*Measurement.power(r,4) - 6*Measurement.power(r,7) + 
				         6*m0*Measurement.power(r,7) - 9*m2*Measurement.power(r,7) + 33*Measurement.power(r,2)*Measurement.power(v,2) - 33*m0*Measurement.power(r,2)*Measurement.power(v,2) + 
				         3*Measurement.power(r,4)*Measurement.power(v,2) - 42*Measurement.power(r,5)*Measurement.power(v,2) + 42*m0*Measurement.power(r,5)*Measurement.power(v,2) + 6*Measurement.power(r,7)*Measurement.power(v,2))*
				       (9*m1*Measurement.power(r,3) - 20*m1*Measurement.power(r,6) - m3*Measurement.power(r,6) + 3*m1*Measurement.power(r,9) - m3*Measurement.power(r,9) - 
				         9*m1*Measurement.power(r,4)*Measurement.power(v,2) + 21*m1*Measurement.power(r,7)*Measurement.power(v,2) + 3*m3*Measurement.power(r,7)*Measurement.power(v,2)) + 
				      1913625*(2 - 2*m0 - 3*Measurement.power(r,3) + 3*m0*Measurement.power(r,3) + Measurement.power(r,5))*
				       Measurement.power(9*m1*Measurement.power(r,3) - 20*m1*Measurement.power(r,6) - m3*Measurement.power(r,6) + 3*m1*Measurement.power(r,9) - m3*Measurement.power(r,9) - 
				         9*m1*Measurement.power(r,4)*Measurement.power(v,2) + 21*m1*Measurement.power(r,7)*Measurement.power(v,2) + 3*m3*Measurement.power(r,7)*Measurement.power(v,2),2) + 
				      297675*Measurement.power(-3*m1*Measurement.power(r,2) + 7*m1*Measurement.power(r,5) + m3*Measurement.power(r,5),2)*
				       (46*Measurement.power(r,2) - 46*m0*Measurement.power(r,2) + 14*Measurement.power(r,4) - 62*Measurement.power(r,5) + 62*m0*Measurement.power(r,5) - 24*m2*Measurement.power(r,5) - 
				         10*Measurement.power(r,7) + 18*Measurement.power(r,8) - 18*m0*Measurement.power(r,8) + 34*m2*Measurement.power(r,8) + 4*Measurement.power(r,10) - 4*Measurement.power(r,11) + 
				         4*m0*Measurement.power(r,11) - 7*m2*Measurement.power(r,11) - m6*Measurement.power(r,11) - 10*Measurement.power(r,13) + 2*Measurement.power(r,14) - 2*m0*Measurement.power(r,14) - 
				         3*m2*Measurement.power(r,14) + m6*Measurement.power(r,14) + 2*Measurement.power(r,16) - 93*Measurement.power(r,3)*Measurement.power(v,2) + 93*m0*Measurement.power(r,3)*Measurement.power(v,2) - 
				         25*Measurement.power(r,5)*Measurement.power(v,2) + 111*Measurement.power(r,6)*Measurement.power(v,2) - 111*m0*Measurement.power(r,6)*Measurement.power(v,2) + 
				         27*m2*Measurement.power(r,6)*Measurement.power(v,2) + 23*Measurement.power(r,8)*Measurement.power(v,2) - 18*Measurement.power(r,9)*Measurement.power(v,2) + 
				         18*m0*Measurement.power(r,9)*Measurement.power(v,2) - 27*m2*Measurement.power(r,9)*Measurement.power(v,2) - 4*Measurement.power(r,11)*Measurement.power(v,2) + 
				         6*Measurement.power(r,14)*Measurement.power(v,2) + 45*Measurement.power(r,4)*Measurement.power(v,4) - 45*m0*Measurement.power(r,4)*Measurement.power(v,4) + 9*Measurement.power(r,6)*Measurement.power(v,4) - 
				         45*Measurement.power(r,7)*Measurement.power(v,4) + 45*m0*Measurement.power(r,7)*Measurement.power(v,4) - 9*Measurement.power(r,9)*Measurement.power(v,4)) + 
				      340200*(2 - 2*m0 - 3*Measurement.power(r,3) + 3*m0*Measurement.power(r,3) + Measurement.power(r,5))*
				       (-34*r + 34*m0*r - 6*Measurement.power(r,3) + 46*Measurement.power(r,4) - 46*m0*Measurement.power(r,4) + 9*m2*Measurement.power(r,4) - 6*Measurement.power(r,7) + 
				         6*m0*Measurement.power(r,7) - 9*m2*Measurement.power(r,7) + 33*Measurement.power(r,2)*Measurement.power(v,2) - 33*m0*Measurement.power(r,2)*Measurement.power(v,2) + 
				         3*Measurement.power(r,4)*Measurement.power(v,2) - 42*Measurement.power(r,5)*Measurement.power(v,2) + 42*m0*Measurement.power(r,5)*Measurement.power(v,2) + 6*Measurement.power(r,7)*Measurement.power(v,2))*
				       (46*Measurement.power(r,2) - 46*m0*Measurement.power(r,2) + 14*Measurement.power(r,4) - 62*Measurement.power(r,5) + 62*m0*Measurement.power(r,5) - 24*m2*Measurement.power(r,5) - 
				         10*Measurement.power(r,7) + 18*Measurement.power(r,8) - 18*m0*Measurement.power(r,8) + 34*m2*Measurement.power(r,8) + 4*Measurement.power(r,10) - 4*Measurement.power(r,11) + 
				         4*m0*Measurement.power(r,11) - 7*m2*Measurement.power(r,11) - m6*Measurement.power(r,11) - 10*Measurement.power(r,13) + 2*Measurement.power(r,14) - 2*m0*Measurement.power(r,14) - 
				         3*m2*Measurement.power(r,14) + m6*Measurement.power(r,14) + 2*Measurement.power(r,16) - 93*Measurement.power(r,3)*Measurement.power(v,2) + 93*m0*Measurement.power(r,3)*Measurement.power(v,2) - 
				         25*Measurement.power(r,5)*Measurement.power(v,2) + 111*Measurement.power(r,6)*Measurement.power(v,2) - 111*m0*Measurement.power(r,6)*Measurement.power(v,2) + 
				         27*m2*Measurement.power(r,6)*Measurement.power(v,2) + 23*Measurement.power(r,8)*Measurement.power(v,2) - 18*Measurement.power(r,9)*Measurement.power(v,2) + 
				         18*m0*Measurement.power(r,9)*Measurement.power(v,2) - 27*m2*Measurement.power(r,9)*Measurement.power(v,2) - 4*Measurement.power(r,11)*Measurement.power(v,2) + 
				         6*Measurement.power(r,14)*Measurement.power(v,2) + 45*Measurement.power(r,4)*Measurement.power(v,4) - 45*m0*Measurement.power(r,4)*Measurement.power(v,4) + 9*Measurement.power(r,6)*Measurement.power(v,4) - 
				         45*Measurement.power(r,7)*Measurement.power(v,4) + 45*m0*Measurement.power(r,7)*Measurement.power(v,4) - 9*Measurement.power(r,9)*Measurement.power(v,4)) + 
				      Sqrt(-4*Measurement.power(225*Measurement.power(-34*r + 34*m0*r - 6*Measurement.power(r,3) + 46*Measurement.power(r,4) - 46*m0*Measurement.power(r,4) + 9*m2*Measurement.power(r,4) - 
				              6*Measurement.power(r,7) + 6*m0*Measurement.power(r,7) - 9*m2*Measurement.power(r,7) + 33*Measurement.power(r,2)*Measurement.power(v,2) - 
				              33*m0*Measurement.power(r,2)*Measurement.power(v,2) + 3*Measurement.power(r,4)*Measurement.power(v,2) - 42*Measurement.power(r,5)*Measurement.power(v,2) + 
				              42*m0*Measurement.power(r,5)*Measurement.power(v,2) + 6*Measurement.power(r,7)*Measurement.power(v,2),2) + 
				           4725*(-3*m1*Measurement.power(r,2) + 7*m1*Measurement.power(r,5) + m3*Measurement.power(r,5))*
				            (9*m1*Measurement.power(r,3) - 20*m1*Measurement.power(r,6) - m3*Measurement.power(r,6) + 3*m1*Measurement.power(r,9) - m3*Measurement.power(r,9) - 
				              9*m1*Measurement.power(r,4)*Measurement.power(v,2) + 21*m1*Measurement.power(r,7)*Measurement.power(v,2) + 3*m3*Measurement.power(r,7)*Measurement.power(v,2)) + 
				           3780*(2 - 2*m0 - 3*Measurement.power(r,3) + 3*m0*Measurement.power(r,3) + Measurement.power(r,5))*
				            (46*Measurement.power(r,2) - 46*m0*Measurement.power(r,2) + 14*Measurement.power(r,4) - 62*Measurement.power(r,5) + 62*m0*Measurement.power(r,5) - 24*m2*Measurement.power(r,5) - 
				              10*Measurement.power(r,7) + 18*Measurement.power(r,8) - 18*m0*Measurement.power(r,8) + 34*m2*Measurement.power(r,8) + 4*Measurement.power(r,10) - 4*Measurement.power(r,11) + 
				              4*m0*Measurement.power(r,11) - 7*m2*Measurement.power(r,11) - m6*Measurement.power(r,11) - 10*Measurement.power(r,13) + 2*Measurement.power(r,14) - 2*m0*Measurement.power(r,14) - 
				              3*m2*Measurement.power(r,14) + m6*Measurement.power(r,14) + 2*Measurement.power(r,16) - 93*Measurement.power(r,3)*Measurement.power(v,2) + 
				              93*m0*Measurement.power(r,3)*Measurement.power(v,2) - 25*Measurement.power(r,5)*Measurement.power(v,2) + 111*Measurement.power(r,6)*Measurement.power(v,2) - 
				              111*m0*Measurement.power(r,6)*Measurement.power(v,2) + 27*m2*Measurement.power(r,6)*Measurement.power(v,2) + 23*Measurement.power(r,8)*Measurement.power(v,2) - 
				              18*Measurement.power(r,9)*Measurement.power(v,2) + 18*m0*Measurement.power(r,9)*Measurement.power(v,2) - 27*m2*Measurement.power(r,9)*Measurement.power(v,2) - 
				              4*Measurement.power(r,11)*Measurement.power(v,2) + 6*Measurement.power(r,14)*Measurement.power(v,2) + 45*Measurement.power(r,4)*Measurement.power(v,4) - 
				              45*m0*Measurement.power(r,4)*Measurement.power(v,4) + 9*Measurement.power(r,6)*Measurement.power(v,4) - 45*Measurement.power(r,7)*Measurement.power(v,4) + 
				              45*m0*Measurement.power(r,7)*Measurement.power(v,4) - 9*Measurement.power(r,9)*Measurement.power(v,4)),3) + 
				        Measurement.power(-6750*Measurement.power(-34*r + 34*m0*r - 6*Measurement.power(r,3) + 46*Measurement.power(r,4) - 46*m0*Measurement.power(r,4) + 9*m2*Measurement.power(r,4) - 
				             6*Measurement.power(r,7) + 6*m0*Measurement.power(r,7) - 9*m2*Measurement.power(r,7) + 33*Measurement.power(r,2)*Measurement.power(v,2) - 33*m0*Measurement.power(r,2)*Measurement.power(v,2) + 
				             3*Measurement.power(r,4)*Measurement.power(v,2) - 42*Measurement.power(r,5)*Measurement.power(v,2) + 42*m0*Measurement.power(r,5)*Measurement.power(v,2) + 6*Measurement.power(r,7)*Measurement.power(v,2),
				            3) - 212625*(-3*m1*Measurement.power(r,2) + 7*m1*Measurement.power(r,5) + m3*Measurement.power(r,5))*
				           (-34*r + 34*m0*r - 6*Measurement.power(r,3) + 46*Measurement.power(r,4) - 46*m0*Measurement.power(r,4) + 9*m2*Measurement.power(r,4) - 6*Measurement.power(r,7) + 
				             6*m0*Measurement.power(r,7) - 9*m2*Measurement.power(r,7) + 33*Measurement.power(r,2)*Measurement.power(v,2) - 33*m0*Measurement.power(r,2)*Measurement.power(v,2) + 
				             3*Measurement.power(r,4)*Measurement.power(v,2) - 42*Measurement.power(r,5)*Measurement.power(v,2) + 42*m0*Measurement.power(r,5)*Measurement.power(v,2) + 6*Measurement.power(r,7)*Measurement.power(v,2))*
				           (9*m1*Measurement.power(r,3) - 20*m1*Measurement.power(r,6) - m3*Measurement.power(r,6) + 3*m1*Measurement.power(r,9) - m3*Measurement.power(r,9) - 
				             9*m1*Measurement.power(r,4)*Measurement.power(v,2) + 21*m1*Measurement.power(r,7)*Measurement.power(v,2) + 3*m3*Measurement.power(r,7)*Measurement.power(v,2)) + 
				          1913625*(2 - 2*m0 - 3*Measurement.power(r,3) + 3*m0*Measurement.power(r,3) + Measurement.power(r,5))*
				           Measurement.power(9*m1*Measurement.power(r,3) - 20*m1*Measurement.power(r,6) - m3*Measurement.power(r,6) + 3*m1*Measurement.power(r,9) - m3*Measurement.power(r,9) - 
				             9*m1*Measurement.power(r,4)*Measurement.power(v,2) + 21*m1*Measurement.power(r,7)*Measurement.power(v,2) + 3*m3*Measurement.power(r,7)*Measurement.power(v,2),2) + 
				          297675*Measurement.power(-3*m1*Measurement.power(r,2) + 7*m1*Measurement.power(r,5) + m3*Measurement.power(r,5),2)*
				           (46*Measurement.power(r,2) - 46*m0*Measurement.power(r,2) + 14*Measurement.power(r,4) - 62*Measurement.power(r,5) + 62*m0*Measurement.power(r,5) - 24*m2*Measurement.power(r,5) - 
				             10*Measurement.power(r,7) + 18*Measurement.power(r,8) - 18*m0*Measurement.power(r,8) + 34*m2*Measurement.power(r,8) + 4*Measurement.power(r,10) - 4*Measurement.power(r,11) + 
				             4*m0*Measurement.power(r,11) - 7*m2*Measurement.power(r,11) - m6*Measurement.power(r,11) - 10*Measurement.power(r,13) + 2*Measurement.power(r,14) - 2*m0*Measurement.power(r,14) - 
				             3*m2*Measurement.power(r,14) + m6*Measurement.power(r,14) + 2*Measurement.power(r,16) - 93*Measurement.power(r,3)*Measurement.power(v,2) + 
				             93*m0*Measurement.power(r,3)*Measurement.power(v,2) - 25*Measurement.power(r,5)*Measurement.power(v,2) + 111*Measurement.power(r,6)*Measurement.power(v,2) - 
				             111*m0*Measurement.power(r,6)*Measurement.power(v,2) + 27*m2*Measurement.power(r,6)*Measurement.power(v,2) + 23*Measurement.power(r,8)*Measurement.power(v,2) - 
				             18*Measurement.power(r,9)*Measurement.power(v,2) + 18*m0*Measurement.power(r,9)*Measurement.power(v,2) - 27*m2*Measurement.power(r,9)*Measurement.power(v,2) - 
				             4*Measurement.power(r,11)*Measurement.power(v,2) + 6*Measurement.power(r,14)*Measurement.power(v,2) + 45*Measurement.power(r,4)*Measurement.power(v,4) - 
				             45*m0*Measurement.power(r,4)*Measurement.power(v,4) + 9*Measurement.power(r,6)*Measurement.power(v,4) - 45*Measurement.power(r,7)*Measurement.power(v,4) + 
				             45*m0*Measurement.power(r,7)*Measurement.power(v,4) - 9*Measurement.power(r,9)*Measurement.power(v,4)) + 
				          340200*(2 - 2*m0 - 3*Measurement.power(r,3) + 3*m0*Measurement.power(r,3) + Measurement.power(r,5))*
				           (-34*r + 34*m0*r - 6*Measurement.power(r,3) + 46*Measurement.power(r,4) - 46*m0*Measurement.power(r,4) + 9*m2*Measurement.power(r,4) - 6*Measurement.power(r,7) + 
				             6*m0*Measurement.power(r,7) - 9*m2*Measurement.power(r,7) + 33*Measurement.power(r,2)*Measurement.power(v,2) - 33*m0*Measurement.power(r,2)*Measurement.power(v,2) + 
				             3*Measurement.power(r,4)*Measurement.power(v,2) - 42*Measurement.power(r,5)*Measurement.power(v,2) + 42*m0*Measurement.power(r,5)*Measurement.power(v,2) + 6*Measurement.power(r,7)*Measurement.power(v,2))*
				           (46*Measurement.power(r,2) - 46*m0*Measurement.power(r,2) + 14*Measurement.power(r,4) - 62*Measurement.power(r,5) + 62*m0*Measurement.power(r,5) - 24*m2*Measurement.power(r,5) - 
				             10*Measurement.power(r,7) + 18*Measurement.power(r,8) - 18*m0*Measurement.power(r,8) + 34*m2*Measurement.power(r,8) + 4*Measurement.power(r,10) - 4*Measurement.power(r,11) + 
				             4*m0*Measurement.power(r,11) - 7*m2*Measurement.power(r,11) - m6*Measurement.power(r,11) - 10*Measurement.power(r,13) + 2*Measurement.power(r,14) - 2*m0*Measurement.power(r,14) - 
				             3*m2*Measurement.power(r,14) + m6*Measurement.power(r,14) + 2*Measurement.power(r,16) - 93*Measurement.power(r,3)*Measurement.power(v,2) + 
				             93*m0*Measurement.power(r,3)*Measurement.power(v,2) - 25*Measurement.power(r,5)*Measurement.power(v,2) + 111*Measurement.power(r,6)*Measurement.power(v,2) - 
				             111*m0*Measurement.power(r,6)*Measurement.power(v,2) + 27*m2*Measurement.power(r,6)*Measurement.power(v,2) + 23*Measurement.power(r,8)*Measurement.power(v,2) - 
				             18*Measurement.power(r,9)*Measurement.power(v,2) + 18*m0*Measurement.power(r,9)*Measurement.power(v,2) - 27*m2*Measurement.power(r,9)*Measurement.power(v,2) - 
				             4*Measurement.power(r,11)*Measurement.power(v,2) + 6*Measurement.power(r,14)*Measurement.power(v,2) + 45*Measurement.power(r,4)*Measurement.power(v,4) - 
				             45*m0*Measurement.power(r,4)*Measurement.power(v,4) + 9*Measurement.power(r,6)*Measurement.power(v,4) - 45*Measurement.power(r,7)*Measurement.power(v,4) + 
				             45*m0*Measurement.power(r,7)*Measurement.power(v,4) - 9*Measurement.power(r,9)*Measurement.power(v,4)),2)),0.3333333333333333)/
				    (945.*Measurement.power(2,0.3333333333333333)*(2 - 2*m0 - 3*Measurement.power(r,3) + 3*m0*Measurement.power(r,3) + Measurement.power(r,5))))/2. - 
				Sqrt(Measurement.power(3*m1*Measurement.power(r,2) - 7*m1*Measurement.power(r,5) - m3*Measurement.power(r,5),2)/
				    (18.*Measurement.power(2 - 2*m0 - 3*Measurement.power(r,3) + 3*m0*Measurement.power(r,3) + Measurement.power(r,5),2)) - 
				   (34*r - 34*m0*r + 6*Measurement.power(r,3) - 46*Measurement.power(r,4) + 46*m0*Measurement.power(r,4) - 9*m2*Measurement.power(r,4) + 6*Measurement.power(r,7) - 
				      6*m0*Measurement.power(r,7) + 9*m2*Measurement.power(r,7) - 33*Measurement.power(r,2)*Measurement.power(v,2) + 33*m0*Measurement.power(r,2)*Measurement.power(v,2) - 
				      3*Measurement.power(r,4)*Measurement.power(v,2) + 42*Measurement.power(r,5)*Measurement.power(v,2) - 42*m0*Measurement.power(r,5)*Measurement.power(v,2) - 6*Measurement.power(r,7)*Measurement.power(v,2))/
				    (21.*(2 - 2*m0 - 3*Measurement.power(r,3) + 3*m0*Measurement.power(r,3) + Measurement.power(r,5))) + 
				   (-34*r + 34*m0*r - 6*Measurement.power(r,3) + 46*Measurement.power(r,4) - 46*m0*Measurement.power(r,4) + 9*m2*Measurement.power(r,4) - 6*Measurement.power(r,7) + 
				      6*m0*Measurement.power(r,7) - 9*m2*Measurement.power(r,7) + 33*Measurement.power(r,2)*Measurement.power(v,2) - 33*m0*Measurement.power(r,2)*Measurement.power(v,2) + 
				      3*Measurement.power(r,4)*Measurement.power(v,2) - 42*Measurement.power(r,5)*Measurement.power(v,2) + 42*m0*Measurement.power(r,5)*Measurement.power(v,2) + 6*Measurement.power(r,7)*Measurement.power(v,2))/
				    (63.*(2 - 2*m0 - 3*Measurement.power(r,3) + 3*m0*Measurement.power(r,3) + Measurement.power(r,5))) - 
				   (Measurement.power(2,0.3333333333333333)*(225*Measurement.power(-34*r + 34*m0*r - 6*Measurement.power(r,3) + 46*Measurement.power(r,4) - 46*m0*Measurement.power(r,4) + 
				           9*m2*Measurement.power(r,4) - 6*Measurement.power(r,7) + 6*m0*Measurement.power(r,7) - 9*m2*Measurement.power(r,7) + 33*Measurement.power(r,2)*Measurement.power(v,2) - 
				           33*m0*Measurement.power(r,2)*Measurement.power(v,2) + 3*Measurement.power(r,4)*Measurement.power(v,2) - 42*Measurement.power(r,5)*Measurement.power(v,2) + 
				           42*m0*Measurement.power(r,5)*Measurement.power(v,2) + 6*Measurement.power(r,7)*Measurement.power(v,2),2) + 
				        4725*(-3*m1*Measurement.power(r,2) + 7*m1*Measurement.power(r,5) + m3*Measurement.power(r,5))*
				         (9*m1*Measurement.power(r,3) - 20*m1*Measurement.power(r,6) - m3*Measurement.power(r,6) + 3*m1*Measurement.power(r,9) - m3*Measurement.power(r,9) - 
				           9*m1*Measurement.power(r,4)*Measurement.power(v,2) + 21*m1*Measurement.power(r,7)*Measurement.power(v,2) + 3*m3*Measurement.power(r,7)*Measurement.power(v,2)) + 
				        3780*(2 - 2*m0 - 3*Measurement.power(r,3) + 3*m0*Measurement.power(r,3) + Measurement.power(r,5))*
				         (46*Measurement.power(r,2) - 46*m0*Measurement.power(r,2) + 14*Measurement.power(r,4) - 62*Measurement.power(r,5) + 62*m0*Measurement.power(r,5) - 24*m2*Measurement.power(r,5) - 
				           10*Measurement.power(r,7) + 18*Measurement.power(r,8) - 18*m0*Measurement.power(r,8) + 34*m2*Measurement.power(r,8) + 4*Measurement.power(r,10) - 4*Measurement.power(r,11) + 
				           4*m0*Measurement.power(r,11) - 7*m2*Measurement.power(r,11) - m6*Measurement.power(r,11) - 10*Measurement.power(r,13) + 2*Measurement.power(r,14) - 2*m0*Measurement.power(r,14) - 
				           3*m2*Measurement.power(r,14) + m6*Measurement.power(r,14) + 2*Measurement.power(r,16) - 93*Measurement.power(r,3)*Measurement.power(v,2) + 93*m0*Measurement.power(r,3)*Measurement.power(v,2) - 
				           25*Measurement.power(r,5)*Measurement.power(v,2) + 111*Measurement.power(r,6)*Measurement.power(v,2) - 111*m0*Measurement.power(r,6)*Measurement.power(v,2) + 
				           27*m2*Measurement.power(r,6)*Measurement.power(v,2) + 23*Measurement.power(r,8)*Measurement.power(v,2) - 18*Measurement.power(r,9)*Measurement.power(v,2) + 
				           18*m0*Measurement.power(r,9)*Measurement.power(v,2) - 27*m2*Measurement.power(r,9)*Measurement.power(v,2) - 4*Measurement.power(r,11)*Measurement.power(v,2) + 
				           6*Measurement.power(r,14)*Measurement.power(v,2) + 45*Measurement.power(r,4)*Measurement.power(v,4) - 45*m0*Measurement.power(r,4)*Measurement.power(v,4) + 9*Measurement.power(r,6)*Measurement.power(v,4) - 
				           45*Measurement.power(r,7)*Measurement.power(v,4) + 45*m0*Measurement.power(r,7)*Measurement.power(v,4) - 9*Measurement.power(r,9)*Measurement.power(v,4))))/
				    (945.*(2 - 2*m0 - 3*Measurement.power(r,3) + 3*m0*Measurement.power(r,3) + Measurement.power(r,5))*
				      Measurement.power(-6750*Measurement.power(-34*r + 34*m0*r - 6*Measurement.power(r,3) + 46*Measurement.power(r,4) - 46*m0*Measurement.power(r,4) + 9*m2*Measurement.power(r,4) - 
				           6*Measurement.power(r,7) + 6*m0*Measurement.power(r,7) - 9*m2*Measurement.power(r,7) + 33*Measurement.power(r,2)*Measurement.power(v,2) - 33*m0*Measurement.power(r,2)*Measurement.power(v,2) + 
				           3*Measurement.power(r,4)*Measurement.power(v,2) - 42*Measurement.power(r,5)*Measurement.power(v,2) + 42*m0*Measurement.power(r,5)*Measurement.power(v,2) + 6*Measurement.power(r,7)*Measurement.power(v,2),3)
				         - 212625*(-3*m1*Measurement.power(r,2) + 7*m1*Measurement.power(r,5) + m3*Measurement.power(r,5))*
				         (-34*r + 34*m0*r - 6*Measurement.power(r,3) + 46*Measurement.power(r,4) - 46*m0*Measurement.power(r,4) + 9*m2*Measurement.power(r,4) - 6*Measurement.power(r,7) + 
				           6*m0*Measurement.power(r,7) - 9*m2*Measurement.power(r,7) + 33*Measurement.power(r,2)*Measurement.power(v,2) - 33*m0*Measurement.power(r,2)*Measurement.power(v,2) + 
				           3*Measurement.power(r,4)*Measurement.power(v,2) - 42*Measurement.power(r,5)*Measurement.power(v,2) + 42*m0*Measurement.power(r,5)*Measurement.power(v,2) + 6*Measurement.power(r,7)*Measurement.power(v,2))*
				         (9*m1*Measurement.power(r,3) - 20*m1*Measurement.power(r,6) - m3*Measurement.power(r,6) + 3*m1*Measurement.power(r,9) - m3*Measurement.power(r,9) - 
				           9*m1*Measurement.power(r,4)*Measurement.power(v,2) + 21*m1*Measurement.power(r,7)*Measurement.power(v,2) + 3*m3*Measurement.power(r,7)*Measurement.power(v,2)) + 
				        1913625*(2 - 2*m0 - 3*Measurement.power(r,3) + 3*m0*Measurement.power(r,3) + Measurement.power(r,5))*
				         Measurement.power(9*m1*Measurement.power(r,3) - 20*m1*Measurement.power(r,6) - m3*Measurement.power(r,6) + 3*m1*Measurement.power(r,9) - m3*Measurement.power(r,9) - 
				           9*m1*Measurement.power(r,4)*Measurement.power(v,2) + 21*m1*Measurement.power(r,7)*Measurement.power(v,2) + 3*m3*Measurement.power(r,7)*Measurement.power(v,2),2) + 
				        297675*Measurement.power(-3*m1*Measurement.power(r,2) + 7*m1*Measurement.power(r,5) + m3*Measurement.power(r,5),2)*
				         (46*Measurement.power(r,2) - 46*m0*Measurement.power(r,2) + 14*Measurement.power(r,4) - 62*Measurement.power(r,5) + 62*m0*Measurement.power(r,5) - 24*m2*Measurement.power(r,5) - 
				           10*Measurement.power(r,7) + 18*Measurement.power(r,8) - 18*m0*Measurement.power(r,8) + 34*m2*Measurement.power(r,8) + 4*Measurement.power(r,10) - 4*Measurement.power(r,11) + 
				           4*m0*Measurement.power(r,11) - 7*m2*Measurement.power(r,11) - m6*Measurement.power(r,11) - 10*Measurement.power(r,13) + 2*Measurement.power(r,14) - 2*m0*Measurement.power(r,14) - 
				           3*m2*Measurement.power(r,14) + m6*Measurement.power(r,14) + 2*Measurement.power(r,16) - 93*Measurement.power(r,3)*Measurement.power(v,2) + 93*m0*Measurement.power(r,3)*Measurement.power(v,2) - 
				           25*Measurement.power(r,5)*Measurement.power(v,2) + 111*Measurement.power(r,6)*Measurement.power(v,2) - 111*m0*Measurement.power(r,6)*Measurement.power(v,2) + 
				           27*m2*Measurement.power(r,6)*Measurement.power(v,2) + 23*Measurement.power(r,8)*Measurement.power(v,2) - 18*Measurement.power(r,9)*Measurement.power(v,2) + 
				           18*m0*Measurement.power(r,9)*Measurement.power(v,2) - 27*m2*Measurement.power(r,9)*Measurement.power(v,2) - 4*Measurement.power(r,11)*Measurement.power(v,2) + 
				           6*Measurement.power(r,14)*Measurement.power(v,2) + 45*Measurement.power(r,4)*Measurement.power(v,4) - 45*m0*Measurement.power(r,4)*Measurement.power(v,4) + 9*Measurement.power(r,6)*Measurement.power(v,4) - 
				           45*Measurement.power(r,7)*Measurement.power(v,4) + 45*m0*Measurement.power(r,7)*Measurement.power(v,4) - 9*Measurement.power(r,9)*Measurement.power(v,4)) + 
				        340200*(2 - 2*m0 - 3*Measurement.power(r,3) + 3*m0*Measurement.power(r,3) + Measurement.power(r,5))*
				         (-34*r + 34*m0*r - 6*Measurement.power(r,3) + 46*Measurement.power(r,4) - 46*m0*Measurement.power(r,4) + 9*m2*Measurement.power(r,4) - 6*Measurement.power(r,7) + 
				           6*m0*Measurement.power(r,7) - 9*m2*Measurement.power(r,7) + 33*Measurement.power(r,2)*Measurement.power(v,2) - 33*m0*Measurement.power(r,2)*Measurement.power(v,2) + 
				           3*Measurement.power(r,4)*Measurement.power(v,2) - 42*Measurement.power(r,5)*Measurement.power(v,2) + 42*m0*Measurement.power(r,5)*Measurement.power(v,2) + 6*Measurement.power(r,7)*Measurement.power(v,2))*
				         (46*Measurement.power(r,2) - 46*m0*Measurement.power(r,2) + 14*Measurement.power(r,4) - 62*Measurement.power(r,5) + 62*m0*Measurement.power(r,5) - 24*m2*Measurement.power(r,5) - 
				           10*Measurement.power(r,7) + 18*Measurement.power(r,8) - 18*m0*Measurement.power(r,8) + 34*m2*Measurement.power(r,8) + 4*Measurement.power(r,10) - 4*Measurement.power(r,11) + 
				           4*m0*Measurement.power(r,11) - 7*m2*Measurement.power(r,11) - m6*Measurement.power(r,11) - 10*Measurement.power(r,13) + 2*Measurement.power(r,14) - 2*m0*Measurement.power(r,14) - 
				           3*m2*Measurement.power(r,14) + m6*Measurement.power(r,14) + 2*Measurement.power(r,16) - 93*Measurement.power(r,3)*Measurement.power(v,2) + 93*m0*Measurement.power(r,3)*Measurement.power(v,2) - 
				           25*Measurement.power(r,5)*Measurement.power(v,2) + 111*Measurement.power(r,6)*Measurement.power(v,2) - 111*m0*Measurement.power(r,6)*Measurement.power(v,2) + 
				           27*m2*Measurement.power(r,6)*Measurement.power(v,2) + 23*Measurement.power(r,8)*Measurement.power(v,2) - 18*Measurement.power(r,9)*Measurement.power(v,2) + 
				           18*m0*Measurement.power(r,9)*Measurement.power(v,2) - 27*m2*Measurement.power(r,9)*Measurement.power(v,2) - 4*Measurement.power(r,11)*Measurement.power(v,2) + 
				           6*Measurement.power(r,14)*Measurement.power(v,2) + 45*Measurement.power(r,4)*Measurement.power(v,4) - 45*m0*Measurement.power(r,4)*Measurement.power(v,4) + 9*Measurement.power(r,6)*Measurement.power(v,4) - 
				           45*Measurement.power(r,7)*Measurement.power(v,4) + 45*m0*Measurement.power(r,7)*Measurement.power(v,4) - 9*Measurement.power(r,9)*Measurement.power(v,4)) + 
				        Sqrt(-4*Measurement.power(225*Measurement.power(-34*r + 34*m0*r - 6*Measurement.power(r,3) + 46*Measurement.power(r,4) - 46*m0*Measurement.power(r,4) + 9*m2*Measurement.power(r,4) - 
				                6*Measurement.power(r,7) + 6*m0*Measurement.power(r,7) - 9*m2*Measurement.power(r,7) + 33*Measurement.power(r,2)*Measurement.power(v,2) - 
				                33*m0*Measurement.power(r,2)*Measurement.power(v,2) + 3*Measurement.power(r,4)*Measurement.power(v,2) - 42*Measurement.power(r,5)*Measurement.power(v,2) + 
				                42*m0*Measurement.power(r,5)*Measurement.power(v,2) + 6*Measurement.power(r,7)*Measurement.power(v,2),2) + 
				             4725*(-3*m1*Measurement.power(r,2) + 7*m1*Measurement.power(r,5) + m3*Measurement.power(r,5))*
				              (9*m1*Measurement.power(r,3) - 20*m1*Measurement.power(r,6) - m3*Measurement.power(r,6) + 3*m1*Measurement.power(r,9) - m3*Measurement.power(r,9) - 
				                9*m1*Measurement.power(r,4)*Measurement.power(v,2) + 21*m1*Measurement.power(r,7)*Measurement.power(v,2) + 3*m3*Measurement.power(r,7)*Measurement.power(v,2)) + 
				             3780*(2 - 2*m0 - 3*Measurement.power(r,3) + 3*m0*Measurement.power(r,3) + Measurement.power(r,5))*
				              (46*Measurement.power(r,2) - 46*m0*Measurement.power(r,2) + 14*Measurement.power(r,4) - 62*Measurement.power(r,5) + 62*m0*Measurement.power(r,5) - 24*m2*Measurement.power(r,5) - 
				                10*Measurement.power(r,7) + 18*Measurement.power(r,8) - 18*m0*Measurement.power(r,8) + 34*m2*Measurement.power(r,8) + 4*Measurement.power(r,10) - 4*Measurement.power(r,11) + 
				                4*m0*Measurement.power(r,11) - 7*m2*Measurement.power(r,11) - m6*Measurement.power(r,11) - 10*Measurement.power(r,13) + 2*Measurement.power(r,14) - 
				                2*m0*Measurement.power(r,14) - 3*m2*Measurement.power(r,14) + m6*Measurement.power(r,14) + 2*Measurement.power(r,16) - 93*Measurement.power(r,3)*Measurement.power(v,2) + 
				                93*m0*Measurement.power(r,3)*Measurement.power(v,2) - 25*Measurement.power(r,5)*Measurement.power(v,2) + 111*Measurement.power(r,6)*Measurement.power(v,2) - 
				                111*m0*Measurement.power(r,6)*Measurement.power(v,2) + 27*m2*Measurement.power(r,6)*Measurement.power(v,2) + 23*Measurement.power(r,8)*Measurement.power(v,2) - 
				                18*Measurement.power(r,9)*Measurement.power(v,2) + 18*m0*Measurement.power(r,9)*Measurement.power(v,2) - 27*m2*Measurement.power(r,9)*Measurement.power(v,2) - 
				                4*Measurement.power(r,11)*Measurement.power(v,2) + 6*Measurement.power(r,14)*Measurement.power(v,2) + 45*Measurement.power(r,4)*Measurement.power(v,4) - 
				                45*m0*Measurement.power(r,4)*Measurement.power(v,4) + 9*Measurement.power(r,6)*Measurement.power(v,4) - 45*Measurement.power(r,7)*Measurement.power(v,4) + 
				                45*m0*Measurement.power(r,7)*Measurement.power(v,4) - 9*Measurement.power(r,9)*Measurement.power(v,4)),3) + 
				          Measurement.power(-6750*Measurement.power(-34*r + 34*m0*r - 6*Measurement.power(r,3) + 46*Measurement.power(r,4) - 46*m0*Measurement.power(r,4) + 9*m2*Measurement.power(r,4) - 
				               6*Measurement.power(r,7) + 6*m0*Measurement.power(r,7) - 9*m2*Measurement.power(r,7) + 33*Measurement.power(r,2)*Measurement.power(v,2) - 
				               33*m0*Measurement.power(r,2)*Measurement.power(v,2) + 3*Measurement.power(r,4)*Measurement.power(v,2) - 42*Measurement.power(r,5)*Measurement.power(v,2) + 
				               42*m0*Measurement.power(r,5)*Measurement.power(v,2) + 6*Measurement.power(r,7)*Measurement.power(v,2),3) - 
				            212625*(-3*m1*Measurement.power(r,2) + 7*m1*Measurement.power(r,5) + m3*Measurement.power(r,5))*
				             (-34*r + 34*m0*r - 6*Measurement.power(r,3) + 46*Measurement.power(r,4) - 46*m0*Measurement.power(r,4) + 9*m2*Measurement.power(r,4) - 6*Measurement.power(r,7) + 
				               6*m0*Measurement.power(r,7) - 9*m2*Measurement.power(r,7) + 33*Measurement.power(r,2)*Measurement.power(v,2) - 33*m0*Measurement.power(r,2)*Measurement.power(v,2) + 
				               3*Measurement.power(r,4)*Measurement.power(v,2) - 42*Measurement.power(r,5)*Measurement.power(v,2) + 42*m0*Measurement.power(r,5)*Measurement.power(v,2) + 6*Measurement.power(r,7)*Measurement.power(v,2)
				               )*(9*m1*Measurement.power(r,3) - 20*m1*Measurement.power(r,6) - m3*Measurement.power(r,6) + 3*m1*Measurement.power(r,9) - m3*Measurement.power(r,9) - 
				               9*m1*Measurement.power(r,4)*Measurement.power(v,2) + 21*m1*Measurement.power(r,7)*Measurement.power(v,2) + 3*m3*Measurement.power(r,7)*Measurement.power(v,2)) + 
				            1913625*(2 - 2*m0 - 3*Measurement.power(r,3) + 3*m0*Measurement.power(r,3) + Measurement.power(r,5))*
				             Measurement.power(9*m1*Measurement.power(r,3) - 20*m1*Measurement.power(r,6) - m3*Measurement.power(r,6) + 3*m1*Measurement.power(r,9) - m3*Measurement.power(r,9) - 
				               9*m1*Measurement.power(r,4)*Measurement.power(v,2) + 21*m1*Measurement.power(r,7)*Measurement.power(v,2) + 3*m3*Measurement.power(r,7)*Measurement.power(v,2),2) + 
				            297675*Measurement.power(-3*m1*Measurement.power(r,2) + 7*m1*Measurement.power(r,5) + m3*Measurement.power(r,5),2)*
				             (46*Measurement.power(r,2) - 46*m0*Measurement.power(r,2) + 14*Measurement.power(r,4) - 62*Measurement.power(r,5) + 62*m0*Measurement.power(r,5) - 24*m2*Measurement.power(r,5) - 
				               10*Measurement.power(r,7) + 18*Measurement.power(r,8) - 18*m0*Measurement.power(r,8) + 34*m2*Measurement.power(r,8) + 4*Measurement.power(r,10) - 4*Measurement.power(r,11) + 
				               4*m0*Measurement.power(r,11) - 7*m2*Measurement.power(r,11) - m6*Measurement.power(r,11) - 10*Measurement.power(r,13) + 2*Measurement.power(r,14) - 
				               2*m0*Measurement.power(r,14) - 3*m2*Measurement.power(r,14) + m6*Measurement.power(r,14) + 2*Measurement.power(r,16) - 93*Measurement.power(r,3)*Measurement.power(v,2) + 
				               93*m0*Measurement.power(r,3)*Measurement.power(v,2) - 25*Measurement.power(r,5)*Measurement.power(v,2) + 111*Measurement.power(r,6)*Measurement.power(v,2) - 
				               111*m0*Measurement.power(r,6)*Measurement.power(v,2) + 27*m2*Measurement.power(r,6)*Measurement.power(v,2) + 23*Measurement.power(r,8)*Measurement.power(v,2) - 
				               18*Measurement.power(r,9)*Measurement.power(v,2) + 18*m0*Measurement.power(r,9)*Measurement.power(v,2) - 27*m2*Measurement.power(r,9)*Measurement.power(v,2) - 
				               4*Measurement.power(r,11)*Measurement.power(v,2) + 6*Measurement.power(r,14)*Measurement.power(v,2) + 45*Measurement.power(r,4)*Measurement.power(v,4) - 
				               45*m0*Measurement.power(r,4)*Measurement.power(v,4) + 9*Measurement.power(r,6)*Measurement.power(v,4) - 45*Measurement.power(r,7)*Measurement.power(v,4) + 
				               45*m0*Measurement.power(r,7)*Measurement.power(v,4) - 9*Measurement.power(r,9)*Measurement.power(v,4)) + 
				            340200*(2 - 2*m0 - 3*Measurement.power(r,3) + 3*m0*Measurement.power(r,3) + Measurement.power(r,5))*
				             (-34*r + 34*m0*r - 6*Measurement.power(r,3) + 46*Measurement.power(r,4) - 46*m0*Measurement.power(r,4) + 9*m2*Measurement.power(r,4) - 6*Measurement.power(r,7) + 
				               6*m0*Measurement.power(r,7) - 9*m2*Measurement.power(r,7) + 33*Measurement.power(r,2)*Measurement.power(v,2) - 33*m0*Measurement.power(r,2)*Measurement.power(v,2) + 
				               3*Measurement.power(r,4)*Measurement.power(v,2) - 42*Measurement.power(r,5)*Measurement.power(v,2) + 42*m0*Measurement.power(r,5)*Measurement.power(v,2) + 6*Measurement.power(r,7)*Measurement.power(v,2)
				               )*(46*Measurement.power(r,2) - 46*m0*Measurement.power(r,2) + 14*Measurement.power(r,4) - 62*Measurement.power(r,5) + 62*m0*Measurement.power(r,5) - 
				               24*m2*Measurement.power(r,5) - 10*Measurement.power(r,7) + 18*Measurement.power(r,8) - 18*m0*Measurement.power(r,8) + 34*m2*Measurement.power(r,8) + 4*Measurement.power(r,10) - 
				               4*Measurement.power(r,11) + 4*m0*Measurement.power(r,11) - 7*m2*Measurement.power(r,11) - m6*Measurement.power(r,11) - 10*Measurement.power(r,13) + 2*Measurement.power(r,14) - 
				               2*m0*Measurement.power(r,14) - 3*m2*Measurement.power(r,14) + m6*Measurement.power(r,14) + 2*Measurement.power(r,16) - 93*Measurement.power(r,3)*Measurement.power(v,2) + 
				               93*m0*Measurement.power(r,3)*Measurement.power(v,2) - 25*Measurement.power(r,5)*Measurement.power(v,2) + 111*Measurement.power(r,6)*Measurement.power(v,2) - 
				               111*m0*Measurement.power(r,6)*Measurement.power(v,2) + 27*m2*Measurement.power(r,6)*Measurement.power(v,2) + 23*Measurement.power(r,8)*Measurement.power(v,2) - 
				               18*Measurement.power(r,9)*Measurement.power(v,2) + 18*m0*Measurement.power(r,9)*Measurement.power(v,2) - 27*m2*Measurement.power(r,9)*Measurement.power(v,2) - 
				               4*Measurement.power(r,11)*Measurement.power(v,2) + 6*Measurement.power(r,14)*Measurement.power(v,2) + 45*Measurement.power(r,4)*Measurement.power(v,4) - 
				               45*m0*Measurement.power(r,4)*Measurement.power(v,4) + 9*Measurement.power(r,6)*Measurement.power(v,4) - 45*Measurement.power(r,7)*Measurement.power(v,4) + 
				               45*m0*Measurement.power(r,7)*Measurement.power(v,4) - 9*Measurement.power(r,9)*Measurement.power(v,4)),2)),0.3333333333333333)) - 
				   Measurement.power(-6750*Measurement.power(-34*r + 34*m0*r - 6*Measurement.power(r,3) + 46*Measurement.power(r,4) - 46*m0*Measurement.power(r,4) + 9*m2*Measurement.power(r,4) - 
				         6*Measurement.power(r,7) + 6*m0*Measurement.power(r,7) - 9*m2*Measurement.power(r,7) + 33*Measurement.power(r,2)*Measurement.power(v,2) - 33*m0*Measurement.power(r,2)*Measurement.power(v,2) + 
				         3*Measurement.power(r,4)*Measurement.power(v,2) - 42*Measurement.power(r,5)*Measurement.power(v,2) + 42*m0*Measurement.power(r,5)*Measurement.power(v,2) + 6*Measurement.power(r,7)*Measurement.power(v,2),3) - 
				      212625*(-3*m1*Measurement.power(r,2) + 7*m1*Measurement.power(r,5) + m3*Measurement.power(r,5))*
				       (-34*r + 34*m0*r - 6*Measurement.power(r,3) + 46*Measurement.power(r,4) - 46*m0*Measurement.power(r,4) + 9*m2*Measurement.power(r,4) - 6*Measurement.power(r,7) + 
				         6*m0*Measurement.power(r,7) - 9*m2*Measurement.power(r,7) + 33*Measurement.power(r,2)*Measurement.power(v,2) - 33*m0*Measurement.power(r,2)*Measurement.power(v,2) + 
				         3*Measurement.power(r,4)*Measurement.power(v,2) - 42*Measurement.power(r,5)*Measurement.power(v,2) + 42*m0*Measurement.power(r,5)*Measurement.power(v,2) + 6*Measurement.power(r,7)*Measurement.power(v,2))*
				       (9*m1*Measurement.power(r,3) - 20*m1*Measurement.power(r,6) - m3*Measurement.power(r,6) + 3*m1*Measurement.power(r,9) - m3*Measurement.power(r,9) - 
				         9*m1*Measurement.power(r,4)*Measurement.power(v,2) + 21*m1*Measurement.power(r,7)*Measurement.power(v,2) + 3*m3*Measurement.power(r,7)*Measurement.power(v,2)) + 
				      1913625*(2 - 2*m0 - 3*Measurement.power(r,3) + 3*m0*Measurement.power(r,3) + Measurement.power(r,5))*
				       Measurement.power(9*m1*Measurement.power(r,3) - 20*m1*Measurement.power(r,6) - m3*Measurement.power(r,6) + 3*m1*Measurement.power(r,9) - m3*Measurement.power(r,9) - 
				         9*m1*Measurement.power(r,4)*Measurement.power(v,2) + 21*m1*Measurement.power(r,7)*Measurement.power(v,2) + 3*m3*Measurement.power(r,7)*Measurement.power(v,2),2) + 
				      297675*Measurement.power(-3*m1*Measurement.power(r,2) + 7*m1*Measurement.power(r,5) + m3*Measurement.power(r,5),2)*
				       (46*Measurement.power(r,2) - 46*m0*Measurement.power(r,2) + 14*Measurement.power(r,4) - 62*Measurement.power(r,5) + 62*m0*Measurement.power(r,5) - 24*m2*Measurement.power(r,5) - 
				         10*Measurement.power(r,7) + 18*Measurement.power(r,8) - 18*m0*Measurement.power(r,8) + 34*m2*Measurement.power(r,8) + 4*Measurement.power(r,10) - 4*Measurement.power(r,11) + 
				         4*m0*Measurement.power(r,11) - 7*m2*Measurement.power(r,11) - m6*Measurement.power(r,11) - 10*Measurement.power(r,13) + 2*Measurement.power(r,14) - 2*m0*Measurement.power(r,14) - 
				         3*m2*Measurement.power(r,14) + m6*Measurement.power(r,14) + 2*Measurement.power(r,16) - 93*Measurement.power(r,3)*Measurement.power(v,2) + 93*m0*Measurement.power(r,3)*Measurement.power(v,2) - 
				         25*Measurement.power(r,5)*Measurement.power(v,2) + 111*Measurement.power(r,6)*Measurement.power(v,2) - 111*m0*Measurement.power(r,6)*Measurement.power(v,2) + 
				         27*m2*Measurement.power(r,6)*Measurement.power(v,2) + 23*Measurement.power(r,8)*Measurement.power(v,2) - 18*Measurement.power(r,9)*Measurement.power(v,2) + 
				         18*m0*Measurement.power(r,9)*Measurement.power(v,2) - 27*m2*Measurement.power(r,9)*Measurement.power(v,2) - 4*Measurement.power(r,11)*Measurement.power(v,2) + 
				         6*Measurement.power(r,14)*Measurement.power(v,2) + 45*Measurement.power(r,4)*Measurement.power(v,4) - 45*m0*Measurement.power(r,4)*Measurement.power(v,4) + 9*Measurement.power(r,6)*Measurement.power(v,4) - 
				         45*Measurement.power(r,7)*Measurement.power(v,4) + 45*m0*Measurement.power(r,7)*Measurement.power(v,4) - 9*Measurement.power(r,9)*Measurement.power(v,4)) + 
				      340200*(2 - 2*m0 - 3*Measurement.power(r,3) + 3*m0*Measurement.power(r,3) + Measurement.power(r,5))*
				       (-34*r + 34*m0*r - 6*Measurement.power(r,3) + 46*Measurement.power(r,4) - 46*m0*Measurement.power(r,4) + 9*m2*Measurement.power(r,4) - 6*Measurement.power(r,7) + 
				         6*m0*Measurement.power(r,7) - 9*m2*Measurement.power(r,7) + 33*Measurement.power(r,2)*Measurement.power(v,2) - 33*m0*Measurement.power(r,2)*Measurement.power(v,2) + 
				         3*Measurement.power(r,4)*Measurement.power(v,2) - 42*Measurement.power(r,5)*Measurement.power(v,2) + 42*m0*Measurement.power(r,5)*Measurement.power(v,2) + 6*Measurement.power(r,7)*Measurement.power(v,2))*
				       (46*Measurement.power(r,2) - 46*m0*Measurement.power(r,2) + 14*Measurement.power(r,4) - 62*Measurement.power(r,5) + 62*m0*Measurement.power(r,5) - 24*m2*Measurement.power(r,5) - 
				         10*Measurement.power(r,7) + 18*Measurement.power(r,8) - 18*m0*Measurement.power(r,8) + 34*m2*Measurement.power(r,8) + 4*Measurement.power(r,10) - 4*Measurement.power(r,11) + 
				         4*m0*Measurement.power(r,11) - 7*m2*Measurement.power(r,11) - m6*Measurement.power(r,11) - 10*Measurement.power(r,13) + 2*Measurement.power(r,14) - 2*m0*Measurement.power(r,14) - 
				         3*m2*Measurement.power(r,14) + m6*Measurement.power(r,14) + 2*Measurement.power(r,16) - 93*Measurement.power(r,3)*Measurement.power(v,2) + 93*m0*Measurement.power(r,3)*Measurement.power(v,2) - 
				         25*Measurement.power(r,5)*Measurement.power(v,2) + 111*Measurement.power(r,6)*Measurement.power(v,2) - 111*m0*Measurement.power(r,6)*Measurement.power(v,2) + 
				         27*m2*Measurement.power(r,6)*Measurement.power(v,2) + 23*Measurement.power(r,8)*Measurement.power(v,2) - 18*Measurement.power(r,9)*Measurement.power(v,2) + 
				         18*m0*Measurement.power(r,9)*Measurement.power(v,2) - 27*m2*Measurement.power(r,9)*Measurement.power(v,2) - 4*Measurement.power(r,11)*Measurement.power(v,2) + 
				         6*Measurement.power(r,14)*Measurement.power(v,2) + 45*Measurement.power(r,4)*Measurement.power(v,4) - 45*m0*Measurement.power(r,4)*Measurement.power(v,4) + 9*Measurement.power(r,6)*Measurement.power(v,4) - 
				         45*Measurement.power(r,7)*Measurement.power(v,4) + 45*m0*Measurement.power(r,7)*Measurement.power(v,4) - 9*Measurement.power(r,9)*Measurement.power(v,4)) + 
				      Sqrt(-4*Measurement.power(225*Measurement.power(-34*r + 34*m0*r - 6*Measurement.power(r,3) + 46*Measurement.power(r,4) - 46*m0*Measurement.power(r,4) + 9*m2*Measurement.power(r,4) - 
				              6*Measurement.power(r,7) + 6*m0*Measurement.power(r,7) - 9*m2*Measurement.power(r,7) + 33*Measurement.power(r,2)*Measurement.power(v,2) - 
				              33*m0*Measurement.power(r,2)*Measurement.power(v,2) + 3*Measurement.power(r,4)*Measurement.power(v,2) - 42*Measurement.power(r,5)*Measurement.power(v,2) + 
				              42*m0*Measurement.power(r,5)*Measurement.power(v,2) + 6*Measurement.power(r,7)*Measurement.power(v,2),2) + 
				           4725*(-3*m1*Measurement.power(r,2) + 7*m1*Measurement.power(r,5) + m3*Measurement.power(r,5))*
				            (9*m1*Measurement.power(r,3) - 20*m1*Measurement.power(r,6) - m3*Measurement.power(r,6) + 3*m1*Measurement.power(r,9) - m3*Measurement.power(r,9) - 
				              9*m1*Measurement.power(r,4)*Measurement.power(v,2) + 21*m1*Measurement.power(r,7)*Measurement.power(v,2) + 3*m3*Measurement.power(r,7)*Measurement.power(v,2)) + 
				           3780*(2 - 2*m0 - 3*Measurement.power(r,3) + 3*m0*Measurement.power(r,3) + Measurement.power(r,5))*
				            (46*Measurement.power(r,2) - 46*m0*Measurement.power(r,2) + 14*Measurement.power(r,4) - 62*Measurement.power(r,5) + 62*m0*Measurement.power(r,5) - 24*m2*Measurement.power(r,5) - 
				              10*Measurement.power(r,7) + 18*Measurement.power(r,8) - 18*m0*Measurement.power(r,8) + 34*m2*Measurement.power(r,8) + 4*Measurement.power(r,10) - 4*Measurement.power(r,11) + 
				              4*m0*Measurement.power(r,11) - 7*m2*Measurement.power(r,11) - m6*Measurement.power(r,11) - 10*Measurement.power(r,13) + 2*Measurement.power(r,14) - 2*m0*Measurement.power(r,14) - 
				              3*m2*Measurement.power(r,14) + m6*Measurement.power(r,14) + 2*Measurement.power(r,16) - 93*Measurement.power(r,3)*Measurement.power(v,2) + 
				              93*m0*Measurement.power(r,3)*Measurement.power(v,2) - 25*Measurement.power(r,5)*Measurement.power(v,2) + 111*Measurement.power(r,6)*Measurement.power(v,2) - 
				              111*m0*Measurement.power(r,6)*Measurement.power(v,2) + 27*m2*Measurement.power(r,6)*Measurement.power(v,2) + 23*Measurement.power(r,8)*Measurement.power(v,2) - 
				              18*Measurement.power(r,9)*Measurement.power(v,2) + 18*m0*Measurement.power(r,9)*Measurement.power(v,2) - 27*m2*Measurement.power(r,9)*Measurement.power(v,2) - 
				              4*Measurement.power(r,11)*Measurement.power(v,2) + 6*Measurement.power(r,14)*Measurement.power(v,2) + 45*Measurement.power(r,4)*Measurement.power(v,4) - 
				              45*m0*Measurement.power(r,4)*Measurement.power(v,4) + 9*Measurement.power(r,6)*Measurement.power(v,4) - 45*Measurement.power(r,7)*Measurement.power(v,4) + 
				              45*m0*Measurement.power(r,7)*Measurement.power(v,4) - 9*Measurement.power(r,9)*Measurement.power(v,4)),3) + 
				        Measurement.power(-6750*Measurement.power(-34*r + 34*m0*r - 6*Measurement.power(r,3) + 46*Measurement.power(r,4) - 46*m0*Measurement.power(r,4) + 9*m2*Measurement.power(r,4) - 
				             6*Measurement.power(r,7) + 6*m0*Measurement.power(r,7) - 9*m2*Measurement.power(r,7) + 33*Measurement.power(r,2)*Measurement.power(v,2) - 33*m0*Measurement.power(r,2)*Measurement.power(v,2) + 
				             3*Measurement.power(r,4)*Measurement.power(v,2) - 42*Measurement.power(r,5)*Measurement.power(v,2) + 42*m0*Measurement.power(r,5)*Measurement.power(v,2) + 6*Measurement.power(r,7)*Measurement.power(v,2),
				            3) - 212625*(-3*m1*Measurement.power(r,2) + 7*m1*Measurement.power(r,5) + m3*Measurement.power(r,5))*
				           (-34*r + 34*m0*r - 6*Measurement.power(r,3) + 46*Measurement.power(r,4) - 46*m0*Measurement.power(r,4) + 9*m2*Measurement.power(r,4) - 6*Measurement.power(r,7) + 
				             6*m0*Measurement.power(r,7) - 9*m2*Measurement.power(r,7) + 33*Measurement.power(r,2)*Measurement.power(v,2) - 33*m0*Measurement.power(r,2)*Measurement.power(v,2) + 
				             3*Measurement.power(r,4)*Measurement.power(v,2) - 42*Measurement.power(r,5)*Measurement.power(v,2) + 42*m0*Measurement.power(r,5)*Measurement.power(v,2) + 6*Measurement.power(r,7)*Measurement.power(v,2))*
				           (9*m1*Measurement.power(r,3) - 20*m1*Measurement.power(r,6) - m3*Measurement.power(r,6) + 3*m1*Measurement.power(r,9) - m3*Measurement.power(r,9) - 
				             9*m1*Measurement.power(r,4)*Measurement.power(v,2) + 21*m1*Measurement.power(r,7)*Measurement.power(v,2) + 3*m3*Measurement.power(r,7)*Measurement.power(v,2)) + 
				          1913625*(2 - 2*m0 - 3*Measurement.power(r,3) + 3*m0*Measurement.power(r,3) + Measurement.power(r,5))*
				           Measurement.power(9*m1*Measurement.power(r,3) - 20*m1*Measurement.power(r,6) - m3*Measurement.power(r,6) + 3*m1*Measurement.power(r,9) - m3*Measurement.power(r,9) - 
				             9*m1*Measurement.power(r,4)*Measurement.power(v,2) + 21*m1*Measurement.power(r,7)*Measurement.power(v,2) + 3*m3*Measurement.power(r,7)*Measurement.power(v,2),2) + 
				          297675*Measurement.power(-3*m1*Measurement.power(r,2) + 7*m1*Measurement.power(r,5) + m3*Measurement.power(r,5),2)*
				           (46*Measurement.power(r,2) - 46*m0*Measurement.power(r,2) + 14*Measurement.power(r,4) - 62*Measurement.power(r,5) + 62*m0*Measurement.power(r,5) - 24*m2*Measurement.power(r,5) - 
				             10*Measurement.power(r,7) + 18*Measurement.power(r,8) - 18*m0*Measurement.power(r,8) + 34*m2*Measurement.power(r,8) + 4*Measurement.power(r,10) - 4*Measurement.power(r,11) + 
				             4*m0*Measurement.power(r,11) - 7*m2*Measurement.power(r,11) - m6*Measurement.power(r,11) - 10*Measurement.power(r,13) + 2*Measurement.power(r,14) - 2*m0*Measurement.power(r,14) - 
				             3*m2*Measurement.power(r,14) + m6*Measurement.power(r,14) + 2*Measurement.power(r,16) - 93*Measurement.power(r,3)*Measurement.power(v,2) + 
				             93*m0*Measurement.power(r,3)*Measurement.power(v,2) - 25*Measurement.power(r,5)*Measurement.power(v,2) + 111*Measurement.power(r,6)*Measurement.power(v,2) - 
				             111*m0*Measurement.power(r,6)*Measurement.power(v,2) + 27*m2*Measurement.power(r,6)*Measurement.power(v,2) + 23*Measurement.power(r,8)*Measurement.power(v,2) - 
				             18*Measurement.power(r,9)*Measurement.power(v,2) + 18*m0*Measurement.power(r,9)*Measurement.power(v,2) - 27*m2*Measurement.power(r,9)*Measurement.power(v,2) - 
				             4*Measurement.power(r,11)*Measurement.power(v,2) + 6*Measurement.power(r,14)*Measurement.power(v,2) + 45*Measurement.power(r,4)*Measurement.power(v,4) - 
				             45*m0*Measurement.power(r,4)*Measurement.power(v,4) + 9*Measurement.power(r,6)*Measurement.power(v,4) - 45*Measurement.power(r,7)*Measurement.power(v,4) + 
				             45*m0*Measurement.power(r,7)*Measurement.power(v,4) - 9*Measurement.power(r,9)*Measurement.power(v,4)) + 
				          340200*(2 - 2*m0 - 3*Measurement.power(r,3) + 3*m0*Measurement.power(r,3) + Measurement.power(r,5))*
				           (-34*r + 34*m0*r - 6*Measurement.power(r,3) + 46*Measurement.power(r,4) - 46*m0*Measurement.power(r,4) + 9*m2*Measurement.power(r,4) - 6*Measurement.power(r,7) + 
				             6*m0*Measurement.power(r,7) - 9*m2*Measurement.power(r,7) + 33*Measurement.power(r,2)*Measurement.power(v,2) - 33*m0*Measurement.power(r,2)*Measurement.power(v,2) + 
				             3*Measurement.power(r,4)*Measurement.power(v,2) - 42*Measurement.power(r,5)*Measurement.power(v,2) + 42*m0*Measurement.power(r,5)*Measurement.power(v,2) + 6*Measurement.power(r,7)*Measurement.power(v,2))*
				           (46*Measurement.power(r,2) - 46*m0*Measurement.power(r,2) + 14*Measurement.power(r,4) - 62*Measurement.power(r,5) + 62*m0*Measurement.power(r,5) - 24*m2*Measurement.power(r,5) - 
				             10*Measurement.power(r,7) + 18*Measurement.power(r,8) - 18*m0*Measurement.power(r,8) + 34*m2*Measurement.power(r,8) + 4*Measurement.power(r,10) - 4*Measurement.power(r,11) + 
				             4*m0*Measurement.power(r,11) - 7*m2*Measurement.power(r,11) - m6*Measurement.power(r,11) - 10*Measurement.power(r,13) + 2*Measurement.power(r,14) - 2*m0*Measurement.power(r,14) - 
				             3*m2*Measurement.power(r,14) + m6*Measurement.power(r,14) + 2*Measurement.power(r,16) - 93*Measurement.power(r,3)*Measurement.power(v,2) + 
				             93*m0*Measurement.power(r,3)*Measurement.power(v,2) - 25*Measurement.power(r,5)*Measurement.power(v,2) + 111*Measurement.power(r,6)*Measurement.power(v,2) - 
				             111*m0*Measurement.power(r,6)*Measurement.power(v,2) + 27*m2*Measurement.power(r,6)*Measurement.power(v,2) + 23*Measurement.power(r,8)*Measurement.power(v,2) - 
				             18*Measurement.power(r,9)*Measurement.power(v,2) + 18*m0*Measurement.power(r,9)*Measurement.power(v,2) - 27*m2*Measurement.power(r,9)*Measurement.power(v,2) - 
				             4*Measurement.power(r,11)*Measurement.power(v,2) + 6*Measurement.power(r,14)*Measurement.power(v,2) + 45*Measurement.power(r,4)*Measurement.power(v,4) - 
				             45*m0*Measurement.power(r,4)*Measurement.power(v,4) + 9*Measurement.power(r,6)*Measurement.power(v,4) - 45*Measurement.power(r,7)*Measurement.power(v,4) + 
				             45*m0*Measurement.power(r,7)*Measurement.power(v,4) - 9*Measurement.power(r,9)*Measurement.power(v,4)),2)),0.3333333333333333)/
				    (945.*Measurement.power(2,0.3333333333333333)*(2 - 2*m0 - 3*Measurement.power(r,3) + 3*m0*Measurement.power(r,3) + Measurement.power(r,5))) - 
				   (-Measurement.power(3*m1*Measurement.power(r,2) - 7*m1*Measurement.power(r,5) - m3*Measurement.power(r,5),3)/
				       (27.*Measurement.power(2 - 2*m0 - 3*Measurement.power(r,3) + 3*m0*Measurement.power(r,3) + Measurement.power(r,5),3)) + 
				      (4*(3*m1*Measurement.power(r,2) - 7*m1*Measurement.power(r,5) - m3*Measurement.power(r,5))*
				         (34*r - 34*m0*r + 6*Measurement.power(r,3) - 46*Measurement.power(r,4) + 46*m0*Measurement.power(r,4) - 9*m2*Measurement.power(r,4) + 6*Measurement.power(r,7) - 
				           6*m0*Measurement.power(r,7) + 9*m2*Measurement.power(r,7) - 33*Measurement.power(r,2)*Measurement.power(v,2) + 33*m0*Measurement.power(r,2)*Measurement.power(v,2) - 
				           3*Measurement.power(r,4)*Measurement.power(v,2) + 42*Measurement.power(r,5)*Measurement.power(v,2) - 42*m0*Measurement.power(r,5)*Measurement.power(v,2) - 6*Measurement.power(r,7)*Measurement.power(v,2)))/
				       (63.*Measurement.power(2 - 2*m0 - 3*Measurement.power(r,3) + 3*m0*Measurement.power(r,3) + Measurement.power(r,5),2)) - 
				      (8*(9*m1*Measurement.power(r,3) - 20*m1*Measurement.power(r,6) - m3*Measurement.power(r,6) + 3*m1*Measurement.power(r,9) - m3*Measurement.power(r,9) - 
				           9*m1*Measurement.power(r,4)*Measurement.power(v,2) + 21*m1*Measurement.power(r,7)*Measurement.power(v,2) + 3*m3*Measurement.power(r,7)*Measurement.power(v,2)))/
				       (21.*(2 - 2*m0 - 3*Measurement.power(r,3) + 3*m0*Measurement.power(r,3) + Measurement.power(r,5))))/
				    (4.*Sqrt(Measurement.power(3*m1*Measurement.power(r,2) - 7*m1*Measurement.power(r,5) - m3*Measurement.power(r,5),2)/
				         (36.*Measurement.power(2 - 2*m0 - 3*Measurement.power(r,3) + 3*m0*Measurement.power(r,3) + Measurement.power(r,5),2)) - 
				        (34*r - 34*m0*r + 6*Measurement.power(r,3) - 46*Measurement.power(r,4) + 46*m0*Measurement.power(r,4) - 9*m2*Measurement.power(r,4) + 6*Measurement.power(r,7) - 
				           6*m0*Measurement.power(r,7) + 9*m2*Measurement.power(r,7) - 33*Measurement.power(r,2)*Measurement.power(v,2) + 33*m0*Measurement.power(r,2)*Measurement.power(v,2) - 
				           3*Measurement.power(r,4)*Measurement.power(v,2) + 42*Measurement.power(r,5)*Measurement.power(v,2) - 42*m0*Measurement.power(r,5)*Measurement.power(v,2) - 6*Measurement.power(r,7)*Measurement.power(v,2))/
				         (21.*(2 - 2*m0 - 3*Measurement.power(r,3) + 3*m0*Measurement.power(r,3) + Measurement.power(r,5))) - 
				        (-34*r + 34*m0*r - 6*Measurement.power(r,3) + 46*Measurement.power(r,4) - 46*m0*Measurement.power(r,4) + 9*m2*Measurement.power(r,4) - 6*Measurement.power(r,7) + 
				           6*m0*Measurement.power(r,7) - 9*m2*Measurement.power(r,7) + 33*Measurement.power(r,2)*Measurement.power(v,2) - 33*m0*Measurement.power(r,2)*Measurement.power(v,2) + 
				           3*Measurement.power(r,4)*Measurement.power(v,2) - 42*Measurement.power(r,5)*Measurement.power(v,2) + 42*m0*Measurement.power(r,5)*Measurement.power(v,2) + 6*Measurement.power(r,7)*Measurement.power(v,2))/
				         (63.*(2 - 2*m0 - 3*Measurement.power(r,3) + 3*m0*Measurement.power(r,3) + Measurement.power(r,5))) + 
				        (Measurement.power(2,0.3333333333333333)*(225*Measurement.power(-34*r + 34*m0*r - 6*Measurement.power(r,3) + 46*Measurement.power(r,4) - 46*m0*Measurement.power(r,4) + 
				                9*m2*Measurement.power(r,4) - 6*Measurement.power(r,7) + 6*m0*Measurement.power(r,7) - 9*m2*Measurement.power(r,7) + 33*Measurement.power(r,2)*Measurement.power(v,2) - 
				                33*m0*Measurement.power(r,2)*Measurement.power(v,2) + 3*Measurement.power(r,4)*Measurement.power(v,2) - 42*Measurement.power(r,5)*Measurement.power(v,2) + 
				                42*m0*Measurement.power(r,5)*Measurement.power(v,2) + 6*Measurement.power(r,7)*Measurement.power(v,2),2) + 
				             4725*(-3*m1*Measurement.power(r,2) + 7*m1*Measurement.power(r,5) + m3*Measurement.power(r,5))*
				              (9*m1*Measurement.power(r,3) - 20*m1*Measurement.power(r,6) - m3*Measurement.power(r,6) + 3*m1*Measurement.power(r,9) - m3*Measurement.power(r,9) - 
				                9*m1*Measurement.power(r,4)*Measurement.power(v,2) + 21*m1*Measurement.power(r,7)*Measurement.power(v,2) + 3*m3*Measurement.power(r,7)*Measurement.power(v,2)) + 
				             3780*(2 - 2*m0 - 3*Measurement.power(r,3) + 3*m0*Measurement.power(r,3) + Measurement.power(r,5))*
				              (46*Measurement.power(r,2) - 46*m0*Measurement.power(r,2) + 14*Measurement.power(r,4) - 62*Measurement.power(r,5) + 62*m0*Measurement.power(r,5) - 24*m2*Measurement.power(r,5) - 
				                10*Measurement.power(r,7) + 18*Measurement.power(r,8) - 18*m0*Measurement.power(r,8) + 34*m2*Measurement.power(r,8) + 4*Measurement.power(r,10) - 4*Measurement.power(r,11) + 
				                4*m0*Measurement.power(r,11) - 7*m2*Measurement.power(r,11) - m6*Measurement.power(r,11) - 10*Measurement.power(r,13) + 2*Measurement.power(r,14) - 
				                2*m0*Measurement.power(r,14) - 3*m2*Measurement.power(r,14) + m6*Measurement.power(r,14) + 2*Measurement.power(r,16) - 93*Measurement.power(r,3)*Measurement.power(v,2) + 
				                93*m0*Measurement.power(r,3)*Measurement.power(v,2) - 25*Measurement.power(r,5)*Measurement.power(v,2) + 111*Measurement.power(r,6)*Measurement.power(v,2) - 
				                111*m0*Measurement.power(r,6)*Measurement.power(v,2) + 27*m2*Measurement.power(r,6)*Measurement.power(v,2) + 23*Measurement.power(r,8)*Measurement.power(v,2) - 
				                18*Measurement.power(r,9)*Measurement.power(v,2) + 18*m0*Measurement.power(r,9)*Measurement.power(v,2) - 27*m2*Measurement.power(r,9)*Measurement.power(v,2) - 
				                4*Measurement.power(r,11)*Measurement.power(v,2) + 6*Measurement.power(r,14)*Measurement.power(v,2) + 45*Measurement.power(r,4)*Measurement.power(v,4) - 
				                45*m0*Measurement.power(r,4)*Measurement.power(v,4) + 9*Measurement.power(r,6)*Measurement.power(v,4) - 45*Measurement.power(r,7)*Measurement.power(v,4) + 
				                45*m0*Measurement.power(r,7)*Measurement.power(v,4) - 9*Measurement.power(r,9)*Measurement.power(v,4))))/
				         (945.*(2 - 2*m0 - 3*Measurement.power(r,3) + 3*m0*Measurement.power(r,3) + Measurement.power(r,5))*
				           Measurement.power(-6750*Measurement.power(-34*r + 34*m0*r - 6*Measurement.power(r,3) + 46*Measurement.power(r,4) - 46*m0*Measurement.power(r,4) + 9*m2*Measurement.power(r,4) - 
				                6*Measurement.power(r,7) + 6*m0*Measurement.power(r,7) - 9*m2*Measurement.power(r,7) + 33*Measurement.power(r,2)*Measurement.power(v,2) - 
				                33*m0*Measurement.power(r,2)*Measurement.power(v,2) + 3*Measurement.power(r,4)*Measurement.power(v,2) - 42*Measurement.power(r,5)*Measurement.power(v,2) + 
				                42*m0*Measurement.power(r,5)*Measurement.power(v,2) + 6*Measurement.power(r,7)*Measurement.power(v,2),3) - 
				             212625*(-3*m1*Measurement.power(r,2) + 7*m1*Measurement.power(r,5) + m3*Measurement.power(r,5))*
				              (-34*r + 34*m0*r - 6*Measurement.power(r,3) + 46*Measurement.power(r,4) - 46*m0*Measurement.power(r,4) + 9*m2*Measurement.power(r,4) - 6*Measurement.power(r,7) + 
				                6*m0*Measurement.power(r,7) - 9*m2*Measurement.power(r,7) + 33*Measurement.power(r,2)*Measurement.power(v,2) - 33*m0*Measurement.power(r,2)*Measurement.power(v,2) + 
				                3*Measurement.power(r,4)*Measurement.power(v,2) - 42*Measurement.power(r,5)*Measurement.power(v,2) + 42*m0*Measurement.power(r,5)*Measurement.power(v,2) + 
				                6*Measurement.power(r,7)*Measurement.power(v,2))*(9*m1*Measurement.power(r,3) - 20*m1*Measurement.power(r,6) - m3*Measurement.power(r,6) + 3*m1*Measurement.power(r,9) - 
				                m3*Measurement.power(r,9) - 9*m1*Measurement.power(r,4)*Measurement.power(v,2) + 21*m1*Measurement.power(r,7)*Measurement.power(v,2) + 3*m3*Measurement.power(r,7)*Measurement.power(v,2)) + 
				             1913625*(2 - 2*m0 - 3*Measurement.power(r,3) + 3*m0*Measurement.power(r,3) + Measurement.power(r,5))*
				              Measurement.power(9*m1*Measurement.power(r,3) - 20*m1*Measurement.power(r,6) - m3*Measurement.power(r,6) + 3*m1*Measurement.power(r,9) - m3*Measurement.power(r,9) - 
				                9*m1*Measurement.power(r,4)*Measurement.power(v,2) + 21*m1*Measurement.power(r,7)*Measurement.power(v,2) + 3*m3*Measurement.power(r,7)*Measurement.power(v,2),2) + 
				             297675*Measurement.power(-3*m1*Measurement.power(r,2) + 7*m1*Measurement.power(r,5) + m3*Measurement.power(r,5),2)*
				              (46*Measurement.power(r,2) - 46*m0*Measurement.power(r,2) + 14*Measurement.power(r,4) - 62*Measurement.power(r,5) + 62*m0*Measurement.power(r,5) - 24*m2*Measurement.power(r,5) - 
				                10*Measurement.power(r,7) + 18*Measurement.power(r,8) - 18*m0*Measurement.power(r,8) + 34*m2*Measurement.power(r,8) + 4*Measurement.power(r,10) - 4*Measurement.power(r,11) + 
				                4*m0*Measurement.power(r,11) - 7*m2*Measurement.power(r,11) - m6*Measurement.power(r,11) - 10*Measurement.power(r,13) + 2*Measurement.power(r,14) - 
				                2*m0*Measurement.power(r,14) - 3*m2*Measurement.power(r,14) + m6*Measurement.power(r,14) + 2*Measurement.power(r,16) - 93*Measurement.power(r,3)*Measurement.power(v,2) + 
				                93*m0*Measurement.power(r,3)*Measurement.power(v,2) - 25*Measurement.power(r,5)*Measurement.power(v,2) + 111*Measurement.power(r,6)*Measurement.power(v,2) - 
				                111*m0*Measurement.power(r,6)*Measurement.power(v,2) + 27*m2*Measurement.power(r,6)*Measurement.power(v,2) + 23*Measurement.power(r,8)*Measurement.power(v,2) - 
				                18*Measurement.power(r,9)*Measurement.power(v,2) + 18*m0*Measurement.power(r,9)*Measurement.power(v,2) - 27*m2*Measurement.power(r,9)*Measurement.power(v,2) - 
				                4*Measurement.power(r,11)*Measurement.power(v,2) + 6*Measurement.power(r,14)*Measurement.power(v,2) + 45*Measurement.power(r,4)*Measurement.power(v,4) - 
				                45*m0*Measurement.power(r,4)*Measurement.power(v,4) + 9*Measurement.power(r,6)*Measurement.power(v,4) - 45*Measurement.power(r,7)*Measurement.power(v,4) + 
				                45*m0*Measurement.power(r,7)*Measurement.power(v,4) - 9*Measurement.power(r,9)*Measurement.power(v,4)) + 
				             340200*(2 - 2*m0 - 3*Measurement.power(r,3) + 3*m0*Measurement.power(r,3) + Measurement.power(r,5))*
				              (-34*r + 34*m0*r - 6*Measurement.power(r,3) + 46*Measurement.power(r,4) - 46*m0*Measurement.power(r,4) + 9*m2*Measurement.power(r,4) - 6*Measurement.power(r,7) + 
				                6*m0*Measurement.power(r,7) - 9*m2*Measurement.power(r,7) + 33*Measurement.power(r,2)*Measurement.power(v,2) - 33*m0*Measurement.power(r,2)*Measurement.power(v,2) + 
				                3*Measurement.power(r,4)*Measurement.power(v,2) - 42*Measurement.power(r,5)*Measurement.power(v,2) + 42*m0*Measurement.power(r,5)*Measurement.power(v,2) + 
				                6*Measurement.power(r,7)*Measurement.power(v,2))*(46*Measurement.power(r,2) - 46*m0*Measurement.power(r,2) + 14*Measurement.power(r,4) - 62*Measurement.power(r,5) + 
				                62*m0*Measurement.power(r,5) - 24*m2*Measurement.power(r,5) - 10*Measurement.power(r,7) + 18*Measurement.power(r,8) - 18*m0*Measurement.power(r,8) + 
				                34*m2*Measurement.power(r,8) + 4*Measurement.power(r,10) - 4*Measurement.power(r,11) + 4*m0*Measurement.power(r,11) - 7*m2*Measurement.power(r,11) - 
				                m6*Measurement.power(r,11) - 10*Measurement.power(r,13) + 2*Measurement.power(r,14) - 2*m0*Measurement.power(r,14) - 3*m2*Measurement.power(r,14) + m6*Measurement.power(r,14) + 
				                2*Measurement.power(r,16) - 93*Measurement.power(r,3)*Measurement.power(v,2) + 93*m0*Measurement.power(r,3)*Measurement.power(v,2) - 25*Measurement.power(r,5)*Measurement.power(v,2) + 
				                111*Measurement.power(r,6)*Measurement.power(v,2) - 111*m0*Measurement.power(r,6)*Measurement.power(v,2) + 27*m2*Measurement.power(r,6)*Measurement.power(v,2) + 
				                23*Measurement.power(r,8)*Measurement.power(v,2) - 18*Measurement.power(r,9)*Measurement.power(v,2) + 18*m0*Measurement.power(r,9)*Measurement.power(v,2) - 
				                27*m2*Measurement.power(r,9)*Measurement.power(v,2) - 4*Measurement.power(r,11)*Measurement.power(v,2) + 6*Measurement.power(r,14)*Measurement.power(v,2) + 
				                45*Measurement.power(r,4)*Measurement.power(v,4) - 45*m0*Measurement.power(r,4)*Measurement.power(v,4) + 9*Measurement.power(r,6)*Measurement.power(v,4) - 
				                45*Measurement.power(r,7)*Measurement.power(v,4) + 45*m0*Measurement.power(r,7)*Measurement.power(v,4) - 9*Measurement.power(r,9)*Measurement.power(v,4)) + 
				             Sqrt(-4*Measurement.power(225*Measurement.power(-34*r + 34*m0*r - 6*Measurement.power(r,3) + 46*Measurement.power(r,4) - 46*m0*Measurement.power(r,4) + 
				                     9*m2*Measurement.power(r,4) - 6*Measurement.power(r,7) + 6*m0*Measurement.power(r,7) - 9*m2*Measurement.power(r,7) + 33*Measurement.power(r,2)*Measurement.power(v,2) - 
				                     33*m0*Measurement.power(r,2)*Measurement.power(v,2) + 3*Measurement.power(r,4)*Measurement.power(v,2) - 42*Measurement.power(r,5)*Measurement.power(v,2) + 
				                     42*m0*Measurement.power(r,5)*Measurement.power(v,2) + 6*Measurement.power(r,7)*Measurement.power(v,2),2) + 
				                  4725*(-3*m1*Measurement.power(r,2) + 7*m1*Measurement.power(r,5) + m3*Measurement.power(r,5))*
				                   (9*m1*Measurement.power(r,3) - 20*m1*Measurement.power(r,6) - m3*Measurement.power(r,6) + 3*m1*Measurement.power(r,9) - m3*Measurement.power(r,9) - 
				                     9*m1*Measurement.power(r,4)*Measurement.power(v,2) + 21*m1*Measurement.power(r,7)*Measurement.power(v,2) + 3*m3*Measurement.power(r,7)*Measurement.power(v,2)) + 
				                  3780*(2 - 2*m0 - 3*Measurement.power(r,3) + 3*m0*Measurement.power(r,3) + Measurement.power(r,5))*
				                   (46*Measurement.power(r,2) - 46*m0*Measurement.power(r,2) + 14*Measurement.power(r,4) - 62*Measurement.power(r,5) + 62*m0*Measurement.power(r,5) - 
				                     24*m2*Measurement.power(r,5) - 10*Measurement.power(r,7) + 18*Measurement.power(r,8) - 18*m0*Measurement.power(r,8) + 34*m2*Measurement.power(r,8) + 
				                     4*Measurement.power(r,10) - 4*Measurement.power(r,11) + 4*m0*Measurement.power(r,11) - 7*m2*Measurement.power(r,11) - m6*Measurement.power(r,11) - 
				                     10*Measurement.power(r,13) + 2*Measurement.power(r,14) - 2*m0*Measurement.power(r,14) - 3*m2*Measurement.power(r,14) + m6*Measurement.power(r,14) + 
				                     2*Measurement.power(r,16) - 93*Measurement.power(r,3)*Measurement.power(v,2) + 93*m0*Measurement.power(r,3)*Measurement.power(v,2) - 25*Measurement.power(r,5)*Measurement.power(v,2) + 
				                     111*Measurement.power(r,6)*Measurement.power(v,2) - 111*m0*Measurement.power(r,6)*Measurement.power(v,2) + 27*m2*Measurement.power(r,6)*Measurement.power(v,2) + 
				                     23*Measurement.power(r,8)*Measurement.power(v,2) - 18*Measurement.power(r,9)*Measurement.power(v,2) + 18*m0*Measurement.power(r,9)*Measurement.power(v,2) - 
				                     27*m2*Measurement.power(r,9)*Measurement.power(v,2) - 4*Measurement.power(r,11)*Measurement.power(v,2) + 6*Measurement.power(r,14)*Measurement.power(v,2) + 
				                     45*Measurement.power(r,4)*Measurement.power(v,4) - 45*m0*Measurement.power(r,4)*Measurement.power(v,4) + 9*Measurement.power(r,6)*Measurement.power(v,4) - 
				                     45*Measurement.power(r,7)*Measurement.power(v,4) + 45*m0*Measurement.power(r,7)*Measurement.power(v,4) - 9*Measurement.power(r,9)*Measurement.power(v,4)),3) + 
				               Measurement.power(-6750*Measurement.power(-34*r + 34*m0*r - 6*Measurement.power(r,3) + 46*Measurement.power(r,4) - 46*m0*Measurement.power(r,4) + 9*m2*Measurement.power(r,4) - 
				                    6*Measurement.power(r,7) + 6*m0*Measurement.power(r,7) - 9*m2*Measurement.power(r,7) + 33*Measurement.power(r,2)*Measurement.power(v,2) - 
				                    33*m0*Measurement.power(r,2)*Measurement.power(v,2) + 3*Measurement.power(r,4)*Measurement.power(v,2) - 42*Measurement.power(r,5)*Measurement.power(v,2) + 
				                    42*m0*Measurement.power(r,5)*Measurement.power(v,2) + 6*Measurement.power(r,7)*Measurement.power(v,2),3) - 
				                 212625*(-3*m1*Measurement.power(r,2) + 7*m1*Measurement.power(r,5) + m3*Measurement.power(r,5))*
				                  (-34*r + 34*m0*r - 6*Measurement.power(r,3) + 46*Measurement.power(r,4) - 46*m0*Measurement.power(r,4) + 9*m2*Measurement.power(r,4) - 6*Measurement.power(r,7) + 
				                    6*m0*Measurement.power(r,7) - 9*m2*Measurement.power(r,7) + 33*Measurement.power(r,2)*Measurement.power(v,2) - 33*m0*Measurement.power(r,2)*Measurement.power(v,2) + 
				                    3*Measurement.power(r,4)*Measurement.power(v,2) - 42*Measurement.power(r,5)*Measurement.power(v,2) + 42*m0*Measurement.power(r,5)*Measurement.power(v,2) + 
				                    6*Measurement.power(r,7)*Measurement.power(v,2))*(9*m1*Measurement.power(r,3) - 20*m1*Measurement.power(r,6) - m3*Measurement.power(r,6) + 3*m1*Measurement.power(r,9) - 
				                    m3*Measurement.power(r,9) - 9*m1*Measurement.power(r,4)*Measurement.power(v,2) + 21*m1*Measurement.power(r,7)*Measurement.power(v,2) + 3*m3*Measurement.power(r,7)*Measurement.power(v,2)
				                    ) + 1913625*(2 - 2*m0 - 3*Measurement.power(r,3) + 3*m0*Measurement.power(r,3) + Measurement.power(r,5))*
				                  Measurement.power(9*m1*Measurement.power(r,3) - 20*m1*Measurement.power(r,6) - m3*Measurement.power(r,6) + 3*m1*Measurement.power(r,9) - m3*Measurement.power(r,9) - 
				                    9*m1*Measurement.power(r,4)*Measurement.power(v,2) + 21*m1*Measurement.power(r,7)*Measurement.power(v,2) + 3*m3*Measurement.power(r,7)*Measurement.power(v,2),2) + 
				                 297675*Measurement.power(-3*m1*Measurement.power(r,2) + 7*m1*Measurement.power(r,5) + m3*Measurement.power(r,5),2)*
				                  (46*Measurement.power(r,2) - 46*m0*Measurement.power(r,2) + 14*Measurement.power(r,4) - 62*Measurement.power(r,5) + 62*m0*Measurement.power(r,5) - 
				                    24*m2*Measurement.power(r,5) - 10*Measurement.power(r,7) + 18*Measurement.power(r,8) - 18*m0*Measurement.power(r,8) + 34*m2*Measurement.power(r,8) + 
				                    4*Measurement.power(r,10) - 4*Measurement.power(r,11) + 4*m0*Measurement.power(r,11) - 7*m2*Measurement.power(r,11) - m6*Measurement.power(r,11) - 
				                    10*Measurement.power(r,13) + 2*Measurement.power(r,14) - 2*m0*Measurement.power(r,14) - 3*m2*Measurement.power(r,14) + m6*Measurement.power(r,14) + 
				                    2*Measurement.power(r,16) - 93*Measurement.power(r,3)*Measurement.power(v,2) + 93*m0*Measurement.power(r,3)*Measurement.power(v,2) - 25*Measurement.power(r,5)*Measurement.power(v,2) + 
				                    111*Measurement.power(r,6)*Measurement.power(v,2) - 111*m0*Measurement.power(r,6)*Measurement.power(v,2) + 27*m2*Measurement.power(r,6)*Measurement.power(v,2) + 
				                    23*Measurement.power(r,8)*Measurement.power(v,2) - 18*Measurement.power(r,9)*Measurement.power(v,2) + 18*m0*Measurement.power(r,9)*Measurement.power(v,2) - 
				                    27*m2*Measurement.power(r,9)*Measurement.power(v,2) - 4*Measurement.power(r,11)*Measurement.power(v,2) + 6*Measurement.power(r,14)*Measurement.power(v,2) + 
				                    45*Measurement.power(r,4)*Measurement.power(v,4) - 45*m0*Measurement.power(r,4)*Measurement.power(v,4) + 9*Measurement.power(r,6)*Measurement.power(v,4) - 
				                    45*Measurement.power(r,7)*Measurement.power(v,4) + 45*m0*Measurement.power(r,7)*Measurement.power(v,4) - 9*Measurement.power(r,9)*Measurement.power(v,4)) + 
				                 340200*(2 - 2*m0 - 3*Measurement.power(r,3) + 3*m0*Measurement.power(r,3) + Measurement.power(r,5))*
				                  (-34*r + 34*m0*r - 6*Measurement.power(r,3) + 46*Measurement.power(r,4) - 46*m0*Measurement.power(r,4) + 9*m2*Measurement.power(r,4) - 6*Measurement.power(r,7) + 
				                    6*m0*Measurement.power(r,7) - 9*m2*Measurement.power(r,7) + 33*Measurement.power(r,2)*Measurement.power(v,2) - 33*m0*Measurement.power(r,2)*Measurement.power(v,2) + 
				                    3*Measurement.power(r,4)*Measurement.power(v,2) - 42*Measurement.power(r,5)*Measurement.power(v,2) + 42*m0*Measurement.power(r,5)*Measurement.power(v,2) + 
				                    6*Measurement.power(r,7)*Measurement.power(v,2))*(46*Measurement.power(r,2) - 46*m0*Measurement.power(r,2) + 14*Measurement.power(r,4) - 62*Measurement.power(r,5) + 
				                    62*m0*Measurement.power(r,5) - 24*m2*Measurement.power(r,5) - 10*Measurement.power(r,7) + 18*Measurement.power(r,8) - 18*m0*Measurement.power(r,8) + 
				                    34*m2*Measurement.power(r,8) + 4*Measurement.power(r,10) - 4*Measurement.power(r,11) + 4*m0*Measurement.power(r,11) - 7*m2*Measurement.power(r,11) - 
				                    m6*Measurement.power(r,11) - 10*Measurement.power(r,13) + 2*Measurement.power(r,14) - 2*m0*Measurement.power(r,14) - 3*m2*Measurement.power(r,14) + 
				                    m6*Measurement.power(r,14) + 2*Measurement.power(r,16) - 93*Measurement.power(r,3)*Measurement.power(v,2) + 93*m0*Measurement.power(r,3)*Measurement.power(v,2) - 
				                    25*Measurement.power(r,5)*Measurement.power(v,2) + 111*Measurement.power(r,6)*Measurement.power(v,2) - 111*m0*Measurement.power(r,6)*Measurement.power(v,2) + 
				                    27*m2*Measurement.power(r,6)*Measurement.power(v,2) + 23*Measurement.power(r,8)*Measurement.power(v,2) - 18*Measurement.power(r,9)*Measurement.power(v,2) + 
				                    18*m0*Measurement.power(r,9)*Measurement.power(v,2) - 27*m2*Measurement.power(r,9)*Measurement.power(v,2) - 4*Measurement.power(r,11)*Measurement.power(v,2) + 
				                    6*Measurement.power(r,14)*Measurement.power(v,2) + 45*Measurement.power(r,4)*Measurement.power(v,4) - 45*m0*Measurement.power(r,4)*Measurement.power(v,4) + 
				                    9*Measurement.power(r,6)*Measurement.power(v,4) - 45*Measurement.power(r,7)*Measurement.power(v,4) + 45*m0*Measurement.power(r,7)*Measurement.power(v,4) - 
				                    9*Measurement.power(r,9)*Measurement.power(v,4)),2)),0.3333333333333333)) + 
				        Measurement.power(-6750*Measurement.power(-34*r + 34*m0*r - 6*Measurement.power(r,3) + 46*Measurement.power(r,4) - 46*m0*Measurement.power(r,4) + 9*m2*Measurement.power(r,4) - 
				              6*Measurement.power(r,7) + 6*m0*Measurement.power(r,7) - 9*m2*Measurement.power(r,7) + 33*Measurement.power(r,2)*Measurement.power(v,2) - 
				              33*m0*Measurement.power(r,2)*Measurement.power(v,2) + 3*Measurement.power(r,4)*Measurement.power(v,2) - 42*Measurement.power(r,5)*Measurement.power(v,2) + 
				              42*m0*Measurement.power(r,5)*Measurement.power(v,2) + 6*Measurement.power(r,7)*Measurement.power(v,2),3) - 
				           212625*(-3*m1*Measurement.power(r,2) + 7*m1*Measurement.power(r,5) + m3*Measurement.power(r,5))*
				            (-34*r + 34*m0*r - 6*Measurement.power(r,3) + 46*Measurement.power(r,4) - 46*m0*Measurement.power(r,4) + 9*m2*Measurement.power(r,4) - 6*Measurement.power(r,7) + 
				              6*m0*Measurement.power(r,7) - 9*m2*Measurement.power(r,7) + 33*Measurement.power(r,2)*Measurement.power(v,2) - 33*m0*Measurement.power(r,2)*Measurement.power(v,2) + 
				              3*Measurement.power(r,4)*Measurement.power(v,2) - 42*Measurement.power(r,5)*Measurement.power(v,2) + 42*m0*Measurement.power(r,5)*Measurement.power(v,2) + 6*Measurement.power(r,7)*Measurement.power(v,2))
				             *(9*m1*Measurement.power(r,3) - 20*m1*Measurement.power(r,6) - m3*Measurement.power(r,6) + 3*m1*Measurement.power(r,9) - m3*Measurement.power(r,9) - 
				              9*m1*Measurement.power(r,4)*Measurement.power(v,2) + 21*m1*Measurement.power(r,7)*Measurement.power(v,2) + 3*m3*Measurement.power(r,7)*Measurement.power(v,2)) + 
				           1913625*(2 - 2*m0 - 3*Measurement.power(r,3) + 3*m0*Measurement.power(r,3) + Measurement.power(r,5))*
				            Measurement.power(9*m1*Measurement.power(r,3) - 20*m1*Measurement.power(r,6) - m3*Measurement.power(r,6) + 3*m1*Measurement.power(r,9) - m3*Measurement.power(r,9) - 
				              9*m1*Measurement.power(r,4)*Measurement.power(v,2) + 21*m1*Measurement.power(r,7)*Measurement.power(v,2) + 3*m3*Measurement.power(r,7)*Measurement.power(v,2),2) + 
				           297675*Measurement.power(-3*m1*Measurement.power(r,2) + 7*m1*Measurement.power(r,5) + m3*Measurement.power(r,5),2)*
				            (46*Measurement.power(r,2) - 46*m0*Measurement.power(r,2) + 14*Measurement.power(r,4) - 62*Measurement.power(r,5) + 62*m0*Measurement.power(r,5) - 24*m2*Measurement.power(r,5) - 
				              10*Measurement.power(r,7) + 18*Measurement.power(r,8) - 18*m0*Measurement.power(r,8) + 34*m2*Measurement.power(r,8) + 4*Measurement.power(r,10) - 4*Measurement.power(r,11) + 
				              4*m0*Measurement.power(r,11) - 7*m2*Measurement.power(r,11) - m6*Measurement.power(r,11) - 10*Measurement.power(r,13) + 2*Measurement.power(r,14) - 2*m0*Measurement.power(r,14) - 
				              3*m2*Measurement.power(r,14) + m6*Measurement.power(r,14) + 2*Measurement.power(r,16) - 93*Measurement.power(r,3)*Measurement.power(v,2) + 
				              93*m0*Measurement.power(r,3)*Measurement.power(v,2) - 25*Measurement.power(r,5)*Measurement.power(v,2) + 111*Measurement.power(r,6)*Measurement.power(v,2) - 
				              111*m0*Measurement.power(r,6)*Measurement.power(v,2) + 27*m2*Measurement.power(r,6)*Measurement.power(v,2) + 23*Measurement.power(r,8)*Measurement.power(v,2) - 
				              18*Measurement.power(r,9)*Measurement.power(v,2) + 18*m0*Measurement.power(r,9)*Measurement.power(v,2) - 27*m2*Measurement.power(r,9)*Measurement.power(v,2) - 
				              4*Measurement.power(r,11)*Measurement.power(v,2) + 6*Measurement.power(r,14)*Measurement.power(v,2) + 45*Measurement.power(r,4)*Measurement.power(v,4) - 
				              45*m0*Measurement.power(r,4)*Measurement.power(v,4) + 9*Measurement.power(r,6)*Measurement.power(v,4) - 45*Measurement.power(r,7)*Measurement.power(v,4) + 
				              45*m0*Measurement.power(r,7)*Measurement.power(v,4) - 9*Measurement.power(r,9)*Measurement.power(v,4)) + 
				           340200*(2 - 2*m0 - 3*Measurement.power(r,3) + 3*m0*Measurement.power(r,3) + Measurement.power(r,5))*
				            (-34*r + 34*m0*r - 6*Measurement.power(r,3) + 46*Measurement.power(r,4) - 46*m0*Measurement.power(r,4) + 9*m2*Measurement.power(r,4) - 6*Measurement.power(r,7) + 
				              6*m0*Measurement.power(r,7) - 9*m2*Measurement.power(r,7) + 33*Measurement.power(r,2)*Measurement.power(v,2) - 33*m0*Measurement.power(r,2)*Measurement.power(v,2) + 
				              3*Measurement.power(r,4)*Measurement.power(v,2) - 42*Measurement.power(r,5)*Measurement.power(v,2) + 42*m0*Measurement.power(r,5)*Measurement.power(v,2) + 6*Measurement.power(r,7)*Measurement.power(v,2))
				             *(46*Measurement.power(r,2) - 46*m0*Measurement.power(r,2) + 14*Measurement.power(r,4) - 62*Measurement.power(r,5) + 62*m0*Measurement.power(r,5) - 24*m2*Measurement.power(r,5) - 
				              10*Measurement.power(r,7) + 18*Measurement.power(r,8) - 18*m0*Measurement.power(r,8) + 34*m2*Measurement.power(r,8) + 4*Measurement.power(r,10) - 4*Measurement.power(r,11) + 
				              4*m0*Measurement.power(r,11) - 7*m2*Measurement.power(r,11) - m6*Measurement.power(r,11) - 10*Measurement.power(r,13) + 2*Measurement.power(r,14) - 2*m0*Measurement.power(r,14) - 
				              3*m2*Measurement.power(r,14) + m6*Measurement.power(r,14) + 2*Measurement.power(r,16) - 93*Measurement.power(r,3)*Measurement.power(v,2) + 
				              93*m0*Measurement.power(r,3)*Measurement.power(v,2) - 25*Measurement.power(r,5)*Measurement.power(v,2) + 111*Measurement.power(r,6)*Measurement.power(v,2) - 
				              111*m0*Measurement.power(r,6)*Measurement.power(v,2) + 27*m2*Measurement.power(r,6)*Measurement.power(v,2) + 23*Measurement.power(r,8)*Measurement.power(v,2) - 
				              18*Measurement.power(r,9)*Measurement.power(v,2) + 18*m0*Measurement.power(r,9)*Measurement.power(v,2) - 27*m2*Measurement.power(r,9)*Measurement.power(v,2) - 
				              4*Measurement.power(r,11)*Measurement.power(v,2) + 6*Measurement.power(r,14)*Measurement.power(v,2) + 45*Measurement.power(r,4)*Measurement.power(v,4) - 
				              45*m0*Measurement.power(r,4)*Measurement.power(v,4) + 9*Measurement.power(r,6)*Measurement.power(v,4) - 45*Measurement.power(r,7)*Measurement.power(v,4) + 
				              45*m0*Measurement.power(r,7)*Measurement.power(v,4) - 9*Measurement.power(r,9)*Measurement.power(v,4)) + 
				           Sqrt(-4*Measurement.power(225*Measurement.power(-34*r + 34*m0*r - 6*Measurement.power(r,3) + 46*Measurement.power(r,4) - 46*m0*Measurement.power(r,4) + 9*m2*Measurement.power(r,4) - 
				                   6*Measurement.power(r,7) + 6*m0*Measurement.power(r,7) - 9*m2*Measurement.power(r,7) + 33*Measurement.power(r,2)*Measurement.power(v,2) - 
				                   33*m0*Measurement.power(r,2)*Measurement.power(v,2) + 3*Measurement.power(r,4)*Measurement.power(v,2) - 42*Measurement.power(r,5)*Measurement.power(v,2) + 
				                   42*m0*Measurement.power(r,5)*Measurement.power(v,2) + 6*Measurement.power(r,7)*Measurement.power(v,2),2) + 
				                4725*(-3*m1*Measurement.power(r,2) + 7*m1*Measurement.power(r,5) + m3*Measurement.power(r,5))*
				                 (9*m1*Measurement.power(r,3) - 20*m1*Measurement.power(r,6) - m3*Measurement.power(r,6) + 3*m1*Measurement.power(r,9) - m3*Measurement.power(r,9) - 
				                   9*m1*Measurement.power(r,4)*Measurement.power(v,2) + 21*m1*Measurement.power(r,7)*Measurement.power(v,2) + 3*m3*Measurement.power(r,7)*Measurement.power(v,2)) + 
				                3780*(2 - 2*m0 - 3*Measurement.power(r,3) + 3*m0*Measurement.power(r,3) + Measurement.power(r,5))*
				                 (46*Measurement.power(r,2) - 46*m0*Measurement.power(r,2) + 14*Measurement.power(r,4) - 62*Measurement.power(r,5) + 62*m0*Measurement.power(r,5) - 
				                   24*m2*Measurement.power(r,5) - 10*Measurement.power(r,7) + 18*Measurement.power(r,8) - 18*m0*Measurement.power(r,8) + 34*m2*Measurement.power(r,8) + 
				                   4*Measurement.power(r,10) - 4*Measurement.power(r,11) + 4*m0*Measurement.power(r,11) - 7*m2*Measurement.power(r,11) - m6*Measurement.power(r,11) - 
				                   10*Measurement.power(r,13) + 2*Measurement.power(r,14) - 2*m0*Measurement.power(r,14) - 3*m2*Measurement.power(r,14) + m6*Measurement.power(r,14) + 
				                   2*Measurement.power(r,16) - 93*Measurement.power(r,3)*Measurement.power(v,2) + 93*m0*Measurement.power(r,3)*Measurement.power(v,2) - 25*Measurement.power(r,5)*Measurement.power(v,2) + 
				                   111*Measurement.power(r,6)*Measurement.power(v,2) - 111*m0*Measurement.power(r,6)*Measurement.power(v,2) + 27*m2*Measurement.power(r,6)*Measurement.power(v,2) + 
				                   23*Measurement.power(r,8)*Measurement.power(v,2) - 18*Measurement.power(r,9)*Measurement.power(v,2) + 18*m0*Measurement.power(r,9)*Measurement.power(v,2) - 
				                   27*m2*Measurement.power(r,9)*Measurement.power(v,2) - 4*Measurement.power(r,11)*Measurement.power(v,2) + 6*Measurement.power(r,14)*Measurement.power(v,2) + 
				                   45*Measurement.power(r,4)*Measurement.power(v,4) - 45*m0*Measurement.power(r,4)*Measurement.power(v,4) + 9*Measurement.power(r,6)*Measurement.power(v,4) - 
				                   45*Measurement.power(r,7)*Measurement.power(v,4) + 45*m0*Measurement.power(r,7)*Measurement.power(v,4) - 9*Measurement.power(r,9)*Measurement.power(v,4)),3) + 
				             Measurement.power(-6750*Measurement.power(-34*r + 34*m0*r - 6*Measurement.power(r,3) + 46*Measurement.power(r,4) - 46*m0*Measurement.power(r,4) + 9*m2*Measurement.power(r,4) - 
				                  6*Measurement.power(r,7) + 6*m0*Measurement.power(r,7) - 9*m2*Measurement.power(r,7) + 33*Measurement.power(r,2)*Measurement.power(v,2) - 
				                  33*m0*Measurement.power(r,2)*Measurement.power(v,2) + 3*Measurement.power(r,4)*Measurement.power(v,2) - 42*Measurement.power(r,5)*Measurement.power(v,2) + 
				                  42*m0*Measurement.power(r,5)*Measurement.power(v,2) + 6*Measurement.power(r,7)*Measurement.power(v,2),3) - 
				               212625*(-3*m1*Measurement.power(r,2) + 7*m1*Measurement.power(r,5) + m3*Measurement.power(r,5))*
				                (-34*r + 34*m0*r - 6*Measurement.power(r,3) + 46*Measurement.power(r,4) - 46*m0*Measurement.power(r,4) + 9*m2*Measurement.power(r,4) - 6*Measurement.power(r,7) + 
				                  6*m0*Measurement.power(r,7) - 9*m2*Measurement.power(r,7) + 33*Measurement.power(r,2)*Measurement.power(v,2) - 33*m0*Measurement.power(r,2)*Measurement.power(v,2) + 
				                  3*Measurement.power(r,4)*Measurement.power(v,2) - 42*Measurement.power(r,5)*Measurement.power(v,2) + 42*m0*Measurement.power(r,5)*Measurement.power(v,2) + 
				                  6*Measurement.power(r,7)*Measurement.power(v,2))*(9*m1*Measurement.power(r,3) - 20*m1*Measurement.power(r,6) - m3*Measurement.power(r,6) + 3*m1*Measurement.power(r,9) - 
				                  m3*Measurement.power(r,9) - 9*m1*Measurement.power(r,4)*Measurement.power(v,2) + 21*m1*Measurement.power(r,7)*Measurement.power(v,2) + 3*m3*Measurement.power(r,7)*Measurement.power(v,2))
				                + 1913625*(2 - 2*m0 - 3*Measurement.power(r,3) + 3*m0*Measurement.power(r,3) + Measurement.power(r,5))*
				                Measurement.power(9*m1*Measurement.power(r,3) - 20*m1*Measurement.power(r,6) - m3*Measurement.power(r,6) + 3*m1*Measurement.power(r,9) - m3*Measurement.power(r,9) - 
				                  9*m1*Measurement.power(r,4)*Measurement.power(v,2) + 21*m1*Measurement.power(r,7)*Measurement.power(v,2) + 3*m3*Measurement.power(r,7)*Measurement.power(v,2),2) + 
				               297675*Measurement.power(-3*m1*Measurement.power(r,2) + 7*m1*Measurement.power(r,5) + m3*Measurement.power(r,5),2)*
				                (46*Measurement.power(r,2) - 46*m0*Measurement.power(r,2) + 14*Measurement.power(r,4) - 62*Measurement.power(r,5) + 62*m0*Measurement.power(r,5) - 
				                  24*m2*Measurement.power(r,5) - 10*Measurement.power(r,7) + 18*Measurement.power(r,8) - 18*m0*Measurement.power(r,8) + 34*m2*Measurement.power(r,8) + 
				                  4*Measurement.power(r,10) - 4*Measurement.power(r,11) + 4*m0*Measurement.power(r,11) - 7*m2*Measurement.power(r,11) - m6*Measurement.power(r,11) - 
				                  10*Measurement.power(r,13) + 2*Measurement.power(r,14) - 2*m0*Measurement.power(r,14) - 3*m2*Measurement.power(r,14) + m6*Measurement.power(r,14) + 
				                  2*Measurement.power(r,16) - 93*Measurement.power(r,3)*Measurement.power(v,2) + 93*m0*Measurement.power(r,3)*Measurement.power(v,2) - 25*Measurement.power(r,5)*Measurement.power(v,2) + 
				                  111*Measurement.power(r,6)*Measurement.power(v,2) - 111*m0*Measurement.power(r,6)*Measurement.power(v,2) + 27*m2*Measurement.power(r,6)*Measurement.power(v,2) + 
				                  23*Measurement.power(r,8)*Measurement.power(v,2) - 18*Measurement.power(r,9)*Measurement.power(v,2) + 18*m0*Measurement.power(r,9)*Measurement.power(v,2) - 
				                  27*m2*Measurement.power(r,9)*Measurement.power(v,2) - 4*Measurement.power(r,11)*Measurement.power(v,2) + 6*Measurement.power(r,14)*Measurement.power(v,2) + 
				                  45*Measurement.power(r,4)*Measurement.power(v,4) - 45*m0*Measurement.power(r,4)*Measurement.power(v,4) + 9*Measurement.power(r,6)*Measurement.power(v,4) - 
				                  45*Measurement.power(r,7)*Measurement.power(v,4) + 45*m0*Measurement.power(r,7)*Measurement.power(v,4) - 9*Measurement.power(r,9)*Measurement.power(v,4)) + 
				               340200*(2 - 2*m0 - 3*Measurement.power(r,3) + 3*m0*Measurement.power(r,3) + Measurement.power(r,5))*
				                (-34*r + 34*m0*r - 6*Measurement.power(r,3) + 46*Measurement.power(r,4) - 46*m0*Measurement.power(r,4) + 9*m2*Measurement.power(r,4) - 6*Measurement.power(r,7) + 
				                  6*m0*Measurement.power(r,7) - 9*m2*Measurement.power(r,7) + 33*Measurement.power(r,2)*Measurement.power(v,2) - 33*m0*Measurement.power(r,2)*Measurement.power(v,2) + 
				                  3*Measurement.power(r,4)*Measurement.power(v,2) - 42*Measurement.power(r,5)*Measurement.power(v,2) + 42*m0*Measurement.power(r,5)*Measurement.power(v,2) + 
				                  6*Measurement.power(r,7)*Measurement.power(v,2))*(46*Measurement.power(r,2) - 46*m0*Measurement.power(r,2) + 14*Measurement.power(r,4) - 62*Measurement.power(r,5) + 
				                  62*m0*Measurement.power(r,5) - 24*m2*Measurement.power(r,5) - 10*Measurement.power(r,7) + 18*Measurement.power(r,8) - 18*m0*Measurement.power(r,8) + 
				                  34*m2*Measurement.power(r,8) + 4*Measurement.power(r,10) - 4*Measurement.power(r,11) + 4*m0*Measurement.power(r,11) - 7*m2*Measurement.power(r,11) - 
				                  m6*Measurement.power(r,11) - 10*Measurement.power(r,13) + 2*Measurement.power(r,14) - 2*m0*Measurement.power(r,14) - 3*m2*Measurement.power(r,14) + 
				                  m6*Measurement.power(r,14) + 2*Measurement.power(r,16) - 93*Measurement.power(r,3)*Measurement.power(v,2) + 93*m0*Measurement.power(r,3)*Measurement.power(v,2) - 
				                  25*Measurement.power(r,5)*Measurement.power(v,2) + 111*Measurement.power(r,6)*Measurement.power(v,2) - 111*m0*Measurement.power(r,6)*Measurement.power(v,2) + 
				                  27*m2*Measurement.power(r,6)*Measurement.power(v,2) + 23*Measurement.power(r,8)*Measurement.power(v,2) - 18*Measurement.power(r,9)*Measurement.power(v,2) + 
				                  18*m0*Measurement.power(r,9)*Measurement.power(v,2) - 27*m2*Measurement.power(r,9)*Measurement.power(v,2) - 4*Measurement.power(r,11)*Measurement.power(v,2) + 
				                  6*Measurement.power(r,14)*Measurement.power(v,2) + 45*Measurement.power(r,4)*Measurement.power(v,4) - 45*m0*Measurement.power(r,4)*Measurement.power(v,4) + 
				                  9*Measurement.power(r,6)*Measurement.power(v,4) - 45*Measurement.power(r,7)*Measurement.power(v,4) + 45*m0*Measurement.power(r,7)*Measurement.power(v,4) - 
				                  9*Measurement.power(r,9)*Measurement.power(v,4)),2)),0.3333333333333333)/
				         (945.*Measurement.power(2,0.3333333333333333)*(2 - 2*m0 - 3*Measurement.power(r,3) + 3*m0*Measurement.power(r,3) + Measurement.power(r,5))))))/2.;
	}

	private static double Sqrt(double d)
	{
		return Math.sqrt(d);
	}
}
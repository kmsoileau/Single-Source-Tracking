package positronic.math;

public class Homotopy 
{
	private static double D1z;
	private static double D2z;
	private static double D3z;
	private static double D4z;
	private static double D5z;
	private static double D6z;
	private static double D7z;
	private static double D8z;
	private static double D9z;
	@SuppressWarnings("unused")
	private static double D10z;

	public static void coeffs(double z0)
	{
		D1z=(f(z0)-g(z0))/Df(1,z0);
		D2z=(2*Df(1,z0)*D1z-2*Dg(1,z0)*D1z-ipower(D1z,2)*Df(2,z0))/Df(1,z0);
		D3z=(3*ipower(D1z,2)*Df(2,z0)-3*ipower(D1z,2)*Dg(2,z0)+3*Df(1,z0)*D2z-3*Dg(1,z0)*D2z-3*D1z*Df(2,z0)*D2z-ipower(D1z,3)*Df(3,z0))/Df(1,z0);
		D4z=(12*D1z*Df(2,z0)*D2z-12*D1z*Dg(2,z0)*D2z-3*Df(2,z0)*ipower(D2z,2)+4*ipower(D1z,3)*Df(3,z0)-6*ipower(D1z,2)*D2z*Df(3,z0)-4*ipower(D1z,3)*Dg(3,z0)+4*Df(1,z0)*D3z-4*Dg(1,z0)*D3z-4*D1z*Df(2,z0)*D3z-ipower(D1z,4)*Df(4,z0))/Df(1,z0);
		D5z=(15*Df(2,z0)*ipower(D2z,2)-15*Dg(2,z0)*ipower(D2z,2)+30*ipower(D1z,2)*D2z*Df(3,z0)-15*D1z*ipower(D2z,2)*Df(3,z0)-30*ipower(D1z,2)*D2z*Dg(3,z0)+20*D1z*Df(2,z0)*D3z-20*D1z*Dg(2,z0)*D3z-10*Df(2,z0)*D2z*D3z-10*ipower(D1z,2)*Df(3,z0)*D3z+5*ipower(D1z,4)*Df(4,z0)-10*ipower(D1z,3)*D2z*Df(4,z0)-5*ipower(D1z,4)*Dg(4,z0)+5*Df(1,z0)*D4z-5*Dg(1,z0)*D4z-5*D1z*Df(2,z0)*D4z-ipower(D1z,5)*Df(5,z0))/Df(1,z0);
		D6z=(90*D1z*ipower(D2z,2)*Df(3,z0)-15*ipower(D2z,3)*Df(3,z0)-90*D1z*ipower(D2z,2)*Dg(3,z0)+60*Df(2,z0)*D2z*D3z-60*Dg(2,z0)*D2z*D3z+60*ipower(D1z,2)*Df(3,z0)*D3z-60*D1z*D2z*Df(3,z0)*D3z-60*ipower(D1z,2)*Dg(3,z0)*D3z-10*Df(2,z0)*ipower(D3z,2)+60*ipower(D1z,3)*D2z*Df(4,z0)-45*ipower(D1z,2)*ipower(D2z,2)*Df(4,z0)-20*ipower(D1z,3)*D3z*Df(4,z0)-60*ipower(D1z,3)*D2z*Dg(4,z0)+30*D1z*Df(2,z0)*D4z-30*D1z*Dg(2,z0)*D4z-15*Df(2,z0)*D2z*D4z-15*ipower(D1z,2)*Df(3,z0)*D4z+6*ipower(D1z,5)*Df(5,z0)-15*ipower(D1z,4)*D2z*Df(5,z0)-6*ipower(D1z,5)*Dg(5,z0)+6*Df(1,z0)*D5z-6*Dg(1,z0)*D5z-6*D1z*Df(2,z0)*D5z-ipower(D1z,6)*Df(6,z0))/Df(1,z0);
		D7z=(105*ipower(D2z,3)*Df(3,z0)-105*ipower(D2z,3)*Dg(3,z0)+420*D1z*D2z*Df(3,z0)*D3z-105*ipower(D2z,2)*Df(3,z0)*D3z-420*D1z*D2z*Dg(3,z0)*D3z+70*Df(2,z0)*ipower(D3z,2)-70*Dg(2,z0)*ipower(D3z,2)-70*D1z*Df(3,z0)*ipower(D3z,2)+315*ipower(D1z,2)*ipower(D2z,2)*Df(4,z0)-105*D1z*ipower(D2z,3)*Df(4,z0)+140*ipower(D1z,3)*D3z*Df(4,z0)-210*ipower(D1z,2)*D2z*D3z*Df(4,z0)-315*ipower(D1z,2)*ipower(D2z,2)*Dg(4,z0)-140*ipower(D1z,3)*D3z*Dg(4,z0)+105*Df(2,z0)*D2z*D4z-105*Dg(2,z0)*D2z*D4z+105*ipower(D1z,2)*Df(3,z0)*D4z-105*D1z*D2z*Df(3,z0)*D4z-105*ipower(D1z,2)*Dg(3,z0)*D4z-35*Df(2,z0)*D3z*D4z-35*ipower(D1z,3)*Df(4,z0)*D4z+105*ipower(D1z,4)*D2z*Df(5,z0)-105*ipower(D1z,3)*ipower(D2z,2)*Df(5,z0)-35*ipower(D1z,4)*D3z*Df(5,z0)-105*ipower(D1z,4)*D2z*Dg(5,z0)+42*D1z*Df(2,z0)*D5z-42*D1z*Dg(2,z0)*D5z-21*Df(2,z0)*D2z*D5z-21*ipower(D1z,2)*Df(3,z0)*D5z+7*ipower(D1z,6)*Df(6,z0)-21*ipower(D1z,5)*D2z*Df(6,z0)-7*ipower(D1z,6)*Dg(6,z0)+7*Df(1,z0)*D6z-7*Dg(1,z0)*D6z-7*D1z*Df(2,z0)*D6z-ipower(D1z,7)*Df(7,z0))/Df(1,z0);
		D8z=(840*ipower(D2z,2)*Df(3,z0)*D3z-840*ipower(D2z,2)*Dg(3,z0)*D3z+560*D1z*Df(3,z0)*ipower(D3z,2)-280*D2z*Df(3,z0)*ipower(D3z,2)-560*D1z*Dg(3,z0)*ipower(D3z,2)+840*D1z*ipower(D2z,3)*Df(4,z0)-105*ipower(D2z,4)*Df(4,z0)+1680*ipower(D1z,2)*D2z*D3z*Df(4,z0)-840*D1z*ipower(D2z,2)*D3z*Df(4,z0)-280*ipower(D1z,2)*ipower(D3z,2)*Df(4,z0)-840*D1z*ipower(D2z,3)*Dg(4,z0)-1680*ipower(D1z,2)*D2z*D3z*Dg(4,z0)+840*D1z*D2z*Df(3,z0)*D4z-210*ipower(D2z,2)*Df(3,z0)*D4z-840*D1z*D2z*Dg(3,z0)*D4z+280*Df(2,z0)*D3z*D4z-280*Dg(2,z0)*D3z*D4z-280*D1z*Df(3,z0)*D3z*D4z+280*ipower(D1z,3)*Df(4,z0)*D4z-420*ipower(D1z,2)*D2z*Df(4,z0)*D4z-280*ipower(D1z,3)*Dg(4,z0)*D4z-35*Df(2,z0)*ipower(D4z,2)+840*ipower(D1z,3)*ipower(D2z,2)*Df(5,z0)-420*ipower(D1z,2)*ipower(D2z,3)*Df(5,z0)+280*ipower(D1z,4)*D3z*Df(5,z0)-560*ipower(D1z,3)*D2z*D3z*Df(5,z0)-70*ipower(D1z,4)*D4z*Df(5,z0)-840*ipower(D1z,3)*ipower(D2z,2)*Dg(5,z0)-280*ipower(D1z,4)*D3z*Dg(5,z0)+168*Df(2,z0)*D2z*D5z-168*Dg(2,z0)*D2z*D5z+168*ipower(D1z,2)*Df(3,z0)*D5z-168*D1z*D2z*Df(3,z0)*D5z-168*ipower(D1z,2)*Dg(3,z0)*D5z-56*Df(2,z0)*D3z*D5z-56*ipower(D1z,3)*Df(4,z0)*D5z+168*ipower(D1z,5)*D2z*Df(6,z0)-210*ipower(D1z,4)*ipower(D2z,2)*Df(6,z0)-56*ipower(D1z,5)*D3z*Df(6,z0)-168*ipower(D1z,5)*D2z*Dg(6,z0)+56*D1z*Df(2,z0)*D6z-56*D1z*Dg(2,z0)*D6z-28*Df(2,z0)*D2z*D6z-28*ipower(D1z,2)*Df(3,z0)*D6z+8*ipower(D1z,7)*Df(7,z0)-28*ipower(D1z,6)*D2z*Df(7,z0)-8*ipower(D1z,7)*Dg(7,z0)+8*Df(1,z0)*D7z-8*Dg(1,z0)*D7z-8*D1z*Df(2,z0)*D7z-ipower(D1z,8)*Df(8,z0))/Df(1,z0);
		D9z=(2520*D2z*Df(3,z0)*ipower(D3z,2)-2520*D2z*Dg(3,z0)*ipower(D3z,2)-280*Df(3,z0)*ipower(D3z,3)+945*ipower(D2z,4)*Df(4,z0)+7560*D1z*ipower(D2z,2)*D3z*Df(4,z0)-1260*ipower(D2z,3)*D3z*Df(4,z0)+2520*ipower(D1z,2)*ipower(D3z,2)*Df(4,z0)-2520*D1z*D2z*ipower(D3z,2)*Df(4,z0)-945*ipower(D2z,4)*Dg(4,z0)-7560*D1z*ipower(D2z,2)*D3z*Dg(4,z0)-2520*ipower(D1z,2)*ipower(D3z,2)*Dg(4,z0)+1890*ipower(D2z,2)*Df(3,z0)*D4z-1890*ipower(D2z,2)*Dg(3,z0)*D4z+2520*D1z*Df(3,z0)*D3z*D4z-1260*D2z*Df(3,z0)*D3z*D4z-2520*D1z*Dg(3,z0)*D3z*D4z+3780*ipower(D1z,2)*D2z*Df(4,z0)*D4z-1890*D1z*ipower(D2z,2)*Df(4,z0)*D4z-1260*ipower(D1z,2)*D3z*Df(4,z0)*D4z-3780*ipower(D1z,2)*D2z*Dg(4,z0)*D4z+315*Df(2,z0)*ipower(D4z,2)-315*Dg(2,z0)*ipower(D4z,2)-315*D1z*Df(3,z0)*ipower(D4z,2)+3780*ipower(D1z,2)*ipower(D2z,3)*Df(5,z0)-945*D1z*ipower(D2z,4)*Df(5,z0)+5040*ipower(D1z,3)*D2z*D3z*Df(5,z0)-3780*ipower(D1z,2)*ipower(D2z,2)*D3z*Df(5,z0)-840*ipower(D1z,3)*ipower(D3z,2)*Df(5,z0)+630*ipower(D1z,4)*D4z*Df(5,z0)-1260*ipower(D1z,3)*D2z*D4z*Df(5,z0)-3780*ipower(D1z,2)*ipower(D2z,3)*Dg(5,z0)-5040*ipower(D1z,3)*D2z*D3z*Dg(5,z0)-630*ipower(D1z,4)*D4z*Dg(5,z0)+1512*D1z*D2z*Df(3,z0)*D5z-378*ipower(D2z,2)*Df(3,z0)*D5z-1512*D1z*D2z*Dg(3,z0)*D5z+504*Df(2,z0)*D3z*D5z-504*Dg(2,z0)*D3z*D5z-504*D1z*Df(3,z0)*D3z*D5z+504*ipower(D1z,3)*Df(4,z0)*D5z-756*ipower(D1z,2)*D2z*Df(4,z0)*D5z-504*ipower(D1z,3)*Dg(4,z0)*D5z-126*Df(2,z0)*D4z*D5z-126*ipower(D1z,4)*Df(5,z0)*D5z+1890*ipower(D1z,4)*ipower(D2z,2)*Df(6,z0)-1260*ipower(D1z,3)*ipower(D2z,3)*Df(6,z0)+504*ipower(D1z,5)*D3z*Df(6,z0)-1260*ipower(D1z,4)*D2z*D3z*Df(6,z0)-126*ipower(D1z,5)*D4z*Df(6,z0)-1890*ipower(D1z,4)*ipower(D2z,2)*Dg(6,z0)-504*ipower(D1z,5)*D3z*Dg(6,z0)+252*Df(2,z0)*D2z*D6z-252*Dg(2,z0)*D2z*D6z+252*ipower(D1z,2)*Df(3,z0)*D6z-252*D1z*D2z*Df(3,z0)*D6z-252*ipower(D1z,2)*Dg(3,z0)*D6z-84*Df(2,z0)*D3z*D6z-84*ipower(D1z,3)*Df(4,z0)*D6z+252*ipower(D1z,6)*D2z*Df(7,z0)-378*ipower(D1z,5)*ipower(D2z,2)*Df(7,z0)-84*ipower(D1z,6)*D3z*Df(7,z0)-252*ipower(D1z,6)*D2z*Dg(7,z0)+72*D1z*Df(2,z0)*D7z-72*D1z*Dg(2,z0)*D7z-36*Df(2,z0)*D2z*D7z-36*ipower(D1z,2)*Df(3,z0)*D7z+9*ipower(D1z,8)*Df(8,z0)-36*ipower(D1z,7)*D2z*Df(8,z0)-9*ipower(D1z,8)*Dg(8,z0)+9*Df(1,z0)*D8z-9*Dg(1,z0)*D8z-9*D1z*Df(2,z0)*D8z-ipower(D1z,9)*Df(9,z0))/Df(1,z0);
		D10z=(2800*Df(3,z0)*ipower(D3z,3)-2800*Dg(3,z0)*ipower(D3z,3)+12600*ipower(D2z,3)*D3z*Df(4,z0)+25200*D1z*D2z*ipower(D3z,2)*Df(4,z0)-6300*ipower(D2z,2)*ipower(D3z,2)*Df(4,z0)-2800*D1z*ipower(D3z,3)*Df(4,z0)-12600*ipower(D2z,3)*D3z*Dg(4,z0)-25200*D1z*D2z*ipower(D3z,2)*Dg(4,z0)+12600*D2z*Df(3,z0)*D3z*D4z-12600*D2z*Dg(3,z0)*D3z*D4z-2100*Df(3,z0)*ipower(D3z,2)*D4z+18900*D1z*ipower(D2z,2)*Df(4,z0)*D4z-3150*ipower(D2z,3)*Df(4,z0)*D4z+12600*ipower(D1z,2)*D3z*Df(4,z0)*D4z-12600*D1z*D2z*D3z*Df(4,z0)*D4z-18900*D1z*ipower(D2z,2)*Dg(4,z0)*D4z-12600*ipower(D1z,2)*D3z*Dg(4,z0)*D4z+3150*D1z*Df(3,z0)*ipower(D4z,2)-1575*D2z*Df(3,z0)*ipower(D4z,2)-3150*D1z*Dg(3,z0)*ipower(D4z,2)-1575*ipower(D1z,2)*Df(4,z0)*ipower(D4z,2)+9450*D1z*ipower(D2z,4)*Df(5,z0)-945*ipower(D2z,5)*Df(5,z0)+37800*ipower(D1z,2)*ipower(D2z,2)*D3z*Df(5,z0)-12600*D1z*ipower(D2z,3)*D3z*Df(5,z0)+8400*ipower(D1z,3)*ipower(D3z,2)*Df(5,z0)-12600*ipower(D1z,2)*D2z*ipower(D3z,2)*Df(5,z0)+12600*ipower(D1z,3)*D2z*D4z*Df(5,z0)-9450*ipower(D1z,2)*ipower(D2z,2)*D4z*Df(5,z0)-4200*ipower(D1z,3)*D3z*D4z*Df(5,z0)-9450*D1z*ipower(D2z,4)*Dg(5,z0)-37800*ipower(D1z,2)*ipower(D2z,2)*D3z*Dg(5,z0)-8400*ipower(D1z,3)*ipower(D3z,2)*Dg(5,z0)-12600*ipower(D1z,3)*D2z*D4z*Dg(5,z0)+3780*ipower(D2z,2)*Df(3,z0)*D5z-3780*ipower(D2z,2)*Dg(3,z0)*D5z+5040*D1z*Df(3,z0)*D3z*D5z-2520*D2z*Df(3,z0)*D3z*D5z-5040*D1z*Dg(3,z0)*D3z*D5z+7560*ipower(D1z,2)*D2z*Df(4,z0)*D5z-3780*D1z*ipower(D2z,2)*Df(4,z0)*D5z-2520*ipower(D1z,2)*D3z*Df(4,z0)*D5z-7560*ipower(D1z,2)*D2z*Dg(4,z0)*D5z+1260*Df(2,z0)*D4z*D5z-1260*Dg(2,z0)*D4z*D5z-1260*D1z*Df(3,z0)*D4z*D5z+1260*ipower(D1z,4)*Df(5,z0)*D5z-2520*ipower(D1z,3)*D2z*Df(5,z0)*D5z-1260*ipower(D1z,4)*Dg(5,z0)*D5z-126*Df(2,z0)*ipower(D5z,2)+12600*ipower(D1z,3)*ipower(D2z,3)*Df(6,z0)-4725*ipower(D1z,2)*ipower(D2z,4)*Df(6,z0)+12600*ipower(D1z,4)*D2z*D3z*Df(6,z0)-12600*ipower(D1z,3)*ipower(D2z,2)*D3z*Df(6,z0)-2100*ipower(D1z,4)*ipower(D3z,2)*Df(6,z0)+1260*ipower(D1z,5)*D4z*Df(6,z0)-3150*ipower(D1z,4)*D2z*D4z*Df(6,z0)-252*ipower(D1z,5)*D5z*Df(6,z0)-12600*ipower(D1z,3)*ipower(D2z,3)*Dg(6,z0)-12600*ipower(D1z,4)*D2z*D3z*Dg(6,z0)-1260*ipower(D1z,5)*D4z*Dg(6,z0)+2520*D1z*D2z*Df(3,z0)*D6z-630*ipower(D2z,2)*Df(3,z0)*D6z-2520*D1z*D2z*Dg(3,z0)*D6z+840*Df(2,z0)*D3z*D6z-840*Dg(2,z0)*D3z*D6z-840*D1z*Df(3,z0)*D3z*D6z+840*ipower(D1z,3)*Df(4,z0)*D6z-1260*ipower(D1z,2)*D2z*Df(4,z0)*D6z-840*ipower(D1z,3)*Dg(4,z0)*D6z-210*Df(2,z0)*D4z*D6z-210*ipower(D1z,4)*Df(5,z0)*D6z+3780*ipower(D1z,5)*ipower(D2z,2)*Df(7,z0)-3150*ipower(D1z,4)*ipower(D2z,3)*Df(7,z0)+840*ipower(D1z,6)*D3z*Df(7,z0)-2520*ipower(D1z,5)*D2z*D3z*Df(7,z0)-210*ipower(D1z,6)*D4z*Df(7,z0)-3780*ipower(D1z,5)*ipower(D2z,2)*Dg(7,z0)-840*ipower(D1z,6)*D3z*Dg(7,z0)+360*Df(2,z0)*D2z*D7z-360*Dg(2,z0)*D2z*D7z+360*ipower(D1z,2)*Df(3,z0)*D7z-360*D1z*D2z*Df(3,z0)*D7z-360*ipower(D1z,2)*Dg(3,z0)*D7z-120*Df(2,z0)*D3z*D7z-120*ipower(D1z,3)*Df(4,z0)*D7z+360*ipower(D1z,7)*D2z*Df(8,z0)-630*ipower(D1z,6)*ipower(D2z,2)*Df(8,z0)-120*ipower(D1z,7)*D3z*Df(8,z0)-360*ipower(D1z,7)*D2z*Dg(8,z0)+90*D1z*Df(2,z0)*D8z-90*D1z*Dg(2,z0)*D8z-45*Df(2,z0)*D2z*D8z-45*ipower(D1z,2)*Df(3,z0)*D8z+10*ipower(D1z,9)*Df(9,z0)-45*ipower(D1z,8)*D2z*Df(9,z0)-10*ipower(D1z,9)*Dg(9,z0)+10*Df(1,z0)*D9z-10*Dg(1,z0)*D9z-10*D1z*Df(2,z0)*D9z-ipower(D1z,10)*Df(10,z0))/Df(1,z0);
	}

	private static int Df(int i, double z0) 
	{
		return 0;
	}

	private static int Dg(int i, double z0) 
	{
		return 0;
	}

	private static int f(double z0) 
	{
		return 0;
	}

	private static int g(double z0) 
	{
		return 0;
	}

	private static double ipower(double x, int i) 
	{
		if(i==0)
			return 1d;
		else
			return x*ipower(x,i-1);
	}
}

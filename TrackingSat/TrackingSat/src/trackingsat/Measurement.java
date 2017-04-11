package trackingsat;

public class Measurement
{
	public static double power(double x, double y) 
	{
		return Math.pow(x, y);
	}
	
	public static double power(double x, int n) 
	{
		if(x==0d && n==0)
			return Double.NaN;
		if(x==0d && n<0)
			return Double.POSITIVE_INFINITY;
		if(x==0d && n>0)
			return 0d;
		if(n==0)
			return 1d;
		if(n<0)
			return 1d/power(x,-n);
		return x*power(x,n-1);
	}
	
	public double m0;
	public double m1;
	public double m2;
	public double m3;
	public double m4;
	public double m5;
	public double m6;
	public double m7;
	
	public Measurement(double m0,double m1,double m2,double m3,double m4,double m5,double m6,double m7)
	{
		this.m0=m0;
		this.m1=m1;
		this.m2=m2;
		this.m3=m3;
		this.m4=m4;
		this.m5=m5;
		this.m6=m6;
		this.m7=m7;
	}
	
	public Measurement(Vector rv, Vector vv, Vector Ru, Vector Tu)
	{
			this.m0=1 - 2*dot(rv,Ru) + dot(rv,rv);
			this.m1=2*dot(rv,vv) - 2*(dot(rv,Tu) + dot(vv,Ru));
			this.m2=2*dot(rv,Ru) + (2*dot(rv,Ru))/power(dot(rv,rv),1.5) - 2/Sqrt(dot(rv,rv)) - 4*dot(vv,Tu) + 
					   2*dot(vv,vv);
			this.m3=2*dot(rv,Tu) + (6*dot(rv,Tu))/power(dot(rv,rv),1.5) - 
					   (6*dot(rv,Ru)*dot(rv,vv))/power(dot(rv,rv),2.5) - (2*dot(rv,vv))/power(dot(rv,rv),1.5) + 
					   6*dot(vv,Ru) + (2*dot(vv,Ru))/power(dot(rv,rv),1.5);
			this.m4=-2*dot(rv,Ru) + (4*dot(rv,Ru))/power(dot(rv,rv),3) + 2/power(dot(rv,rv),2) - 
					   (12*dot(rv,Ru))/power(dot(rv,rv),1.5) - (24*dot(rv,Tu)*dot(rv,vv))/power(dot(rv,rv),2.5) + 
					   (30*dot(rv,Ru)*power(dot(rv,vv),2))/power(dot(rv,rv),3.5) + 
					   (6*power(dot(rv,vv),2))/power(dot(rv,rv),2.5) - 
					   (12*dot(rv,vv)*dot(vv,Ru))/power(dot(rv,rv),2.5) + 8*dot(vv,Tu) + 
					   (8*dot(vv,Tu))/power(dot(rv,rv),1.5) - (6*dot(rv,Ru)*dot(vv,vv))/power(dot(rv,rv),2.5) - 
					   (2*dot(vv,vv))/power(dot(rv,rv),1.5);
			this.m5=-2*dot(rv,Tu) + (20*dot(rv,Tu))/power(dot(rv,rv),3) - (20*dot(rv,Tu))/power(dot(rv,rv),1.5) - 
					   (60*dot(rv,Ru)*dot(rv,vv))/power(dot(rv,rv),4) - (16*dot(rv,vv))/power(dot(rv,rv),3) + 
					   (60*dot(rv,Ru)*dot(rv,vv))/power(dot(rv,rv),2.5) + 
					   (150*dot(rv,Tu)*power(dot(rv,vv),2))/power(dot(rv,rv),3.5) - 
					   (210*dot(rv,Ru)*power(dot(rv,vv),3))/power(dot(rv,rv),4.5) - 
					   (30*power(dot(rv,vv),3))/power(dot(rv,rv),3.5) - 10*dot(vv,Ru) + 
					   (16*dot(vv,Ru))/power(dot(rv,rv),3) - (20*dot(vv,Ru))/power(dot(rv,rv),1.5) + 
					   (90*power(dot(rv,vv),2)*dot(vv,Ru))/power(dot(rv,rv),3.5) - 
					   (60*dot(rv,vv)*dot(vv,Tu))/power(dot(rv,rv),2.5) - 
					   (30*dot(rv,Tu)*dot(vv,vv))/power(dot(rv,rv),2.5) + 
					   (90*dot(rv,Ru)*dot(rv,vv)*dot(vv,vv))/power(dot(rv,rv),3.5) + 
					   (18*dot(rv,vv)*dot(vv,vv))/power(dot(rv,rv),2.5) - 
					   (18*dot(vv,Ru)*dot(vv,vv))/power(dot(rv,rv),2.5);
			this.m6=2*dot(rv,Ru) + (44*dot(rv,Ru))/power(dot(rv,rv),4.5) + 16/power(dot(rv,rv),3.5) - 
					   (60*dot(rv,Ru))/power(dot(rv,rv),3) + (30*dot(rv,Ru))/power(dot(rv,rv),1.5) - 
					   (360*dot(rv,Tu)*dot(rv,vv))/power(dot(rv,rv),4) + 
					   (120*dot(rv,Tu)*dot(rv,vv))/power(dot(rv,rv),2.5) + 
					   (840*dot(rv,Ru)*power(dot(rv,vv),2))/power(dot(rv,rv),5) + 
					   (150*power(dot(rv,vv),2))/power(dot(rv,rv),4) - 
					   (450*dot(rv,Ru)*power(dot(rv,vv),2))/power(dot(rv,rv),3.5) - 
					   (1260*dot(rv,Tu)*power(dot(rv,vv),3))/power(dot(rv,rv),4.5) + 
					   (1890*dot(rv,Ru)*power(dot(rv,vv),4))/power(dot(rv,rv),5.5) + 
					   (210*power(dot(rv,vv),4))/power(dot(rv,rv),4.5) - 
					   (300*dot(rv,vv)*dot(vv,Ru))/power(dot(rv,rv),4) + 
					   (180*dot(rv,vv)*dot(vv,Ru))/power(dot(rv,rv),2.5) - 
					   (840*power(dot(rv,vv),3)*dot(vv,Ru))/power(dot(rv,rv),4.5) - 12*dot(vv,Tu) + 
					   (96*dot(vv,Tu))/power(dot(rv,rv),3) - (40*dot(vv,Tu))/power(dot(rv,rv),1.5) + 
					   (540*power(dot(rv,vv),2)*dot(vv,Tu))/power(dot(rv,rv),3.5) - 
					   (132*dot(rv,Ru)*dot(vv,vv))/power(dot(rv,rv),4) - (34*dot(vv,vv))/power(dot(rv,rv),3) + 
					   (90*dot(rv,Ru)*dot(vv,vv))/power(dot(rv,rv),2.5) + 
					   (540*dot(rv,Tu)*dot(rv,vv)*dot(vv,vv))/power(dot(rv,rv),3.5) - 
					   (1260*dot(rv,Ru)*power(dot(rv,vv),2)*dot(vv,vv))/power(dot(rv,rv),4.5) - 
					   (180*power(dot(rv,vv),2)*dot(vv,vv))/power(dot(rv,rv),3.5) + 
					   (360*dot(rv,vv)*dot(vv,Ru)*dot(vv,vv))/power(dot(rv,rv),3.5) - 
					   (108*dot(vv,Tu)*dot(vv,vv))/power(dot(rv,rv),2.5) + 
					   (90*dot(rv,Ru)*power(dot(vv,vv),2))/power(dot(rv,rv),3.5) + 
					   (18*power(dot(vv,vv),2))/power(dot(rv,rv),2.5);
			this.m7=2*dot(rv,Tu) + (308*dot(rv,Tu))/power(dot(rv,rv),4.5) - 
					   (140*dot(rv,Tu))/power(dot(rv,rv),3) + (42*dot(rv,Tu))/power(dot(rv,rv),1.5) - 
					   (1512*dot(rv,Ru)*dot(rv,vv))/power(dot(rv,rv),5.5) - 
					   (344*dot(rv,vv))/power(dot(rv,rv),4.5) + 
					   (1260*dot(rv,Ru)*dot(rv,vv))/power(dot(rv,rv),4) - 
					   (210*dot(rv,Ru)*dot(rv,vv))/power(dot(rv,rv),2.5) + 
					   (5880*dot(rv,Tu)*power(dot(rv,vv),2))/power(dot(rv,rv),5) - 
					   (1050*dot(rv,Tu)*power(dot(rv,vv),2))/power(dot(rv,rv),3.5) - 
					   (12600*dot(rv,Ru)*power(dot(rv,vv),3))/power(dot(rv,rv),6) - 
					   (1680*power(dot(rv,vv),3))/power(dot(rv,rv),5) + 
					   (4410*dot(rv,Ru)*power(dot(rv,vv),3))/power(dot(rv,rv),4.5) + 
					   (13230*dot(rv,Tu)*power(dot(rv,vv),4))/power(dot(rv,rv),5.5) - 
					   (20790*dot(rv,Ru)*power(dot(rv,vv),5))/power(dot(rv,rv),6.5) - 
					   (1890*power(dot(rv,vv),5))/power(dot(rv,rv),5.5) + 14*dot(vv,Ru) + 
					   (344*dot(vv,Ru))/power(dot(rv,rv),4.5) - (336*dot(vv,Ru))/power(dot(rv,rv),3) + 
					   (70*dot(vv,Ru))/power(dot(rv,rv),1.5) + 
					   (5040*power(dot(rv,vv),2)*dot(vv,Ru))/power(dot(rv,rv),5) - 
					   (1890*power(dot(rv,vv),2)*dot(vv,Ru))/power(dot(rv,rv),3.5) + 
					   (9450*power(dot(rv,vv),4)*dot(vv,Ru))/power(dot(rv,rv),5.5) - 
					   (2100*dot(rv,vv)*dot(vv,Tu))/power(dot(rv,rv),4) + 
					   (420*dot(rv,vv)*dot(vv,Tu))/power(dot(rv,rv),2.5) - 
					   (5880*power(dot(rv,vv),3)*dot(vv,Tu))/power(dot(rv,rv),4.5) - 
					   (924*dot(rv,Tu)*dot(vv,vv))/power(dot(rv,rv),4) + 
					   (210*dot(rv,Tu)*dot(vv,vv))/power(dot(rv,rv),2.5) + 
					   (4536*dot(rv,Ru)*dot(rv,vv)*dot(vv,vv))/power(dot(rv,rv),5) + 
					   (792*dot(rv,vv)*dot(vv,vv))/power(dot(rv,rv),4) - 
					   (1890*dot(rv,Ru)*dot(rv,vv)*dot(vv,vv))/power(dot(rv,rv),3.5) - 
					   (8820*dot(rv,Tu)*power(dot(rv,vv),2)*dot(vv,vv))/power(dot(rv,rv),4.5) + 
					   (18900*dot(rv,Ru)*power(dot(rv,vv),3)*dot(vv,vv))/power(dot(rv,rv),5.5) + 
					   (2100*power(dot(rv,vv),3)*dot(vv,vv))/power(dot(rv,rv),4.5) - 
					   (792*dot(vv,Ru)*dot(vv,vv))/power(dot(rv,rv),4) + 
					   (378*dot(vv,Ru)*dot(vv,vv))/power(dot(rv,rv),2.5) - 
					   (6300*power(dot(rv,vv),2)*dot(vv,Ru)*dot(vv,vv))/power(dot(rv,rv),4.5) + 
					   (2520*dot(rv,vv)*dot(vv,Tu)*dot(vv,vv))/power(dot(rv,rv),3.5) + 
					   (630*dot(rv,Tu)*power(dot(vv,vv),2))/power(dot(rv,rv),3.5) - 
					   (3150*dot(rv,Ru)*dot(rv,vv)*power(dot(vv,vv),2))/power(dot(rv,rv),4.5) - 
					   (450*dot(rv,vv)*power(dot(vv,vv),2))/power(dot(rv,rv),3.5) + 
					   (450*dot(vv,Ru)*power(dot(vv,vv),2))/power(dot(rv,rv),3.5);
	}
	
	public double dot(Vector a, Vector b)
	{
		return a.dot(b);
	}


	public double Sqrt(double d)
	{
		return Math.sqrt(d);
	}

	public String toString()
	{
		return "Measurement [m0=" + m0 + ", m1=" + m1 + ", m2=" + m2 + ", m3="
				+ m3 + ", m4=" + m4 + ", m5=" + m5 + ", m6=" + m6 + ", m7="
				+ m7 + "]";
	}
}
package positronic.math.optimization;

import positronic.math.IFunction2;

public class Triangle implements IFunction2
{
	public static final double E=Math.exp(1.);
	
	public static void main(String[] args) 
	{
		int divisions=50;
		int runs=100;
		double initX=-.1;
		double initY=-.2;
		
		double[][] pts=new double[divisions][2];
		
		pts[0][0]=initX;
		pts[0][1]=initY;
		
		for(int i=1;i<divisions;i++)
		{
			pts[i][0]=Math.random();
			pts[i][1]=Math.random();
		}
		
		double[][] res=pts;
		for(int trials=0;trials<runs;trials++)
		{
			res=Optima.optima(res,new Triangle());
		
			String outp="{";
			for(int i=0;i<res.length-1;i++)
				outp+="{"+res[i][0]+","+res[i][1]+"},\n";
			outp+="{"+res[res.length-1][0]+","+res[res.length-1][1]+"}";
			outp+="}";
			System.out.println(outp);
		}
	}
	
	public double f(double a, double b) 
	{
		return 1/((1 + Power(E,-10*b))*(1 + Power(E,10*(-(Sqrt(3)*a) + b)))*
			     (1 + Power(E,10*(-Sqrt(3) + Sqrt(3)*a + b))));
	}

	public double f1(double a, double b) 
	{
		return (-10*Sqrt(3)*Power(E,10*(-Sqrt(3) + Sqrt(3)*a + b)))/
			    ((1 + Power(E,-10*b))*(1 + Power(E,10*(-(Sqrt(3)*a) + b)))*
			    	      Power(1 + Power(E,10*(-Sqrt(3) + Sqrt(3)*a + b)),2)) + 
			    	   (10*Sqrt(3)*Power(E,10*(-(Sqrt(3)*a) + b)))/
			    	    ((1 + Power(E,-10*b))*Power(1 + Power(E,10*(-(Sqrt(3)*a) + b)),2)*
			    	      (1 + Power(E,10*(-Sqrt(3) + Sqrt(3)*a + b))));
	}

	public double f2(double a, double b) 
	{
		return (-10*Power(E,10*(-Sqrt(3) + Sqrt(3)*a + b)))/
			    ((1 + Power(E,-10*b))*(1 + Power(E,10*(-(Sqrt(3)*a) + b)))*
			    	      Power(1 + Power(E,10*(-Sqrt(3) + Sqrt(3)*a + b)),2)) - 
			    	   (10*Power(E,10*(-(Sqrt(3)*a) + b)))/
			    	    ((1 + Power(E,-10*b))*Power(1 + Power(E,10*(-(Sqrt(3)*a) + b)),2)*
			    	      (1 + Power(E,10*(-Sqrt(3) + Sqrt(3)*a + b)))) + 
			    	   10/(Power(E,10*b)*Power(1 + Power(E,-10*b),2)*
			    	      (1 + Power(E,10*(-(Sqrt(3)*a) + b)))*
			    	      (1 + Power(E,10*(-Sqrt(3) + Sqrt(3)*a + b))));
	}

	private double Power(double e2, double d) 
	{
		return Math.pow(e2,d);
	}
	
	private double Sqrt(double e2) 
	{
		return Math.sqrt(e2);
	}
}

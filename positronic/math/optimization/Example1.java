package positronic.math.optimization;

import positronic.math.IFunction2;

public class Example1 implements IFunction2
{
	public static final double E=Math.exp(1.);
	
	public static void main(String[] args) 
	{
		int divisions=100;
		int runs=200;
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
			res=Optima.optima(res,new Example1());
		
			String outp="{";
			for(int i=0;i<res.length-1;i++)
				outp+="{"+res[i][0]+","+res[i][1]+"},\n";
			outp+="{"+res[res.length-1][0]+","+res[res.length-1][1]+"}";
			outp+="}";
			System.out.println(outp);
		}
	}
	
	public double f(double x, double y) 
	{
		return Power(x,2) + y;
	}

	public double f1(double x, double y) 
	{
		return 2*x;
	}

	public double f2(double a, double b) 
	{
		return 1.;
	}

	private double Power(double e2, double d) 
	{
		return Math.pow(e2,d);
	}
}

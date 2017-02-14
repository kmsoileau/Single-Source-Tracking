package positronic.math.optimization;

import positronic.math.IFunction2;

public class BoxyValley implements IFunction2
{
	public static final double E=Math.exp(1.);
	
	public static void main(String[] args) 
	{
		int divisions=200;
		int runs=20;
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
			res=Optima.optima(res,new BoxyValley());
		
			String outp="{";
			for(int i=0;i<res.length-1;i++)
				outp+="{"+res[i][0]+","+res[i][1]+"},\n";
			outp+="{"+res[res.length-1][0]+","+res[res.length-1][1]+"}";
			outp+="}";
			System.out.println(outp);
		}
		
		System.exit(0);
	}
	
	public double f(double a, double b) {
		return a*b*(1 - 1/((1 + Power(E,-30*(1 - a)))*(1 + Power(E,-30*a))*
		        (1 + Power(E,-30*(1 - a - b)))*(1 + Power(E,-30*(a + b)))));
	}

	public double f1(double a, double b) 
	{
		return a*b*(-30/(Power(E,30*(a + b))*(1 + Power(E,-30*(1 - a)))*
		         (1 + Power(E,-30*a))*(1 + Power(E,-30*(1 - a - b)))*
		         Power(1 + Power(E,-30*(a + b)),2)) + 
		      30/(Power(E,30*(1 - a - b))*(1 + Power(E,-30*(1 - a)))*
		         (1 + Power(E,-30*a))*Power(1 + Power(E,-30*(1 - a - b)),2)*
		         (1 + Power(E,-30*(a + b)))) - 
		      30/(Power(E,30*a)*(1 + Power(E,-30*(1 - a)))*
		         Power(1 + Power(E,-30*a),2)*(1 + Power(E,-30*(1 - a - b)))*
		         (1 + Power(E,-30*(a + b)))) + 
		      30/(Power(E,30*(1 - a))*Power(1 + Power(E,-30*(1 - a)),2)*
		         (1 + Power(E,-30*a))*(1 + Power(E,-30*(1 - a - b)))*
		         (1 + Power(E,-30*(a + b))))) + 
		   b*(1 - 1/((1 + Power(E,-30*(1 - a)))*(1 + Power(E,-30*a))*
		         (1 + Power(E,-30*(1 - a - b)))*(1 + Power(E,-30*(a + b)))));
	}

	public double f2(double a, double b) 
	{
		return a*b*(-30/(Power(E,30*(a + b))*(1 + Power(E,-30*(1 - a)))*
		         (1 + Power(E,-30*a))*(1 + Power(E,-30*(1 - a - b)))*
		         Power(1 + Power(E,-30*(a + b)),2)) + 
		      30/(Power(E,30*(1 - a - b))*(1 + Power(E,-30*(1 - a)))*
		         (1 + Power(E,-30*a))*Power(1 + Power(E,-30*(1 - a - b)),2)*
		         (1 + Power(E,-30*(a + b))))) + 
		   a*(1 - 1/((1 + Power(E,-30*(1 - a)))*(1 + Power(E,-30*a))*
		         (1 + Power(E,-30*(1 - a - b)))*(1 + Power(E,-30*(a + b)))));
	}

	private double Power(double e2, double d) 
	{
		return Math.pow(e2,d);
	}

}

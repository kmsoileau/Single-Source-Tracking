package positronic.math.integration;

import positronic.math.FunctionOfOneVariable;
import positronic.math.FunctionOfTwoVariables;

public class SimpsonsRule 
{
	/**
	 * @param func is a function of one variable
	 * @param a is the initial value
	 * @param b is the end value
	 * @param n is the number of double intervals of size 2h
	 * @return the value of \int_a^b{func.f(x)dx
	 */
	public static double integral(FunctionOfOneVariable func,double a,double b,int n)
	{
		n*=2;
		double h =(b-a)/n;
		double s=func.f(a);
			 
		for(int i=1;i<=n;i+=2)
			s+=4*func.f(a+h*i);
			 
		for(int i=2;i<n;i+=2)
			s+=2*func.f(a+h*i);
			 
		s+=func.f(b);
		return h*s/3;
	}
	
	public static double integral(final FunctionOfTwoVariables func,double a1,double b1,final double a2,final double b2,
			int n1,final int n2)
	{
		return integral(new FunctionOfOneVariable()
		{
			public double f(final double x) 
			{
				return integral(new FunctionOfOneVariable()
				{
					public double f(double y) 
					{
						return func.f(x, y);
					}
				},a2,b2,n2);
			}
		},a1,b1,n1);
	}
	
	/*public static void main(String[] args) 
	{
		FunctionOfOneVariable func1=new FunctionOfOneVariable()
		{
			public double f(double x)
			{
				return Math.sin(x);
			}
		};
		System.out.println(integral(func1,0.,1.,1000));
		
		FunctionOfTwoVariables func2=new FunctionOfTwoVariables()
		{
			public double f(double x, double y)
			{
				return Math.sin(x)*Math.tan(x*y);
			}
		};
		System.out.println(integral(func2,1.,2.,3.,4.,1000,1000));
	}*/
	
	public static void main(String[] args) 
	{
		FunctionOfTwoVariables func2=new FunctionOfTwoVariables()
		{
			public double f(double x, double y)
			{
				return Math.sin(x)*Math.tan(x*y);
			}
		};
		System.out.println(integral(func2,1.,2.,3.,4.,1000,1000));
	}
}

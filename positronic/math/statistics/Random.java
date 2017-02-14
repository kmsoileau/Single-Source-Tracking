package positronic.math.statistics;

import java.util.List;

public class Random
{
	public static Object chooseOneRandomly(List<Object> list)
	{
		return chooseOneRandomly(list.toArray());
	}
	
	public static Object chooseOneRandomly(Object[] array)
	{
		if(array==null || array.length==0)
			return null;
		if(array.length==1)
			return array[0];
		return array[(int)(Math.random()*array.length)];
	}
	
	public static double[] normalDeviate()
	{
		double[] z=new double[2];
		double x1=Math.random();
		double x2=Math.random();
		double p=Math.sqrt(-2.*Math.log(x1));
		double q=2.*Math.PI*x2;
		z[0]=p*Math.cos(q);
		z[1]=p*Math.sin(q);
		return z;
	}
}

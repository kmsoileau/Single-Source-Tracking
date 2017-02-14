/*
 * @(#)ContinuedFraction.java	1.0 10/02/22
 *
 * Copyright 2010 Positronic Software. All Rights Reserved.
 *
 * This software is the proprietary information of Positronic Software.
 * Use is subject to license terms.
 *
 */
/**
 * 
 * @author  Kerry Michael Soileau
 * ksoileau@yahoo.com
 * http://kerrysoileau.com/index.html
 * @version 1.0, 10/02/22
 */
package positronic.math;

public class ContinuedFraction
{
	private static int count;
	
	public static String continuedFraction(double x)
	{
		count++;
		if(count>100) return ""+(long)x;
		if(x==Math.floor(x))
			return ""+(long)x;
		return ""+(long)Math.floor(x)+"+"+"1/("+continuedFraction(1/(x-Math.floor(x)))+")";
	}
	
	public static void main(String[] args)
	{
		System.out.println(continuedFraction(2.718281828));
	}
}
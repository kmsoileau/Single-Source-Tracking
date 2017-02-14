package positronic.ai.learner.shadow;

import positronic.ai.learner.IImage;

/**
 * <p>Title: Demo application of Learner object</p>
 * <p>Description: Adds any two numbers chosen from the interval [0.0,1.0] </p>
 * <p>Copyright (c) 2004</p>
 * <p>Company: Positronic Software</p>
 * @author Kerry M. Soileau
 * @version 1.0
 */

public class LearnerApp
{
	private static double f(double x, double y)
	{
		return (Power(x,2) + Power(y,2) < 0.06 || 
			    Power(-0.3 + x,2) + Power(-0.4 + y,2) < 0.02 || 
			    Power(-0.8 + x,2) + Power(-0.8 + y,2) < 0.02 || 
			    Power(-0.8 + x,2) + Power(-0.8 + y,2) < 0.02)?1:0;
	}

	public static void main(String[] args)
	{
		MyLearner lrn=new MyLearner(.01,.99);
	
	    for(int i=0;i<10000;i++)
	    {
	    	double first=Math.random();
	    	double second=Math.random();
	    	if(f(first,second)==1.)
	    		new Point(first,(IImage)new Image(1.)).train(lrn);
	    }
	    
	    System.out.println(lrn.toExcel());
	    System.out.println(lrn.size());
	}
	
	private static double Power(double y, int i) 
	{
		return Math.pow(y, 1.*i);
	}
}
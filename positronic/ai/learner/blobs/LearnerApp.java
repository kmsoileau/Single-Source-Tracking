package positronic.ai.learner.blobs;

import positronic.ai.learner.IImage;
import positronic.ai.learner.glint.Image;
import positronic.ai.learner.glint.Point;

/**
 * <p>Copyright (c) 2012</p>
 * <p>Company: Positronic Software</p>
 * @author Kerry M. Soileau
 * @version 1.0
 */

public class LearnerApp
{
	private static double f(double x, double y)
	{
		/*return (Power(x,2) + Power(y,2) < 0.06 || 
		    Power(-0.3 + x,2) + Power(-0.4 + y,2) < 0.02 || 
		    Power(-0.8 + x,2) + Power(-0.8 + y,2) < 0.02 || 
		    Power(-0.8 + x,2) + Power(-0.8 + y,2) < 0.02)?1d:0d;*/
		return x*y;
	}

	public static void main(String[] args)
	  {
	    for(int trials=100;trials<20000;trials+=100)
	    {
	    	MyLearner lrn=new MyLearner(.05,.99);
		    {
			    for(int i=0;i<trials;i++)
			    {
			    	double first=Math.random();
			    	double second=Math.random();
			    	new Point(first,second,(IImage)new Image(f(first,second))).train(lrn);
			    }
			    int ls=lrn.size();
			    //System.out.println(",{"+trials+","+ls+"}\t"+1.*ls/trials);
			    //System.out.println(",{"+String.format("%f",1./trials)+","+String.format("%f",1./ls)+"}\t");
			    System.out.println(String.format("%f",1./trials)+"\t"+String.format("%f",1./ls));
		    }
	    }
	  }
	
	
	
	/*private static double Power(double y, int i) 
	{
		return Math.pow(y, 1.*i);
	}*/
}
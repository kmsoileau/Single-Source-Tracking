package positronic.ai.learner.adder;

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
	public static void main(String[] args)
	{
		MyLearner lrn=new MyLearner(.01,.99);

		for(int i=0;i<10000;i++)
		{
			double first=Math.random();
			double second=Math.random();
			new Point(first,second,(IImage)new Image(first+second)).train(lrn);
		}
      
		System.out.println(lrn.toExcel());
		System.out.println(lrn.size());
	}
}
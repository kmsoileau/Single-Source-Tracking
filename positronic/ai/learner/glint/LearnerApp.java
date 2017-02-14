package positronic.ai.learner.glint;

import positronic.ai.learner.IImage;
import positronic.ai.learner.Learner;

public class LearnerApp
{
  public static void main(String[] args)
  {
    for(int trials=10000;trials<6500001;trials+=10000)
    {
    	Learner lrn=new Learner(.1,.9);
	    for(int i=0;i<trials;i++)
	    {
	    	double beta=2.*Math.PI*Math.random();
	    	double alpha=2.*Math.PI*Math.random();
	    	double lambda=Math.sin(alpha)/Math.sin(2.*alpha-beta)-1.;
	      
	    	if(lambda>.01 && lambda<.1)
	    		new Point(lambda,beta,(IImage)new Image(alpha)).train(lrn);
	    }
	    int ls=lrn.size();
	    System.out.println(",{"+trials+","+ls+"}\t"+1.*ls/trials);
    }
  }
}
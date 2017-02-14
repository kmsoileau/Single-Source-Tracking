package positronic.ai.learner.blobs;

import java.util.HashSet;
import java.util.Iterator;

import positronic.ai.learner.IPoint;
import positronic.ai.learner.Learner;

public class MyLearner extends Learner
{
	private static final long serialVersionUID = 2000691317562659776L;

	public MyLearner()
	{
	}

	public MyLearner(HashSet<IPoint> c, double tolerance, double quality)
	{
		super(c, tolerance, quality);
	}

	public MyLearner(double tolerance, double quality)
	{
		super(tolerance, quality);
	}

	public String toExcel()
  {
    Iterator<IPoint> it=super.iterator();
    String ret="";
    while(it.hasNext())
    {
    	IPoint ip=it.next();
    	ret+="\n"+((Point)ip).getX()+"\t"+((Point)ip).getY()+"\t"+((Image)((Point)ip).getImage()).getValue();
    }
    return ret;
  }
}

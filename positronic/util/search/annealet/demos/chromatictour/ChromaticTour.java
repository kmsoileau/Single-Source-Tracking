package positronic.util.search.annealet.demos.chromatictour;

import java.util.ArrayList;
import java.util.Collections;

import positronic.awt.geometry.Point;

public class ChromaticTour extends ArrayList<Point>
{
	private static final long serialVersionUID = 5227150301392735289L;

	public ChromaticTour(Problem problem) 
	{
		ArrayList<Integer> unused=new ArrayList<Integer>();
		unused.addAll(problem.genus);
		
		Collections.shuffle(problem.points);
		for(Point pt : problem.points)
		{
			if(unused.size()==0)
				break;
			Integer sp=problem.get(pt);
			if(unused.contains(sp))
			{
				super.add(pt);
				unused.remove(sp);
			}
		}
	}
	
	public double length()
	{
		double ret=0.;
		for(int i=0;i<this.size()-1;i++)
		{
			Point p1=super.get(i);
			Point p2=super.get(i+1);
			ret+=Math.sqrt((p2.x-p1.x)*(p2.x-p1.x)+(p2.y-p1.y)*(p2.y-p1.y));
		}
		return ret;
	}
}

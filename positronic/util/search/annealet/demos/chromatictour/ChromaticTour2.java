package positronic.util.search.annealet.demos.chromatictour;

import java.util.ArrayList;
import java.util.Set;

import positronic.awt.geometry.Point;
import positronic.math.statistics.Random;

public class ChromaticTour2 extends ArrayList<Point>
{
	private static final long serialVersionUID = 6477792006969522254L;

	public ChromaticTour2()
	{
		super();
	}
	
	public ChromaticTour2(Problem problem)
	{
		super();
		Integer curr=null;
		ArrayList<Integer> unvisited=new ArrayList<Integer>();
		Set<Integer> a = problem.triangles.keySet();
		unvisited.addAll(a);
		
		//Choose a triangle randomly
		curr = (Integer) Random.chooseOneRandomly(unvisited.toArray());
		ArrayList<Point> aTriangle0 = problem.triangles.get(curr);
		//Mark the triangle visited
		unvisited.remove(curr);
		//Choose triangle point randomly
		Point currPoint = (Point)Random.chooseOneRandomly(aTriangle0.toArray());
		//Add it to the path
		super.add(currPoint);
		//Continue building the tour until all triangles have been visited
		while(!unvisited.isEmpty())
		{
			//Choose an unvisited triangle randomly
			curr = (Integer) Random.chooseOneRandomly(unvisited.toArray());
			ArrayList<Point> aTriangle = problem.triangles.get(curr);
			//Mark the triangle visited
			unvisited.remove(curr);
			//Find closest point to currentPoint
			currPoint= currPoint.closestPoint(aTriangle);
		//Add it to the path
			super.add(currPoint);
		}
		
		if(super.size()>1)
		{
			Point newStart=super.get(1).closestPoint(aTriangle0);
			super.set(0, newStart);
		}
	}
	
	public double length()
	{
		double ret=0.;
		for(int i=0;i<this.size()-1;i++)
		{
			Point p1=super.get(i);
			Point p2=super.get(i+1);
			try
			{
				ret+=Math.sqrt((p2.x-p1.x)*(p2.x-p1.x)+(p2.y-p1.y)*(p2.y-p1.y));
			} catch (java.lang.NullPointerException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return ret;
	}

	public String prettyPrint()
	{
		String ret="";
		for(Point p : this)
			ret+=p.x+"\t"+p.y+"\n";
		return ret;
	}
}

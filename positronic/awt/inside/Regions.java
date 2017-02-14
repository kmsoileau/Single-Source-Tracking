package positronic.awt.inside;

import java.awt.Point;
import java.awt.Polygon;
import java.util.Calendar;

import positronic.math.EquivalenceRelation;

public class Regions 
{
	public static EquivalenceRelation equivalence(Polygon polygon, Point[] pointset)
	{
		EquivalenceRelation ret=new EquivalenceRelation();
		for(int i=0;i<pointset.length;i++)
			for(int j=i+1;j<pointset.length;j++)
				if(equivalent(polygon,pointset[i],pointset[j]))
					ret.add(pointset[i],pointset[j]);
		return ret;
	}
	
	/**
	 * Returns true if points p1 and p2 are either both inside or 
	 * both outside Polygon polygon. 
	 * @param polygon is an instance of java.awt.Polygon.
	 * @param p1 is an instance of java.awt.Point.
	 * @param p2 is an instance of java.awt.Point.
	 * @return boolean
	 */
	public static boolean equivalent(Polygon polygon, Point p1, Point p2)
	{
		if(polygon==null)
			return true;
		if(p1==null || p2==null)
			return false;
		if(polygon.contains(p1)&& polygon.contains(p2))
			return true;
		if(!polygon.contains(p1)&& !polygon.contains(p2))
			return true;
		return false;
	}
	
	/**
	 * Returns true if points p1 and p2 are either:
	 * inside ALL of the Polygons in the array polygons, or
	 * outside ALL of the Polygons in the array polygons. 
	 * @param polygons is an array of objects of class 
	 * java.awt.Polygon.
	 * @param p1 is an instance of java.awt.Point.
	 * @param p2 is an instance of java.awt.Point.
	 * @return boolean
	 */
	public static void main(String[] args) 
	{
		long start=Calendar.getInstance().getTimeInMillis();
		long finish=Calendar.getInstance().getTimeInMillis();
		long dur=finish-start;
		System.out.println(""+dur);
	}
}

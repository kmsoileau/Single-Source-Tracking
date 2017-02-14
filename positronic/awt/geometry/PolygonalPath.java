package positronic.awt.geometry;

import java.util.ArrayList;

public class PolygonalPath extends ArrayList<Point>
{
	private static final long serialVersionUID = 144713341979930395L;

	public static void main(String[] args)
	{
		PolygonalPath p1 = StandardEquilateralTriangle.randomInteriorPolygonalPath(10);
		PolygonalPath p2 = StandardEquilateralTriangle.randomInteriorPolygonalPath(10);
		System.out.println(p1.distance(p2));
	}
	
	public PolygonalPath()
	{
		super();
	}
	
	public PolygonalPath(Point[] pts)
	{
		for(Point p : pts)
			super.add(p);
	}
	
	public double distance(PolygonalPath p)
	{
		if(this.size()!=p.size())
			return Double.MAX_VALUE;
		double ret=0.;
		for(int i=0;i<this.size();i++)
			ret+=this.get(i).distance(p.get(i));
		return ret;
	}
	
	public double length()
	{
		if(super.size()<2)
			return 0.;
		double ret=0.;
		Point current=super.get(0);
		for(int i=1;i<super.size();i++)
		{
			Point n=super.get(i);
			ret+=n.distance(current);
			current=n;
		}
		return ret;
	}
}

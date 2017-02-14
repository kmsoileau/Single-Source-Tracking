package positronic.awt.geometry;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import positronic.math.vectoranalysis.twodimensional.Vector;

public class Point implements IPoint
{
	/**
	 * Given two Points p1 and p2, this method finds the Point bestPoint in points such that the distance 
	 * from p1 to p2 via bestPoint is minimized.
	 */
	public static Point bestHop(Point p1, Point p2, ArrayList<Point> points)
	{
		double bestLength=Double.POSITIVE_INFINITY;
		Point bestPoint=null;
		for(Point hop : points)
		{
			double l=p1.distance(hop)+p2.distance(hop);
			
			if(l<bestLength)
			{
				bestLength=l;
				bestPoint=hop;
			}
		}
		return bestPoint;
	}
	
	public static ArrayList<Integer> simpleTraversal(ArrayList<Point> points, double maxDistance)
	{
		ArrayList<Point> pointsVisited=new ArrayList<Point>();
		Point latest=points.get(0);
		ArrayList<Integer> ret=new ArrayList<Integer>();
		
		while(true)
		{
			ret.add(points.indexOf(latest));
			pointsVisited.add(latest);
			Point cp=null;
			double dist=Double.POSITIVE_INFINITY;
			while(true)
			{
				cp=latest.closestPoint(points, pointsVisited);
				if(cp==null)
					return ret;
				dist=latest.distance(cp);
				if(dist<=maxDistance)
				{
					latest=cp;
					break;
				}
				else
					pointsVisited.add(cp);
			}
		}
	}
	
	public double x;
	public double y;
	
	public Point(double x, double y)
	{
		this.x=x;
		this.y=y;
	}
	
	public Point(Point p)
	{
		this(p.x,p.y);
	}
	
	public Point closestPoint(ArrayList<Point> points)
	{
		double bestDistance=Double.POSITIVE_INFINITY;
		Point ret=null;
		if(points==null || points.isEmpty())
			return null;
		for(Point p : points)
		{
			double l=this.distance(p);
			if(l<bestDistance)
			{
				bestDistance=l;
				ret=p;
			}
		}
		return ret;
	}
	
	public Point closestPoint(ArrayList<Point> points, ArrayList<Point> exclusions)
	{
		double bestDistance=Double.POSITIVE_INFINITY;
		Point ret=null;
		if(points==null || points.isEmpty())
			return null;
		for(Point p : points)
		{
			if(exclusions!=null && exclusions.contains(p))
				continue;
			else
			{
				double l=this.distance(p);
				if(l<bestDistance)
				{
					bestDistance=l;
					ret=p;
				}
			}
		}
		return ret;
	}
	
	public double[] coordinates() 
	{
		double[] ret=new double[2];
		ret[0]=this.x;
		ret[1]=this.y;
		return ret;
	}
	
	public double[] crossproduct(Point q) 
	{
		return new double[]{0.,0.,this.x*q.y-this.y*q.x};
	}
	
	public double distance(Point p)
	{
		return Math.sqrt((this.x-p.x)*(this.x-p.x)+(this.y-p.y)*(this.y-p.y));
	}
	
	public boolean equals(Object o)
	{
		if(!(o instanceof Point))
			return false;
		if(this.toString().compareTo(((Point)o).toString())==0)
			return true;
		return false;
	}
	
	public double getX() 
	{
		return this.x;
	}
	
	public double getY() 
	{
		return this.y;
	}
	
	public int index(PositronicPolygon[] polys)
	{
		int ret=0;
		for(int i=0;i<polys.length;i++)
		{
			if(polys[i]==null) continue;
			if(polys[i].contains(this))
				ret=2*ret+1;
			else
				ret=2*ret;
		}
		return ret;
	}
	
	public boolean liesInLineSegment(LineSegment ls)
	{
		double px=this.x;
		double py=this.y;
		Point startpoint=ls.getStart();
		double sx=startpoint.x;
		double sy=startpoint.y;
		if(px==sx && py==sy)
			return true;
		Point finishpoint=ls.getFinish();
		double fx=finishpoint.x;
		double fy=finishpoint.y;
		if(px==fx && py==fy)
			return true;
		double denominator=(fx-sx)*(fx-sx)+(fy-sy)*(fy-sy);
		double numerator=(px-sx)*(fx-sx)+(py-sy)*(fy-sy);
		double lambda=numerator/denominator;
		double shadowx=sx+lambda*(fx-sx);
		if(px!=shadowx)
			return false;
		double shadowy=sy+lambda*(fy-sy);
		if(py!=shadowy)
			return false;
		return true;
	}
	
	public Set<LineSegment> lineSegmentsContaining(ArrayList<LineSegment> lslist)
	{
		Set<LineSegment> ret=new HashSet<LineSegment>();
		
		for(LineSegment ls : lslist)
			if(this.liesInLineSegment(ls))
					ret.add(ls);
		return ret;
	}

	public Point rotateAboutOrigin(double theta)
	{
		double x=this.x;
		double y=this.y;
		double c=Math.cos(theta);
		double s=Math.sin(theta);
		return new Point(x*c-y*s,x*s+y*c);
	}

	public String toString()
	{
		return "("+this.x+","+this.y+")";
	}

	public Vector toVector()
	{
		return new Vector(this.x,this.y);
	}

	public Point translate(double x,double y)
	{
		return new Point(this.x+x,this.y+y);
	}
}



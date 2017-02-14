package positronic.awt.geometry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Polygons
{
	private static final double DIVISIONS = 400;
	protected PositronicPolygon[] polygons;
	
	protected int dimension;

	
	public Polygons(int dimension)
	{
		this(new PositronicPolygon[dimension]);
	}

	public Polygons(PositronicPolygon[] polygons)
	{
		this.polygons=polygons;
		this.dimension=polygons.length;
	}
	
	public double[] bounds()
	{
		double[] ret=new double[4];
		ret[0]=Double.POSITIVE_INFINITY;
		ret[1]=Double.NEGATIVE_INFINITY;
		ret[2]=Double.POSITIVE_INFINITY;
		ret[3]=Double.NEGATIVE_INFINITY;
		
		for(PositronicPolygon p : this.polygons)
		{
			if(p==null) continue;
			for(int i=0;i<p.getNumberOfVertices();i++)
			{
				if(p.getXpoints()[i]<ret[0])
					ret[0]=p.getXpoints()[i];
				if(p.getXpoints()[i]>ret[1])
					ret[1]=p.getXpoints()[i];
				if(p.getYpoints()[i]<ret[2])
					ret[2]=p.getYpoints()[i];
				if(p.getYpoints()[i]>ret[3])
					ret[3]=p.getYpoints()[i];
			}
		}
		
		return ret;
	}

	public int countRegions()
	{
		return this.countRegions(generateGrid(this.bounds()));
	}

	public int countRegions(Set<InsidePoint> points)
	{
		if(this.polygons==null || this.polygons.length==0)
			return 0;
		
		Set<InsidePoint> rtytot=this.findRepresentativePoints(points);
		Set<InsidePoint> restot=this.filterPoints(rtytot);
		
		HashMap<InsidePoint,Integer> hashmap=new HashMap<InsidePoint,Integer>();
		for(InsidePoint pt : restot)
			if(!hashmap.values().contains(new Integer(pt.index(this.polygons))))
				hashmap.put(pt, pt.index(this.polygons));
		return hashmap.values().size();
	}
	
	public int dimension()
	{
		return this.dimension;
	}
	
	public Polygons duplicate()
	{
		Polygons ret=new Polygons(this.dimension);
		
		for(int i=0;i<ret.polygons.length;i++)
			try
			{
				ret.setPositronicPolygon(i,new PositronicPolygon(this.getPositronicPolygon(i).toLineSegmentArray()));
			} catch (ImproperlyFormedPolygonException e)
			{
				e.printStackTrace();
			}
		
		return ret;
	}
	
	public Set<Point> edgeIntersections()
	{
		Set<Point> ret=new HashSet<Point>();
		
		ArrayList<LineSegment> lslist=this.generateLineSegmentArrayList();
		for(LineSegment ls1 : lslist)
			for(LineSegment ls2 : lslist)
			{
				if(ls1==ls2)
					continue;
				Point p=ls1.intersectPoint(ls2);
				if(p==null)
					continue;
				ret.add(p);
			}
		return ret;
	}
	
	public Set<InsidePoint> filterPoints(Set<InsidePoint> points)
	{
		Set<InsidePoint> ret=new HashSet<InsidePoint>();
		for(PositronicPolygon poly : this.getPolygons())
		{
			if(poly==null) continue;
			for(InsidePoint p : points)
				if(!ret.contains(p) && poly.contains(p.x,p.y))
					ret.add(p);
		}
		return ret;
	}
	
	public Set<InsidePoint> findRepresentativePoints(Set<InsidePoint> points)
	{
		LineSegment[] LineSegments=this.generateLineSegmentArrayList().toArray(new LineSegment[0]);
		HashMap<InsidePoint,Integer> hashmap=new HashMap<InsidePoint,Integer>();
		for(InsidePoint p : points)
		{
			if(p==null)continue;
			int ind=p.index(LineSegments);
			
			boolean found=false;
			for(Integer i : hashmap.values())
				if(i.intValue()==ind)
				{
					found=true;
					break;
				}
			if(!found)
				hashmap.put(p,new Integer(ind));
		}
		return hashmap.keySet();
	}
	
	Set<InsidePoint> generateGrid(double[] bounds)
	{
		Set<InsidePoint> points=new HashSet<InsidePoint>();
		for(double x=bounds[0];x<=bounds[1];x+=(bounds[1]-bounds[0])/DIVISIONS)
			for(double y=bounds[2];y<=bounds[3];y+=(bounds[3]-bounds[2])/DIVISIONS)
				points.add(new InsidePoint(x,y));
		
		return points;
	}
	
	ArrayList<LineSegment> generateLineSegmentArrayList()
	{
		ArrayList<LineSegment> cumul=new ArrayList<LineSegment>();
		for(PositronicPolygon pp : this.polygons)
			if(pp!=null)
				cumul.addAll(Arrays.asList(pp.toLineSegmentArray()));
		
		return cumul;
	}
	
	public PositronicPolygon[] getPolygons()
	{
		return polygons;
	}
	
	public PositronicPolygon getPositronicPolygon(int i) 
	{
		return this.polygons[i];
	}
	
	public Set<LineSegment> lineSegmentsContaining(Point p)
	{
		LineSegment adhoc=new LineSegment(p,p);
		Set<LineSegment> ret=new HashSet<LineSegment>();
		
		ArrayList<LineSegment> lslist=this.generateLineSegmentArrayList();
		for(LineSegment ls : lslist)
			if(ls.intersects(adhoc))
					ret.add(ls);
		return ret;
	}
	
	public void setPositronicPolygon(int i, PositronicPolygon polygon) 
	{
		this.polygons[i]=polygon;
	}
}

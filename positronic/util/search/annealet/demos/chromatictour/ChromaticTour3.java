package positronic.util.search.annealet.demos.chromatictour;

import java.util.ArrayList;
import java.util.Set;

import positronic.awt.geometry.ImproperlyFormedPolygonException;
import positronic.awt.geometry.LineSegment;
import positronic.awt.geometry.Point;
import positronic.awt.geometry.PositronicPolygon;

public class ChromaticTour3 extends ArrayList<Point>
{
	private static final long serialVersionUID = -6897015831628243168L;

	private static Problem initializeProblem(int numberTriangles, int subdivisions)
	{
		Problem ret=new Problem();
		PositronicPolygon prototype=null;
		try
		{
			prototype = new PositronicPolygon(new Point[]{new Point(0.,0.),new Point(1.,0.),new Point(.5,Math.sqrt(.75))});
		} catch (ImproperlyFormedPolygonException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LineSegment[] lsap = prototype.toLineSegmentArray();
		
		ArrayList<Point> accum=new ArrayList<Point>();
		for(LineSegment ls : lsap)
		{
			Point[] r = ls.subdivide(subdivisions);
			for(Point p : r)
				if(!accum.contains(p))
					accum.add(p);
			accum.add(ls.getStart());
			accum.add(ls.getFinish());
		}
		
		Point[] points=new Point[accum.size()];
		for(int i=0;i<accum.size();i++)
			points[i]=accum.get(i);
		
		PositronicPolygon pp=null;
		try
		{
			pp = new PositronicPolygon(points);
		} catch (ImproperlyFormedPolygonException e)
		{
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
		double[] xp = pp.getXpoints();
		double[] yp = pp.getYpoints();
		for(int i=0;i<xp.length;i++)
			ret.addPoint(xp[i],yp[i],1);
		
		for(int j=2;j<=numberTriangles;j++)
		{
			double candx=Math.random();
			double candy=Math.random();
			
			while(!pp.contains(candx, candx))
			{
				candx=Math.random();
				candy=Math.random();
			}
			PositronicPolygon pp1=null;
			try
			{
				pp1 = pp.translate(-candx,-candy);
			} catch (ImproperlyFormedPolygonException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			double theta=2.*Math.PI*Math.random();
			PositronicPolygon pp2=null;
			try
			{
				pp2 = pp1.rotateAboutOrigin(theta);
			} catch (ImproperlyFormedPolygonException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			double[] xp1 = pp2.getXpoints();
			double[] yp1 = pp2.getYpoints();
			for(int i=0;i<xp1.length;i++)
				ret.addPoint(xp1[i],yp1[i],j);
		}
		return ret;
	}
	
	public static void main(String[] args) throws Exception
	{
		Problem problem=initializeProblem(6,10);
		double bestLength=Double.POSITIVE_INFINITY;
		ChromaticTour3 bestTour=null;
		while(bestLength>1.9)
		{
			ChromaticTour3 c2=new ChromaticTour3(problem);
			double l=c2.length();
			if(l<bestLength)
			{
				bestLength=l;
				bestTour=c2;
			}
		}
		System.out.println(bestTour.prettyPrint());
		System.out.println(bestTour.length());
		System.out.println(bestTour.size());
	}
	
	public ChromaticTour3()
	{
		super();
	}

	public ChromaticTour3(Problem problem)
	{
		super();
		Integer curr=null;
		ArrayList<Integer> unvisited=new ArrayList<Integer>();
		Set<Integer> a = problem.triangles.keySet();
		unvisited.addAll(a);
		
		Problem copy=new Problem(problem);
		//Find the topmost point
		Point topPoint = topMostPoint(copy);
		//Add it to the path
		super.add(topPoint);
		//Find the triangle containing it
		curr=copy.getSpecies(topPoint);
		//Mark the triangle visited
		unvisited.remove(curr);
		//Remove it from copy
		//System.out.println("Before removing "+curr+":"+copy);
		copy=new Problem(copy,unvisited);
		//System.out.println("After removing "+curr+":"+copy);
		
		while(!unvisited.isEmpty())
		{
			//Find the topmost point
			topPoint = topMostPoint(copy);
			//Add it to the path
			super.add(topPoint);
			//Find the triangle containing it
			curr=copy.getSpecies(topPoint);
			//Mark the triangle visited
			unvisited.remove(curr);
			//Remove it from copy
			copy=new Problem(copy,unvisited);
		}
	}
	
	/*public ChromaticTour3 trySubreverse()
	{
		ChromaticTour3 ret=new ChromaticTour3();
		int p1=(int)(Math.random()*this.size());
		int p2=(int)(Math.random()*this.size());
		if(p2<p1)
		{
			int dum=p1;
			p1=p2;
			p2=dum;
		}
		ArrayList<Point> reversedArray=new ArrayList<Point>();
		for(int i=p1;i<=p2;i++)
			reversedArray.add(this.get(p1+p2-i));
		for(int i=0;i<p1;i++)
			ret.add(this.get(i));
		for(int i=p1;i<=p2;i++)
			ret.add(reversedArray.get(i-p1));
		for(int i=p2+1;i<this.size();i++)
			ret.add(this.get(i));
		return ret;
	}*/
	
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

	private String prettyPrint()
	{
		String ret="";
		for(Point p : this)
			ret+=p.x+"\t"+p.y+"\n";
		return ret;
	}

	private Point topMostPoint(Problem problem) 
	{
		Point top=null;
		double highestHeight=Double.NEGATIVE_INFINITY;
		for(Point p : problem.keySet())
		{
			if(p.y>highestHeight)
			{
				highestHeight=p.y;
				top=p;
			}
		}
		return top;
	}
}

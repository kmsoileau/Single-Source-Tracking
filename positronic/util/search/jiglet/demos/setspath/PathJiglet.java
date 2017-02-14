package positronic.util.search.jiglet.demos.setspath;

import java.util.ArrayList;

import positronic.awt.geometry.ImproperlyFormedPolygonException;
import positronic.awt.geometry.LineSegment;
import positronic.awt.geometry.Point;
import positronic.awt.geometry.PositronicPolygon;
import positronic.util.search.jiglet.IVertex;
import positronic.util.search.jiglet.Jiglet;

public class PathJiglet extends Jiglet
{
	public static IVertex bestVertex=null;
	public static double bestValue=Double.POSITIVE_INFINITY;
	static int jiggleLimit=10;
	static int unsuccessfulJiggles=0;
	
	static ArrayList<Point> rotatedTriangle(double theta) throws ImproperlyFormedPolygonException
	{
		Point p1=new Point(0.,0.);
		Point p2=new Point(1.,0.);
		Point p3=new Point(.5,Math.sqrt(3.)/2.);
		LineSegment[] edges=new LineSegment[]{new LineSegment(p1,p2),new LineSegment(p2,p3),new LineSegment(p3,p1)};
		PositronicPolygon triangle=new PositronicPolygon(edges);
		triangle=triangle.rotateAboutOrigin(theta);
		Point[] sd1=edges[0].subdivide(100);
		Point[] sd2=edges[1].subdivide(100);
		Point[] sd3=edges[2].subdivide(100);
		ArrayList<Point> ret=new ArrayList<Point>();
		for(Point p:sd1)
			ret.add(p);
		for(Point p:sd2)
			ret.add(p);
		for(Point p:sd3)
			ret.add(p);
		return ret;
	}
	
	public static void main(String[] args) throws ImproperlyFormedPolygonException 
	{
		
		PathVertex.set=new ArrayList<ArrayList<Point>>();
		
		for(double theta=0.;theta<2.*Math.PI;theta+=.1)
			PathVertex.set.add(rotatedTriangle(theta));
		
		for(int i=0;i<100;i++)
		{
			PathJiglet hss=new PathJiglet();
			hss.setTrials(1000);
			hss.start();
		}
		System.out.println(bestVertex);
		System.out.println(bestValue);
	}
	
	protected IVertex explore() 
	{
		return new PathVertex();
	}

	protected void init() 
	{
		super.currentVertex=new PathVertex();
	}

	protected boolean perTrial() 
	{
		if(unsuccessfulJiggles>jiggleLimit)
		{
			unsuccessfulJiggles=0;
			return false;
		}
			
		if(super.currentVertex.evaluate()<bestValue)
		{
			bestVertex = currentVertex;
			bestValue=bestVertex.evaluate();
		}
		else
			unsuccessfulJiggles++;
		return true;
	}

	protected void wrapup() 
	{
		//System.out.println("Finis");
	}
}




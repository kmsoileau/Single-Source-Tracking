package positronic.util.search.annealet.demos.chromatictour;

import java.util.ArrayList;

import positronic.awt.geometry.ImproperlyFormedPolygonException;
import positronic.awt.geometry.LineSegment;
import positronic.awt.geometry.Point;
import positronic.awt.geometry.PositronicPolygon;
import positronic.util.search.annealet.Annealet;

public class ChromaticTourAnnealet extends Annealet
{	
	public static void main(String[] args)
	{
		new ChromaticTourAnnealet();
	}

	private Problem problem;
		
	public ChromaticTourAnnealet()
	{
		initializeProblem();
		incumbent=new Ingot(problem);
		incumbent.show();
		//System.out.println(incumbent.evaluate());
		candidate=new Ingot(problem);
		candidate.show();
		//System.out.println(candidate.evaluate());
		best=new Ingot(problem);
		//best.show();
		//best.mutate();
		//best.show();
		
		coolingRate(0.9999);
		initialTemperature(50.);
		numberOfAttemptsPerTemperature(200);
		
		currentTemperature=initialTemperature();
		lowestEnergy=Integer.MAX_VALUE;
				
		while(continueAnnealing())//&&super.currentTemperature>.00001)
		{
			//System.out.println("\nLowest energy is "+Double.toString(lowestEnergy));	
			//best.show();
			//System.out.println("");
			//System.out.println("Temperature is "+currentTemperature);
		}
		System.out.println("Out of Continue Loop");
	}

	private void initializeProblem()
	{
		this.problem=new Problem();
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
			Point[] r = ls.subdivide(300);
			for(Point p : r)
				if(!accum.contains(p))
					accum.add(p);
		}
		
		//for(Point p : accum)
		//	System.out.println(p.x+"\t"+p.y);
		Point[] points=new Point[accum.size()];
		for(int i=0;i<accum.size();i++)
			points[i]=accum.get(i);
		//System.out.println(accum);
		
		PositronicPolygon pp=null;
		try
		{
			pp = new PositronicPolygon(points);
		} catch (ImproperlyFormedPolygonException e)
		{
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
		//System.out.println("pp");
		//System.out.println(pp);
		
		
		double[] xp = pp.getXpoints();
		double[] yp = pp.getYpoints();
		for(int i=0;i<xp.length;i++)
			problem.addPoint(xp[i],yp[i],1);
		
		for(int j=1;j<80;j++)
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
				problem.addPoint(xp1[i],yp1[i],j);
			//System.out.println(problem);
		}
	}
}




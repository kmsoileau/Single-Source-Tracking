package positronic.awt.geometry;

import java.util.ArrayList;
import java.util.List;

import positronic.math.EquivalenceRelation;

public class PositronicPolygon implements IPolygon
{
	public static ArrayList<IPolygon> contained(double x, double y, IPolygon[] polys)
	{
		return contained(new Point(x,y),polys);
	}

	public static ArrayList<IPolygon> contained(IPoint p, IPolygon[] polys)
	{
		ArrayList<IPolygon> ret=new ArrayList<IPolygon>();
		if(polys==null || polys.length==0)
			return ret;
		
		for(IPolygon pol : polys)
			if(pol.contains(p))
				ret.add(pol);
				
		return ret;
	}
	
	public static void main(String[] args)
	{
				Point[] pointArray=new Point[]
						{
						new Point(	-178.2966326	,	28.40224917	),
						new Point(	-173.9778595	,	26.06284332	),
						new Point(	-178.3078156	,	28.39489937	),
						new Point(	-175.7370911	,	27.92840195	),
						new Point(	-171.7514648	,	25.76016426	),
						new Point(	-167.9977112	,	25.00443077	),
						new Point(	-166.2182312	,	23.8612957	),
						new Point(	-166.1702271	,	23.73103714	),
						new Point(	-164.6892548	,	23.57468796	),
						new Point(	-161.9107666	,	23.06551361	),
						new Point(	-160.167471	,	21.932863	),
						new Point(	-159.758218	,	21.980694	),
						new Point(	-159.471962	,	21.88292	),
						new Point(	-159.295271	,	22.13039	),
						new Point(	-159.5411505	,	22.21676395	),
						new Point(	-159.786543	,	22.06369	),
						new Point(	-159.790932	,	22.031177	),
						new Point(	-158.250671	,	21.557373	),
						new Point(	-158.125459	,	21.330264	),
						new Point(	-157.8456165	,	21.28993646	),
						new Point(	-157.7106	,	21.3585	),
						new Point(	-157.8526246	,	21.49997074	),
						new Point(	-157.9923	,	21.708	),
						new Point(	-158.190704	,	21.585892	),
						new Point(	-157.9109254	,	21.30576826	),
						new Point(	-157.7932892	,	21.43765831	),
						new Point(	-157.039987	,	21.190909	),
						new Point(	-156.7560199	,	21.17802289	),
						new Point(	-156.953719	,	21.067761	),
						new Point(	-157.254061	,	21.090601	),
						new Point(	-157.257085	,	21.227268	),
						new Point(	-157.006243	,	20.849603	),
						new Point(	-156.809576	,	20.826036	),
						new Point(	-157.035789	,	20.927078	),
						new Point(	-156.667028	,	20.85832527	),
						new Point(	-156.448656	,	20.704739	),
						new Point(	-156.225338	,	20.62294	),
						new Point(	-155.984587	,	20.767496	),
						new Point(	-156.230159	,	20.931936	),
						new Point(	-156.510391	,	20.940358	),
						new Point(	-156.69411	,	20.952708	),
						new Point(	-156.5587273	,	20.59857679	),
						new Point(	-156.6666174	,	20.56106253	),
						new Point(	-156.6047545	,	20.5960302	),
						new Point(	-155.783242	,	20.246395	),
						new Point(	-155.502561	,	20.114155	),
						new Point(	-155.204486	,	19.969438	),
						new Point(	-155.063972	,	19.728917	),
						new Point(	-154.852618	,	19.549172	),
						new Point(	-154.9846625	,	19.34756884	),
						new Point(	-155.31337	,	19.250698	),
						new Point(	-155.555326	,	19.069377	),
						new Point(	-155.763598	,	18.981837	),
						new Point(	-155.90491	,	19.230147	),
						new Point(	-155.957033	,	19.52816187	),
						new Point(	-156.049651	,	19.780452	),
						new Point(	-155.828965	,	19.995542	),
						new Point(	-173.9778595	,	26.06284332	),
										
							
						};
				
				ArrayList<Point> points=new ArrayList<Point>();
				for(Point p : pointArray)
					points.add(p);
				ArrayList<Integer> s=Point.simpleTraversal(points, 16.);
				for(int i=0;i<s.size();i++)
					System.out.println(pointArray[s.get(i)].x+"\t"+pointArray[s.get(i)].y);
	}
	
	private double[] xpoints;
	private double[] ypoints;

	public PositronicPolygon(double[] x, double[] y) throws ImproperlyFormedPolygonException
	{
		setXpoints(new double[x.length]);
		setYpoints(new double[x.length]);
		
		for(int i=0;i<x.length;i++)
		{
			getXpoints()[i]=x[i];
			getYpoints()[i]=y[i];
		}
		
		LineSegment[] test=this.toLineSegmentArray();
		for(int i=0;i<this.getNumberOfVertices();i++)
			for(int j=i+1;j<this.getNumberOfVertices();j++)
			{
				double lambda=test[i].intersectPosition(test[j]);
				if(lambda!=0. && lambda!=1. && lambda!=Double.MAX_VALUE)
					throw new ImproperlyFormedPolygonException("Edges of polygon cross at midsections: "+test[i]+"\t"+test[j]);
			}
	}
	
	public PositronicPolygon(IPoint[] points) throws ImproperlyFormedPolygonException
	{
		setXpoints(new double[points.length]);
		setYpoints(new double[points.length]);
		
		for(int i=0;i<points.length;i++)
		{
			getXpoints()[i]=((Point)points[i]).x;
			getYpoints()[i]=((Point)points[i]).y;
		}
		
		LineSegment[] test=this.toLineSegmentArray();
		for(int i=0;i<this.getNumberOfVertices();i++)
			for(int j=i+1;j<this.getNumberOfVertices();j++)
			{
				double lambda=test[i].intersectPosition(test[j]);
				if(lambda!=0. && lambda!=1. && lambda!=Double.MAX_VALUE)
					throw new ImproperlyFormedPolygonException("Edges of polygon cross at midsections: "+test[i]+"\t"+test[j]);
			}
	}
	
	public PositronicPolygon(LineSegment[] edges) throws ImproperlyFormedPolygonException
	{
		setXpoints(new double[edges.length]);
		setYpoints(new double[edges.length]);
		
		for(int i=0;i<edges.length;i++)
		{
			getXpoints()[i]=edges[i].getStart().x;
			getYpoints()[i]=edges[i].getStart().y;
		}
		
		LineSegment[] test=this.toLineSegmentArray();
		for(int i=0;i<this.getNumberOfVertices();i++)
			for(int j=i+1;j<this.getNumberOfVertices();j++)
			{
				double lambda=test[i].intersectPosition(test[j]);
				if(lambda!=0. && lambda!=1. && lambda!=Double.MAX_VALUE)
					throw new ImproperlyFormedPolygonException("Edges of polygon cross at midsections: "+test[i]+"\t"+test[j]);
			}
	}
	
	public boolean contains(double x, double y)
	{
		int hits = 0;

		double lastx = getXpoints()[getNumberOfVertices()-1];
		double lasty = getYpoints()[getNumberOfVertices()-1];
		double curx, cury;

		// Walk the edges of the polygon
		for (int i = 0; i < getNumberOfVertices(); lastx = curx, lasty = cury, i++) 
		{
			curx = getXpoints()[i];
			cury = getYpoints()[i];

			if (cury == lasty) 
				continue;

			double leftx;
			if (curx < lastx) 
			{
				if (x >= lastx) 
					continue;
				leftx = curx;
			} 
			else 
			{
				if (x >= curx) 
					continue;
				leftx = lastx;
			}

			double test1, test2;
			if (cury < lasty) 
			{
				if (y < cury || y >= lasty) 
					continue;
				if (x < leftx) 
				{
					hits++;
					continue;
				}
				test1 = x - curx;
				test2 = y - cury;
			} 
			else 
			{
				if (y < lasty || y >= cury) 
					continue;
				if (x < leftx) 
				{
					hits++;
					continue;
				}
				test1 = x - lastx;
				test2 = y - lasty;
			}

			if (test1 < (test2 / (lasty - cury) * (lastx - curx))) 
				hits++;
		}
		return ((hits & 1) != 0);
	}
	
	public boolean contains(IPoint p)
	{
		return this.contains(((Point)p).x,((Point)p).y);
	}

	public EquivalenceRelation equivalence(List<Point> pointlist)
	{
		if(pointlist==null || pointlist.size()==0)
			return null;
		return equivalence((Point[])pointlist.toArray(new Point[0]));
	}

	public EquivalenceRelation equivalence(Point[] pointset)
	{
		EquivalenceRelation ret=new EquivalenceRelation();
		for(int i=0;i<pointset.length;i++)
			for(int j=i+1;j<pointset.length;j++)
				if(this.equivalent(pointset[i],pointset[j]))
					ret.add(pointset[i],pointset[j]);
		return ret;
	}

	/**
	 * This method returns true if the Points p1 and p2 are either both 
	 * inside or both outside this PositronicPolygon. Otherwise it returns 
	 * false.
	 */
	public boolean equivalent(Point p1, Point p2)
	{
		if(p1==null || p2==null)
			return false;
		if(this.contains(p1)&& this.contains(p2))
			return true;
		if(!this.contains(p1)&& !this.contains(p2))
			return true;
		return false;
	}

	/**
	 * This method returns the length of the array xpoints
	 * 
	 */
	public int getNumberOfVertices()
	{
		return getXpoints().length;
	}
	
	public double[] getXpoints()
	{
		return xpoints;
	}
	
	public double[] getYpoints()
	{
		return ypoints;
	}
	
	public Point[] intersectPointsArray(LineSegment e1)
	{
		ArrayList<Point> ret=new ArrayList<Point>();
		
		LineSegment[] lines=this.toLineSegmentArray();
		for(LineSegment l : lines)
		{
			Point p=e1.intersectPoint(l);
			if(p!=null)
				ret.add(p);
		}
		return (Point[])intersectPointsList(e1).toArray(new Point[0]);
	}

	public ArrayList<Point> intersectPointsList(LineSegment e1)
	{
		ArrayList<Point> ret=new ArrayList<Point>();
		
		LineSegment[] lines=this.toLineSegmentArray();
		for(LineSegment l : lines)
		{
			Point p=e1.intersectPoint(l);
			if(p!=null)
				ret.add(p);
		}
		return ret;
	}
	
	public PositronicPolygon rotateAboutOrigin(double theta) throws ImproperlyFormedPolygonException
	{
		LineSegment[] ary=this.toLineSegmentArray();
		LineSegment[] rary=new LineSegment[ary.length];
		for(int i=0;i<ary.length;i++)
		{
			//System.out.println(ary[i]);
			rary[i]=ary[i].rotateAboutOrigin(theta);
			//System.out.println("becomes "+rary[i]);
		}
		return new PositronicPolygon(rary);	
	}

	public void setXpoints(double[] xpoints)
	{
		this.xpoints = xpoints;
	}

	/**
	 * This method returns an array of Edge objects corresponding to the 
	 * PositronicPolygon.
	 * 
	 */
	/*public LineSegment[] toLineSegmentArray()
	{
		LineSegment[] lsArray=this.toLineSegmentArray();
		LineSegment[] LineSegmentArray=new LineSegment[lsArray.length];
		for(int i=0;i<LineSegmentArray.length;i++)
			LineSegmentArray[i]=new LineSegment(new InsidePoint(lsArray[i].getStart().x,lsArray[i].getStart().y),
					new InsidePoint(lsArray[i].getFinish().x,lsArray[i].getFinish().y));
		return LineSegmentArray;
	}*/

	public void setYpoints(double[] ypoints)
	{
		this.ypoints = ypoints;
	}

	/**
	 * This method returns an array of LineSegment objects corresponding to the 
	 * PositronicPolygon.
	 * 
	 */
	public LineSegment[] toLineSegmentArray()
	{
		LineSegment[] ret=new LineSegment[getNumberOfVertices()];
		for(int i=0;i<getNumberOfVertices()-1;i++)
			ret[i]=new LineSegment(new Point(getXpoints()[i],getYpoints()[i]),new Point(getXpoints()[i+1],getYpoints()[i+1]));
		ret[getNumberOfVertices()-1]=new LineSegment(new Point(getXpoints()[getNumberOfVertices()-1],getYpoints()[getNumberOfVertices()-1]),new Point(getXpoints()[0],getYpoints()[0]));
		return ret;
	}
	
	public String toString()
	{
		String ret="{";
		for(int i=0;i<this.getNumberOfVertices();i++)
			ret+="{"+this.getXpoints()[i]+","+this.getYpoints()[i]+"},";
		ret+="{"+this.getXpoints()[0]+","+this.getYpoints()[0]+"}}";
		return ret;
	}
	
	public PositronicPolygon translate(double x,double y) throws ImproperlyFormedPolygonException
	{
		LineSegment[] ary=this.toLineSegmentArray();
		for(int i=0;i<ary.length;i++)
			ary[i]=ary[i].translate(x,y);
		return new PositronicPolygon(ary);	
	}
}
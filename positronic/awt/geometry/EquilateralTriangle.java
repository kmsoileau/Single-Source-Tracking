package positronic.awt.geometry;

import positronic.math.vectoranalysis.twodimensional.Vector;

public class EquilateralTriangle extends PositronicPolygon implements IEnclosure 
{
	public static void main(String[] args)
	{
		Point[] test=new Point[]{
		new Point(0.3,0.),
		new Point(0.29850125,0.039933367),new Point(0.294019973,0.079467732)};
		
		/*Point[] test=new Point[]{
				new Point(0.3,0.),
				new Point(0.29850125,0.039933367),
				new Point(0.294019973,0.079467732),
				new Point(0.286600947,0.118208083),
				new Point(0.276318298,0.155767337),
				new Point(0.263274769,0.191770215),
				new Point(0.247600684,0.225856989),
				new Point(0.229452656,0.257687075),
				new Point(0.209012013,0.286942436),
				new Point(0.18648299,0.313330764),
				new Point(0.162090692,0.336588394),
				new Point(0.136078836,0.356482944),
				new Point(0.108707326,0.372815634),
				new Point(0.080249649,0.385423274),
				new Point(0.050990143,0.394179892),
				new Point(0.021221161,0.398997995),
				new Point(-0.008759857,0.399829441),
				new Point(-0.038653348,0.396665924),
				new Point(-0.068160628,0.389539052),
				new Point(-0.09698687,0.378520035),
				new Point(-0.124844051,0.363718971),
				new Point(-0.151453831,0.345283747),
				new Point(-0.176550335,0.323398562),
				new Point(-0.199882806,0.298282085),
				new Point(-0.221218115,0.270185272),
				new Point(-0.240343085,0.239388858),
				new Point(-0.257066626,0.206200549),
				new Point(-0.271221643,0.170951952),
				new Point(-0.282666702,0.13399526),
				new Point(-0.29128745,0.095699732),
				new Point(-0.296997749,0.056448003),
				new Point(-0.299740545,0.016632265),
				new Point(-0.299488433,-0.023349657),
				new Point(-0.296243931,-0.063098278),
				new Point(-0.290039458,-0.102216441),
				new Point(-0.280937006,-0.140313291),
				new Point(-0.269027525,-0.177008177),
				new Point(-0.25443001,-0.211934456),
				new Point(-0.237290314,-0.244743156),
				new Point(-0.217779691,-0.275106464),
				new Point(-0.196093086,-0.302720998),
				new Point(-0.172447184,-0.327310844),
				new Point(-0.147078246,-0.348630309),
				new Point(-0.120239752,-0.366466375),
				new Point(-0.092199861,-0.38064083),
				new Point(-0.06323874,-0.391012047),
				new Point(-0.033645758,-0.397476401),
				new Point(-0.003716599,-0.399969303),
				new Point(0.026249695,-0.398465844),
				new Point(0.055953711,-0.392981045),
				new Point(0.085098656,-0.38356971),
				new Point(0.113393323,-0.370325873),
				new Point(0.140555001,-0.353381862),
				new Point(0.166312301,-0.332906977),
				new Point(0.190407863,-0.309105795),
				new Point(0.212600932,-0.28221613),
				new Point(0.232669764,-0.252506655),
				new Point(0.250413835,-0.220274217),
				new Point(0.265655855,-0.185840872),
				new Point(0.278243529,-0.149550666),
				new Point(0.288051086,-0.111766199),
				new Point(0.294980532,-0.072865002),
				new Point(0.298962629,-0.033235761),
				new Point(0.3,0.)};*/

		System.out.println("Test points:");
		for(int i=0;i<test.length;i++)
			System.out.println(test[i].x+"\t"+test[i].y);
		IEnclosure bestTri=null;
		double bestMeasure=Double.POSITIVE_INFINITY;
		double leastDistance=Double.POSITIVE_INFINITY;
		double lastMeasure=Double.POSITIVE_INFINITY;
		double measure=0.;
		while(leastDistance>.001 || Math.abs(measure-lastMeasure)>.000001)
		{
			try 
			{
				IEnclosure tri = new EquilateralTriangle(
						new Point(4*Math.random()-2,4*Math.random()-2),
						new Point(4*Math.random()-2,4*Math.random()-2));
				if(tri.containsAll(test))
				{
					lastMeasure=measure;
					measure=tri.measure();
					if(measure<bestMeasure)
					{
						Point p=tri.closestPoint(test);
						leastDistance=tri.leastDistance(p);
						System.out.println("Current least distance:\t"+leastDistance);
						bestTri=tri;
						bestMeasure=measure;
					}
				}
			} 
			catch (ImproperlyFormedPolygonException e) 
			{
				e.printStackTrace();
			}
		}
		double[] xs=bestTri.getXpoints();
		double[] ys=bestTri.getYpoints();
		Point[] pts=bestTri.getPoints();
		System.out.println("Best Triangle vertices:");
		System.out.println(xs[0]+"\t"+ys[0]+"\n"+xs[1]+"\t"+ys[1]+"\n"+xs[2]+"\t"+ys[2]);
		System.out.println(pts[0]+"\t"+pts[1]+"\t"+pts[2]);
		System.out.println("Measure:");
		System.out.println(bestMeasure);
		Point p=bestTri.closestPoint(test);
		System.out.println("Closest point:");
		System.out.println(p);
		System.out.println("Distance:");
		System.out.println(bestTri.leastDistance(p));
	}
	
	public EquilateralTriangle(EquilateralTriangle tri) throws ImproperlyFormedPolygonException 
	{
		this(tri.getPoints());
	}
	
	public EquilateralTriangle(Point p1, Point p2) throws ImproperlyFormedPolygonException 
	{
		super(new Point[]{p1,p2,new Point(p1.x*.5+p2.x*.5+p1.y*Math.sqrt(3)/2+p2.y*(-Math.sqrt(3)/2),
				p1.x*(-Math.sqrt(3)/2)+p2.x*Math.sqrt(3)/2+p1.y*.5+p2.y*.5)});
	}
	
	public EquilateralTriangle(Point[] pts) throws ImproperlyFormedPolygonException 
	{
		this(pts[0],pts[1]);
	}
	
	public Point centroid()
	{
		double[] xs=this.getXpoints();
		double[] ys=this.getYpoints();
		double cx=(xs[0]+xs[1]+xs[2])/3;
		double cy=(ys[0]+ys[1]+ys[2])/3;
		return new Point(cx,cy);
	}
	
	public EquilateralTriangle centroidScale(double scaleFactor) throws ImproperlyFormedPolygonException
	{
		if(scaleFactor<=0.)
			return null;
		
		Point[] pts=this.getPoints();
		Vector centroid=(Vector) this.centroid().toVector().multiply(1-scaleFactor);
		Vector ar=(Vector) centroid.plus(pts[0].toVector().multiply(scaleFactor));
		Vector br=(Vector) centroid.plus(pts[1].toVector().multiply(scaleFactor));
		
		return new EquilateralTriangle(new Point(ar.get(0),ar.get(1)),
				new Point(br.get(0),br.get(1)));
	}
	
	public Point closestPoint(Point[] pts)
	{
		if(pts==null || pts.length==0)
			return null;
		Point closest=null;
		double leastDistance=Double.NEGATIVE_INFINITY;
		for(Point p : pts)
		{
			double dist=this.leastDistance(p);
			if(closest==null || dist<leastDistance)
			{
				closest=p;
				leastDistance=dist;
			}
		}
		return closest;
	}
	
	public boolean contains(double x, double y)
	{
		return super.contains(x,y);
	}
	
	public boolean contains(Point p)
	{
		return super.contains(p);
	}
	
	public boolean containsAll(Point[] pts)
	{
		if(pts==null || pts.length==0)
			return true;
		for(Point p : pts)
			if(!this.contains(p))
				return false;
		return true;
	}
	
	public EquilateralTriangle duplicate(EquilateralTriangle tri) throws ImproperlyFormedPolygonException
	{
		double[] xs=tri.getXpoints();
		double[] ys=tri.getYpoints();
		Point p1=new Point(xs[0],ys[0]);
		Point p2=new Point(xs[1],ys[1]);
		return new EquilateralTriangle(p1,p2);
	}
	
	public Point[] getPoints()
	{
		double[] xs=this.getXpoints();
		double[] ys=this.getYpoints();
		Point[] ret=new Point[xs.length];
		for(int i=0;i<ret.length;i++)
			ret[i]=new Point(xs[i],ys[i]);
		return ret;
	}
	
	public double inclusionScore(double x, double y)
	{
		if(this.contains(x,y))
			return 0.;
		double ld=this.leastDistance(x,y);
		return 10000*Math.exp(ld);
	}
	
	public double inclusionScore(Point p)
	{
		return this.inclusionScore(p.x,p.y);
	}
	
	public double inclusionScore(Point[] p)
	{
		double ret=this.perimeter();
		for(Point pt : p)
			ret+=this.inclusionScore(pt);
		return ret;
	}
	
	public double leastDistance(double x, double y)
	{
		LineSegment[] side=this.toLineSegmentArray();
		double leastDistance=Double.POSITIVE_INFINITY;
		for(LineSegment l : side)
		{
			double current=l.distance(new Point(x,y));
			if(current<leastDistance)
				leastDistance=current;
		}
		return leastDistance;
	}

	public double leastDistance(Point p)
	{
		return this.leastDistance(p.x,p.y);
	}
	
	public double measure() 
	{
		return this.perimeter()/3;
	}
	
	public double perimeter() 
	{
		Point[] pts=this.getPoints();
		Point p1=pts[0];
		Point p2=pts[1];
		return 3*p1.distance(p2);
	}

	public String toString()
	{
		double[] xs=this.getXpoints();
		double[] ys=this.getYpoints();
		return xs[0]+"\t"+ys[0]+"\n"+xs[1]+"\t"+ys[1]+"\n"+xs[2]+"\t"+ys[2];
	}
}

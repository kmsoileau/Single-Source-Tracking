package positronic.awt.geometry;

import java.util.ArrayList;
import java.util.Set;

public class LineSegment
{
	public static void main(String[] args)
	{
		LineSegment ls1=new LineSegment(new Point(1.,2.),new Point(3.,3.));
		LineSegment ls2=new LineSegment(new Point(4.,1.),new Point(2.,4.));
		System.out.println("Discriminant of "+ls1+" is "+ls1.getDiscriminant());
		System.out.println("Discriminant of "+ls2+" is "+ls2.getDiscriminant());
		System.out.println("Intersection position ls1.intersectPosition(ls2) is "+ls1.intersectPosition(ls2));
		System.out.println("Intersection position ls2.intersectPosition(ls1) is "+ls2.intersectPosition(ls1));
		System.out.println("Intersection point ls1.intersectPoint(ls2) is "+ls1.intersectPoint(ls2));
		System.out.println("Intersection point ls2.intersectPoint(ls1) is "+ls2.intersectPoint(ls1));
		Point ip=ls2.intersectPoint(ls1);
		ArrayList<LineSegment> lslist=new ArrayList<LineSegment>();
		lslist.add(ls1);
		lslist.add(ls2);
		Set<LineSegment> lsset=ip.lineSegmentsContaining(lslist);
		System.out.println(lsset);
		
		LineSegment ls3=new LineSegment(new Point(1.,2.),new Point(3.,3.));
		LineSegment ls4=new LineSegment(new Point(4.,1.),new Point(1.,2.));
		System.out.println("Intersection = "+ls3.intersects(ls4));
		System.out.println("The reverse of "+ls4+" is "+ls4.reverse());
		System.out.println(ls4.projection(new Point(0.,0.)));
		
		System.out.println("Intersection position ls3.intersectPosition(ls3) is "+ls3.intersectPosition(ls3));
		System.out.println("Intersect ls3.intersect(ls3) is "+ls3.intersects(ls3));
	}
	
	private Point start;
	private Point finish;
	
	public LineSegment(Point start, Point finish)
	{
		this.start=start;
		this.finish=finish;
	}
	
	public double distance(Point p)
	{
		return this.projection(p).distance(p);
	}
	
	//Returns true if the endpoints of this and obj are congruent.
	public boolean equals(Object obj)
	{
		if(!(obj instanceof LineSegment))
			return false;
		LineSegment ls=(LineSegment)obj;
		if(this.toString().compareTo(ls.toString())==0 
				|| this.reverse().toString().compareTo(ls.toString())==0)
			return true;
		return false;
	}
	
	public double getDiscriminant() 
	{
		return this.getFinish().x*this.getStart().y-this.getFinish().y*this.getStart().x;
	}
	
	public Point getFinish() 
	{
		return finish;
	}
	
	public Point getStart() 
	{
		return start;
	}
	
	/*
	 * If this and e1 have a point in common, this method returns true, else returns false.
	 */
	public boolean intersects(LineSegment e1)
	{
		if(this.equals(e1))
			return true;
		if(this.start.equals(e1.start)
				||this.start.equals(e1.finish)
				||this.finish.equals(e1.finish))
			return true;
		if(this.intersectPoint(e1)==null)
			return false;
		return true;
	}
	
	/*
	 * If this and e1 have a point in common, this method returns it, 
	 * else returns null.
	 */
	public Point intersectPoint(LineSegment e1)
	{
		double den=-this.getStart().y*e1.getStart().x+this.getStart().y*e1.getFinish().x+this.getFinish().y*e1.getStart().x-this.getFinish().y*e1.getFinish().x-this.getStart().x*e1.getFinish().y+this.getStart().x*e1.getStart().y+this.getFinish().x*e1.getFinish().y-this.getFinish().x*e1.getStart().y;
		double num1 = -this.getStart().y*e1.getStart().x+this.getStart().y*e1.getFinish().x-e1.getStart().y*e1.getFinish().x-this.getStart().x*e1.getFinish().y+e1.getFinish().y*e1.getStart().x+this.getStart().x*e1.getStart().y;
		double num2 = -this.getStart().y*e1.getStart().x+this.getFinish().x*this.getStart().y-this.getFinish().y*this.getStart().x+this.getFinish().y*e1.getStart().x+this.getStart().x*e1.getStart().y-this.getFinish().x*e1.getStart().y;
		
		if(den<0.)
			if(num1>0. || num1<den || num2>0. || num2<den)
				return null;
		if(den==0.)
			return null;
		if(den>0.)
			if(num1<0. || num1>den || num2<0. || num2>den)
				return null;
		
		double lambda1 = num1/den;
		double intx=(1.-lambda1)*this.getStart().x+lambda1*this.getFinish().x;
		double inty=(1.-lambda1)*this.getStart().y+lambda1*this.getFinish().y;
		
		return new Point(intx,inty);
	}

	public double intersectPosition(LineSegment e1)
	{
		double den=-this.getStart().y*e1.getStart().x+this.getStart().y*e1.getFinish().x+this.getFinish().y*e1.getStart().x-this.getFinish().y*e1.getFinish().x-this.getStart().x*e1.getFinish().y+this.getStart().x*e1.getStart().y+this.getFinish().x*e1.getFinish().y-this.getFinish().x*e1.getStart().y;
		double num1 = -this.getStart().y*e1.getStart().x+this.getStart().y*e1.getFinish().x-e1.getStart().y*e1.getFinish().x-this.getStart().x*e1.getFinish().y+e1.getFinish().y*e1.getStart().x+this.getStart().x*e1.getStart().y;
		double num2 = -this.getStart().y*e1.getStart().x+this.getFinish().x*this.getStart().y-this.getFinish().y*this.getStart().x+this.getFinish().y*e1.getStart().x+this.getStart().x*e1.getStart().y-this.getFinish().x*e1.getStart().y;
		
		if(den<0.)
			if(num1>0. || num1<den || num2>0. || num2<den)
				return Double.MAX_VALUE;
		if(den==0.)
			return Double.MAX_VALUE;
		if(den>0.)
			if(num1<0. || num1>den || num2<0. || num2>den)
				return Double.MAX_VALUE;
		
		return Math.round(1000000.*num1/den)/1000000.;
	}
	
	//Returns the point on this which lies a distance d from this.start
	public Point mark(double d) 
	{
		if(d<0. || d>this.size())
			return null;
		Point p1=this.start;
		Point p2=this.finish;
		double f=d/this.size();
		double x=p1.x*(1-f)+p2.x*f;
		double y=p1.y*(1-f)+p2.y*f;
		return new Point(x,y);
	}
	
	/**
	 * Returns the Point of the line containing this with minimal distance to the Point p. 
	 * This Point may not lie in this.
	 */
	public Point projection(Point p)
	{
		Point s=this.getStart();
		Point f=this.getFinish();
		double fminsx=f.x-s.x;
		double fminsy=f.y-s.y;
		double denominator=fminsx*fminsx+fminsy*fminsy;
		if(denominator==0.)
			return s;
		double fminpx=f.x-p.x;
		double fminpy=f.y-p.y;
		double numerator=fminpx*fminsx+fminpy*fminsy;
		double lambda=numerator/denominator;
		return new Point(lambda*s.x+(1-lambda)*f.x,lambda*s.y+(1-lambda)*f.y);
	}
	
	public LineSegment reverse()
	{
		return new LineSegment(this.getFinish(),this.getStart());
	}
	
	public LineSegment rotateAboutOrigin(double theta)
	{
		return new LineSegment(this.start.rotateAboutOrigin(theta),this.finish.rotateAboutOrigin(theta));
	}
	
	//Randomly choose a point uniformly along this
	public Point sample() 
	{
		double t=Math.random();
		return new Point(this.start.x*(1.-t)+this.finish.x*t,this.start.y*(1.-t)+this.finish.y*t);
	}
	
	public double size() 
	{
		double dx=this.finish.x-this.start.x;
		double dy=this.finish.y-this.start.y;
		
		return Math.sqrt(dx*dx+dy*dy);
	}
	
	//Returns a Point array containing the new points produced when the LineSegment is subdivided into n subintervals. The start and 
	//finish points of the LineSegment are not included in the returned array.
	public Point[] subdivide(int n) 
	{
		if(n<1)
			return null;
		if(n==1)
			return new Point[]{this.start,this.finish};
		double incrX=(this.finish.x-this.start.x)/n;
		double incrY=(this.finish.y-this.start.y)/n;
		Point[] ret=new Point[n-1];
		for(int i=0;i<n-1;i++)
			ret[i]=new Point(this.start.x+incrX*(i+1),this.start.y+incrY*(i+1));
		return ret;
	}
	
	public ArrayList<Point> subdivideArray(int n)
	{
		Point[] r=this.subdivide(n);
		if(r==null)
			return null;
		ArrayList<Point> ret=new ArrayList<Point>();
		for(Point p : r)
			ret.add(p);
		return ret;
	}

	public LineSegment[] subSegmentsArray(int n)
	{
		if(n<1)
			return null;
		LineSegment[] ret=new LineSegment[n];
		Point[] p=this.subdivide(n);
		for(int i=0;i<p.length-1;i++)
		{
			Point start=p[i];
			Point finish=p[i+1];
			ret[i]=new LineSegment(start,finish);
		}
		return ret;
	}

	public String toString()
	{
		return "$"+this.getStart()+"->"+this.getFinish()+"$";
	}

	public LineSegment translate(double x,double y)
	{
		return new LineSegment(this.start.translate(x,y),this.finish.translate(x,y));
	}
}
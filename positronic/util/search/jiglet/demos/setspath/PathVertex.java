package positronic.util.search.jiglet.demos.setspath;

import java.util.ArrayList;

import positronic.awt.geometry.Point;
import positronic.util.search.jiglet.IVertex;

public class PathVertex implements IVertex
{
	public static ArrayList<ArrayList<Point>> set;
	private ArrayList<Point> path;
	
	public PathVertex()
	{
		this.path=new ArrayList<Point>();
		for(int i=0;i<set.size();i++)
			if(pointsFromSet(i)==0)
				this.path.add(pickAPointFromSet(i));
		while(this.path.size()<this.dimension())
			this.path.add(pickAPointFromSet((int)(set.size()*Math.random())));
		while(this.path.size()>this.dimension())
			this.path.remove(0);
	}
	
	public int dimension() 
	{
		return set.size();
	}

	public IVertex duplicate() 
	{
		PathVertex m=new PathVertex();
		for(int i=0;i<this.dimension();i++)
			m.path.set(i, this.path.get(i));
		return m;
	}
	
	public double evaluate() 
	{
		for(int i=0;i<set.size();i++)
			if(!this.meets(set.get(i)))
					return Double.MAX_VALUE;
		return this.length();
	}

	//unused
	public int getCoordinate(int i) 
	{
		return 0;
	}

	private ArrayList<Point> getSet(int i)
	{
		return PathVertex.set.get(i);
	}
	
	private double length()
	{
		double length=0d;
		for(int i=0;i<this.dimension()-1;i++)
		{
			double x1=this.path.get(i).x;
			double y1=this.path.get(i).y;
			double x2=this.path.get(i+1).x;
			double y2=this.path.get(i+1).y;
			length+=Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
		}
		return length;
	}

	private boolean meets(ArrayList<Point> someSet)
	{
		for(Point p:this.path)
			if(someSet.contains(p))
				return true;
		return false;
	}
	
	private Point pickAPointFromSet(int i) 
	{
		ArrayList<Point> curr=this.getSet(i);
		return curr.get((int)(curr.size()*Math.random()));
	}
	
	private int pointsFromSet(int i)
	{
		int count=0;
		ArrayList<Point> curr=this.getSet(i);
		for(Point p:this.path)
			if(curr.contains(p))
				count++;
		return count;
	}

	//unused
	public void setCoordinate(int i, int n) 
	{
		;
	}
	
	public String toString()
	{
		String ret="$";
		for(int i=0;i<this.dimension();i++)
			ret+=this.path.get(i)+",";
		return ret+"] "+this.evaluate();
	}
}
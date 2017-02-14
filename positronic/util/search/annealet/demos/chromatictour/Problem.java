package positronic.util.search.annealet.demos.chromatictour;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import positronic.awt.geometry.Point;

public class Problem extends HashMap<Point,Integer>
{
	private static final long serialVersionUID = 4902047227997276088L;
	public ArrayList<Point> points;
	public HashSet<Integer> genus;
	public HashMap<Integer,ArrayList<Point>> triangles;

	public Problem() 
	{
		this.points=new ArrayList<Point>();
		this.genus=new HashSet<Integer>();
		this.triangles=new HashMap<Integer,ArrayList<Point>>();
	}
	
	public Problem(Problem prob) 
	{
		this();
		for(Point p : prob.points)
			this.addPoint(p.x,p.y,prob.getSpecies(p));
	}
	
	public Problem(Problem prob, ArrayList<Integer> include) 
	{
		this();
		if(!include.isEmpty())
			for(Point p : prob.points)
			{
				Integer species=prob.getSpecies(p);
				if(include.contains(species))
					this.addPoint(p.x,p.y,prob.getSpecies(p));
			}
	}

	public void addPoint(double x, double y, int species)
	{
		Point p=new Point(x,y);
		this.points.add(p);
		super.put(p, species);
		this.genus.add(species);
		ArrayList<Point> curr = this.triangles.get(species);
		if(curr==null)
		{
			ArrayList<Point> a=new ArrayList<Point>();
			this.triangles.put(species,a);
			curr = a;
		}
		curr.add(p);
	}

	public int getSpecies(Point p) 
	{
		return super.get(p).intValue();
	}
	
	public ArrayList<Point> getTriangle(int n) 
	{
		return triangles.get(n);
	}
	
	public String toString()
	{
		String ret="";
		for(Point p : super.keySet())
			ret+="\n"+p.x+"\t"+p.y+"\t"+this.getSpecies(p);
		return ret;
	}
}

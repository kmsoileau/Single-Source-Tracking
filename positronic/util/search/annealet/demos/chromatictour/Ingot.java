package positronic.util.search.annealet.demos.chromatictour;

import java.util.ArrayList;

import positronic.awt.geometry.Point;
import positronic.math.statistics.Random;
import positronic.util.search.annealet.IIngot;

public class Ingot extends ChromaticTour2 implements IIngot
{	
	private static final long serialVersionUID = -8183447742244447889L;
	private Problem problem;
	
	public Ingot(Problem problem)
	{
		super(problem);
		this.problem=problem;
	}
	
	//Copy the contents of incumbent into this.
	public void duplicate(IIngot incumbent)
	{
		super.clear();
		for(Point pt : (Ingot)incumbent)
			super.add(pt);
	}
		
	public double evaluate()
	{
		return super.length();
	}
	
	public void linearize()
	{
		int n1=Integer.MIN_VALUE;
		while(n1<0 || n1+2>=super.size())
			n1=(int)(Math.random()*super.size());
		Point p1=super.get(n1);
		Point p2=super.get(n1+1);
		Point p3=super.get(n1+2);
		ArrayList<Point> tri = problem.getTriangle(problem.getSpecies(p2));
		super.set(n1+1,Point.bestHop(p1,p3,tri));
	}
	
	public void mutate()
	{
		if(Math.random()<=.5)
			reverseSubpath();
		else
			replaceSetRepresentative();
		linearize();
	}
	
	public void replaceSetRepresentative()
	{
		int n1=(int)(Math.random()*super.size());
		ArrayList<Point> tri=
			problem.getTriangle(problem.getSpecies(super.get(n1)));
		Point choice = (Point)Random.chooseOneRandomly(tri.toArray());
		this.set(n1,choice);
	}
	
	public void reverseSubpath()
	{
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
		for(int i=p1;i<=p2;i++)
			this.set(i,reversedArray.get(i-p1));
	}

	public void show()
	{
		System.out.println(this.prettyPrint());
	}
}




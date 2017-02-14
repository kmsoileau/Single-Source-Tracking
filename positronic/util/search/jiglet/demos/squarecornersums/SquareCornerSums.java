package positronic.util.search.jiglet.demos.squarecornersums;

import positronic.util.search.jiglet.IVertex;
import positronic.util.search.jiglet.Jiglet;

public class SquareCornerSums extends Jiglet
{
	public static void main(String[] args)
	{
		SquareCornerSums hcs=new SquareCornerSums();
		hcs.setTrials(1000000);
		hcs.start();
	}
	
	protected IVertex explore() 
	{
		int n1=(int)(Math.random()*9);
		int n2=(int)(Math.random()*9);
		int dum=this.currentVertex.getCoordinate(n1);
		this.currentVertex.setCoordinate(n1,this.currentVertex.getCoordinate(n2));
		this.currentVertex.setCoordinate(n2,dum);
		return this.currentVertex;
	}

	protected void init() 
	{
		currentVertex=new SquareCornerSumsVertex();
	}

	protected boolean perTrial() 
	{
		System.out.println(currentVertex);
		return true;
	}

	protected void wrapup() 
	{
		System.out.println("Finis");
	}
}

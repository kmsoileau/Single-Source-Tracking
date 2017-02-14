package positronic.util.search.jiglet.demos.expressibility;

import positronic.util.search.jiglet.IVertex;
import positronic.util.search.jiglet.Jiglet;

public class ExpressibilityJiglet extends Jiglet
{
	public static void main(String[] args)
	{
		ExpressibilityJiglet hcs=new ExpressibilityJiglet();
		hcs.setTrials(1000000);
		hcs.start();
	}
	
	protected IVertex explore() 
	{
		int n1=(int)(Math.random()*9);
		int n2=(int)(Math.random()*9);
		IVertex output=currentVertex.duplicate();
		int dum=output.getCoordinate(n1);
		output.setCoordinate(n1,output.getCoordinate(n2));
		output.setCoordinate(n2,dum);
		return output;
	}

	protected void init() 
	{
		currentVertex=new ExpressibilityVertex();
		for(int i=0;i<9;i++)
			currentVertex.setCoordinate(i,i+1);
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

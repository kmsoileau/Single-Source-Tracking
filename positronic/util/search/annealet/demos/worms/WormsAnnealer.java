package positronic.util.search.annealet.demos.worms;

import positronic.awt.geometry.EquilateralTriangle;
import positronic.awt.geometry.ImproperlyFormedPolygonException;
import positronic.awt.geometry.Point;
import positronic.util.search.annealet.Annealet;

public class WormsAnnealer extends Annealet
{	
	public static void main(String[] args)
	{
		try 
		{
			EquilateralTriangle testTri=new EquilateralTriangle(
					new Point(2*Math.random()-1,2*Math.random()-1),
					new Point(2*Math.random()-1,2*Math.random()-1));
			Ingot.testPointSet=testTri.getPoints();
			new WormsAnnealer();
		} 
		catch (ImproperlyFormedPolygonException e) 
		{
			e.printStackTrace();
		}
	}
		
	public WormsAnnealer() throws ImproperlyFormedPolygonException
	{
		incumbent=new Ingot();
		candidate=new Ingot();
		best=new Ingot();
		
		initialTemperature(10.0);
		numberOfAttemptsPerTemperature(2000);
		coolingRate(.9999);
		
		currentTemperature=initialTemperature();
		lowestEnergy=1E+20;
		System.out.println("Best Utility is "+lowestEnergy);
		
				
		while(continueAnnealing())
		{
			System.out.println("Best Utility is "+lowestEnergy);	
			/*System.out.println("");
			for(int i=0;i<3;i++)
				System.out.print(((Ingot)best).values[i]);
			System.out.println("");
			for(int i=3;i<6;i++)
				System.out.print(((Ingot)best).values[i]);
			System.out.println("");
			for(int i=6;i<9;i++)
				System.out.print(((Ingot)best).values[i]);
			System.out.println("");*/
			best.show();
			System.out.println("Perimeter is "+((EquilateralTriangle)best).perimeter());
			System.out.println("Temperature is "+currentTemperature);
		}
		System.out.println("Out of Continue Loop");
	}
}
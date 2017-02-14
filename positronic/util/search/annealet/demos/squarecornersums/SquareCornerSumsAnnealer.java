package positronic.util.search.annealet.demos.squarecornersums;

import positronic.util.search.annealet.Annealet;
import positronic.util.search.annealet.demos.mathodicapetals.Ingot;

public class SquareCornerSumsAnnealer extends Annealet
{	
	public static void main(String[] args)
	{
		new SquareCornerSumsAnnealer();
	}
		
	public SquareCornerSumsAnnealer()
	{
		incumbent=new Ingot();
		candidate=new Ingot();
		best=new Ingot();
		
		initialTemperature(.5);
		numberOfAttemptsPerTemperature(10*20);
		coolingRate(.99);
		
		currentTemperature=initialTemperature();
		lowestEnergy=1E+20;
		System.out.println("Best Utility is "+lowestEnergy);
				
		while(continueAnnealing())
		{
			System.out.println("Best Utility is "+lowestEnergy);	
			best.show();
			System.out.println("Temperature is "+currentTemperature);
		}
		System.out.println("Out of Continue Loop");
	}
}




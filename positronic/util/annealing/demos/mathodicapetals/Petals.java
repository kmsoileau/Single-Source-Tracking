package positronic.util.annealing.demos.mathodicapetals;

import positronic.util.annealing.Annealet;

public class Petals extends Annealet
{
	public static void main(String[] args)
	{
		new Petals();
	}
	
	public Petals()
	{
		incumbent=new Ingot();
		candidate=new Ingot();
		best=new Ingot();
		
		initialTemperature(300.0);
		numberOfAttemptsPerTemperature(1000);
		coolingRate(.95);
		
		currentTemperature=initialTemperature();
		lowestEnergy=Integer.MAX_VALUE;
				
		while(continueAnnealing())
		{
			System.out.println("\nBest Utility is "+Double.toString(lowestEnergy));	
			best.show();
			System.out.println("\nCurrent Utility is "+Double.toString(incumbent.evaluate()));	
			incumbent.show();
			System.out.println("");
			System.out.println("Temperature is "+currentTemperature);
		}
		System.out.println("Out of Continue Loop");
	}
}

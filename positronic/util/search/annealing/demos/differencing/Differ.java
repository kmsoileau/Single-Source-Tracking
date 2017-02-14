package positronic.util.search.annealing.demos.differencing;

import positronic.util.search.annealing.Annealet;

public class Differ extends Annealet
{
	public static void main(String[] args)
	{
		new Differ();
	}
	
	public Differ()
	{
		incumbent=new Ingot();
		candidate=new Ingot();
		best=new Ingot();
		
		coolingRate(0.999);
		initialTemperature(200000);
		numberOfAttemptsPerTemperature(50);
		
		currentTemperature=initialTemperature();
		lowestEnergy=Integer.MAX_VALUE;
				
		while(continueAnnealing() && currentTemperature>10000d)
		{
			System.out.println("\nLowest energy is "+Double.toString(lowestEnergy));	
			best.show();
			System.out.println("");
			System.out.println("Temperature is "+currentTemperature);
		}
		System.out.println("Out of Continue Loop");
	}
}

package positronic.util.search.annealing.demos.squarecornersums2;

import positronic.util.search.annealing.Annealet;

public class SquareCornerSums2Annealer extends Annealet
{	
	public static void main(String[] args)
	{
		new SquareCornerSums2Annealer();
	}
		
	public SquareCornerSums2Annealer()
	{
		incumbent=new Ingot();
		candidate=new Ingot();
		best=new Ingot();
		
		initialTemperature(100.0);
		numberOfAttemptsPerTemperature(10*20);
		coolingRate(.99);
		
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
			System.out.println("Temperature is "+currentTemperature);
		}
		System.out.println("Out of Continue Loop");
	}
}




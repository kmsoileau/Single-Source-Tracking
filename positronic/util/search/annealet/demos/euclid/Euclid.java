package positronic.util.search.annealet.demos.euclid;

import positronic.util.search.annealet.Annealet;

//-87: 43 86 74 37 73 53 1 79 71 59 61 97 83 89 67 41 82 28 7 77 66 14 16 76 50 85 65 13 91 98 70 100 12 64 58 29 87 15 5 55 45 20 80 34 52 78 6 68 17 51 39 21 18 84 48 8 10 32 44 11 88 22 26 4 90 81 33 96 40 36 27 3 63 49 56 38 19 95 60 72 92 2 54 62 31 93 24 9 42 35 25 75 99 57 30 69 23 46 94 47 
 
public class Euclid extends Annealet
{
	public static void main(String[] args)
	{
		new Euclid();
	}
	
	public Euclid()
	{
		incumbent=new Ingot();
		candidate=new Ingot();
		best=new Ingot();
		
		coolingRate(0.95);
		initialTemperature(200);
		numberOfAttemptsPerTemperature(50);
		
		currentTemperature=initialTemperature();
		lowestEnergy=Integer.MAX_VALUE;
				
		while(continueAnnealing() && currentTemperature>1e-100)
		{
			System.out.println("\nLowest energy is "+Double.toString(lowestEnergy));	
			best.show();
			System.out.println("");
			System.out.println("Temperature is "+currentTemperature);
		}
		System.out.println("Out of Continue Loop");
	}
}

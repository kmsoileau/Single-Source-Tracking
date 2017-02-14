package positronic.util.search.annealet.demos.expressibility1;

import positronic.math.Expressible;
import positronic.util.ArrayListSet;
import positronic.util.search.annealet.Annealet;
import positronic.util.search.annealet.demos.differencing.Ingot;

public class ExpressibilityAnnealet1 extends Annealet
{
	//26 87 132 20 29 111 68 
	
	public static void main(String[] args) 
	{
		new ExpressibilityAnnealet1();
	}
	
	public static int[] jiggleSearch(int[] center)
	{
		int[] currentCenter=new int[center.length];
		
		for(int i=0;i<1000;i++)
		{
			for(int j=0;j<center.length;j++)
				currentCenter[j]=center[j];
			for(int j=0;j<currentCenter.length;j++)
			{
				double r=Math.random();
				if(r<1./3)
					currentCenter[j]--;
				else
					if(r<2./3)
						;
					else
						currentCenter[j]++;	
			}
			ArrayListSet<Long> param=new ArrayListSet<Long>();
			for(int n : currentCenter)
				param.add(new Long(n));
			ArrayListSet<?> a=Expressible.expressibleList(param);
			int hits=0;
			for(Object o : a)
			{
				int curr=((Long)o).intValue();
				if(curr>0 && curr<=360)
					hits++;
			}
			if(hits==360)
				return currentCenter;
		}
		return center;
	}
	
	public ExpressibilityAnnealet1()
	{
		incumbent=new Ingot();
		candidate=new Ingot();
		best=new Ingot();
		
		coolingRate(0.999);
		initialTemperature(200000);
		numberOfAttemptsPerTemperature(50);
		
		currentTemperature=initialTemperature();
		lowestEnergy=Long.MAX_VALUE;
				
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
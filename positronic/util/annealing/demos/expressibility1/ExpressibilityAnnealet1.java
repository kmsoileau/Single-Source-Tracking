package positronic.util.annealing.demos.expressibility1;

import positronic.math.Expressible;
import positronic.util.ArrayListSet;
import positronic.util.annealing.Annealet;
import positronic.util.annealing.demos.differencing.Ingot;

public class ExpressibilityAnnealet1 extends Annealet
{
	public static void main(String[] args) 
	{
		//new Mathodica();
		int[] res=jiggleSearch(new int[]{2,16,38,50,78,85,86,88,87});
		for(int i:res)
			System.out.print(i+",");
	}
	
	@SuppressWarnings("unchecked")
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
			@SuppressWarnings("rawtypes")
			ArrayListSet<Long> param=new ArrayListSet();
			for(int n : currentCenter)
				param.add(new Integer(n));
			@SuppressWarnings("rawtypes")
			ArrayListSet a=Expressible.expressibleList(param);
			int hits=0;
			for(Object o : a)
			{
				int curr=((Integer)o).intValue();
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
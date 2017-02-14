package positronic.util.search.annealing;

import java.util.Random;

public class Annealet 
{	
	protected IIngot best;
	protected IIngot candidate;
	private double coolingRate;
	protected double currentTemperature;
	protected IIngot incumbent;
	private double initialTemperature;
	protected double lowestEnergy;
	private int numberOfAttemptsPerTemperature;
	protected int numberOfSuccesses;
	private Random r=new Random();

	public Annealet()
	{
		coolingRate(0.99);
		initialTemperature(20);
		numberOfAttemptsPerTemperature(100);
	}

	private boolean attemptJump()
	{
		double res1;
		double res2;

		res1 = incumbent.evaluate();
		candidate.duplicate(incumbent);
		candidate.mutate();
		res2 = candidate.evaluate();

		if(consultMetropolis(currentTemperature, res2 - res1))
		{
			if(res2<lowestEnergy)
			{	
				lowestEnergy=res2;
				best.duplicate(candidate);
			}
			
			incumbent.duplicate(candidate);
			return true;
		}
		else
			return false;
	}
	
	private boolean consultMetropolis(double T, double deltaEnergy)
	{
		if(T == 0) return false;
		if(deltaEnergy < 0.) return true;
		if(Math.exp(-deltaEnergy/T) > r.nextDouble()) return true;
		return false;
	}
	
	protected boolean continueAnnealing()
	{
		currentTemperature=nextTemperature();
		numberOfSuccesses=0;

		for(int i=1;i<=numberOfAttemptsPerTemperature();i++)
			if(attemptJump())
				numberOfSuccesses++;
		
		return true;
	}
	
	public double coolingRate()
	{
		return coolingRate;
	}
		
	public void coolingRate(double vnewValue)
	{
		coolingRate = vnewValue;
	}
	
	public double initialTemperature()
	{
		return initialTemperature;
	}
	
	public void initialTemperature(double vData) 
	{
		initialTemperature = vData;
	}

	private double nextTemperature()
	{
	   return currentTemperature * coolingRate();
	}

	public int numberOfAttemptsPerTemperature()
	{
		return numberOfAttemptsPerTemperature;
	}

	public void numberOfAttemptsPerTemperature(int vNewValue)
	{
		numberOfAttemptsPerTemperature = vNewValue;
	}
}




package positronic.util.annealing;

import java.util.Random;

public class Annealist
{
	private double m_coolingRate;
	private double m_InitialTemperature;
	private int m_NumberOfAttemptsPerTemperature;
	private Random r;

	public Annealist()
	{
		r=new Random();
		coolingRate(0.95);
		initialTemperature(20);
		numberOfAttemptsPerTemperature(50);
	}

	public double coolingRate()
	{
		return m_coolingRate;
	}

	public void coolingRate(double vnewValue)
	{
		m_coolingRate = vnewValue;
	}

	public double initialTemperature()
	{
		return m_InitialTemperature;
	}

	public void initialTemperature(double vData) 
	{
		m_InitialTemperature = vData;
	}

	public boolean consultMetropolis(double t,double de)
	{
		if(de == 0.)
		{
			return false;
		}
		
		if(t == 0)
		{
			return false;
		}
		if(de < 0.)
		{
			return true;
		}
		//if(Math.exp(-de / t) > Math.random())
		if(Math.exp(-de / t) > r.nextDouble())
		{
			return true;
		}
		return false;
	}

	public int numberOfAttemptsPerTemperature()
	{
		return m_NumberOfAttemptsPerTemperature;
	}

	public void numberOfAttemptsPerTemperature(int vNewValue)
	{
		m_NumberOfAttemptsPerTemperature = vNewValue;
	}
}


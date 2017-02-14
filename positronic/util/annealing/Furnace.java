package positronic.util.annealing;

public class Furnace 
{
	private double m_CurrentTemperature;
	
	public double currentTemperature()
	{
		return m_CurrentTemperature;
	}

	public void currentTemperature(double vData) 
	{
		m_CurrentTemperature = vData;
	}
}


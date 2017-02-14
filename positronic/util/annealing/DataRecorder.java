package positronic.util.annealing;

public class DataRecorder 
{
	private int m_NumberOfSuccesses;
	private double m_bestUtility;

	public double bestUtility()
	{
		return m_bestUtility;
	}

	public void bestUtility(double vnewValue)
	{
		m_bestUtility = vnewValue;
	}

	public int numberOfSuccesses()
	{
		return m_NumberOfSuccesses;
	}

	public void numberOfSuccesses(int vNewValue) 
	{
		m_NumberOfSuccesses = vNewValue;
	}
}


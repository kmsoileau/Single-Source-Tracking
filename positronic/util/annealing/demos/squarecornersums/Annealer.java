package positronic.util.annealing.demos.squarecornersums;

import positronic.util.annealing.Annealist;
import positronic.util.annealing.DataRecorder;
import positronic.util.annealing.Furnace;

public class Annealer 
{	
	public static void main(String[] args)
	{
		new Annealer();
	}
		
	public DataRecorder Tricorder;
	public Annealist MyAnnealist;
	public Furnace MyFurnace;
	public Ingots MyIngots;
	
	protected Ingot m_Incumbent;
	protected Ingot m_Candidate;
	protected Ingot m_BestIngot;

	public Annealer()
	{
		MyIngots=new Ingots();
		
		m_Incumbent=new Ingot();
		MyIngots.theIngots.addElement(m_Incumbent);
		
		m_Candidate=new Ingot();
		MyIngots.theIngots.addElement(m_Candidate);

		m_BestIngot=new Ingot();
		MyIngots.theIngots.addElement(m_BestIngot);
	
		MyFurnace=new Furnace();
		Tricorder= new DataRecorder();
		MyAnnealist=new Annealist();
		MyAnnealist.initialTemperature(.5);
		MyAnnealist.numberOfAttemptsPerTemperature(10*20);
		MyAnnealist.coolingRate(.99);
		
		MyFurnace.currentTemperature(MyAnnealist.initialTemperature());
		Tricorder.bestUtility(1E+20);
		System.out.println("Best Utility is "+Double.toString(Tricorder.bestUtility()));
				
		while(continueAnnealing())
		{
			System.out.println("Best Utility is "+Double.toString(Tricorder.bestUtility()));	
			System.out.println("");
			for(int i=0;i<3;i++)
				System.out.print(m_BestIngot.values[i]);
			System.out.println("");
			for(int i=3;i<6;i++)
				System.out.print(m_BestIngot.values[i]);
			System.out.println("");
			for(int i=6;i<9;i++)
				System.out.print(m_BestIngot.values[i]);
			System.out.println("");
			System.out.println("Temperature is "+MyFurnace.currentTemperature());
		}
		System.out.println("Out of Continue Loop");
	}

	public boolean continueAnnealing()
	{
		MyFurnace.currentTemperature(nextTemperature());
		Tricorder.numberOfSuccesses(0);

		for(int i=1;i<=MyAnnealist.numberOfAttemptsPerTemperature();i++)
			if(attemptJump())
				Tricorder.numberOfSuccesses(Tricorder.numberOfSuccesses() + 1);
		
		//return Tricorder.numberOfSuccesses() > 0;	
		return true;
	}

	public boolean attemptJump()
	{
		double res1;
		double res2;

		res1 = m_Incumbent.evaluate();
		m_Candidate.copy(m_Incumbent);
		m_Candidate.mutate();
		res2 = m_Candidate.evaluate();

		if(MyAnnealist.consultMetropolis(MyFurnace.currentTemperature(), res2 - res1))
		{
			if(res2<Tricorder.bestUtility())
			{	
				Tricorder.bestUtility(res2);
				m_BestIngot.copy(m_Candidate);
			}
			m_Incumbent.copy(m_Candidate);

			return true;
		}
		else
			return false;
	}

	public double nextTemperature()
	{
	   return MyFurnace.currentTemperature() * MyAnnealist.coolingRate();
	}
}




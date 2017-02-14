package positronic.util.annealing.demos.squarecornersums;

import java.util.Vector;


public class Ingots 
{
	public Vector<Ingot> theIngots;
	
	public Ingots()
	{
		theIngots=new Vector<Ingot>();
	}

	public Ingots(int initcap)
	{
		theIngots=new Vector<Ingot>(initcap);
	}
}

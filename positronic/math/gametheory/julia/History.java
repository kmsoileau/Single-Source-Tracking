package positronic.math.gametheory.julia;

import java.util.Vector;

public class History extends Vector<IMove>
{
	private static final long serialVersionUID = -2153552372803499861L;
	private int capacity=Integer.MAX_VALUE;
	
	public int getCapacity() 
	{
		return capacity;
	}

	public void recordMove(IMove m)
	{
		if(super.size()==capacity)
			super.remove(0);
		super.add(m);
	}

	public void setCapacity(int capacity) 
	{
		this.capacity = capacity;
	}
}

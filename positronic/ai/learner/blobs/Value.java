package positronic.ai.learner.blobs;

import positronic.ai.learner.IValue;

public class Value implements IValue
{
	private double val;

	public Object getValue() 
	{
		return val;
	}

	public void setValue(Object o) 
	{
		this.val = (Double) o;
	}
}

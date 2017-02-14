package positronic.ai.learner.indicator;

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


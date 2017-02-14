package positronic.satisfiability.demos.towerofhanoi;

import positronic.satisfiability.elements.BooleanVariable;
import positronic.satisfiability.elements.IBooleanVariable;

public class Disk
{
	public IBooleanVariable disk;

	public Disk() throws Exception
	{
		this.disk = BooleanVariable.getBooleanVariable();
	}

	public Disk(String string, boolean b) throws Exception
	{
		this.disk = BooleanVariable.getBooleanVariable(string,b);
	}

	public boolean getValue()
	{
		return this.disk.getValue();
	}
}

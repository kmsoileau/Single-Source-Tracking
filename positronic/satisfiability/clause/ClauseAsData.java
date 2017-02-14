package positronic.satisfiability.clause;

import positronic.satisfiability.naturalnumberlist.NaturalNumberList;

//This class is under development and is not ready for use.
public class ClauseAsData 
{
	private static int cADCount;
	public ClauseAsData() throws Exception
	{
		this(3);
	}
	
	public ClauseAsData(int capacity) throws Exception
	{
		this(""+cADCount,capacity);
	}
	
	public ClauseAsData(String name) throws Exception
	{
		this(name,3);
	}
	
	public ClauseAsData(String name, int capacity) throws Exception
	{
		new NaturalNumberList(name,new long[capacity]);
		new NaturalNumberList(name,new long[capacity]);
		cADCount++;
	}
}

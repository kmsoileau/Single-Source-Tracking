package positronic.util.schedule.precedence;

import positronic.satisfiability.naturalnumber.INaturalNumber;
import positronic.satisfiability.naturalnumber.NaturalNumber;

public class Task implements ITask
{
	public INaturalNumber Start;
	public INaturalNumber Completion;
  private String name;
	
	public Task() throws Exception
	{
		this("AnonymousTask");
	}
	
	public Task(String name) throws Exception
	{
		this.name=name;
		this.Start=new NaturalNumber(this.name+"_Start");
		this.Completion=new NaturalNumber(this.name+"_Completion");
	}

	public INaturalNumber Completion()
	{
		return this.Completion;
	}

	public INaturalNumber Start()
	{
		return this.Start;
	}
}

package positronic.util.schedule.precedence;

import positronic.satisfiability.elements.Problem;
import positronic.satisfiability.naturalnumber.NaturalNumberOrderer;

public class TaskPrecedenceFixer extends Problem
{
	private static final long serialVersionUID = 6035638271472781467L;

	public TaskPrecedenceFixer(ITask z, ITask x) throws Exception
	{
		this.setClauses(new NaturalNumberOrderer(z.Completion(),x.Start())
			.getClauses());
	}
}

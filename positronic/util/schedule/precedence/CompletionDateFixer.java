package positronic.util.schedule.precedence;

import positronic.satisfiability.elements.Problem;
import positronic.satisfiability.naturalnumber.NaturalNumberFixer;

public class CompletionDateFixer extends Problem
{
	private static final long serialVersionUID = 4615873546939871040L;

	public CompletionDateFixer(ITask x, int i) throws Exception
	{
		this.setClauses(new NaturalNumberFixer(x.Completion(),i).getClauses());
	}
}

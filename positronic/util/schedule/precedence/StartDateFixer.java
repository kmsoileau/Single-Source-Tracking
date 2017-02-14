package positronic.util.schedule.precedence;

import positronic.satisfiability.elements.Problem;
import positronic.satisfiability.naturalnumber.NaturalNumberFixer;

public class StartDateFixer extends Problem
{
	private static final long serialVersionUID = 4894125391109728881L;

	public StartDateFixer(ITask x, int i) throws Exception
	{
		this.setClauses(new NaturalNumberFixer(x.Start(),i).getClauses());
	}
}

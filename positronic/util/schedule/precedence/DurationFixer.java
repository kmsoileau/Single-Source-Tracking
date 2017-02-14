package positronic.util.schedule.precedence;

import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.Problem;
import positronic.satisfiability.naturalnumber.INaturalNumber;
import positronic.satisfiability.naturalnumber.NaturalNumber;
import positronic.satisfiability.naturalnumber.NaturalNumberAdder;
import positronic.satisfiability.naturalnumber.NaturalNumberFixer;

public class DurationFixer extends Problem
{
	private static final long serialVersionUID = 4375863287208693414L;

	public DurationFixer(ITask z, int x) throws Exception
	{
		INaturalNumber T=new NaturalNumber();
		this.setClauses(new Conjunction(new NaturalNumberFixer(T,x),
				new NaturalNumberAdder(z.Start(),T,z.Completion())).getClauses());
	}
	
	/*public DurationFixer(ITask z, int x) throws Exception
	{
		INaturalNumber T=new NaturalNumber();
		INaturalNumber F=new NaturalNumber();
		this.setClauses(new Conjunction(new NaturalNumberFixer(T,x),
				new NaturalNumberAdder(z.Start(),T,F),
					new NaturalNumberOrderer(F,z.Completion())).getClauses());
	}*/
}

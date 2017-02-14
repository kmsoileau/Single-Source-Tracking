package positronic.satisfiability.interval;

import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;
import positronic.satisfiability.exceptions.IntervalException;
import positronic.satisfiability.exceptions.NaturalNumberException;
import positronic.satisfiability.naturalnumber.INaturalNumber;
import positronic.satisfiability.naturalnumber.NaturalNumberOrderer;

public class IntervalMembershipper extends Problem implements IProblem
{
	private static final long serialVersionUID = 1L;

	public IntervalMembershipper(IInterval interval, INaturalNumber number) throws Exception
  {
    if(interval==null)
      throw new IntervalException("Passed a null IInterval to constructor.");
    if(number==null)
      throw new NaturalNumberException("Passed a null INaturalNumber to constructor.");
    IProblem p1=new NaturalNumberOrderer(interval.getLeft(),number);
    IProblem p2=new NaturalNumberOrderer(number,interval.getRight());
    
    IProblem problem=new Conjunction(p1,p2);
    this.setClauses(problem.getClauses());
  }
}

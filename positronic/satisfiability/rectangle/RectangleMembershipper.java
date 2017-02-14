package positronic.satisfiability.rectangle;

import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;
import positronic.satisfiability.exceptions.NaturalNumberException;
import positronic.satisfiability.exceptions.RectangleException;
import positronic.satisfiability.interval.IntervalMembershipper;
import positronic.satisfiability.naturalnumber.INaturalNumber;

public class RectangleMembershipper extends Problem implements IProblem
{
	private static final long serialVersionUID = 792728992547522941L;

	public RectangleMembershipper(final IRectangle rectangle, final INaturalNumber X, final INaturalNumber Y) throws Exception
  {
    if(rectangle==null)
      throw new RectangleException("Passed a null IRectangle to constructor.");
    if(X==null || Y==null)
      throw new NaturalNumberException("Passed a null INaturalNumber to constructor.");
    final IProblem p1=new IntervalMembershipper(rectangle.getHorizontal(),X);
    final IProblem p2=new IntervalMembershipper(rectangle.getVertical(),Y);
    final IProblem problem=new Conjunction(p1,p2);
    this.setClauses(problem.getClauses());
  }
}

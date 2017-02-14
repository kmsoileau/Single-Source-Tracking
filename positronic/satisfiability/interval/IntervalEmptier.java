package positronic.satisfiability.interval;

import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.IBooleanVariable;
import positronic.satisfiability.elements.IClause;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;
import positronic.satisfiability.naturalnumber.NaturalNumberOrderer;
import positronic.satisfiability.naturalnumber.NaturalNumberUnequalizer;
 /**
 * An extension of the Problem class which is satisfied when an Interval is 
 * empty.
 *
 * In one way to use this class, one passes an Interval X to the appropriate 
 * constructor. The IntervalNonemptier object produced is a Problem, and one 
 * may manipulate it using any of the methods provided by the Problem class.
 *
 * @author  Kerry Michael Soileau
 * <blockquote><pre>
 * ksoileau@yahoo.com
 * http://kerrysoileau.com/index.html
 * </pre></blockquote>
 * @version 1.0, 07/09/09
 * @see IBooleanVariable
 * @see IClause
 * @see IProblem
 * @see Problem
 */

public class IntervalEmptier extends Problem implements IProblem
{
	private static final long serialVersionUID = -1742756145322885379L;

	public IntervalEmptier(final IInterval X) throws Exception
  {
		if(X.getLeft()!=null && X.getRight()!=null)
		{
			final IProblem p1=new NaturalNumberUnequalizer(X.getLeft(),X.getRight());
			final IProblem p2=new NaturalNumberOrderer(X.getRight(),X.getLeft());
			final IProblem problem=new Conjunction(p1,p2);
	    this.setClauses(problem.getClauses());
		}
  }
}
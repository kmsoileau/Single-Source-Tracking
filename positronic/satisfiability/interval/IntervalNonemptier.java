package positronic.satisfiability.interval;

import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.IBooleanVariable;
import positronic.satisfiability.elements.IClause;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;
import positronic.satisfiability.exceptions.IntervalNonemptierException;
import positronic.satisfiability.naturalnumber.NaturalNumberOrderer;
 /**
 * An extension of the Problem class which is satisfied when an Interval is 
 * nonempty.
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
 * @version 1.0, 07/09/05
 * @see IBooleanVariable
 * @see IClause
 * @see IProblem
 * @see Problem
 */

public class IntervalNonemptier extends Problem implements IProblem
{
	private static final long serialVersionUID = -1742756145322885379L;

	public IntervalNonemptier(final IInterval X) throws Exception
  {
		if(X.getLeft()==null || X.getRight()==null)
			throw new IntervalNonemptierException("Improperly constructed Interval was passed to constructor.");
		if(X.getLeft()!=null || X.getRight()!=null)
		{
			final IProblem problem=new Conjunction(new NaturalNumberOrderer(X.getLeft(),X.getRight()));
	    this.setClauses(problem.getClauses());
		}
  }
}
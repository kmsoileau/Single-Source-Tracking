package positronic.satisfiability.interval;

import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.IBooleanVariable;
import positronic.satisfiability.elements.IClause;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;
import positronic.satisfiability.exceptions.IntervalFixerException;
import positronic.satisfiability.naturalnumber.NaturalNumberFixer;
 /**
 * An extension of the Problem class which fixes the value of an Interval.
 *
 * In one way to use this class, one passes an Interval X to the appropriate 
 * constructor. The IntervalFixer object 
 * produced is a Problem, and one may manipulate it using any of the methods 
 * provided by the Problem class.
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

public class IntervalFixer extends Problem implements IProblem
{
	private static final long serialVersionUID = 7966122658517348258L;

	public IntervalFixer(IInterval X) throws Exception
  {
		if(X.getLeft()==null || X.getRight()==null)
			throw new IntervalFixerException("Improperly constructed Interval was passed to constructor.");
		
		IProblem p1=new NaturalNumberFixer(X.getLeft());
		IProblem p2=new NaturalNumberFixer(X.getRight());
    IProblem problem=new Conjunction(p1,p2);
    this.setClauses(problem.getClauses());
  }
}
package positronic.satisfiability.interval;

import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.Disjunction;
import positronic.satisfiability.elements.IBooleanVariable;
import positronic.satisfiability.elements.IClause;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;
import positronic.satisfiability.naturalnumber.NaturalNumberEqualizer;
 /**
 * An extension of the Problem class which is satisfied when two 
 * Intervals are equal.
 *
 * In one way to use this class, one passes Interval X and Interval Y 
 * to the appropriate constructor. The IntervalEqualizer object 
 * produced is a Problem, and one may manipulate it using any of the methods 
 * provided by the Problem class.
 *
 * @author  Kerry Michael Soileau
 * <blockquote><pre>
 * ksoileau@yahoo.com
 * http://kerrysoileau.com/index.html
 * </pre></blockquote>
 * @version 1.0, 07/09/10
 * @see IBooleanVariable
 * @see IClause
 * @see IProblem
 * @see Problem
 */

public class IntervalEqualizer extends Problem implements IProblem
{
	private static final long serialVersionUID = -6377321084094024021L;

	public IntervalEqualizer(final IInterval X, final IInterval Y) throws Exception
  {
		final IProblem problem1=new NaturalNumberEqualizer(X.getLeft(),Y.getLeft());
		final IProblem problem2=new NaturalNumberEqualizer(X.getRight(),Y.getRight());
		final IProblem problem3=new Conjunction(new IntervalEmptier(X),new IntervalEmptier(Y));
   
		final IProblem problem=new Disjunction(new Conjunction(problem1,problem2),problem3);
    this.setClauses(problem.getClauses());
  }
}
package positronic.satisfiability.interval;

import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.Disjunction;
import positronic.satisfiability.elements.IBooleanVariable;
import positronic.satisfiability.elements.IClause;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;
import positronic.satisfiability.naturalnumber.INaturalNumber;
import positronic.satisfiability.naturalnumber.NaturalNumber;
import positronic.satisfiability.naturalnumber.NaturalNumberAdder;
 /**
 * An extension of the Problem class which is satisfied when 
 * two Intervals are congruent. By this is meant that each 
 * Interval is a translation of the other, if the Intervals 
 * are both nonempty. Any two empty Intervals are congruent.
 *
 * In one way to use this class, one passes Interval X and Interval Y 
 * to the appropriate constructor. The IntervalCongruenter object 
 * produced is a Problem, and one may manipulate it using any of the methods 
 * provided by the Problem class.
 *
 * @author  Kerry Michael Soileau
 * <blockquote><pre>
 * ksoileau@yahoo.com
 * http://kerrysoileau.com/index.html
 * </pre></blockquote>
 * @version 1.0, 07/09/07
 * @see IBooleanVariable
 * @see IClause
 * @see IProblem
 * @see Problem
 */

public class IntervalCongruenter extends Problem implements IProblem
{
	private static final long serialVersionUID = 7743447590424867247L;

	public IntervalCongruenter(final IInterval X, final IInterval Y) throws Exception
  {
		final INaturalNumber D=new NaturalNumber();
		final IProblem problem1=new Conjunction(new NaturalNumberAdder(X.getLeft(),D,Y.getLeft()),
    		new NaturalNumberAdder(X.getRight(),D,Y.getRight()));
		final IProblem problem2=new Conjunction(new NaturalNumberAdder(Y.getLeft(),D,X.getLeft()),
    		new NaturalNumberAdder(Y.getRight(),D,X.getRight()));
		final IProblem problem3=new Conjunction(new IntervalEmptier(X),new IntervalEmptier(Y));
		final IProblem problem=new Disjunction(problem1,problem2,problem3);
    this.setClauses(problem.getClauses());
  }
}
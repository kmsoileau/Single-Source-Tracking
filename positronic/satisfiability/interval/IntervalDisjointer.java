package positronic.satisfiability.interval;

import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.IBooleanVariable;
import positronic.satisfiability.elements.IClause;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;
 /**
 * An extension of the Problem class which implements the 
 * disjunction of two Intervals. By this is meant the Problem 
 * is satisfied if and only if the Intervals are disjoint.
 *
 * In one way to use this class, one passes Interval X and 
 * Interval Y to the appropriate constructor. The 
 * IntervalDisjointer object produced is a Problem, and one 
 * may manipulate it using any of the methods provided by the 
 * Problem class.
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

public class IntervalDisjointer extends Problem implements IProblem
{
	private static final long serialVersionUID = 6958623418180586252L;

	public IntervalDisjointer(IInterval X, IInterval Y) throws Exception
  {
		IInterval Z=new Interval();
		IProblem p1=new IntervalMeeter(X,Y,Z);
		IProblem p2=new IntervalEmptier(Z);
    
    IProblem problem=new Conjunction(p1,p2);
    this.setClauses(problem.getClauses());
  }
}
package positronic.satisfiability.interval;

import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.IBooleanVariable;
import positronic.satisfiability.elements.IClause;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;
import positronic.satisfiability.naturalnumber.NaturalNumberOrderer;
 /**
 * An extension of the Problem class which implements the 
 * inclusion of one Interval inside another. When this 
 * Problem is satisfied, X is a subset of Y. If X is 
 * empty, the Problem is satisfied regardless of Y, and 
 * if Y is empty, the Problem is satisfied only when X is 
 * empty.
 *
 * In one way to use this class, one passes Intervals X 
 * and Y. The IntervalSubsetter object produced is a 
 * Problem, and one may manipulate it using any of the 
 * methods provided by the Problem class.
 *
 * @author  Kerry Michael Soileau
 * <blockquote><pre>
 * ksoileau@yahoo.com
 * http://kerrysoileau.com/index.html
 * </pre></blockquote>
 * @version 1.0, 07/09/08
 * @see IBooleanVariable
 * @see IClause
 * @see IProblem
 * @see Problem
 */

public class IntervalSubsetter extends Problem implements IProblem
{
	private static final long serialVersionUID = -12191495151688981L;

	public IntervalSubsetter(IInterval X, IInterval Y) throws Exception
  {
    IProblem p1=new NaturalNumberOrderer(Y.getLeft(),X.getLeft());
    IProblem p2=new NaturalNumberOrderer(X.getRight(),Y.getRight());
    IProblem problem=new Conjunction(p1,p2);
    this.setClauses(problem.getClauses());
  }
}
package positronic.satisfiability.rectangle;

import positronic.satisfiability.elements.Disjunction;
import positronic.satisfiability.elements.IBooleanVariable;
import positronic.satisfiability.elements.IClause;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;
import positronic.satisfiability.interval.IntervalDisjointer;
 /**
 * An extension of the Problem class which implements the disjunction of two
 * Rectangles. By this is meant the Problem is satisfied if and only if the
 * Rectangles are disjoint.
 *
 * In one way to use this class, one passes Rectangle X and Rectangle Y to the 
 * appropriate constructor. The RectangleDisjointer object produced is a 
 * Problem, and one may manipulate it using any of the methods provided by 
 * the Problem class.
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

public class RectangleDisjointer extends Problem implements IProblem
{
	private static final long serialVersionUID = -9068847029886117339L;

	public RectangleDisjointer(final IRectangle X, final IRectangle Y) throws Exception
  {
		final IProblem v1=new IntervalDisjointer(X.getHorizontal(),Y.getHorizontal());
		final IProblem v2=new IntervalDisjointer(X.getVertical(),Y.getVertical());
		
    final IProblem problem=new Disjunction(v1,v2);
    this.setClauses(problem.getClauses());
  }
}
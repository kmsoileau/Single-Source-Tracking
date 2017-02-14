package positronic.satisfiability.rectangle;

import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.IBooleanVariable;
import positronic.satisfiability.elements.IClause;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;
import positronic.satisfiability.interval.IntervalJoiner;
 /**
 * An extension of the Problem class which implements the join of two
 * Rectangles. By this is meant the smallest Rectangle which contains both 
 * Rectangles.
 *
 * In one way to use this class, one passes Rectangle X, Rectangle Y and
 * Rectangle Z to the appropriate constructor. When this Problem is 
 * satisfied, Z is the join of X and Y. The RectangleJoiner object produced 
 * is a Problem, and one may manipulate it using any of the methods provided 
 * by the Problem class.
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

public class RectangleJoiner extends Problem implements IProblem
{
	private static final long serialVersionUID = 3031300062936620628L;

	public RectangleJoiner(final IRectangle X, final IRectangle Y, final IRectangle Z) throws Exception
  {
		final IProblem v1=new IntervalJoiner(X.getHorizontal(),Y.getHorizontal(),Z.getHorizontal());
		final IProblem v2=new IntervalJoiner(X.getVertical(),Y.getVertical(),Z.getVertical());
    final IProblem problem=new Conjunction(v1,v2);
    this.setClauses(problem.getClauses());
  }
}
package positronic.satisfiability.rectangle;

import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.IBooleanVariable;
import positronic.satisfiability.elements.IClause;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;
import positronic.satisfiability.interval.IntervalNonemptier;
 /**
 * An extension of the Problem class which is satisfied when a Rectangle is 
 * nonempty.
 *
 * In one way to use this class, one passes a Rectangle X to the appropriate 
 * constructor. The RectangleNonemptier object produced is a Problem, and one 
 * may manipulate it using any of the methods provided by the Problem class.
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

public class RectangleNonemptier extends Problem implements IProblem
{
	private static final long serialVersionUID = -4900938545534326454L;

	public RectangleNonemptier(final IRectangle X) throws Exception
  {
		final IProblem problem=new Conjunction(
				new IntervalNonemptier(X.getHorizontal()),
				new IntervalNonemptier(X.getVertical()));
	  this.setClauses(problem.getClauses());
  }
}
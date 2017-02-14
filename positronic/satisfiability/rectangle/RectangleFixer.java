package positronic.satisfiability.rectangle;

import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.IBooleanVariable;
import positronic.satisfiability.elements.IClause;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;
import positronic.satisfiability.interval.IntervalFixer;
 /**
 * An extension of the Problem class which fixes the value of a Rectangle.
 *
 * In one way to use this class, one passes a Rectangle X the appropriate 
 * constructor. The RectangleFixer object produced is a Problem, and one may 
 * manipulate it using any of the methods provided by the Problem class.
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

public class RectangleFixer extends Problem implements IProblem
{
	private static final long serialVersionUID = 2025779322780446093L;

	public RectangleFixer(IRectangle X) throws Exception
  {
    final IProblem problem=new Conjunction(
    		new IntervalFixer(X.getHorizontal()),
    		new IntervalFixer(X.getVertical()));
    this.setClauses(problem.getClauses());
  }
}
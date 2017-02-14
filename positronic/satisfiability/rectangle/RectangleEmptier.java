package positronic.satisfiability.rectangle;

import positronic.satisfiability.elements.Disjunction;
import positronic.satisfiability.elements.IBooleanVariable;
import positronic.satisfiability.elements.IClause;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;
import positronic.satisfiability.exceptions.RectangleEmptierException;
import positronic.satisfiability.interval.IntervalEmptier;
 /**
 * An extension of the Problem class which is satisfied when an Rectangle is 
 * empty.
 *
 * In one way to use this class, one passes an Rectangle X to the appropriate 
 * constructor. The RectangleNonemptier object produced is a Problem, and one 
 * may manipulate it using any of the methods provided by the Problem class.
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

public class RectangleEmptier extends Problem implements IProblem
{
	private static final long serialVersionUID = -1305902667001109632L;

	public RectangleEmptier(final IRectangle X) throws Exception
  {
		if(X.getHorizontal()==null || X.getVertical()==null)
			throw new RectangleEmptierException("Improperly formed Rectangle was passed to constructor.");
		
		final IProblem p1=new IntervalEmptier(X.getHorizontal());
		final IProblem p2=new IntervalEmptier(X.getVertical());
		final IProblem problem=new Disjunction(p1,p2);
    this.setClauses(problem.getClauses());
  }
}
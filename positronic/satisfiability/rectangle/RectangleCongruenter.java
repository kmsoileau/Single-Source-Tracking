package positronic.satisfiability.rectangle;

import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.Disjunction;
import positronic.satisfiability.elements.IBooleanVariable;
import positronic.satisfiability.elements.IClause;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;
import positronic.satisfiability.interval.IntervalCongruenter;
 /**
 * An extension of the Problem class which is satisfied when two 
 * Rectangles are congruent. By this is meant that each Rectangle is a 
 * translation of the other, or that they are both empty.
 *
 * In one way to use this class, one passes Rectangle X and Rectangle Y 
 * to the appropriate constructor. The RectangleCongruenter object 
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

public class RectangleCongruenter extends Problem implements IProblem
{
	private static final long serialVersionUID = -4303956431899766121L;

	public RectangleCongruenter(final IRectangle X, final IRectangle Y) throws Exception
  {
		final IProblem bothEmpty=new Conjunction(
				new RectangleEmptier(X),
				new RectangleEmptier(Y));
		final IProblem p1=new Conjunction(
				new IntervalCongruenter(X.getHorizontal(),Y.getHorizontal()),
				new IntervalCongruenter(X.getVertical(),Y.getVertical()));
		final IProblem problem=new Disjunction(bothEmpty,p1);
    this.setClauses(problem.getClauses());
  }
}
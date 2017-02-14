package positronic.satisfiability.interval;

import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.Disjunction;
import positronic.satisfiability.elements.IBooleanVariable;
import positronic.satisfiability.elements.IClause;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;
import positronic.satisfiability.naturalnumber.NaturalNumberEqualizer;
import positronic.satisfiability.naturalnumber.NaturalNumberOrderer;
 /**
 * An extension of the Problem class which implements the intersection of two
 * Intervals.
 *
 * In one way to use this class, one passes Interval X, Interval Y and
 * Interval Z to the appropriate constructor. The IntervalIntersector object 
 * produced is a Problem, and one may manipulate it using any of the methods 
 * provided by the Problem class.
 *
 * For example, when the Problem instance p defined by
 *
 * <p><tt>Problem p = new IntervalIntersector(X,Y,Z);</tt></p>
 *
 * is satisfied, the following truth equation will be satisfied:
 *
 * <p><tt>Z == X ? Y</tt></p>.
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

public class IntervalIntersector extends Problem implements IProblem
{
	private static final long serialVersionUID = -5006932368783952709L;

	public IntervalIntersector(Interval X, Interval Y, Interval Z) throws Exception
  {
    IProblem p1=new Conjunction(new NaturalNumberOrderer(X.getLeft(),Y.getLeft()),new NaturalNumberEqualizer(Z.getLeft(),Y.getLeft()));
    IProblem p2=new Conjunction(new NaturalNumberOrderer(Y.getLeft(),X.getLeft()),new NaturalNumberEqualizer(Z.getLeft(),X.getLeft()));
    IProblem p3=new Conjunction(new NaturalNumberOrderer(X.getRight(),Y.getRight()),new NaturalNumberEqualizer(Z.getRight(),X.getRight()));
    IProblem p4=new Conjunction(new NaturalNumberOrderer(Y.getRight(),X.getRight()),new NaturalNumberEqualizer(Z.getRight(),Y.getRight()));
    IProblem problem=new Conjunction(new Disjunction(p1,p2),new Disjunction(p3,p4));
    this.setClauses(problem.getClauses());
  }
}
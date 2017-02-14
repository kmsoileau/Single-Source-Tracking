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
 * An extension of the Problem class which implements the union of two
 * Intervals. By this is meant the smallest Interval which contains both 
 * Intervals.
 *
 * In one way to use this class, one passes Interval X, Interval Y and
 * Interval Z to the appropriate constructor. The IntervalJoiner object 
 * produced is a Problem, and one may manipulate it using any of the methods 
 * provided by the Problem class.
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

public class IntervalJoiner extends Problem implements IProblem
{
	private static final long serialVersionUID = -4325758917160378843L;

	public IntervalJoiner(IInterval X, IInterval Y, IInterval Z) throws Exception
  {
		IProblem p1=new Conjunction(new NaturalNumberOrderer(X.getLeft(),Y.getLeft()),new NaturalNumberEqualizer(Z.getLeft(),X.getLeft()));
    IProblem p2=new Conjunction(new NaturalNumberOrderer(Y.getLeft(),X.getLeft()),new NaturalNumberEqualizer(Z.getLeft(),Y.getLeft()));
    IProblem p3=new Conjunction(new NaturalNumberOrderer(X.getRight(),Y.getRight()),new NaturalNumberEqualizer(Z.getRight(),Y.getRight()));
    IProblem p4=new Conjunction(new NaturalNumberOrderer(Y.getRight(),X.getRight()),new NaturalNumberEqualizer(Z.getRight(),X.getRight()));
    IProblem problem1=new Conjunction(new IntervalNonemptier(X),new IntervalNonemptier(Y),new Disjunction(p1,p2),new Disjunction(p3,p4));
    IProblem problem2=new Conjunction(new IntervalEmptier(X),new IntervalEqualizer(Y,Z));
    IProblem problem3=new Conjunction(new IntervalEmptier(Y),new IntervalEqualizer(X,Z));
    IProblem problem=new Disjunction(problem1,problem2,problem3);
    this.setClauses(problem.getClauses());
  }
}
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
 * An extension of the Problem class which implements the intersection 
 * of two Intervals. By this is meant the largest Interval which is 
 * contained by both Intervals.
 *
 * In one way to use this class, one passes Interval X, Interval Y and
 * Interval Z to the appropriate constructor. When the Problem is 
 * satisfied, Z will represent the meet of Intervals X and Y. The 
 * IntervalMeeter object produced is a Problem, and one may manipulate 
 * it using any of the methods provided by the Problem class.
 *
 * @author  Kerry Michael Soileau
 * <blockquote><pre>
 * ksoileau@yahoo.com
 * http://kerrysoileau.com/index.html
 * </pre></blockquote>
 * @version 1.1, 07/09/10
 * @see IBooleanVariable
 * @see IClause
 * @see IProblem
 * @see Problem
 */

public class IntervalMeeter extends Problem implements IProblem
{
	private static final long serialVersionUID = 4761204683006894327L;

	public IntervalMeeter(final IInterval X, final IInterval Y) throws Exception
  {
		final IProblem xisnonempty=new IntervalNonemptier(X);
		final IProblem yxisnonempty=new IntervalNonemptier(Y);
		final IProblem ylxr=new NaturalNumberOrderer(Y.getLeft(),X.getRight());
		final IProblem xlyr=new NaturalNumberOrderer(X.getLeft(),Y.getRight());
    
		final IProblem problem=new Conjunction(xisnonempty,yxisnonempty,ylxr,xlyr);
    this.setClauses(problem.getClauses());
  }
	
	public IntervalMeeter(final IInterval X, final IInterval Y, final IInterval Z) throws Exception
  {
		final IProblem x1=new Conjunction(new Disjunction(new IntervalEmptier(X),new IntervalEmptier(Y)),
				new IntervalEmptier(Z));
		final IProblem q1=new Conjunction(new NaturalNumberOrderer(X.getLeft(),Y.getLeft()),new NaturalNumberEqualizer(Z.getLeft(),Y.getLeft()));
    final IProblem q2=new Conjunction(new NaturalNumberOrderer(Y.getLeft(),X.getLeft()),new NaturalNumberEqualizer(Z.getLeft(),X.getLeft()));
    final IProblem q3=new Conjunction(new NaturalNumberOrderer(X.getRight(),Y.getRight()),new NaturalNumberEqualizer(Z.getRight(),X.getRight()));
    final IProblem q4=new Conjunction(new NaturalNumberOrderer(Y.getRight(),X.getRight()),new NaturalNumberEqualizer(Z.getRight(),Y.getRight()));
    final IProblem x2=new Conjunction(new Disjunction(q1,q2),new Disjunction(q3,q4));
    
    this.setClauses(new Disjunction(x1,x2).getClauses());
  }
}
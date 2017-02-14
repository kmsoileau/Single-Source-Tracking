package positronic.satisfiability.demos.interval;

import java.util.List;

import positronic.satisfiability.elements.BooleanLiteral;
import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;
import positronic.satisfiability.interval.IInterval;
import positronic.satisfiability.interval.Interval;
import positronic.satisfiability.interval.IntervalFixer;
import positronic.satisfiability.interval.IntervalNonemptier;
import positronic.satisfiability.naturalnumber.NaturalNumber;

public class IntervalNonemptierDemo 
{
  public static void main(String[] args) throws Exception
  {
    IInterval interval=new Interval(
    		new NaturalNumber(0L),
    		new NaturalNumber(24L));
    
    IProblem N1=new IntervalFixer(interval);
    
    IProblem A=new IntervalNonemptier(interval);
    
    IProblem problem=new Conjunction(N1,A);
    
    problem.sort();
    System.out.println(problem);
    List<?> s=problem.findModel(Problem.defaultSolver());
		if(s!=null && s.size()>0)
    {
      BooleanLiteral.interpret(s);
    	System.out.println("interval= "+interval);
    }
    else
      System.out.println("No solution.");
  }
}

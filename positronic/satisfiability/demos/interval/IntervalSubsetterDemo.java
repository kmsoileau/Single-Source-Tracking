package positronic.satisfiability.demos.interval;

import java.util.List;

import positronic.satisfiability.elements.BooleanLiteral;
import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;
import positronic.satisfiability.interval.Interval;
import positronic.satisfiability.interval.IntervalFixer;
import positronic.satisfiability.interval.IntervalSubsetter;
import positronic.satisfiability.naturalnumber.NaturalNumber;

public class IntervalSubsetterDemo 
{
  public static void main(String[] args) throws Exception
  {
    Interval interval1=new Interval(
    		new NaturalNumber("X1",23L),
    		new NaturalNumber("Y1",1L));
    Interval interval2=new Interval(
    		new NaturalNumber("X2",23L),
    		new NaturalNumber("Y2",2L));
    
    IntervalFixer N1=new IntervalFixer(interval1);
    IntervalFixer N2=new IntervalFixer(interval2);
    
    IProblem problem=new Conjunction(N1,N2,
    		new IntervalSubsetter(interval1,interval2));
    
    problem.sort();
    System.out.println(problem);
    List<?> s=problem.findModel(Problem.defaultSolver());
		if(s!=null && s.size()>0)
    {
      BooleanLiteral.interpret(s);
    	System.out.println("I1= "+interval1);
    	System.out.println("I2= "+interval2);
    }
    else
      System.out.println("No solution.");
  }
}

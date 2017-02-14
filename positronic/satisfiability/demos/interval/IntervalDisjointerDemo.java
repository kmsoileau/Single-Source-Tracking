package positronic.satisfiability.demos.interval;

import java.util.List;

import positronic.satisfiability.elements.BooleanLiteral;
import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;
import positronic.satisfiability.interval.IInterval;
import positronic.satisfiability.interval.Interval;
import positronic.satisfiability.interval.IntervalDisjointer;
import positronic.satisfiability.interval.IntervalFixer;
import positronic.satisfiability.naturalnumber.NaturalNumber;

public class IntervalDisjointerDemo 
{
	public static void main(String[] args) throws Exception
  {
    IInterval interval1=new Interval(
    		new NaturalNumber("X1",29L),
    		new NaturalNumber("Y1",28L));
    IInterval interval2=new Interval(
    		new NaturalNumber("X2",7L),
    		new NaturalNumber("Y2",2L));
    
    IProblem N1=new IntervalFixer(interval1);
    IProblem N2=new IntervalFixer(interval2);
    
    IProblem problem=new Conjunction(N1,N2,new IntervalDisjointer(interval1,interval2));
    
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

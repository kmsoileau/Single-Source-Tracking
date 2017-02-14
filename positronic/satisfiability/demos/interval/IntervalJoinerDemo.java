package positronic.satisfiability.demos.interval;

import java.util.List;

import positronic.satisfiability.elements.BooleanLiteral;
import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;
import positronic.satisfiability.interval.Interval;
import positronic.satisfiability.interval.IntervalFixer;
import positronic.satisfiability.interval.IntervalJoiner;
import positronic.satisfiability.naturalnumber.NaturalNumber;

public class IntervalJoinerDemo 
{
  public static void main(String[] args) throws Exception
  {
    Interval I3=new Interval();

    Interval I1=new Interval(
    		new NaturalNumber("X1",1L),
    		new NaturalNumber("Y1",23L));
    Interval I2=new Interval(
    		new NaturalNumber("X2",26L),
    		new NaturalNumber("Y2",4L));
    
    IntervalFixer N1=new IntervalFixer(I1);
    IntervalFixer N2=new IntervalFixer(I2);
    
    IProblem A=new IntervalJoiner(I1,I2,I3);
    
    IProblem problem=new Conjunction(N1,N2,A);
    problem.sort();
    System.out.println(problem);
    List<?> s=problem.findModel(Problem.defaultSolver());
		if(s!=null && s.size()>0)
    {
      BooleanLiteral.interpret(s);
    	System.out.println("I1= "+I1);
    	System.out.println("I2= "+I2);
    	System.out.println("I3= "+I3);
    }
    else
      System.out.println("No solution.");
  }
}

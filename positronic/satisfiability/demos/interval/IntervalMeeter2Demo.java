package positronic.satisfiability.demos.interval;

import java.util.List;

import positronic.satisfiability.elements.BooleanLiteral;
import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;
import positronic.satisfiability.interval.Interval;
import positronic.satisfiability.interval.IntervalFixer;
import positronic.satisfiability.interval.IntervalMeeter;
import positronic.satisfiability.naturalnumber.NaturalNumber;

public class IntervalMeeter2Demo 
{
  public static void main(String[] args) throws Exception
  {
    Interval I1=new Interval(
    		new NaturalNumber("X1",2L),
    		new NaturalNumber("Y1",29L));
    Interval I2=new Interval(
    		new NaturalNumber("X2",26L),
    		new NaturalNumber("Y2",29L));
    
    IntervalFixer N1=new IntervalFixer(I1);
    IntervalFixer N2=new IntervalFixer(I2);
    
    IProblem A=new IntervalMeeter(I1,I2);
    
    IProblem problem=new Conjunction(N1,N2,A);
    problem.sort();
    System.out.println(problem);
    List<?> s=problem.findModel(Problem.defaultSolver());
		if(s!=null && s.size()>0)
    {
      BooleanLiteral.interpret(s);
    	System.out.println("I1= "+I1);
    	System.out.println("I2= "+I2);
    }
    else
      System.out.println("No solution.");
  }
}

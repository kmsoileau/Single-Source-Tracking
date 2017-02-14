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

public class IntervalMeeterDemo 
{
  public static void main(String[] args) throws Exception
  {
    Interval I3=new Interval();

    Interval I1=new Interval(
    		new NaturalNumber("X1",5L),
    		new NaturalNumber("Y1",25L));
    Interval I2=new Interval(
    		new NaturalNumber("X2",3L),
    		new NaturalNumber("Y2",25L));
    
    IntervalFixer N1=new IntervalFixer(I1);
    IntervalFixer N2=new IntervalFixer(I2);
    
    IProblem A=new IntervalMeeter(I1,I2,I3);
    
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

package positronic.satisfiability.rectangle;

import java.util.List;

import positronic.satisfiability.elements.BooleanLiteral;
import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;
import positronic.satisfiability.interval.Interval;
import positronic.satisfiability.naturalnumber.NaturalNumber;

public class RectangleSubsetterDemo 
{
  public static void main(String[] args) throws Exception
  {
    IRectangle rectangle1=new Rectangle(
    		new Interval(
        		new NaturalNumber("X1",3L),
        		new NaturalNumber("Y1",4)),
        new Interval(
            new NaturalNumber("X2",12L),
            new NaturalNumber("Y2",15L)));
    
    IRectangle rectangle2=new Rectangle(
    		new Interval(
        		new NaturalNumber("X3",3L),
        		new NaturalNumber("Y3",3)),
        new Interval(
            new NaturalNumber("X4",12L),
            new NaturalNumber("Y4",17L)));
    
    RectangleFixer N1=new RectangleFixer(rectangle1);
    RectangleFixer N2=new RectangleFixer(rectangle2);
    
    IProblem problem=new Conjunction(N1,N2,
    		new RectangleSubsetter(rectangle1,rectangle2));
    
    problem.sort();
    System.out.println(problem);
    List<?> s=problem.findModel(Problem.defaultSolver());
		if(s!=null && s.size()>0)
    {
      BooleanLiteral.interpret(s);
    	System.out.println("rectangle 1= "+rectangle1);
    	System.out.println("rectangle 2= "+rectangle2);
    }
    else
      System.out.println("No solution.");
  }
}

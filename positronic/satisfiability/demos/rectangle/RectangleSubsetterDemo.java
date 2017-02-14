package positronic.satisfiability.demos.rectangle;

import java.util.List;

import positronic.satisfiability.elements.BooleanLiteral;
import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;
import positronic.satisfiability.interval.Interval;
import positronic.satisfiability.naturalnumber.NaturalNumber;
import positronic.satisfiability.rectangle.IRectangle;
import positronic.satisfiability.rectangle.Rectangle;
import positronic.satisfiability.rectangle.RectangleFixer;
import positronic.satisfiability.rectangle.RectangleSubsetter;

public class RectangleSubsetterDemo 
{
  public static void main(String[] args) throws Exception
  {
    IRectangle rectangle1=new Rectangle(4,4,13,15);
    
    IRectangle rectangle2=new Rectangle(
    		new Interval(
        		new NaturalNumber("X3",3L),
        		new NaturalNumber("Y3",5)),
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

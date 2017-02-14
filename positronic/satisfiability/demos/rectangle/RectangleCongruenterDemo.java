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
import positronic.satisfiability.rectangle.RectangleCongruenter;
import positronic.satisfiability.rectangle.RectangleFixer;

public class RectangleCongruenterDemo 
{
  public static void main(String[] args) throws Exception
  {
  	IRectangle rectangle1=new Rectangle(
    		new Interval(
        		new NaturalNumber("X1",13L),
        		new NaturalNumber("Y1",14L)),
        new Interval(
            new NaturalNumber("X2",12L),
            new NaturalNumber("Y2",15L)));
    
    IRectangle rectangle2=new Rectangle(
    		new Interval(
        		new NaturalNumber("X3",13L),
        		new NaturalNumber("Y3",14L)),
        new Interval(
            new NaturalNumber("X4",22L),
            new NaturalNumber("Y4",25L)));
    
    RectangleFixer N1=new RectangleFixer(rectangle1);
    RectangleFixer N2=new RectangleFixer(rectangle2);
    
    IProblem problem=new Conjunction(N1,N2,
    		new RectangleCongruenter(rectangle1,rectangle2));
    
    problem.sort();
    System.out.println(problem);
    
    List<?> s=problem.findModel(Problem.defaultSolver());
		if(s!=null && s.size()>0)
    {
      BooleanLiteral.interpret(s);
    	System.out.println("rectangle1= "+rectangle1);
    	System.out.println("rectangle2= "+rectangle2);
    }
    else
      System.out.println("No solution.");
  }
}

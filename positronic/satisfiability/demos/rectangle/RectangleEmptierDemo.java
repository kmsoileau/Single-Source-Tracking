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
import positronic.satisfiability.rectangle.RectangleEmptier;
import positronic.satisfiability.rectangle.RectangleFixer;

public class RectangleEmptierDemo 
{
  public static void main(String[] args) throws Exception
  {
  	IRectangle rectangle=new Rectangle(
  			new Interval(
  					new NaturalNumber("X1",25L),
  					new NaturalNumber("Y1",24L)),
    		new Interval(
        		new NaturalNumber("X2",14L),
        		new NaturalNumber("Y2",14L)));
    
    IProblem N1=new RectangleFixer(rectangle);
    
    IProblem A=new RectangleEmptier(rectangle);
    
    IProblem problem=new Conjunction(N1,A);
    
    problem.sort();
    System.out.println(problem);
    List<?> s=problem.findModel(Problem.defaultSolver());
		if(s!=null && s.size()>0)
    {
      BooleanLiteral.interpret(s);
    	System.out.println("rectangle= "+rectangle);
    }
    else
      System.out.println("No solution.");
  }
}

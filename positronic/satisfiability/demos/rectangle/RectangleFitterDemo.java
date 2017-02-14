package positronic.satisfiability.demos.rectangle;

import java.util.List;

import positronic.satisfiability.elements.BooleanLiteral;
import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;
import positronic.satisfiability.rectangle.IRectangle;
import positronic.satisfiability.rectangle.Rectangle;
import positronic.satisfiability.rectangle.RectangleCongruenter;
import positronic.satisfiability.rectangle.RectangleDisjointer;
import positronic.satisfiability.rectangle.RectangleFixer;
import positronic.satisfiability.rectangle.RectangleSubsetter;

public class RectangleFitterDemo 
{
  public static void main(String[] args) throws Exception
  {
  	IRectangle rectangleenclosure=new Rectangle(0,10,0,10);
  	IRectangle rectangle=new Rectangle(0,10,0,3);
    IRectangle rectangle1=new Rectangle();
    IRectangle rectangle2=new Rectangle();
    
    IProblem problem=new Conjunction(new IProblem[]{
    		new RectangleFixer(rectangleenclosure),
    		new RectangleFixer(rectangle),
    		new RectangleSubsetter(rectangle1,rectangleenclosure),
    		new RectangleSubsetter(rectangle2,rectangleenclosure),
    		new RectangleCongruenter(rectangle,rectangle1),
    		new RectangleCongruenter(rectangle,rectangle2),
    		new RectangleDisjointer(rectangle1,rectangle2)});
    
    problem.sort();
    System.out.println(problem);
    
    List<?> s=problem.findModel(Problem.defaultSolver());
		if(s!=null && s.size()>0)
    {
      BooleanLiteral.interpret(s);
      System.out.println("rectangleenclosure= "+rectangleenclosure);
    	System.out.println("rectangle= "+rectangle);
    	System.out.println("rectangle1= "+rectangle1);
    	System.out.println("rectangle2= "+rectangle2);
    }
    else
      System.out.println("No solution.");
  }
}

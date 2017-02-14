package positronic.satisfiability.demos.bit;

import java.util.List;

import positronic.satisfiability.elements.BitFixer;
import positronic.satisfiability.elements.BitOrderer;
import positronic.satisfiability.elements.BooleanVariable;
import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.IBooleanLiteral;
import positronic.satisfiability.elements.IBooleanVariable;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;

public class BitOrdererDemo
{
  public static void main(String[] args) throws Exception
  {
    // Create the BooleanVariables:
    IBooleanVariable x=BooleanVariable.getBooleanVariable("x");
    IBooleanVariable y=BooleanVariable.getBooleanVariable("y");

    // Construct the object that implements the constraint x <= y :
    IProblem bitOrderer1 = new BitOrderer(x,y);
    System.out.println(bitOrderer1);

    // Constrain the values of x and y :
    IProblem bfx1=new BitFixer(x,true);
    IProblem bfy1=new BitFixer(y,false);

    //Combine the constraints into a Problem object :
    IProblem p1=new Conjunction(bitOrderer1,bfx1,bfy1);
    System.out.println(p1);
    //Find a solution to the Problem object :
    List<IBooleanLiteral> v1=p1.findModel(Problem.defaultSolver());
    System.out.println(v1);
  }
}
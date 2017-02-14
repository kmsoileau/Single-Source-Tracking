package positronic.satisfiability.demos.bit;

import positronic.satisfiability.elements.BitNoter;
import positronic.satisfiability.elements.BooleanLiteral;
import positronic.satisfiability.elements.BooleanVariable;
import positronic.satisfiability.elements.IBooleanVariable;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;

public class BitNoterDemo
{
  public static void main(String[] args) throws Exception
  {
    IBooleanVariable x=BooleanVariable.getBooleanVariable("x");
    IBooleanVariable y=BooleanVariable.getBooleanVariable("y");

    IProblem bitNoter1 = new BitNoter(x,y);
    System.out.println(bitNoter1);
    BooleanLiteral.interpret(bitNoter1.findModel(Problem.defaultSolver()));
    System.out.println("x = "+x.getValue());
    System.out.println("y = "+y.getValue());
  }
}
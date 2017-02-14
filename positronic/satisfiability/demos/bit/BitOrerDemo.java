package positronic.satisfiability.demos.bit;

import positronic.satisfiability.elements.BitOrer;
import positronic.satisfiability.elements.BooleanLiteral;
import positronic.satisfiability.elements.BooleanVariable;
import positronic.satisfiability.elements.IBooleanVariable;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;

public class BitOrerDemo
{
  public static void main(String[] args) throws Exception
  {
    IBooleanVariable x=BooleanVariable.getBooleanVariable("x");
    IBooleanVariable y=BooleanVariable.getBooleanVariable("y");
    IBooleanVariable z=BooleanVariable.getBooleanVariable("z");

    IProblem bitOrer1 = new BitOrer(x,y,z);
    System.out.println(bitOrer1);
    BooleanLiteral.interpret(bitOrer1.findModel(Problem.defaultSolver()));
    System.out.println("x = "+x.getValue());
    System.out.println("y = "+y.getValue());
    System.out.println("z = "+z.getValue());
  }
}
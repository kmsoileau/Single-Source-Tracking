package positronic.satisfiability.demos.bit;

import positronic.satisfiability.elements.BitNander;
import positronic.satisfiability.elements.BooleanLiteral;
import positronic.satisfiability.elements.BooleanVariable;
import positronic.satisfiability.elements.IBooleanVariable;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;

public class BitNanderDemo
{
  public static void main(String[] args) throws Exception
  {
    IBooleanVariable x=BooleanVariable.getBooleanVariable("x");
    IBooleanVariable y=BooleanVariable.getBooleanVariable("y");
    IBooleanVariable z=BooleanVariable.getBooleanVariable("z");

    IProblem bitNander1 = new BitNander(x,y,z);
    System.out.println(bitNander1);
    BooleanLiteral.interpret(bitNander1.findModel(Problem.defaultSolver()));
    System.out.println("x = "+x.getValue());
    System.out.println("y = "+y.getValue());
    System.out.println("z = "+z.getValue());
  }
}
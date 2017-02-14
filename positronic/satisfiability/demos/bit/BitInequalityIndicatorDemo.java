package positronic.satisfiability.demos.bit;

import positronic.satisfiability.elements.BitInequalityIndicator;
import positronic.satisfiability.elements.BooleanLiteral;
import positronic.satisfiability.elements.BooleanVariable;
import positronic.satisfiability.elements.IBooleanVariable;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;

 public class BitInequalityIndicatorDemo
{
  public static void main(String[] args) throws Exception
  {
    IBooleanVariable x=BooleanVariable.getBooleanVariable("x");
    IBooleanVariable y=BooleanVariable.getBooleanVariable("y");
    IBooleanVariable z=BooleanVariable.getBooleanVariable("z");

    IProblem bitInequalityIndicator1 = new BitInequalityIndicator(x,y,z);

    System.out.println(bitInequalityIndicator1);
    BooleanLiteral.interpret(bitInequalityIndicator1.findModel(Problem.defaultSolver()));
    System.out.println("x = "+x.getValue());
    System.out.println("y = "+y.getValue());
    System.out.println("z = "+z.getValue());
  }
}


package positronic.satisfiability.demos.bit;

import positronic.satisfiability.elements.BitEqualityIndicator;
import positronic.satisfiability.elements.BooleanLiteral;
import positronic.satisfiability.elements.BooleanVariable;
import positronic.satisfiability.elements.IBooleanVariable;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;

public class BitEqualityIndicatorDemo
{
  public static void main(String[] args) throws Exception
  {
    IBooleanVariable x=BooleanVariable.getBooleanVariable("x");
    IBooleanVariable y=BooleanVariable.getBooleanVariable("y");
    IBooleanVariable z=BooleanVariable.getBooleanVariable("z");

    IProblem bitEqualityIndicator1 = new BitEqualityIndicator(x,y,z);

    System.out.println(bitEqualityIndicator1);
    
    BooleanLiteral.interpret(bitEqualityIndicator1.findModel(Problem.defaultSolver()));
    System.out.println("x = "+x.getValue());
    System.out.println("y = "+y.getValue());
    System.out.println("z = "+z.getValue());
  }
}


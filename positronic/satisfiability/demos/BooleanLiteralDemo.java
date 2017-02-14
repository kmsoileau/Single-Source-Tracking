package positronic.satisfiability.demos;

import positronic.satisfiability.elements.BooleanLiteral;
import positronic.satisfiability.elements.BooleanVariable;
import positronic.satisfiability.elements.IBooleanLiteral;

public class BooleanLiteralDemo
{
  public static void main(String[] args) throws Exception
  {
    IBooleanLiteral booleanLiteral1 = BooleanLiteral.getBooleanLiteral(BooleanVariable.getBooleanVariable("x"),true);
    System.out.println(booleanLiteral1);
    IBooleanLiteral booleanLiteral2 = BooleanLiteral.getBooleanLiteral(BooleanVariable.getBooleanVariable("y"),false);
    System.out.println(booleanLiteral2);
    IBooleanLiteral booleanLiteral3 = BooleanLiteral.getBooleanLiteral(BooleanVariable.getBooleanVariable("x"),true);
    if(booleanLiteral1==booleanLiteral3)
    	System.out.println("booleanLiteral1 is the same object as booleanLiteral3.");
  }
}
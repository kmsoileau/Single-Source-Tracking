package positronic.satisfiability.demos;

import positronic.satisfiability.elements.BooleanVariable;
import positronic.satisfiability.elements.IBooleanVariable;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.ThreeBitAdder;

public class ThreeSATProblemDemo2
{
  public static void main(String[] args) throws Exception
  {
    IBooleanVariable w=BooleanVariable.getBooleanVariable("w");
    IBooleanVariable x=BooleanVariable.getBooleanVariable("x");
    IBooleanVariable y=BooleanVariable.getBooleanVariable("y");
    IBooleanVariable z=BooleanVariable.getBooleanVariable("z");
    IBooleanVariable c=BooleanVariable.getBooleanVariable("c");

    ThreeBitAdder threeBitAdder1 = new ThreeBitAdder(w,x,y,z,c);

    System.out.println(threeBitAdder1);
    
    IProblem p=threeBitAdder1.toThreeSatProblem();
    System.out.println(p);
    
    System.out.println(p.toXML());
  }
}
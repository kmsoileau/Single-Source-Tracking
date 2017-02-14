package positronic.satisfiability.demos.bit;

import positronic.satisfiability.elements.BooleanVariable;
import positronic.satisfiability.elements.IBooleanVariable;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;
import positronic.satisfiability.elements.ThreeBitAdder;

public class ThreeBitAdderDemo
{
  public static void main(String[] args) throws Exception
  {
    IBooleanVariable w=BooleanVariable.getBooleanVariable("w");
    IBooleanVariable x=BooleanVariable.getBooleanVariable("x");
    IBooleanVariable y=BooleanVariable.getBooleanVariable("y");
    IBooleanVariable z=BooleanVariable.getBooleanVariable("z");
    IBooleanVariable c=BooleanVariable.getBooleanVariable("c");

    IProblem threeBitAdder1 = new ThreeBitAdder(w,x,y,z,c);

    System.out.println(threeBitAdder1);
    
    IProblem p1=threeBitAdder1.combineSinglyMatchingClauses();
    p1.sort();
    System.out.println(p1);
    
    IProblem p2=p1.combineSinglyMatchingClauses();
    p2.sort();
    System.out.println(p2);
    
    IProblem p3=p2.combineSinglyMatchingClauses();
    p3.sort();
    System.out.println(p3);
    System.out.println(((Problem)p3).factorization());
  }
}
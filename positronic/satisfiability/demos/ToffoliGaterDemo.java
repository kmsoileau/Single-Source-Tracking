package positronic.satisfiability.demos;

import java.util.List;

import positronic.satisfiability.elements.BitFixer;
import positronic.satisfiability.elements.BooleanLiteral;
import positronic.satisfiability.elements.BooleanVariable;
import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.IBooleanLiteral;
import positronic.satisfiability.elements.IBooleanVariable;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.ToffoliGater;

public class ToffoliGaterDemo
{
  public static void main(String[] args) throws Exception
  {
    // Create the BooleanVariables:
    IBooleanVariable A=BooleanVariable.getBooleanVariable("A");
    IBooleanVariable B=BooleanVariable.getBooleanVariable("B");
    IBooleanVariable C=BooleanVariable.getBooleanVariable("C");
    IBooleanVariable P=BooleanVariable.getBooleanVariable("P");
    IBooleanVariable Q=BooleanVariable.getBooleanVariable("Q");
    IBooleanVariable R=BooleanVariable.getBooleanVariable("R");

    // Construct the object that implements the constraint x & y = z :
    IProblem toffoliGater1 = new ToffoliGater(A,B,C,P,Q,R);
    System.out.println(toffoliGater1);

    // Constrain the values of A, B and C:
    IProblem a1=new BitFixer(A,true);
    IProblem b1=new BitFixer(B,true);
    IProblem c1=new BitFixer(C,false);

    //Combine the constraints into a Problem object :
    IProblem p1=new Conjunction(toffoliGater1,a1,b1,c1);
    System.out.println(p1);
    
    //Find a solution to the Problem object :
    List<IBooleanLiteral> v1=p1.findModel();
    System.out.println(v1);
    BooleanLiteral.interpret(v1);

    System.out.println("----!-----------$");
    System.out.println("A = "+A.getValue());
    System.out.println("B = "+B.getValue());
    System.out.println("C = "+C.getValue());
    System.out.println("P = "+P.getValue());
    System.out.println("Q = "+Q.getValue());
    System.out.println("R = "+R.getValue());
    
    IProblem rp=p1.resolve(v1);
    System.out.println("::::::::::");
    System.out.println(rp);
  }
}
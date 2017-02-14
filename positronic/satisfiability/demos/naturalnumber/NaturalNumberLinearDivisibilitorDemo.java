package positronic.satisfiability.demos.naturalnumber;

import java.util.List;

import positronic.satisfiability.elements.BooleanLiteral;
import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.IBooleanLiteral;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;
import positronic.satisfiability.naturalnumber.INaturalNumber;
import positronic.satisfiability.naturalnumber.NaturalNumber;
import positronic.satisfiability.naturalnumber.NaturalNumberFixer;
import positronic.satisfiability.naturalnumber.NaturalNumberLinearDivisibilitor;

/**
 * <p>Title: NaturalNumberLinearDivisibilitorDemo</p>
 * <p>Description: TBS</p>
 * <p>Copyright (c) 2010</p>
 * <p>Company: Positronic Software</p>
 * @author Kerry Michael Soileau
 * @version 1.0
 */

public class NaturalNumberLinearDivisibilitorDemo
{
  public static void main(String[] args) throws Exception
  {
    INaturalNumber A=new NaturalNumber("A");
    INaturalNumber X=new NaturalNumber("X");
    INaturalNumber C=new NaturalNumber("C");

    IProblem p=new Conjunction(
    		new NaturalNumberFixer(A,3),
    		new NaturalNumberFixer(C,35),
    		new NaturalNumberLinearDivisibilitor(A,X,C));
    
    System.out.println(p);

    List<IBooleanLiteral> s=p.findModel(Problem.defaultSolver());
	if(s!=null && s.size()>0)
    {
		BooleanLiteral.interpret(s);
		System.out.println("A= "+A);
		System.out.println("X= "+X);
		System.out.println("C= "+C);
    }
    else
    	System.out.println("No solution.");
  }
}
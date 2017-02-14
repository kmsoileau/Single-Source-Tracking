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

public class NaturalNumberGreatestCommonDivisorDemo
{
  public static void main(String[] args) throws Exception
  {
    INaturalNumber X=new NaturalNumber("X");
    INaturalNumber Y=new NaturalNumber("Y");
    
    INaturalNumber GCD=new NaturalNumber();

    IProblem p=new Conjunction(new IProblem[]{
    		new NaturalNumberFixer(X,14),
    			new NaturalNumberFixer(Y,56),
    			new NaturalNumberGreatestCommonDivisor(X,Y,GCD)
    });
    
    System.out.println(p);
    
    List<IBooleanLiteral> s=p.findModel(Problem.defaultSolver());
		if(s!=null && s.size()>0)
    {
      BooleanLiteral.interpret(s);
      System.out.println("X = "+X);
      System.out.println("Y = "+Y);
      System.out.println("GCD = "+GCD);
    }
		else
      System.out.println("No solution.");
  }
}
package positronic.satisfiability.demos;

import java.util.List;

import positronic.satisfiability.elements.BooleanLiteral;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;
import positronic.satisfiability.elements.ProblemNonequivalenter;
import positronic.satisfiability.naturalnumber.NaturalNumber;
import positronic.satisfiability.naturalnumber.NaturalNumberDoubler;
import positronic.satisfiability.naturalnumber.NaturalNumberFixer;

public class ProblemNonequivalenterDemo
{
  public static void main(String[] args) throws Exception
  {
    NaturalNumber X=new NaturalNumber("X");
    NaturalNumber Y=new NaturalNumber("Y");

    IProblem pp=new ProblemNonequivalenter(
    		new NaturalNumberDoubler(X,Y),
    		new NaturalNumberFixer(Y,3));
    
    pp.sort();
    System.out.println(pp);
    List<?> s=pp.findModel(Problem.defaultSolver());
		if(s!=null && s.size()>0)
    {
      BooleanLiteral.interpret(s);
    	System.out.println("X= "+X);
    	System.out.println("Y= "+Y);
    }
    else
      System.out.println("No solution.");
  }
}

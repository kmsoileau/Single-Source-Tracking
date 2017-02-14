package positronic.satisfiability.demos.naturalnumber;

import java.util.List;

import positronic.satisfiability.elements.BooleanLiteral;
import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.IBooleanLiteral;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;
import positronic.satisfiability.naturalnumber.NaturalNumber;
import positronic.satisfiability.naturalnumber.NaturalNumberFixer;
import positronic.satisfiability.naturalnumber.NaturalNumberOrderer;

public class NaturalNumberOrdererDemo 
{
  public static void main(String[] args) throws Exception
  {
    NaturalNumber X=new NaturalNumber("X",14L);
    NaturalNumber Y=new NaturalNumber("Y",15L);

    NaturalNumberFixer N1=new NaturalNumberFixer(X);
    NaturalNumberFixer N2=new NaturalNumberFixer(Y);
    IProblem A=new NaturalNumberOrderer(X,Y);
    
    IProblem problem=new Conjunction(N1,N2,A);
    problem.sort();
    System.out.println(problem);
    //List s=PartialSolution.solveList(problem);
    List<IBooleanLiteral> s=problem.findModel(Problem.defaultSolver());
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

package positronic.satisfiability.demos;

import java.util.List;

import positronic.satisfiability.elements.BooleanLiteral;
import positronic.satisfiability.elements.BooleanVariable;
import positronic.satisfiability.elements.IBooleanLiteral;
import positronic.satisfiability.elements.IBooleanVariable;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;
import positronic.satisfiability.elements.ProblemBitLinker;

public class ProblemBitLinkerDemo 
{
	public static void main(String[] args) throws Exception
  {
    IBooleanVariable b=BooleanVariable.getBooleanVariable("b");

    IProblem p=Problem.unsolvableProblem();
    
    IProblem testProblem=new ProblemBitLinker(p,b);
    
    System.out.println(testProblem);
    
    List<IBooleanLiteral> s=testProblem.findModel(Problem.defaultSolver());
		if(s!=null && s.size()>0)
    {
      BooleanLiteral.interpret(s);
    	System.out.println("b= "+b);
    }
    else
      System.out.println("No solution.");
  }
}

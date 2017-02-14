package positronic.satisfiability.demos.integer;

import java.util.List;

import positronic.satisfiability.elements.BooleanLiteral;
import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.IBooleanLiteral;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;
import positronic.satisfiability.integer.IInteger;
import positronic.satisfiability.integer.Integer;
import positronic.satisfiability.integer.IntegerFixer;
import positronic.satisfiability.integer.IntegerOrderer;

public class IntegerOrdererDemo 
{
  public static void main(String[] args) throws Exception
  {
    IInteger X=new Integer("X",0L);
    IInteger Y=new Integer("Y",4L);

    IProblem N1=new IntegerFixer(X);
    IProblem N2=new IntegerFixer(Y);
    IProblem A=new IntegerOrderer(X,Y);
    
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
		
	String sss=((Problem)problem).toSatSimTable();
	System.out.println(sss);
  }
}

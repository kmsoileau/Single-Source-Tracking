package positronic.util.schedule.precedence;

import java.util.List;

import positronic.satisfiability.elements.BooleanLiteral;
import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;
import positronic.satisfiability.naturalnumber.NaturalNumberFixer;
import positronic.satisfiability.naturalnumber.NaturalNumberOrderer;

public class SchedulingDemo 
{
	public static void main(String[] args) throws Exception 
	{
    ITask Q=new Task("Q");
    ITask A=new Task("A");
    ITask X=new Task("X");
    ITask F=new Task("F");
    
    IProblem[] tp={
    		new TaskPrecedenceFixer(Q,A),
    		new TaskPrecedenceFixer(X,A),
    		new TaskPrecedenceFixer(Q,X),
    		new TaskPrecedenceFixer(X,F)};
    
    IProblem cd1=new NaturalNumberFixer(A.Completion(),20);
    IProblem cd2=new NaturalNumberOrderer(1,Q.Start());
    
    IProblem[] df={
    		new DurationFixer(Q,2),
    		new DurationFixer(A,3),
    		new DurationFixer(X,4),
    		new DurationFixer(F,2)};
    
    
    IProblem problem=new Conjunction(
    		new Conjunction(tp),cd1,new Conjunction(df),cd2);

    System.out.println(problem);
    
    List<?> s=problem.findModel(Problem.defaultSolver());
		if(s!=null && s.size()>0)
    {
      BooleanLiteral.interpret(s);
      System.out.println("Q start date = "+Q.Start());
    	System.out.println("Q completion date = "+Q.Completion());
    	System.out.println("A start date = "+A.Start());
    	System.out.println("A completion date = "+A.Completion());
    	System.out.println("X start date = "+X.Start());
    	System.out.println("X completion date = "+X.Completion());
    	System.out.println("F start date = "+F.Start());
    	System.out.println("F completion date = "+F.Completion());
    }
    else
      System.out.println("No solution.");
  }
}

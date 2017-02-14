package positronic.satisfiability.demos;

import java.util.List;

import positronic.satisfiability.elements.BooleanLiteral;
import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;
import positronic.satisfiability.elements.ProblemDenier;
import positronic.satisfiability.naturalnumber.INaturalNumber;
import positronic.satisfiability.naturalnumber.NaturalNumber;
import positronic.satisfiability.naturalnumberlist.INaturalNumberList;
import positronic.satisfiability.naturalnumberlist.NaturalNumberList;
import positronic.satisfiability.naturalnumberlist.NaturalNumberListFixer;
import positronic.satisfiability.naturalnumberlist.NaturalNumberListMembership;

public class ProblemDenierDemo2
{
  public static void main(String[] args) throws Exception
  { 
    INaturalNumberList X=new NaturalNumberList("data",new long[]{2,7,1,8,2,8,1,8,3,4,5,6,2});
    IProblem fix=new NaturalNumberListFixer(X);
    
    INaturalNumber A=new NaturalNumber("A");
    INaturalNumber B=new NaturalNumber("B");
		IProblem AisIn=new NaturalNumberListMembership(A,X);
		IProblem BisNotIn=new ProblemDenier(new NaturalNumberListMembership(B,X));
    
    IProblem problem=new Conjunction(fix,AisIn,BisNotIn);
    System.out.println(problem);
    
    List<?> s=problem.findModel(Problem.defaultSolver());
		if(s!=null && s.size()>0)
    {
      BooleanLiteral.interpret(s);
      System.out.println("A = "+A);
      System.out.println("B = "+B);
    }
    else
      System.out.println("No solution.");
  }
}
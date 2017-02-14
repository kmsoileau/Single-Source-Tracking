package positronic.satisfiability.demos.naturalnumberlist;

import java.util.List;

import positronic.satisfiability.elements.BooleanLiteral;
import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.IBooleanLiteral;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;
import positronic.satisfiability.naturalnumberlist.INaturalNumberList;
import positronic.satisfiability.naturalnumberlist.NaturalNumberList;
import positronic.satisfiability.naturalnumberlist.NaturalNumberListFixer;
import positronic.satisfiability.naturalnumberlist.NaturalNumberListNonrepeater;

public class NaturalNumberListNonrepeaterDemo 
{
  public static void main(String[] args) throws Exception
  {
    INaturalNumberList testList=new NaturalNumberList("y",new long[]
    {
      5,6,2,4
    });
    IProblem problem=new Conjunction(new NaturalNumberListFixer(testList),new NaturalNumberListNonrepeater(testList));
    System.out.println(problem);
    List<IBooleanLiteral> s=problem.findModel(Problem.defaultSolver());
		if(s!=null && s.size()>0)
    {
      BooleanLiteral.interpret(s);
    	System.out.println("s2= "+testList);
    }
    else
      System.out.println("No solution.");
  }
}
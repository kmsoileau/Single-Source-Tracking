package positronic.satisfiability.demos.naturalnumberlist;

import java.util.List;

import positronic.satisfiability.elements.BooleanLiteral;
import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.IBooleanLiteral;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.naturalnumberlist.INaturalNumberList;
import positronic.satisfiability.naturalnumberlist.NaturalNumberList;
import positronic.satisfiability.naturalnumberlist.NaturalNumberListFixer;
import positronic.satisfiability.naturalnumberlist.NaturalNumberListRepeater;

public class NaturalNumberListRepeaterDemo 
{
  public static void main(String[] args) throws Exception
  {
    INaturalNumberList testList=new NaturalNumberList("y",new long[]
    {
      7,
      5,
      2,
      4
    });
    IProblem problem=new Conjunction(
    		new NaturalNumberListFixer(testList),
    		new NaturalNumberListRepeater(testList));
    System.out.println(problem);
    List<IBooleanLiteral> s=problem.findModel();
		if(s!=null && s.size()>0)
    {
      BooleanLiteral.interpret(s);
    	System.out.println("s2= "+testList);
    }
    else
      System.out.println("No solution.");
  }
}
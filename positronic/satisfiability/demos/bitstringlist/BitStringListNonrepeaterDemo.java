package positronic.satisfiability.demos.bitstringlist;

import java.util.List;

import positronic.satisfiability.bitstringlist.BitStringList;
import positronic.satisfiability.bitstringlist.BitStringListFixer;
import positronic.satisfiability.bitstringlist.BitStringListNonrepeater;
import positronic.satisfiability.bitstringlist.IBitStringList;
import positronic.satisfiability.elements.BooleanLiteral;
import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.IBooleanLiteral;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;

public class BitStringListNonrepeaterDemo 
{
  public static void main(String[] args) throws Exception
  {
    IBitStringList testList=new BitStringList("y",new boolean[][]
    {
      {true,false,true},
      {false,true,false,true},
      {false,true,false},
      {true,false,false}
    });
    IProblem problem=new Conjunction(
    		new BitStringListFixer(testList),
    		new BitStringListNonrepeater(testList));
    System.out.println(problem);
    List<IBooleanLiteral> s=problem.findModel(Problem.defaultSolver());
    System.out.println(s);
		if(s!=null && s.size()>0)
    {
      BooleanLiteral.interpret(s);
    	System.out.println("s2= "+testList);
    }
    else
      System.out.println("No solution.");
  }
}
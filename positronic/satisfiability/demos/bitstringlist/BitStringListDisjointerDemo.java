package positronic.satisfiability.demos.bitstringlist;

import java.util.List;

import positronic.satisfiability.bitstringlist.BitStringList;
import positronic.satisfiability.bitstringlist.BitStringListDisjointer;
import positronic.satisfiability.bitstringlist.BitStringListFixer;
import positronic.satisfiability.bitstringlist.IBitStringList;
import positronic.satisfiability.elements.BooleanLiteral;
import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.IBooleanLiteral;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;
/**
 * <p>Title: BitStringListDisjointerDemo</p>
 * <p>Description: TBS</p>
 * <p>Copyright (c) 2005</p>
 * <p>Company: Positronic Software</p>
 * @author Kerry Michael Soileau
 * @version 1.0
 */

public class BitStringListDisjointerDemo /** @todo Test this thoroughly */
{
  public static void main(String[] args) throws Exception
  {
    IBitStringList slm=new BitStringList("y",
    		new boolean[][]{
    		{true,false,false},
        {true,true,false},
      });

    IBitStringList bsl=new BitStringList("slist",
    		new boolean[][]{
    		{false,true,false},
    		{false,false,false},
    		{false,true,false},
    		{false,true,false},
      });

    IProblem problem=new Conjunction(
    		new BitStringListFixer(slm),
    			new BitStringListFixer(bsl),
    				new BitStringListDisjointer(bsl,slm));

    System.out.println(problem);
    List<IBooleanLiteral> s=problem.findModel(Problem.defaultSolver());
		if(s!=null && s.size()>0)
    {
      BooleanLiteral.interpret(s);
    	System.out.println("slm= "+slm);
    	System.out.println("bsl= "+bsl);
    }
    else
      System.out.println("No solution.");
  }
}
package positronic.satisfiability.demos.bitstringlist;

import java.util.List;

import positronic.satisfiability.bitstringlist.BitStringList;
import positronic.satisfiability.bitstringlist.BitStringListFixer;
import positronic.satisfiability.bitstringlist.BitStringListUnioner;
import positronic.satisfiability.bitstringlist.IBitStringList;
import positronic.satisfiability.elements.BooleanLiteral;
import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.IBooleanLiteral;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;
/**
 * <p>Title: BitStringListUnionerDemo</p>
 * <p>Description: TBS</p>
 * <p>Copyright (c) 2005</p>
 * <p>Company: Positronic Software</p>
 * @author Kerry Michael Soileau
 * @version 1.0
 */

public class BitStringListUnionerDemo /** @todo This class is under suspicion of being INCORRECT */
{
  public static void main(String[] args) throws Exception
  {
    IBitStringList slm=new BitStringList("y",
    		new boolean[][]{
        {true,false,false},
        {true,true,false},
      });
    IProblem slmfix=new BitStringListFixer(slm);
    
    IBitStringList bsl=new BitStringList("slist",
    		new boolean[][]{
        {true,false,true},
      });
    IProblem bslfix=new BitStringListFixer(bsl);

    IBitStringList target=new BitStringList("combined",
    		new boolean[3][3]);

    IProblem problem=new Conjunction(slmfix,bslfix,new BitStringListUnioner(target,slm,bsl));

    System.out.println(problem);
    List<IBooleanLiteral> s=problem.findModel(Problem.defaultSolver());
		if(s!=null && s.size()>0)
    {
      BooleanLiteral.interpret(s);
    	System.out.println("slm= "+slm);
    	System.out.println("bsl= "+bsl);
    	System.out.println("target= "+target);
    }
    else
      System.out.println("No solution.");
  }
}
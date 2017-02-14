package positronic.satisfiability.demos.bitstringlist;

/**
 * <p>Title: TBS</p>
 * <p>Description: TBS</p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: Positronic Software</p>
 * @author Kerry Michael Soileau
 * @version 1.0
 */
 import java.util.List;

import positronic.satisfiability.bitstring.BitString;
import positronic.satisfiability.bitstring.IBitString;
import positronic.satisfiability.bitstringlist.BitStringList;
import positronic.satisfiability.bitstringlist.BitStringListFixer;
import positronic.satisfiability.bitstringlist.IBitStringList;
import positronic.satisfiability.elements.BooleanLiteral;
import positronic.satisfiability.elements.IBooleanLiteral;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;

public class BitStringListFixerDemo
{
  public static void main(String[] args) throws Exception
  {
    IBitString[] theStrings=new BitString[3];
    theStrings[0]=new BitString(new boolean[]{true,true,false});
    theStrings[1]=new BitString("named",new boolean[]{true,true,true,false});
    theStrings[2]=new BitString(new boolean[]{false,true,true});
    IBitStringList samp2=new BitStringList("theList",theStrings);
    IProblem bslf2=new BitStringListFixer(samp2);
    System.out.println(bslf2);
    List<IBooleanLiteral> s=bslf2.findModel(Problem.defaultSolver());
		if(s!=null && s.size()>0)
    {
      BooleanLiteral.interpret(s);
    	System.out.println("samp2= "+samp2);
    	
    }
    else
      System.out.println("No solution.");

  }
}
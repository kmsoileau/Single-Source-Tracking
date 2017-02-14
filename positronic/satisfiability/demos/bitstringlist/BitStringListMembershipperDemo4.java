package positronic.satisfiability.demos.bitstringlist;

import java.util.List;

import positronic.satisfiability.bitstring.BitString;
import positronic.satisfiability.bitstring.BitStringFixer;
import positronic.satisfiability.bitstring.IBitString;
import positronic.satisfiability.bitstringlist.BitStringList;
import positronic.satisfiability.bitstringlist.BitStringListMembershipper;
import positronic.satisfiability.bitstringlist.IBitStringList;
import positronic.satisfiability.elements.BooleanLiteral;
import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.IBooleanLiteral;
import positronic.satisfiability.elements.IProblem;
/**
 * <p>Title: BitStringListMembershipperDemo4</p>
 * <p>Description: This is a sample application showing the use of the 
 * BitStringListMembershipper class.</p>
 * <p>Copyright (c) 2007</p>
 * <p>Company: Positronic Software</p>
 * @author Kerry Michael Soileau
 * @version 1.0
 */

public class BitStringListMembershipperDemo4
{
  public static void main(String[] args) throws Exception
  {
    IBitString string1=new BitString("string1",new boolean[4]);
    IBitString string2=new BitString("string2",new boolean[4]);
    
    IBitStringList bsl=new BitStringList("slist",new IBitString[]
      {
        new BitString(4),
        new BitString(3),
        new BitString(3),
        new BitString(1),
        new BitString(4),
        new BitString(1)
      });

    IProblem fix=new BitStringFixer(string1,"1001");
    IProblem fix2=new BitStringFixer(string2,"1100");

    IProblem bslm1=new Conjunction(fix,fix2
    		,new BitStringListMembershipper(string1,bsl)
    		,new BitStringListMembershipper(string2,bsl));
    
    System.out.println(bslm1);
    
    List<IBooleanLiteral> s=bslm1.findModel();

    if(s!=null && s.size()>0)
    {
      BooleanLiteral.interpret(s);
      System.out.println("string1 = "+string1);
      System.out.println("string2 = "+string2);
      System.out.println("bsl = "+bsl);
    }
    else
      System.out.println("No solution.");
  }
}
package positronic.satisfiability.demos.bitstringlist;

import java.util.List;

import positronic.satisfiability.bitstring.BitString;
import positronic.satisfiability.bitstring.BitStringFixer;
import positronic.satisfiability.bitstring.IBitString;
import positronic.satisfiability.bitstringlist.BitStringList;
import positronic.satisfiability.bitstringlist.BitStringListFixer;
import positronic.satisfiability.bitstringlist.BitStringListMembershipper;
import positronic.satisfiability.bitstringlist.IBitStringList;
import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.IBooleanLiteral;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;
/**
 * <p>Title: BitStringListMembershipperDemo3</p>
 * <p>Description: This is a sample application showing the use of the 
 * BitStringListMembershipper class.</p>
 * <p>Copyright (c) 2005</p>
 * <p>Company: Positronic Software</p>
 * @author Kerry Michael Soileau
 * @version 1.0
 */

public class BitStringListMembershipperDemo3
{
  public static void main(String[] args) throws Exception
  {
    IBitString slm=new BitString("Kerry","0101");

    IBitStringList bsl=new BitStringList("slist",new IBitString[]
    {
      new BitString("000"),
      new BitString("010"),
      new BitString("0101"),
      new BitString("011"),
      new BitString(""),
      new BitString("101"),
      new BitString("000"),
      new BitString("000"),
    });

    IProblem problem=new Conjunction(
    		new BitStringFixer(slm),
    			new BitStringListFixer(bsl),
    				new BitStringListMembershipper(slm,bsl));

    System.out.println(problem);

    List<IBooleanLiteral> s=problem.findModel(Problem.defaultSolver());

    if(s!=null && s.size()>0)
    {
      System.out.println("slm= "+slm);
      System.out.println("bsl= "+bsl);
    }
    else
      System.out.println("No solution.");

    //System.out.print(((Problem)problem).reduceComplements());
  }
}
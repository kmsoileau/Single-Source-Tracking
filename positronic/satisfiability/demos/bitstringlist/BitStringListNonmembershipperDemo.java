package positronic.satisfiability.demos.bitstringlist;

import java.util.List;

import positronic.satisfiability.bitstring.BitString;
import positronic.satisfiability.bitstring.BitStringFixer;
import positronic.satisfiability.bitstring.IBitString;
import positronic.satisfiability.bitstringlist.BitStringList;
import positronic.satisfiability.bitstringlist.BitStringListFixer;
import positronic.satisfiability.bitstringlist.BitStringListNonmembershipper;
import positronic.satisfiability.bitstringlist.IBitStringList;
import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.IBooleanLiteral;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;
/**
 * <p>Title: BitStringListNonmembershipperDemo</p>
 * <p>Description: TBS</p>
 * <p>Copyright (c) 2005</p>
 * <p>Company: Positronic Software</p>
 * @author Kerry Michael Soileau
 * @version 1.0
 */

public class BitStringListNonmembershipperDemo
{
  public static void main(String[] args) throws Exception
  {
    IBitString slm=new BitString("y",new boolean[]{false,true,false,false});

    IBitStringList bsl=new BitStringList("slist",new IBitString[]
    {
      new BitString("000"),
      new BitString("010"),
      new BitString("0101"),
      new BitString("011"),
      new BitString("101"),
      new BitString("000"),
      new BitString("000"),
    });


    IProblem problem=new Conjunction(new BitStringFixer(slm),
      new BitStringListFixer(bsl),
        new BitStringListNonmembershipper(slm,bsl));

    System.out.println(problem);

    List<IBooleanLiteral> s=problem.findModel(Problem.defaultSolver());

    if(s!=null && s.size()>0)
    {
      System.out.println("slm= "+slm);
      System.out.println("bsl= "+bsl);
    }
    else
      System.out.println("No solution.");
  }
}
package positronic.satisfiability.demos.bitstringlist;

import java.util.List;

import positronic.satisfiability.bitstring.BitString;
import positronic.satisfiability.bitstring.BitStringFixer;
import positronic.satisfiability.bitstring.IBitString;
import positronic.satisfiability.bitstringlist.BitStringList;
import positronic.satisfiability.bitstringlist.BitStringListFixer;
import positronic.satisfiability.bitstringlist.BitStringListMembershipper;
import positronic.satisfiability.bitstringlist.IBitStringList;
import positronic.satisfiability.elements.BooleanLiteral;
import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.IBooleanLiteral;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;
/**
 * <p>Title: BitStringListMembershipperDemo1</p>
 * <p>Description: This is a sample application showing the use of the 
 * BitStringListMembershipper class.</p>
 * <p>Copyright (c) 2005</p>
 * <p>Company: Positronic Software</p>
 * @author Kerry Michael Soileau
 * @version 1.0
 */

 //Need to reverify this one
public class BitStringListMembershipperDemo1
{
  public static void main(String[] args) throws Exception
  {
  	IBitStringList bsl=new BitStringList("slist",
  			new IBitString[]
  	    {
  				new BitString("00"),
  	      new BitString("101"),
  	      new BitString("1110"),
  	      new BitString("100"),
  	      new BitString("111"),
  	      new BitString("0110")
  	    });

  	/**
  	 * Note: To get a successful match, it is necessary for the matching string to have 
  	 * the same length and the same content as the search string.
  	 */
  	IBitString string=new BitString("string",new boolean[3]);
    IProblem stringfix=new BitStringFixer(string,new boolean[]{true,false,true});

    IProblem bslm=new BitStringListMembershipper(string,bsl);
    System.out.println(bslm);
    IProblem fix=new BitStringListFixer(bsl);

    IProblem problem=new Conjunction(bslm,fix,stringfix);

    System.out.println(problem);
    List<IBooleanLiteral> s=problem.findModel(Problem.defaultSolver());
    if(s!=null && s.size()>0)
    {
    	BooleanLiteral.interpret(s);
      System.out.println(string);
    }
    else
      System.out.println("No solution.");
  }
}
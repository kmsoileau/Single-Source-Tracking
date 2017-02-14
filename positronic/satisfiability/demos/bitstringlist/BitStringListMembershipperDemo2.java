package positronic.satisfiability.demos.bitstringlist;

import java.util.List;

import positronic.satisfiability.bitstring.BitString;
import positronic.satisfiability.bitstring.BitStringUnequalizer;
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
 * <p>Title: BitStringListMembershipperDemo2</p>
 * <p>Description: This is a sample application showing the use of the 
 * BitStringListMembershipper class.</p>
 * <p>Copyright (c) 2005</p>
 * <p>Company: Positronic Software</p>
 * @author Kerry Michael Soileau
 * @version 1.0
 */

public class BitStringListMembershipperDemo2
{
  public static void main(String[] args) throws Exception
  {
    IBitString string1=new BitString("string1",new boolean[4]);
    IBitString string2=new BitString("string2",new boolean[3]);

    IBitStringList bsl=new BitStringList("slist",new IBitString[]
      {
        new BitString("00"),
        new BitString("101"),
        new BitString("1110"),
        new BitString("100"),
        new BitString("111"),
        new BitString("0110")
      });

    //The list must have given values
    IProblem fix=new BitStringListFixer(bsl);

    //Both strings must occur in the list
    IProblem bslm1=new BitStringListMembershipper(string1,bsl);
    System.out.println(bslm1);
    IProblem bslm2=new BitStringListMembershipper(string2,bsl);

    //The two strings must be different
    IProblem diff=new BitStringUnequalizer(string1,string2);

    //Combine all of the IProblems into a single IProblem
    IProblem problem=new Conjunction(bslm1,bslm2,fix,diff);
    //problem.sort();
    System.out.println(problem);

    //Solve the IProblem
    List<IBooleanLiteral> s=problem.findModel(Problem.defaultSolver());

    if(s!=null && s.size()>0)
    {
      for(int i=0;i<s.size();i++)
        System.out.println(s.get(i));
      BooleanLiteral.interpret(s);
      System.out.println("String1 = "+string1);
      System.out.println("String2 = "+string2);
    }
    else
      System.out.println("No solution.");
  }
}
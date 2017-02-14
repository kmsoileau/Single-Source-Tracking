package positronic.satisfiability.demos.bitstringlist;

import java.util.List;

import positronic.satisfiability.bitstring.BitString;
import positronic.satisfiability.bitstring.IBitString;
import positronic.satisfiability.bitstringlist.BitStringList;
import positronic.satisfiability.bitstringlist.BitStringListFixer;
import positronic.satisfiability.bitstringlist.BitStringListIncrementer;
import positronic.satisfiability.bitstringlist.IBitStringList;
import positronic.satisfiability.elements.BooleanLiteral;
import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.IBooleanLiteral;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;
/**
 * <p>Title: BitStringListIncrementerDemo</p>
 * <p>Description: </p>
 * <p>Copyright (c) 2005</p>
 * <p>Company: Positronic Software</p>
 * @author Kerry Michael Soileau
 * @version 1.0
 */

public class BitStringListIncrementerDemo
{
  public static void main(String[] args) throws Exception
  {
    IBitStringList firstList=new BitStringList("firstList",new IBitString[]
    {
    		new BitString("000"),
        new BitString("010"),
        new BitString("0101"),
        new BitString("111"),
        new BitString("000"),
        new BitString("000"),
    });

    IBitStringList secondList=new BitStringList("secondList",new IBitString[]
    {
      new BitString("000"),
      new BitString("010"),
      new BitString("0101"),
      new BitString("011"),
      new BitString("111"),
      new BitString("000"),
      new BitString("000"),
    });
    
    IBitString theBitString=new BitString(3);


    IProblem problem=new Conjunction(new BitStringListFixer(firstList),
      new BitStringListFixer(secondList),
        new BitStringListIncrementer(firstList,theBitString,secondList));

    System.out.println(problem);
    
    List<IBooleanLiteral> s=problem.findModel(Problem.defaultSolver());
    if(s!=null && s.size()>0)
    {
      BooleanLiteral.interpret(s);
      System.out.println(firstList);
    	System.out.println(theBitString);
    	System.out.println(secondList);
    }
    else
      System.out.println("No solution.");
  }
}
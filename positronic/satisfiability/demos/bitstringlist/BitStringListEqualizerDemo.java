package positronic.satisfiability.demos.bitstringlist;

import java.util.List;

import positronic.satisfiability.bitstring.BitString;
import positronic.satisfiability.bitstring.IBitString;
import positronic.satisfiability.bitstringlist.BitStringList;
import positronic.satisfiability.bitstringlist.BitStringListEqualizer;
import positronic.satisfiability.bitstringlist.BitStringListFixer;
import positronic.satisfiability.bitstringlist.IBitStringList;
import positronic.satisfiability.elements.BooleanLiteral;
import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.IBooleanLiteral;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;
/**
 * <p>Title: BitStringListEqualizerDemo</p>
 * <p>Description: This is a sample application showing the use of the 
 * BitStringListEqualizer class.</p>
 * <p>Copyright (c) 2005</p>
 * <p>Company: Positronic Software</p>
 * @author Kerry Michael Soileau
 * @version 1.0
 */
public class BitStringListEqualizerDemo
{
  public static void main(String[] args) throws Exception
  {
    IBitStringList A=new BitStringList("A",new IBitString[]
    {
      new BitString("000"),
      new BitString("011"),
      new BitString("0101"),
      new BitString("010")
    });

    IBitStringList B=new BitStringList("B",new IBitString[]
    {
    		new BitString("000"),
    		new BitString("011"),
        new BitString("010"),
        new BitString("0101")
    });
    
    System.out.println(B);

    IProblem problem=new Conjunction(
    	new BitStringListFixer(A),
      	new BitStringListFixer(B),
        	new BitStringListEqualizer(A,B));

    System.out.println(problem);

    List<IBooleanLiteral> s=problem.findModel(Problem.defaultSolver());
		if(s!=null && s.size()>0)
    {
      BooleanLiteral.interpret(s);
      System.out.println("A = "+A);
      System.out.println("B = "+B);
    }
    else
      System.out.println("No solution.");
  }
}
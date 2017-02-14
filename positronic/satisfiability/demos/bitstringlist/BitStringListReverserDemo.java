package positronic.satisfiability.demos.bitstringlist;

import java.util.List;

import positronic.satisfiability.bitstring.BitString;
import positronic.satisfiability.bitstring.IBitString;
import positronic.satisfiability.bitstringlist.BitStringList;
import positronic.satisfiability.bitstringlist.BitStringListFixer;
import positronic.satisfiability.bitstringlist.BitStringListReverser;
import positronic.satisfiability.bitstringlist.IBitStringList;
import positronic.satisfiability.elements.BooleanLiteral;
import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.IBooleanLiteral;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;

public class BitStringListReverserDemo
{
	public static void main(String[] args) throws Exception
  {
    IBitStringList A=new BitStringList("A",new IBitString[]
    {
      new BitString("000"),
      new BitString("110"),
      new BitString("010"),
      new BitString("011")
    });

    IBitStringList B=new BitStringList("B",new IBitString[]
    {
    		new BitString("000"),
    		new BitString("000"),
        new BitString("000"),
        new BitString("000")
    });
    
    System.out.println(B);

    IProblem p1=new BitStringListReverser(A,B);
    System.out.println(p1);
    
    IProblem problem=new Conjunction(
    		new BitStringListReverser(A,B),
    			new BitStringListFixer(A));

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

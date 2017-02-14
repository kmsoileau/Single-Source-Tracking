package positronic.satisfiability.demos.bitstring;

import java.util.List;

import positronic.satisfiability.bitstring.BitString;
import positronic.satisfiability.bitstring.BitStringFixer;
import positronic.satisfiability.bitstring.BitStringMapper;
import positronic.satisfiability.bitstring.IBitString;
import positronic.satisfiability.elements.BooleanLiteral;
import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.IBooleanLiteral;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;
/**
 * <p>Title: TBS</p>
 * <p>Description: TBS</p>
 * <p>Copyright (c) 2005</p>
 * <p>Company: Positronic Software</p>
 * @author Kerry Michael Soileau
 * @version 1.0
 */

public class BitStringMapperDemo
{
  public static void main(String[] args) throws Exception
  {
    IBitString[] x=new IBitString[]{
      new BitString("1011"),
      new BitString("0010"),
      new BitString("0011"),
      new BitString("0100"),
      new BitString("0101"),
      };
    IBitString[] y=new IBitString[]{
      new BitString("1101"),
      new BitString("0110"),
      new BitString("1011"),
      new BitString("0101"),
      new BitString("1101"),
      };
    IBitString abscissa=new BitString("abscissa","0101");
    IBitString ordinate=new BitString("ordinate",new boolean[4]);

    BitStringMapper nnm1=new BitStringMapper(x,y,abscissa,ordinate);
    IProblem problem=new Conjunction(nnm1,new BitStringFixer(abscissa));
    System.out.println(problem);
    List<IBooleanLiteral> v7=problem.findModel(Problem.defaultSolver());
    if(v7.size()>0)
    {
    	BooleanLiteral.interpret(v7);
    	System.out.println("x="+abscissa);
    	System.out.println("y="+ordinate);
    }
    else
    	System.out.println("No solution.");
  }
}
package positronic.satisfiability.demos.bitstring;
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
import positronic.satisfiability.bitstring.BitStringTotaler;
import positronic.satisfiability.bitstring.IBitString;
import positronic.satisfiability.elements.BitFixer;
import positronic.satisfiability.elements.BooleanLiteral;
import positronic.satisfiability.elements.BooleanVariable;
import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.IBooleanLiteral;
import positronic.satisfiability.elements.IBooleanVariable;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;
import positronic.satisfiability.naturalnumber.INaturalNumber;
import positronic.satisfiability.naturalnumber.NaturalNumber;

public class BitStringTotalerDemo /** @todo This class is under suspicion of being INCORRECT */
{
  public static void main(String[] args) throws Exception
  {
    IBitString B=new BitString("Kerry",new IBooleanVariable[]
    {
      BooleanVariable.getBooleanVariable("Kerry0"),
      BooleanVariable.getBooleanVariable("Kerry1"),
      BooleanVariable.getBooleanVariable("Kerry2"),
      BooleanVariable.getBooleanVariable("Kerry3"),
      BooleanVariable.getBooleanVariable("Kerry4"),
    });

    INaturalNumber ZZ=new NaturalNumber("ZZTop");

    IProblem bst=new BitStringTotaler(B,ZZ);
    System.out.println(bst);
    IProblem[] bf=new BitFixer[B.size()];
    bf[0]=new BitFixer(B.getBooleanVariable(0),true);
    bf[1]=new BitFixer(B.getBooleanVariable(1),true);
    bf[2]=new BitFixer(B.getBooleanVariable(2),true);
    bf[3]=new BitFixer(B.getBooleanVariable(3),true);
    bf[4]=new BitFixer(B.getBooleanVariable(4),false);

    IProblem problem=new Conjunction(new Conjunction(bf),bst);

    /*PartialSolution junk7=PartialSolution.goodieSolve(problem);
    System.out.println("After goodieSolve we have:");
    System.out.println(junk7);

    PartialSolution.solveList(junk7.getProblem());

    BooleanLiteral.interpret(junk7.getBooleanLiterals());
    System.out.println(ZZ.getName()+"\t"+ZZ);*/
    List<IBooleanLiteral> s=problem.findModel(Problem.defaultSolver());
		if(s!=null && s.size()>0)
    {
      BooleanLiteral.interpret(s);
    	System.out.println("B= "+B);
    	System.out.println("ZZ= "+ZZ);
    }
    else
      System.out.println("No solution.");
  }
}
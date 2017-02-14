package positronic.satisfiability.demos;

/**
 * <p>Title: TBS</p>
 * <p>Description: TBS</p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: Positronic Software</p>
 * @author Kerry Michael Soileau
 * @version 1.0
 */
 import java.util.List;

import positronic.satisfiability.elements.BitFixer;
import positronic.satisfiability.elements.BooleanLiteral;
import positronic.satisfiability.elements.BooleanVariable;
import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.IBooleanLiteral;
import positronic.satisfiability.elements.IBooleanVariable;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;
import positronic.satisfiability.exceptions.BitStringException;
import positronic.satisfiability.exceptions.BooleanLiteralException;
import positronic.satisfiability.naturalnumber.INaturalNumber;
import positronic.satisfiability.naturalnumber.NaturalNumber;
import positronic.satisfiability.naturalnumber.NaturalNumberFromBitConverter;

public class NaturalNumberFromBitConverterDemo
{
  public static void main(String[] args) throws Exception,BooleanLiteralException,BitStringException
  {
    INaturalNumber N=new NaturalNumber("N");
    IBooleanVariable BVar=BooleanVariable.getBooleanVariable("BVar");
    NaturalNumberFromBitConverter nnfbc=new NaturalNumberFromBitConverter(N,BVar);
    BitFixer bf=new BitFixer(BVar,true);
    IProblem prob=new Conjunction(bf,nnfbc);
    System.out.println(prob);
    List<IBooleanLiteral> s=prob.findModel(Problem.defaultSolver());
		if(s!=null && s.size()>0)
    {
      BooleanLiteral.interpret(s);
      System.out.println("BVar= "+BVar.getValue());
    	System.out.println("N= "+N);
    }
    else
      System.out.println("No solution.");
  }
}
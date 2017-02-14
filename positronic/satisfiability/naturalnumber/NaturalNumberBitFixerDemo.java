package positronic.satisfiability.naturalnumber;

/**
 * <p>Title: TBS</p>
 * <p>Description: TBS</p>
 * <p>Copyright (c) 2005</p>
 * <p>Company: Positronic Software</p>
 * @author Kerry Michael Soileau
 * @version 1.0
 */
import java.util.List;

import org.sat4j.minisat.SolverFactory;

import positronic.satisfiability.elements.BooleanLiteral;

public class NaturalNumberBitFixerDemo
{
  public static void main(String[] args) throws Exception
  {
    INaturalNumber X=new NaturalNumber("X");
    NaturalNumberBitFixer nnbf=new NaturalNumberBitFixer(X,3,true);
    List<?> s=nnbf.findModel(SolverFactory.newMiniSATHeap());
		if(s!=null && s.size()>0)
    {
      BooleanLiteral.interpret(s);
    	System.out.println("X= "+X);
    }
    else
      System.out.println("No solution.");
  }
}
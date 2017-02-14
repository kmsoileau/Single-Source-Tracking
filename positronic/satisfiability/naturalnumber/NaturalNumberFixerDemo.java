package positronic.satisfiability.naturalnumber;

import java.util.List;

import org.sat4j.minisat.SolverFactory;

import positronic.satisfiability.elements.BooleanLiteral;
import positronic.satisfiability.elements.Conjunction;

public class NaturalNumberFixerDemo
{
  public static void main(String[] args) throws Exception
  {
    INaturalNumber X=new NaturalNumber("X");
    INaturalNumber Y=new NaturalNumber("Y");

    NaturalNumberFixer bnnfx=new NaturalNumberFixer(X,129L);
    NaturalNumberFixer bnnfy=new NaturalNumberFixer(Y,255L);

    Conjunction p7=new Conjunction(bnnfx,bnnfy);

    List<?> s=p7.findModel(SolverFactory.newMiniSATHeap());
		if(s!=null && s.size()>0)
    {
      BooleanLiteral.interpret(s);
    	System.out.println("X= "+X);
    	System.out.println("Y= "+Y);
    }
    else
      System.out.println("No solution.");
  }
}
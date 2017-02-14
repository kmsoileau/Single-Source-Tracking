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
import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.IProblem;

public class NaturalNumberEqualizerDemo
{
  public static void main(String[] args) throws Exception
  {
    INaturalNumber X=new NaturalNumber("X");
    INaturalNumber Y=new NaturalNumber("Y");

    IProblem p=new Conjunction(new NaturalNumberFixer(X,6),new NaturalNumberEqualizer(X,Y));
    System.out.println(p);
    List<?> s=p.findModel(SolverFactory.newMiniSATHeap());
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
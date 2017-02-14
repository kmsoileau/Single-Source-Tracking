package positronic.satisfiability.naturalnumber;

import java.util.List;

import org.sat4j.minisat.SolverFactory;

import positronic.satisfiability.elements.BooleanLiteral;
import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.IProblem;

/**
 * @todo this fails when new NaturalNumberRelativelyPrimer(K,L)
 * is uncommented, debug it.
 *
 */
public class NaturalNumberLeastCommonMultiplerDemo
{
  public static void main(String[] args) throws Exception
  {
    INaturalNumber X=new NaturalNumber("X");
    INaturalNumber Y=new NaturalNumber("Y");
    
    INaturalNumber LCM=new NaturalNumber();

    IProblem p=new Conjunction(new IProblem[]{
    		new NaturalNumberFixer(X,19),
    			new NaturalNumberFixer(Y,16),
    			new NaturalNumberLeastCommonMultipler(X,Y,LCM)
    });
    
    System.out.println(p);
    
    List<?> s=p.findModel(SolverFactory.newMiniSATHeap());
		if(s!=null && s.size()>0)
    {
      BooleanLiteral.interpret(s);
      System.out.println("X = "+X);
      System.out.println("Y = "+Y);
      System.out.println("LCM = "+LCM);
    }
		else
      System.out.println("No solution.");
  }
}
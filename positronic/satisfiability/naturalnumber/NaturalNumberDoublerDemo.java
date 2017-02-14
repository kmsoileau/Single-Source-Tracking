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

public class NaturalNumberDoublerDemo
{
  public static void main(String[] args) throws Exception
  {
    INaturalNumber X=new NaturalNumber("X");
    INaturalNumber Y=new NaturalNumber("Y");

    for(long i=0;i<Math.pow(2.,1.*NaturalNumber.getLength())/2;i++)
    {
	    NaturalNumberFixer bnnfx=new NaturalNumberFixer(X,i);
	
	    NaturalNumberDoubler NaturalNumberDoubler1 = new NaturalNumberDoubler(X,Y);
	
	    IProblem p=new Conjunction(bnnfx,NaturalNumberDoubler1);
	    List<?> s=p.findModel(SolverFactory.newMiniSATHeap());
			if(s!=null && s.size()>0)
	    {
	      BooleanLiteral.interpret(s);
	    	System.out.print("\nX= "+X);
	    	System.out.print("\tY= "+Y);
	    }
	    else
	      System.out.print("No solution.");
    }
  }
}
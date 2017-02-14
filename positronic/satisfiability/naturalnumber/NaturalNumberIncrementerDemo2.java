package positronic.satisfiability.naturalnumber;

import java.util.List;

import org.sat4j.minisat.SolverFactory;

import positronic.satisfiability.elements.BooleanLiteral;
import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.IProblem;

public class NaturalNumberIncrementerDemo2
{
  public static void main(String[] args) throws Exception
  {
    INaturalNumber X=new NaturalNumber("X");
    INaturalNumber Y=new NaturalNumber("Y");
    INaturalNumber C=new NaturalNumber("C");

    for(int i=0;i<Math.pow(2.,1.*NaturalNumber.getLength());i++)
    {
	    IProblem bnnfx=new NaturalNumberFixer(X,i);
	    IProblem bnnfy=new NaturalNumberIncrementer(X,Y,C);
	
	    IProblem p=new Conjunction(bnnfx,bnnfy);
	
	    //System.out.println(p);
	    List<?> s=p.findModel(SolverFactory.newMiniSATHeap());
			if(s!=null && s.size()>0)
	    {
	      BooleanLiteral.interpret(s);
	    	System.out.print("\nX= "+X+"\t");
	    	System.out.print("Y= "+Y+"\t");
	    	System.out.print("C= "+C+"\t");
	    }
	    else
	      System.out.print("No solution.");
    }
  }
}
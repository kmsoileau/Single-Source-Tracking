package positronic.satisfiability.naturalnumber;

import java.util.List;

import org.sat4j.minisat.SolverFactory;

import positronic.satisfiability.elements.BitFixer;
import positronic.satisfiability.elements.BooleanLiteral;
import positronic.satisfiability.elements.BooleanVariable;
import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.IBooleanVariable;
import positronic.satisfiability.elements.IProblem;

public class NaturalNumberBitMultiplyDemo
{
  public static void main(String[] args) throws Exception
  {
    IBooleanVariable b=BooleanVariable.getBooleanVariable("b");
    INaturalNumber X=new NaturalNumber("X");
    INaturalNumber Y=new NaturalNumber("Y");

    IProblem p=new Conjunction(
    		new BitFixer(b,false),
    		new NaturalNumberFixer(X,255L),
    		new NaturalNumberBitMultiply(b,X,Y));
    
    List<?> s=p.findModel(SolverFactory.newMiniSATHeap());
		if(s!=null && s.size()>0)
    {
      BooleanLiteral.interpret(s);
      System.out.println("b= "+b.getValue());
    	System.out.println("X= "+X);
    	System.out.println("Y= "+Y);
    }
    else
      System.out.println("No solution.");
  }
}
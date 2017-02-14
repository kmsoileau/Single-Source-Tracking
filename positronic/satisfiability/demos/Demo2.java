package positronic.satisfiability.demos;

import java.util.List;

import positronic.satisfiability.elements.BooleanLiteral;
import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.IBooleanLiteral;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;
import positronic.satisfiability.naturalnumber.NaturalNumber;
import positronic.satisfiability.naturalnumber.NaturalNumberEqualizer;
import positronic.satisfiability.naturalnumber.NaturalNumberFixer;
/**
 * <p>Title: Demo2</p>
 * <p>Description: A demo program</p>
 * <p>Copyright (c) 2005</p>
 * <p>Company: Positronic Software</p>
 * @author Kerry Michael Soileau
 * @version 1.0
 */

public class Demo2
{
  public static void main(String[] args) throws Exception
  {
    NaturalNumber X=new NaturalNumber("X");
    NaturalNumber Y=new NaturalNumber("Y");

    NaturalNumberFixer N=new NaturalNumberFixer(X,14L);
    NaturalNumberEqualizer A=new NaturalNumberEqualizer(X,Y);
    
    IProblem problem=new Conjunction(N,A);
    List<IBooleanLiteral> s=problem.findModel(Problem.defaultSolver());
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
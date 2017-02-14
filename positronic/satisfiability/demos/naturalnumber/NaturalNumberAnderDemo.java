package positronic.satisfiability.demos.naturalnumber;

/**
 * <p>Title: TBS</p>
 * <p>Description: TBS</p>
 * <p>Copyright (c) 2005</p>
 * <p>Company: Positronic Software</p>
 * @author Kerry Michael Soileau
 * @version 1.0
 */
import java.util.List;

import positronic.satisfiability.elements.BooleanLiteral;
import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.IBooleanLiteral;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;
import positronic.satisfiability.naturalnumber.INaturalNumber;
import positronic.satisfiability.naturalnumber.NaturalNumber;
import positronic.satisfiability.naturalnumber.NaturalNumberAnder;
import positronic.satisfiability.naturalnumber.NaturalNumberFixer;

public class NaturalNumberAnderDemo
{
  public static void main(String[] args) throws Exception
  {
    INaturalNumber X=new NaturalNumber("X");
    INaturalNumber Y=new NaturalNumber("Y");
    INaturalNumber Z=new NaturalNumber("Z");

    NaturalNumberFixer nnf1=new NaturalNumberFixer(X,34);
    NaturalNumberFixer nnf2=new NaturalNumberFixer(Y,123);
    NaturalNumberAnder nna=new NaturalNumberAnder(X,Y,Z);

    IProblem p=new Conjunction(nnf1,nnf2,nna);
    System.out.println(p);

    List<IBooleanLiteral> s=p.findModel(Problem.defaultSolver());
		if(s!=null && s.size()>0)
    {
      BooleanLiteral.interpret(s);
    	System.out.println("X= "+X);
    	System.out.println("Y= "+Y);
    	System.out.println("Z= "+Z);
    }
    else
      System.out.println("No solution.");
  }
}
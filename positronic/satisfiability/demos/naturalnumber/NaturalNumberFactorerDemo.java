package positronic.satisfiability.demos.naturalnumber;

/**
 * <p>Title: TBS</p>
 * <p>Description: TBS</p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: Positronic Software</p>
 * @author Kerry Michael Soileau
 * @version 1.0
 */
import java.util.Date;
import java.util.List;

import positronic.satisfiability.elements.BooleanLiteral;
import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.IBooleanLiteral;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.naturalnumber.INaturalNumber;
import positronic.satisfiability.naturalnumber.NaturalNumber;
import positronic.satisfiability.naturalnumber.NaturalNumberFactorer;
import positronic.satisfiability.naturalnumber.NaturalNumberFixer;

public class NaturalNumberFactorerDemo
{
  public static void main(String[] args) throws Exception
  {
	  Date d1=new Date();
	  NaturalNumber.setLength(43);
	  INaturalNumber X=new NaturalNumber("X");
	  INaturalNumber Y=new NaturalNumber("Y");
	  INaturalNumber Z=new NaturalNumber("Z");
	  
	  IProblem p=new Conjunction(
	    		new NaturalNumberFixer(Z,9409L),
				new NaturalNumberFactorer(X,Y,Z));
	  
	  System.out.println(p.size()+" clauses generated...");
	  
	  List<IBooleanLiteral> s=p.findModel();
    
	  BooleanLiteral.interpret(s);
    
	  System.out.println("X = "+X);
	  System.out.println("Y = "+Y);
	  System.out.println("Z = "+Z);
	  Date d2=new Date();
	  System.out.println(d2.getTime()-d1.getTime());
  }
}
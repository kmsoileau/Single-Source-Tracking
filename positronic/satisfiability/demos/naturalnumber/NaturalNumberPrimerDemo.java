package positronic.satisfiability.demos.naturalnumber;

/**
 * <p>Title: TBS</p>
 * <p>Description: TBS</p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: Positronic Software</p>
 * @author Kerry Michael Soileau
 * @version 1.0
 */
import java.util.List;

import positronic.satisfiability.elements.BooleanLiteral;
import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.IBooleanLiteral;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.naturalnumber.INaturalNumber;
import positronic.satisfiability.naturalnumber.NaturalNumber;
import positronic.satisfiability.naturalnumber.NaturalNumberFixer;
import positronic.satisfiability.naturalnumber.NaturalNumberPrimer;

public class NaturalNumberPrimerDemo
{
  public static void main(String[] args) throws Exception
  {
  	INaturalNumber Z=new NaturalNumber("Z");
    IProblem p=new Conjunction(new NaturalNumberFixer(Z,13L),new NaturalNumberPrimer(Z));
    List<IBooleanLiteral> s=p.findModel();
    System.out.println(s);
    if(s!=null && s.size()>0)
	{
		BooleanLiteral.interpret(s);
		System.out.println(Z);
	}
	else
		System.out.println("No solution.");
  }
}
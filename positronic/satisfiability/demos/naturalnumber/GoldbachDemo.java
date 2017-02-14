package positronic.satisfiability.demos.naturalnumber;

/**
 * <p>Title: TBS</p>
 * <p>Description: TBS</p>
 * <p>Copyright: Copyright (c) 2011</p>
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
import positronic.satisfiability.naturalnumber.NaturalNumberAdder;
import positronic.satisfiability.naturalnumber.NaturalNumberFixer;
import positronic.satisfiability.naturalnumber.NaturalNumberPrimer;

public class GoldbachDemo
{
  public static void main(String[] args) throws Exception
  {
  	INaturalNumber prime1=new NaturalNumber("prime1");
  	INaturalNumber prime2=new NaturalNumber("prime2");
  	INaturalNumber evennumber=new NaturalNumber("evennumber");
  	IProblem p=new Conjunction(new NaturalNumberFixer(evennumber,24L),
    		new NaturalNumberAdder(prime1,prime2,evennumber),
    		new NaturalNumberPrimer(prime1),
    		new NaturalNumberPrimer(prime2));
    List<IBooleanLiteral> s=p.findModel();
    if(s!=null && s.size()>0)
	{
		BooleanLiteral.interpret(s);
		System.out.println(prime1);
		System.out.println(prime2);
	}
	else
		System.out.println("No solution.");
  }
}
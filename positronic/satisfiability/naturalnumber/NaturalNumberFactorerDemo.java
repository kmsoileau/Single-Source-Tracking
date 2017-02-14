package positronic.satisfiability.naturalnumber;

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
import positronic.satisfiability.elements.IProblem;

public class NaturalNumberFactorerDemo
{
  public static void main(String[] args) throws Exception
  {
    INaturalNumber X=new NaturalNumber("X");
    INaturalNumber Y=new NaturalNumber("Y");
    INaturalNumber Z=new NaturalNumber("Z");

    NaturalNumberFixer bnnfz=new NaturalNumberFixer(Z,14L);
    NaturalNumberFactorer NaturalNumberFactorer1 = new NaturalNumberFactorer(X,Y,Z);

    IProblem p=new Conjunction(bnnfz,NaturalNumberFactorer1);
    List<?> s=p.findModel();
    BooleanLiteral.interpret(s);
    System.out.println("X = "+X);
    System.out.println("Y = "+Y);
    System.out.println("Z = "+Z);
  }
}
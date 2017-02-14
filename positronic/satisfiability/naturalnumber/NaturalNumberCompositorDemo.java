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

import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.IProblem;

public class NaturalNumberCompositorDemo
{
  public static void main(String[] args) throws Exception
  {
  	INaturalNumber Z=new NaturalNumber("Z");
    IProblem p=new Conjunction(new NaturalNumberFixer(Z,13L),new NaturalNumberCompositor(Z));
    List<?> s=p.findModel();
    System.out.println(s);
  }
}
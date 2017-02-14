package positronic.satisfiability.demos;

/**
 * <p>Title: TBS</p>
 * <p>Description: TBS</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Positronic Software</p>
 * @author Kerry Michael Soileau
 * @version 1.0
 */
import java.util.List;

import positronic.satisfiability.NaturalNumberBitStringEqualizer;
import positronic.satisfiability.bitstring.BitString;
import positronic.satisfiability.bitstring.IBitString;
import positronic.satisfiability.elements.BooleanLiteral;
import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.IBooleanLiteral;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;
import positronic.satisfiability.naturalnumber.INaturalNumber;
import positronic.satisfiability.naturalnumber.NaturalNumber;
import positronic.satisfiability.naturalnumber.NaturalNumberFixer;

public class NaturalNumberBitStringEqualizerDemo extends Problem implements IProblem
{
  private static final long serialVersionUID = 1L;

  public static void main(String[] args) throws Exception
  {
    INaturalNumber X=new NaturalNumber("X");
    IBitString Y=new BitString("Y",new boolean[X.size()]);

    IProblem p1=new NaturalNumberFixer(X,128L);
    IProblem p2=new NaturalNumberBitStringEqualizer(X,Y);
    IProblem p=new Conjunction(p1,p2);
    List<IBooleanLiteral> s=p.findModel(Problem.defaultSolver());
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
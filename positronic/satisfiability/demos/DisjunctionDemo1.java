package positronic.satisfiability.demos;

import java.util.List;

import positronic.satisfiability.elements.BitEqualizer;
import positronic.satisfiability.elements.BooleanLiteral;
import positronic.satisfiability.elements.BooleanVariable;
import positronic.satisfiability.elements.Disjunction;
import positronic.satisfiability.elements.IBooleanLiteral;
import positronic.satisfiability.elements.IBooleanVariable;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;
/**
 * <p>Title: DisjunctionDemo1</p>
 * <p>Description: TBS</p>
 * <p>Copyright (c) 2005</p>
 * <p>Company: Positronic Software</p>
 * @author Kerry Michael Soileau
 * @version 1.0
 */

public class DisjunctionDemo1
{
  public static void main(String[] args) throws Exception
  {
    IBooleanVariable X=BooleanVariable.getBooleanVariable("X");
    IBooleanVariable Y=BooleanVariable.getBooleanVariable("Y");
    IBooleanVariable Z=BooleanVariable.getBooleanVariable("Z");
    IBooleanVariable W=BooleanVariable.getBooleanVariable("W");
    Disjunction disjunction1=new Disjunction(new IProblem[]
    {
      new BitEqualizer(X,Y),
      new BitEqualizer(Y,Z),
      new BitEqualizer(Z,W),
    });
    System.out.println(disjunction1);
    List<IBooleanLiteral> s=disjunction1.findModel(Problem.defaultSolver());
		if(s!=null && s.size()>0)
    {
			System.out.println(s);
      BooleanLiteral.interpret(s);
    	System.out.println("X= "+X.getValue());
    	System.out.println("Y= "+Y.getValue());
    	System.out.println("Z= "+Z.getValue());
    	System.out.println("W= "+W.getValue());
    }
    else
      System.out.println("No solution.");                                                   
  }
}
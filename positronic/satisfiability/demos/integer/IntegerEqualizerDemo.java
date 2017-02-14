package positronic.satisfiability.demos.integer;
/**
 * <p>Title: TBS</p>
 * <p>Description: TBS</p>
 * <p>Copyright (c) 2010</p>
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
import positronic.satisfiability.integer.IInteger;
import positronic.satisfiability.integer.Integer;
import positronic.satisfiability.integer.IntegerEqualizer;
import positronic.satisfiability.integer.IntegerFixer;

public class IntegerEqualizerDemo
{
  public static void main(String[] args) throws Exception
  {
    IInteger X=new Integer("X",6L);
    IInteger Y=new Integer("Y",6L);

    IProblem p=new Conjunction(
    		new IntegerFixer(X),
    		new IntegerFixer(Y),
    		new IntegerEqualizer(X,Y));
    System.out.println(p);
    List<IBooleanLiteral> s=p.findModel(Problem.defaultSolver());
		if(s!=null && s.size()>0)
    {
      BooleanLiteral.interpret(s);
    	System.out.println("X= "+X);
    	System.out.println("Y= "+Y);
    }
    else
      System.out.println("No solution.");
		
		String sss=((Problem)p).toSatSimTable();
		System.out.println(sss);
  }
}
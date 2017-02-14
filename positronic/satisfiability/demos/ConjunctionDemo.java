package positronic.satisfiability.demos;

import java.util.List;

import positronic.satisfiability.elements.BitEqualizer;
import positronic.satisfiability.elements.BitFixer;
import positronic.satisfiability.elements.BooleanLiteral;
import positronic.satisfiability.elements.BooleanVariable;
import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.IBooleanLiteral;
import positronic.satisfiability.elements.IBooleanVariable;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;

public class ConjunctionDemo
{
  public static void main(String[] args) throws Exception
  {
    IBooleanVariable X=BooleanVariable.getBooleanVariable("X");
    IBooleanVariable Y=BooleanVariable.getBooleanVariable("Y");
    IBooleanVariable Z=BooleanVariable.getBooleanVariable("Z");
    
    IProblem fixY=new BitFixer(Y,true);
    IProblem fixZ=new BitFixer(Y,true);
    IProblem conjunction1 = new Conjunction(new BitEqualizer(X,Y),new BitEqualizer(Y,Z));
    IProblem problem=new Conjunction(fixY,fixZ,conjunction1);
    System.out.println(problem);
    List<IBooleanLiteral> s=problem.findModel(Problem.defaultSolver());
		if(s!=null && s.size()>0)
    {
      BooleanLiteral.interpret(s);
    	System.out.println("X= "+X.getValue());
    	System.out.println("Y= "+Y.getValue());
    	System.out.println("Z= "+Z.getValue());
    }
    else
      System.out.println("No solution.");
  }
}
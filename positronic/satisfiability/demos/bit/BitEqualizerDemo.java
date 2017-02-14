package positronic.satisfiability.demos.bit;

import java.util.List;

import positronic.satisfiability.elements.BitEqualizer;
import positronic.satisfiability.elements.BooleanLiteral;
import positronic.satisfiability.elements.BooleanVariable;
import positronic.satisfiability.elements.IBooleanLiteral;
import positronic.satisfiability.elements.IBooleanVariable;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;

public class BitEqualizerDemo
{
  public static void main(String[] args) throws Exception//BooleanLiteralException, BitEqualizerException
  {
    IBooleanVariable x=BooleanVariable.getBooleanVariable("x");
    IBooleanVariable y=BooleanVariable.getBooleanVariable("y");

    IProblem bitEqualizer1 = new BitEqualizer(x,y);
    System.out.println(bitEqualizer1);
    List<IBooleanLiteral> s=bitEqualizer1.findModel(Problem.defaultSolver());
	if(s!=null && s.size()>0)
    {
		BooleanLiteral.interpret(s);
    	System.out.println("x= "+x.getValue());
    	System.out.println("y= "+y.getValue());
    }
    else
    	System.out.println("No solution.");
  }
}
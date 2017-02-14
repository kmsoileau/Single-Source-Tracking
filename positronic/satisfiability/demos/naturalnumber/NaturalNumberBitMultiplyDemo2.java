package positronic.satisfiability.demos.naturalnumber;

import java.util.List;

import positronic.satisfiability.elements.BitFixer;
import positronic.satisfiability.elements.BooleanLiteral;
import positronic.satisfiability.elements.BooleanVariable;
import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.IBooleanLiteral;
import positronic.satisfiability.elements.IBooleanVariable;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;
import positronic.satisfiability.naturalnumber.INaturalNumber;
import positronic.satisfiability.naturalnumber.NaturalNumber;
import positronic.satisfiability.naturalnumber.NaturalNumberBitMultiply;
import positronic.satisfiability.naturalnumber.NaturalNumberFixer;

public class NaturalNumberBitMultiplyDemo2
{
  public static void main(String[] args) throws Exception
  {
  	IBooleanVariable[] b=new IBooleanVariable[4];
    INaturalNumber[] X=new INaturalNumber[4];
    INaturalNumber[] Y=new INaturalNumber[4];
    
    b[0]=BooleanVariable.getBooleanVariable("b0",true);
    b[1]=BooleanVariable.getBooleanVariable("b1",true);
    b[2]=BooleanVariable.getBooleanVariable("b2",false);
    b[3]=BooleanVariable.getBooleanVariable("b3",true);
    
    X[0]=new NaturalNumber("x0",213L);
    X[1]=new NaturalNumber("x1",123L);
    X[2]=new NaturalNumber("x2",34L);
    X[3]=new NaturalNumber("x3",2L);
    
    Y[0]=new NaturalNumber("y0");
    Y[1]=new NaturalNumber("y1");
    Y[2]=new NaturalNumber("y2");
    Y[3]=new NaturalNumber("y3");

    IProblem p=new Conjunction(new IProblem[]{
    		new BitFixer(b[0]),
    		new BitFixer(b[1]),
    		new BitFixer(b[2]),
    		new BitFixer(b[3]),
    		new NaturalNumberFixer(X[0]),
    		new NaturalNumberFixer(X[1]),
    		new NaturalNumberFixer(X[2]),
    		new NaturalNumberFixer(X[3]),
    		new NaturalNumberBitMultiply(b,X,Y)});
    
    List<IBooleanLiteral> s=p.findModel(Problem.defaultSolver());
    
	if(s!=null && s.size()>0)
	{
		BooleanLiteral.interpret(s);
		for(int i=0;i<b.length;i++)
		{
			System.out.println(b[i].getName()+"="+b[i].getValue());
			System.out.println(X[i].getName()+"="+X[i]);
			System.out.println(Y[i].getName()+"="+Y[i]);
		}
	}
	else
		System.out.println("No solution.");
  }
}
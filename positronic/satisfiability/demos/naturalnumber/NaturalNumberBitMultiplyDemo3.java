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
import positronic.satisfiability.naturalnumber.NaturalNumberBitMultiply;
import positronic.satisfiability.naturalnumber.NaturalNumberFixer;
import positronic.satisfiability.naturalnumberlist.INaturalNumberList;
import positronic.satisfiability.naturalnumberlist.NaturalNumberList;

public class NaturalNumberBitMultiplyDemo3
{
  public static void main(String[] args) throws Exception
  {
	IBooleanVariable[] b=new IBooleanVariable[4];
    INaturalNumberList X=new NaturalNumberList("X",new long[]{0,0,0,0});
    INaturalNumberList Y=new NaturalNumberList("Y",new long[]{0,0,0,0});
    
    b[0]=BooleanVariable.getBooleanVariable("b0",true);
    b[1]=BooleanVariable.getBooleanVariable("b1",true);
    b[2]=BooleanVariable.getBooleanVariable("b2",false);
    b[3]=BooleanVariable.getBooleanVariable("b3",true);
    
    X.getNaturalNumber(2).setName("ggdsdfgfdg");
    
    IProblem p=new Conjunction(new IProblem[]{
    		new BitFixer(b[0]),
    		new BitFixer(b[1]),
    		new BitFixer(b[2]),
    		new BitFixer(b[3]),
    		new NaturalNumberFixer(X.getNaturalNumber(0),17L),
    		new NaturalNumberFixer(X.getNaturalNumber(1),123L),
    		new NaturalNumberFixer(X.getNaturalNumber(2),34L),
    		new NaturalNumberFixer(X.getNaturalNumber(3),2L),
    		new NaturalNumberBitMultiply(b,X,Y)});
    
    List<IBooleanLiteral> s=p.findModel(Problem.defaultSolver());
    
	if(s!=null && s.size()>0)
	{
		BooleanLiteral.interpret(s);
		for(int i=0;i<b.length;i++)
		{
			System.out.println(b[i].getName()+"="+b[i].getValue());
			System.out.println(X.getNaturalNumber(i).getName()+"="+X.getNaturalNumber(i));
			System.out.println(Y.getNaturalNumber(i).getName()+"="+Y.getNaturalNumber(i));
		}
	}
	else
		System.out.println("No solution.");
  }
}
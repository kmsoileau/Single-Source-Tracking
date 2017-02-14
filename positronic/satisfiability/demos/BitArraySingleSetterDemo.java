package positronic.satisfiability.demos;

import java.util.List;

import positronic.satisfiability.elements.BitArraySingleSetter;
import positronic.satisfiability.elements.BooleanLiteral;
import positronic.satisfiability.elements.BooleanVariable;
import positronic.satisfiability.elements.IBooleanVariable;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;

public class BitArraySingleSetterDemo 
{
	public static void main(String[] args) throws Exception
	{
		IBooleanVariable[] array=new IBooleanVariable[5];
		for(int i=0;i<array.length;i++)
			array[i]=BooleanVariable.getBooleanVariable();
		IProblem problem=new BitArraySingleSetter(array);
		
		System.out.println(problem);
		
		List<?> s=problem.findModel(Problem.defaultSolver());
		if(s!=null && s.size()>0)
		{
			BooleanLiteral.interpret(s);
			System.out.println(array[0]);
			System.out.println(array[1]);
			System.out.println(array[2]);
			System.out.println(array[3]);
			System.out.println(array[4]);
    	}
		else
			System.out.println("There is no solution.");
	}
}

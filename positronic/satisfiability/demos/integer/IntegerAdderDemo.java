package positronic.satisfiability.demos.integer;

import java.io.FileWriter;
import java.util.List;

import positronic.satisfiability.elements.BooleanLiteral;
import positronic.satisfiability.elements.BooleanVariable;
import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.IBooleanLiteral;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;
import positronic.satisfiability.integer.IInteger;
import positronic.satisfiability.integer.Integer;
import positronic.satisfiability.integer.IntegerAdder;
import positronic.satisfiability.integer.IntegerFixer;
import positronic.satisfiability.naturalnumber.NaturalNumber;

public class IntegerAdderDemo
{
	public static void main(String[] args) throws Exception
	{
		NaturalNumber.setLength(3);
		BooleanVariable.setPrefix("B$");
		NaturalNumber.setPrefix("N$");
		IInteger i1=new Integer("I",3L);
		IInteger i2=new Integer("J",4L);
		IInteger i3=new Integer("K");
		
		IProblem p1=new IntegerFixer(i1);
		IProblem p2=new IntegerFixer(i2);
		IProblem p3=new IntegerAdder(i1,i2,i3);
		
		IProblem problem=new Conjunction(p1,p2,p3);
		
		String ps = problem.toMathematicaCode();
		FileWriter fw=new FileWriter("C:\\Users\\Kerry Soileau\\Desktop\\mathe.txt");
		fw.write(ps);
		fw.close();
	  
		System.out.println(problem);
    
		List<IBooleanLiteral> s=problem.findModel(Problem.defaultSolver());

		if(s!=null && s.size()>0)
		{
			BooleanLiteral.interpret(s);
			System.out.println(i1);
			System.out.println(i2);
			System.out.println(i3);
		}
		else
			System.out.println("No solution.");
		
		String sss=((Problem)problem).toSatSimTable();
		System.out.println(sss);
	}
}

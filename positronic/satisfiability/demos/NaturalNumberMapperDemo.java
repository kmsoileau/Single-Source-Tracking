package positronic.satisfiability.demos;

import java.util.List;

import positronic.satisfiability.elements.BooleanLiteral;
import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.IBooleanLiteral;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;
import positronic.satisfiability.naturalnumber.INaturalNumber;
import positronic.satisfiability.naturalnumber.NaturalNumber;
import positronic.satisfiability.naturalnumber.NaturalNumberFixer;
import positronic.satisfiability.naturalnumber.NaturalNumberMapper;

public class NaturalNumberMapperDemo
{
	public static void main(String[] args) throws Exception
  {
    INaturalNumber abscissa=new NaturalNumber("abscissa");
    INaturalNumber ordinate=new NaturalNumber("ordinate");
    
    IProblem nnm1=new NaturalNumberMapper(
    		abscissa,new long[]{1,2,3,4,5},
    		ordinate,new long[]{2,5,6,6,5});
    IProblem nnf=new NaturalNumberFixer(ordinate,4);
    IProblem problem=new Conjunction(nnm1,nnf);
    System.out.println(problem.toXML());
    
    List<IBooleanLiteral> s=problem.findModel(Problem.defaultSolver());
		if(s!=null && s.size()>0)
    {
      BooleanLiteral.interpret(s);
    	System.out.println("abscissa= "+abscissa);
    	System.out.println("ordinate= "+ordinate);
    }
    else
      System.out.println("No solution.");
   }
}

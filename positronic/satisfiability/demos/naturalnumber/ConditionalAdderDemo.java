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
import positronic.satisfiability.naturalnumber.ConditionalAdder;
import positronic.satisfiability.naturalnumber.INaturalNumber;
import positronic.satisfiability.naturalnumber.NaturalNumber;
import positronic.satisfiability.naturalnumber.NaturalNumberFixer;


public class ConditionalAdderDemo 
{
	public static void main(String[] args) throws Exception
	{
		INaturalNumber X=new NaturalNumber("X");
	    INaturalNumber Y=new NaturalNumber("Y");
	    INaturalNumber Z=new NaturalNumber("Z");
	    INaturalNumber C=new NaturalNumber("C");
	    
	    INaturalNumber conditionalSum=new NaturalNumber("conditionalSum");
	    
	    IBooleanVariable bitX=BooleanVariable.getBooleanVariable("bitX");
	    IBooleanVariable bitY=BooleanVariable.getBooleanVariable("bitY");
	    IBooleanVariable bitZ=BooleanVariable.getBooleanVariable("bitZ");
	    IBooleanVariable bitC=BooleanVariable.getBooleanVariable("bitC");

	    IProblem p=new Conjunction(
	    		new IProblem[]{
	    				new NaturalNumberFixer(X,34),
	    				new NaturalNumberFixer(Y,17),
	    				new NaturalNumberFixer(Z,12),
	    				new NaturalNumberFixer(C,21),
	    				new ConditionalAdder(
	    						new INaturalNumber[]{X,Y,Z,C}, 
	    						new IBooleanVariable[]{bitX,bitY,bitZ,bitC},
	    						conditionalSum),
	    				new BitFixer(bitX,true),
	    				new BitFixer(bitY,false),
	    				new BitFixer(bitZ,false),
	    				new BitFixer(bitC,true)});

	    System.out.println(p);
	    List<IBooleanLiteral> s=p.findModel(Problem.defaultSolver());
			if(s!=null && s.size()>0)
	    {
	      BooleanLiteral.interpret(s);
	      System.out.println("X = "+X);
	      System.out.println("Y = "+Y);
	      System.out.println("Z = "+Z);
	      System.out.println("C = "+C);
	      System.out.println("conditionalSum = "+conditionalSum);
	    }
			else
	      System.out.println("No solution.");
	}
}

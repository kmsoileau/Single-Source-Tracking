package positronic.satisfiability.demos.naturalnumber;

import java.util.List;

import positronic.satisfiability.elements.BooleanLiteral;
import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.IBooleanLiteral;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;
import positronic.satisfiability.naturalnumber.INaturalNumber;
import positronic.satisfiability.naturalnumber.NaturalNumber;
import positronic.satisfiability.naturalnumber.NaturalNumberFixer;
import positronic.satisfiability.naturalnumber.NaturalNumberMultiplier;

public class NaturalNumberMultiplierDemo3
{
  public static void main(String[] args) throws Exception
  {
    INaturalNumber X=new NaturalNumber("X");
    INaturalNumber Y=new NaturalNumber("Y");
    INaturalNumber Z=new NaturalNumber("Z");

    IProblem p;
    List<IBooleanLiteral> s;
    for(long i=1;i<(long)(Math.pow(2.,NaturalNumber.getLength()));i++)
    	for(long j=0;i*j<(long)Math.pow(2.,NaturalNumber.getLength());j++)
		{
			p=new Conjunction(new IProblem[]
		    		{
		    			new NaturalNumberMultiplier(X,Y,Z),
			    		new NaturalNumberFixer(X,i),
			    		new NaturalNumberFixer(Y,j),
		    		});
		    
		    s=p.findModel(Problem.defaultSolver());
			if(s!=null && s.size()>0)
		    {
				BooleanLiteral.interpret(s);
				System.out.print("\nX = "+X);
				System.out.print("\tY = "+Y);
				System.out.print("\tZ = "+Z);
		    }
			else
				System.out.println("No solution.");
		}
  }
}
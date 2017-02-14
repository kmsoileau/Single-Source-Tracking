package positronic.satisfiability.demos.naturalnumber;

/**
 * <p>Title: TBS</p>
 * <p>Description: TBS</p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: Positronic Software</p>
 * @author Kerry Michael Soileau
 * @version 1.0
 */
import java.util.List;

import positronic.satisfiability.elements.BooleanLiteral;
import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.IBooleanLiteral;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.naturalnumber.INaturalNumber;
import positronic.satisfiability.naturalnumber.NaturalNumber;
import positronic.satisfiability.naturalnumber.NaturalNumberFixer;
import positronic.satisfiability.naturalnumber.NaturalNumberIncrementer;
import positronic.satisfiability.naturalnumber.NaturalNumberMultiplier;
import positronic.satisfiability.naturalnumber.NaturalNumberOrderer;

public class NaturalNumberTriangularDemo
{
  public static void main(String[] args) throws Exception
  {
  	INaturalNumber X=new NaturalNumber("X");
    INaturalNumber Two=new NaturalNumber("Two");
    INaturalNumber TwoZ=new NaturalNumber("TwoZ");
    INaturalNumber Y=new NaturalNumber("Y");
  	INaturalNumber Z=new NaturalNumber("Z");
  	INaturalNumber Bound=new NaturalNumber("Bound");
  	
  	IProblem p=new Conjunction(new IProblem[]{
  			new NaturalNumberFixer(Two,2),
  			new NaturalNumberIncrementer(X,Y),
  					new NaturalNumberMultiplier(X,Y,TwoZ),
  					new NaturalNumberFixer(Bound,100),
  					new NaturalNumberOrderer(Bound,Z),
  					new NaturalNumberMultiplier(Two,Z,TwoZ),
  	}
  					);
  	
  	/*p=new Conjunction(new NaturalNumberFixer(Two),
  			new NaturalNumberFixer(Z,6),
  			new NaturalNumberTriangular(X,Two,TwoZ,Y,Z));*/
  	List<IBooleanLiteral> s=p.findModel();
  	System.out.println(p);
  	System.out.println(s);
    BooleanLiteral.interpret(s);
    System.out.println("X = "+X);
    System.out.println("Two = "+Two);
    System.out.println("TwoZ = "+TwoZ);
    System.out.println("Y = "+Y);
    System.out.println("Z = "+Z);
    
    /*PartialSolution ps=new PartialSolution(new ArrayListSet(),p);
    ps.eliminateSingletons();
    System.out.println(ps.getBooleanLiterals());
    System.out.println(ps.getProblem());*/
    
  	
    
  }
}
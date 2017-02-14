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
import positronic.satisfiability.naturalnumber.NaturalNumberMapperInverse;
/**
 * <p>Title: NaturalNumberMappingInverseDemo</p>
 * <p>Description: TBS</p>
 * <p>Copyright (c) 2005</p>
 * <p>Company: Positronic Software</p>
 * @author Kerry Michael Soileau
 * @version 1.0
 */

public class NaturalNumberMapperInverseDemo
{
  public static void main(String[] args) throws Exception
  {
    NaturalNumberMapper nnm1=null;
    
    long[] x=new long[]{11,2,3,4,5};
    long[] y=new long[]{23,45,16,36,78};
    nnm1=new NaturalNumberMapper(new NaturalNumber("abscissafirst"),x,new NaturalNumber("ordinatefirst"),y);

    INaturalNumber X=new NaturalNumber("fore");
    INaturalNumber Y=new NaturalNumber("aft");
    IProblem finv=null;
    
    finv=new Conjunction(new NaturalNumberMapperInverse(nnm1,X,Y),new NaturalNumberFixer(X,45L));
    
    System.out.println(finv);
    List<IBooleanLiteral> s=finv.findModel(Problem.defaultSolver());
		if(s!=null && s.size()>0)
    {
      BooleanLiteral.interpret(s);
    	System.out.println("X= "+X);
    	System.out.println("Y= "+Y);
    }
    else
      System.out.println("No solution.");
  }
}
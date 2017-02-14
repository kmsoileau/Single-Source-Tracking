package positronic.satisfiability.demos;

import java.util.List;

import positronic.satisfiability.elements.BooleanLiteral;
import positronic.satisfiability.elements.IBooleanLiteral;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;
import positronic.satisfiability.naturalnumber.INaturalNumber;
import positronic.satisfiability.naturalnumber.NaturalNumber;
import positronic.satisfiability.naturalnumber.NaturalNumberMapper;
import positronic.satisfiability.naturalnumber.NaturalNumberMapperComposition;
/**
 * <p>Title: NaturalNumberMapperCompositionDemo</p>
 * <p>Description: TBS</p>
 * <p>Copyright (c) 2005</p>
 * <p>Company: Positronic Software</p>
 * @author Kerry Michael Soileau
 * @version 1.0
 */

public class NaturalNumberMapperCompositionDemo
{
  public static void main(String[] args) throws Exception
  {
    NaturalNumberMapper nnm1=new NaturalNumberMapper(
    		new NaturalNumber("abscissafirst"),new long[]{11,2,3,4,5},
    		new NaturalNumber("ordinatefirst"),new long[]{36,45,16,36,78});
    
    NaturalNumberMapper nnm2=new NaturalNumberMapper(
    		new NaturalNumber("abscissasecond"),new long[]{23,45,16,36,78},
    		new NaturalNumber("ordinatesecond"),new long[]{3,5,6,6,8});
    
    INaturalNumber X=new NaturalNumber("fore");
    INaturalNumber Y=new NaturalNumber("aft");
    IProblem compo=new NaturalNumberMapperComposition(nnm1,nnm2,X,Y);
    
    System.out.println(compo);
    List<IBooleanLiteral> s=compo.findModel(Problem.defaultSolver());
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
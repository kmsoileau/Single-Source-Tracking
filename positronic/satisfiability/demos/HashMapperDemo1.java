package positronic.satisfiability.demos;

import java.util.HashMap;
import java.util.List;

import positronic.satisfiability.elements.BooleanLiteral;
import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.HashMapper;
import positronic.satisfiability.elements.IBooleanLiteral;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.naturalnumber.INaturalNumber;
import positronic.satisfiability.naturalnumber.NaturalNumber;
import positronic.satisfiability.naturalnumber.NaturalNumberFixer;
/**
 * <p>Title: MapperDemo5</p>
 * <p>Description: TBS</p>
 * <p>Copyright (c) 2010</p>
 * <p>Company: Positronic Software</p>
 * @author Kerry Michael Soileau
 * @version 1.0
 */

public class HashMapperDemo1
{
  public static void main(String[] args) throws Exception
  {
  	INaturalNumber X=new NaturalNumber("x");
    INaturalNumber Y=new NaturalNumber("y");
    
    HashMap<Long,Long> h=new HashMap<Long,Long>();
    h.put(1L, 31L);
    h.put(2L, 28L);
    h.put(3L, 31L);
    h.put(4L, 30L);
    h.put(5L, 31L);
    h.put(6L, 30L);
    h.put(7L, 31L);
    h.put(8L, 31L);
    h.put(9L, 30L);
    h.put(10L, 31L);
    h.put(11L, 30L);
    h.put(12L, 31L);
    
    IProblem calendar=new HashMapper(h,X,Y);
    
    IProblem problem=new Conjunction(calendar,
    		new NaturalNumberFixer(X,2L));
    
    List<IBooleanLiteral> s=problem.findModel();
		if(s!=null && s.size()>0)
    {
      BooleanLiteral.interpret(s);
    	System.out.println("month = "+X);
    	System.out.println("number of days in month = "+Y);
    }
    else
      System.out.println("No solution.");
  }
}
package positronic.satisfiability.demos;

import java.util.HashMap;
import java.util.List;

import positronic.satisfiability.bitstring.BitString;
import positronic.satisfiability.bitstring.BitStringFixer;
import positronic.satisfiability.bitstring.IBitString;
import positronic.satisfiability.elements.BooleanLiteral;
import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.HashMapper;
import positronic.satisfiability.elements.IBooleanLiteral;
import positronic.satisfiability.elements.IProblem;
/**
 * <p>Title: MapperDemo6</p>
 * <p>Description: TBS</p>
 * <p>Copyright (c) 2010</p>
 * <p>Company: Positronic Software</p>
 * @author Kerry Michael Soileau
 * @version 1.0
 */

public class HashMapperDemo2
{
  public static void main(String[] args) throws Exception
  {
  	IBitString X=new BitString("x",4);
    IBitString Y=new BitString("y",5);
    
    HashMap<String,String> h=new HashMap<String,String>();
    h.put("0001", "11111");
    h.put("0010", "11100");
    h.put("0011", "11111");
    h.put("0100", "11110");
    h.put("0101", "11111");
    h.put("0110", "11110");
    h.put("0111", "11111");
    h.put("1000", "11111");
    h.put("1001", "11110");
    h.put("1010", "11111");
    h.put("1011", "11110");
    h.put("1100", "11111");
    
    IProblem calendar=new HashMapper(h,X,Y);
    
    IProblem problem=new Conjunction(calendar,
    		new BitStringFixer(X,"00010"));
    
    List<IBooleanLiteral> s=problem.findModel();
	if(s!=null && s.size()>0)
    {
      BooleanLiteral.interpret(s);
    	System.out.println("month = "+X.toBits());
    	System.out.println("number of days in month = "+Y.toBits());
    }
    else
      System.out.println("No solution.");
  }
}
package positronic.satisfiability.demos;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import positronic.satisfiability.elements.BooleanLiteral;
import positronic.satisfiability.elements.BooleanVariable;
import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.IBooleanLiteral;
import positronic.satisfiability.elements.IBooleanVariable;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Mapper;
import positronic.satisfiability.elements.ProblemPair;
import positronic.satisfiability.naturalnumber.INaturalNumber;
import positronic.satisfiability.naturalnumber.NaturalNumber;
import positronic.satisfiability.naturalnumber.NaturalNumberFixer;
/**
 * <p>Title: MapperDemo1</p>
 * <p>Description: TBS</p>
 * <p>Copyright (c) 2005</p>
 * <p>Company: Positronic Software</p>
 * @author Kerry Michael Soileau
 * @version 1.0
 */

public class MapperDemo1
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
    ProblemPair[] pp=new ProblemPair[h.size()];
    
    IBooleanVariable[] b=new IBooleanVariable[h.size()-1];
    for(int i=0;i<b.length;i++)
    	b[i]=BooleanVariable.getBooleanVariable("b"+i);
    
    Iterator<Long> it=h.keySet().iterator();
    int count=0;
    while(it.hasNext())
    {
    	Long key=it.next();
    	Long entry=h.get(key);
    	//System.out.println("key="+key+"\tentry="+entry);
    	pp[count++]=new ProblemPair(new NaturalNumberFixer(X,key),new NaturalNumberFixer(Y,entry));
    }
    
    Mapper calendar = new Mapper(pp,b);
    
    IProblem problem=new Conjunction(calendar,
    		new NaturalNumberFixer(X,6L));
    //System.out.println(problem);
    
    List<IBooleanLiteral> s=problem.findModel();
		if(s!=null && s.size()>0)
    {
      BooleanLiteral.interpret(s);
    	System.out.println("x= "+X);
    	System.out.println("y= "+Y);
    	
    	for(int i=0;i<b.length;i++)
    		System.out.println("B$"+i+"]= "+b[i].getValue());
    }
    else
      System.out.println("No solution.");
  }
}
/*
 * BitStringListSorterDemo.java	1.0 05/05/04
 *
 * Copyright 2004-2005 Positronic Software.
 *
 *
 */
 /**
 * <p>Title: BitStringListSorterDemo</p>
 * <p>Description: TBS</p>
 * <p>Copyright (c) 2005</p>
 * <p>Company: Positronic Software</p>
 * @author Kerry Michael Soileau
 * @version 1.0
 */

package positronic.satisfiability.demos.bitstringlist;

import java.util.List;

import positronic.satisfiability.bitstring.BitString;
import positronic.satisfiability.bitstringlist.BitStringList;
import positronic.satisfiability.bitstringlist.BitStringListFixer;
import positronic.satisfiability.bitstringlist.BitStringListSorter;
import positronic.satisfiability.bitstringlist.IBitStringList;
import positronic.satisfiability.elements.BooleanLiteral;
import positronic.satisfiability.elements.BooleanVariable;
import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.IBooleanLiteral;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;

public class BitStringListSorterDemo
{
  public static void main(String[] args) throws Exception
  {
	  BooleanVariable.setPrefix("bv");
	  BitString.setPrefix("bs");
    IBitStringList s1=new BitStringList("x",new boolean[][]
    {
      {true,false,true},
      //{false,true,false,true},
      {false,false,true},
      {true,false,false},
      {false,true,false}
    });
    System.out.println("s1.getName() = "+s1.getName());
    for(int i=0;i<s1.size();i++)
      System.out.println("s1.getBitString("+i+") = "+s1.getBitString(i));

    IBitStringList s2=new BitStringList("y",new boolean[][]
    {
      {false,true,false},
      //{false,true,false,true},
      {false,true,true},
      {true,false,false},
      {true,false,true}
    });
    System.out.println("s2.getName() = "+s2.getName());
    for(int i=0;i<s2.size();i++)
      System.out.println("s2.getBitString("+i+") = "+s2.getBitString(i));

    
    IProblem bslf=new BitStringListFixer(s1);
    
    IProblem bsls=new BitStringListSorter(s1,s2);
    
    IProblem problem=new Conjunction(bslf,bsls);
    
    problem.sort();
    System.out.println(problem);
    
    String mc=problem.toMathematicaCode();
    //System.out.println(c);
    System.out.println(mc);
    //System.out.println(xml);

    List<IBooleanLiteral> s=problem.findModel(Problem.defaultSolver());
		if(s!=null && s.size()>0)
    {
      BooleanLiteral.interpret(s);
    	System.out.println("s1="+s1);
    	System.out.println("s2="+s2);
    }
    else
      System.out.println("No solution.");
  }
}
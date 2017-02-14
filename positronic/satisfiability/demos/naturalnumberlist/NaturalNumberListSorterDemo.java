/*
 * NaturalNumberListSorterDemo.java	1.0 06/02/04
 *
 * Copyright 2006 Positronic Software.
 *
 *
 */
 /**
 * <p>Title: NaturalNumberListSorterDemo</p>
 * <p>Description: TBS</p>
 * <p>Copyright (c) 2006</p>
 * <p>Company: Positronic Software</p>
 * @author Kerry Michael Soileau
 * @version 1.0
 */

///SUSPECT CODE

package positronic.satisfiability.demos.naturalnumberlist;

import java.util.List;

import positronic.satisfiability.elements.BooleanLiteral;
import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.IBooleanLiteral;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;
import positronic.satisfiability.naturalnumberlist.INaturalNumberList;
import positronic.satisfiability.naturalnumberlist.NaturalNumberList;
import positronic.satisfiability.naturalnumberlist.NaturalNumberListFixer;
import positronic.satisfiability.naturalnumberlist.NaturalNumberListSorter;

public class NaturalNumberListSorterDemo
{
  public static void main(String[] args) throws Exception
  {
    INaturalNumberList s1=new NaturalNumberList("x",new long[]
    {
    		2,
        11,3,4,5,1,13,8
    });
    System.out.println("s1.getName() = "+s1.getName());

    for(int i=0;i<s1.size();i++)
      System.out.println("s1.getNaturalNumber("+i+") = "+s1.getNaturalNumber(i));

    /*INaturalNumberList s2=new NaturalNumberList("y",new long[]
    {
      234,
      23,
      123,
      512
    });*/
    
    INaturalNumberList s2=new NaturalNumberList("y",new long[s1.size()]);
    
    System.out.println("s2.getName() = "+s2.getName());
    for(int i=0;i<s2.size();i++)
      System.out.println("s2.getNaturalNumber("+i+") = "+s2.getNaturalNumber(i));

    
    IProblem bslf=new NaturalNumberListFixer(s1);
    
    IProblem bsls=new NaturalNumberListSorter(s1,s2);
    
    IProblem problem=new Conjunction(bslf,bsls);
    
    problem.sort();
    System.out.println(problem);

    List<IBooleanLiteral> s=problem.findModel(Problem.defaultSolver());
    //List s=PartialSolution.solveList(problem);
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

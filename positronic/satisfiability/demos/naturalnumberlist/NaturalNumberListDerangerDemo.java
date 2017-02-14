/*
 * NaturalNumberListDerangerDemo.java	1.0 09/05/21
 *
 * Copyright 2009 Positronic Software.
 *
 *
 */
 /**
 * <p>Title: NaturalNumberListDerangerDemo</p>
 * <p>Description: TBS</p>
 * <p>Copyright (c) 2009</p>
 * <p>Company: Positronic Software</p>
 * @author Kerry Michael Soileau
 * @version 1.0
 */

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

public class NaturalNumberListDerangerDemo
{
  public static void main(String[] args) throws Exception
  {
    INaturalNumberList s1=new NaturalNumberList("x",new long[]
    {
    		3,
    		1,
    		9,
    		11
    });
    

    INaturalNumberList s2=new NaturalNumberList("y",new long[]
    {
    		3,
    		1,
    		9,
    		11
    });
  
    IProblem bslf=new NaturalNumberListFixer(s1);
    IProblem bsls=new NaturalNumberListDeranger(s1,s2);
    
    IProblem problem=new Conjunction(bslf,bsls);
    
    System.out.println(problem);

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
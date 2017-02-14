package positronic.satisfiability.bitstringgroup;

/*
 * BitStringBinaryOperator.java	1.0 November 30, 2009
 *
 * Copyright 2009 Positronic Software.
 *
 *
 */

import java.util.ArrayList;
import java.util.List;

import positronic.satisfiability.bitstring.BitString;
import positronic.satisfiability.bitstring.BitStringEqualizer;
import positronic.satisfiability.bitstring.BitStringFixer;
import positronic.satisfiability.bitstring.IBitString;
import positronic.satisfiability.elements.BooleanLiteral;
import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.Disjunction;
import positronic.satisfiability.elements.IBooleanLiteral;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;

/**
 * <p>Title: <tt>BitStringBinaryOperator</tt> class</p>
 * <p>Description: This class, an extension of <tt>Problem</tt>, is created from
 * triplets of instances of <tt>Problem</tt> passed to one of the 
 * <tt>BitStringBinaryOperator</tt> constructors.
 * <p>Copyright (c) 2009</p>
 * <p>Company: Positronic Software</p>
 * @author Kerry Michael Soileau
 * @version 1.0
 */

public class BitStringBinaryOperator extends Problem implements IProblem
{
	private static final long serialVersionUID = 3891593851225135810L;

	public static void main(String[] args) throws Exception
	{
		IBitString E0=new BitString("A","00");
	  	IBitString E1=new BitString("B","01");
	  	IBitString E2=new BitString("C","10");
			ArrayList<IBitString> elements=new ArrayList<IBitString>();
			elements.add(E0);
			elements.add(E1);
			elements.add(E2);
  	
	  	IBitString answer=new BitString("answer",2);
	  	
	  	BitStringBinaryOperatorTable table=new BitStringBinaryOperatorTable("test",elements);
	  	
	  	IProblem[] problem1=new IProblem[]{
	  			new BitStringFixer(E0),
	  			new BitStringFixer(E1),
	  			new BitStringFixer(E2),
	  			new BitStringEqualizer(table.getLeft(0),E0),
	  			new BitStringEqualizer(table.getRight(0),E0),
	  			new BitStringEqualizer(table.getResult(0),E0),
	  			new BitStringEqualizer(table.getLeft(1),E0),
	  			new BitStringEqualizer(table.getRight(1),E1),
	  			new BitStringEqualizer(table.getResult(1),E1),
	  			new BitStringEqualizer(table.getLeft(2),E0),
	  			new BitStringEqualizer(table.getRight(2),E2),
	  			new BitStringEqualizer(table.getResult(2),E2),
	  			new BitStringEqualizer(table.getLeft(3),E1),
	  			new BitStringEqualizer(table.getRight(3),E0),
	  			new BitStringEqualizer(table.getResult(3),E1),
	  			new BitStringEqualizer(table.getLeft(4),E1),
	  			new BitStringEqualizer(table.getRight(4),E1),
	  			new BitStringEqualizer(table.getResult(4),E2),
	  			new BitStringEqualizer(table.getLeft(5),E1),
	  			new BitStringEqualizer(table.getRight(5),E2),
	  			new BitStringEqualizer(table.getResult(5),E0),
	  			new BitStringEqualizer(table.getLeft(6),E2),
	  			new BitStringEqualizer(table.getRight(6),E0),
	  			new BitStringEqualizer(table.getResult(6),E2),
	  			new BitStringEqualizer(table.getLeft(7),E2),
	  			new BitStringEqualizer(table.getRight(7),E1),
	  			new BitStringEqualizer(table.getResult(7),E0),
	  			new BitStringEqualizer(table.getLeft(8),E2),
	  			new BitStringEqualizer(table.getRight(8),E2),
	  			new BitStringEqualizer(table.getResult(8),E1),
	  			
	  	
	  			new BitStringBinaryOperator(table,E2,answer,E1)};
  	
	  	IProblem problem=new Conjunction(problem1);
	  	
	  	System.out.println(problem);
	  	
	  	List<IBooleanLiteral> s=problem.findModel(Problem.defaultSolver());
	    if(s!=null && s.size()>0)
	    {
	    	BooleanLiteral.interpret(s);
	    	System.out.println("A="+E0.toBits());
	    	System.out.println("B="+E1.toBits());
	   		System.out.println("C="+E2.toBits());
	   		System.out.println("Ans="+answer.toBits());
	    }
	    else
	      System.out.println("No solution.");
	    
	    for(int i=0;i<table.size();i++)
	    	System.out.println(table.getLeft(i).toBits()+" + "+table.getRight(i).toBits()+" = "+table.getResult(i).toBits());
	}
  
	public BitStringBinaryOperator(IBitStringBinaryOperatorTable table,IBitString X, IBitString Y, IBitString Z) throws Exception
	{
		if(table==null) 
			throw new BitStringBinaryOperatorException("A null IBitStringBinaryOperatorTable was passed to a constructor.");
	    if(table.size()==0) 
	    	throw new BitStringBinaryOperatorException("An empty IBitStringBinaryOperatorTable was passed to a constructor.");
	    IProblem res=null;
	    for(int i=0;i<table.size();i++)
	    	res=new Disjunction(res,new Conjunction(
	    			new BitStringEqualizer(X,table.getLeft(i)),
	    			new BitStringEqualizer(Y,table.getRight(i)),
	    			new BitStringEqualizer(Z,table.getResult(i))));
	    
	    this.setClauses(res.getClauses());
	}
}
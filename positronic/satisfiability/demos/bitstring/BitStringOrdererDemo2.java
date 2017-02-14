/*
 * BitStringOrdererDemo2.java	1.0 05/05/04
 *
 * Copyright 2005 Positronic Software.
 *
 *
 */

package positronic.satisfiability.demos.bitstring;

import java.util.ArrayList;
import java.util.List;

import positronic.satisfiability.bitstring.BitString;
import positronic.satisfiability.bitstring.BitStringOrderer;
import positronic.satisfiability.bitstring.IBitString;
import positronic.satisfiability.elements.BitFixer;
import positronic.satisfiability.elements.BooleanLiteral;
import positronic.satisfiability.elements.BooleanVariable;
import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.IBooleanLiteral;
import positronic.satisfiability.elements.IBooleanVariable;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;

public class BitStringOrdererDemo2
{
  
  public static void main(String[] args) throws Exception
  {
  	int degreeX=6;
    int degreeY=4;
    ArrayList<IProblem> pfix=new ArrayList<IProblem>();

    IBitString X=new BitString("X",new IBooleanVariable[degreeX]);
    for(int i=0;i<X.size();i++)
    {
      boolean value;
      if(Math.random()<.5) value=true;
      else value=false;
      X.setBooleanVariable(i,BooleanVariable.getBooleanVariable(X.getName()+"$"+i));
      X.getBooleanVariable(i).setValue(value);
      pfix.add(new BitFixer(X.getBooleanVariable(i),value));
    }

    System.out.println(X);

    IBitString Y=new BitString("Y",new IBooleanVariable[degreeY]);
    for(int i=0;i<Y.size();i++)
    {
      boolean value;
      if(Math.random()<.5) value=true;
      else value=false;
      Y.setBooleanVariable(i,BooleanVariable.getBooleanVariable(Y.getName()+"$"+i));
      Y.getBooleanVariable(i).setValue(value);
      pfix.add(new BitFixer(Y.getBooleanVariable(i),value));
    }

    System.out.println(Y);

    IProblem fix=new Conjunction(pfix);
    
    IProblem bta=new BitStringOrderer(X,Y);
    System.out.println(bta);

    IProblem problem=new Conjunction(fix,bta);
    
    List<IBooleanLiteral> s=problem.findModel(Problem.defaultSolver());
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
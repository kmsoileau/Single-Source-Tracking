package positronic.satisfiability.demos;

import java.util.List;

import positronic.satisfiability.elements.BooleanLiteral;
import positronic.satisfiability.elements.BooleanVariable;
import positronic.satisfiability.elements.Clause;
import positronic.satisfiability.elements.IBooleanLiteral;
import positronic.satisfiability.elements.IBooleanVariable;
import positronic.satisfiability.elements.IClause;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;
/**
 * <p>Title: TBS</p>
 * <p>Description: TBS</p>
 * <p>Copyright (c) 2005</p>
 * <p>Company: Positronic Software</p>
 * @author Kerry Michael Soileau
 * @version 1.0
 */

public class Demo1
{
  public static void main(String[] args) throws Exception
  {
    IBooleanVariable a=BooleanVariable.getBooleanVariable("a");
    IBooleanVariable b=BooleanVariable.getBooleanVariable("b");
    IBooleanVariable c=BooleanVariable.getBooleanVariable("c");

    IProblem p=new Problem();

    p.setClauses(new IClause[]
    {
      Clause.newClause().or(a),
      Clause.newClause().or(a).or(b),
      Clause.newClause().or(a).or(b).or(c),
    });

    System.out.println(p);
    List<IBooleanLiteral> s=p.findModel(Problem.defaultSolver());
		if(s!=null && s.size()>0)
    {
      BooleanLiteral.interpret(s);
    	System.out.println("a= "+a);
    	System.out.println("b= "+b);
    	System.out.println("c= "+c);
    }
    else
      System.out.println("No solution.");

    IBooleanVariable[] bv=new IBooleanVariable[10];
    for(int i=0;i<bv.length;i++)
      bv[i]=BooleanVariable.getBooleanVariable("x"+i);
    IProblem pp=Problem.randomProblem(bv,20);
    System.out.println(pp);
  }
}
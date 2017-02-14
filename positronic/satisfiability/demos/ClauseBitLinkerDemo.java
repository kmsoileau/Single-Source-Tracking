package positronic.satisfiability.demos;

import positronic.satisfiability.elements.BooleanVariable;
import positronic.satisfiability.elements.Clause;
import positronic.satisfiability.elements.ClauseBitLinker;
import positronic.satisfiability.elements.IBooleanVariable;
import positronic.satisfiability.elements.IClause;
import positronic.satisfiability.elements.IProblem;

public class ClauseBitLinkerDemo
{
	public static void main(String[] args) throws Exception
	{
    IBooleanVariable[] bva=new BooleanVariable[4];

    bva[0]=BooleanVariable.getBooleanVariable("foo30");
    bva[1]=BooleanVariable.getBooleanVariable("foo11");
    bva[2]=BooleanVariable.getBooleanVariable("foo23");
    bva[3]=BooleanVariable.getBooleanVariable("foo83");

    IClause clause=new Clause();
    
    clause.orNot(bva[0]);
    clause.or(bva[1]);
    clause.or(bva[2]);
    
    System.out.println(bva[3]);
    System.out.println(clause);
    
    IProblem result=new ClauseBitLinker(bva[3],clause);

    System.out.println(result);
	}
}

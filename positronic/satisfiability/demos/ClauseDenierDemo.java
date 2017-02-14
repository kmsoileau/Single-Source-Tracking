package positronic.satisfiability.demos;

import positronic.satisfiability.elements.BooleanVariable;
import positronic.satisfiability.elements.Clause;
import positronic.satisfiability.elements.ClauseDenier;
import positronic.satisfiability.elements.IBooleanVariable;
import positronic.satisfiability.elements.IClause;
import positronic.satisfiability.elements.Problem;

public class ClauseDenierDemo
{
  public static void main(String[] args) throws Exception
  {
    IBooleanVariable[] bva=new IBooleanVariable[3];

    bva[0]=BooleanVariable.getBooleanVariable("x_1");
    bva[1]=BooleanVariable.getBooleanVariable("x_2");
    bva[2]=BooleanVariable.getBooleanVariable("x_3");

    IClause clause=new Clause().or(bva[0]).orNot(bva[1]).or(bva[2]);

    System.out.println("The given clause was "+clause+".");
    System.out.println("The denial of this clause is the following Problem:");
    System.out.println(new ClauseDenier(clause));
    
    System.out.println(new ClauseDenier(null));
    System.out.println(new ClauseDenier(new Clause()));
    System.out.println(new ClauseDenier(Problem.unsolvableProblem().getClause(0)));
  }
}
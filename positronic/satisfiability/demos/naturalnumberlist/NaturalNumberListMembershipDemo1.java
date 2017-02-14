package positronic.satisfiability.demos.naturalnumberlist;

import java.util.List;

import positronic.satisfiability.elements.BooleanLiteral;
import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.IBooleanLiteral;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;
import positronic.satisfiability.naturalnumber.INaturalNumber;
import positronic.satisfiability.naturalnumber.NaturalNumber;
import positronic.satisfiability.naturalnumberlist.INaturalNumberList;
import positronic.satisfiability.naturalnumberlist.NaturalNumberList;
import positronic.satisfiability.naturalnumberlist.NaturalNumberListFixer;
import positronic.satisfiability.naturalnumberlist.NaturalNumberListMembership;
/**
 * <p>Title: NaturalNumberListMembershipDemo1</p>
 * <p>Description: TBS</p>
 * <p>Copyright (c) 2005</p>
 * <p>Company: Positronic Software</p>
 * @author Kerry Michael Soileau
 * @version 1.0
 */
public class NaturalNumberListMembershipDemo1
{
  public static void main(String[] args) throws Exception
  {
    INaturalNumberList bsl=new NaturalNumberList(
      "slist",
      new INaturalNumber[]
      {
        new NaturalNumber(100),
        new NaturalNumber(2),
        new NaturalNumber(3)
      });
    System.out.println(bsl);

    INaturalNumber string=new NaturalNumber("string");

    IProblem bslm=new NaturalNumberListMembership(string,bsl);
    IProblem fix=new NaturalNumberListFixer(bsl);

    IProblem problem=new Conjunction(bslm,fix);
    System.out.println(problem);

    List<IBooleanLiteral> s=problem.findModel(Problem.defaultSolver());
    if(s!=null && s.size()>0)
    {
      BooleanLiteral.interpret(s);
      System.out.println("string = "+string);
    }
    else
      System.out.println("No solution.");
  }
}
package positronic.satisfiability.demos.naturalnumberlist;

import java.util.List;

import positronic.satisfiability.elements.BooleanLiteral;
import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.IBooleanLiteral;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;
import positronic.satisfiability.naturalnumber.INaturalNumber;
import positronic.satisfiability.naturalnumber.NaturalNumber;
import positronic.satisfiability.naturalnumber.NaturalNumberUnequalizer;
import positronic.satisfiability.naturalnumberlist.INaturalNumberList;
import positronic.satisfiability.naturalnumberlist.NaturalNumberList;
import positronic.satisfiability.naturalnumberlist.NaturalNumberListFixer;
import positronic.satisfiability.naturalnumberlist.NaturalNumberListMembership;
/**
 * <p>Title: NaturalNumberListMembershipDemo2</p>
 * <p>Description: TBS</p>
 * <p>Copyright (c) 2005</p>
 * <p>Company: Positronic Software</p>
 * @author Kerry Michael Soileau
 * @version 1.0
 */

public class NaturalNumberListMembershipDemo2
{
  public static void main(String[] args) throws Exception
  {
    INaturalNumber string1=new NaturalNumber("string1");
    INaturalNumber string2=new NaturalNumber("string2");

    INaturalNumberList bsl=new NaturalNumberList("slist",new INaturalNumber[]
      {
        new NaturalNumber(11),
        new NaturalNumber(15),
        new NaturalNumber(14),
        new NaturalNumber(4),
        new NaturalNumber(7),
        new NaturalNumber(6)
      });

    //The list must have given values
    IProblem fix=new NaturalNumberListFixer(bsl);

    //Both strings must occur in the list
    IProblem bslm1=new NaturalNumberListMembership(string1,bsl);
    IProblem bslm2=new NaturalNumberListMembership(string2,bsl);
    //The two strings must be different
    IProblem diff=new NaturalNumberUnequalizer(string1,string2);
    //Combine all of the IProblems into a single IProblem
    IProblem problem=new Conjunction(bslm1,bslm2,fix,diff);
    problem.sort();

    System.out.println(problem);

    //Solve the IProblem
    List<IBooleanLiteral> s=problem.findModel(Problem.defaultSolver());

    if(s!=null && s.size()>0)
    {
      for(int i=0;i<s.size();i++)
        System.out.println(s.get(i));
      BooleanLiteral.interpret(s);
      System.out.println("bsl = "+bsl); 
      System.out.println("String1 = "+string1);
      System.out.println("String2 = "+string2);
    }
    else
      System.out.println("No solution.");
  }
}
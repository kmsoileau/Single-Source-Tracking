package positronic.satisfiability.demos.naturalnumberlist;

import java.util.List;

import positronic.satisfiability.elements.BooleanLiteral;
import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;
import positronic.satisfiability.naturalnumber.INaturalNumber;
import positronic.satisfiability.naturalnumber.NaturalNumber;
import positronic.satisfiability.naturalnumberlist.INaturalNumberList;
import positronic.satisfiability.naturalnumberlist.NaturalNumberList;
import positronic.satisfiability.naturalnumberlist.NaturalNumberListFixer;
import positronic.satisfiability.naturalnumberlist.NaturalNumberListMiner;
/**
 * <p>Title: NaturalNumberListMinerDemo</p>
 * <p>Description: TBS</p>
 * <p>Copyright (c) 2007</p>
 * <p>Company: Positronic Software</p>
 * @author Kerry Michael Soileau
 * @version 1.0
 */
public class NaturalNumberListMinerDemo
{
  public static void main(String[] args) throws Exception
  {
    INaturalNumberList numberList=new NaturalNumberList(
      "numberList",
      new INaturalNumber[]
      {
        new NaturalNumber(253),
        new NaturalNumber(101),
        new NaturalNumber(301),
        new NaturalNumber(211),
        new NaturalNumber(172),
        new NaturalNumber(353),
        new NaturalNumber(12),
        new NaturalNumber(87),
        new NaturalNumber(301)
      });
    System.out.println(numberList);

    INaturalNumber theMinValue=new NaturalNumber("minValue");

    IProblem minProb=new NaturalNumberListMiner(numberList,theMinValue);
    IProblem fixListProb=new NaturalNumberListFixer(numberList);

    IProblem problem=new Conjunction(minProb,fixListProb);
    System.out.println(problem);

    List<?> s=problem.findModel(Problem.defaultSolver());
    if(s!=null && s.size()>0)
    {
      BooleanLiteral.interpret(s);
      System.out.println("minValue = "+theMinValue);
    }
    else
      System.out.println("No solution.");
  }
}
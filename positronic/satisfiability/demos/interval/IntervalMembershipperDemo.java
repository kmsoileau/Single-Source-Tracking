package positronic.satisfiability.demos.interval;

import java.util.List;

import positronic.satisfiability.elements.BooleanLiteral;
import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;
import positronic.satisfiability.interval.IInterval;
import positronic.satisfiability.interval.Interval;
import positronic.satisfiability.interval.IntervalFixer;
import positronic.satisfiability.interval.IntervalMembershipper;
import positronic.satisfiability.naturalnumber.INaturalNumber;
import positronic.satisfiability.naturalnumber.NaturalNumber;
import positronic.satisfiability.naturalnumber.NaturalNumberFixer;
/**
 * <p>Title: IntervalMembershipperDemo</p>
 * <p>Description: TBS</p>
 * <p>Copyright (c) 2007</p>
 * <p>Company: Positronic Software</p>
 * @author Kerry Michael Soileau
 * @version 1.0
 */
public class IntervalMembershipperDemo
{
  public static void main(String[] args) throws Exception
  {
    INaturalNumber number=new NaturalNumber(11);
    IInterval interval=new Interval(new NaturalNumber(10),new NaturalNumber(23));

    IProblem problem=new Conjunction(
    		new IntervalFixer(interval),
    		new NaturalNumberFixer(number),
    		new IntervalMembershipper(interval,number));
    System.out.println(problem);

    List<?> s=problem.findModel(Problem.defaultSolver());
    if(s!=null && s.size()>0)
    {
      BooleanLiteral.interpret(s);
      System.out.println("interval = "+interval);
      System.out.println("number = "+number);
    }
    else
      System.out.println("No solution.");
  }
}
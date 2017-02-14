package positronic.satisfiability.demos;

import java.util.List;

import positronic.satisfiability.elements.BooleanLiteral;
import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.Disjunction;
import positronic.satisfiability.elements.IBooleanLiteral;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;
import positronic.satisfiability.exceptions.NaturalNumberListException;
import positronic.satisfiability.naturalnumber.NaturalNumberEqualizer;
import positronic.satisfiability.naturalnumberlist.INaturalNumberList;
import positronic.satisfiability.naturalnumberlist.NaturalNumberList;
import positronic.satisfiability.naturalnumberlist.NaturalNumberListFixer;

class PancakeFlipper extends Problem implements IProblem
{
	private static final long serialVersionUID = -2531552420105241317L;

	public PancakeFlipper(final INaturalNumberList before, final INaturalNumberList after) throws Exception
	{
		final IProblem[] subp=new IProblem[before.size()];
		for(int i=0;i<before.size();i++)
		{
			final IProblem[] p=new IProblem[before.size()];
			for(int j=0;j<i+1;j++)
			{
				p[j]=new NaturalNumberEqualizer(after.getNaturalNumber(j),before.getNaturalNumber(i-j));
			}
			for(int j=i+1;j<before.size();j++)
			{
				p[j]=new NaturalNumberEqualizer(after.getNaturalNumber(j),before.getNaturalNumber(j));
			}
			subp[i]=new Conjunction(p);
		}
		this.setClauses(new Disjunction(subp).getClauses());
	}
}

public class Pancakes
{
	public static int energy(INaturalNumberList l) throws Exception
	{
		int ret=0;
		int sgn=1;
		for(int i=0;i<l.size();i++)
		{
			try
			{
				ret+=sgn*Integer.parseInt(l.getNaturalNumber(i).toString());
			} catch (NumberFormatException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NaturalNumberListException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			sgn*=(-1);
		}
			
		return ret;
	}
	
	public static void main(String[] args) throws Exception
	{
		INaturalNumberList start=new NaturalNumberList(
				new long[]{0,2,9,6,4,8,1,7,5,3});
		INaturalNumberList goal=new NaturalNumberList(
				new long[]{0,1,2,3,4,5,6,7,8,9});
		int flips=9;
		INaturalNumberList[] flip=new NaturalNumberList[flips-1];
		for(int i=0;i<flips-1;i++)
			flip[i]=new NaturalNumberList(new long[start.size()]);
		IProblem fixstart=new NaturalNumberListFixer(start);
		IProblem fixgoal=new NaturalNumberListFixer(goal);
		IProblem[] flipper=new PancakeFlipper[flips];
		flipper[0]=new PancakeFlipper(start,flip[0]);
		for(int i=0;i<flips-2;i++)
			flipper[i+1]=new PancakeFlipper(flip[i],flip[i+1]);
		flipper[flips-1]=new PancakeFlipper(flip[flips-2],goal);
		IProblem problem=new Conjunction(fixstart,fixgoal,new Conjunction(flipper));
		
		List<IBooleanLiteral> s=problem.findModel(Problem.defaultSolver());
		if(s!=null && s.size()>0)
    {
      BooleanLiteral.interpret(s);
      System.out.println("start = "+start+"\t"+energy(start));
      for(int i=0;i<flips-1;i++)
      	System.out.println("flip$"+i+"] = "+flip[i]+"\t"+energy(flip[i]));
      System.out.println("goal = "+goal+"\t"+energy(goal));
    }
		else
			System.out.println("There is no solution.");
	}
}
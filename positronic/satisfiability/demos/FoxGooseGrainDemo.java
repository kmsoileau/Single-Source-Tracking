package positronic.satisfiability.demos;

import java.util.List;

import positronic.satisfiability.elements.BitEqualizer;
import positronic.satisfiability.elements.BitFixer;
import positronic.satisfiability.elements.BitUnequalizer;
import positronic.satisfiability.elements.BooleanLiteral;
import positronic.satisfiability.elements.BooleanVariable;
import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.Disjunction;
import positronic.satisfiability.elements.ExclusiveDisjunction;
import positronic.satisfiability.elements.IBooleanLiteral;
import positronic.satisfiability.elements.IBooleanVariable;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;
import positronic.satisfiability.elements.ProblemDenier;

class CrossAlone extends Problem implements IProblem
{
	private static final long serialVersionUID = -415239221862983507L;

	public CrossAlone(Status s1,Status s2) throws Exception
	{
		this.setClauses(new Conjunction(
				new IProblem[]{
						//new BitEqualizer(s1.boat,s1.farmer),
						new BoatAndFarmerTogether(s1),
						//new BitEqualizer(s2.boat,s2.farmer),
						new BoatAndFarmerTogether(s2),
						new BitUnequalizer(s1.boat,s2.boat),
						new BitEqualizer(s1.goose,s2.goose),
						new BitEqualizer(s1.fox,s2.fox),
						new BitEqualizer(s1.grain,s2.grain)}
		).getClauses());
	}
}

class BoatAndFarmerTogether extends Problem implements IProblem
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3891746155584127881L;

	public BoatAndFarmerTogether(Status s) throws Exception
	{
		this.setClauses(new BitEqualizer(s.boat,s.farmer).getClauses());
	}
}

class CrossTheRiver extends Problem implements IProblem
{
	private static final long serialVersionUID = -6257432340767347437L;

	public CrossTheRiver(Status s1,Status s2) throws Exception
	{
		this.setClauses(new ExclusiveDisjunction(
				new IProblem[]{
						new CrossWithFox(s1,s2),
						new CrossWithGoose(s1,s2),
						new CrossWithGrain(s1,s2),
						new CrossAlone(s1,s2)}
		).getClauses());
	}
}

class CrossWithFox extends Problem implements IProblem
{
	private static final long serialVersionUID = 2319201519378413233L;

	public CrossWithFox(Status s1,Status s2) throws Exception
	{
		this.setClauses(new Conjunction(
				new IProblem[]{
						new FarmerAndFoxTogether(s1),
						new FarmerAndFoxTogether(s2),
						new BitEqualizer(s1.boat,s1.farmer),
						new BitEqualizer(s2.boat,s2.farmer),
						new BitUnequalizer(s1.boat,s2.boat),
						new BitEqualizer(s1.goose,s2.goose),
						new BitEqualizer(s1.grain,s2.grain)}
		).getClauses());
	}
}

class CrossWithGoose extends Problem implements IProblem
{
	private static final long serialVersionUID = -1354767985790340236L;

	public CrossWithGoose(Status s1,Status s2) throws Exception
	{
		this.setClauses(new Conjunction(
				new IProblem[]{
						new FarmerAndGooseTogether(s1),
						new FarmerAndGooseTogether(s2),
						new BitEqualizer(s1.boat,s1.farmer),
						new BitEqualizer(s2.boat,s2.farmer),
						new BitUnequalizer(s1.boat,s2.boat),
						new BitEqualizer(s1.fox,s2.fox),
						new BitEqualizer(s1.grain,s2.grain)}
		).getClauses());
	}
}

class CrossWithGrain extends Problem implements IProblem
{
	private static final long serialVersionUID = -5891682124082196966L;

	public CrossWithGrain(Status s1,Status s2) throws Exception
	{
		this.setClauses(new Conjunction(
				new IProblem[]{
						new FarmerAndGrainTogether(s1),
						new FarmerAndGrainTogether(s2),
						new BitEqualizer(s1.boat,s1.farmer),
						new BitEqualizer(s2.boat,s2.farmer),
						new BitUnequalizer(s1.boat,s2.boat),
						new BitEqualizer(s1.fox,s2.fox),
						new BitEqualizer(s1.goose,s2.goose)}
		).getClauses());
	}
}

class FarmerAndFoxTogether extends Problem implements IProblem
{
	private static final long serialVersionUID = 164880712389461177L;

	public FarmerAndFoxTogether(Status s) throws Exception
	{
		this.setClauses(new BitEqualizer(s.farmer,s.fox).getClauses());
	}
}

class FarmerAndGooseTogether extends Problem implements IProblem
{
	private static final long serialVersionUID = -1767741192595346928L;

	public FarmerAndGooseTogether(Status s) throws Exception
	{
		this.setClauses(new BitEqualizer(s.farmer,s.goose).getClauses());
	}
}

class FarmerAndGrainTogether extends Problem implements IProblem
{
	private static final long serialVersionUID = 3343454200385857675L;

	public FarmerAndGrainTogether(Status s) throws Exception
	{
		this.setClauses(new BitEqualizer(s.farmer,s.grain).getClauses());
	}
}

class FoxAndGooseTogether extends Problem implements IProblem
{
	private static final long serialVersionUID = 3748635710590580510L;

	public FoxAndGooseTogether(Status s) throws Exception
	{
		this.setClauses(new BitEqualizer(s.fox,s.goose).getClauses());
	}
}

public class FoxGooseGrainDemo
{
	public static void main(String[] args) throws Exception
	{
		int crossings=7;
		Status[] status=new Status[crossings+1];
		for(int i=0;i<crossings+1;i++)
			status[i]=new Status();

		IProblem initPositions=new Conjunction(new IProblem[]{
    		new BitFixer(status[0].boat),
    		new BitFixer(status[0].farmer),
    		new BitFixer(status[0].fox),
    		new BitFixer(status[0].goose),
    		new BitFixer(status[0].grain)});
		
		IProblem finalPositions=new Conjunction(new IProblem[]{
				new BitFixer(status[crossings].boat,true),
    		new BitFixer(status[crossings].farmer,true),
    		new BitFixer(status[crossings].fox,true),
    		new BitFixer(status[crossings].goose,true),
    		new BitFixer(status[crossings].grain,true)});
		
		IProblem problem=new Conjunction(initPositions,finalPositions);
		
		for(int i=0;i<crossings;i++)
			problem=new Conjunction(problem,
					new CrossTheRiver(status[i],status[i+1]));
		
		for(int i=0;i<crossings+1;i++)
			problem=new Conjunction(problem,
					new StatusIsGood(status[i]));
    
		System.out.println(problem.toXML());
    
		List<IBooleanLiteral> s=problem.findModel(Problem.defaultSolver());
		if(s!=null && s.size()>0)
		{
			BooleanLiteral.interpret(s);
			for(int i=0;i<crossings+1;i++)
			{
				System.out.println("\n"+(status[i].boat.getValue()?"\t\t":"")+"Boat");
				System.out.println((status[i].farmer.getValue()?"\t\t":"")+"Farmer");
				System.out.println((status[i].fox.getValue()?"\t\t":"")+"Fox");
				System.out.println((status[i].goose.getValue()?"\t\t":"")+"Goose");
				System.out.println((status[i].grain.getValue()?"\t\t":"")+"Grain");
				System.out.println("-----------------------------------$");
			}
		}
		else
			System.out.println("There is no solution.");
	}
}

class GooseAndGrainTogether extends Problem implements IProblem
{
	private static final long serialVersionUID = -292897075823991262L;

	public GooseAndGrainTogether(Status s) throws Exception
	{
		this.setClauses(new BitEqualizer(s.goose,s.grain).getClauses());
	}
}

class GooseIsSafe extends Problem implements IProblem
{
	private static final long serialVersionUID = -2286585270991083106L;

	public GooseIsSafe(Status s) throws Exception
	{
		this.setClauses(new Disjunction(
				new ProblemDenier(new FoxAndGooseTogether(s)),
				new FarmerAndGooseTogether(s)
		).getClauses());
	}
}

class GrainIsSafe extends Problem implements IProblem
{
	private static final long serialVersionUID = 8300722284554026280L;

	public GrainIsSafe(Status s) throws Exception
	{
		this.setClauses(new Disjunction(
				new ProblemDenier(new GooseAndGrainTogether(s)),
				new FarmerAndGrainTogether(s)
		).getClauses());
	}
}

class Status
{
	IBooleanVariable boat;
	IBooleanVariable farmer;
	IBooleanVariable fox;
	IBooleanVariable goose;
	IBooleanVariable grain;
	
	public Status() throws Exception
	{
		boat=BooleanVariable.getBooleanVariable();
		farmer=BooleanVariable.getBooleanVariable();
		fox=BooleanVariable.getBooleanVariable();
		goose=BooleanVariable.getBooleanVariable();
		grain=BooleanVariable.getBooleanVariable();
	}
}

class StatusIsGood extends Problem implements IProblem
{
	private static final long serialVersionUID = -4746086930916156288L;

	public StatusIsGood(Status status) throws Exception
	{
		this.setClauses(
				new Conjunction(
			  		new GrainIsSafe(status),
			  		new GooseIsSafe(status)
			  		).getClauses()
		);
	}
}
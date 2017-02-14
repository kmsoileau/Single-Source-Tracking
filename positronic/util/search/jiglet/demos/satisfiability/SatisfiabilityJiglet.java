package positronic.util.search.jiglet.demos.satisfiability;

import positronic.satisfiability.elements.BooleanVariable;
import positronic.satisfiability.elements.IBooleanVariable;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;
import positronic.util.search.jiglet.IVertex;
import positronic.util.search.jiglet.Jiglet;

public class SatisfiabilityJiglet extends Jiglet
{
	IProblem p;
	
	public SatisfiabilityJiglet(IProblem problem) 
	{
		this.p=problem;
	}

	public static void main(String[] args) 
	{
		SatisfiabilityJiglet hss=null;
		try {
			hss = new SatisfiabilityJiglet(
					Problem.randomProblem(
							new IBooleanVariable[]
							{
									(IBooleanVariable) BooleanVariable.getBooleanVariable("A"),
									(IBooleanVariable) BooleanVariable.getBooleanVariable("B"),
									(IBooleanVariable) BooleanVariable.getBooleanVariable("C")
							},
							4)
						);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		try 
		{
			BVMap.backing=hss.p.getBooleanVariables();
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		hss.setTrials(10000);
		hss.start();
	}
	
	protected IVertex explore() 
	{
		IVertex output=currentVertex.duplicate();
		for(int i=0;i<output.dimension();i++)
		{
			((IDoubleVertex)output).setDoubleCoordinate(i,Math.random());
		}
		return output;
	}

	protected void init() 
	{
		try 
		{
			currentVertex=new SatisfiabilityVertex(p);
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		for(int i=0;i<currentVertex.dimension();i++)
			((IDoubleVertex)currentVertex).setDoubleCoordinate(i, Math.random());	
	}

	protected boolean perTrial() 
	{
		if(currentVertex.evaluate()>1e-3)
		{
			//System.out.println(currentVertex);
			return true;
		}
		else
		{
			System.out.println("Solution found!");
			System.out.println(currentVertex);
			return false;
		}
	}

	protected void wrapup() 
	{
		System.out.println("Finis");
	}
}




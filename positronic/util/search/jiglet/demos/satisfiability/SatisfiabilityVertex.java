package positronic.util.search.jiglet.demos.satisfiability;

import java.util.ArrayList;

import positronic.satisfiability.elements.IBooleanVariable;
import positronic.satisfiability.elements.IProblem;
import positronic.util.search.jiglet.IVertex;

public class SatisfiabilityVertex implements IDoubleVertex
{
	private IProblem problem;
	private int dim;
	BVMap bvm;
	
	public SatisfiabilityVertex(IProblem problem) throws Exception
	{
		this.problem=problem;
		bvm=new BVMap(problem.getBooleanVariables());
		ArrayList<IBooleanVariable> ar = problem.getBooleanVariables();
		this.dim=ar.size();
		for(int i=0;i<this.dimension();i++)
			bvm.setValue(ar.get(i),0.);
	}

	public int dimension() 
	{
		return dim;
	}

	public IVertex duplicate() 
	{
		try 
		{
			return new SatisfiabilityVertex(this.problem);
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		return null;
	}
	
	public double evaluate()
	{
		double ret=0.;
		for(int i=0;i<problem.size();i++)
		{
			try 
			{
				ret+=VertexClause.evaluate(bvm,problem.getClause(i));
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
		return ret;
	}
	
	public int getCoordinate(int i) 
	{
		return 0;
	}
	
	public double getDoubleCoordinate(int i) 
	{
		return bvm.getValue(BVMap.getBV(i));
	}

	@Override
	public void setCoordinate(int i, int n) 
	{
	}

	public void setDoubleCoordinate(int i, double x) 
	{
		bvm.setValue(BVMap.getBV(i), x);
	}

	public String toString()
	{
		String ret="$";
		for(int i=0;i<this.dimension();i++)
			ret+=this.getDoubleCoordinate(i)+",";
		return ret+"] "+this.evaluate();
	}
}
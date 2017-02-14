package positronic.satisfiability.solvers;

import org.sat4j.minisat.SolverFactory;
import org.sat4j.specs.ISolver;

public class MySolverFactory 
{
	public static ISolver newMiniSAT() 
	{
		return SolverFactory.newMiniSATHeap();
	}
}

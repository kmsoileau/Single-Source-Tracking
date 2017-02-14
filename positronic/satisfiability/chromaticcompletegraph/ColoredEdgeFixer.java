package positronic.satisfiability.chromaticcompletegraph;

import java.util.Vector;

import positronic.satisfiability.bitstring.BitStringEqualizer;
import positronic.satisfiability.bitstring.IBitString;
import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.Disjunction;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;

public class ColoredEdgeFixer extends Problem implements IProblem
{
	private static final long serialVersionUID = -8105853818390322559L;

	public ColoredEdgeFixer(ChromaticCompleteGraph ccg, 
			IBitString bs1, IBitString bs2, IBitString color) throws Exception
	{
		this(ccg.getEdges(), bs1, bs2, color);
	}
	
	public ColoredEdgeFixer(Vector<ColoredEdge> vce, 
			IBitString bs1, IBitString bs2, IBitString color) throws Exception
	{
		IProblem problem=null;
		
		for(ColoredEdge ce : vce)
		{
			IProblem ip1=new BitStringEqualizer(ce.firstpoint,bs1);
			IProblem ip2=new BitStringEqualizer(ce.secondpoint,bs2);
			IProblem ip3=new BitStringEqualizer(ce.color,color);
			
			IProblem ip=new Conjunction(
					ip1,
					ip2,
					ip3);
			problem=new Disjunction(problem,ip);
		}
		
		this.setClauses(problem.getClauses());
	}
}

package positronic.util.search.jiglet.demos.satisfiability;

import positronic.satisfiability.elements.IBooleanLiteral;


public class VertexBL 
{
	public static double evaluate(BVMap bvm,IBooleanLiteral bl)
	{
		double nm=bvm.getValue(bl.getBooleanVariable());
		if(!bl.isBarred())
			nm=1.-nm;
		return nm*nm; 
	}
}

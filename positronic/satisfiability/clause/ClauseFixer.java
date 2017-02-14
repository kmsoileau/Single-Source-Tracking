package positronic.satisfiability.clause;

import positronic.satisfiability.elements.IBooleanLiteral;
import positronic.satisfiability.elements.IClause;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;

//This class is under development and is not ready for use.
public class ClauseFixer extends Problem implements IProblem
{
	private static final long serialVersionUID = -3842912719908126130L;

	public ClauseFixer(IClause cl) throws Exception
	{
		for(int i=0;i<cl.size();i++)
		{
			IBooleanLiteral currBL=cl.getLiteralAt(i);
			if(currBL.isBarred())
			{
				
			}
		}
	}

}

package positronic.satisfiability.asdata.clause;

import positronic.satisfiability.elements.IBooleanVariable;
import positronic.satisfiability.elements.IClause;

public interface IClauseAsData 
{
	IBooleanVariable barredIndicator(IBooleanVariable bv) throws Exception;
	String getName();
	IBooleanVariable occurrenceIndicator(IBooleanVariable bv) throws Exception;
	IClause toClause() throws Exception;
	String toString();
}


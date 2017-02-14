package positronic.satisfiability.asdata.problem;

import java.util.ArrayList;

import positronic.satisfiability.asdata.clause.IClauseAsData;
import positronic.satisfiability.elements.IProblem;

public interface IProblemAsData 
{
	boolean addClause(IClauseAsData c);
	ArrayList<IClauseAsData> getClauses();
	IClauseAsData[] getClausesArray();
	boolean removeClause(IClauseAsData c);
	IClauseAsData removeClause(int index);
	IProblem toProblem() throws Exception;
}
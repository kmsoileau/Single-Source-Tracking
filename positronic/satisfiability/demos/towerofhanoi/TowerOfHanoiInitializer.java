package positronic.satisfiability.demos.towerofhanoi;

import positronic.satisfiability.elements.BooleanVariable;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;

public class TowerOfHanoiInitializer extends Problem implements IProblem
{
	private static final long serialVersionUID = 556029605876241215L;

	public TowerOfHanoiInitializer(final TowerOfHanoi tower) throws Exception
	{
		for(int i=0;i<tower.getNumberOfPegs();i++)
			for(int j=0;j<tower.getNumberOfDisks();j++)
				tower.setStateVariable(i,j,BooleanVariable.getBooleanVariable(tower.getName()+"$"+i+"$"+j,(i==0)?true:false));
		this.setClauses(new TowerOfHanoiFixer(tower).getClauses());
	}
}

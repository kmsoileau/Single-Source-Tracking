package positronic.satisfiability.demos.towerofhanoi;

import positronic.satisfiability.elements.BooleanVariable;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;

public class TowerOfHanoiFinalizer extends Problem implements IProblem
{
	private static final long serialVersionUID = 6485684030148882774L;

	public TowerOfHanoiFinalizer(final TowerOfHanoi tower) throws Exception
	{
		for(int i=0;i<tower.getNumberOfPegs();i++)
			for(int j=0;j<tower.getNumberOfDisks();j++)
				tower.setStateVariable(i,j,BooleanVariable.getBooleanVariable(tower.getName()+"$"+i+"$"+j,false));
		tower.getStateVariable(0,2).setValue(true);
		tower.getStateVariable(2,1).setValue(true);
		tower.getStateVariable(0,0).setValue(true);
		
		this.setClauses(new TowerOfHanoiFixer(tower).getClauses());
	}
}

package positronic.satisfiability.demos.towerofhanoi;

import positronic.satisfiability.elements.BitFixer;
import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;

public class TowerOfHanoiFixer extends Problem implements IProblem
{
	private static final long serialVersionUID = 8158481091806088872L;

	public TowerOfHanoiFixer(final TowerOfHanoi tower) throws Exception
	{
		final IProblem[] problems=new IProblem[tower.getNumberOfPegs()*tower.getNumberOfDisks()];
		int count=0;
		for(int i=0;i<tower.getNumberOfPegs();i++)
			for(int j=0;j<tower.getNumberOfDisks();j++)
				problems[count++]=new BitFixer(tower.getStateVariable(i,j));
		this.setClauses(new Conjunction(problems).getClauses());
	}
}


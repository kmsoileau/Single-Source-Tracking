package positronic.satisfiability.demos.towerofhanoi;

import positronic.satisfiability.elements.BitFixer;
import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;

public class DiskMover extends Problem implements IProblem
{
	private static final long serialVersionUID = 1635226052143552836L;

	public DiskMover(
			TowerOfHanoi pretransfer,
			TowerOfHanoi postransfer,
			int sourcepeg,
			int targetpeg, 
			int disk) throws Exception
	{
		this.setClauses(new Conjunction(
				new BitFixer(pretransfer.getStateVariable(sourcepeg,disk),
						true),
				new BitFixer(postransfer.getStateVariable(sourcepeg,disk),
						false),
				new BitFixer(pretransfer.getStateVariable(targetpeg,disk),
								false),
				new BitFixer(postransfer.getStateVariable(targetpeg,disk),
								true)
					).getClauses());
	}
}

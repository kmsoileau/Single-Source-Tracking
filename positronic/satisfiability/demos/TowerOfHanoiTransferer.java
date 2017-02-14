package positronic.satisfiability.demos;

import positronic.satisfiability.elements.BitEqualizer;
import positronic.satisfiability.elements.BitFixer;
import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;

public class TowerOfHanoiTransferer extends Problem implements IProblem
{
	private static final long serialVersionUID = 1L;

	public TowerOfHanoiTransferer(
			TowerOfHanoi pretransfer,
			TowerOfHanoi postransfer,
			int sourcepeg,
			int targetpeg,
			int lifted) throws Exception
	{
		IProblem problem=null;
		
		/**The move of disks:
		 * Qualify the move by verifying that pre-transfer, 
		 * all of the targetpeg bits lower than lifted are 0
		 */
		for(int i=0;i<lifted;i++)
			problem=new Conjunction(problem,
					new BitFixer(pretransfer.getStateVariable(targetpeg,i),false));
		
		//Add them to the targetpeg
		for(int i=0;i<lifted;i++)
		{
			problem=new Conjunction(problem,
					new BitEqualizer(postransfer.getStateVariable(targetpeg,i),
							pretransfer.getStateVariable(sourcepeg,i)));
		}
		for(int i=lifted;i<postransfer.getNumberOfDisks();i++)
		{
			problem=new Conjunction(problem,
					new BitEqualizer(postransfer.getStateVariable(targetpeg,i),
							pretransfer.getStateVariable(targetpeg,i)));
		}
		//Remove them from the sourcepeg
		for(int i=0;i<lifted;i++)
		{
			problem=new Conjunction(problem,
					new BitFixer(postransfer.getStateVariable(sourcepeg,i),
							false));
		}
		for(int i=lifted;i<postransfer.getNumberOfDisks();i++)
		{
			problem=new Conjunction(problem,
					new BitEqualizer(postransfer.getStateVariable(sourcepeg,i),
							pretransfer.getStateVariable(sourcepeg,i)));
		}
		//Add them to the targetpeg
		for(int i=0;i<lifted;i++)
		{
			problem=new Conjunction(problem,
					new BitEqualizer(pretransfer.getStateVariable(sourcepeg,i),
							postransfer.getStateVariable(targetpeg,i)));
		}
		for(int i=lifted;i<postransfer.getNumberOfDisks();i++)
		{
			problem=new Conjunction(problem,
					new BitEqualizer(pretransfer.getStateVariable(targetpeg,i),
							postransfer.getStateVariable(targetpeg,i)));
		}
		
		for(int peg=0;peg<pretransfer.getNumberOfPegs();peg++)
			if(peg!=sourcepeg && peg!=targetpeg)
				for(int i=0;i<pretransfer.getNumberOfDisks();i++)
				{
					problem=new Conjunction(problem,
							new BitEqualizer(pretransfer.getStateVariable(peg,i),
									postransfer.getStateVariable(peg,i)));
				}

		this.setClauses(problem.getClauses());
	}
}

class TowerOfHanoiTransfererException extends Exception
{
	private static final long serialVersionUID = 1L;

	public TowerOfHanoiTransfererException(String s)
	{
		super(s);
	}
}

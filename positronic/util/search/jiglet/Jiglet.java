package positronic.util.search.jiglet;

public abstract class Jiglet
{
	private int trials=1000;
	protected IVertex currentVertex;
	protected abstract boolean perTrial();
	protected abstract IVertex explore();
	protected abstract void init();
	
	protected IVertex jiggle(IVertex current)
	{
		IVertex tentative=explore();
		double a=tentative.evaluate();
		double b=current.evaluate();
		if(a<=b)
			return tentative;
		else
			return current;
	}
	
	protected void setTrials(int t)
	{
		this.trials=t;
	}
	
	protected void start()
	{
		this.init();
		for(int i=0;i<this.trials;i++)
		{
			currentVertex=jiggle(currentVertex);
			boolean res=perTrial();
			if(!res)
				break;
		}
		this.wrapup();
	}

	protected abstract void wrapup();
}

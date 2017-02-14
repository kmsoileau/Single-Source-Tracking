package positronic.util.search;

public abstract class Jiglet
{
	private int trials=10000000;
	protected abstract boolean doTrial(Jiglet j);
	protected abstract double evaluate();
	protected abstract void init(Jiglet j);
	
	public IVertex jiggle()
	{
		IVertex output=sample();
		if(output.evaluate()<=this.evaluate())
			return output;
		else
			return (IVertex) this;
	}
	
	protected abstract IVertex sample();
	
	public void setTrials(int t)
	{
		trials=t;
	}

	public void start(Jiglet j)
	{
		this.init(j);
		for(int i=0;i<trials;i++)
		{
			boolean ret=j.doTrial(j);
			if(!ret)break;
		}
	}
}

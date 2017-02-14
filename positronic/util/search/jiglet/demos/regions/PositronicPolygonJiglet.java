package positronic.util.search.jiglet.demos.regions;

import positronic.awt.geometry.PositronicPolygon;

public abstract class PositronicPolygonJiglet
{
	private int trials=1000;
	protected PositronicPolygon[] currentVertex;
	protected abstract PositronicPolygon[] explore();
	protected abstract void init();
	
	protected PositronicPolygon[] jiggle(PositronicPolygon[] current)
	{
		PositronicPolygon[] tentative=explore();
		if(RegionsPositronicPolygonArray.evaluate(tentative)<RegionsPositronicPolygonArray.evaluate(current))
			return tentative;
		else
			return current;
	}
	
	protected abstract boolean perTrial();
	
	protected void setTrials(int t)
	{
		this.trials=t;
	}
	
	protected void start()
	{
		this.init();
		for(int i=0;i<this.trials;i++)
		{
			//System.out.println("Before jiggle:\t"+this.currentVertex+"\t"+RegionsPositronicPolygonArray.evaluate(this.currentVertex));
			this.currentVertex=jiggle(this.currentVertex);
			//System.out.println("After jiggle:\t"+this.currentVertex+"\t"+RegionsPositronicPolygonArray.evaluate(this.currentVertex));
			
			boolean res=perTrial();
			if(!res)
				break;
		}
		this.wrapup();
	}

	protected abstract void wrapup();
}

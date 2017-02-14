package positronic.ai.randomwalk;

import java.util.ArrayList;

public class RandomWalker
{
	public ArrayList<IVertex> walk(IVertex start)
	{
		ArrayList<IVertex> ret=new ArrayList<IVertex>();
		IVertex current=start;
		ret.add(current);
		
		while(!current.endCondition())
		{
			current.moveToNeighbor();
			ret.add(current);
		}
		
		return ret;
	}
	
	public ArrayList<IVertex> walk(IVertex start, int length)
	{
		ArrayList<IVertex> ret=new ArrayList<IVertex>();
		IVertex current=start;
		ret.add(current.duplicate());
		
		for(int i=0;i<length;i++)
		{
			current.moveToNeighbor();
			ret.add(current.duplicate());
		}
		
		return ret;
	}
}

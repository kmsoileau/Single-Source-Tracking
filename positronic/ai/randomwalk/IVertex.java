package positronic.ai.randomwalk;

public interface IVertex
{
	IVertex duplicate();
	boolean endCondition();
	boolean equals(Object o);
	void moveToNeighbor();
}

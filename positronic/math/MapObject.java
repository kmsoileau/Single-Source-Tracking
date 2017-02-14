package positronic.math;

public class MapObject 
{
	MapObject nextObject;
	Object o;
	
	public MapObject(Object o)
	{
		this.o=o;
	}
	
	public void addNext(MapObject o)
	{
		this.nextObject=o;
	}
	
	public String println()
	{
		return (String)o.toString();
	}
}

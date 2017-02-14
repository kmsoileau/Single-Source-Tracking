package positronic.math;

import java.util.ArrayList;
import java.util.HashMap;

public class MappingSet extends ArrayList<Object> implements IMappingSet
{
	private static final long serialVersionUID = 1L;
	private HashMap<Object, Object> nextMap;

	public MappingSet()
	{
		super();
		nextMap=new HashMap<Object, Object>();
	}
	
	public MappingSet(Object[] oarray)
	{
		this();
		for(Object o:oarray)
			this.add(o);
	}
	
	public boolean add(Object o)
	{
		if(super.size()==0)
			nextMap.put(o,o);
		else
		{
			nextMap.put(getLast(),o);
			nextMap.put(o,getFirst());
		}
		return super.add(o);
	}
	
	public void add(Object[] oarray)
	{
		for(Object o:oarray)
			this.add(o);
	}
	
	public Object getFirst()
	{
		if(super.size()==0)
			return null;
		return super.get(0);
	}
	
	public Object getLast()
	{
		if(super.size()==0)
			return null;
		return super.get(super.size()-1);
	}
	
	public Object next(Object o)
	{
		if(o==null)
			return null;
		else
			return nextMap.get(o);
	}
}

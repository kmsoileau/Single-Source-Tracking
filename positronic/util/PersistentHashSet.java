package positronic.util;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class PersistentHashSet<E> implements Iterable<E>
{
	private HashMap<E, Boolean> backingHashMap;
	private static final Boolean ISMEMBER=new Boolean(true);
	private static final Boolean ISNOTMEMBER=new Boolean(false);

	public static void main(String[] args) throws Exception
	{
		PersistentArrayList<String> phs=new PersistentArrayList<String>(new String[]{"Kerry","John","Steve","Julie","Donna"});
		System.out.println(phs);
		Iterator<String> it=phs.iterator();
		while(it.hasNext())
		{
			String s=it.next();
			System.out.println(s);
			phs.remove(s);
		}
	}
	
	public PersistentHashSet()
	{
		this.setBackingHashMap(new HashMap<E, Boolean>());
	}
	
	public PersistentHashSet(E[] e)
	{
		this();
		for(E o : e)
			this.add(o);
	}
	
	public PersistentHashSet(List<E> l)
	{
		this();
		for(E o : l)
			this.add(o);
	}
	
	public PersistentHashSet(Set<E> hs)
	{
		this();
		for(E o : hs)
			this.add(o);
	}
	
	public boolean add(E e)
	{
		return(getBackingHashMap().put(e,ISMEMBER)!=null);
	}
	
	public boolean addAll(Collection<? extends E> c)
	{
		boolean ret=false;
		for(E o : c)
			if(!ret)
				ret=this.add(o);
		return ret;
	}
	
	/**
	 * Removes all members while retaining memory that they were
	 * once members.
	 */
	public void clear()
	{
		for(E o : history())
			this.remove(o);
	}
	
	public boolean contains(E o)
	{
		return(getBackingHashMap().containsKey(o) 
				&& getBackingHashMap().get(o));
	}
	
	public boolean containsAll(Collection<E> c)
	{
		for(E o : c)
			if(!this.contains(o))
				return false;
		return true;
	}

	public HashMap<E, Boolean> getBackingHashMap()
	{
		return backingHashMap;
	}

	public Set<E> history()
	{
		return (Set<E>) getBackingHashMap().keySet();
	}

	public boolean isEmpty()
	{
		return(this.size()==0);
	}

	/** 
	 * Returns the iterator on the keySet of the underlying
	 * HashMap, which will iterate over all objects which have
	 * been members up to date, including objects which have
	 * been removed. It does NOT iterate over the CURRENT
	 * members of the object.
	 */
	
	public Iterator<E> iterator()
	{
		return (Iterator<E>) history().iterator();
	}

	/**
	 * Deletes all memory of members which have previously been
	 * removed.
	 */
	public void prune()
	{
		for(E o : history())
			if(!this.contains(o))
				getBackingHashMap().remove(o);
	}

	public boolean remove(E o)
	{
		return getBackingHashMap().put(o,ISNOTMEMBER);
	}

	public boolean removeAll(Collection<E> c)
	{
		boolean ret=false;
		for(E o : c)
			if(!ret)
				ret=this.remove(o);
		return ret;
	}

	public boolean retainAll(Collection<E> c)
	{
		boolean ret=false;
		for(E o : c)
			if(!c.contains(o))
				ret=this.remove(o);
		return ret;
	}

	public void setBackingHashMap(HashMap<E, Boolean> backingHashMap)
	{
		this.backingHashMap = backingHashMap;
	}
	
	public int size()
	{
		int count=0;
		for(E o : history())
			if(this.contains(o))
				count++;
		return count;
	}

	public Object[] toArray()
	{
		Object[] ret=new Object[this.size()];
		int pos=0;
		for(E o : history())
			if(this.contains(o))
				ret[pos++]=o;
		return ret;
	}

	public String toString()
	{
		return this.getBackingHashMap().toString();
	}
}



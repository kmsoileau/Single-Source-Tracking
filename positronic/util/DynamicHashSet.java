package positronic.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class DynamicHashSet<E> implements Set<E>, Iterator<E>
{
	public static void main(String[] args)
	{
		DynamicHashSet<String> dhs=new DynamicHashSet<String>();
		for(int i=0;i<20;i++)
			if(Math.random()>.3)
				dhs.add("Kerry"+i);
			else
				dhs.remove("Kerry"+i);
		Collection<String> c=Arrays.asList(new String[]{"Kerryh","Julieh"});
		dhs.addAll(c);
		dhs.remove("Kerry13");
		dhs.remove("Kerry7");
		dhs.remove("Kerry0");
		System.out.println(dhs);
		System.out.println("\n");
		while(dhs.hasNext())
			System.out.println("-->"+dhs.next());
	}
	
	private HashMap<E,Boolean> backing;
	private static Boolean TRUE=new Boolean(true);
	private static Boolean FALSE=new Boolean(false);
	private Iterator<E> keySetIterator;
	private E theNext;
	private E lastReturned;
	
	public DynamicHashSet()
	{
		super();
		this.backing=new HashMap<E,Boolean>();
		this.keySetIterator=this.backing.keySet().iterator();
	}
	
	public boolean add(E arg0)
	{
		backing.put(arg0,TRUE);
		return true;
	}

	public boolean addAll(Collection<? extends E> arg0)
	{
		boolean ret=false;
		for(E e : arg0)
			if(this.add(e))
				ret=true;
		return ret;
	}

	public void clear()
	{
		for(E e : backing.keySet())
			this.remove(e);
	}
	
	public boolean contains(Object arg0)
	{
		return (backing.keySet().contains(arg0) && backing.get(arg0).booleanValue());
	}

	public boolean containsAll(Collection<?> arg0)
	{
		boolean ret=false;
		for(Object e : arg0)
			if(this.contains(e))
				ret=true;
		return ret;
	}

	public boolean hasNext()
	{
		if(!this.keySetIterator.hasNext())
			return false;
		theNext=this.keySetIterator.next();
		while(!this.contains(theNext))
		{
			if(!this.keySetIterator.hasNext())
				return false;
			theNext=this.keySetIterator.next();
		}
		return true;
	}

	public boolean isEmpty()
	{
		for(E e : backing.keySet())
			if(this.contains(e))
				return false;
		return true;
	}

	public Iterator<E> iterator()
	{
		return this;
	}

	public E next()
	{
		this.lastReturned=this.theNext;
		return this.theNext;
	}

	public void remove()
	{
		if(this.lastReturned!=null)
			this.remove(this.lastReturned);
	}

	@SuppressWarnings("unchecked")
	public boolean remove(Object arg0)
	{
		backing.put((E) arg0,FALSE);
		return true;
	}

	public boolean removeAll(Collection<?> arg0)
	{
		boolean ret=false;
		for(Object e : arg0)
			if(this.remove(e))
				ret=true;
		return ret;
	}

	public boolean retainAll(Collection<?> arg0)
	{
		boolean ret=false;
		for(E e : backing.keySet())
			if(!arg0.contains(e))
			{
				this.remove(e);
				ret=true;
			}
		return ret;
	}

	public int size()
	{
		int ret=0;
		for(E e : backing.keySet())
			if(this.contains(e))
				ret++;
		return ret;
	}

	public Object[] toArray()
	{
		ArrayList<E> a=new ArrayList<E>();
		for(E e : backing.keySet())
			if(this.contains(e))
				a.add((E) e);
		return a.toArray();
	}

	@SuppressWarnings("unchecked")
	public <T> T[] toArray(T[] arg0)
	{
		ArrayList<E> a=new ArrayList<E>();
		for(E e : backing.keySet())
			if(this.contains(e))
				a.add((E) e);
		return (T[]) a.toArray();
	}
	
	public String toString()
	{
		String ret="$";
		for(E o : this.backing.keySet())
			if(this.contains(o))
				ret+="<"+o+">\n";
		return ret+"$";
	}
}


/*package positronic.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class DynamicHashSet<Object> implements Set<Object>, Iterator
{
	public static void main(String[] args)
	{
		DynamicHashSet<String> dhs=new DynamicHashSet<String>();
		for(int i=0;i<100;i++)
			if(Math.random()>.3)
				dhs.add("Kerry"+i);
			else
				dhs.remove("Kerry"+i);
		System.out.println(dhs);
	}
	private HashMap<java.lang.Object,Boolean> backing;
	private static Boolean TRUE=new Boolean(true);
	private static Boolean FALSE=new Boolean(false);
	private Iterator<java.lang.Object> keySetIterator;
	private java.lang.Object theNext;
	
	private java.lang.Object lastReturned;
	
	public DynamicHashSet()
	{
		super();
		this.backing=new HashMap<java.lang.Object,Boolean>();
		this.keySetIterator=this.backing.keySet().iterator();
	}
	
	public boolean add(Object arg0)
	{
		backing.put(arg0,TRUE);
		return true;
	}

	public boolean addAll(Collection<? extends Object> arg0)
	{
		boolean ret=false;
		for(Object e : arg0)
			if(this.add(e))
				ret=true;
		return ret;
	}

	public void clear()
	{
		for(java.lang.Object e : backing.keySet())
			this.remove(e);
	}

	public boolean contains(java.lang.Object arg0)
	{
		return (backing.keySet().contains(arg0) && backing.get(arg0).booleanValue());
	}

	public boolean containsAll(Collection<?> arg0)
	{
		boolean ret=false;
		for(java.lang.Object e : arg0)
			if(this.contains(e))
				ret=true;
		return ret;
	}

	public boolean hasNext()
	{
		if(!this.keySetIterator.hasNext())
			return false;
		theNext=this.keySetIterator.next();
		while(!this.contains(theNext))
		{
			if(!this.keySetIterator.hasNext())
				return false;
			theNext=this.keySetIterator.next();
		}
		return true;
	}

	public boolean isEmpty()
	{
		for(java.lang.Object e : backing.keySet())
			if(this.contains(e))
				return false;
		return true;
	}

	public Iterator iterator()
	{
		return this;
	}

	public java.lang.Object next()
	{
		this.lastReturned=this.theNext;
		return this.theNext;
	}

	public void remove()
	{
		if(this.lastReturned!=null)
			this.remove(this.lastReturned);
	}

	public boolean remove(java.lang.Object arg0)
	{
		backing.put(arg0,FALSE);
		return true;
	}

	public boolean removeAll(Collection<?> arg0)
	{
		boolean ret=false;
		for(java.lang.Object e : arg0)
			if(this.remove(e))
				ret=true;
		return ret;
	}

	public boolean retainAll(Collection<?> arg0)
	{
		boolean ret=false;
		for(java.lang.Object e : backing.keySet())
			if(!arg0.contains(e))
			{
				this.remove(e);
				ret=true;
			}
		return ret;
	}

	public int size()
	{
		int ret=0;
		for(java.lang.Object e : backing.keySet())
			if(this.contains(e))
				ret++;
		return ret;
	}

	public java.lang.Object[] toArray()
	{
		ArrayList<Object> a=new ArrayList<Object>();
		for(java.lang.Object e : backing.keySet())
			if(this.contains(e))
				a.add((Object) e);
		return a.toArray();
	}

	public <T> T[] toArray(T[] arg0)
	{
		ArrayList<Object> a=new ArrayList<Object>();
		for(java.lang.Object e : backing.keySet())
			if(this.contains(e))
				a.add((Object) e);
		return (T[]) a.toArray();
	}
	
	public String toString()
	{
		String ret="$";
		for(java.lang.Object o : this.backing.keySet())
			if(this.contains(o))
				ret+="<"+o+">\n";
		return ret+"$";
	}
}
*/
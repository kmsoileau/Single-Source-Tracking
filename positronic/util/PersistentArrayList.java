package positronic.util;

import java.util.ArrayList;
import java.util.List;

public class PersistentArrayList<E> extends java.util.AbstractList<E> 
	implements java.util.List<E>, java.util.RandomAccess, java.lang.Cloneable, java.io.Serializable
{
	private static final long serialVersionUID = -4351352640125923245L;

	public static void main(String[] args) throws Exception
	{
		PersistentArrayList<String> pal=new PersistentArrayList<String>();
		for(int i=0;i<200;i++)
		{
			int v=(int) (Math.random()*100);
			if(Math.random()<.5)
				pal.add(String.valueOf(v));
			else
				pal.delete(String.valueOf(v));
		}
		System.out.println(pal);
	}
	
	private ArrayList<E> plusList;
	private ArrayList<E> minusList;
	private ArrayList<E> backingList;
	
	public PersistentArrayList()
	{
		this.plusList=new ArrayList<E>();
		this.minusList=new ArrayList<E>();
		this.backingList=new ArrayList<E>();
	}
	
	public PersistentArrayList(ArrayList<E> hs)
	{
		this();
		for(E o : hs)
			this.add(o);
	}
	
	public PersistentArrayList(E[] e)
	{
		this();
		for(E o : e)
			this.add(o);
	}
	
	public PersistentArrayList(List<E> l)
	{
		this();
		for(E o : l)
			this.add(o);
	}
	
	public boolean add(E obj)
	{
		ArrayList<E> ret=new ArrayList<E>();
		if(!this.plusList.contains(obj))
			this.plusList.add(obj);
		for(E e : this.plusList)
			if(!ret.contains(e) && !this.minusList.contains(e))
				ret.add(e);
		this.backingList.clear();
		return this.backingList.addAll(ret);
	}
	
	public void clear()
	{
		this.plusList.clear();
		this.minusList.clear();
		this.backingList.clear();
	}
	
	public boolean delete(E obj)
	{
		ArrayList<E> ret=new ArrayList<E>();
		if(!this.minusList.contains(obj))
			this.minusList.add(obj);
		for(E e : this.plusList)
			if(!ret.contains(e) && !this.minusList.contains(e))
				ret.add(e);
		this.backingList.clear();
		return this.backingList.addAll(ret);
	}
	
	public E get(int index) 
	{
		return (E)(this.backingList.get(index));
	}
	
	public boolean isEmpty()
	{
		return(this.size()==0);
	}

	public void prune()
	{
		this.plusList.clear();
		this.minusList.clear();
		this.plusList.addAll(this.backingList);
	}

	public int size()
	{
		return this.backingList.size();
	}

	public Object[] toArray()
	{
		return this.backingList.toArray();
	}

	public String toString()
	{
		return this.backingList.toString();
	}
}
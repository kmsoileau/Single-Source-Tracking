package positronic.util;

import java.util.Vector;

public class Rotary<E> extends Vector<E>
{
	private static final long serialVersionUID = -6399045925442664200L;

	public static void main(String[] args)
	{
		Rotary<String> r=new Rotary<String>();
		r.add("01");
		r.insertRight("01", "02");
		r.insertLeft("01", "03");
		r.insertLeft("01", "04");
		System.out.println(r.toString());
	}
	
	public boolean add(E addin)
	{
		return super.add(addin);
	}
	
	public void insertLeft(E existing,E addin)
	{
		if(super.size()==0)
			super.add(addin);
		else
			super.add(super.indexOf(existing),addin);
	}
	
	public void insertRight(E existing,E addin)
	{
		if(super.size()==0 || super.lastElement()==existing)
			super.add(addin);
		else
			super.add(super.indexOf(existing)+1,addin);
	}
	
	public int size()
	{
		return super.size();
	}
	
	public E toTheLeftOf(E element)
	{
		if(super.firstElement()==element)
			return super.lastElement();
		else
			return super.get(super.indexOf(element)-1);
	}
	
	public E toTheRightOf(E element)
	{
		if(super.lastElement()==element)
			return super.firstElement();
		else
			return super.get(super.indexOf(element)+1);
	}
}

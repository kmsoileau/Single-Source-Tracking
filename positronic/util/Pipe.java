package positronic.util;

import java.util.ArrayList;
import java.util.Collections;

public class Pipe<E> extends ArrayList<E>
{
	private static final long serialVersionUID = 6592567428668411935L;

	public static void main(String[] args)
	{
		Pipe<Integer> pipe=new Pipe<Integer>(30);
		for(Integer i=0;i<100;i++)
			System.out.println(">"+pipe.push(i));
		for(Integer i=0;i<pipe.capacity;i++)
			System.out.println("#"+pipe.get(i));
	}
	
	protected int capacity;
	
	public Pipe()
	{
		this(10);
	}
	
	public Pipe(int size)
	{
		super();
		this.capacity=size;
	}
	
	public E get(int n)
	{
		if(n<super.size())
			return super.get(n);
		return null;
	}
	
	public E push(E e)
	{
		super.add(e);
		if(super.size()<=this.capacity)
			return null;
		else
			return super.remove(0);
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<?> sortedList()
	{
		@SuppressWarnings("rawtypes")
		ArrayList srt=new ArrayList<E>(this);
		Collections.sort(srt);
		return srt;
	}
}

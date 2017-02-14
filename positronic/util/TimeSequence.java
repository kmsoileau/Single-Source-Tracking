package positronic.util;

import java.util.ArrayList;

import positronic.math.statistics.Percentile;

public class TimeSequence<E> extends Pipe<E>
{
	private static final long serialVersionUID = -6785196508916099267L;

	public static void main(String[] args)
	{
		TimeSequence<Double> pipe=new TimeSequence<Double>(300);
		for(int i=0;i<pipe.capacity;i++)
		{
			double y = Math.random();
			pipe.push(Math.sin(y*Math.PI));
		}
		for(int i=0;i<pipe.size();i++)
			System.out.println(pipe.get(i));
		ArrayList<?> lst = pipe.sortedList();
		for(Double x=0.;x<=1.01;x+=.01)
			System.out.println(x+"\t"+Percentile.eval(lst,x));
	}

	public TimeSequence() 
	{
		super();
	}

	public TimeSequence(int size) 
	{
		super(size);
	}
}

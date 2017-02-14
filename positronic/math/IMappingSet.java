package positronic.math;

public interface IMappingSet
{
	boolean add(Object o);
	void add(Object[] oarray);
	Object getFirst();
	Object getLast();
	Object next(Object o);
}
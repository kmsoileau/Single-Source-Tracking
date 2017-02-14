package positronic.math;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MappingIterator implements Iterator<Object>
{
	public static void main(String[] args)
	{
		Domain d=new Domain(new Object[]{"Kerry","John","Steve","Julie","Donna","Red","Green","Blue","Yellow"});
		Range r=new Range(new Object[]{"Kerry","John","Steve","Julie","Donna","Red","Green","Blue","Yellow"});
		MappingIterator m=new MappingIterator(d,r);

		while(m.hasNext())
			System.out.println(m.count + "\t"+ m.next());
		
		System.exit(0);
	}
	
	private long count;
	private Domain domain;
	private Map<Object,Object> f0;
	private boolean firstuse;
	private Map<Object,Object> fnew;
	private Map<Object,Object> fold;
	private long maxCount;
	private Range range;

	public MappingIterator(Domain domain, Range range)
	{
		super();
		this.domain=domain;
		this.range=range;
		f0=new HashMap<Object,Object>();
		for(int j=0;j<domain.size();j++)
		{
			System.out.println("Putting "+domain.get(j)+"--->"+range.getFirst());
			f0.put(domain.get(j),range.getFirst());
		}
		firstuse=true;
		maxCount=(long)Math.pow(this.range.size(),this.domain.size());
	}

	public boolean hasNext()
	{
		return count<maxCount;
	}

	public Object next()
	{
		this.count++;
		if(firstuse)
		{
			firstuse=false;
			fold=f0;
			return f0;
		}
		else
		{
			fnew=new HashMap<Object,Object>(fold);
			Object o=domain.getFirst();
			while(true)
			{
				Object q=range.next(fold.get(o));
				fnew.put(o,q);
				o=domain.next(o);
				if(!q.equals(range.getFirst()))
					break;
			}
			fold=fnew;
			return fnew;
		}
	}
	
	public void remove()
	{
	}
}

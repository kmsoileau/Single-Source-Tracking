package positronic.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class PartitionExperimental //implements Iterator
{
	private Object[] array;
	///private PowerSet ps;
	
	public ArrayList<Object> makePartition(Object[] array)
	{
		if(array==null||array.length==0)
			return null;
		if(array.length==1)
		{
			ArrayList<Object> ret=new ArrayList<Object>();
			ret.add(array[0]);
			return ret;
		}
		
    PowerSet ps=new PowerSet(array);
    ArrayList<Object> ret=new ArrayList<Object>();
    while(ps.hasNext())
    {
    	Object o=ps.next();
    	System.out.println("Working on subset "+o);
    	ArrayList<Object> build=new ArrayList<Object>();
    	System.out.println("Adding "+o+" to build");
    	build.add(o);
    	System.out.println("Build now equals "+build);
    	ArrayList<Object> l=new ArrayList<Object>(Arrays.asList(this.array));
    	System.out.println("Creating list "+l+"from array this.array");
    	System.out.println("Removing "+o+" from list l");
    	l.removeAll((Collection<?>)o);
    	System.out.println("l now equals "+l);
    	System.out.println("Recursively determine sub partition of "+l);
    	ArrayList<Object> r=makePartition(l.toArray());
    	if(r!=null)
    		build.addAll(r);
    	System.out.println("Build finally equals "+build);
    	ret.add(build);
    }
    return ret;
	}
	
	/*public Partition(Object[] array)
  {
		this.array=array;
		if(this.array!=null)
		{
			this.ret=new ArrayList<Object>();
	    this.ps=new PowerSet(this.array);
	    while(this.ps.hasNext())
	    {
	    	Object o=this.ps.next();
	    	System.out.println("Working on subset "+o);
	    	ArrayList<Object> build=new ArrayList<Object>();
	    	System.out.println("Adding "+o+" to build");
	    	build.add(o);
	    	System.out.println("Build now equals "+build);
	    	ArrayList<Object> l=new ArrayList<Object>(Arrays.asList(this.array));
	    	System.out.println("Creating list "+l+"from array this.array");
	    	System.out.println("Removing "+o+" from list l");
	    	l.removeAll((Collection<?>)o);
	    	System.out.println("l now equals "+l);
	    	System.out.println("Recursively determine sub partition of "+l);
	    	Partition r=new Partition(l.toArray());
	    	build.addAll(r.ret);
	    	System.out.println("Build finally equals "+build);
	    	this.ret.add(build);
	    }
		}
  }*/
	
	public PartitionExperimental(Object[] array)
  {
		this.array=array;
		this.makePartition(this.array);
  }

	public static void main(String[] args)
	{
		PartitionExperimental p=new PartitionExperimental(new Object[]{"1","2","3"});
		for(Object o:p.array)
			System.out.println(o);
	}

	public boolean hasNext()
	{
		// TODO Auto-generated method stub
		return false;
	}

	/*public Object next()
	{
		ArrayList<Object> headPartition=null;
		if(ps.hasNext())
			headPartition=ps.next();
		
		
		
		return null;
	}*/

	public void remove()
	{
		// TODO Auto-generated method stub
		
	}

}

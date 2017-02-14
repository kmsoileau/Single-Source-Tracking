package positronic.util.search.jiglet.demos.satisfiability;

import java.util.ArrayList;
import java.util.HashMap;

import positronic.satisfiability.elements.IBooleanVariable;

public class BVMap
{
	private HashMap<IBooleanVariable,Double> map;
	public static ArrayList<IBooleanVariable> backing;
	private static HashMap<IBooleanVariable,Integer> index;
	
	public static IBooleanVariable getBV(int n)
	{
		return backing.get(n);
	}
	
	public static double getIndex(IBooleanVariable bv)
	{
		return index.get(bv).intValue();
	}
	
	public double getValue(IBooleanVariable bv)
	{
		Double o = map.get(bv);
		return o.doubleValue();
	}
	
	public void setValue(IBooleanVariable bv, double x)
	{
		if(map==null)
		{
			map=new HashMap<IBooleanVariable,Double>();
		}
		map.put(bv, new Double(x));
		if(index==null)
		{
			index=new HashMap<IBooleanVariable,Integer>();
		}
		if(backing==null)
		{
			backing=new ArrayList<IBooleanVariable>();
		}
		int q=backing.indexOf(bv);
		index.put(bv,q);
	}
	
	public BVMap(ArrayList<IBooleanVariable> bvs)
	{
		
		for(int i=0;i<bvs.size();i++)
		{
			IBooleanVariable curr=bvs.get(i);
			setValue(curr, 0.);
		}
	}
}

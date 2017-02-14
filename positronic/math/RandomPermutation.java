package positronic.math;

import java.util.ArrayList;
import java.util.List;

import positronic.math.statistics.Random;

public class RandomPermutation extends ArrayList<Object>
{
	private static final long serialVersionUID = -1555427158231415914L;

	public static int award(int[][] preferences, int item)
	{
		int minrank=Integer.MAX_VALUE;
		ArrayList<Object> ret=new ArrayList<Object>();
		for(int person=0;person<preferences.length;person++)
			if(preferences[person][item]<minrank)
				minrank=preferences[person][item];
		for(int person=0;person<preferences.length;person++)
			if(preferences[person][item]==minrank)
				ret.add(person);
		if(ret.size()==1)
			return (Integer)ret.get(0);
		else
			return (Integer)Random.chooseOneRandomly(ret);
	}
	
	public static int[][] generatePreferences(int persons, int items)
	{
		int[][] p=new int[persons][items];
		for(int person=0;person<persons;person++)
		{
			p[person]=new int[items];
			RandomPermutation r=RandomPermutation.random(items);
			for(int item=0;item<r.size();item++)
				p[person][item]=(Integer)r.get(item);
		}
		return p;
	}
	
	//Returns the items whose rank is better than cut to person per
	public static ArrayList<Integer> itemsDesiredMore(int[][] preferences, int per, int cut)
	{
		int[] prefs=preferences[per];
		ArrayList<Integer> ret=new ArrayList<Integer>();
		for(int i=0;i<prefs.length;i++)
			if(prefs[i]<cut)
				ret.add(i);
		return ret;
	}
	
	public static void main(String[] args)
	{
		int persons=5;
		int items=10;
		int[][] p=generatePreferences(persons,items);
		
		for(int person=0;person<persons;person++)
			for(int cut=0;cut<items;cut++)
				System.out.println(person+"\t"+cut+"\t"+itemsDesiredMore(p, person, cut));
		
		System.out.print("\t");
		for(int item=0;item<items;item++)
			System.out.print("\t"+item);
		System.out.print("\n\t");
		for(int item=0;item<items;item++)
			System.out.print("\t$");
		for(int person=0;person<persons;person++)
		{
			System.out.print("\nPerson "+person);
			for(int item=0;item<items;item++)
				System.out.print("\t"+p[person][item]);
		}
		
		int[] assignments=new int[items];
		for(int item=0;item<items;item++)
			assignments[item]=award(p,item);
		
		System.out.print("\n");
		for(int item=0;item<items;item++)
			System.out.print("\nItem "+item+" goes to person "+assignments[item]);
		ArrayList<ArrayList<Integer>> awards=new ArrayList<ArrayList<Integer>>(persons);
		for(int person=0;person<persons;person++)
			awards.add(new ArrayList<Integer>());
		for(int item=0;item<items;item++)
			awards.get(assignments[item]).add(item);
		System.out.print("\n");
		for(int person=0;person<persons;person++)
			System.out.print("\nPerson "+person+" gets items "+awards.get(person));
		for(int per1=0;per1<persons;per1++)
			for(int per2=0;per2<persons;per2++)
				for(int item1 : awards.get(per1))
					for(int item2 : awards.get(per2))
						if(tradingOpportunity(p, per1, item1, per2, item2))
							System.out.println(item1+"\t"+item2);
		
		for(int i=0;i<100000000;i++)
		{
			String s=test(10,10);
			if(s.length()>0)
				System.out.println(s);
		}
	}
	
	public static String test(int persons, int items)
	{
		int[][] p=generatePreferences(persons,items);
		
		int[] assignments=new int[items];
		for(int item=0;item<items;item++)
			assignments[item]=award(p,item);
		
		ArrayList<ArrayList<Integer>> awards=new ArrayList<ArrayList<Integer>>(persons);
		for(int person=0;person<persons;person++)
			awards.add(new ArrayList<Integer>());
		for(int item=0;item<items;item++)
			awards.get(assignments[item]).add(item);
		for(int per1=0;per1<persons;per1++)
			for(int per2=0;per2<persons;per2++)
				for(int item1 : awards.get(per1))
					for(int item2 : awards.get(per2))
						if(tradingOpportunity(p, per1, item1, per2, item2))
							return(p+"\t"+item1+"\t"+item2);
		return "";
	}
	
	public static RandomPermutation random(int n)
	{
		List<Object> list=new ArrayList<Object>();
		for(int i=1;i<n+1;i++)
			list.add(i);
		return new RandomPermutation(list);
	}
	
	public static boolean tradingOpportunity(int[][] preferences, int per1, int item1, int per2, int item2)
	{
		//Stuff per1 wants more than item1
		ArrayList<Integer> q1=itemsDesiredMore(preferences, per1, preferences[per1][item1]);
		if(q1.contains(item2))
		{
			//Stuff per2 wants more than item2
			ArrayList<Integer> q2=itemsDesiredMore(preferences, per2, preferences[per2][item2]);
			if(q2.contains(item1))
				return true;
		}
		return false;
	}
	
	public RandomPermutation(List<Object> list)
	{
		int size=list.size();
		for(int i=0;i<size;i++)
		{
			Integer chosen=(Integer)Random.chooseOneRandomly(list);
			list.remove(chosen);
			super.add(chosen);
		}
	}
}

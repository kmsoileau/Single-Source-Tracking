package positronic.math;

import java.util.ArrayList;
import java.util.HashMap;

public class RandomPermutationDemo 
{
	public static void main(String[] args)
	{
		int numOfPairs=40;
		RandomPermutation[] h=new RandomPermutation[numOfPairs];
		RandomPermutation[] v=new RandomPermutation[numOfPairs];
		for(int i=0;i<numOfPairs;i++)
			h[i]=RandomPermutation.random(numOfPairs);
		for(int i=0;i<numOfPairs;i++)
			v[i]=RandomPermutation.random(numOfPairs);
		
		int[][] boys=new int[numOfPairs][numOfPairs];
		int[][] girls=new int[numOfPairs][numOfPairs];
		for(int i=0;i<numOfPairs;i++)
			for(int j=0;j<numOfPairs;j++)
				boys[i][j]=(Integer)h[i].get(j);
		for(int i=0;i<numOfPairs;i++)
			for(int j=0;j<numOfPairs;j++)
				girls[i][j]=(Integer)v[i].get(j);
		
		System.out.println("PREFERENCE MATRIX");
		for(int b=0;b<numOfPairs;b++)
		{
			for(int g=0;g<numOfPairs;g++)
				System.out.print(boys[b][g]+","+girls[g][b]+"\t");
			System.out.println();
		}
		System.out.println();
		
		System.out.println("STABLE PAIRINGS");
		ArrayList<RandomPairing> pairings=new ArrayList<RandomPairing>();
		for(int i=0;i<1000000000;i++)
		{
			RandomPairing rp=new RandomPairing(numOfPairs);
			boolean b=stableAssignment(boys,girls,rp);
			if(b)
				if(!pairings.contains(rp))
					pairings.add(rp);
		}
		for(RandomPairing p : pairings)
			System.out.println(p);
	}
	
	public static boolean stableAssignment(int[][] boys,int[][] girls,RandomPairing a)
	{	
		HashMap<Integer, Integer> abh = a.boys;
		for(Integer b1 : abh.keySet())
		{
			Integer g1=abh.get(b1);	//g1 is married to b1
			HashMap<Integer, Integer> agh = a.girls;
			for(Integer g2 : agh.keySet())
			{
				Integer b2=agh.get(g2);	//g2 is married to b2
				//If b1 prefers g2 to g1 and g2 prefers b1 to b2 then return false
				if(boys[b1-1][g2-1]<boys[b1-1][g1-1])
					if(girls[b1-1][g2-1]<girls[b2-1][g2-1])
						return false;
			}
		}
		return true;
	}
}

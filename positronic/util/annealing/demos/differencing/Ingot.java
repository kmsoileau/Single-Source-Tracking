package positronic.util.annealing.demos.differencing;

import java.util.Arrays;

import positronic.math.Expressible;
import positronic.util.ArrayListSet;
import positronic.util.annealing.IIngot;

//54: 1 20 24 99 101 129 137 164 248 255 256 267 280 290 291 293 296 300 301 308 314 317 322 324 332 340 346 350 356 364 371 380 389 403 413 418 422 433 435 443 464 497 528 538 547 592 606 608 609 611 615 646 651 707

//Low solutions for least max angle
//117 99 42 103 63 73 123
//21 44 62 39 94 82 87 85
//2 18 39 54 71 90 109 123 143
//1 20 40 67 74 88 111 128 132 152
//12 29 62 52 121 89 114 148 127 160 161
//18 39 19 35 83 86 58 136 186 151 175 187

//3,57,83,85,92,96,98
//24,35,45,65,82,85,87,88
//2,16,38,50,78,85,86,87,88

public class Ingot implements IIngot
{	
	public ArrayListSet<Long> values;
	private static final long BASES=7;
	
	public Ingot()
	{
		values=new ArrayListSet<Long>();
		for(long i=0;i<BASES;i++)
			values.add(new Long(360*i/20));
	}
	
	//Copy the contents of incumbent into this.
	public void copy(IIngot incumbent)
	{
		for(int i=0;i<BASES;i++)
			this.values.set(i,((Ingot)incumbent).values.get(i));
	}
	
	public double evaluate()
	{
		double score=0d;
		ArrayListSet<?> pass=new ArrayListSet<Object>();
		long maxvalue=Long.MIN_VALUE;
		for(int i=0;i<this.values.size();i++)
			if(this.values.get(i) instanceof Long)
				pass.add(new Long(((Long)(this.values.get(i))).intValue()));
			else
				pass.addO(this.values.get(i));
		for(int i=0;i<pass.size();i++)
			maxvalue=Math.max(maxvalue,((Long)pass.get(i)));
		
		@SuppressWarnings("unchecked")
		ArrayListSet<?> expressible=Expressible.expressibleList((ArrayListSet<Long>) pass);
		Long[] sortarray=(Long[])expressible.toArray(new Long[0]);
		Arrays.sort(sortarray);
		ArrayListSet<?> dum=new ArrayListSet<Object>();
		/*for(long i=0;i<pass.size();i++)
			System.out.print(pass.get(i)+",");*/
		for(int i=0;i<sortarray.length;i++)
			if(sortarray[i]>0 && sortarray[i]<=360)
				dum.add(new Long(sortarray[i]));
		//System.out.println("base set of "+pass+" produces expressible set "+dum);
		long hits=0;
		for(long n=1;n<=360;n++)
			if(expressible.contains(new Long(n)))
				hits++;
		score=-hits*1000.+1.*maxvalue;
		System.out.print("-$"+hits);
		return score;
	}
	
	public void mutate()
	{
		for(int n=0;n<BASES;n++)
		{
			if(values.get(n) instanceof Long)
				values.set(n, Math.max(1,((Long)values.get(n)).intValue()+Math.round(4d*Math.random()-2d)));
			else
				values.set(n, Math.max(1,((Long)values.get(n)).intValue()+Math.round(4d*Math.random()-2d)));
		}
	}

	public void show()
	{
		for(int i=0;i<BASES;i++)
			if(values.get(i) instanceof Long)
				System.out.print((Long)values.get(i)+" ");
			else
				System.out.print((Long)values.get(i)+" ");
	}
}




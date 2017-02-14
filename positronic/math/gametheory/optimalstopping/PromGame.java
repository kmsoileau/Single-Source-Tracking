package positronic.math.gametheory.optimalstopping;

import java.util.ArrayList;

public class PromGame
{
	public static PromGame generateRandomGame(int numberBoys)
	{
		PromGame pg=new PromGame(new ArrayList<Boy>());

		for(int i=0;i<numberBoys;i++)
		{
			Boy bb=new Boy("Boy"+(i+1),PromGame.rand(),PromGame.rand());
			pg.boys.add(bb);
		}
		pg.normalizeGame();
		//pg.sort();
		return pg;
	}

	public static void main(String[] args)
	{
		ArrayList<Boy> theBoys=new ArrayList<Boy>();
		theBoys.add(new Boy("Al  ",.66,.83));
		theBoys.add(new Boy("Ben ",.87,.27));
		theBoys.add(new Boy("Carl",.88,.56));
		theBoys.add(new Boy("Don ",1.,.85));

		PromGame game=new PromGame(theBoys);
		ArrayList<Double> parray=PromGame.probabilityArray(game.boys);
		double of=PromGame.occursFirst(parray,0);


		//fprintf(stderr,"\r-----------%s",[game toString].UTF8String);

		//Tally *t=[[Tally new] initWithDetails:[game boys]];

		int count=0;
		int trials=0;
		while(++count<1000)
		{
			ArrayList<Boy> a=theBoys;
			while(a==null || a.size()==1)
				a=theBoys;
			Boy firstasker=a.get(0);
			Boy secondasker=a.get(1);

			if(firstasker==theBoys.get(2)
					&&
					secondasker ==theBoys.get(0))
			{
				//fprintf(stderr,"\r%i\tBoy %s asked first.",count,firstasker.identifier.UTF8String);
				for(int i=1;i<a.size();i++)
				{
					Boy b=a.get(i);
					System.out.println(b.toString());
				}
				trials++;
			}
		}
	}

	public static ArrayList<Integer> multiIndex(ArrayList<Integer> l)
	{
		ArrayList<Integer> ret=new ArrayList<Integer>();
		for(int i=0;i<l.size();i++)
			if(((Integer)l.get(i)).intValue()==1)
				ret.add(new Integer(i));
		return ret;
	}

	//Assuming events e1, e2, e3, ... have probabilities of occurrence p[0], p[1], p[2], ...
	//and if occurring, will occur in no particular order, this method returns the probability
	//that event e1 occurs first.
	//The array p contains objects of type NSNumber.
	public static double occursFirst(ArrayList<Double> p)
	{
		int boys=p.size();
		double tot=0.;
		for(int n=1;n<pow(2.,boys*1.);n+=2)
		{
			IntegerDigits ig=new IntegerDigits(n,2,boys);
			ArrayList<Integer> mi=PromGame.multiIndex(ig.list);

			if(mi!=null && mi.size()>0)
			{
				int mc=mi.size();
				double prod=1.;
				for(int i=0;i<mc;i++)
				{
					int index=((Integer)mi.get(i)).intValue();
					prod*=((Double)p.get(index)).doubleValue();
				}
				tot+=prod/mc*pow(-1.,mc+1);
			}
		}
		return tot;
	}

	//Assuming events e1, e2, e3, ... have probabilities of occurrence p[0], p[1], p[2], ...
	//and if occurring, will occur in no particular order, this method returns the probability
	//that event e occurs first.
	//The array p contains objects of type NSNumber.
	public static double occursFirst(ArrayList<Double> p,int e)
	{
		if(e==0)
			return PromGame.occursFirst(p);
		@SuppressWarnings("unchecked")
		ArrayList<Double> dup=(ArrayList<Double>) p.clone();
		Double a=dup.get(0);
		dup.set(0, dup.get(e));
		dup.set(e, a);
		return PromGame.occursFirst(dup);
	}

	private static double pow(double d, double e) 
	{
		return Math.pow(d,e);
	}

	public static ArrayList<Double> probabilityArray(ArrayList<Boy> boys)
	{
		ArrayList<Double> probs=new ArrayList<Double>();
		for(int i=0;i<boys.size();i++)
		{
			Boy currBoy=(Boy) boys.get(i);
			Double n=new Double(currBoy.p);
			probs.add(n);
		}
		return probs;
	}

	public static double rand()
	{
		return Math.random();
	}

	private ArrayList<Boy> boys;

	public PromGame(ArrayList<Boy> bys)
	{
		this.boys=bys;
	}

	public PromGame bayesianUpdate(Boy boyWhoAskedFirst)
	{
		PromGame ret=new PromGame(new ArrayList<Boy>());

		for(Object bo : this.boys)
		{
			Boy b=(Boy)bo;
			if(b!=boyWhoAskedFirst)
			{
				Boy bb=new Boy(b.identifier,b.x,this.bayesianUpdate(b,boyWhoAskedFirst));
				ret.boys.add(bb);
			}
		}
		return ret;
	}

	public double bayesianUpdate(Boy boyToBeUpdated,Boy boyWhoAskedFirst)
	{
		int k=this.getIndex(boyWhoAskedFirst);
		int j=this.getIndex(boyToBeUpdated);
		double pj=boyToBeUpdated.p;

		ArrayList<Double> probs=PromGame.probabilityArray(this.boys);
		double den=PromGame.occursFirst(probs,k);
		probs.set(j, new Double(1.));
		double num=PromGame.occursFirst(probs,k);
		return num/den*pj;
	}

	public int getIndex(Boy b)
	{
		for(int i=0;i<this.boys.size();i++)
		{
			Boy curr=(Boy) this.boys.get(i);
			if(curr.equals(b))
				return i;
		}
		return -1;
	}

	public void normalizeGame()
	{
		double maxx=Double.NEGATIVE_INFINITY;
		int numberBoys=boys.size();
		for(int i=0;i<numberBoys;i++)
		{

			Object bo=this.boys.get(i);
			Boy b=(Boy)bo;
			if(b.x>maxx)
				maxx=b.x;
		}
		for(int i=0;i<numberBoys;i++)
		{
			Boy b=(Boy) boys.get(i);
			b.x/=maxx;
		}
	}
}
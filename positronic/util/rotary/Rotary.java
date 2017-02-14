package positronic.util.rotary;

import java.util.Vector;

public class Rotary<E>
{
	public static void main(String[] args) 
	{
		String[] knights={
			"King Bagdemagus",
			"King Hoel",
			"King Leodegrance",
			"King Pellinore",
			"King Uriens",
			"Sir Aglovale",
			"Sir Agravaine",
			"Sir Bedivere",
			"Sir Bors",
			"Sir Breunor",
			"Sir Cador",
			"Sir Caradoc",
			"Sir Colgrevance",
			"Sir Constantine",
			"Sir Dagonet",
			"Sir Daniel",
			"Sir Dinadan",
			"Sir Ector",
			"Sir Ector de Maris",
			"Sir Elyan the White",
			"Sir Erec",
			"Sir Gaheris",
			"Sir Galahad",
			"Sir Galehaut",
			"Sir Galeschin",
			"Sir Gareth",
			"Sir Gawain",
			"Sir Geraint",
			"Sir Gingalain",
			"Sir Griflet",
			"Sir Kay",
			"Sir Lamorak",
			"Sir Lancelot",
			"Sir Lionel",
			"Sir Lucan",
			"Sir Maleagant",
			"Sir Meliant de Lis",
			"Sir Mordred",
			"Sir Morholt",
			"Sir Palamedes the Saracen",
			"Sir Pelleas",
			"Sir Percival",
			"Sir Safir",
			"Sir Sagramore le Desirous",
			"Sir Segwarides",
			"Sir Tor",
			"Sir Tristram",
			"Sir Ywain",
			"Sir Ywain the Bastard"};
		
		Rotary<String> r=new Rotary<String>();
		for(String knight : knights)
			r.addAt(null, knight);
		
		System.out.println(r);
		Rotary<String> p=r.reverse();
		System.out.println(p);
		System.out.println("Distance from Sir Kay to Sir Dinadan is "+r.distance("Sir Kay","Sir Dinadan"));
		System.out.println("Distance from King Uriens to Sir Bors is "+r.distance("King Uriens","Sir Bors"));
		System.out.println("Distance from Sir Daniel to Sir Bors is "+r.distance("Sir Daniel","Sir Bors"));
		System.out.println("Distance from Sir Daniel to King Uriens is "+r.distance("Sir Daniel","King Uriens"));
		System.out.println("Distance from Sir Daniel to Sir Daniel is "+r.distance("Sir Daniel","Sir Daniel"));
		System.out.println("Distance from King Uriens to Sir Cador is "+r.distance("King Uriens","Sir Cador"));
		System.out.println("Distance from Sir Cador to King Uriens is "+r.distance("Sir Cador","King Uriens"));
		
		r.swap("King Uriens", "Sir Daniel");
		System.out.println(r);
	}
	
	private Vector<E> backing;
	
	public Rotary()
	{
		this.backing=new Vector<E>();
	}
	
	public void addAt(E position, E added)
	{
		int index=this.backing.indexOf(position);
		if(index==-1)
			this.backing.add(added);
		else
			this.backing.add(index,added);
	}
	
	public void clear()
	{
		this.backing.clear();
	}
	
	public boolean contains(E e)
	{
		return this.backing.contains(e);
	}

	public int distance(E one, E other)
	{
		int posone=this.backing.indexOf(one);
		if(posone==-1)
			return Integer.MIN_VALUE;
		int posother=this.backing.indexOf(other);
		if(posother==-1)
			return Integer.MIN_VALUE;
		int dist=posother-posone;
		if(dist<0)
			dist+=this.size();
		return dist;
	}
	
	public boolean equals(Object other)
	{
		if(!(other instanceof Rotary<?>))
			return false;
		@SuppressWarnings("unchecked")
		Rotary<E> rect=(Rotary<E>)other;
		if(this.size()!=rect.size())
			return false;
		E chk1=this.backing.firstElement();
		for(E e : this.backing)
			if(this.distance(chk1,e)!=rect.distance(chk1,e))
				return false;
		return true;
	}
	
	public boolean isEmpty()
	{
		return this.backing.isEmpty();
	}
	
	public boolean remove(E removed)
	{
		if(this.size()==0)
			return false;
		return this.backing.remove(removed);
	}
	
	public Rotary<E> reverse()
	{
		Rotary<E> ret=new Rotary<E>();
		E previous=null;
		for(E e : this.backing)
		{
			ret.addAt(previous, e);
			previous=e;
		}
		return ret;
	}
	
	public int size()
	{
		return this.backing.size();
	}
	
	public boolean swap(E one, E other)
	{
		int indone=this.backing.indexOf(one);
		if(indone==-1)
			return false;
		int indother=this.backing.indexOf(other);
		if(indother==-1)
			return false;
		this.backing.set(indone,other);
		this.backing.set(indother,one);
		return true;
	}
	
	public String toString()
	{
		String ret="[> ";
		for(E s : this.backing)
			ret+=s+"\n > ";
		return ret+"$";
	}
}

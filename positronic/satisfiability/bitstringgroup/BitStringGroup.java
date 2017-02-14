package positronic.satisfiability.bitstringgroup;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import positronic.satisfiability.bitstring.BitString;
import positronic.satisfiability.bitstring.BitStringPair;
import positronic.satisfiability.bitstring.IBitString;
import positronic.satisfiability.bitstringlist.BitStringList;
import positronic.satisfiability.bitstringlist.IBitStringList;

public class BitStringGroup implements IBitStringGroup
{
	public static void main(String[] args) throws Exception
	{
		IBitStringList X=new BitStringList("X",
				new IBitString[]
      	  {
      	    new BitString("00"),
      	    new BitString("01"),
      	    new BitString("10"),
      	    new BitString("11")
      	  });
		IBitStringGroup group=new BitStringGroup(X);
		group.addRule(X.getBitString(0),X.getBitString(0),X.getBitString(0));
		group.addRule(X.getBitString(0),X.getBitString(1),X.getBitString(1));
		group.addRule(X.getBitString(0),X.getBitString(2),X.getBitString(2));
		group.addRule(X.getBitString(0),X.getBitString(3),X.getBitString(3));
		group.addRule(X.getBitString(1),X.getBitString(0),X.getBitString(1));
		group.addRule(X.getBitString(1),X.getBitString(1),X.getBitString(2));
		group.addRule(X.getBitString(1),X.getBitString(2),X.getBitString(3));
		group.addRule(X.getBitString(1),X.getBitString(3),X.getBitString(0));
		group.addRule(X.getBitString(2),X.getBitString(0),X.getBitString(2));
		group.addRule(X.getBitString(2),X.getBitString(1),X.getBitString(3));
		group.addRule(X.getBitString(2),X.getBitString(2),X.getBitString(0));
		group.addRule(X.getBitString(2),X.getBitString(3),X.getBitString(1));
		group.addRule(X.getBitString(3),X.getBitString(0),X.getBitString(3));
		group.addRule(X.getBitString(3),X.getBitString(1),X.getBitString(0));
		group.addRule(X.getBitString(3),X.getBitString(2),X.getBitString(1));
		group.addRule(X.getBitString(3),X.getBitString(3),X.getBitString(2));
		System.out.println(group);
	}
	
	private HashMap<BitStringPair, IBitString> bsg=new HashMap<BitStringPair, IBitString>();
	
	private String name;
	
	public BitStringGroup(IBitStringGroup X)
	{
		this.setName(X.getName());
		this.getMap().putAll(((BitStringGroup)X).getMap());
	}
	
	public BitStringGroup(IBitStringList X) throws Exception
	{
		for(int i=0;i<X.size();i++)
		{
			IBitString left=X.getBitString(i);
			for(int j=0;j<X.size();j++)
			{
				IBitString right=X.getBitString(j);
				BitStringPair bsp=new BitStringPair(left,right);
				bsg.put(bsp,null);
			}
		}
	}
	
	public void addRule(IBitString a,IBitString b,IBitString c)
	{
		BitStringPair bsp=new BitStringPair(a,b);
		Set<BitStringPair> keyset=this.bsg.keySet();
		Iterator<BitStringPair> it=keyset.iterator();
		while(it.hasNext())
		{
			BitStringPair currbsp=(BitStringPair)it.next();
			if(bsp.equals(currbsp))
			{
				this.bsg.remove(currbsp);
				this.bsg.put(bsp,c);
				break;
			}
		}
	}

	public Map<BitStringPair, IBitString> getMap()
	{
		return bsg;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String toString()
  {
		Iterator<BitStringPair> it=bsg.keySet().iterator();
    String res="{";
    while(it.hasNext())
    {
	    BitStringPair curr=(BitStringPair)it.next();
	    res+="{";
	    res+=curr.getLeft();
	    res+=" * ";
	    res+=curr.getRight();
	    res+=" = ";
	    res+=bsg.get(curr);
	    if(it.hasNext())
	    	res+="},\n";
	    else
	    	res+="}}\n";
    }
    return res;
  }
}

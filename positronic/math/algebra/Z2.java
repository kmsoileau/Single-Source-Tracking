package positronic.math.algebra;

import java.util.HashMap;
import java.util.HashSet;

import positronic.math.algebra.core.IMagmaElement;
import positronic.math.algebra.core.Magma;

public class Z2 implements IMagmaElement
{
	public static void main(String[] args)
	{
		Magma m=new Magma();
		IMagmaElement a0=new Z2("0");
		IMagmaElement a1=new Z2("1");
		IMagmaElement a2=new Z2("2");
		m.define(a0, a0, a0);
		m.define(a0, a1, a1);
		m.define(a0, a2, a2);
		m.define(a1, a0, a1);
		m.define(a1, a1, a2);
		m.define(a1, a2, a0);
		m.define(a2, a0, a2);
		m.define(a2, a1, a0);
		m.define(a2, a2, a1);
		
		for(IMagmaElement ge : m.keySet())
		{
			HashMap<IMagmaElement,IMagmaElement> curr=m.get(ge);
			for(IMagmaElement he : curr.keySet())
				System.out.println(ge+"+"+he+"="+curr.get(he));
		}
		
		HashSet<IMagmaElement> work1=new HashSet<IMagmaElement>();
		HashSet<IMagmaElement> work2=new HashSet<IMagmaElement>();
		work1.add(a1);
		
		work2.add(a2);
		work2.add(a1);
		System.out.println(m.evaluate(work1, work2));
	}
	
	private String basis;
	
	public Z2(String s)
	{
		this.basis=s;
	}

	public int compareTo(IMagmaElement o)
	{
		return basis.compareTo(o.toString());
	}

	public String getBasis()
	{
		return basis;
	}
	
	public void setBasis(String basis)
	{
		this.basis = basis;
	}

	public String toString()
	{
		return this.basis;
	}
}
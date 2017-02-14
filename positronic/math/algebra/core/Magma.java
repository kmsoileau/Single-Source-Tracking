package positronic.math.algebra.core;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Magma extends HashMap<IMagmaElement,HashMap<IMagmaElement,IMagmaElement>>
{
	private static final long serialVersionUID = 4760531872772442419L;

	public void define(IMagmaElement a, IMagmaElement b, IMagmaElement c)
	{
		if(super.get(a)==null)
			this.put(a,new HashMap<IMagmaElement,IMagmaElement>());
		super.get(a).put(b,c);
	}
	
	public IMagmaElement evaluate(IMagmaElement a, IMagmaElement b)
	{
		return this.get(a).get(b);
	}
	
	public Set<IMagmaElement> evaluate(Set<IMagmaElement> A, Set<IMagmaElement> B)
	{
		Set<IMagmaElement> ret=new HashSet<IMagmaElement>();
		for(IMagmaElement a : A)
			for(IMagmaElement b : B)
				ret.add(evaluate(a, b));
		
		return ret;
	}
}
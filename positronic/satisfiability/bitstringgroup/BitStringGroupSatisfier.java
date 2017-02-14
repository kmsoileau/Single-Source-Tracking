package positronic.satisfiability.bitstringgroup;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import positronic.satisfiability.bitstring.BitString;
import positronic.satisfiability.bitstring.BitStringEqualizer;
import positronic.satisfiability.bitstring.BitStringFixer;
import positronic.satisfiability.bitstring.BitStringPair;
import positronic.satisfiability.bitstring.IBitString;
import positronic.satisfiability.bitstringlist.BitStringList;
import positronic.satisfiability.bitstringlist.BitStringListFixer;
import positronic.satisfiability.bitstringlist.IBitStringList;
import positronic.satisfiability.elements.BooleanLiteral;
import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.Disjunction;
import positronic.satisfiability.elements.IBooleanLiteral;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;

public class BitStringGroupSatisfier extends Problem implements IProblem
{
	private static final long serialVersionUID = -5612835439986620608L;

	public static void main(String[] args) throws Exception
	{
		IBitString E00=new BitString("00");
		IBitString E01=new BitString("01");
		IBitString E10=new BitString("10");
		IBitString E11=new BitString("11");
		
		IBitStringList X=new BitStringList("X",
				new IBitString[]
      	  {
						E00,
						E01,
						E10,
						E11
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

		BitStringGroupSatisfier bsgs=new BitStringGroupSatisfier(group,
				E10,E10,E11);
		
		IProblem p=new Conjunction(
				new BitStringListFixer(X),
				bsgs);
    System.out.println(p);
    List<IBooleanLiteral> s=p.findModel(Problem.defaultSolver());
		if(s!=null && s.size()>0)
    {
      BooleanLiteral.interpret(s);
    	System.out.println("X= "+X);
    }
    else
      System.out.println("No solution.");
	}

	public BitStringGroupSatisfier(IBitStringGroup g,IBitString a,IBitString b,IBitString c) throws Exception
	{
		Set<BitStringPair> keyset=((BitStringGroup)g).getMap().keySet();
		Iterator<BitStringPair> it=keyset.iterator();
		while(it.hasNext())
		{
			BitStringPair bsp=(BitStringPair)it.next();
			IBitString left=bsp.getLeft();
			IBitString right=bsp.getRight();
			IBitString lookedup=(IBitString)(((BitStringGroup)g).getMap().get(bsp));
			IProblem newRule=new Conjunction(
					new Conjunction(
					new BitStringFixer(left),
					new BitStringFixer(right),
					new BitStringFixer(lookedup)
					),
					new Conjunction(
					new BitStringEqualizer(a,left),
					new BitStringEqualizer(b,right),
					new BitStringEqualizer(c,lookedup))
					);
			if(this.isEmpty())
				this.setClauses(newRule.getClauses());
			else
				this.setClauses(new Disjunction(this,newRule).getClauses());
		}
	}
}

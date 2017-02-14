package positronic.satisfiability.demos;

import positronic.satisfiability.bitstring.BitString;
import positronic.satisfiability.bitstring.IBitString;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.SeveralKeysWithLikeEntryChooser;
import positronic.satisfiability.naturalnumber.INaturalNumber;
import positronic.satisfiability.naturalnumber.NaturalNumber;

public class MapperDemo4
{
	public static void main(String[] args) throws Exception
	{
		int[] supply=new int[]{31,28,31,30,31,30,31,31,30,31,30,31};
		int bitsrequired=(int)(Math.ceil(Math.log(1d*supply.length)/Math.log(2d)));
	
		IBitString[] key=new IBitString[]{
				new BitString("x1",bitsrequired),
				new BitString("x2",bitsrequired),
				new BitString("x3",bitsrequired)};
	    	INaturalNumber supplyEntry=new NaturalNumber("y");
	    	
    IProblem problem=new SeveralKeysWithLikeEntryChooser(supply,key,supplyEntry);
	    
    /*List<IBooleanLiteral> s=problem.findModel(Problem.defaultSolver());
		if(s!=null && s.size()>0)
    {
			BooleanLiteral.interpret(s);
    	System.out.println("key[0]= "+key[0].toBits());
    	System.out.println("key[1]= "+key[1].toBits());
    	System.out.println("key[2]= "+key[2].toBits());
    	System.out.println("entry= "+supplyEntry);
    }
    else
	  	System.out.println("No solution.");*/
	  	
	  	String code=problem.toCode();
    System.out.println(code);
	}
	
	
}
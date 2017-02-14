package positronic.satisfiability.demos.bitstringgraph;

import positronic.satisfiability.bitstring.BitString;
import positronic.satisfiability.bitstring.IBitString;
import positronic.satisfiability.bitstringgraph.BitStringDigraphConnector;
import positronic.satisfiability.bitstringgraph.BitStringGraph;
import positronic.satisfiability.bitstringgraph.IBitStringGraph;

public class BitStringDigraphConnectorDemo
{
	public static void main(String[] args) throws Exception
	{
    	IBitStringGraph s1=new BitStringGraph("Kerry",4);
    	System.out.println("s1.getName() = "+s1.getName());

    	/*s1.addPair(new BitString(3), new BitString(3));
    	s1.addPair(new BitString(3), new BitString(3));
    	s1.addPair(new BitString(3), new BitString(3));
    	s1.addPair(new BitString(3), new BitString(3));*/
    
    	System.out.println(s1);
    
    	IBitString A=new BitString("in1",3);
    	IBitString B=new BitString("out1",3);
    	BitStringDigraphConnector bsdc=new BitStringDigraphConnector(s1,A,B);
    	System.out.println(bsdc);
	}
}
package positronic.satisfiability.demos.bitstring;

import java.util.ArrayList;

import positronic.satisfiability.bitstring.BitString;
import positronic.satisfiability.bitstring.BitStringFixer;
import positronic.satisfiability.bitstring.IBitString;
import positronic.satisfiability.bitstringgraph.BitStringDigraphConnector;
import positronic.satisfiability.bitstringgraph.BitStringGraph;
import positronic.satisfiability.bitstringgraph.IBitStringGraph;
import positronic.satisfiability.elements.BooleanLiteral;
import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.IProblem;

public class BitStringDigraphDemo 
{
	public static void main(String[] args) throws Exception
  {
  	IBitStringGraph x=new BitStringGraph("X");
  	IBitString room0=new BitString("0","0000");
  	IBitString room1=new BitString("1","0001");
  	IBitString room2=new BitString("2","0010");
  	IBitString room3=new BitString("3","0011");
  	IBitString room4=new BitString("4","0100");
  	IBitString room5=new BitString("5","0101");
  	IBitString room6=new BitString("6","0110");
  	IBitString room7=new BitString("7","0111");
  	IBitString room8=new BitString("8","1000");

  	/*x.addPair(room0,room1);
  	x.addPair(room1,room4);
  	x.addPair(room3,room6);
  	x.addPair(room4,room5);
  	x.addPair(room5,room2);
  	x.addPair(room6,room7);
  	x.addPair(room7,room4);
  	x.addPair(room7,room8);*/
  	
  	System.out.println(x);
  	IProblem[] fixroom=new IProblem[9];
  	fixroom[0]=new BitStringFixer(room0);
  	fixroom[1]=new BitStringFixer(room1);
  	fixroom[2]=new BitStringFixer(room2);
  	fixroom[3]=new BitStringFixer(room3);
  	fixroom[4]=new BitStringFixer(room4);
  	fixroom[5]=new BitStringFixer(room5);
  	fixroom[6]=new BitStringFixer(room6);
  	fixroom[7]=new BitStringFixer(room7);
  	fixroom[8]=new BitStringFixer(room8);
  	
  	IBitString adjroom=new BitString("adjacent room",4);
  	
  	IBitString[] path=new IBitString[2];
  	path[0]=new BitString("path0",4);
  	path[1]=new BitString("path1",4);
  	IBitString roomCurr=room3;
  	IProblem conn=new BitStringDigraphConnector(x,roomCurr,path,adjroom);
  	IProblem problem=new Conjunction(new Conjunction(fixroom),conn);
  	System.out.println(problem);
  	ArrayList<?>[] ss=problem.findTwoModels(adjroom);
  	System.out.println("Model 1");
		if(ss!=null && ss[0]!=null && ss[0].size()>0)
    {
      BooleanLiteral.interpret(ss[0]);
    	//System.out.println(room0);
    	//System.out.println(room1);
    	//System.out.println(room2);
    	//System.out.println(room3);
    	//System.out.println(room4);
    	//System.out.println(room5);
    	//System.out.println(room6);
    	//System.out.println(room7);
    	System.out.println(roomCurr);
    	System.out.println(path[0]);
    	System.out.println(path[1]);
    	System.out.println(adjroom);
    }
    else
      System.out.println("No solution.");
		System.out.println("Model 2");
		if(ss!=null && ss[1]!=null && ss[1].size()>0)
    {
      BooleanLiteral.interpret(ss[1]);
    	//System.out.println(room0);
    	//System.out.println(room1);
    	//System.out.println(room2);
    	//System.out.println(room3);
    	//System.out.println(room4);
    	//System.out.println(room5);
    	//System.out.println(room6);
    	//System.out.println(room7);
    	System.out.println(roomCurr);
    	System.out.println(path[0]);
    	System.out.println(path[1]);
    	System.out.println(adjroom);
    }
    else
      System.out.println("No solution.");
  }
}

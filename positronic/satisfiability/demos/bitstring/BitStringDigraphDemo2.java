/**
 * An IBitStringGraph represents a directed graph whose nodes are bit 
 * strings of a given length. For instance we will use the following 
 * example:
 * 
 * 0000->0001->0100->0101->0010
 *               ^
 *               |
 * 0011->0110->0111->1000
 *  
 */
package positronic.satisfiability.demos.bitstring;

import java.util.List;

import positronic.satisfiability.bitstring.BitString;
import positronic.satisfiability.bitstring.BitStringFixer;
import positronic.satisfiability.bitstring.IBitString;
import positronic.satisfiability.bitstringgraph.BitStringDigraphConnector;
import positronic.satisfiability.bitstringgraph.BitStringGraph;
import positronic.satisfiability.bitstringgraph.IBitStringGraph;
import positronic.satisfiability.elements.BooleanLiteral;
import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.IProblem;

public class BitStringDigraphDemo2 
{
	public static void main(String[] args) throws Exception
  {
		//Create an instance of BitStringGraph
  	IBitStringGraph theGraph=new BitStringGraph("Graph");
  	//Create instances of the BitString objects which will be the nodes.
  	IBitString room0=new BitString("room_0","0000");
  	IBitString room1=new BitString("room_1","0001");
  	IBitString room2=new BitString("room_2","0010");
  	IBitString room3=new BitString("room_3","0011");
  	IBitString room4=new BitString("room_4","0100");
  	IBitString room5=new BitString("room_5","0101");
  	IBitString room6=new BitString("room_6","0110");
  	IBitString room7=new BitString("room_7","0111");
  	IBitString room8=new BitString("room_8","1000");
  	//Attach the appropriate edges of the graph 
  	/*theGraph.addPair(room0,room1);
  	theGraph.addPair(room1,room4);
  	theGraph.addPair(room3,room6);
  	theGraph.addPair(room4,room5);
  	theGraph.addPair(room5,room2);
  	theGraph.addPair(room6,room7);
  	theGraph.addPair(room7,room4);
  	theGraph.addPair(room7,room8);*/
  	
  	System.out.println(theGraph);
  	
  	//Create the array of Problem objects which will fix the values of the nodes
  	IProblem[] fixroom
  		=new IProblem[]{
  			new BitStringFixer(room0),
  			new BitStringFixer(room1),
  			new BitStringFixer(room2),
  			new BitStringFixer(room3),
  			new BitStringFixer(room4),
  			new BitStringFixer(room5),
  			new BitStringFixer(room6),
  			new BitStringFixer(room7),
  			new BitStringFixer(room8)};
  	
  	IBitString[] path=new IBitString[2];
  	path[0]=new BitString("path0",4);
  	path[1]=new BitString("path1",4);
  	IBitString endroom=new BitString("end_room",4);
  	IBitString startroom=new BitString("start_room",4);
  	
  	IProblem conn=new BitStringDigraphConnector(theGraph,startroom,path,endroom);
  	IProblem problem=new Conjunction(
  			new Conjunction(fixroom),conn,
  			new BitStringFixer(startroom,"0110"),
  			new BitStringFixer(endroom,"0101"));
  	System.out.println(problem);
  	List<?> ss=problem.findModel();
  	System.out.println("Path Found:");
		if(ss!=null && ss.size()>0)
    {
      BooleanLiteral.interpret(ss);
    	System.out.println(startroom);
    	System.out.println(path[0]);
    	System.out.println(path[1]);
    	System.out.println(endroom);
    }
    else
      System.out.println("No solution.");
  }
}

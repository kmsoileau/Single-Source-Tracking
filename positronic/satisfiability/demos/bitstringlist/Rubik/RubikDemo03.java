package positronic.satisfiability.demos.bitstringlist.Rubik;

import java.util.List;

import positronic.satisfiability.bitstringlist.BitStringListFixer;
import positronic.satisfiability.bitstringlist.Rubik.RubikShifter;
import positronic.satisfiability.bitstringlist.Rubik.RubikStatus;
import positronic.satisfiability.elements.BooleanLiteral;
import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.IBooleanLiteral;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;

public class RubikDemo03
{
	public static void main(String[] args) throws Exception
	{
		RubikStatus start=new RubikStatus("start");
		
		start.setFaceGreen(1);
		start.setFaceRed(2);
		start.setFaceRed(3);
		start.setFaceGreen(4);
		start.setFaceYellow(5);
		start.setFaceGreen(6);
		start.setFaceYellow(7);
		start.setFaceYellow(8);
		start.setFaceWhite(9);
		start.setFaceWhite(10);
		start.setFaceWhite(11);
		start.setFaceRed(12);
		start.setFaceBlue(13);
		start.setFaceBlue(14);
		start.setFaceOrange(15);
		start.setFaceOrange(16);
		start.setFaceYellow(17);
		start.setFaceGreen(18);
		start.setFaceGreen(19);
		start.setFaceOrange(20);
		start.setFaceRed(21);
		start.setFaceRed(22);
		start.setFaceYellow(23);
		start.setFaceBlue(24);
		start.setFaceOrange(25);
		start.setFaceYellow(26);
		start.setFaceGreen(27);
		start.setFaceWhite(28);
		start.setFaceYellow(29);
		start.setFaceBlue(30);
		start.setFaceBlue(31);
		start.setFaceOrange(32);
		start.setFaceOrange(33);
		start.setFaceYellow(34);
		start.setFaceGreen(35);
		start.setFaceGreen(36);
		start.setFaceWhite(37);
		start.setFaceRed(38);
		start.setFaceRed(39);
		start.setFaceRed(40);
		start.setFaceWhite(41);
		start.setFaceWhite(42);
		start.setFaceOrange(43);
		start.setFaceWhite(44);
		start.setFaceOrange(45);
		start.setFaceBlue(46);
		start.setFaceBlue(47);
		start.setFaceBlue(48);
		
		int MOVES=19;
		
		RubikStatus[] after=new RubikStatus[MOVES];
		
		for(int i=0;i<MOVES;i++)
			after[i]=new RubikStatus("after"+(i+1));
		
		after[MOVES-1].initializeCube();
		
		IProblem problem=new BitStringListFixer(start);
		problem=new Conjunction(problem,new RubikShifter(start,after[0]));
		for(int i=0;i<MOVES-1;i++)
			problem=new Conjunction(problem,new RubikShifter(after[i],after[i+1]));
		
		problem=new Conjunction(problem,new BitStringListFixer(after[MOVES-1]));
		
		List<IBooleanLiteral> s=problem.findModel(Problem.defaultSolver());
		
		if(s!=null && s.size()>0)
	    {
			BooleanLiteral.interpret(s);
			System.out.println("start = "+start);
			for(int i=0;i<MOVES;i++)
				System.out.println("after"+(i+1)+" = "+after[i]);
			RubikFrame rfbefore=new RubikFrame("start",start);
			rfbefore.setVisible(true);
			RubikFrame[] rfafter=new RubikFrame[MOVES];
			for(int i=0;i<MOVES;i++)
			{
				rfafter[i]=new RubikFrame("after"+(i+1),after[i]);
				rfafter[i].setVisible(true);
			}
	    }
		else
			System.out.println("No solution in "+MOVES+" moves.");
	}
}
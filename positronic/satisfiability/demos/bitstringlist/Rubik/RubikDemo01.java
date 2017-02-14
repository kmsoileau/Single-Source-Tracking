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

public class RubikDemo01
{
	public static void main(String[] args) throws Exception
	{
		RubikStatus before=new RubikStatus("before");
		RubikStatus after=new RubikStatus("after");
		
		
		before.setFaceYellow(1);
		before.setFaceYellow(2);
		before.setFaceYellow(3);
		before.setFaceYellow(4);
		before.setFaceYellow(5);
		before.setFaceYellow(6);
		before.setFaceYellow(7);
		before.setFaceYellow(8);
		before.setFaceRed(9);
		before.setFaceRed(10);
		before.setFaceRed(11);
		before.setFaceBlue(12);
		before.setFaceBlue(13);
		before.setFaceBlue(14);
		before.setFaceOrange(15);
		before.setFaceOrange(16);
		before.setFaceOrange(17);
		before.setFaceGreen(18);
		before.setFaceGreen(19);
		before.setFaceGreen(20);
		before.setFaceRed(21);
		before.setFaceRed(22);
		before.setFaceBlue(23);
		before.setFaceBlue(24);
		before.setFaceOrange(25);
		before.setFaceOrange(26);
		before.setFaceGreen(27);
		before.setFaceGreen(28);
		before.setFaceGreen(29);
		before.setFaceGreen(30);
		before.setFaceGreen(31);
		before.setFaceRed(32);
		before.setFaceRed(33);
		before.setFaceRed(34);
		before.setFaceBlue(35);
		before.setFaceBlue(36);
		before.setFaceBlue(37);
		before.setFaceOrange(38);
		before.setFaceOrange(39);
		before.setFaceOrange(40);
		before.setFaceWhite(41);
		before.setFaceWhite(42);
		before.setFaceWhite(43);
		before.setFaceWhite(44);
		before.setFaceWhite(45);
		before.setFaceWhite(46);
		before.setFaceWhite(47);
		before.setFaceWhite(48);
		
		after.initializeCube();
		
		IProblem problem=new Conjunction(
				new BitStringListFixer(before),
				new BitStringListFixer(after),
				new RubikShifter(before,after));
		
		List<IBooleanLiteral> s=problem.findModel(Problem.defaultSolver());
		
		if(s!=null && s.size()>0)
	    {
	      BooleanLiteral.interpret(s);
	      System.out.println("before = "+before);
	      System.out.println("after = "+after);
	    }
		else
			System.out.println("No solution.");
	}
}

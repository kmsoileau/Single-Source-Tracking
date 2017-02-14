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

public class RubikDemo02
{
	public static void main(String[] args) throws Exception
	{
		RubikStatus before=new RubikStatus("before");
		
		before.setFaceGreen(1);
		before.setFaceRed(2);
		before.setFaceRed(3);
		before.setFaceGreen(4);
		before.setFaceYellow(5);
		before.setFaceGreen(6);
		before.setFaceYellow(7);
		before.setFaceYellow(8);
		before.setFaceWhite(9);
		before.setFaceWhite(10);
		before.setFaceWhite(11);
		before.setFaceRed(12);
		before.setFaceBlue(13);
		before.setFaceBlue(14);
		before.setFaceOrange(15);
		before.setFaceOrange(16);
		before.setFaceYellow(17);
		before.setFaceGreen(18);
		before.setFaceGreen(19);
		before.setFaceOrange(20);
		before.setFaceRed(21);
		before.setFaceRed(22);
		before.setFaceYellow(23);
		before.setFaceBlue(24);
		before.setFaceOrange(25);
		before.setFaceYellow(26);
		before.setFaceGreen(27);
		before.setFaceWhite(28);
		before.setFaceYellow(29);
		before.setFaceBlue(30);
		before.setFaceBlue(31);
		before.setFaceOrange(32);
		before.setFaceOrange(33);
		before.setFaceYellow(34);
		before.setFaceGreen(35);
		before.setFaceGreen(36);
		before.setFaceWhite(37);
		before.setFaceRed(38);
		before.setFaceRed(39);
		before.setFaceRed(40);
		before.setFaceWhite(41);
		before.setFaceWhite(42);
		before.setFaceOrange(43);
		before.setFaceWhite(44);
		before.setFaceOrange(45);
		before.setFaceBlue(46);
		before.setFaceBlue(47);
		before.setFaceBlue(48);
		
		RubikStatus after1=new RubikStatus("after1");
		RubikStatus after2=new RubikStatus("after2");
		RubikStatus after3=new RubikStatus("after3");
		
		after3.initializeCube();

		IProblem problem=new Conjunction(new IProblem[]{
				new BitStringListFixer(before),
				new RubikShifter(before,after1),
				new RubikShifter(after1,after2),
				new RubikShifter(after2,after3),
				new BitStringListFixer(after3)});
		
		List<IBooleanLiteral> s=problem.findModel(Problem.defaultSolver());
		
		if(s!=null && s.size()>0)
	    {
	      BooleanLiteral.interpret(s);
	      System.out.println("before = "+before);
	      System.out.println("after1 = "+after1);
	      System.out.println("after2 = "+after2);
	      System.out.println("after3 = "+after3);
	    }
		else
			System.out.println("No solution.");
		
		RubikFrame rfbefore=new RubikFrame("before",before);
		rfbefore.setVisible(true);
		
		RubikFrame rfafter1=new RubikFrame("after1",after1);
		rfafter1.setVisible(true);

		RubikFrame rfafter2=new RubikFrame("after2",after2);
		rfafter2.setVisible(true);

		RubikFrame rfafter3=new RubikFrame("after3",after3);
		rfafter3.setVisible(true);
	}
}
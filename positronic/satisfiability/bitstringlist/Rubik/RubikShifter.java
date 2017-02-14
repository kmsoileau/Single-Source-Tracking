package positronic.satisfiability.bitstringlist.Rubik;

import java.util.List;

import positronic.satisfiability.bitstring.BitStringEqualizer;
import positronic.satisfiability.bitstringlist.BitStringListFixer;
import positronic.satisfiability.elements.BooleanLiteral;
import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.Disjunction;
import positronic.satisfiability.elements.IBooleanLiteral;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;

public class RubikShifter extends Problem implements IProblem
{
	private static final long serialVersionUID = -2046434810902559402L;

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
	
	public RubikShifter(RubikStatus before, RubikStatus after) throws Exception
	{
		this.setClauses(new Disjunction(new IProblem[]{
				new RubikShifter(before, after, new int[]{12,13,14,24,34,33,32,23}, new int[]{6,7,8,15,25,35,43,42,41,31,22,11}),//BlueR
				new RubikShifter(before, after, new int[]{12,23,32,33,34,24,14,13}, new int[]{11,22,31,41,42,43,35,25,15,8,7,6}),//BlueL
				new RubikShifter(before, after, new int[]{41,42,43,45,48,47,46,44}, new int[]{32,33,34,35,36,37,38,39,40,29,30,31}),//WhiteR
				new RubikShifter(before, after, new int[]{41,44,46,47,48,45,43,42}, new int[]{31,30,29,40,39,38,37,36,35,34,33,32}),//WhiteL
				new RubikShifter(before, after, new int[]{1,2,3,5,8,7,6,4}, new int[]{20,19,18,17,16,15,14,13,12,11,10,9}),//YellowR
				new RubikShifter(before, after, new int[]{1,4,6,7,8,5,3,2}, new int[]{9,10,11,12,13,14,15,16,17,18,19,20}),//YellowL
				new RubikShifter(before, after, new int[]{9,10,11,22,31,30,29,21}, new int[]{1,4,6,12,23,32,41,44,46,40,28,20}),//RedR
				new RubikShifter(before, after, new int[]{9,21,29,30,31,22,11,10}, new int[]{20,28,40,46,44,41,32,23,12,6,4,1}),//RedL
				new RubikShifter(before, after, new int[]{15,16,17,26,37,36,35,25}, new int[]{8,5,3,18,27,38,48,45,43,34,24,14}),//OrangeR
				new RubikShifter(before, after, new int[]{15,25,35,36,37,26,17,16}, new int[]{14,24,34,43,45,48,38,27,18,3,5,8}),//OrangeL
				new RubikShifter(before, after, new int[]{18,19,20,28,40,39,38,27}, new int[]{3,2,1,9,21,29,46,47,48,37,26,17}),//GreenR
				new RubikShifter(before, after, new int[]{18,27,38,39,40,28,20,19}, new int[]{17,26,37,48,47,46,29,21,9,1,2,3})//GreenL
		}).getClauses());
	}
	
	public RubikShifter(RubikStatus before, RubikStatus after, int[] faces1, int[] faces2) throws Exception
	{
		boolean[] check=new boolean[48];
		for(int i=0;i<48;i++)
			check[i]=false;
		IProblem prob=null;
		for(int i=0;i<faces1.length;i++)
		{
			prob=new Conjunction(prob,new BitStringEqualizer(after.getFace(faces1[(i+2)%faces1.length]),before.getFace(faces1[i])));
			check[faces1[(i+2)%faces1.length]-1]=true;
		}
		for(int i=0;i<faces2.length;i++)
		{
			prob=new Conjunction(prob,new BitStringEqualizer(after.getFace(faces2[(i+3)%faces2.length]),before.getFace(faces2[i])));
			check[faces2[(i+3)%faces2.length]-1]=true;
		}
		for(int i=0;i<48;i++)
		{
			if(!check[i])
				prob=new Conjunction(prob,new BitStringEqualizer(before.getFace(i+1),after.getFace(i+1)));
		}
		this.setClauses(prob.getClauses());
	}
}

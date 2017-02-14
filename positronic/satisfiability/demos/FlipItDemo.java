package positronic.satisfiability.demos;

import java.util.List;

import positronic.satisfiability.bittable.BitTable;
import positronic.satisfiability.bittable.BitTableFixer;
import positronic.satisfiability.bittable.IBitTable;
import positronic.satisfiability.elements.BitEqualizer;
import positronic.satisfiability.elements.BitUnequalizer;
import positronic.satisfiability.elements.BooleanLiteral;
import positronic.satisfiability.elements.BooleanVariable;
import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.IBooleanLiteral;
import positronic.satisfiability.elements.IBooleanVariable;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;

public class FlipItDemo
{
	public static void main(String[] args) throws Exception
	{
		IBitTable[] board=new BitTable[10];
		for(int i=0;i<10;i++)
		{
			IBooleanVariable[][] data=new IBooleanVariable[3][3];
			for(int j=0;j<3;j++)
				for(int k=0;k<3;k++)
					data[j][k]=BooleanVariable.getBooleanVariable(false);
			board[i]=new BitTable("board",data);
		}
		board[0].getBooleanVariable(0,0).setValue(true);
		board[0].getBooleanVariable(0,1).setValue(false);
		board[0].getBooleanVariable(0,2).setValue(false);
		board[0].getBooleanVariable(1,0).setValue(true);
		board[0].getBooleanVariable(1,1).setValue(true);
		board[0].getBooleanVariable(1,2).setValue(false);
		board[0].getBooleanVariable(2,0).setValue(false);
		board[0].getBooleanVariable(2,1).setValue(true);
		board[0].getBooleanVariable(2,2).setValue(true);
		IProblem initialPosition=new BitTableFixer(board[0]);
		IProblem push00=new Pusher00(board[0],board[1]);
		IProblem push01=new Pusher01(board[1],board[2]);
		IProblem push02=new Pusher02(board[2],board[3]);
		
		IProblem problem=new Conjunction(initialPosition,push00,push01,push02);
		
		List<IBooleanLiteral> s=problem.findModel(Problem.defaultSolver());
		if(s!=null && s.size()>0)
		{
			BooleanLiteral.interpret(s);
			System.out.println(board[0]);
			System.out.println(board[1]);
			System.out.println(board[2]);
			System.out.println(board[3]);
		}
		else
			System.out.println("There is no solution.");
	}
}

class Pusher00 extends Problem implements IProblem
{
	private static final long serialVersionUID = -3203333630355171194L;

	public Pusher00(IBitTable preboard, IBitTable postboard) throws Exception
	{
		IProblem ret00=new BitUnequalizer(preboard.getBooleanVariable(0,0),postboard.getBooleanVariable(0,0));
		IProblem ret01=new BitUnequalizer(preboard.getBooleanVariable(0,1),postboard.getBooleanVariable(0,1));
		IProblem ret02=new BitEqualizer(preboard.getBooleanVariable(0,2),postboard.getBooleanVariable(0,2));
		IProblem ret10=new BitUnequalizer(preboard.getBooleanVariable(1,0),postboard.getBooleanVariable(1,0));
		IProblem ret11=new BitUnequalizer(preboard.getBooleanVariable(1,1),postboard.getBooleanVariable(1,1));
		IProblem ret12=new BitEqualizer(preboard.getBooleanVariable(1,2),postboard.getBooleanVariable(1,2));
		IProblem ret20=new BitEqualizer(preboard.getBooleanVariable(2,0),postboard.getBooleanVariable(2,0));
		IProblem ret21=new BitEqualizer(preboard.getBooleanVariable(2,1),postboard.getBooleanVariable(2,1));
		IProblem ret22=new BitEqualizer(preboard.getBooleanVariable(2,2),postboard.getBooleanVariable(2,2));
		IProblem p=new Conjunction(new IProblem[]{ret00,ret01,ret02,ret10,ret11,ret12,ret20,ret21,ret22});
		this.setClauses(p.getClauses());
	}
}

class Pusher01 extends Problem implements IProblem
{
	private static final long serialVersionUID = 3754440448599549768L;

	public Pusher01(IBitTable preboard, IBitTable postboard) throws Exception
	{
		IProblem ret00=new BitUnequalizer(preboard.getBooleanVariable(0,0),postboard.getBooleanVariable(0,0));
		IProblem ret01=new BitUnequalizer(preboard.getBooleanVariable(0,1),postboard.getBooleanVariable(0,1));
		IProblem ret02=new BitUnequalizer(preboard.getBooleanVariable(0,2),postboard.getBooleanVariable(0,2));
		IProblem ret10=new BitUnequalizer(preboard.getBooleanVariable(1,0),postboard.getBooleanVariable(1,0));
		IProblem ret11=new BitUnequalizer(preboard.getBooleanVariable(1,1),postboard.getBooleanVariable(1,1));
		IProblem ret12=new BitUnequalizer(preboard.getBooleanVariable(1,2),postboard.getBooleanVariable(1,2));
		IProblem ret20=new BitEqualizer(preboard.getBooleanVariable(2,0),postboard.getBooleanVariable(2,0));
		IProblem ret21=new BitEqualizer(preboard.getBooleanVariable(2,1),postboard.getBooleanVariable(2,1));
		IProblem ret22=new BitEqualizer(preboard.getBooleanVariable(2,2),postboard.getBooleanVariable(2,2));
		IProblem p=new Conjunction(new IProblem[]{ret00,ret01,ret02,ret10,ret11,ret12,ret20,ret21,ret22});
		this.setClauses(p.getClauses());
	}
}

class Pusher02 extends Problem implements IProblem
{
	private static final long serialVersionUID = 4635832533075468139L;

	public Pusher02(IBitTable preboard, IBitTable postboard) throws Exception
	{
		IProblem ret00=new BitEqualizer(preboard.getBooleanVariable(0,0),postboard.getBooleanVariable(0,0));
		IProblem ret01=new BitUnequalizer(preboard.getBooleanVariable(0,1),postboard.getBooleanVariable(0,1));
		IProblem ret02=new BitUnequalizer(preboard.getBooleanVariable(0,2),postboard.getBooleanVariable(0,2));
		IProblem ret10=new BitEqualizer(preboard.getBooleanVariable(1,0),postboard.getBooleanVariable(1,0));
		IProblem ret11=new BitUnequalizer(preboard.getBooleanVariable(1,1),postboard.getBooleanVariable(1,1));
		IProblem ret12=new BitUnequalizer(preboard.getBooleanVariable(1,2),postboard.getBooleanVariable(1,2));
		IProblem ret20=new BitEqualizer(preboard.getBooleanVariable(2,0),postboard.getBooleanVariable(2,0));
		IProblem ret21=new BitEqualizer(preboard.getBooleanVariable(2,1),postboard.getBooleanVariable(2,1));
		IProblem ret22=new BitEqualizer(preboard.getBooleanVariable(2,2),postboard.getBooleanVariable(2,2));
		IProblem p=new Conjunction(new IProblem[]{ret00,ret01,ret02,ret10,ret11,ret12,ret20,ret21,ret22});
		this.setClauses(p.getClauses());
	}
}

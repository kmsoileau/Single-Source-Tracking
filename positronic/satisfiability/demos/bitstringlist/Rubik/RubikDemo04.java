package positronic.satisfiability.demos.bitstringlist.Rubik;

import java.awt.FlowLayout;
import java.util.List;

import javax.swing.JFrame;

import positronic.satisfiability.bitstringlist.BitStringListFixer;
import positronic.satisfiability.bitstringlist.Rubik.RubikShifter;
import positronic.satisfiability.bitstringlist.Rubik.RubikStatus;
import positronic.satisfiability.elements.BooleanLiteral;
import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.IBooleanLiteral;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;

public class RubikDemo04 extends JFrame
{
	private static final long serialVersionUID = 3448814798127647717L;

	public static void main(String[] args) throws Exception
	{
		new RubikDemo04();
	}
	
	public void doAnalysis(RubikStatus start, int moves) throws Exception
	{
		
		RubikStatus[] after=new RubikStatus[moves];
		
		for(int i=0;i<moves;i++)
			after[i]=new RubikStatus("after"+(i+1));
		
		after[moves-1].initializeCube();
		
		IProblem problem=new BitStringListFixer(start);
		problem=new Conjunction(problem,new RubikShifter(start,after[0]));
		for(int i=0;i<moves-1;i++)
			problem=new Conjunction(problem,new RubikShifter(after[i],after[i+1]));
		
		problem=new Conjunction(problem,new BitStringListFixer(after[moves-1]));
		
		List<IBooleanLiteral> s=problem.findModel(Problem.defaultSolver());
		
		if(s!=null && s.size()>0)
	    {
			BooleanLiteral.interpret(s);
			System.out.println("start = "+start);
			for(int i=0;i<moves;i++)
				System.out.println("after"+(i+1)+" = "+after[i]);
			RubikJPanel rfbefore=new RubikJPanel(start);
			this.setLayout(new FlowLayout());
			this.add(rfbefore);
			rfbefore.setVisible(true);
			RubikJPanel[] rfafter=new RubikJPanel[moves];
			for(int i=0;i<moves;i++)
			{
				rfafter[i]=new RubikJPanel(after[i]);
				this.add(rfafter[i]);
				rfafter[i].setVisible(true);
			}
			this.setVisible(true);
	    }
		else
			System.out.println("No solution in "+moves+" moves.");
	}

	public RubikDemo04() throws Exception
	{
		RubikStatus start=new RubikStatus("start");
		
		start.setReds(new int[]{9,10,11,22,30,31,28,48});
		start.setYellows(new int[]{1,2,3,4,5,6,7,8});
		start.setBlues(new int[]{12,13,14,23,24,32,47,29});
		start.setWhites(new int[]{21,34,41,42,36,37,39,40});
		start.setOranges(new int[]{27,45,46,15,16,17,25,35});
		start.setGreens(new int[]{33,43,44,38,26,18,19,20});
		
		doAnalysis(start, 11);
		
		/*
		
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
			RubikJPanel rfbefore=new RubikJPanel(start);
			this.setLayout(new FlowLayout());
			this.add(rfbefore);
			rfbefore.setVisible(true);
			RubikJPanel[] rfafter=new RubikJPanel[MOVES];
			for(int i=0;i<MOVES;i++)
			{
				rfafter[i]=new RubikJPanel(after[i]);
				this.add(rfafter[i]);
				rfafter[i].setVisible(true);
			}
			this.setVisible(true);
	    }
		else
			System.out.println("No solution in "+MOVES+" moves.");*/
	}
}
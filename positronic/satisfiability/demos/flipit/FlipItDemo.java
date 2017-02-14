package positronic.satisfiability.demos.flipit;

import java.util.List;

import positronic.satisfiability.bittable.BitTable;
import positronic.satisfiability.bittable.BitTableFixer;
import positronic.satisfiability.bittable.IBitTable;
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
		int moves=6;
		IBitTable[] board=new BitTable[moves+1];
		IProblem prob = solve(board);
		System.out.println(prob.toMathematicaCode());
		
		List<IBooleanLiteral> s=prob.findModel(Problem.defaultSolver());
		
		if(s!=null && s.size()>0)
		{
			BooleanLiteral.interpret(s);
			for(int i=0;i<moves+1;i++)
				System.out.println(board[i]);
		}
		else
			System.out.println("There is no solution.");
		
		
	}
	
	public static IProblem solve(IBitTable[] board) throws Exception
	{
		int moves=board.length-1;
		for(int i=0;i<moves+1;i++)
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
		
		board[moves].getBooleanVariable(0,0).setValue(true);
		board[moves].getBooleanVariable(0,1).setValue(true);
		board[moves].getBooleanVariable(0,2).setValue(true);
		board[moves].getBooleanVariable(1,0).setValue(true);
		board[moves].getBooleanVariable(1,1).setValue(true);
		board[moves].getBooleanVariable(1,2).setValue(true);
		board[moves].getBooleanVariable(2,0).setValue(true);
		board[moves].getBooleanVariable(2,1).setValue(true);
		board[moves].getBooleanVariable(2,2).setValue(true);
		IProblem finalPosition=new BitTableFixer(board[moves]);
		
		IProblem problem=new Conjunction(initialPosition,finalPosition);
		
		for(int i=0;i<moves;i++)
			problem=new Conjunction(problem,new Push(board[i],board[i+1]));
		return problem;
	}
}
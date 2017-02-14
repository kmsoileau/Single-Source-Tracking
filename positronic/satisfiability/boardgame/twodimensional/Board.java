package positronic.satisfiability.boardgame.twodimensional;

import positronic.satisfiability.boardgame.twodimensional.twoplayer.Piece;

public class Board
{
	Cloneable[][] board=null;
	
	public Board()
	{
		this(3,3);
	}
	
	public Board(int rows, int columns)
	{
		board=new Cloneable[rows][columns];
	}
	
	public void placePiece(Piece p,int row,int column)
	{
		board[row][column]=p;
	}
	
	public Object removePiece(int row,int column)
	{
		Piece p=(Piece)((Piece)board[row][column]).clone();
		board[row][column]=null;
		return p;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}

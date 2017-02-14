package positronic.satisfiability.boardgame.track;

import positronic.satisfiability.boardgame.twodimensional.twoplayer.Piece;

public class Track
{
	Object[] board=null;
	
	public Track()
	{
		this(3);
	}
	
	public Track(int spaces)
	{
		board=new Object[spaces];
	}
	
	public void placePiece(Piece p,int space)
	{
		board[space]=p;
	}
	
	public Object removePiece(int space)
	{
		Piece p=(Piece)((Piece)board[space]).clone();
		board[space]=null;
		return p;
	}
	
	
}

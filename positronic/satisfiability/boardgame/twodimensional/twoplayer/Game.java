package positronic.satisfiability.boardgame.twodimensional.twoplayer;

import java.awt.Color;

import positronic.satisfiability.boardgame.Pieces;

public class Game
{
	public static void main(String[] args)
	{
		Game game=new Game();
		game.createBlackPieces(5);
		game.createWhitePieces(5);
	}
	
	private Pieces blackPieces=new Pieces();
	private Pieces whitePieces=new Pieces();
	
	public void createBlackPieces(int number)
	{
		for(int i=0;i<number;i++)
		{
			Piece currPiece=new Piece();
			currPiece.setColor(Color.black);
			currPiece.setStatus(IPiece.PLAYABLE);
			blackPieces.add(currPiece);
		}
	}
	
	public void createWhitePieces(int number)
	{
		for(int i=0;i<number;i++)
		{
			Piece currPiece=new Piece();
			currPiece.setColor(Color.white);
			currPiece.setStatus(IPiece.PLAYABLE);
			whitePieces.add(currPiece);
		}
	}
}

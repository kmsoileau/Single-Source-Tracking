package positronic.satisfiability.boardgame;

import java.util.Collection;
import java.util.HashSet;

import positronic.satisfiability.boardgame.twodimensional.twoplayer.Piece;

public class Pieces implements Cloneable
{
	private HashSet<Piece> piecesSet=new HashSet<Piece>();

	public Pieces()
	{
	}
	
	public Pieces(Collection<Piece> c)
	{
		if(c!=null)
			this.piecesSet.addAll(c);
	}
	
	public void add(Piece p)
	{
		this.piecesSet.add(p);
	}
}

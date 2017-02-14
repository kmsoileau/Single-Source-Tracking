package positronic.satisfiability.boardgame.twodimensional.twoplayer;

import java.awt.Color;

public class Piece implements IPiece,Cloneable
{
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}
	
	public Piece()
	{
		this(Color.black,IPiece.PLAYABLE);
	}
	
	public Piece(Color color,int status)
	{
		this.setColor(color);
		this.setStatus(status);
	}
	
	private Color color=IPiece.DEFAULTCOLOR;
	
	private int status=IPiece.PLAYABLE;

	public Color getColor()
	{
		return color;
	}

	public int getStatus()
	{
		return status;
	}

	public void setColor(Color color)
	{
		this.color = color;
	}

	public void setStatus(int status)
	{
		this.status = status;
	}
	
	public Object clone()
	{
		return new Piece(this.getColor(),this.getStatus());
	}
}

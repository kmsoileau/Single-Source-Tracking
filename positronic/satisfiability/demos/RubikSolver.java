package positronic.satisfiability.demos;

import java.util.ArrayList;

import positronic.satisfiability.bitstring.BitString;
import positronic.satisfiability.bitstring.IBitString;
import positronic.satisfiability.bitstringlist.BitStringList;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;

class RubikShifter extends Problem implements IProblem
{
	private static final long serialVersionUID = -4124389557776017471L;
	private ArrayList<RubikStatus> status;
	
	public RubikShifter() throws Exception
	{
		this.status=new ArrayList<RubikStatus>();
		new BitStringList("Position 1",54,3);
	}

	public RubikStatus getStatus(int i)
	{
		return status.get(i);
	}

	public void setStatus(int i,RubikStatus value)
	{
		this.status.set(i, value);
	}
}

class RubikRightRotator extends Problem implements IProblem
{
	private static final long serialVersionUID = 1L;

	public RubikRightRotator(int face, RubikStatus before, RubikStatus after)
	{
		switch(face)
		{
			case 0:
				/**
				 * (0,0)->(0,2)
				 * (0,1)->(0,5)
				 * (0,2)->(0,8)
				 * (0,3)->(0,1)
				 * (0,4)->(0,4)
				 * (0,5)->(0,7)
				 * (0,6)->(0,0)
				 * (0,7)->(0,3)
				 * (0,8)->(0,6)
				 * 
				 * (1,2)->(2,2)
				 * (1,5)->(2,5)
				 * (1,8)->(2,8)
				 * 
				 * (2,2)->(4,2)
				 * (2,5)->(4,5)
				 * (2,8)->(4,8)
				 * 
				 * (4,2)->(5,2)
				 * (4,5)->(5,5)
				 * (4,8)->(5,8)
				 * 
				 * (5,2)->(1,2)
				 * (5,5)->(1,5)
				 * (5,8)->(1,8)
				 */
				;
			case 1:
				;
			case 2:
				;
			case 3:
				;
			case 4:
				;
			case 5:
				;
			default:
				;
		}
	}
}

class RubikLeftRotator extends Problem implements IProblem
{
	private static final long serialVersionUID = 1L;

	public RubikLeftRotator()
	{
		
	}
}

public class RubikSolver extends Problem implements IProblem
{
	private static final long serialVersionUID = -382450069357334956L;
	private ArrayList<BitStringList> status;
	
	public RubikSolver() throws Exception
	{
		setStatus(new ArrayList<BitStringList>());
		new BitStringList("Position 1",54,3);
	}

	public ArrayList<BitStringList> getStatus()
	{
		return status;
	}

	public void setStatus(ArrayList<BitStringList> status)
	{
		this.status = status;
	}
}

class RubikStatus
{
	private IBitString[][] status;
	
	public RubikStatus() throws Exception
	{
		this.status=new IBitString[6][9];
		for(int face=0;face<6;face++)
		{
			this.status[face]=new IBitString[9];
			for(int square=0;square<9;square++)
				this.status[face][square]=new BitString("Face"+face+"Square"+square,3);
		}
	}

	public IBitString getStatus(int face,int square)
	{
		return this.status[face][square];
	}

	public void setStatus(int face,int square,IBitString value)
	{
		this.status[face][square]=value;
	}
}

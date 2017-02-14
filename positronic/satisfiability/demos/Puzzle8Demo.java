package positronic.satisfiability.demos;

/**
 * <p>Title: TBS</p>
 * <p>Description: TBS</p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: Positronic Software</p>
 * @author Kerry Michael Soileau
 * @version 1.0
 */
import positronic.satisfiability.bitstring.BitString;
import positronic.satisfiability.bitstring.BitStringMapper;
import positronic.satisfiability.bitstring.IBitString;
import positronic.satisfiability.bitstringlist.BitStringList;
import positronic.satisfiability.bitstringlist.BitStringListFixer;
import positronic.satisfiability.bitstringlist.IBitStringList;
import positronic.satisfiability.elements.IProblem;

public class Puzzle8Demo
{
	
  public static void main(String[] args) throws Exception
  {
    IBitStringList items=new BitStringList("items",new IBitString[]
    {
      new BitString("0000"),//the empty item
      new BitString("0001"),//item 1
      new BitString("0010"),//item 2
      new BitString("0011"),//item 3
      new BitString("0100"),//item 4
      new BitString("0101"),//item 5
      new BitString("0110"),//item 6
      new BitString("0111"),//item 7
      new BitString("1000"),//item 8
    });
    IProblem fixItems=new BitStringListFixer(items);
    System.out.println(fixItems);

    IBitStringList positions=new BitStringList("positions",new IBitString[]
    {
      new BitString("0000"),//position 0,0
      new BitString("0001"),//position 0,1
      new BitString("0010"),//position 0,2
      new BitString("0100"),//position 1,0
      new BitString("0101"),//position 1,1
      new BitString("0110"),//position 1,2
      new BitString("1000"),//position 2,0
      new BitString("1001"),//position 2,1
      new BitString("1010"),//position 2,2
    });
    IProblem fixPositions=new BitStringListFixer(items);
    System.out.println(fixPositions);

    IProblem initialPositions=new BitStringMapper(positions,items,new BitString("p",4),new BitString("i",4));

    System.out.println(initialPositions);
  }
}
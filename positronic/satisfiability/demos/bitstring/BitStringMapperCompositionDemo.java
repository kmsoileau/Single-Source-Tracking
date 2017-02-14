package positronic.satisfiability.demos.bitstring;

import java.util.List;

import positronic.satisfiability.bitstring.BitString;
import positronic.satisfiability.bitstring.BitStringMapper;
import positronic.satisfiability.bitstring.BitStringMapperComposition;
import positronic.satisfiability.bitstring.IBitString;
import positronic.satisfiability.elements.BooleanLiteral;
import positronic.satisfiability.elements.IBooleanLiteral;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;
/**
 * <p>Title: BitStringMappingCompositionDemo</p>
 * <p>Description: TBS</p>
 * <p>Copyright (c) 2005</p>
 * <p>Company: Positronic Software</p>
 * @author Kerry Michael Soileau
 * @version 1.0
 */

public class BitStringMapperCompositionDemo
{
  public static void main(String[] args) throws Exception
  {
    BitStringMapper nnm1=null;
    IBitString[] x=new IBitString[]{
      new BitString("1011"),
      new BitString("0010"),
      new BitString("0011"),
      new BitString("0100"),
      new BitString("0101"),
      };
    IBitString[] y=new IBitString[]{
      new BitString("1101"),
      new BitString("0110"),
      new BitString("1011"),
      new BitString("0101"),
      new BitString("1101"),
      };
    nnm1=new BitStringMapper(x,y,
        new BitString("abscissafirst",4),
          new BitString("ordinatefirst",4));

    BitStringMapper nnm2=null;
    x=new IBitString[]{
      new BitString("1011"),
      new BitString("0010"),
      new BitString("0011"),
      new BitString("0100"),
      new BitString("0101"),
      };
    y=new IBitString[]{
      new BitString("1101"),
      new BitString("0110"),
      new BitString("1011"),
      new BitString("0101"),
      new BitString("1101"),
      };
    nnm2=new BitStringMapper(x,y,
        new BitString("abscissasecond",4),
          new BitString("ordinatesecond",4));

    IProblem compo=null;
    IBitString X=null;
    IBitString Y=null;
    
    X=new BitString("fore",4);
    Y=new BitString("aft",4);
    compo=new BitStringMapperComposition(nnm1,nnm2,X,Y);
    
    System.out.println(compo);
    List<IBooleanLiteral> s=compo.findModel(Problem.defaultSolver());
		if(s!=null && s.size()>0)
    {
      BooleanLiteral.interpret(s);
    	System.out.println("X= "+X);
    	System.out.println("Y= "+Y);
    }
    else
      System.out.println("No solution.");

  }
}
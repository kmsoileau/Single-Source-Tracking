package positronic.satisfiability.demos.bitstringlist;

import java.io.FileWriter;
import java.util.List;

import positronic.satisfiability.bitstring.BitString;
import positronic.satisfiability.bitstring.IBitString;
import positronic.satisfiability.bitstringlist.BitStringList;
import positronic.satisfiability.bitstringlist.BitStringListDisjointUnioner;
import positronic.satisfiability.bitstringlist.BitStringListFixer;
import positronic.satisfiability.bitstringlist.BitStringListSorter;
import positronic.satisfiability.bitstringlist.IBitStringList;
import positronic.satisfiability.elements.BooleanLiteral;
import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;

/**
 * <p>Title: BitStringListDisjointUnionerDemo</p>
 * <p>Description: TBS</p>
 * <p>Copyright (c) 2005</p>
 * <p>Company: Positronic Software</p>
 * @author Kerry Michael Soileau
 * @version 1.0
 */

public class BitStringListDisjointUnionerDemo
{
  public static void main(String[] args) throws Exception
  {
    IBitStringList slm=new BitStringList("y",
    		new boolean[][]{
        {false,true,true},
        {true,true,true},
      });
    IProblem slmfix=new BitStringListFixer(slm);
    
    IBitStringList bsl=new BitStringList("slist",
    		new IBitString[]{
    		new BitString(new boolean[]{true,true,true}),
    		new BitString(new boolean[]{false,true,false})
      });
    IProblem bslfix=new BitStringListFixer(bsl);

    IBitStringList target=new BitStringList("combined",
    		new boolean[4][3]);

    IProblem problem=
    	new Conjunction(slmfix,bslfix,
    			new BitStringListDisjointUnioner(target,slm,bsl),
    			new BitStringListSorter(target));

    System.out.println(problem);
    FileWriter f=new FileWriter("F:kerry.txt");
    f.write(problem.toXML());
    f.close();
    List<?> s=problem.findModel(Problem.defaultSolver());
		if(s!=null && s.size()>0)
    {
      BooleanLiteral.interpret(s);
    	System.out.println("slm= "+slm);
    	System.out.println("bsl= "+bsl);
    	System.out.println("target= "+target);
    }
    else
      System.out.println("No solution.");
  }
}

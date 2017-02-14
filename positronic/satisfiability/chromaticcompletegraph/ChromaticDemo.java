package positronic.satisfiability.chromaticcompletegraph;

import java.util.List;
import java.util.Vector;

import positronic.satisfiability.bitstring.BitString;
import positronic.satisfiability.bitstring.BitStringFixer;
import positronic.satisfiability.bitstring.IBitString;
import positronic.satisfiability.elements.BooleanLiteral;
import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.IBooleanLiteral;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;


public class ChromaticDemo 
{
  public static void main(String[] args) throws Exception
  {
  	IBitString fp=new BitString(3);
  	IBitString sp=new BitString(3);
  	IBitString color=new BitString(3);
  	ColoredEdge ce=new ColoredEdge(fp,sp,color);
  	Vector<ColoredEdge> vce=new Vector<ColoredEdge>();
  	vce.add(ce);
  	IProblem problem=new Conjunction(
  			new BitStringFixer(fp,"010"),
  			new BitStringFixer(sp,"110"),
  			new BitStringFixer(color,"111"),
  			new ColoredEdgeFixer(vce, fp, sp, color)
  			);
	 
	  System.out.println(problem);
    
	  List<IBooleanLiteral> s=problem.findModel(Problem.defaultSolver());
	  
	  if(s!=null && s.size()>0)
	  {
		  BooleanLiteral.interpret(s);
		  System.out.println("fp = "+fp.toBits());
		  System.out.println("sp = "+sp.toBits());
		  System.out.println("color = "+color.toBits());
		  System.out.println("ce = "+ce);
		  System.out.println("vce = "+vce);
	  }
	  else
		  System.out.println("No solution.");
  }
}


package positronic.satisfiability.demos;

import java.util.List;

import positronic.satisfiability.elements.BitFixer;
import positronic.satisfiability.elements.BooleanLiteral;
import positronic.satisfiability.elements.BooleanVariable;
import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.Disjunction;
import positronic.satisfiability.elements.IBooleanLiteral;
import positronic.satisfiability.elements.IBooleanVariable;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;
import positronic.satisfiability.naturalnumber.NaturalNumber;
import positronic.satisfiability.naturalnumber.NaturalNumberDoubler;
import positronic.satisfiability.naturalnumber.NaturalNumberFixer;

public class ProblemDemo2
{
  public static void main(String[] args) throws Exception
  {
    IBooleanVariable b=BooleanVariable.getBooleanVariable("b");

    NaturalNumber X=new NaturalNumber("X");
    NaturalNumber Y=new NaturalNumber("Y");

    //Stipulate that b=false
    BitFixer bf=new BitFixer(b,false);
    //Stipulate that Y=3
    NaturalNumberFixer nnfx=new NaturalNumberFixer(Y,3);

    //nndxy <-> 2X=Y
    NaturalNumberDoubler nndxy=new NaturalNumberDoubler(X,Y);
    //nndyx <-> 2Y=X
    NaturalNumberDoubler nndyx=new NaturalNumberDoubler(Y,X);

    //Stipulate that ptrue = nndxy && nnfx
    IProblem ptrue=new Conjunction(nndxy,nnfx);

    //Stipulate that pfalse = nndyx && nnfx
    IProblem pfalse=new Conjunction(nndyx,nnfx);

    //Stipulate that qq = ptrue || pfalse
    IProblem qq=new Disjunction(ptrue,pfalse,b);

    //Stipulate that pp = qq && bf
    IProblem pp=new Conjunction(qq,bf);

    pp.sort();
    System.out.println(pp);
    List<IBooleanLiteral> s=pp.findModel(Problem.defaultSolver());
		if(s!=null && s.size()>0)
    {
      BooleanLiteral.interpret(s);
    	System.out.println("X= "+X);
    	System.out.println("Y= "+Y);
    }
    else
      System.out.println("No solution.");
    
		System.out.println(((Problem)pp).toCode());
  }
}

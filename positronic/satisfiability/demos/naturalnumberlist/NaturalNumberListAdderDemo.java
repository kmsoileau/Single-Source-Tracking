package positronic.satisfiability.demos.naturalnumberlist;

import java.util.List;

import positronic.satisfiability.elements.BooleanLiteral;
import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.IBooleanLiteral;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;
import positronic.satisfiability.naturalnumberlist.INaturalNumberList;
import positronic.satisfiability.naturalnumberlist.NaturalNumberList;
import positronic.satisfiability.naturalnumberlist.NaturalNumberListAdder;
import positronic.satisfiability.naturalnumberlist.NaturalNumberListFixer;

public class NaturalNumberListAdderDemo 
{
	public static void main(String[] args) throws Exception 
	{
		INaturalNumberList s1=new NaturalNumberList("x",
				new long[]
				         {
									1,
									11
				         });
   System.out.println("s1.getName() = "+s1.getName());

   for(int i=0;i<s1.size();i++)
     System.out.println("s1.getNaturalNumber("+i+") = "+s1.getNaturalNumber(i));

   INaturalNumberList s2=new NaturalNumberList("y",new long[]
                                                            {
  	 3,4
                                                            }
  		          );
   
   INaturalNumberList s3=new NaturalNumberList("z",new long[s1.size()]);
   
   System.out.println("s2.getName() = "+s2.getName());
   for(int i=0;i<s2.size();i++)
     System.out.println("s2.getNaturalNumber("+i+") = "+s2.getNaturalNumber(i));
   
   IProblem f1=new NaturalNumberListFixer(s1);
   IProblem f2=new NaturalNumberListFixer(s2);
   IProblem eq=new NaturalNumberListAdder(s1,s2,s3);
   
   IProblem problem=new Conjunction(f1,f2,eq);
   System.out.println(problem);
   
   List<IBooleanLiteral> s=problem.findModel(Problem.defaultSolver());
   //List s=PartialSolution.solveList(problem);
   if(s!=null && s.size()>0)
   {
  	 BooleanLiteral.interpret(s);
  	 System.out.println("s1="+s1);
  	 System.out.println("s2="+s2);
  	 System.out.println("s3="+s3);
   }
   else
     System.out.println("No solution.");

	}

}

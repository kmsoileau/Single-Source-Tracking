package positronic.satisfiability.demos;

import positronic.satisfiability.elements.Disjunction;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Problem;

public class ConjunctionDemo2
{
  public static void main(String[] args) throws Exception
  {
    IProblem problem1 
    = new Disjunction(Problem.trivialProblem(),Problem.trivialProblem());
    System.out.println(problem1);
    IProblem problem2 
    = new Disjunction(Problem.trivialProblem(),Problem.unsolvableProblem());
    System.out.println(problem2);
    IProblem problem3 
    
    = new Disjunction(Problem.unsolvableProblem(),Problem.trivialProblem());
    System.out.println(problem3);
    IProblem problem4 
    = new Disjunction(Problem.unsolvableProblem(),Problem.unsolvableProblem());
    System.out.println(problem4);
  }
}
package positronic.satisfiability.demos.naturalnumberlist;

import positronic.satisfiability.naturalnumberlist.INaturalNumberList;
import positronic.satisfiability.naturalnumberlist.NaturalNumberList;
/**
 * <p>Title: NaturalNumberListDemo</p>
 * <p>Description: TBS</p>
 * <p>Copyright (c) 2005</p>
 * <p>Company: Positronic Software</p>
 * @author Kerry Michael Soileau
 * @version 1.0
 */

public class NaturalNumberListDemo
{
  public static void main(String[] args) throws Exception
  {
    long[] valueArray=new long[]
    {
      (long)4,(long)26,(long)11
    };

    INaturalNumberList n=new NaturalNumberList(valueArray);
    System.out.println(n);
  }
}
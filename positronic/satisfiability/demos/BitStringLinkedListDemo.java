package positronic.satisfiability.demos;

import positronic.satisfiability.bitstring.BitString;
import positronic.satisfiability.bitstring.IBitString;
import positronic.satisfiability.bitstringlist.BitStringLinkedList;
import positronic.satisfiability.bitstringlist.IBitStringList;

/**
 * <p>Title: BitStringLinkedListDemo</p>
 * <p>Description: This is a sample application showing the use of the 
 * BitStringLinkedList class.</p>
 * <p>Copyright (c) 2005</p>
 * <p>Company: Positronic Software</p>
 * @author Kerry Michael Soileau
 * @version 1.0
 */
public class BitStringLinkedListDemo
{
  public static void main(String[] args) throws Exception
  {
    IBitStringList s1=new BitStringLinkedList();
    System.out.println("s1.getName() = "+s1.getName());

    IBitStringList s2=new BitStringLinkedList("y",new boolean[][]
    {
      {true,false,true},
      {false,true,false,true},
      {true,false,false},
      {false,true,false}
    });
    System.out.println("s2.getName() = "+s2.getName());
    for(int i=0;i<s2.size();i++)
      System.out.println("s2.getBitString("+i+") = "+s2.getBitString(i));

    IBitStringList s3=new BitStringLinkedList("s3list",new IBitString[]
      {
        new BitString("001"),
        new BitString("010"),
        new BitString("110")
      });
    System.out.println("s3.getName() = "+s3.getName());
    for(int i=0;i<s3.size();i++)
      System.out.println("s3.getBitString("+i+") = "+s3.getBitString(i));

    IBitStringList s4=new BitStringLinkedList("s4list",new IBitString[]
      {
      });
    System.out.println("s4.getName() = "+s4.getName());
    System.out.println("s4.size() = "+s4.size());

    IBitStringList s5=new BitStringLinkedList("s5list",new IBitString[0]);
    System.out.println("s5.getName() = "+s5.getName());
    System.out.println("s5.size() = "+s5.size());

    IBitString s001=new BitString("001");
    IBitString s010=new BitString("010");
    IBitString s110=new BitString("110");
    IBitString s110x=s110;
    IBitString s001x=s001;
    IBitStringList s6=new BitStringLinkedList("s6list",new IBitString[]
      {
        s001,
        s110x,
        s001,
        new BitString(),
        s010,
        s001x,
        s110
      });
    System.out.println("s6.getName() = "+s6.getName());
    System.out.println("s6.size() = "+s6.size());
    for(int i=0;i<s6.size();i++)
      System.out.println("s6.getBitString("+i+") = "+s6.getBitString(i));
  }
}
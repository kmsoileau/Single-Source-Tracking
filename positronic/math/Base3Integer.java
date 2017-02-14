/**
 * <p>Title: TBS</p>
 * <p>Description: TBS</p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: Positronic Software</p>
 * @author Kerry Michael Soileau
 * @version 1.0
 */
package positronic.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

public class Base3Integer implements Cloneable
{
  public static void main(String[] args)
  {
    int minneg=Integer.MAX_VALUE;
    int maxpos=Integer.MIN_VALUE;
    int minind=-1;
    Base3Integer[] base3Integer1=new Base3Integer[8];
    for(int i=0;i<base3Integer1.length;i++)
      base3Integer1[i] = new Base3Integer();

    TwoWaySlidingTableOfIntegers tw=new TwoWaySlidingTableOfIntegers(base3Integer1.length,
      base3Integer1[0].contents.size());
    for(int i=0;i<base3Integer1.length;i++)
      for(int j=0;j<base3Integer1[i].contents.size();j++)
        tw.add(i,j,base3Integer1[i].getContents().get(j));

    System.out.println("Initial value of table...");
    System.out.println(tw.toString());

    //System.out.println("Analyzing 1/2 patterns...");
    //
    for(int i=0;i<tw.row.size();i++)
    {
      int anlyz=tw.analyze(i);
      if(anlyz<=0 && anlyz<minneg)
      {
        minneg=anlyz;
        minind=i;
      }
      if(anlyz>=0 && anlyz>maxpos)
      {
        maxpos=anlyz;
      }
    }


    //System.out.println("minneg="+minneg+"\t"+"maxpos="+maxpos);
    //System.out.println("minind="+minind+"\t"+"maxind="+maxind);

    //System.out.println("Revise each row so that 2 occurs at least as frequently as 1...");
    for(int i=0;i<tw.row.size();i++)
    {
      int anlyz=tw.analyze(i);
      if(anlyz>=0)
        tw.toggle(i);
    }

    minneg=Integer.MAX_VALUE;
    maxpos=Integer.MIN_VALUE;
    minind=-1;
    for(int i=0;i<tw.row.size();i++)
    {
      int anlyz=tw.analyze(i);
      System.out.println("anlyz="+anlyz);
      if(anlyz<=0 && anlyz<minneg)
      {
        minneg=anlyz;
        minind=i;
      }
      if(anlyz>=0 && anlyz>maxpos)
      {
        maxpos=anlyz;
      }
    }

    //System.out.println("minneg="+minneg+"\t"+"maxpos="+maxpos);
    //System.out.println("minind="+minind+"\t"+"maxind="+maxind);

    //System.out.println("Rep row is \n"+tw.getRow(minind).toString());

    for(int i=0;i<tw.getRow(minind).getEntry().size();i++)
    {
      if(tw.getRow(minind).getEntry().elementAt(i).compareTo("2")==0)
        tw.moveColumn(i,0);
    }

    Object[] objarr=tw.toObjectArray();
    Arrays.sort(objarr);

    TwoWaySlidingTableOfIntegers tw1=new TwoWaySlidingTableOfIntegers(objarr);
    System.out.println("Table dump after sort is \n"+tw1.toString());

    System.out.println("Now toggle every row whose first nonzero entry = 1");
    for(int i=0;i<tw1.row.size();i++)
    {
      //int val;

      for(int j=0;j<tw1.getRow(i).getEntry().size();j++)
      {
        String val=tw1.getRow(i).getEntry().elementAt(j);
        if(val.compareTo("2")==0)
          break;
        if(val.compareTo("1")==0)
        {
          tw1.toggle(i);
          break;
        }
      }
    }
    System.out.println("Table dump after toggle is \n"+tw1.toString());
    objarr=tw1.toObjectArray();
    Arrays.sort(objarr);
    TwoWaySlidingTableOfIntegers tw2=new TwoWaySlidingTableOfIntegers(objarr);
    System.out.println("Table dump after second sort is \n"+tw2.toString());
  }

  /*
  public Base3Integer(int n)
  {
    int sz=(int)(Math.log(Integer.MAX_VALUE)/Math.log(3)+1.)-1;
    if(n>=0)
    {
      contents=new ArrayList(sz);
      int md;
      int i=0;
      while(n>0 && contents.size()<sz)
      {
        md=n%3;
        contents.add(i,new Integer(md));
        n=(n-md)/3;
        i++;
      }
    }
    while(contents.size()<sz)
      contents.add(new Integer(0));
  }
  */

  private ArrayList<String> contents=new ArrayList<String>(0);

  public Base3Integer()
  {
    this(100);
  }

  public Base3Integer(int sz)
  {
    for(int i=0;i<sz;i++)
    {
      int md=(int)(3.*Math.random());
      contents.add(i,md+"");
    }
  }
  public ArrayList<String> getContents() {
    return contents;
  }
}

class Column extends Sequence implements Comparable<Object>
{
  public Column(int col)
  {
    super(col);
  }
}

class Row extends Sequence implements Comparable<Object>
{
  public Row(int row)
  {
    super(row);
  }

  public String toString()
  {
    String str="";
    for(int i=0;i<getEntry().size();i++)
    {
      String s=getEntry().get(i).toString();
      if(s.equals("2"))
        s="  2";
      if(s.equals("1"))
        s="  1";
      if(s.equals("0"))
        s="  0";
      str+=s;
    }
    return str;
  }
}

class Sequence implements Comparable<Object>
{
  private Vector<String> entry;

  public Sequence()
  {
    this(10);
  }

  public Sequence(int entries)
  {
    entry=new Vector<String>(entries);
    for(int i=0;i<entries;i++)
      entry.add(new String("$"));
  }

  public int compareTo(Object o)
  {
    Sequence oc=(Sequence)o;
    Vector<String> oce=oc.getEntry();
    Vector<String> thv=this.entry;
    int i=0;
    while(i<thv.size() && i<oce.size())
    {
      String cthis=(thv.elementAt(i));
      String co=oce.elementAt(i);
      if(cthis.compareTo(co)!=0)
        return cthis.compareTo(co);
      i++;
    }
    return 0;
  }

  public Vector<String> getEntry()
  {
    return this.entry;
  }

  public void setEntry(Vector<String> v)
  {
    this.entry=v;
  }
}

class TwoWaySlidingTable
{
  Vector<Column> column;
  Vector<Row> row;

	public TwoWaySlidingTable(int rows, int columns)
  {
    column=new Vector<Column>(columns);
    for(int i=0;i<columns;i++)
      column.addElement(new Column(rows));

    row=new Vector<Row>(rows);
    for(int i=0;i<rows;i++)
      row.addElement(new Row(columns));
  }

  public TwoWaySlidingTable(Row[] rws)
  {
    this(rws.length,((Row)(rws[0])).getEntry().size());
  }

  public void add(int rw, int cl, String o)
  {
    getRow(rw).getEntry().setElementAt(o,cl);
    getColumn(cl).getEntry().setElementAt(o,rw);
  }

  public Column getColumn(int col)
  {
    return ((Column)this.column.elementAt(col));
  }

  public Row getRow(int rw)
  {
    return ((Row)this.row.elementAt(rw));
  }

  public void moveColumn(int from, int to)
  {
    Column tbm=this.column.elementAt(from);
    this.column.removeElementAt(from);
    this.column.insertElementAt(tbm,to);

    for(int i=0;i<row.size();i++)
    {
      Vector<String> v=getRow(i).getEntry();
      String ofrom=v.elementAt(from);
      v.removeElementAt(from);
      v.insertElementAt(ofrom,to);
    }
  }

  public void moveRow(int from, int to)
  {
    Row tbm=getRow(from);
    this.row.removeElementAt(from);
    this.row.insertElementAt(tbm,to);

    for(int i=0;i<column.size();i++)
    {
      Vector<String> v=getColumn(i).getEntry();
      String ofrom=v.elementAt(from);
      v.removeElementAt(from);
      v.insertElementAt(ofrom,to);
    }
  }

  public Object[] toObjectArray()
  {
    Object[] ret=new Object[this.row.size()];
    for(int i=0;i<ret.length;i++)
      ret[i]=this.getRow(i);
    return ret;
  }

  public String toString()
  {
    String str="";
    for(int i=0;i<this.row.size();i++)
      str+=getRow(i).toString()+"\n";
    return str;
  }
}

class TwoWaySlidingTableOfIntegers extends TwoWaySlidingTable
{
  public TwoWaySlidingTableOfIntegers(int rows, int columns)
  {
    super(rows,columns);
  }

  public TwoWaySlidingTableOfIntegers(Object[] rws)
  {
    this(rws.length,((Row)(rws[0])).getEntry().size());
    for(int i=0;i<rws.length;i++)
      for(int j=0;j<((Row)(rws[0])).getEntry().size();j++)
        this.add(i,j,((Row)rws[i]).getEntry().elementAt(j));
  }

  public int analyze(int rw)
  {
    int minusOnes=countMinusOnes(rw);
    int plusOnes=countPlusOnes(rw);
    if(minusOnes<plusOnes)
    {
      return plusOnes;
    }
    else
      return -minusOnes;
  }

  public int countMinusOnes(int rw)
  {
    //Vector v=((Row)this.row.elementAt(rw)).getEntry();
    Vector<String> v=getRow(rw).getEntry();
    int tot=0;
    for(int i=0;i<v.size();i++)
    {
      //String obj=v.get(i);
      //int j=((Integer)obj).intValue();
      if(v.get(i).compareTo("2")==0)
        tot++;
    }
    return tot;
  }

  public int countPlusOnes(int rw)
  {
    Vector<String> v=getRow(rw).getEntry();
    int tot=0;
    for(int i=0;i<v.size();i++)
    {
      String obj=v.get(i);
      //int j=((Integer)obj).intValue();
      if(obj.compareTo("1")==0)
        tot++;
    }
    return tot;
  }

  public void toggle(int rw)
  {
  	Vector<String> v=getRow(rw).getEntry();
    for(int i=0;i<v.size();i++)
    {
      //Object obj=v.elementAt(i);
      //String nt=obj;
      /*int j=nt.intValue();
      if(j==0)
        nt="0";
      if(j==1)
        nt="2";
      if(j==2)
        nt="2";*/
      v.setElementAt(v.elementAt(i),i);
    }
  }

  public String toString()
  {
    String str="";
    for(int i=0;i<this.row.size();i++)
      str+=getRow(i).toString()+"\n";
    return str;
  }
}

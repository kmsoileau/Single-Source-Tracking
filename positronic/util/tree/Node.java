package positronic.util.tree;

import java.io.IOException;
import java.util.ArrayList;

public class Node 
{
	public static void main(String[] args) throws IOException
	{
		Node o1=new Node("root");
		Node o2=new Node("leaf");
		Node o3=new Node("interior node");
		Node o4=new Node("leaves1");
		Node o5=new Node("leaves2");
		
		Node main=new Node("root");
		main.addNode(o2);
		Node intNode=new Node("interior node");
		main.addNode(intNode);
		intNode.addNode(o4);
		intNode.addNode(o5);
		
		System.out.println(o1);
		System.out.println(o2);
		System.out.println(o3);
		System.out.println(o4);
		System.out.println(o5);
		
		System.out.println(main.containsNode(o1));
		System.out.println(main.containsNode(o2));
		System.out.println(main.containsNode(o3));
		System.out.println(main.containsNode(o4));
		System.out.println(main.containsNode(o5));
		
		System.out.println(main.containsNodeNamed("leaf"));
	}
	
	private ArrayList<Node> subNode;
	private String name;
	
	public Node(String string)
	{
		this.subNode=new ArrayList<Node>();
		this.name=string;
	}

	public void addNode(Node t)
	{
		if(this.containsNode(t)==null)
			getNodes().add(t);
	}

	public Node containsNodeNamed(String name)
	{
		if(getNodes().isEmpty())
			return null;
		for(Node nd : getNodes())
			if(name.compareTo(nd.name)==0)
				return this;
		for(Node t : getNodes())
			if(t.containsNodeNamed(name)!=null)
				return t;
		return null;
	}
	
	public Node containsNode(Node o)
	{
		if(getNodes().isEmpty())
			return null;
		if(this.getNodes().contains(o))
			return this;
		for(Node t : getNodes())
			if(t.containsNode(o)!=null)
				return t;
		return null;
	}
	
	public ArrayList<Node> getNodes() 
	{
		return subNode;
	}
	
	public String toString()
	{
		String ret="\n"+this.name;
		if(this.getNodes().size()>0)
			ret+="\n";
		for(Node n : this.getNodes())
			ret+="----$"+n.name+"\n";
		return ret;
	}
}

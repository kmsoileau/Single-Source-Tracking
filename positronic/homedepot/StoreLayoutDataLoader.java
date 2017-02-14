package positronic.homedepot;

import java.util.ArrayList;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import positronic.util.XMLDocument;

public class StoreLayoutDataLoader
{
	public static ArrayList<Item> readURL(String url)
	{
		try 
		{
			Document doc=new XMLDocument(url).getDocument();
			
			NodeList nlp=doc.getElementsByTagName("Product");
			NodeList nla=doc.getElementsByTagName("Aisle");
			
			String[][] s=new String[nlp.getLength()][2];
			
			for(int i=0;i<s.length;i++)
			{
				s[i][0]=nlp.item(i).getTextContent();
				s[i][1]=nla.item(i).getTextContent();
			}
			
			ArrayList<Item> ret=new ArrayList<Item>();
			for(int i=0;i<s.length;i++)
			{
				Item it=new Item();
				String[] si=s[i];
				it.item=si[0];
				it.location=si[1];
				ret.add(it);
			}
			return ret;
		} 
		catch (Exception e) 
		{
			return null;
		} 
	}
}
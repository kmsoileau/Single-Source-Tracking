package positronic.homedepot;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import positronic.util.XMLDocument;

public class DataReader 
{
	private XMLDocument doc;
	
	public DataReader(String str) throws SAXException, IOException, ParserConfigurationException 
	{
		doc=new XMLDocument(str);
	}

	public Document getDocument() 
	{
		return doc.getDocument();
	}
}
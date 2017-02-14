package positronic.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLDocument
{
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException
	{
		//URL url=new URL("http://www.kerrysoileau.com/test.xml");
		File url=new File("C:/Users/kerrysoileau/Desktop");
		DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
		DocumentBuilder db=dbf.newDocumentBuilder();
		Document doc=db.parse(url.toURI().toURL().openStream());

		System.out.println(doc);

		NodeList nodes_i = doc.getDocumentElement().getChildNodes();
		for (int i = 0; i < nodes_i.getLength(); i++) 
		{
			Node node_i = nodes_i.item(i);
			if (XMLDocument.isElementNode(node_i, "Item")) 
			{
				NodeList more_nodes=((Element)node_i).getChildNodes();
				for (int j = 0; j < more_nodes.getLength(); j++) 
				{
					Node node_j=more_nodes.item(j);
					if(XMLDocument.isElementNode(node_j, "Title"))
					{
						NodeList value = ((Element) node_j).getChildNodes();
						String textvalue = value.item(0).getTextContent();
						System.out.println(textvalue);
					}
					if(XMLDocument.isElementNode(node_j, "StartHour"))
					{
						NodeList value = ((Element) node_j).getChildNodes();
						String textvalue = value.item(0).getTextContent();
						System.out.println(textvalue);
					}
					if(XMLDocument.isElementNode(node_j, "EndMinute"))
					{
						NodeList value = ((Element) node_j).getChildNodes();
						String textvalue = value.item(0).getTextContent();
						System.out.println(textvalue);
					}
					if(XMLDocument.isElementNode(node_j, "EndHour"))
					{
						NodeList value = ((Element) node_j).getChildNodes();
						String textvalue = value.item(0).getTextContent();
						System.out.println(textvalue);
					}
					if(XMLDocument.isElementNode(node_j, "StartMinute"))
					{
						NodeList value = ((Element) node_j).getChildNodes();
						String textvalue = value.item(0).getTextContent();
						System.out.println(textvalue);
					}
					if(XMLDocument.isElementNode(node_j, "DateYear"))
					{
						NodeList value = ((Element) node_j).getChildNodes();
						String textvalue = value.item(0).getTextContent();
						System.out.println(textvalue);
					}
					if(XMLDocument.isElementNode(node_j, "DateMonth"))
					{
						NodeList value = ((Element) node_j).getChildNodes();
						String textvalue = value.item(0).getTextContent();
						System.out.println(textvalue);
					}
					if(XMLDocument.isElementNode(node_j, "DateDay"))
					{
						NodeList value = ((Element) node_j).getChildNodes();
						String textvalue = value.item(0).getTextContent();
						System.out.println(textvalue);
					}
					if(XMLDocument.isElementNode(node_j, "Location"))
					{
						NodeList value = ((Element) node_j).getChildNodes();
						String textvalue = value.item(0).getTextContent();
						System.out.println(textvalue);
					}
				}

			}
		}
	}

	public static boolean isElementNode(Node node, String str)
	{
		return node.getNodeType()==Node.ELEMENT_NODE
				&&((Element) node).getTagName().equals(str);
	}

	private static InputStream OpenHttpConnection(String urlString) throws MalformedURLException, IOException
	{
		InputStream in = null;
		URLConnection conn =new URL(urlString).openConnection();

		if(!(conn instanceof HttpURLConnection))
			throw new IOException("Not an HTTP connection");

		try
		{
			HttpURLConnection httpConn = (HttpURLConnection) conn;
			httpConn.setAllowUserInteraction(false);
			httpConn.setInstanceFollowRedirects(true);
			httpConn.setRequestMethod("GET");
			httpConn.connect();
			if (httpConn.getResponseCode()==HttpURLConnection.HTTP_OK) 
				in = httpConn.getInputStream();
		}
		catch (Exception ex)
		{
			throw new IOException("Error connecting");
		}
		return in;
	}
	private DocumentBuilderFactory builderFactory;
	private DocumentBuilder builder;

	private Document document;

	public XMLDocument(InputStream in) throws ParserConfigurationException, SAXException, IOException
	{
		this.builderFactory=DocumentBuilderFactory.newInstance();
		this.builder=this.builderFactory.newDocumentBuilder();
		this.document = builder.parse(in);
		in.close();
	}

	public XMLDocument(String urlString) throws ParserConfigurationException, SAXException, IOException
	{
		this(XMLDocument.OpenHttpConnection(urlString));
	}

	public Document getDocument()
	{
		return this.document;
	}
}
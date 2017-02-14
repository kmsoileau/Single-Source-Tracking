package positronic.util;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class BusStopReader 
{
	public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException
	{
		ArrayList<BusEvent> be=BusStopReader.readSchedule("http://www.kerrysoileau.com/bus/bus.xml");
		
		for(BusEvent curr : be)
			System.out.println("Bus "+curr.busName+" stops at "+curr.stopAddress+" ("+curr.latitude+","+curr.longitude+") at time "+curr.time+".");
	}
	
	public static ArrayList<BusEvent> readSchedule(String location) throws SAXException, IOException, ParserConfigurationException
	{
		XMLDocument x=new XMLDocument(location);
		Document document = x.getDocument();
		NodeList nodes_i = document.getDocumentElement().getChildNodes();
		ArrayList<BusEvent> res=new ArrayList<BusEvent>();
		for (int i = 0; i < nodes_i.getLength(); i++) 
		{
			Node node_i = nodes_i.item(i);
			if (node_i.getNodeType()==Node.ELEMENT_NODE
					&&((Element) node_i).getTagName().equals("bus")) 
			{
				Element bus = (Element) node_i;
				String busName=bus.getAttributes().getNamedItem("id").getNodeValue();
				NodeList nodes_j = bus.getChildNodes();
				for (int j = 0; j < nodes_j.getLength(); j++) 
				{
					Node node_j = nodes_j.item(j);
					if(node_j.getNodeType()!= Node.ELEMENT_NODE)
						continue;
					Element stop=(Element)node_j;
					String address=stop.getAttributes()
						.getNamedItem("address").getNodeValue();
					String latitude=stop.getAttributes()
						.getNamedItem("latitude").getNodeValue();
					String longitude=stop.getAttributes()
						.getNamedItem("longitude").getNodeValue();
					NodeList nodes_k = stop.getChildNodes();
					for (int k = 0; k < nodes_k.getLength(); k++)
					{
						Node node_k = nodes_k.item(k);
						if(node_k.getNodeType()!= Node.ELEMENT_NODE)
							continue;
						Element time=(Element)node_k;
						BusEvent curr=new BusEvent();
						curr.busName=busName;
						curr.latitude=latitude;
						curr.longitude=longitude;
						curr.stopAddress=address;
						curr.time=time.getAttributes()
							.getNamedItem("value").getNodeValue();
						res.add(curr);
						System.out.println("Bus "+curr.busName+" stops at "+curr.stopAddress+" ("+curr.latitude+","+curr.longitude+") at time "+curr.time+".");
					}
				}
			}
		}
		return res;
	}
}
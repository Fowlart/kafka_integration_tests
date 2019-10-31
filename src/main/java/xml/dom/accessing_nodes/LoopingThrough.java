package xml.dom.accessing_nodes;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;


public class LoopingThrough
{
	public static void main(String[] args)
	{
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = null;
		try
		{
			documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document document = documentBuilder.parse("example.xml");

			// The documentElement property of the XML document is the root node.
			Element root = document.getDocumentElement();

			// deleting unnecessary nodes
			for (int i = 0; i < root.getChildNodes().getLength(); i++)
			{
				Node element = root.getChildNodes().item(i);
				/** In this case Node.TEXT_NODE - is unnecessary text */
				if (element.getNodeType() == Node.TEXT_NODE)
				{
					root.removeChild(element);
				}
			}

			//process element nodes
			for (int i = 0; i < root.getChildNodes().getLength(); i++)
			{
				Node element = root.getChildNodes().item(i);
				System.out.println(element.getNodeType() + "/" + element.getNodeName()+": ");
				System.out.println(element.getTextContent());
			}
		}
		catch (ParserConfigurationException e)
		{
			e.printStackTrace();
		}
		catch (SAXException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

	}
}

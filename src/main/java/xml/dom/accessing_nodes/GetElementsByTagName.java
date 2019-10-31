package xml.dom.accessing_nodes;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;


public class GetElementsByTagName
{
	public static void main(String[] args)
	{
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = null;
		try
		{
			documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document document = documentBuilder.parse("example.xml");
			// The getElementsByTagName() method returns a node list. A node list is an array of nodes.
			String textContent = document.getElementsByTagName("CD").item(4).getTextContent();
			System.out.println(textContent);

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

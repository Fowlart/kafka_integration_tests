package xml.dom.accessing_nodes;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;


public class NavigatingNodeRelationships
{

	public static void main(String[] args)
	{
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = null;
		try
		{
			documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document document = documentBuilder.parse("example.xml");
			Element root = document.getDocumentElement();
			Node temp = null;

			for (int i = 0; i < root.getChildNodes().getLength(); i++)
			{
				//find first ELEMENT NODE
				if (root.getChildNodes().item(i).getNodeType() == Node.ELEMENT_NODE)
				{
					temp = root.getChildNodes().item(i);
					while (temp.getNextSibling() != null)
					{
						temp = temp.getNextSibling();
						System.out.println(temp.getTextContent());
					}
					break;
				}
			}
		}
		catch (Exception ex)
		{
		}
	}
}

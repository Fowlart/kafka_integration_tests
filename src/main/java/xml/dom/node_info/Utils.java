package xml.dom.node_info;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;


public class Utils
{
	private Node root;

	public Utils(String fileName) throws Exception
	{

		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
		Document document = documentBuilder.parse("xmls/example.xml");
		this.root = document.getDocumentElement();
		cleanFromUnnecessaryText(root);
	}

	public List<Node> getAllAttributeNodes(Node root)
	{
		List<Node> result = new ArrayList<>();
		for (int i = 0; i < root.getChildNodes().getLength(); i++)
		{
			Node temp = root.getChildNodes().item(i);

			if (temp.hasChildNodes())
			{
				result.addAll(getAllAttributeNodes(temp));
			}

			if (temp.getNodeType() == Node.ELEMENT_NODE)
			{
				if (temp.hasAttributes())
				{
					NamedNodeMap namedNodeMap = temp.getAttributes();
					// get first attribute from map
					Node attribute = namedNodeMap.item(0);
					result.add(attribute);
				}
			}
		}
		return result;
	}


	private void cleanFromUnnecessaryText(Node root)
	{
		List<Node> forRemove = new ArrayList<>();

		for (int i = 0; i < root.getChildNodes().getLength(); i++)
		{
			Node nodeForRemove = root.getChildNodes().item(i);
			if (nodeForRemove.getNodeType() == Node.TEXT_NODE)
			{
				forRemove.add(nodeForRemove);
			}
		}

		forRemove.stream().forEach(node -> root.removeChild(node));
	}

	public Node getRoot()
	{
		return root;
	}
}

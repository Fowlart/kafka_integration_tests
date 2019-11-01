package xml.dom.node_info;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;


public class CdCatalogTextCleaner
{
	private Node root;

	public CdCatalogTextCleaner(Node root)
	{
		this.root = root;
		cleanFromUnnecessaryText(root);
	}

	// checking
	public static void main(String[] args)
	{
		try
		{
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document document = documentBuilder.parse("xmls/example.xml");

			// The documentElement property of the XML document is the root node.
			Element root = document.getDocumentElement();
			CdCatalogTextCleaner cdCatalogTextCleaner = new CdCatalogTextCleaner(root);

			Node cleanRoot = cdCatalogTextCleaner.getRoot();

			for (int i = 0; i < cleanRoot.getChildNodes().getLength(); i++)
			{
			    System.out.println(cleanRoot.getChildNodes().item(i).getNodeName());
                System.out.println(cleanRoot.getChildNodes().item(i).getNodeType());
			}
		}
		catch (Exception ex)
		{
		}
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

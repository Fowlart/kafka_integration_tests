package xml.dom.node_info;

import org.w3c.dom.Node;


public class NodeInfo
{
	public static void main(String[] args)
	{
		Utils utils = null;
		try
		{
			utils = new Utils("xmls/example.xml");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		Node cleanRoot = utils.getRoot();

		//NodeValue for element nodes is undefined
		System.out.println("Printing properties for ELEMENT NODES:");
		for (int i = 0; i < cleanRoot.getChildNodes().getLength(); i++)
		{
			Node node = cleanRoot.getChildNodes().item(i);
			System.out.println(
					">NodeValue:" + node.getNodeValue() + ">>NodeName:" + node.getNodeName() + ">>>NodeType:" + node.getNodeType());

		}

		System.out.println("Printing properties for ATTRIBUTE NODES:");
		//NodeValue for attribute nodes is the attribute value, NodeName of an attribute node is the attribute name
		utils.getAllAttributeNodes(cleanRoot).stream().forEach(node -> System.out.println(
				">NodeValue:" + node.getNodeValue() + ">>NodeName:" + node.getNodeName() + ">>>NodeType:" + node.getNodeType()));



	}
}


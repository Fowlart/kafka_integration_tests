package xml.dom.node_info;

import org.w3c.dom.Node;
import xml.dom.Utils;


public class NodeInfo {
    public static void main(String[] args) {

        Utils utils = null;

        try {
            utils = new Utils("xmls/example.xml");
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        Node cleanRoot = utils.getClearRoot();

        System.out.println("\n" + "Printing properties for ELEMENT NODES:");

        for (int i = 0; i < cleanRoot.getChildNodes().getLength(); i++) {
            Node node = cleanRoot.getChildNodes().item(i);
            //NodeValue for ELEMENT nodes is undefined, nodeName of an ELEMENT node is the same as the tag name
            System.out.println(
                    ">NodeValue:" + node.getNodeValue() + ">>NodeName:" + node.getNodeName() + ">>>NodeType:"
                            + node.getNodeType());
        }

        //NodeValue for ATTRIBUTE nodes is the attribute value, NodeName of an ATTRIBUTE node is the attribute name
        System.out.println("\n" + "Printing properties for ATTRIBUTE NODES:");
        utils.getAllAttributeNodes(cleanRoot).stream().forEach(node -> System.out.println(
                ">NodeValue:" + node.getNodeValue() + ">>NodeName:" + node.getNodeName() + ">>>NodeType:" + node.getNodeType()));

        //NodeValue for TEXT nodes is text itself, NodeName of an TEXT node is always the #text name
        System.out.println("\n" + "Printing properties for TEXT NODES:");
        utils.getTextList(cleanRoot).stream().forEach(node -> System.out.println(
                ">NodeValue:" + node.getNodeValue() + ">>NodeName:" + node.getNodeName() + ">>>NodeType:" + node.getNodeType()));

    }
}
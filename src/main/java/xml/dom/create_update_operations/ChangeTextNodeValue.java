package xml.dom.create_update_operations;


import org.w3c.dom.Node;
import xml.dom.Utils;

import java.util.List;

public class ChangeTextNodeValue {
    public static void main(String[] args) {
        try {
            Utils utils = new Utils("xmls/example.xml");

            List<Node> nodeList = utils.getElementsListByName("ARTIST");

            System.out.println(">>>Printing all artist: ");
            nodeList.stream().forEach(node -> System.out.println(node.getFirstChild().getNodeValue()));

            // Changing all
            nodeList.stream().forEach(node -> node.getFirstChild().setNodeValue("Artur"));

            System.out.println(">>>Printing again: ");
            nodeList.stream().forEach(node -> System.out.println(node.getFirstChild().getNodeValue()));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

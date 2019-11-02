package xml.dom;

import com.google.common.collect.Lists;
import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.ArrayList;
import java.util.List;


public class Utils {
    private Node root;
    private Document document;

    public Utils(String fileName) throws Exception {

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse("xmls/example.xml");
        this.document = document;
        this.root = document.getDocumentElement();
        cleanFromUnnecessaryText(root);
    }

    public List<Node> getAllAttributeNodes(Node root) {
        List<Node> result = new ArrayList<>();
        for (int i = 0; i < root.getChildNodes().getLength(); i++) {
            Node temp = root.getChildNodes().item(i);

            if (temp.hasChildNodes()) {
                result.addAll(getAllAttributeNodes(temp));
            }

            if (temp.getNodeType() == Node.ELEMENT_NODE) {
                if (temp.hasAttributes()) {
                    NamedNodeMap namedNodeMap = temp.getAttributes();
                    // get first attribute from map
                    Node attribute = namedNodeMap.item(0);
                    result.add(attribute);
                }
            }
        }
        return result;
    }


    private void cleanFromUnnecessaryText(Node root) {
        List<Node> forRemove = new ArrayList<>();

        for (int i = 0; i < root.getChildNodes().getLength(); i++) {
            Node nodeForRemove = root.getChildNodes().item(i);
            if (nodeForRemove.getNodeType() == Node.TEXT_NODE) {
                forRemove.add(nodeForRemove);
            }
        }

        forRemove.stream().forEach(node -> root.removeChild(node));
    }

    public Node getClearRoot() {
        return root;
    }


    public List<Text> getTextList(Node rootNode) {
        List<Text> result = Lists.newArrayList();
        NodeList listForFiler = rootNode.getChildNodes();
        int nodeListLenth = rootNode.getChildNodes().getLength();

        for (int i = 0; i < nodeListLenth; i++) {
            Node temp = listForFiler.item(i);
            if (temp.hasChildNodes()) result.addAll(getTextList(temp));
            else if (temp.getNodeType() == Node.TEXT_NODE) result.add((Text) temp);
        }
        return result;
    }

    public List<Node> getElementsListByName(String tagName) {
        List<Node> result = Lists.newArrayList();
        NodeList elements = root.getOwnerDocument().getElementsByTagName(tagName);
        for (int i = 0; i < elements.getLength(); i++) result.add(elements.item(i));
        return result;
    }

    public Document getDocument() {
        return document;
    }
}

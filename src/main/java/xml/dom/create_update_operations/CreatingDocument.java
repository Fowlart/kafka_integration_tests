package xml.dom.create_update_operations;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.Text;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class CreatingDocument {
    public static void main(String[] args) {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = null;
        try {
            documentBuilder = documentBuilderFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        Document newDocument = documentBuilder.newDocument();
        Node root = newDocument.createElement("Root");
        Node child = newDocument.createElement("Child");
        root.appendChild(child);
        Text text = newDocument.createTextNode("some text");
        child.appendChild(text);
        newDocument.appendChild(root);

        System.out.println(newDocument.getElementsByTagName("Child").item(0).getNodeName());
        System.out.println(newDocument.getElementsByTagName("Child").item(0).getFirstChild().getNodeValue());
    }
}

package xml.dom.node_list;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class DomNodeList {

    public static void main(String[] args) {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse("xmls/example.xml");
            NodeList artistsList = document.getElementsByTagName("ARTIST");
            System.out.println(artistsList.getLength());
        } catch (Exception ex) {
        }
    }
}
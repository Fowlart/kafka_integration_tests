package xml.dom;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

/**
 * The W3C Document Object Model (DOM) is a platform and language-neutral interface that allows programs and scripts to
 * dynamically access and update the content, structure, and style of a document.
 */

/* https://www.w3schools.com/xml/dom_intro.asp **/

public class DomParserBasics {

	public static void main(String[] args)
	{
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse("xmls/example.xml");
            

			// this code will retrieves all text content from first and second CD element
            System.out.println(document.getElementsByTagName("CD").item(0).getTextContent());


            //removing element
			Node root = document.getDocumentElement();
			System.out.println(root.getChildNodes().item(1).getTextContent());
			Node forRemove = root.getChildNodes().item(1);
			root.removeChild(forRemove);
			System.out.println(root.getChildNodes().item(1).getTextContent());


        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}
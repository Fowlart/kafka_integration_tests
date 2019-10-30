package xml.dom;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;


/**
 * The W3C Document Object Model (DOM) is a platform and language-neutral interface that allows programs and scripts to
 * dynamically access and update the content, structure, and style of a document.
 */
public class DomParser {

	public static void main(String[] args)
	{
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse("example.xml");

			// ROOT ELEMENT
			Element root = document.getDocumentElement();
			System.out.println(root.getNodeName());
			System.out.println(root.getNodeType());
			//	System.out.println(root.getTextContent());

			//WTF?
			Text first = (Text) root.getFirstChild();
			Text last = (Text) root.getLastChild();
			System.out.println("last_child_text:" + last.getWholeText());
			System.out.println("first_child_text:" + first.getWholeText());



			NodeList nList = root.getChildNodes();
			for (int temp = 0; temp < nList.getLength(); temp++)
			{
				Node node = nList.item(temp);
				if (node.getNodeType() == Node.ELEMENT_NODE)
				{
					System.out.println("______________________________");
					/**...an XML element is everything from (including) the element's start tag to (including) the element's end tag...*/

					// CD element
					Element element = (Element) node;
					System.out.println("element.getTagName(): " + element.getTagName());
					System.out.println("element.hasChildNodes(): " + element.hasChildNodes());
					System.out.println("element.getTextContent(): " + element.getTextContent());
					System.out.println("* * *");

					//TITLE element
					Node title = element.getElementsByTagName("TITLE").item(0);
					System.out.println(title.getNodeName());
					System.out.println(title.getTextContent());
					System.out.println(title.getNodeValue());
					System.out.println(title.getNodeType());
					System.out.println(title.hasChildNodes());
					System.out.println("* * *");

					// TEXT inside TITLE element
					Text text = (Text) title.getFirstChild();
					System.out.println(text.getWholeText());
					System.out.println(text.getNodeValue());
				}
			}
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
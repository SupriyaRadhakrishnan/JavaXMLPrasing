import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/*
 * Get Document Builder
 * get Document
 * normalize the xml structure
 * get all the elements by the tag name
 */
public class ParserDemo {

	public static void main(String[] args) {
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
			DocumentBuilder builder = dbf.newDocumentBuilder();
			Document document =  builder.parse(new File("laptop.xml"));
			
			document.getDocumentElement().normalize(); 
			NodeList laptoplist = document.getElementsByTagName("laptop");
			for(int i =0;i<laptoplist.getLength();i++)
			{
				Node laptop = laptoplist.item(i);
				
				if(laptop.getNodeType() == Node.ELEMENT_NODE)
				{
					Element laptopelement = (Element) laptop;
					System.out.println("Laptop name : " + laptopelement.getAttribute("name"));
					NodeList laptopchild = laptop.getChildNodes();
					
					for(int j =0;j<laptopchild.getLength();j++) {
						Node detail = laptopchild.item(j);
						if(detail.getNodeType() == Node.ELEMENT_NODE)
						{
							Element child = (Element) detail;
							System.out.println("Child Attibute : " + child.getTagName() + " : " + child.getAttribute("value"));
						}
					}
					
				}
					
			}
			
			
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block 
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		

	}

}

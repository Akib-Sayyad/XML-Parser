package com.dom.ex1;

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

public class ReadXMLDOM {
	// put the content in project docs folder
	private final static String fileName = "book.xml";
	
	public static String getElementValueByName(Element element, String name) {
		String value = null;
		if (name != null) {
			NodeList nodeList = element.getElementsByTagName(name);
			for (int i = 0; i < nodeList.getLength(); i++) {
				Node node = nodeList.item(i);
				if (node != null) {
					value = node.getTextContent();
				}
			}
		}
		return value;
	}
	
	public static void main(String[] args) {
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = null;
		try {
			// build DOM builder factory to craete document.
			builder = builderFactory.newDocumentBuilder();

			// parse XML files into DOM objects
			Document document = builder.parse(new File(fileName));

			// get Root Element for xml tree
			Element rootElement = document.getDocumentElement();

			// get childrens can be elements, comments, processing instructions,
			// characters etc,
			NodeList nodes = rootElement.getChildNodes();
			for (int i = 0; i < nodes.getLength(); i++) {
				Node node = nodes.item(i);

				// if node is an Element then process accordingly.
				if (node instanceof Element) {
					Element book = (Element) node;
					String title = book.getElementsByTagName("title").item(0).getTextContent();
					String author = book.getElementsByTagName("author").item(0).getTextContent();
					String isbn = book.getElementsByTagName("ISBN").item(0).getTextContent();
					String id = book.getAttribute("id");
					author = getElementValueByName(book, "author");
					System.out.println("id: " + id + "  , title: " + title + ", author: " + author + " , isbn:" + isbn);
					String nodeValue = book.getTextContent();

					// Attr attribute = child.getAttributeNode("id");
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

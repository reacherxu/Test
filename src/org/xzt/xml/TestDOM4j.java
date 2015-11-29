package org.xzt.xml;


import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class TestDOM4j {
	public static Document doc = null;
	public static void main(String[] args) {
		readXML();
	}

	private static void readXML() {
		SAXReader reader = new SAXReader();
		try {
			doc = reader.read("E:\\Coding\\xml\\example.xml");
			Element root = doc.getRootElement();
			listElement(root);
			Element node = root.element("ingredlist");
			test(node);
		} catch (DocumentException e) {
			e.printStackTrace();
		} 
	}

	private static void test(Element root) {
		@SuppressWarnings("unchecked")
		List<Element> elems = root.elements();
		for (Iterator<Element> iterator = elems.iterator(); iterator.hasNext();) {
			Element ele = (Element) iterator.next();
			System.out.println(ele.getName());
		}
	}

	//遍历
	private static void listElement(Element elem) {
		System.out.print(elem.getName() + "\t");
		
		@SuppressWarnings("unchecked")
		List<Attribute> attr = elem.attributes();
		if( !elem.getTextTrim().equals("") )
			System.out.print(elem.getTextTrim() + "\t");
		for (Attribute attribute : attr) {
			System.out.print(attribute.getName() + ":" + attribute.getValue() + "\t" );
		}
		System.out.println();
		for (@SuppressWarnings("unchecked")
		Iterator<Element> it = elem.elementIterator(); it.hasNext();) {
			Element node = (Element) it.next();
			listElement(node);
		}
	}
}

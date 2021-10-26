package com.dsg.framework.xml;

import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class XMLHelperMethods {

  public static Document getXMLDocument(String xmlFilePath) throws Exception {

    Document doc;

    try {
      File xmlFile = new File(xmlFilePath);
      DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
      DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
      doc = dBuilder.parse(xmlFile);
      doc.getDocumentElement().normalize();
      return doc;
    } catch (Exception e) {
      throw new Exception("Error in getXMLDocument() for ".concat(xmlFilePath), e);
    }
  }
}

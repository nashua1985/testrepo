package com.dsg.framework.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class XMLUrl {

  public static final String URLS_PATH = "properties/urls.xml";

  private static HashMap<String, String> xmlList;

  public XMLUrl(String xmlFilePath) throws Exception {
    xmlList = this.getXMLList(xmlFilePath);
  }

  public String getURL(String urlName) {
    // System.out.println("Requested Value: " + application + ": " + xmlList.get(application));
    return xmlList.get(urlName);
  }

  public static ArrayList<String> getNodeNames(String xmlFilePath) {
    ArrayList<String> nodeNames = new ArrayList<>();
    try {
      Document doc;
      File xmlFile = new File(xmlFilePath);
      DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
      DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
      doc = dBuilder.parse(xmlFile);
      doc.getDocumentElement().normalize();

      NodeList nodes = doc.getElementsByTagName("*");
      for (int i = 0; i < nodes.getLength(); i++) {
        // System.out.println("name is : " + nodes.item(i).getNodeName());
        nodeNames.add(nodes.item(i).getNodeName());
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

    return nodeNames;
  }

  private HashMap<String, String> getXMLList(String xmlFilePath) throws Exception {

    Document doc = XMLHelperMethods.getXMLDocument(xmlFilePath);

    HashMap<String, String> valueList = new HashMap<>();
    ArrayList<String> nodeNames = getNodeNames(xmlFilePath);

    for (String nodeString : nodeNames) {
      NodeList nodeList = doc.getElementsByTagName(nodeString);

      for (int i = 0; i < nodeList.getLength(); i++) {

        Node node = nodeList.item(i);

        if (node.getNodeType() == Node.ELEMENT_NODE) {

          Element element = (Element) node;

          String value = element.getAttribute("value");

          valueList.put(nodeString, value);

        } else {
          throw new Exception("No data found in: " + xmlFilePath);
        }
      }
    }
    return valueList;
  }
}

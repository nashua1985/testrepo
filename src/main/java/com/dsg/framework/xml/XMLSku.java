package com.dsg.framework.xml;

import com.dsg.framework.entities.SKU;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class XMLSku {

  public static ArrayList<SKU> getSKUListWithProperties(String xmlFilePath) {

    ArrayList<SKU> returnSkus = new ArrayList<>();

    try {
      Document doc;
      File xmlFile = new File(xmlFilePath);
      DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
      DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
      doc = dBuilder.parse(xmlFile);
      doc.getDocumentElement().normalize();

      NodeList skus = doc.getElementsByTagName("Sku");

      for (int i = 0; i < skus.getLength(); i++) {

        SKU skudto = new SKU();
        HashMap<String, String> skuProps = new HashMap<>();

        Node node = skus.item(i);

        if (node.getNodeType() == Node.ELEMENT_NODE) {

          Element element = (Element) node;

          skudto.setSkuNumber(element.getAttribute("value"));

          NodeList props = element.getChildNodes();

          for (int x = 0; x < props.getLength(); x++) {
            Node pnode = props.item(x);

            if (pnode.getNodeType() == Node.ELEMENT_NODE) {
              Element pelement = (Element) pnode;

              skuProps.put(pelement.getNodeName(), pelement.getAttribute("value"));
            }
          }
        }
        skudto.setSkuProperties(skuProps);
        returnSkus.add(skudto);
      }
      /* Node pathNode = pathXML.item(0);
      Element element = (Element) pathNode;
      returnPath = element.getAttribute("value");

      System.out.println("Requested property " + property + ": " + returnPath);*/
    } catch (Exception e) {
      e.printStackTrace();
    }

    return returnSkus;
  }
}

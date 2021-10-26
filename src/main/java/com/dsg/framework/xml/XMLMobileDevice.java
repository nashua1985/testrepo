package com.dsg.framework.xml;

import com.dsg.framework.entities.MobileDevice;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.HashMap;

public class XMLMobileDevice {

  public static final String MOBILE_DEVICE_PATH = "../properties/MobileDevices.xml";

  private final HashMap<String, MobileDevice> devices;

  public XMLMobileDevice(String xmlFilePath) throws Exception {

    devices = this.getDeviceLibrary(xmlFilePath);
  }

  public MobileDevice getMobileDevice(String deviceID) throws Exception {

    try {

      MobileDevice device = devices.get(deviceID);

      if (device == null) {
        throw new Exception("getMobileDeviceData: Device data not found for ID " + deviceID);
      } else {
        return new MobileDevice(device);
      }

    } catch (Exception e) {
      throw new Exception("getMobileDeviceData: Device data not found for ID " + deviceID);
    }
  }

  private HashMap<String, MobileDevice> getDeviceLibrary(String xmlFilePath) throws Exception {

    Document doc = XMLHelperMethods.getXMLDocument(xmlFilePath);

    HashMap<String, MobileDevice> mobileDevices = new HashMap<String, MobileDevice>();

    NodeList nodeList = doc.getElementsByTagName("MobileDevice");

    for (int i = 0; i < nodeList.getLength(); i++) {

      Node node = nodeList.item(i);

      if (node.getNodeType() == Node.ELEMENT_NODE) {

        Element element = (Element) node;

        String id = element.getAttribute("id");
        String type = element.getAttribute("type");
        String deviceName = element.getAttribute("deviceName");
        String platformName = element.getAttribute("platformName");
        String platformVersion = element.getAttribute("platformVersion");
        String appPackage = element.getAttribute("appPackage");
        String appActivity = element.getAttribute("appActivity");
        String url = element.getAttribute("url");

        mobileDevices.put(
            id,
            new MobileDevice(
                id, type, deviceName, platformName, platformVersion, appPackage, appActivity, url));

      } else {
        throw new Exception("getMobileDeviceData: Mobile Device data not found in " + xmlFilePath);
      }
    }

    if (mobileDevices.isEmpty()) {

      throw new Exception("getMobileDeviceLibrary: No Data Found in " + xmlFilePath);

    } else {
      return mobileDevices;
    }
  }
}

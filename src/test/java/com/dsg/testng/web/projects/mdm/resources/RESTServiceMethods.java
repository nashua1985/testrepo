package com.dsg.testng.web.projects.mdm.resources;

import org.json.JSONArray;
import org.json.JSONObject;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class RESTServiceMethods {

  public int mdmSkuDataAPITest(String sku, String attrID, String expectedVal) {
    int result = 99;
    try {
      URL url =
          new URL(
              "https://productcatalog-api-stg.apps.vn01.pcf.dcsg.com/pc-mdmskudata/_search?default_operator=AND&q=Sku:"
                  + sku
                  + "%20AND%20AttrID:"
                  + attrID);
      HttpURLConnection conn = (HttpURLConnection) url.openConnection();
      conn.setRequestMethod("GET");
      // conn.setRequestProperty("Accept", "application/json");
      if (conn.getResponseCode() != 200) {
        throw new RuntimeException(" HTTP error code : " + conn.getResponseCode());
      }
      Scanner scan = new Scanner(url.openStream());
      String entireResponse = new String();
      while (scan.hasNext()) {
        String temp = scan.nextLine();
        // System.out.println(temp);
        entireResponse += temp;
      }

      // System.out.println("Response : " + entireResponse);
      scan.close();

      JSONObject obj = new JSONObject(entireResponse);
      System.out.println(obj.toString(4));

      System.out.println("Did i time out? : " + obj.get("timed_out").toString());

      JSONObject checkResults = obj.getJSONObject("hits");
      String total = checkResults.get("total").toString();

      // System.out.println("TOTAL HITS: " + checkResults.get("total").toString());
      System.out.println("TOTAL HITS: " + total);

      // check to make sure query returned something
      if (!total.equals("0")) {
        JSONArray arr = obj.getJSONObject("hits").getJSONArray("hits");

        // array appears to be only one element
        JSONObject source = (JSONObject) arr.getJSONObject(0).get("_source");
        String value = source.get("Value").toString();
        // System.out.println("Value: " + source.get("Value"));
        System.out.println("Value: " + value);
        if (value.equals(expectedVal)) {
          result = 1;
          System.out.println("SKU PASSED");
        } else {
          System.out.println("SKU FAILED");
          result = 0;
        }
      } else {
        System.out.println("SKU did not return any results.");
        result = 2;
      }

      /*for (int i = 0; i < arr.length(); i++)
      {
          //System.out.println("TEST : " + i + arr.getJSONObject(i));
          //System.out.println("Source " + arr.getJSONObject(i).get("_source"));
          JSONObject source = (JSONObject) arr.getJSONObject(i).get("_source");
          System.out.println("Value: " + source.get("Value"));
      }*/

    } catch (Exception e) {
      e.printStackTrace();
    }

    // 0 = fail | 1 = pass | 2 = not found
    return result;
  }
}

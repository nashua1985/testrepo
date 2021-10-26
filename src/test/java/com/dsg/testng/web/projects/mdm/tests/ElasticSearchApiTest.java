package com.dsg.testng.web.projects.mdm.tests;

import com.dsg.framework.enums.RunType;
import com.dsg.testng.basetest.WebDriverBaseTest;
import com.dsg.framework.enums.Browser;
import com.dsg.testng.web.projects.mdm.resources.RESTServiceMethods;
import com.dsg.testng.web.resources.WebNavigation;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class ElasticSearchApiTest extends WebDriverBaseTest {

  @Test(dataProvider = "localBrowsers") // "sauceBrowsers")
  public void elasticSearchAPITest(Browser browser, RunType runType) throws Exception {

    this.createDriver(browser, "elasticSearchAPITest", runType);

    WebNavigation nav = getWebNavigation();
    // Navigation nav = new Navigation(false);
    RESTServiceMethods rest = new RESTServiceMethods();
    ArrayList<String[]> skus = nav.readFromFileWithSeperator("./properties/MDMSkuService.txt", ",");
    ArrayList<String[]> failures = new ArrayList<String[]>();
    ArrayList<String[]> notFound = new ArrayList<String[]>();

    for (String[] sku : skus) {
      if (rest.mdmSkuDataAPITest(sku[0], sku[1], sku[2]) == 0) {
        failures.add(sku);
      }
      if (rest.mdmSkuDataAPITest(sku[0], sku[1], sku[2]) == 2) {
        notFound.add(sku);
      }
    }

    System.out.println("\nSummary: ");
    System.out.println("Total: " + skus.size());
    System.out.println("Passes: " + (skus.size() - failures.size()));
    System.out.println("Total Failures: " + (failures.size() + notFound.size()));
    System.out.println("Failures: " + failures.size());
    System.out.println("Not Found: " + notFound.size());

    if (failures.size() > 0) {
      System.out.println("\nFailed SKUs: ");
      for (String[] sku : failures) {
        System.out.println(sku[0] + "," + sku[1] + "," + sku[2] + "," + sku[3] + "," + sku[4]);
      }
    }

    if (notFound.size() > 0) {
      System.out.println("\nNot Found SKUs: ");
      for (String[] sku : notFound) {
        System.out.println(sku[0] + "," + sku[1] + "," + sku[2] + "," + sku[3] + "," + sku[4]);
      }
    }
  }
}

package com.dsg.testng.web.projects.dsg_prod.tests;

import com.dsg.testng.basetest.WebDriverBaseTest;
import org.junit.Test;

import java.time.LocalDateTime;

// not updated for new framework

public class TestRunner extends WebDriverBaseTest {

  private static final LocalDateTime NOW = LocalDateTime.now();
  static String buildName;

  @Test
  public void test() {
    int testsToRun = 1;

    if (testsToRun == 0) {
      String[] sportsArray = {"Bowling", "Soccer"};
      for (int i = 0; i < sportsArray.length; i++) {
        // TopNavTest.topNavTest(sportsArray[i]);

      }
    }

    if (testsToRun == 1) {

      buildName = "TopNavTest_" + NOW;

      String[] browsers = {
        // "macOS 10.14,safari,latest",
        // "Windows 10,edge,latest",
        "Windows 10,chrome,latest", "Windows 10,microsoftedge,latest", "Windows 10,chrome,latest"
        // "Windows 10,firefox,latest"
      };
      for (int x = 0; x < browsers.length; x++) {
        String[] temp = browsers[x].split(",");

        String[] sportsArray = {"Bowling", "Soccer", "Football"};
        for (int i = 0; i < sportsArray.length; i++) {
          // navigation.initSauceLabsWithParams(temp[0], temp[1], temp[2], buildName);
          // TopNavTest.topNavTest(sportsArray[i]);
          // TopNavTest.topNavTestSauceLabs(sportsArray[i]);
          /*if(i == sportsArray.length-1)
          {
          	i = 0;
          }*/
        }
      }
    }

    if (testsToRun == 2) {

      // String [] searchCategory = {"golf balls", "hat"};
      String[] searchCategory = {
        "North Face",
        "hydro flask",
        "project rock",
        "yeti",
        "football cleats",
        "baseball cleats",
        "treadmill",
        "calia",
        "brooks womens",
        "nike womens"
      };
      for (int i = 0; i < searchCategory.length; i++) {
        System.out.println("Checking: " + searchCategory[i]);
        // SearchTest.searchTest(searchCategory[i]);
      }
    }

    if (testsToRun == 3) {

      buildName = "SearchTest_" + NOW;

      String[] browsers = {
        "macOS 10.14,safari,latest", "Windows 10,chrome,latest", "Windows 10,firefox,latest"
      };
      for (int x = 0; x < browsers.length; x++) {
        String[] temp = browsers[x].split(",");

        String[] sportsArray = {"Bowling", "Soccer"};
        for (int i = 0; i < sportsArray.length; i++) {
          // DriverManager.initSauceLabsWithParams(temp[0], temp[1], temp[2], buildName);
          System.out.println("Checking: " + sportsArray[i]);
          // SearchTest.searchTestSauceLabs(sportsArray[i]);
          /*if(i == sportsArray.length-1)
          {
              i = 0;
          }*/
        }
      }
    }
  }
}

package com.dsg.testng.web.projects.hr.resources;

import com.dsg.testng.basetest.WebDriverBaseTest;
import com.dsg.testng.web.resources.WebNavigation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HRHelperMethods extends WebDriverBaseTest {

  static WebNavigation nav;

  public HRHelperMethods() {
    nav = getWebNavigation();
  }

  public String[] readIDsFromFile(String filePath) {
    ArrayList<String> ids = new ArrayList<String>();

    System.out.println("Retreiving IDs...");

    try {

      BufferedReader br = new BufferedReader(new FileReader(filePath));
      String line = br.readLine();
      while (line != null) {
        if (line.lastIndexOf(',') != -1) {
          line = line.substring(0, line.length() - 1);
        }
        ids.add(line);
        line = br.readLine();
      }

      br.close();

    } catch (IOException e) {

      e.printStackTrace();
    }

    String[] idArray = new String[ids.size() - 1];

    System.out.println("IDs:");

    for (int i = 0; i < ids.size() - 1; i++) {
      System.out.println(ids.get(i));
      idArray[i] = ids.get(i);
    }
    return idArray;
  }

  public void clickTile(String tileToClick) {
    // List<WebElement> tiles = DriverManager.getDriver().findElements(By.xpath("//*[contains(@id,
    // 'PTNUI_LAND_REC_GROUPLET_LBL')]"));
    List<WebElement> tiles =
        getRemoteWebDriver()
            .findElements(By.xpath("//*[contains(@id, 'PTNUI_LAND_REC_GROUPLET_LBL')]"));

    HashMap<String, WebElement> tileMap = new HashMap<String, WebElement>();

    for (WebElement tile : tiles) {
      // nav.Print("ID " + tile.getAttribute("id") + " Text: " + tile.getText());
      nav.Print("ID " + tile.getAttribute("id") + " Text: " + tile.getAttribute("innerText"));
      tileMap.put(tile.getAttribute("innerText"), tile);
    }

    nav.ClickElement(tileMap.get(tileToClick));
  }
}

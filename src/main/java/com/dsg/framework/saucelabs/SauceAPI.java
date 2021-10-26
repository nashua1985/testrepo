package com.dsg.framework.saucelabs;

import com.dsg.framework.credentials.EagleCredential;
import com.dsg.framework.credentials.EagleEncryption;
import com.dsg.framework.properties.AutomationProperties;
import com.dsg.framework.properties.InitProperties;
import com.saucelabs.saucerest.SauceREST;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.HashMap;
import java.util.Map;

// import org.testng.ITestResult;
// import com.dsg.generateordertool.ObjectBin;

public class SauceAPI {

  // private static final LocalDateTime NOW = LocalDateTime.now();

  protected static boolean sauceEnabled;
  protected static String jobID;
  protected static SauceREST client;

  public SauceAPI(RemoteWebDriver driver, String str) {
    EagleCredential sauceCreds;

    try {
      AutomationProperties ap = InitProperties.setProperties();
      sauceCreds = EagleEncryption.decryptCredential(ap.getSauceEncryptedCredential());

    } catch (Exception e) {
      System.out.println("Unable to decrypt Sauce Credential");
      return;
    }

    jobID = ((RemoteWebDriver) driver).getSessionId().toString();
    client = new SauceREST(sauceCreds.getUserName(), sauceCreds.getPassword());
    sauceEnabled = true;

    Map<String, Object> updates = new HashMap<>();

    updates.put("name", str);

    client.updateJobInfo(jobID, updates);
  }

  /*public static void afterMethodSauceStatus(ObjectBin objectBin, ITestResult result)
  {
      try
      {
          objectBin.getSauceAPI().setStatus(result.isSuccess());
      } catch (Exception e)
      {
          System.out.println("ERROR: Problem updating status on SauceLabs");
      }
  }*/

  public static void afterMethodSauceStatus() {}

  public static String getSauceJobURL() {

    return "http://saucelabs.com/jobs/" + jobID;
  }

  public static void setStatus(boolean status) {
    if (!sauceEnabled) {
      return;
    }
    {
      Map<String, Object> updates = new HashMap<>();
      updates.put("passed", status);
      client.updateJobInfo(jobID, updates);
    }
  }

  /*public static void setSauceName(String name) {

      try
      {
          new SauceAPI(DriverManager.getDriver(), name);
      } catch (Exception e)
      {
          System.out.println("Unable to set Sauce Name");
          e.printStackTrace();
      }
  }*/

}

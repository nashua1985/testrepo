package com.dsg.framework.saucelabs;

import com.dsg.framework.credentials.EagleCredential;
import com.dsg.framework.credentials.EagleEncryption;
import com.saucelabs.saucerest.SauceREST;
import org.json.JSONException;

import java.util.HashMap;
import java.util.Map;

public class SauceMethods {

  private static SauceREST sauceClient;

  public SauceMethods(SauceREST sauceREST) {
    sauceClient = sauceREST;
  }

  public static void updateResults(boolean testResults, String sessionId) throws JSONException {
    Map<String, Object> updates = new HashMap<>();
    updates.put("passed", testResults);
    sauceClient.updateJobInfo(sessionId, updates);
  }

  public static SauceREST getSauceRest(String encryptedCreds) {
    EagleCredential sauceCreds = null;

    try {
      sauceCreds = EagleEncryption.decryptCredential(encryptedCreds);

    } catch (Exception e) {
      System.out.println("Unable to decrypt Sauce Credential");
      return null;
    }

    String user = sauceCreds.getUserName();
    String pw = sauceCreds.getPassword();
    return new SauceREST(user, pw);
  }

  public static String getSauceURLString(String encryptedCreds) {
    EagleCredential sauceCreds = null;

    try {
      sauceCreds = EagleEncryption.decryptCredential(encryptedCreds);

    } catch (Exception e) {
      System.out.println("Unable to decrypt Sauce Credential");
      return null;
    }

    String user = sauceCreds.getUserName();
    String pw = sauceCreds.getPassword();

    // return "http://" + user + ":" + pw + "@ondemand.saucelabs.com:80/wd/hub";
    return "http://" + user + ":" + pw + "@ondemand.us-west-1.saucelabs.com:80/wd/hub";
  }
}

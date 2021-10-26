package com.dsg.framework.credentials;

import com.dsg.framework.properties.AutomationProperties;
import com.dsg.framework.properties.InitProperties;

import java.io.IOException;

public class GenerateEncryptedCredentials {

  public static void main(String[] args) throws IOException {

    AutomationProperties ap = InitProperties.setProperties();
    String propPath = ap.getPropertiesDirectory();

    CredentialsManager.setCredentials(propPath);
  }
}

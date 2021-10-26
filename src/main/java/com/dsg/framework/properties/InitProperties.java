package com.dsg.framework.properties;

import java.io.IOException;

public class InitProperties {

  public static AutomationProperties setProperties() throws IOException {

    return new AutomationProperties(
        System.getProperty("user.home")
            + "/AutomationFramework/automationproperties/automation.properties");
  }

  public static AutomationProperties setPropertiesJenkins() throws IOException {

    return new AutomationProperties("/usr/local/automationproperties/automation.properties");
  }

  public static AutomationProperties setPropertiesGithub() throws IOException {

    return new AutomationProperties("./properties/automation.properties");
  }

  public static AutomationProperties setPropertiesJenkinsProd() throws IOException {

    return new AutomationProperties("/data02/opt/util/automations/automation.properties");
  }
}

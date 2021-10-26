package com.dsg.framework.credentials;

public class EagleCredential {

  private String username;
  private String password;

  public EagleCredential(String username, String password) {
    this.username = username;
    this.password = password;
  }

  public String getUserName() {
    return username;
  }

  public String getPassword() {
    return password;
  }
}

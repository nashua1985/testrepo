package com.dsg.framework.tools;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MailosaurEmailGenerator {

  private static final String EMAIL_DOMAIN = "@mailosaur.io";

  private static final String MOBILE = ".qcjskoxa";

  private static final Date DATE = new Date();

  public static String getEmail() {

    SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy_HHmmss");

    String NOW = formatter.format(DATE);

    String email = NOW + MOBILE + EMAIL_DOMAIN;

    // System.out.println(email);

    return email;
  }
}

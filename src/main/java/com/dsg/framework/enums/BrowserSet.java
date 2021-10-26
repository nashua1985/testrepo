package com.dsg.framework.enums;

public enum BrowserSet {
  CHROME_LAST2("Chrome-Last2", constants.CHROME_LAST2),
  CHROME_FOX_LATEST("Chrome-Fox-Latest", constants.CHROME_FOX_LATEST);

  protected final String displayName;
  protected final Object[][] browserObject;

  BrowserSet(String displayName, Object[][] browserObject) {
    this.displayName = displayName;
    this.browserObject = browserObject;
  }

  public String getDisplayName() {
    return displayName;
  }

  public Object[][] getBrowserObject() {
    return browserObject;
  }

  protected static class constants {

    public static final Object[][] CHROME_LAST2 =
        new Object[][] {
          new Object[] {Browser.CHROME_WIN, RunType.SAUCE},
          new Object[] {Browser.CHROME_WIN_OLD, RunType.SAUCE}
        };

    public static final Object[][] CHROME_FOX_LATEST =
        new Object[][] {
          new Object[] {Browser.FIREFOX_WIN, RunType.SAUCE},
          new Object[] {Browser.CHROME_WIN, RunType.SAUCE}
        };
  }
}

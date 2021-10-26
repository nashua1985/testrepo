package com.dsg.testng.web.projects.primo.resources;

public class FlagStyleSet {
  private String style;
  private String pack;
  private String hCase;
  private String hUnit;

  public FlagStyleSet(String style, String pack, String hCase, String hUnit) {
    this.style = style;
    this.pack = pack;
    this.hCase = hCase;
    this.hUnit = hUnit;
  }

  public FlagStyleSet() {}

  public String getStyle() {
    return style;
  }

  public void setStyle(String style) {
    this.style = style;
  }

  public String getPack() {
    return pack;
  }

  public void setPack(String pack) {
    this.pack = pack;
  }

  public String gethCase() {
    return hCase;
  }

  public void sethCase(String hCase) {
    this.hCase = hCase;
  }

  public String gethUnit() {
    return hUnit;
  }

  public void sethUnit(String hUnit) {
    this.hUnit = hUnit;
  }

  public String headerToString() {
    return style + " : " + pack + " : " + hCase + " : " + hUnit;
  }

  @Override
  public String toString() {
    return "style='"
        + style
        + '\''
        + ", pack='"
        + pack
        + '\''
        + ", hCase='"
        + hCase
        + '\''
        + ", hUnit='"
        + hUnit
        + '\'';
  }
}

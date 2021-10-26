package com.dsg.framework.entities;

import java.util.HashMap;

public class SKU {

  public String skuNumber;
  public HashMap<String, String> skuProperties;

  public String getSkuNumber() {
    return skuNumber;
  }

  public void setSkuNumber(String skuNumber) {
    this.skuNumber = skuNumber;
  }

  public HashMap<String, String> getSkuProperties() {
    return skuProperties;
  }

  public void setSkuProperties(HashMap<String, String> skuProperties) {
    this.skuProperties = skuProperties;
  }
}

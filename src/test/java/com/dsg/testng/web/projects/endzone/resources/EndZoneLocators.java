package com.dsg.testng.web.projects.endzone.resources;

import org.openqa.selenium.By;

public class EndZoneLocators {

  public static By associateNumber = By.cssSelector("[data-testid='associate-num']");
  public static By associatePin = By.cssSelector("[data-testid='associate-pin']");
  public static By loginSubmit = By.cssSelector("[data-testid='login-submit']");
  public static By scanItem = By.cssSelector("[id='scan']");
  public static By itemSubmit = By.cssSelector("[data-testid='submit']");
  public static By orderTotal = By.cssSelector("[data-testid='total']");
  public static By completeTransaction = By.cssSelector("[data-testid='complete-transaction']");
  public static By cashButton = By.cssSelector("[data-testid='cash-button']");
  public static By cashInput = By.cssSelector("[id='cash-input']");
  public static By cashEnterButton = By.cssSelector("[data-testid='cash-enter-button']");
  public static By newTransactionButton = By.cssSelector("[data-testid='new-transaction-button']");
  public static By closeRegisterButton = By.cssSelector("[data-testid='close-register']");
}

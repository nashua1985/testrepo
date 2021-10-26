package com.dsg.testng.web.locators;

import org.openqa.selenium.By;

public class DSGLocators {
  /** PLEASE USE A COMMENT TO DESCRIBE THE PAGE THE LOCATOR IS FOUND ON* */
  public static By TopNavButton = By.id("dropbtn");

  public static By TopNavButtonClick = By.id("nav-open-button");

  public static By SkuSearchBar =
      By.xpath(
          "//input[(@id='SimpleSearchForm_SearchTerm') and (@class = 'site-search wcs-search')]");
  public static By SkuSearchButton = By.id("submitButton_ACCE_Label");

  public static By AddToCart = By.id("add2CartBtn");

  public static By ContinueShopping = By.className("contShopping-btn");
  public static By ViewCart = By.id("viewCartpopupbtn");

  public static By Checkout = By.xpath("//*[@class = 'checkoutbtn primary-btn']");
  public static By GuestCheckout = By.xpath("//*[@title='Guest Checkout']");

  public static By ScoreCardText = By.id("scoreCard-reward1");
  public static By ScoreCardSubmit = By.id("score-card-apply-button-div");

  // Checkout Address Locators
  public static By AddNewAddress = By.id("Add_New_Addr_Box");

  public static By FirstName = By.id("firstName");
  public static By LastName = By.id("lastName");
  public static By AddressLine1 = By.id("WC__AddressEntryForm_FormInput_address1_1");
  public static By City = By.name("city");
  public static By State = By.id("WC__AddressEntryForm_FormInput_state_1SelectBoxItText");
  public static By Zip = By.name("zipCode");
  public static By Phone = By.xpath("//*[@for='phone']");
  public static By Email = By.id("email");
  public static By AddressSubmit = By.id("DSG_Add_Address_Submit");

  // Credit Card
  public static By Account = By.id("account");
  public static By Month = By.id("monthSelectBoxItText");
  public static By Year = By.id("yearSelectBoxItText");
  public static By Cvc = By.id("cc_cvc");

  public static By PaymentProcessing = By.id("paymentProcessing");

  // PRODUCTION LOCATORS
  // Production locators should begin with prefix PROD_

  public static By PROD_SkuSearchBar = By.name("search");
  public static By PROD_SkuSearchButton = By.xpath("//*[text()='search']");

  public static By PROD_AddToCart = By.id("add-to-cart");
  public static By PROD_ViewCart = By.id("in-your-cart");
  public static By PROD_GoToCart = By.xpath("//*[text()='GO TO CART']");
  public static By PROD_CartDetails = By.className("details-toggle-text");

  public static By PROD_CloseDetails = By.xpath("//*[@title = 'Close Details']");
  public static By PROD_UpdateQuantity = By.className("quantityInput");
  public static By PROD_CheckoutButton = By.xpath("//*[@class = 'checkoutbtn primary-btn']");

  public static By PROD_GuestCheckoutButton = By.xpath("//*[text() = 'Guest Checkout']");

  public static By PROD_ShoppingCartButton = By.xpath("//*[text() = 'shopping_cart']");
}

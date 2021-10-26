package com.dsg.cucumber.pages.cart;

import org.openqa.selenium.By;

public class CartPage {
    public static By cartIcon = By.className("cart-count-value");
    public static By itemsInYourCart = By.className("font-weight-normal");
    // top of cart page
    public static By productName = By.className("product-name");
    public static By originalPrice = By.className("product-price--original ng-star-inserted");
    public static By discountedPrice = By.className("product-price product-price--discounted");


    public static By productDetails = By.xpath("//strong[contains(text(), 'Details')]");
    public static By qty = By.xpath("//input[@aria-label='Quantity']");
    public static By productPrice = By.xpath("//span[@class='product-price ng-star-inserted']");
    public static By cartProductPrice = By.xpath("//p[@class='product-price']");

    public static By productOriginalPrice = By.xpath("//div[@class='price-list ng-star-inserted']");
    public static By cartDiscountedProductPrice = By.xpath("//p[@class='product-price product-price--discounted']");
    public static By cartStrikethrProductPrice = By.xpath("//span[contains(@class, 'product-price--original')]");
    public static By sortDropdown = By.xpath("//span[@class='rs-selected-sort-text']");
    public static By priceHighToLow = By.xpath("//div[contains(text(),'Price High to Low')]");
    public static By promoInfo = By.xpath("//i[@class='material-icons pl-2']");
    public static By ShippingpromoInfo = By.xpath("//p[contains(text(),'Free Shipping on Orders $65 or More! ')]/i[@class='material-icons line-item__icon ng-star-inserted']");
    public static By promoClose = By.xpath("//button[@class='btn btn-close']");
    public static By EstShipping = By.xpath("//p[@class='line-item__text line-item__text--price' and contains(text(),'6.99')]");
    public static By caliaPromoShip = By.xpath("//p[@class='line-item__text line-item__text--price line-item__text--promotion']");
    public static By storepickupShip = By.xpath("//p[@class='line-item__text line-item__text--price line-item__text--bold']");

    public static By deleteButton = By.xpath("//img[@class='delete-icon']");
    public static By cartProductNames = By.xpath("//p[@class='product-name']");

    public static By cartChangeStore = By.xpath("//button/span[contains(text(),'Change Store')]");
    public static By checkoutButton = By.xpath("//button[contains(text(),'Checkout')]");

}

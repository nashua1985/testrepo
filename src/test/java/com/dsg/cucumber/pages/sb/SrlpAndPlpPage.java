package com.dsg.cucumber.pages.sb;

import org.openqa.selenium.By;
import org.testng.log4testng.Logger;

public class SrlpAndPlpPage {
    private static final Logger logger = Logger.getLogger(SrlpAndPlpPage.class);
    public static By sortDropDown = By.xpath("//span[@class='rs-selected-sort-text']");
    public static By priceLowToHighOption = By.xpath("//div[text()='Price Low to High']");
    public static By priceHighToLowOption = By.xpath("//div[text()='Price High to Low']");
    public static By nonActive48View = By.xpath("//a[@class=' rs-page-count-item p-48 mobile-hide']");
    public static By active48View = By.xpath("//a[@class='active rs-page-count-item p-48 mobile-hide']");
    public static By nonActive96View = By.xpath("//a[@class=' rs-page-count-item p-96 mobile-hide']");
    public static By active96View = By.xpath("//a[@class='active rs-page-count-item p-96 mobile-hide']");
    public static By nonActive144View = By.xpath("//a[@class=' rs-page-count-item p-144 mobile-hide']");
    public static By active144View = By.xpath("//a[@class='active rs-page-count-item p-144 mobile-hide']");
    public static By pinnedItemsCount = By.xpath("//div[contains(@data-em, '_pinned')]");
    public static By shipToMeOption = By.xpath("//button[text()='Ship To Me']");
    public static By inStoreOption = By.xpath("//button[text()='In Store']");
    public static By addToCartButton = By.xpath("//span[text()=' ADD TO CART' or text()='ADD TO CART']");
}

package com.dsg.cucumber.pages.sb;

import org.openqa.selenium.By;
import org.testng.log4testng.Logger;

public class CategoriesPage {
    private static final Logger logger = Logger.getLogger(CategoriesPage.class);
// flyout categories
    //--SPORTS--
    public static final By BASEBALL = By.xpath("//a[text()='Baseball']");
    public static final By BASKETBALL = By.xpath("//a[text()='Basketball']");
    //--WOMEN--
    public static final By SHOP_ALL_WOMEN = By.xpath("//a[text()=\"Shop All Women's\"]");
    public static final By FOOTWEAR = By.xpath("//a[text()='Footwear']");

    //    Shop Departments>Sports Category
    public static By baseballSubCat = By.xpath("//strong[contains(text(), 'Baseball')]");
    public static By batsFam = By.xpath("//a[@href='/f/baseball-bats']");
    public static By basketballSubCat = By.xpath("//strong[contains(text(), 'Basketball')]");
//    public static By basketballFam = By.xpath("//a[@href='/f/basketballs']//strong[contains(text(), 'Basketball')]");
    public static By basketballFam = By.xpath("//a[@href='/f/basketballs']");

    public static By bikesSubCat = By.xpath("//strong[contains(text(), 'Bikes & Cycling')]");
    public static By bikesFam = By.xpath("//a[@href='/f/bikes']");

    public static By runningSubCat = By.xpath("//strong[contains(text(), 'Running')]");
    public static By runningShoesFam = By.xpath("//a[@href='/f/shop-running-shoes']");
//    Shop Departments>Women Category
    public static By womensFootwearSubCat = By.xpath("//strong[contains(text(), \"Women's Footwear\")]");
    public static By allWomensFootwearFam = By.xpath("//a[@href='/f/all-womens-footwear']");
    public static By womensTrendsSubCat = By.xpath("//strong[contains(text(), \"Women's Trends\")]");
    public static By vansFam = By.xpath("//a[@href='/f/shop-vans-footwear']");

    //______Mobile Page Objects_______//
    //    Shop Departments>Sports Category
    public static By baseballSubCatMobile = By.xpath("//a[@href='/c/baseball-equipment-gear']//*[text()='Baseball']");
    public static By basketballSubCatMobile = By.xpath("//a[@href='/c/basketball-gear']//*[text()='Basketball']");
    public static By bikesSubCatMobile = By.xpath("//a[@href='/c/bike-gear']//*[text()='Bikes & Cycling']");
    public static By bikesFamMobile = By.xpath("//strong[contains(text(), 'Bikes')]");

    //    Shop Departments>Women Category
    public static By womensFootwearSubCatMobile = By.xpath("//a[@href='/c/womens-footwear']//*[text()='Footwear']");
    public static By allWomensFootwearFamMobile = By.xpath("//a[@href='/f/all-womens-footwear']//span");

    public static By hyperCatTextLink = By.xpath("//p[@class='expansion-title' and text()='Featured Categories']");
}

package com.dsg.cucumber.pages.sb;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.testng.log4testng.Logger;

public class HomePage {
    private static final Logger logger = Logger.getLogger(HomePage.class);
    public static By searchTextBox = By.xpath("//input[@id='search-regular' or @id='SearchBoxText' or @id='searchInput']");
    public static By searchIcon = By.xpath("//*[text()='search' or @class='rh-icon-search-header' or @class='dsg-forward-logo']");
    public static By searchIconMobile = MobileBy.xpath("//*[text()='search' or @class='rh-icon-search-header' or @class='dsg-forward-logo']");
    public static By filterHyperText = By.xpath("//div[text()='FILTER']");
    public static By searchResultKeys = By.xpath("//div[@id='search-page']");
    public static By clearIcon = By.xpath("(//span[text()='Clear'])[1]");
//    public static By closePromoWindow = By.xpath("//div[@class='close']");
//    public static By closePromoWindow = By.xpath("//div[@class='default_dialog']//div[@class='close']");
    public static By closePromoWindow = By.xpath("//img[@alt='Close Modal']");


    public static By signInHomePage = By.xpath("//p[text()='My Account']");
    public static By emailLoginBox = By.id("email");
    public static By pswdLoginBox = By.id("signinPass");
    public static By signInBtn = By.xpath("//span[contains(text(), 'Sign In')]");
    public static By itemQuantityOnCart = By.id("OrderQty");
    public static By emailSignUpBox = By.id("email-signup");
    public static By emailSignUpBtn = By.xpath("//span[text()='Sign Up']");
    public static By findStoreLink = By.xpath("//span[text()='Find a Store']");


    //***Hamburger Categories
    public static By shopDepartments = By.xpath("//span[text()='Shop Departments']");
    public static By sportsCategory = By.xpath("(//*[text()='Sports' or text()='Shop By Sport'])[1]");
    public static By womenCategory = By.xpath("(//*[text()='Women'])[1]");
    public static By menCategory = By.xpath("(//*[text()='Men'])[1]");
    public static By kidsCategory = By.xpath("(//*[contains(text(), 'Kids')])[2]");
    public static By outerwearCategory = By.xpath("//span[text()='Outerwear Shop']");
    public static By fitnessExerciseEquipmentCategory = By.xpath("(//*[text()='Exercise & Wellness' or text()='Exercise and Wellness'])[1]");
    public static By outdoorGearCategory = By.xpath("(//*[text()='Outdoor & Recreation' or text()='Outdoor and Recreation'])[1]");
    public static By fanCategory = By.xpath("(//*[text()='Fan Shop'])[1]");
    public static By accessoriesElectronicsCategory = By.xpath("(//*[text()='Accessories'])[1]");
    public static By holidayGiftCategory = By.xpath("//span[text()='Holiday Gift Guide']");
    public static By holidayDealsCategory = By.xpath("//span[text()='Holiday Deals']");
    public static By topBrandsCategory = By.xpath("(//*[text()='Top Brands'])[1]");
    public static By clearanceCategory = By.xpath("(//*[text()='Clearance'])[1]");
    public static By clearAllLink = By.xpath("//a[text()='Clear All']");

//______Mobile Page Objects_______//
    public static By navMenu = By.xpath("//*[@id='nav-open-button']//span");
    public static By navMenu3= MobileBy.xpath("//*[@d='M3 18h18v-2H3v2zm0-5h18v-2H3v2zm0-7v2h18V6H3z']");
    public static By closeMenuBtn= MobileBy.xpath("//*[@d='M19 6.41L17.59 5 12 10.59 6.41 5 5 6.41 10.59 12 5 17.59 6.41 19 12 13.41 17.59 19 19 17.59 13.41 12z']");
    public static By navMenu2 = By.xpath("(//*[@d='M0 0h24v24H0z'])[1]");
    public static By suggestionSearchCloseIcon = By.xpath("//img[@class='close-button__icon dsg-mt-xs' and @alt='Close Menu']");

    public static By sportsCategoryM = By.xpath("//a[@href='/c/shop-by-sport' or @id='a_manin_nav/c/shop-by-sport']/span[text()='Sports']");
    public static By sportsCategoryViewAllM = By.xpath("//a[@href='/c/shop-by-sport']/span[text()='View All']");
    public static By womenCategoryM = By.xpath("//a[@href='/c/shop-all-womens-apparel-footwear']/*[text()='Women']");
    public static By womenCategoryViewAllM = By.xpath("//a[@href='/c/shop-all-womens-apparel-footwear']/*[text()='View All']");
    public static By menCategoryM = By.xpath("//a[@href='/c/shop-all-mens-apparel-footwear']/*[text()='Men']");
    public static By menCategoryViewAllM = By.xpath("//a[@href='/c/shop-all-mens-apparel-footwear']/*[text()='View All']");
    public static By kidsCategoryM = By.xpath("//a[@href='/c/shop-all-kids-apparel-footwear']/*[text()=\"Kids'\"]");
    public static By kidsCategoryViewAllM = By.xpath("//a[@href='/c/shop-all-kids-apparel-footwear']/*[text()='View All']");
    public static By fitnessExerciseEquipmentCategoryM = By.xpath("//a[@href='/c/exercise-equipment']/*[text()='Exercise & Wellness']");
    public static By fitnessExerciseEquipmentCategoryViewAll = By.xpath("//a[@href='/c/exercise-equipment']/*[text()='View All']");
    public static By outdoorCategoryM = By.xpath("//a[@href='/c/outdoor-908551--1']/*[text()='Outdoor & Recreation']");
    public static By outdoorCategoryViewAllM = By.xpath("//a[@href='/c/outdoor-908551--1']/*[text()='View All']");
    public static By fanCategoryM = By.xpath("//a[@href='/c/fan-shop']/*[text()='Fan Shop']");
    public static By fanCategoryViewAllM = By.xpath("//a[@href='/c/fan-shop']//span[text()='View All']");
    public static By accessoriesElectronicsCategoryM = By.xpath("//a[@href='/c/all-accessories']/*[text()='Accessories']");
    public static By accessoriesElectronicsCategoryViewAll = By.xpath("//a[@href='/c/all-accessories']/*[text()='View All']");
    public static By topBrandsCategoryM = By.xpath("//a[@href='/s/shop-all-brands']/*[text()='Top Brands']");
    public static By topBrandsCategoryViewAllM = By.xpath("//a[@href='/s/shop-all-brands']/*[text()='View All']");
    public static By clearanceCategoryM = By.xpath("//a[@href='/c/clearance-apparel-gear-footwear']/*[text()='Clearance']");
    public static By clearanceViewAll = By.xpath("//a[@href='/c/clearance-apparel-gear-footwear']/*[text()='View All']");

    //AOS
    public static By storeNumberBox = By.name("storeNumber");
    public static By storeNumberSbmBtn = By.xpath("//button[text()='Submit']");


}

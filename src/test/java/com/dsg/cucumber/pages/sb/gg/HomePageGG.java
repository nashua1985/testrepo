package com.dsg.cucumber.pages.sb.gg;

import org.openqa.selenium.By;
import org.testng.log4testng.Logger;

public class HomePageGG {
    private static final Logger logger = Logger.getLogger(HomePageGG.class);
    //***Hamburger Categories
//    public static By clubsCategory = By.xpath("//a[@href='/f/golf-clubs-and-golf-club-sets']//span[text()='Clubs']");
    public static By clubsCategory = By.xpath("//span[text()='Clubs']");
    public static By apparelCategory = By.xpath("//span[text()='Apparel']");
    public static By mensGolfApparelSubCategory = By.xpath("//span[text()=\"Men's Golf Apparel\"]");
    public static By shirtsMensGolfApparelSubSubCategory = By.xpath("//p[contains(text(), 'Shirts')]");
    public static By footwearCategory = By.xpath("//span[text()='Footwear']");
    public static By mensGolfShoesSubCategory = By.xpath("//span[text()=\"Men's Golf Shoes\"]");

}

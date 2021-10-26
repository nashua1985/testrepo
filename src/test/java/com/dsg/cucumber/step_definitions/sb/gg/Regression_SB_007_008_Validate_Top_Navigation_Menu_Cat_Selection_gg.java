package com.dsg.cucumber.step_definitions.sb.gg;


import com.dsg.cucumber.config.Base;
import com.dsg.cucumber.framework.CommonElementMethods;
import com.dsg.cucumber.pages.sb.HomePage;
import com.dsg.cucumber.pages.sb.gg.HomePageGG;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.testng.Assert.assertTrue;

public class Regression_SB_007_008_Validate_Top_Navigation_Menu_Cat_Selection_gg {
    private static final Logger logger = Logger.getLogger(Regression_SB_007_008_Validate_Top_Navigation_Menu_Cat_Selection_gg.class);
    private static final Integer timeout = 10;
    private static final String GOLF_CLUBS_TITLES = "Golf Clubs | Best Price Guarantee at Golf Galaxy";
    private static final String MENS_SHIRTS_TITLES = "Golf Shirts For Men - Short & Long Sleeve Polos";
    private static final String MENS_GOLF_SHOES_TITLES = "Men's Golf Shoes";

    CommonElementMethods commonMethods= new CommonElementMethods();

    @When("we should see Top Navigation Menu and child submenu in gg")
    public void we_enter() throws Exception {
        commonMethods.clickWhenVisible(HomePage.shopDepartments,timeout);
        commonMethods.clickWhenVisible(HomePageGG.clubsCategory, timeout);
        assertTrue(Base.getDriver().getTitle().contains(GOLF_CLUBS_TITLES));

        commonMethods.clickWhenVisible(HomePage.shopDepartments,timeout);
        commonMethods.clickWhenVisible(HomePageGG.apparelCategory, timeout);
        commonMethods.clickWhenVisible(HomePageGG.mensGolfApparelSubCategory, timeout);
        commonMethods.clickWhenVisible(HomePageGG.shirtsMensGolfApparelSubSubCategory, timeout);
        assertTrue(Base.getDriver().getTitle().contains(MENS_SHIRTS_TITLES));

        commonMethods.clickWhenVisible(HomePage.shopDepartments,timeout);
        commonMethods.clickWhenVisible(HomePageGG.footwearCategory, timeout);
        commonMethods.clickWhenVisible(HomePageGG.mensGolfShoesSubCategory, timeout);
        assertTrue(Base.getDriver().getTitle().contains(MENS_GOLF_SHOES_TITLES));
    }
}


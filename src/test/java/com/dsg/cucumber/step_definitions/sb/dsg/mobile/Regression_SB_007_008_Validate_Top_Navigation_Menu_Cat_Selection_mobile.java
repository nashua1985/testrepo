package com.dsg.cucumber.step_definitions.sb.dsg.mobile;


import com.dsg.cucumber.config.Base;
import com.dsg.cucumber.framework.CommonElementMethods;
import com.dsg.cucumber.pages.sb.HomePage;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;

import static org.testng.Assert.assertTrue;

public class Regression_SB_007_008_Validate_Top_Navigation_Menu_Cat_Selection_mobile {
    private static final Logger logger = Logger.getLogger(Regression_SB_007_008_Validate_Top_Navigation_Menu_Cat_Selection_mobile.class);
    private static final Integer timeout = 10;
    private static final String METHOD_NAME = "validateTopNavigationMenu";
    private static final String SPORT_CAT_TITLE = "Sports Equipment for Team Sports";
    private static final String WOMEN_CAT_TITLE = "Shop Women's";
    private static final String MEN_CAT_TITLE = "Shop Men's";
    private static final String KIDS_CAT_TITLE = "Shop Kids";
    private static final String OUTERWEAR_CAT_TITLE = "Outerwear Shop";
    private static final String FITNESS_EXERCISE_EQUIPMENT_CAT_TITLE = "Fitness & Exercise Equipment";
    private static final String OUTDOOR_GEAR_CAT_TITLE = "Outdoor Gear & Outdoor Sports Store";
    private static final String FAN_CAT_TITLE = "Fan Shop";
    private static final String ACCESSORIES_ELECTRONICS_CAT_TITLE = "Accessories & Electronics";
    private static final String HOLIDAY_GIFT_CAT_TITLE = "Holiday Gift Shop";
    private static final String HOLIDAY_DEALS_CAT_TITLE = "DICK'S Sporting Goods Black Friday Deals 2020";
    private static final String TOP_BRANDS_CAT_TITLE = "Shop All Brands";
    private static final String CLEARANCE_CAT_TITLE = "Clearance Sports Apparel, Footwear & Gear";
    CommonElementMethods commonMethods= new CommonElementMethods();

    @When("we should see Top Navigation Menu and child submenu on mobile")
    public void we_enter() throws Exception {
        commonMethods.clickWhenVisible(HomePage.navMenu, timeout);
        commonMethods.clickWhenVisible(HomePage.sportsCategoryM,timeout);
        commonMethods.clickWhenVisible(HomePage.sportsCategoryViewAllM,timeout);
        Thread.sleep(8000);
        assertTrue(Base.getDriver().getTitle().contains(SPORT_CAT_TITLE));

        commonMethods.clickWhenVisible(HomePage.navMenu, timeout);
        commonMethods.clickWhenVisible(HomePage.womenCategoryM,timeout);
        commonMethods.clickWhenVisible(HomePage.womenCategoryViewAllM,timeout);
        Thread.sleep(8000);
        assertTrue(Base.getDriver().getTitle().contains(WOMEN_CAT_TITLE));

        commonMethods.clickWhenVisible(HomePage.navMenu, timeout);
        commonMethods.clickWhenVisible(HomePage.menCategoryM,timeout);
        commonMethods.clickWhenVisible(HomePage.menCategoryViewAllM,timeout);
        Thread.sleep(8000);
        assertTrue(Base.getDriver().getTitle().contains(MEN_CAT_TITLE));

        commonMethods.clickWhenVisible(HomePage.navMenu, timeout);
        commonMethods.clickWhenVisible(HomePage.kidsCategoryM,timeout);
        commonMethods.clickWhenVisible(HomePage.kidsCategoryViewAllM,timeout);
        Thread.sleep(8000);
        assertTrue(Base.getDriver().getTitle().contains(KIDS_CAT_TITLE));

        commonMethods.clickWhenVisible(HomePage.navMenu, timeout);
        commonMethods.clickWhenVisible(HomePage.fitnessExerciseEquipmentCategoryM,timeout);
        commonMethods.clickWhenVisible(HomePage.fitnessExerciseEquipmentCategoryViewAll,timeout);
        Thread.sleep(8000);
        assertTrue(Base.getDriver().getTitle().contains(FITNESS_EXERCISE_EQUIPMENT_CAT_TITLE));

        commonMethods.clickWhenVisible(HomePage.navMenu, timeout);
        commonMethods.clickWhenVisible(HomePage.outdoorCategoryM,timeout);
        commonMethods.clickWhenVisible(HomePage.outdoorCategoryViewAllM,timeout);
        Thread.sleep(8000);
        assertTrue(Base.getDriver().getTitle().contains(OUTDOOR_GEAR_CAT_TITLE));

        commonMethods.clickWhenVisible(HomePage.navMenu, timeout);
        commonMethods.clickWhenVisible(HomePage.fanCategoryM,timeout);
        commonMethods.clickWhenVisible(HomePage.fanCategoryViewAllM,timeout);
        Thread.sleep(8000);
        assertTrue(Base.getDriver().getTitle().contains(FAN_CAT_TITLE));

        commonMethods.clickWhenVisible(HomePage.navMenu, timeout);
        commonMethods.clickWhenVisible(HomePage.accessoriesElectronicsCategoryM,timeout);
        commonMethods.clickWhenVisible(HomePage.accessoriesElectronicsCategoryViewAll,timeout);
        Thread.sleep(8000);
        assertTrue(Base.getDriver().getTitle().contains(ACCESSORIES_ELECTRONICS_CAT_TITLE));

        commonMethods.clickWhenVisible(HomePage.navMenu, timeout);
        commonMethods.clickWhenVisible(HomePage.topBrandsCategoryM,timeout);
        commonMethods.clickWhenVisible(HomePage.topBrandsCategoryViewAllM,timeout);
        assertTrue(Base.getDriver().getTitle().contains(TOP_BRANDS_CAT_TITLE));
        Thread.sleep(8000);

        commonMethods.clickWhenVisible(HomePage.navMenu, timeout);
        commonMethods.clickWhenVisible(HomePage.clearanceCategoryM,timeout);
        commonMethods.clickWhenVisible(HomePage.clearanceViewAll,timeout);
        Thread.sleep(8000);
        assertTrue(Base.getDriver().getTitle().contains(CLEARANCE_CAT_TITLE));
    }
}


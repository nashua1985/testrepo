package com.dsg.cucumber.step_definitions.sb.dsg;


import com.dsg.cucumber.config.Base;
import com.dsg.cucumber.framework.CommonElementMethods;
import com.dsg.cucumber.pages.sb.HomePage;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.testng.Assert.assertTrue;

public class Regression_SB_007_008_Validate_Top_Navigation_Menu_Cat_Selection {
    private static final Logger logger = Logger.getLogger(Regression_SB_007_008_Validate_Top_Navigation_Menu_Cat_Selection.class);
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

    @When("we should see Top Navigation Menu and child submenu")
    public void we_enter() throws Exception {
        Map<By, String> catListNewNav = new LinkedHashMap<>();
        catListNewNav.put(HomePage.sportsCategory, SPORT_CAT_TITLE);
        catListNewNav.put(HomePage.womenCategory, WOMEN_CAT_TITLE);
        catListNewNav.put(HomePage.menCategory, MEN_CAT_TITLE);
        catListNewNav.put(HomePage.kidsCategory, KIDS_CAT_TITLE);
//        catListNewNav.put(HomePage.outerwearCategory, OUTERWEAR_CAT_TITLE);
        catListNewNav.put(HomePage.fitnessExerciseEquipmentCategory, FITNESS_EXERCISE_EQUIPMENT_CAT_TITLE);
        catListNewNav.put(HomePage.outdoorGearCategory, OUTDOOR_GEAR_CAT_TITLE);
        catListNewNav.put(HomePage.fanCategory, FAN_CAT_TITLE);
        catListNewNav.put(HomePage.accessoriesElectronicsCategory, ACCESSORIES_ELECTRONICS_CAT_TITLE);
//        catList.put(HomePage.holidayGiftCategory, HOLIDAY_GIFT_CAT_TITLE);
//        catList.put(HomePage.holidayDealsCategory, HOLIDAY_DEALS_CAT_TITLE);
        catListNewNav.put(HomePage.topBrandsCategory, TOP_BRANDS_CAT_TITLE);
        catListNewNav.put(HomePage.clearanceCategory, CLEARANCE_CAT_TITLE);

        Map<By, String> catList = new LinkedHashMap<>();
        catList.put(HomePage.sportsCategory, SPORT_CAT_TITLE);
//        catList.put(HomePage.womenCategory, WOMEN_CAT_TITLE);
//        catList.put(HomePage.menCategory, MEN_CAT_TITLE);
//        catList.put(HomePage.kidsCategory, KIDS_CAT_TITLE);
//        catList.put(HomePage.outerwearCategory, OUTERWEAR_CAT_TITLE);
//        catList.put(HomePage.fitnessExerciseEquipmentCategory, FITNESS_EXERCISE_EQUIPMENT_CAT_TITLE);
        catList.put(HomePage.outdoorGearCategory, OUTDOOR_GEAR_CAT_TITLE);
        catList.put(HomePage.fanCategory, FAN_CAT_TITLE);
        catList.put(HomePage.accessoriesElectronicsCategory, ACCESSORIES_ELECTRONICS_CAT_TITLE);
//        catList.put(HomePage.holidayGiftCategory, HOLIDAY_GIFT_CAT_TITLE);
//        catList.put(HomePage.holidayDealsCategory, HOLIDAY_DEALS_CAT_TITLE);
        catList.put(HomePage.topBrandsCategory, TOP_BRANDS_CAT_TITLE);
        catList.put(HomePage.clearanceCategory, CLEARANCE_CAT_TITLE);
        int getOldNavCount = commonMethods.getListSize(HomePage.shopDepartments, timeout);
        if(getOldNavCount > 0) {
            for (Map.Entry<By, String> oldNav : catList.entrySet()) {
//                commonMethods.hoverParentMenuAndClicksChild(HomePage.shopDepartments, oldNav.getKey(), timeout);
                commonMethods.hoverOnElement(HomePage.shopDepartments, timeout);
                commonMethods.clickWhenVisible(oldNav.getKey(), timeout);
                Thread.sleep(5000);
                assertTrue(Base.getDriver().getTitle().contains(oldNav.getValue()));
            }
        }else{
            for (Map.Entry<By, String> newNav : catListNewNav.entrySet()) {
                commonMethods.clickWhenVisible(newNav.getKey(), timeout);
                Thread.sleep(5000);
                assertTrue(Base.getDriver().getTitle().contains(newNav.getValue()));
            }
        }
    }
}


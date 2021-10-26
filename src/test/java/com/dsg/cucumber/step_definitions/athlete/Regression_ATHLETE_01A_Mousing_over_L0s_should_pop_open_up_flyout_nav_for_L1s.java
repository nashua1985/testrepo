package com.dsg.cucumber.step_definitions.athlete;


import com.dsg.cucumber.config.Base;
import com.dsg.cucumber.framework.CommonElementMethods;
import com.dsg.cucumber.pages.sb.CategoriesPage;
import com.dsg.cucumber.pages.sb.HomePage;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.testng.Assert.assertTrue;

public class Regression_ATHLETE_01A_Mousing_over_L0s_should_pop_open_up_flyout_nav_for_L1s {
    private static final Logger logger = Logger.getLogger(Regression_ATHLETE_01A_Mousing_over_L0s_should_pop_open_up_flyout_nav_for_L1s.class);
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

    @When("we should see L1 flyout when hovering on L0")
    public void we_enter() throws Exception {
        List<By> sportList = new ArrayList<>();
        sportList.add(CategoriesPage.BASEBALL);
        sportList.add(CategoriesPage.BASKETBALL);

        List<By> womenList = new ArrayList<>();
        womenList.add(CategoriesPage.SHOP_ALL_WOMEN);
        womenList.add(CategoriesPage.FOOTWEAR);

        Map<By, List<By>> catListNewNav = new LinkedHashMap<>();
        catListNewNav.put(HomePage.sportsCategory, sportList);
        catListNewNav.put(HomePage.womenCategory, womenList);

        //old nav
        int getOldNavCount = commonMethods.getListSize(HomePage.shopDepartments, timeout);
        if(getOldNavCount > 0) {
            commonMethods.hoverOnElement(HomePage.shopDepartments, timeout);
            Thread.sleep(5000);
            //end of old nav
        }else{
            //nothing
        }
                for (Map.Entry<By, List<By>> newNav : catListNewNav.entrySet()) {
                    commonMethods.hoverOnElement(HomePage.womenCategory, timeout); //workaround to make hover work
                    commonMethods.hoverOnElement(newNav.getKey(), timeout);
                    Thread.sleep(5000);
                    for (int i = 0; i < sportList.size(); i++) {
                        assertTrue(commonMethods.isElementVisible(newNav.getValue().get(i), timeout));
                    }
                }
            }
        }
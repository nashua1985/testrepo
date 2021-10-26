package com.dsg.cucumber.step_definitions.sb.dsg;


import com.dsg.cucumber.config.Base;
import com.dsg.cucumber.framework.CommonElementMethods;
import com.dsg.cucumber.pages.sb.CategoriesPage;
import com.dsg.cucumber.pages.sb.HomePage;
import com.dsg.cucumber.utilities.ProxyClass;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.testng.Assert.assertTrue;

public class Regression_SB_009_010_Validate_Family_Selection_From_Category_Pages {
    private static final Logger logger = Logger.getLogger(Regression_SB_009_010_Validate_Family_Selection_From_Category_Pages.class);
    private static final Integer timeout = 10;
    private static final String SPORT_CAT_TITLE = "Sports Equipment for Team Sports";
    private static final String BASEBALL_FAMILY_TITLE = "Baseball Bats";
    private static final String BASKETBALLS_FAMILY_TITLE = "Basketballs";
    private static final String BIKES_FAMILY_TITLE = "Bikes for Sale";
    private static final String RUNNING_SHOES_FAMILY_TITLE = "Running Shoes";
    private static final String VANS_FAMILY_TITLE = "Vans Shoes & Vans Skate Shoes";
    private static final String ALL_WOMENS_FOOTWEAR_FAMILY_TITLE = "Shop All Women's Footwear";
    private static final String WOMEN_CAT_TITLE = "Shop Women's";

    CommonElementMethods commonMethods= new CommonElementMethods();

    @When("we should see some family pages of sport category")
    public void family_pages_of_sport_cat() throws Exception {
        Map<By, By> catAndFamList = new LinkedHashMap<>();
        catAndFamList.put(CategoriesPage.baseballSubCat, CategoriesPage.batsFam);
        catAndFamList.put(CategoriesPage.basketballSubCat, CategoriesPage.basketballFam);
        catAndFamList.put(CategoriesPage.bikesSubCat, CategoriesPage.bikesFam);
        List<String> titles = new ArrayList<>();
        titles.add(BASEBALL_FAMILY_TITLE);
        titles.add(BASKETBALLS_FAMILY_TITLE);
        titles.add(BIKES_FAMILY_TITLE);
        int i = 0;
        Thread.sleep(5000);
        for(Map.Entry<By,By> getLocators: catAndFamList.entrySet()){
            int getOldNavCount = commonMethods.getListSize(HomePage.shopDepartments, timeout);
            if(getOldNavCount > 0){
                commonMethods.hoverParentMenuAndClicksChild(HomePage.shopDepartments, HomePage.sportsCategory, timeout);
            }else{
                commonMethods.clickWhenVisible(HomePage.sportsCategory, timeout);
            }
            Thread.sleep(5000);
            ProxyClass.promotionHandler();
            commonMethods.hoverParentMenuAndClicksChild(getLocators.getKey(), getLocators.getValue(), timeout);
            logger.info("verifying title: "+titles.get(i));
            Thread.sleep(5000);
            assertTrue(Base.getDriver().getTitle().contains(titles.get(i)));
            i++;
        }
    }

    @When("we should see some family pages of women category")
    public void family_pages_of_women_cat() throws Exception {
        Map<By, String> catListNewNav = new LinkedHashMap<>();
        catListNewNav.put(HomePage.womenCategory, WOMEN_CAT_TITLE);
        Map<By, By> catAndFamList = new LinkedHashMap<>();
        catAndFamList.put(CategoriesPage.womensFootwearSubCat, CategoriesPage.allWomensFootwearFam);
//        catAndFamList.put(CategoriesPage.womensTrendsSubCat, CategoriesPage.vansFam);
        List<String> titles = new ArrayList<>();
        titles.add(ALL_WOMENS_FOOTWEAR_FAMILY_TITLE);
        titles.add(VANS_FAMILY_TITLE);

        int getOldNavCount = commonMethods.getListSize(HomePage.shopDepartments, timeout);
        if(getOldNavCount > 0) {
                commonMethods.hoverParentMenuAndClicksChild(HomePage.shopDepartments, HomePage.womenCategory, timeout);
        }else{
            for (Map.Entry<By, String> newNav : catListNewNav.entrySet()) {
                commonMethods.clickWhenVisible(newNav.getKey(), timeout);
                Thread.sleep(5000);
                assertTrue(Base.getDriver().getTitle().contains(newNav.getValue()));
            }
        }

        int i = 0;
        Thread.sleep(5000);
        for(Map.Entry<By,By> getLocators: catAndFamList.entrySet()){
            commonMethods.hoverParentMenuAndClicksChild(getLocators.getKey(), getLocators.getValue(), timeout);
            logger.info("verifying title: "+titles.get(i));
            Thread.sleep(5000);
            assertTrue(Base.getDriver().getTitle().contains(titles.get(i)));
            i++;
        }
    }
}


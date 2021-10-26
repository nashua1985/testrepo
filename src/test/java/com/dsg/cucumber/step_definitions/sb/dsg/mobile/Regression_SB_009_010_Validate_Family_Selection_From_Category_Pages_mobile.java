package com.dsg.cucumber.step_definitions.sb.dsg.mobile;


import com.dsg.cucumber.config.Base;
import com.dsg.cucumber.framework.CommonElementMethods;
import com.dsg.cucumber.pages.sb.CategoriesPage;
import com.dsg.cucumber.pages.sb.HomePage;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.testng.Assert.assertTrue;

public class Regression_SB_009_010_Validate_Family_Selection_From_Category_Pages_mobile {
    private static final Logger logger = Logger.getLogger(Regression_SB_009_010_Validate_Family_Selection_From_Category_Pages_mobile.class);
    private static final Integer timeout = 10;
    private static final String SPORT_CAT_TITLE = "Sports Equipment for Team Sports";
    private static final String BASEBALL_FAMILY_TITLE = "Baseball Bats";
    private static final String BASKETBALLS_FAMILY_TITLE = "Basketballs";
    private static final String BIKES_FAMILY_TITLE = "Bikes";
    private static final String RUNNING_SHOES_FAMILY_TITLE = "Running Shoes";
    private static final String VANS_FAMILY_TITLE = "Vans Shoes & Vans Skate Shoes";
    private static final String ALL_WOMENS_FOOTWEAR_FAMILY_TITLE = "Shop All Women's Footwear";

    CommonElementMethods commonMethods= new CommonElementMethods();

    @When("we should see some family pages of sport category on mobile")
    public void family_pages_of_sport_cat() throws Exception {
        Map<By, By> catAndFamList = new LinkedHashMap<>();
        catAndFamList.put(CategoriesPage.baseballSubCatMobile, CategoriesPage.batsFam);
        //only one F page validation for mobile, as android location cannot be disabled.
        //once disabled, uncomment other f pages
//        catAndFamList.put(CategoriesPage.basketballSubCatMobile, CategoriesPage.basketballFam);
//        catAndFamList.put(CategoriesPage.bikesSubCatMobile, CategoriesPage.bikesFamMobile);
        List<String> titles = new ArrayList<>();
        titles.add(BASEBALL_FAMILY_TITLE);
        titles.add(BASKETBALLS_FAMILY_TITLE);
        titles.add(BIKES_FAMILY_TITLE);
        int i = 0;
        int flag = 0;
        commonMethods.clickWhenVisible(HomePage.navMenu, timeout);
        for(Map.Entry<By,By> getLocators: catAndFamList.entrySet()){
            if(flag==0){
                commonMethods.clickWhenVisible(HomePage.sportsCategoryM,timeout);
                flag++;
            }else {
                List<WebElement> navMenu = Base.getDriver().findElements(HomePage.navMenu);
                if (navMenu.size() != 0) {
                    logger.info("Nav Menu counts++++++++====>>>>> : "+navMenu.size());
                    commonMethods.clickWhenVisible(HomePage.navMenu, timeout);
                } else {
                    commonMethods.clickWhenVisible(HomePage.navMenu2, timeout);
                }
                commonMethods.clickWhenVisible(HomePage.sportsCategoryM, timeout);
            }
                commonMethods.clickWhenVisible(getLocators.getKey(),timeout);
                commonMethods.clickWhenVisible(getLocators.getValue(), timeout);
                logger.info("verifying title: "+titles.get(i));
                //getTitle method doesnt work well on mobile web.
//                boolean getTitle = commonMethods.isElementVisible(By.xpath("//div[@data-testid='pageTitle']//h1[contains(text(), '"+titles.get(i) +"')]"), timeout);
//                logger.info("returning title boolean: "+getTitle);
                Thread.sleep(5000);
                assertTrue(Base.getDriver().getTitle().contains(titles.get(i)));
                logger.info("Title is verified: "+titles.get(i));
            i++;
        }
    }

    @When("we should see some family pages of women category on mobile")
    public void family_pages_of_women_cat() throws Exception {
        Map<By, By> catAndFamList = new LinkedHashMap<>();
        catAndFamList.put(CategoriesPage.womensFootwearSubCatMobile, CategoriesPage.allWomensFootwearFamMobile);
        List<String> titles = new ArrayList<>();
        titles.add(ALL_WOMENS_FOOTWEAR_FAMILY_TITLE);
        titles.add(VANS_FAMILY_TITLE);
        int i = 0;
        int flag = 0;
        commonMethods.clickWhenVisible(HomePage.navMenu, timeout);
        for(Map.Entry<By,By> getLocators: catAndFamList.entrySet()) {
            if (flag == 0) {
                commonMethods.clickWhenVisible(HomePage.womenCategoryM, timeout);
                flag++;
            } else {
                List<WebElement> navMenu = Base.getDriver().findElements(HomePage.navMenu);
                if(navMenu.size() != 0){
                    commonMethods.clickWhenVisible(HomePage.navMenu, timeout);
                }else{
                    commonMethods.clickWhenVisible(HomePage.navMenu2, timeout);
                }
                commonMethods.clickWhenVisible(HomePage.womenCategory, timeout);
            }
            commonMethods.clickWhenVisible(getLocators.getKey(), timeout);
            commonMethods.clickWhenVisible(getLocators.getValue(), timeout);
            logger.info("verifying title: " + titles.get(i));
            //getTitle method doesnt work well on mobile web.
//            boolean getTitle = commonMethods.isElementVisible(By.xpath("//div[@data-testid='pageTitle']//h1[contains(text(), '"+titles.get(i) +"')]"), timeout);
//            logger.info("returning title boolean: "+getTitle);
            Thread.sleep(5000);
            assertTrue(Base.getDriver().getTitle().contains(titles.get(i)));
            logger.info("Title is verified: "+titles.get(i));
            i++;
        }
    }
}


package com.dsg.cucumber.step_definitions.athlete;


import com.dsg.cucumber.framework.CommonElementMethods;
import com.dsg.cucumber.pages.sb.HomePage;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.testng.Assert.assertTrue;

public class Regression_01B_Mobile_menu_should_open_and_close {
    private static final Logger logger = Logger.getLogger(Regression_01B_Mobile_menu_should_open_and_close.class);
    private static final Integer timeout = 10;
    private static final String METHOD_NAME = "validateTopNavigationMenu";
    CommonElementMethods commonMethods = new CommonElementMethods();

    @When("we should see mobile menu open and close")
    public void mobile_menu_should_open_and_close() throws Exception {
        List <By> ListNewNav = new ArrayList<>();
        ListNewNav.add(HomePage.sportsCategory);
        ListNewNav.add(HomePage.womenCategory);
        ListNewNav.add(HomePage.menCategory);
        ListNewNav.add(HomePage.kidsCategory);
        ListNewNav.add(HomePage.fitnessExerciseEquipmentCategory);
        ListNewNav.add(HomePage.outdoorGearCategory);
        ListNewNav.add(HomePage.fanCategory);
        ListNewNav.add(HomePage.accessoriesElectronicsCategory);
        ListNewNav.add(HomePage.topBrandsCategory);
        ListNewNav.add(HomePage.clearanceCategory);
        commonMethods.clickWhenVisible(HomePage.navMenu3, timeout);
        for (int i = 0; i < ListNewNav.size(); i++) {
            assertTrue(commonMethods.isElementVisible(ListNewNav.get(i), timeout));
        }
        commonMethods.clickWhenVisible(HomePage.closeMenuBtn, timeout);
        //to validate close button worked as it should reveal nav button
        assertTrue(commonMethods.isElementVisible(HomePage.navMenu3, timeout));
    }
}
package com.dsg.cucumber.step_definitions.sb.gg;


import com.dsg.cucumber.framework.CommonElementMethods;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import java.util.List;

public class Mock_requests_gg {
    private static final Logger logger = Logger.getLogger(Mock_requests_gg.class);
    private static final Integer timeout = 10;
    CommonElementMethods commonMethods= new CommonElementMethods();
    public static final String ZIP = "15108";
    @When("we mock")
    public void we_mock() throws Exception {
        commonMethods.enterValueWhenVisible(By.id("zip"), ZIP, timeout);
        commonMethods.sendkeys_tab(By.id("zip"), timeout);
        commonMethods.clickWhenVisible(By.xpath("(//input[@name='mui-16855'])[1]"), timeout);
        commonMethods.clickWhenVisible(By.xpath("//span[text()='With PGA Professional']"), timeout);
        commonMethods.clickWhenVisible(By.xpath("//span[text()='NEXT STEP']"), timeout);
        commonMethods.clickWhenVisible(By.id("selectedServiceProDropdown"), timeout);
        commonMethods.clickWhenVisible(By.xpath("//li[text()='Bryson DeChambeau']"), timeout);
        

    }
}


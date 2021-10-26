package com.dsg.cucumber.step_definitions.aos;


import com.dsg.cucumber.config.Base;
import com.dsg.cucumber.framework.CommonElementMethods;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class Regression_AOS_045_Validate_colored_breakout_pages {
    private static final Logger logger = Logger.getLogger(Regression_AOS_045_Validate_colored_breakout_pages.class);
    private static final Integer timeout = 10;
    private static final By coloredPageItemTotal = By.xpath("//a[@class='rs_product_description d-block']");

    CommonElementMethods commonMethods = new CommonElementMethods();
    @When("we validate if at least one colored breakout page is live for aos")
    public void validate_colored_breakout_pages() throws Exception {
        List<String> urls = new ArrayList<>();
        urls.add("https://aos.dickssportinggoods.com/f/uther-golf-towels");
        urls.add("https://aos.dickssportinggoods.com/f/nike-team-hustle-d8");
        urls.add("https://aos.dickssportinggoods.com/f/yeti-14-oz-mugs");
        urls.add("https://aos.dickssportinggoods.com/f/new-balance-fuelcore-nergize-shoes");
        urls.add("https://aos.dickssportinggoods.com/f/brooks-ghost-12");
        urls.add("https://aos.dickssportinggoods.com/f/brooks-anthem-2");
        urls.add("https://aos.dickssportinggoods.com/f/brooks-ghost-11-1953083-1");
        urls.add("https://aos.dickssportinggoods.com/f/brooks-glycerin-17");
        urls.add("https://aos.dickssportinggoods.com/f/asics-gt-2000");
        urls.add("https://aos.dickssportinggoods.com/f/under-armour-project-rock-shirts-1953098-1");
        for(int i = 0; true; i++){
            Base.getDriver().get(urls.get(i));
            int totalItems = commonMethods.getListSize(coloredPageItemTotal, timeout);
            if(totalItems>0){
                logger.info("Colored page is FOUND");
                break;
            }else{
                logger.info("Searching for colored breakout pages: "+urls.get(i).toString());
            }
            Assert.fail("Colored Breakout Pages NOT FOUND");
        }
    }
}



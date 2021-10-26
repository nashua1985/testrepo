package com.dsg.cucumber.step_definitions.sb.dsg;


import com.dsg.cucumber.framework.CommonElementMethods;
import com.dsg.cucumber.pages.sb.SrlpAndPlpPage;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.List;

public class Regression_SB_012_Validate_Sorting_Options_SRLP {
    private static final Logger logger = Logger.getLogger(Regression_SB_012_Validate_Sorting_Options_SRLP.class);
    private static final Integer timeout = 10;
    CommonElementMethods commonMethods = new CommonElementMethods();

    @When("we validate price sorting from low to high")
    public void we_validate_sorting_from_low_to_high() throws Exception {
        commonMethods.clickWhenVisible(SrlpAndPlpPage.sortDropDown, timeout);
        commonMethods.clickWhenVisible(SrlpAndPlpPage.priceLowToHighOption, timeout);
        Thread.sleep(8000);
        List<String> priceList = commonMethods.getTextFromListOfElements(By.xpath("//p[@class='final-price' or @class='offer-price']"), timeout);
        for(int i=1, k=1; i<priceList.size();i++, k++) {
            String getPriceTextFromElement1 = commonMethods.getTextFromLocator(By.xpath("(//p[@class='final-price' or @class='offer-price'])[" + i + "]"), timeout);
            int incremented = i+1;
            String getPriceTextFromElement2 = commonMethods.getTextFromLocator(By.xpath("(//p[@class='final-price' or @class='offer-price'])["+incremented+"]"), timeout);
            String priceTextFromElement1 = getPriceTextFromElement1.replace("$", "");
            String priceTextFromElement2 = getPriceTextFromElement2.replace("$", "");
            String[] sortedPriceFromElement1 = priceTextFromElement1.split("-");
            String[] sortedPriceFromElement2 = priceTextFromElement2.split("-");
//            System.out.println(sortedPriceFromElement1.length);
//            System.out.println("#"+k+": "+Arrays.deepToString(sortedPriceFromElement1));
//            System.out.println(sortedPriceFromElement2.length);
//            System.out.println(Arrays.deepToString(sortedPriceFromElement2));
            try {
                double priceLow1 = Double.parseDouble(sortedPriceFromElement1[0]);
                double priceLow2 = Double.parseDouble(sortedPriceFromElement2[0]);
//                double priceHigh1 = 0.0;
                double priceHigh2 = 0.0;
//                if(sortedPriceFromElement1.length == 2) {
//                    priceHigh1 = Double.parseDouble(sortedPriceFromElement1[1]);
//                }
                if(sortedPriceFromElement2.length == 2) {
                    priceHigh2 = Double.parseDouble(sortedPriceFromElement2[1]);
                }
//                System.out.println(priceLow1 + " : " + priceHigh1 + " priceLow and priceHigh for 2nd Element: " + priceLow2 + " : " + priceHigh2);
                if(priceLow1 <= priceLow2 || priceLow1 <= priceHigh2){
                    logger.info("Sorting works");
                    System.out.println("_________________");
                }else{
                    logger.info("Sorting maybe not working: "+priceLow1+" is HIGHER than "+priceLow2+" or "+priceHigh2);
                    Assert.fail("Sorting maybe NOT working correctly");
                }
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    @When("we validate price sorting from high to low")
    public void we_validate_sorting_from_high_to_low() throws Exception {
        commonMethods.clickWhenVisible(SrlpAndPlpPage.sortDropDown, timeout);
        commonMethods.clickWhenVisible(SrlpAndPlpPage.priceHighToLowOption, timeout);
        Thread.sleep(3000);
        List<String> priceList = commonMethods.getTextFromListOfElements(By.xpath("//p[@class='final-price' or @class='offer-price']"), timeout);
        for(int i=1, k=1; i<priceList.size();i++, k++) {
            String getPriceTextFromElement1 = commonMethods.getTextFromLocator(By.xpath("(//p[@class='final-price' or @class='offer-price'])[" + i + "]"), timeout);
            int incremented = i+1;
            String getPriceTextFromElement2 = commonMethods.getTextFromLocator(By.xpath("(//p[@class='final-price' or @class='offer-price'])["+incremented+"]"), timeout);
            String priceTextFromElement1 = getPriceTextFromElement1.replace("$", "");
            String priceTextFromElement2 = getPriceTextFromElement2.replace("$", "");
            String[] sortedPriceFromElement1 = priceTextFromElement1.split("-");
            String[] sortedPriceFromElement2 = priceTextFromElement2.split("-");
//            System.out.println(sortedPriceFromElement1.length);
//            System.out.println("#"+k+": "+Arrays.deepToString(sortedPriceFromElement1));
//            System.out.println(sortedPriceFromElement2.length);
//            System.out.println(Arrays.deepToString(sortedPriceFromElement2));
            try {
                double priceLow1 = Double.parseDouble(sortedPriceFromElement1[0]);
                double priceLow2 = Double.parseDouble(sortedPriceFromElement2[0]);
                double priceHigh1 = 0.0;
//                double priceLow1 = 0.0;
                double priceHigh2 = 0.0;
                if(sortedPriceFromElement1.length == 2) {
                    priceHigh1 = Double.parseDouble(sortedPriceFromElement1[1]);
                }if(sortedPriceFromElement2.length == 2) {
                    priceHigh2 = Double.parseDouble(sortedPriceFromElement2[1]);
                }
                System.out.println(priceLow1 + " : " + priceHigh1 + " priceLow and priceHigh for 2nd Element: " + priceLow2 + " : " + priceHigh2);
                if(priceLow1 >= priceLow2 || priceHigh1 >= priceHigh2 || priceHigh1 >= priceLow1){
                    logger.info("Sorting works");
                    System.out.println("_________________");
                }else{
                    logger.info("Sorting maybe not working: "+priceHigh1+" is LOWER than "+priceLow2+" or "+priceHigh2);
                    Assert.fail("Sorting maybe NOT working correctly");
                }
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
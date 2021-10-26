package com.dsg.cucumber.step_definitions.pdp.dsg;

import com.dsg.cucumber.config.Base;
import com.dsg.cucumber.framework.CommonElementMethods;
import com.dsg.cucumber.pages.pdp.ProductDetailsPage;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PDP_008_ATC_Baseball_Bat {
    private static final Logger logger = Logger.getLogger(PDP_008_ATC_Baseball_Bat.class);
    private static final Integer timeout = 10;
    CommonElementMethods commonMethods = new CommonElementMethods();
    PDP_001_ATC_Yeti reg=new PDP_001_ATC_Yeti();

    @When("we select bat length 32 and weight 29oz")
    public void select_length_and_weight()  {
        /*JavascriptExecutor js=(JavascriptExecutor) Base.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);",color);
        js.executeScript("arguments[0].style.border='3px solid red'",color);*/


        try {
            if(commonMethods.isElementVisible(ProductDetailsPage.batLength32,timeout)){
                reg.clickwithJavascript(ProductDetailsPage.batLength32);
            }
            else
            {
                List<WebElement> lengthlist = Base.getDriver().findElements(By.xpath("//button[@class='btn-attr-select block-attr ng-star-inserted']"));
                commonMethods.clickWhenVisible(lengthlist.get(0), timeout);

            }
        } catch(TimeoutException e) {
            System.out.println("Timeout occured");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if(commonMethods.isElementVisible(ProductDetailsPage.batWeight29,timeout)){
                    reg.clickwithJavascript(ProductDetailsPage.batWeight29);
                }
                else
                {
                    List<WebElement> weightList = Base.getDriver().findElements(By.xpath("//button[@class='btn-attr-select block-attr ng-star-inserted']/div/span[contains(text(),'OZ')]"));
                    commonMethods.clickWhenVisible(weightList.get(0), timeout);

                }
        } catch(TimeoutException e) {
            System.out.println("Timeout occured");
        }
        catch (Exception e) {
            e.printStackTrace();
        }




    }
}

package com.dsg.cucumber.framework;

import com.dsg.cucumber.config.Base;
import com.dsg.cucumber.utilities.BrowserUtilities;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ElementReadyStatus{
    private static final Logger logger = Logger.getLogger(ElementReadyStatus.class);
    /**
     * Checks in DOM if element/s is/are visible and enabled by locator and returns WebElement
     *
     * @param locator By locator value
     * @param timeout times out when locator not found
     * @return WebElement
     */
    public static WebElement getWebElementVisible(By locator, int timeout) throws Exception {
        WebElement element = null;
        try {
            logger.info("Searching for WebElement: " + locator + "");
            element = new WebDriverWait(Base.getDriver(), timeout).until(ExpectedConditions.visibilityOfElementLocated(locator));
            logger.info(locator+" is VISIBLE");
        } catch (Exception e) {
            logger.info("WebElement " + locator + " is NOT VISIBLE Try/Catch Block kicked in.");
            e.printStackTrace();
            BrowserUtilities.takeAScreenshotAndSave();
        }
        return element;
    }
    /**
     * Checks in DOM if element/s is/are visible and enabled by locator and returns boolean
     * 
     * @param locator By locator value
     * @param timeout times out when locator not found
     * @return boolean
     */
    public static boolean elementVisibleAndEnabled(By locator, int timeout) throws Exception {
        try{
        if(new WebDriverWait(Base.getDriver(), timeout).until(ExpectedConditions.visibilityOfElementLocated(locator)).isEnabled()){
            logger.info(locator+" is visible and enabled");
            return true;
        }else{
            logger.info(locator+" is NOT visible and enabled");
            return false;
        }
    }catch (Exception e){
        logger.info(locator+" is NOT visible and enabled. Try/Catch Block kicked in.");
        e.printStackTrace();
        BrowserUtilities.takeAScreenshotAndSave();
        return false;
    }
}

    /**
     * Checks in DOM if element/s is/are visible and enabled by WebElement and returns boolean
     *
     //* @param WebElement webElement value
     * @param timeout times out when locator not found
     * @return boolean
     */
    public static boolean elementVisibleAndEnabled(WebElement webElement, int timeout) throws Exception {
        try{
            (new WebDriverWait(Base.getDriver(), timeout)).until(ExpectedConditions.visibilityOf(webElement));
                logger.info(webElement+" is visible and enabled");
                return true;
        }catch (Exception e){
            logger.info(webElement+" is NOT visible and enabled");
            e.printStackTrace();
            BrowserUtilities.takeAScreenshotAndSave();
            return false;
        }

    }
//    /**
//     * Checks in DOM if element exists by locator and returns boolean
//     *
//     * @param locator By locator value
//     * @param timeout times out when locator not found
//     * @return boolean
//     */
//    protected static boolean elementDoesNotExist(By locator, int timeout) {
//    	WebElement element = null;
//    	try {
//    		element = new WebDriverWait(Base.getDriver(), timeout).until(ExpectedConditions.presenceOfElementLocated(locator));
//    		if(element != null) {
//    			return true;
//    		}
//    	}
//    	catch (Exception e) {
//    		return false;
//    	}
//    	return false;
//    }

}

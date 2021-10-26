package com.dsg.cucumber.utilities;

import com.dsg.cucumber.config.Base;
import com.dsg.cucumber.framework.CommonElementMethods;
import com.dsg.cucumber.framework.ElementReadyStatus;
import com.dsg.cucumber.pages.sb.HomePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.apache.log4j.Logger;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BrowserUtilities {
    private static final Logger logger = Logger.getLogger(BrowserUtilities.class);
    /**
     //* @param String string as an argument
     * @return Double
     */
    public static void promotionHandler() throws Exception {
        boolean promotionWindow = ElementReadyStatus.elementVisibleAndEnabled(HomePage.closePromoWindow,3);
        if(promotionWindow) {
            CommonElementMethods commonMethods= new CommonElementMethods();
            commonMethods.clickWhenVisible(HomePage.closePromoWindow, 1);
        }
    }

    /**
     //* @param String string as an argument
     * @return Double
     */
    public static double getNumberFromCart(String text){
        String newText = text.replace("$", "");
        String asd[] = newText.split(" ");
        double dbl = Double.parseDouble(asd[0]);
        logger.info("returning double number: "+dbl);
        return dbl;
    }

    /**
     * @param elements represents collection of WebElements
     * @return collection of strings
     */
    public static List<String> getTextFromWebElements(List<WebElement> elements) {
        List<String> textValues = new ArrayList<>();
        for (WebElement element : elements) {
            if (!element.getText().isEmpty()) {
                textValues.add(element.getText());
            }
        }
        return textValues;
    }

    /**
     * waits for backgrounds processes on the browser to complete
     *
     * @param timeOutInSeconds
     */
    public static void waitForPageToLoad(long timeOutInSeconds) {
        ExpectedCondition<Boolean> expectation = driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
        try {
            WebDriverWait wait = new WebDriverWait(Base.getDriver(), timeOutInSeconds);
            wait.until(expectation);
        } catch (Throwable error) {
            error.printStackTrace();
        }
    }

    /**
     * Clicks on an element using JavaScript
     *
     * @param element
     */
    public static void clickWithJS(WebElement element) {
        ((JavascriptExecutor) Base.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) Base.getDriver()).executeScript("arguments[0].click();", element);
    }

    /**
     * Scroll to element using JavaScript
     *
     * @param element
     */
    public static void scrollTo(WebElement element) {
        ((JavascriptExecutor) Base.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    /**
     * This method takes a screenshot and saves it with a date&time stamp.
     *
     * @return path to screenshot
     */
    @Test
    public static String takeAScreenshotAndSave() throws IOException {
        String path = System.getProperty("user.dir") + "/target/screenshots/";
        path = path.replace("/", File.separator);

        File file = new File(path);
        file.mkdirs();
        String timeStamp = DateTimeUtilities.getTimeStamp();
        path +=timeStamp+".jpeg";
        try (OutputStream outputStream = new FileOutputStream(path)) {
            TakesScreenshot takesScreenshot = (TakesScreenshot) Base.getDriver();
            byte[] screenshot = takesScreenshot.getScreenshotAs(OutputType.BYTES);
            outputStream.write(screenshot);
        } catch (IOException e) {
            logger.error(e);
            e.printStackTrace();
            throw new RuntimeException("Failed to create a screenshot :: " + path);
        }
       logger.info("Screenshot saved here :: " + path);
        return path;
    }


    /**
     * This method will switch webdriver from current window
     * to target window based on page title
     * @param title of the window to switch
     */
    public static void switchWindow(String title){
        Set<String> windowHandles = Base.getDriver().getWindowHandles();
        for(String window : windowHandles){
            Base.getDriver().switchTo().window(window);
            if(Base.getDriver().getTitle().equals(title)){
                break;
            }
        }
    }
}

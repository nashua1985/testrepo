package com.dsg.cucumber.utilities;

import com.dsg.cucumber.config.Base;
import com.dsg.cucumber.framework.CommonElementMethods;
import com.dsg.cucumber.pages.sb.HomePage;
import com.dsg.cucumber.step_definitions.sb.dsg.Regression_SB_030_Validate_Quickview_Panel_Functionality_Attribute_Selection;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

public class ProxyClass implements InvocationHandler {
    private static final Logger logger = Logger.getLogger(Regression_SB_030_Validate_Quickview_Panel_Functionality_Attribute_Selection.class);

    private final WebElement element;

    public ProxyClass(WebElement element) {
        this.element = element;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //before invoking actual method check for the popup
        this.promotionHandler();
        //at this point, popup would have been closed if it had appeared. element action can be called safely now.
        // --------START---------
        try {
            Object result = method.invoke(element, args);
            return result;
        } catch (InvocationTargetException ite) {
            throw ite.getCause();
        }
        //----------END-----------
        // Block was commented out to test new code ------Start------ as of 1/3/2020
//        Object result = method.invoke(element, args);
//        return result;
        //--------END-------------
    }

    public static void promotionHandler() throws Exception {
//        logger.info("Checking if Promo Window is OPEN...");
        List<WebElement> getPopUpList = Base.getDriver().findElements(HomePage.closePromoWindow);
            if(getPopUpList.size()!=0){
//                Thread.sleep(3000);
                CommonElementMethods commonMethods= new CommonElementMethods();
//            logger.info("Found Promo Window. KILLED it...");
                WebElement ele = Base.getDriver().findElement(HomePage.closePromoWindow);
                JavascriptExecutor executor = (JavascriptExecutor)Base.getDriver();
                executor.executeScript("arguments[0].click();", ele);
                Thread.sleep(5000);

            //                Base.getDriver(). findElement(HomePage.closePromoWindow).click();
//                commonMethods.clickWhenVisible(HomePage.closePromoWindow, 1);
            logger.info("Promo Window is KILLED");
        }
        //button[@ng-click='closeWindow()' and contains(text(), 'Close')]
//        List<WebElement> getFeedbackList = Base.getDriver().findElements(By.xpath("(//button[@aria-label='Close Survey'])[1]/i"));
//        List<WebElement> getFeedbackListButton = Base.getDriver().findElements(By.xpath("//button[@ng-click='closeWindow()' and contains(text(), 'Close')]"));
//
//
//        logger.info("FeedBacks is being SEARCHED: list of 1 "+getFeedbackList.size());
//        logger.info("FeedBacks is being SEARCHED: list of 2 "+getFeedbackListButton.size());
//
//        if(getFeedbackList.size()!=0){
//            logger.info("FeedBack Window is FOUND");
//            WebElement feedbackClose = Base.getDriver().findElement(By.xpath("(//button[@aria-label='Close Survey'])[1]/i"));
//            JavascriptExecutor executor = (JavascriptExecutor)Base.getDriver();
//            executor.executeScript("arguments[0].click();", feedbackClose);
//            Thread.sleep(5000);
//            logger.info("++++++++++++++++++++____Attention___+++++++++++++++++++++++");
//            logger.info("FeedBack Window is KILLED");
//        }
//
//        if(getFeedbackListButton.size()!=0){
//            logger.info("FeedBack Window is FOUND");
//            WebElement feedbackClose = Base.getDriver().findElement(By.xpath("//button[@ng-click='closeWindow()' and contains(text(), 'Close')]"));
//            JavascriptExecutor executor = (JavascriptExecutor)Base.getDriver();
//            executor.executeScript("arguments[0].click();", feedbackClose);
//            Thread.sleep(5000);
//            logger.info("++++++++++++++++++++____Attention___+++++++++++++++++++++++");
//            logger.info("FeedBack2 Window is KILLED");
//        }
    }
    public static WebElement wrapperElement(WebElement element) {
        ProxyClass proxy = new ProxyClass(element);
        WebElement wrappedElement = (WebElement) Proxy.newProxyInstance(ProxyClass.class.getClassLoader(),
                new Class[] { WebElement.class },
                proxy);
        return wrappedElement;
    }
}

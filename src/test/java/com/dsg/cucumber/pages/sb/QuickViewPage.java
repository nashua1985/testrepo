package com.dsg.cucumber.pages.sb;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.testng.log4testng.Logger;

public class QuickViewPage {
    private static final Logger logger = Logger.getLogger(QuickViewPage.class);
    public static By addToCart = By.xpath("//span[contains(text(), 'Add To Cart')]");
    public static By firstOccurenceAddToCart = By.xpath("(//span[text()=' ADD TO CART' or text()='ADD TO CART'])[1]");
    public static By addQuantityIcon = By.xpath("//span[@data-testid='quickViewModal_addItems']");
    public static By addQuantityIconMobile = MobileBy.xpath("//span[@data-testid='quickViewModal_addItems']//*[local-name()='path']");


}

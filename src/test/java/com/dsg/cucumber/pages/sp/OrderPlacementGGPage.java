package com.dsg.pages.sp;

import org.openqa.selenium.By;
import org.testng.log4testng.Logger;

public class OrderPlacementGGPage {
	
	private static final Logger logger = Logger.getLogger(OrderPlacementGGPage.class);
	  
  	
  	// Sole panel Order Placement 
	public static By GG_Order_Placement_Page = By.xpath("//span[@class='display-skeleton-header-title']");
	public static By CartOrderNumber = By.xpath("//*[@class='MuiPaper-root MuiCard-root order-placement-header MuiPaper-elevation1 MuiPaper-rounded']");
	public static By CancelCart = By.xpath("//*[text()='CANCEL CART']");

  	// GG Homepage
	// Order Placement Frame Cart
	public static By iFrame_title=By.xpath("//iframe[@title='order placement']");
  	public static By searchTextBox = By.xpath("//input[@id='search-regular' or @id='SearchBoxText']");
    public static By searchIcon = By.xpath("//*[text()='search' or @class='rh-icon-search-header']");
    public static By filterHyperText = By.xpath("//div[text()='FILTER']");
    public static By searchResultKeys = By.xpath("//div[@id='search-page']");
    public static By clearIcon = By.xpath("(//span[text()='Clear'])[1]");
    public static By closePromoWindow = By.xpath("//div[@class='close']");


	public static By chooseProduct = By.xpath("//div[@class='dsg-flex flex-column dsg-react-product-card rs_product_card'][1]");
	public static By addToCart = By.xpath("//button[@id='add-to-cart']");
//	public static By firstOccurenceAddToCart = By.xpath("(//span[text()=' ADD TO CART'])[1]");
	public static By chooseColor = By.xpath("//div[@class='attribute colors']/div[@class='dsg-flex flex-row flex-wrap' and 1]//img[@class='lazy-content lazyloaded'][1]");
	public static By chooseSize = By.xpath("//div[@class='attribute']/div[@class='dsg-flex flex-row flex-wrap' and 1]//div[@class='value false false'][1]");
	public static By addToCartfinal = By.xpath("//button[@class='dsg-react-button addToCart  ']/div[@class='background dsg-flex flex-grow flex-column align-items-center justify-content-center' and 1][1]");
	public static By goToCart = By.xpath("//a[@class='w-100 text-center dsg-button dsg-button-primary medium-height']");
	public static By getCartOrderNumber =By.xpath("//span[@class='orderNumber']");



}

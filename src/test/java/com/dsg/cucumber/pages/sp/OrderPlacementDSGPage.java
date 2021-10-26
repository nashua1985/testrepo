package com.dsg.pages.sp;

import org.openqa.selenium.By;
import org.testng.log4testng.Logger;


public class OrderPlacementDSGPage {

	  	private static final Logger logger = Logger.getLogger(OrderPlacementDSGPage.class);
	  
	  	// Sole panel Order Placement 
	  	
	  	public static By CartOrderNumber = By.xpath("//*[@class='MuiPaper-root MuiCard-root order-placement-header MuiPaper-elevation1 MuiPaper-rounded']");
	  	public static By CancelCart = By.xpath("//*[text()='CANCEL CART']");
		public static By Order_Placement_Page = By.xpath("//span[@class='display-skeleton-header-title']");

		// DSG Homepage
	  	// Order Placement Frame Cart
		public static By iFrame_title=By.xpath("//iframe[@title='order placement']");
	    public static By searchTextBox = By.xpath("//input[@id='search-regular' or @id='SearchBoxText']");
	    public static By searchIcon = By.xpath("//i[@data-em='Header_Search']");
		public static By addToCart = By.xpath("//span[contains(text(), 'Add To Cart')]");
		public static By firstOccurenceAddToCart = By.xpath("(//span[text()=' ADD TO CART'])[1]");
		public static By filterHyperText = By.xpath("//div[text()='FILTER']");
	    public static By searchResultKeys = By.xpath("//div[@id='search-page']");
	    public static By clearIcon = By.xpath("(//span[text()='Clear'])[1]");
	    public static By closePromoWindow = By.xpath("//div[@class='close']");
	    public static By chooseColor = By.xpath("//div[@class='attribute colors']/div[@class='dsg-flex flex-row flex-wrap' and 1]//img[@class='lazy-content lazyloaded'][1]");
	    public static By chooseSize = By.xpath("//div[@class='attribute']/div[@class='dsg-flex flex-row flex-wrap' and 1]//div[@class='value false false'][1]");
		public static By addToCartParent = By.xpath("//*[@class='dsg-flex flex-row ']");
	    public static By addToCartfinal = By.xpath("//button[@class='dsg-react-button addToCart  ']/div[@class='background dsg-flex flex-grow flex-column align-items-center justify-content-center' and 1][1]");
	    public static By viewCart = By.xpath("//button[@alt='View Cart']//span[@class='dsg-react-button-label dsg-flex align-items-center justify-content-center']");
	    public static By getCartOrderNumber =By.xpath("//span[@class='orderNumber']");  
	  
	    
	    //***DSG Hamburger Categories
	    
	    public static By shopDepartments = By.xpath("//span[text()='Shop Departments']");
	    public static By sportsCategory = By.xpath("//span[text()='Sports']");
	    public static By womenCategory = By.xpath("//span[text()='Women']");
	    public static By menCategory = By.xpath("//span[text()='Men']");
	    public static By kidsCategory = By.xpath("//span[contains(text(), 'Kids')]");
	    public static By outerwearCategory = By.xpath("//span[text()='Outerwear Shop']");
	    public static By fitnessExerciseEquipmentCategory = By.xpath("//span[text()='Exercise & Wellness']");
	    public static By outdoorGearCategory = By.xpath("//span[text()='Outdoor & Recreation']");
	    public static By fanCategory = By.xpath("//span[text()='Fan Shop']");
	    public static By accessoriesElectronicsCategory = By.xpath("//span[text()='Accessories']");
	    public static By holidayGiftCategory = By.xpath("//span[text()='Holiday Gift Guide']");
	    public static By holidayDealsCategory = By.xpath("//span[text()='Holiday Deals']");
	    public static By topBrandsCategory = By.xpath("//span[text()='Top Brands']");
	    public static By clearanceCategory = By.xpath("//span[text()='Clearance']");
	    public static By clearAllLink = By.xpath("//a[text()='Clear All']");

}

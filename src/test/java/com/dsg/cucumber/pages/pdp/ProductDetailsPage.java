package com.dsg.cucumber.pages.pdp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage {
    //from plp or search results
    public static By firstProductInGrid = By.xpath("//*[@class='card_image']");
    public static By clearFilters= By.className("dsg-react-hyperlink");

    //Product details
    public static By productName= By.className("title");
    public static By currentPrice= By.className("product-price ng-star-inserted");

    //Buttons and links
    /*@FindBy(how= how = How.xpath,using=("//div[@id='facet_list_label_Color']"))
    public static WebElement colorDropdown;
    public static By bluebutton=By.xpath("//span[@style=\\\"background-color: blue;\\\"]");*/
    public static By addToCart = By.id("add-to-cart");
    public static By goToCart = By.xpath("//a[contains(text(),'GO TO CART')]");
    public static By cart_title = By.xpath("//title[contains(text(), 'Cart')]");
    public static By continueShopping = By.className("dsg-button dsg-button-tertiary medium-height");
    public static By customNext = By.id("sliderRight");
    public static By customSaveSelection = By.id("formSubmit");
    public static By quantityBox = By.id("inputQty");
    public static By topNav = By.xpath("//li[@id='dropbtn']/span/span");
    public static By shopDepartments = By.xpath("//span[contains(text(),'Shop Departments')]");
    public static By topBrands= By.xpath("//span[contains(text(),'Top Brands')]");
    public static By YetiBrand= By.xpath("//a[contains(text(),'Yeti')]");
    public static By outdoorRec= By.xpath("//span[contains(text(),'Outdoor & Recreation')]");
    public static By Fishing= By.xpath("//strong[contains(text(),' Fishing')]");
    public static By rods= By.xpath("//a[@title='Rods']");
    public static By BikesCycling= By.xpath("//strong[contains(text(),'Bikes & Cycling')]");
    public static By bikes= By.xpath("//a[@title='Bikes']");
    public static By closeButton = By.xpath("//button[@class='btn btn-close']/i");
    public static By detail = By.xpath("//i[@class='material-icons details-toggle-icon']");//div[@class='d-flex align-items-center']/p[contains(text(),'Details')]
    public static By ratingsButton = By.xpath("//button[@class='bv_main_container_row_flex']");
    public static By reviewSearch = By.xpath("//button[@class='bv-content-btn bv-content-search-btn bv-focusable']");
    public static By reviewFilterBtn = By.xpath("//button[@class='bv-content-btn bv-filter-control bv-expand-filter-button bv-focusable']");
    public static By ownedforDropdown = By.xpath("//button[@class='bv-focusable']/span[@class='bv-dropdown-title' and contains(text(),'Owned for')]");
    public static By oneMonthorLess = By.xpath("//li[@data-bv-dropdown-value='1month']");
    public static By changeStorelink = By.xpath("//span[contains(text(),'Change Store')]");
    public static By zipcodeSearch=By.xpath("//button[@class='search-button']");
    public static By showStoresCheckbox=By.xpath("//input[@class='hmf-input-checkbox']");
    public static By selectStoreradio=By.xpath("//span[@class='store-select-radio-custom']");
    public static By selectStoreButton=By.xpath("//button/span[contains(text(),'Set Store')]");
    public static By notifyMeButton=By.xpath("//button[contains(text(),'Notify Me When Available')]");
    public static By notAvailable=By.xpath("//span[contains(text(),'Not Available at ')]");
    public static By linkStoreInfo=By.xpath("//button[@class='store-details-dropdown']");
    public static By rodLengthDropdown=By.xpath("//div[@id='facet_list_label_Rod Length']");
    public static By viewAllSizes=By.xpath("//div[contains(text(),'View All Sizes')]");


    //Attributes
    //Colors
    public static By colorNavy = By.xpath("//button[@aria-label='Navy']");
    public static By colorBlack = By.xpath("//button[@aria-label='Black']");
    public static By colorRed = By.xpath("//button[contains(@aria-label,'Red')]");
    public static By colorChrome = By.xpath("//button[@aria-label='Chrome']");
    public static By colorRedShoe = By.xpath("//div[@aria-labelledby='3232_facet_value_Red']");
    public static By colorMatteBlack = By.xpath("//button[@aria-label='Matte Black']");
    public static By colorWhiteBlackWhite = By.xpath("//button[@aria-label='White/Black/White']");
    public static By colorBlackFacemask = By.xpath("//button[@id='facemaskcolor-riddellmaskcolor-black']");
    public static By colorFilter = By.xpath("//div[@id='facet_list_label_Color']");
    public static By saleFilter = By.xpath("//div[@id='facet_list_label_Sale']");
    public static By genderFilter = By.xpath("//div[@id='facet_list_label_Gender']");
    public static By gendermens = By.xpath("//div[@aria-labelledby='5495_facet_value_Men_s']/input");
    public static By saletogglebutton = By.xpath("//div[@class='mdc-switch__thumb']");
    public static By priceFilter = By.xpath("//div[@id='facet_list_label_Price']");
    public static By under25 = By.xpath("//div[@aria-labelledby='dickssportinggoodsofferprice_facet_value_*-25']/span[@class='dsg-checkmark-wrapper']");
    public static By under50 = By.xpath("//div[@aria-labelledby='dickssportinggoodsofferprice_facet_value_25-50']/span[@class='dsg-checkmark-wrapper']");
    public static By colorBlackHoodie = By.xpath("//div[@aria-labelledby='3232_facet_value_Black']");
    public static By sizeFilter = By.xpath("//div[@id='facet_list_label_Size']");
    public static By SizeMediumHoodie = By.xpath("//div[@aria-labelledby='299_facet_value_M']");
    public static By ShoeSizeFilter = By.xpath("//div[@id='facet_list_label_Mens_Shoe_Size']");
    public static By ShoeSize11 = By.xpath("//div[@aria-labelledby='[object Object]_facet_value_11.0']");

    //Sizes
    public static By sizeMedium = By.xpath("//span[text()='M']");
    public static By customSizeMedium = By.id("size-m");
    public static By sizeLarge = By.id("block-swatch_Size_3");
    public static By customSizeLarge = By.id("size-l");
    public static By rodLength7 = By.id("block-swatch_RodLength_1");
    public static By rodPower = By.xpath("//button[@aria-label='Medium']");
    public static By frameSize3 = By.id("block-swatch_FrameSize_3");
    public static By shoeSize11 = By.xpath("//button[@aria-label='11.0']");
    public static By shoeSize9 = By.xpath("//button[@aria-label='9.0']");
    public static By pantSize32 = By.xpath("//button[@aria-label='32']");
    public static By inseam32 = By.xpath("//button[@aria-label='32']");
    public static By batLength32 = By.xpath("//button[@aria-label='32\"']");
    public static By batWeight29 = By.xpath("//button[@aria-label='29 OZ']");
    public static By customSize52 = By.xpath("//button[@aria-label='52']");
    public static By frameSize15 = By.xpath("//button[@aria-label='15\"']");
    public static By frameSize17 = By.xpath("//button[@aria-label='17\"']");
    public static By frameSize19= By.xpath("//button[@aria-label='19\"']");
    public static By frameSize21= By.xpath("//button[@aria-label='21\"']");



    //Fields
    public static By textLine1 = By.id("textLine1");
    public static By textLine2 = By.id("textLine2");
    public static By textLine3 = By.id("textLine3");
    public static By personalizationNum = By.id("numberLine1");
    public static By customJerseyName = By.id("teamplayernamestaticcolor-playerNameInput");
    public static By customJerseyNumber = By.id("teamplayernumberstaticcolor-playerNumberInput");
    public static By customTitle = By.id("responsiveTitle");
    public static By searchReviewtext = By.id("bv-text-field-search-contentSearch1");
    public static By searchReviewLightBoxtext= By.id("bv-text-field-search-contentSearch1-lightboxSearch");
    public static By reviewDropdown= By.xpath("//div/button[@aria-labelledby='bv-dropdown-reviews-menu bv-dropdown-select-reviews bv-dropdown-title-reviews']");
    public static By mostRecent= By.xpath("//li[@id='data-bv-dropdown-item-mostRecent']");
    public static By zipcodeText = By.xpath("//input[@id='zip-code']");

    //Custom
    public static By facemaskS2BDHS4 = By.xpath("//button[@aria-label='riddell_victor_helmet_s2bdsp']");
    public static By genderWomens = By.xpath("//button[@aria-label='Women's']");
    public static By handLeft = By.xpath("//button[@aria-label='LH']");
    public static By loft9 = By.xpath("//button[@aria-label='loft-9']");
    public static By loftDropdown = By.id("select-loft");
    public static By shaftManufacturerDropDown = By.id("select-shaft_manufacturer");
    public static By shaftFujikura = By.id("shaft_manufacturer-fujikura");
    public static By driverLengthDropdown = By.id("select-length");
    public static By driverLengthWomensStandard = By.id("length-women’s standard");
    public static By gripBrandDropdown = By.id("select-gripbrand");
    public static By gripBuildDropdown = By.id("select-gripsize");
    public static By shaftMaterialSteel = By.id("shaft_material-steel-label");
    public static By handLeftIron = By.xpath("//button[@id='hand-lh']");
    public static By setMakeUp = By.xpath("//button[@aria-label='5-PW, UW, SW']");
    public static By indiIronSelectionToggle = By.xpath("//div[@id='ironSelectionTogglerIndividualIronSelection']");
    public static By fiveIron = By.xpath("//button[@ria-label='5 iron']");
    public static By lieDropdown = By.xpath("//select[@id='select-lie']");
    public static By filterButton=By.xpath("//div[@class='rs-filter-svg']");

    //page titles
    public static By sizeChartTitle = By.xpath("//div[contains(text(),'Size Chart')]");
    public static By promodescTitle = By.xpath("//div[contains(text(),'Promotion Details')]");



}

package com.dsg.cucumber.pages.MyAccount;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.testng.log4testng.Logger;

public class MyAccount {
	private static final Logger logger = Logger.getLogger(MyAccount.class);
	public static By searchTextBox = By
			.xpath("//input[@id='search-regular' or @id='SearchBoxText' or @id='searchInput']");

	public static By fullName = By.xpath("//myaccount-scorecard-member/div/div[1]/div[2]/div[1]");

	public static By scoreCardNumber = By.xpath("//myaccount-scorecard-member/div/div[1]/div[2]/div[3]");

	public static By numberOfPoints = By.xpath("//myaccount-scorecard-member/div/div[2]/div[2]/span");

	public static By text = By.xpath("//myaccount-account-summary/div/div[1]/div[2]/myaccount-reward-list");
	
	public static By manageAccount = By.id("btn-manage");

	public static By purchase_orders = By.cssSelector("table.cdk-table tbody tr");

	public static By scorecard = By.xpath(
			"//*[@id=\"myaccount-container\"]/div[2]/myaccount-account-summary/div/div[1]/div[1]/myaccount-scorecard-gold/div/div[2]/div");

	public static By manageAccountButton = By.cssSelector("#btn-manage");

	public static By rewardsTab = By.xpath("//a[contains(text(),'Rewards')]");

	public static By purchaseTab = By.xpath("//a[contains(text(),'Purchases')]");

	public static By accountSettingTab = By.xpath("//a[contains(text(),'Account Settings')]");

	public static By faqTab = By.xpath("//a[contains(text(),'FAQ')]");

	public static By signOutButton = By.xpath("//a[contains(text(),'Sign Out')]");

	public static By rewards_activeRewards = By.cssSelector("myaccount-reward-list div p");

	public static By rewards_PointBalance = By.cssSelector("h2.point-balance span");

	public static By credit_my_account_link = By.cssSelector("a.credit-label");

	public static By credit_my_account_sideBar = By.cssSelector("div.panel-description-content");

	public static By close_sidebar = By.cssSelector("button.btn-close");

//	Order Details related locator
	public static By order_header = By.cssSelector("h1.order-details-header");
	public static By order_status = By
			.xpath("//span[@class='order-details-subheader' and contains(.,'Status')]/following-sibling::span");

	public static By order_total = By.xpath("//span[contains(text(),' Order Total ')]/../following-sibling::div");

	public static By setting_rewards = By.cssSelector("myaccount-reward-delivery");
	public static By setting_subscription = By.cssSelector("myaccount-subscriptions");
	public static By setting_login = By.cssSelector("myaccount-manage-login");
	public static By setting_addressbook = By.cssSelector("myaccount-address-bookv2");
	public static By setting_phonebook = By.cssSelector("myaccount-phone-book");
}

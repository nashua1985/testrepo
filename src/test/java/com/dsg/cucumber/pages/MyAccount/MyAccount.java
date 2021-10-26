package com.dsg.cucumber.pages.MyAccount;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.testng.log4testng.Logger;

public class MyAccount {
    private static final Logger logger = Logger.getLogger(MyAccount.class);
    public static By searchTextBox = By.xpath("//input[@id='search-regular' or @id='SearchBoxText' or @id='searchInput']");

    public static By fullName = By.xpath("//myaccount-scorecard-member/div/div[1]/div[2]/div[1]");

    public static By scoreCardNumber = By.xpath("//myaccount-scorecard-member/div/div[1]/div[2]/div[3]");

    public static By numberOfPoints = By.xpath("//myaccount-scorecard-member/div/div[2]/div[2]/span");

    public  static By text = By.xpath("//myaccount-account-summary/div/div[1]/div[2]/myaccount-reward-list");

    public  static By scorecard = By.xpath("//*[@id=\"myaccount-container\"]/div[2]/myaccount-account-summary/div/div[1]/div[1]/myaccount-scorecard-gold/div/div[2]/div");

    public  static By manageAccountButton = By.cssSelector("#btn-manage");

}


package com.dsg.cucumber.pages.AS;

import org.openqa.selenium.By;

public class AthleteScheduler {
    //  First page (location and service selection)
    public static By schedulerContent = By.id("scheduling-root");
    public static By zipEntry = By.id("zip");
    public static By robinsonStore = By.id("StoreROBINSON");
    public static By akronStore = By.id("StoreAKRON");
    public static By lessonService = By.id("lessonServiceTile");
    public static By fittingService = By.id("clubServiceTile");
    public static By serviceTypeNextButton = By.id("ServiceTypeNextStepButton");
    //  Second page (pro, date, and time selection)
    public static By proDropdown = By.id("selectedServiceProDropdown");
    public static By brysonDechambeau = By.id("Bryson DeChambeau-MenuItem");
    public static By dustinJohnson = By.id("Dustin Johnson-MenuItem");
    public static By proBackButton = By.id("ServiceTimeBackButton");
    public static By serviceTimeNextButton = By.id("ServiceTimeNextStepButton");
    public static By serviceTimeBackButton = By.id("ServiceTimeBackButton");
    public static By daySelector = By.id("daySelector");
    public static By calendarIcon = By.id("calendarIcon");
    public static By availableDate = By.id("#\\32 021-12-27-Button");
    public static By availableTime = By.id("#\\31 4\\:00\\:00-Button");
    public static By dateNextStepsButton = By.id("#ServiceTimeNextStepButton");
}

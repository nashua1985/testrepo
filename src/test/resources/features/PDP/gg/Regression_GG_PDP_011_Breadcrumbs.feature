Feature: Regression_GG_PDP_011_Breadcrumbs
  Background: open page
    Given we are on "womensSkirtsGG" page

  @PDP_GG
  @Regression
  @PDP_011
  Scenario: Regression_GG_PDP_011_Breadcrumbs
    And we click on the first product in search grid
    And we wait for 3 seconds
    And we click the "Women's Apparel" breadcrumb
    Then we should see "Women's Apparel"

    And we click to open the hamburger menu and select "Top Brands"
    And we select "Yeti"
    And we click on the first product in search grid
    And we wait for 3 seconds
    And we click the "Camping & Hiking" breadcrumb
    Then we should see "Camping & Hiking Gear" title

    And we click to open the hamburger menu and select "Outdoor & Recreation"
    And we select "Fishing & Rods"
    And we click on the first product in search grid
    And we wait for 3 seconds
    And we click the "Sports Equipment" breadcrumb
    Then we should see "Sports Equipment" title

    And we click to open the hamburger menu and select "Outdoor & Recreation"
    And we select "Bikes"
    And we click on the first product in search grid
    And we wait for 3 seconds
    And we click the "Bikes & Cycling" breadcrumb
    Then we should see "Bikes & Cycling" title

    And we are on "personalGolfBalls" page
    And we click on the first product in search grid
    And we wait for 3 seconds
    And we click the "Golf" breadcrumb
    Then we should see "Golf" title

    And we are on "baseballBats" page
    And we click on the first product in search grid
    And we wait for 3 seconds
    And we click the "Home" breadcrumb
    Then we should see "Shop Departments"






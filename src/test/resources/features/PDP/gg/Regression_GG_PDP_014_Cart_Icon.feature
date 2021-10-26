Feature: Regression_GG_PDP_014_Cart_Icon
  Background: open page
    Given we are on "putterGG" page

  @PDP_GG
  @PDP_mobile
  @PDP_mobile_ios
  @Regression
  @PDP_014
  Scenario: Regression_GG_PDP_014_Cart_Icon
And we click on the first product in search grid
    And we select the color Navy
    And we wait for 3 seconds
    And we change the quantity desired to "3"
    And we validate available to ship
    And we click on Add to Cart button
    And we click "Continue Shopping"
    Then cart count value is "3"
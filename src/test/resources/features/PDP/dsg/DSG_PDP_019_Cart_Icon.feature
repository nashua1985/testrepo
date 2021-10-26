Feature: Regression_DSG_PDP_019_Cart_Icon
  Background: open page
    Given we are on "yetiBrand" page

  @PDP
  @PDP_mobile
  @PDP_mobile_ios
  @Regression
  @PDP_019
  Scenario: Regression_DSG_PDP_019_Cart_Icon
    When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
    Given we are on "yetiBrand" page
    And we wait for 10 seconds
    And we click on the first product in search grid
    And we select the color Navy
    And we wait for 3 seconds
    And we change the quantity desired to "4"
    And we validate available to ship
    And we click on Add to Cart button
    And we click "Continue Shopping"
    Then cart count value is "4"
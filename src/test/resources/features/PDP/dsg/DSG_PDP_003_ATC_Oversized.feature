Feature: Regression_DSG_PDP_003_ATC_Oversized
  Background: open page
    Given we are on "dsgKayakFamily" page

  @PDP
  @Regression
  @PDP_Smoke
  @PDP_003
  @Batch1
  @PDP_mobile
  @PDP_mobile_ios
  Scenario: Regression_DSG_PDP_003_ATC_Oversized
    When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
    Given we are on "dsgKayakFamily" page
    And we wait for 10 seconds
    And we click  Ship to me
    And we click on the first product in search grid
    And we wait for 5 seconds
    And select the first color option
    And we click on Add to Cart button
    And we wait for 5 seconds
    And we should see "ADDED TO CART"
    And we should see Continue Shopping
    And we should see "GO TO CART"
    And we click GO TO CART in safari
    And we should see "1 item"
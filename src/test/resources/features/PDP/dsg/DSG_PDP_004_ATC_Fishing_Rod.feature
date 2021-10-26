Feature: Regression_DSG_PDP_004_ATC_Fishing_Rod
  Background: open page
    Given we are on "fishingRods" page


  @PDP
  @Regression
  @PDP_Smoke
  @PDP_004
  @Batch1
  @PDP_mobile
  @PDP_mobile_ios
  Scenario: Regression_DSG_PDP_004_ATC_Fishing_Rod
    When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
    Given we are on "fishingRods" page
    And we wait for 10 seconds
    And we click  Ship to me
    And we filter by rod length "7'0"
    And we click on the first product in search grid
    And we click on Add to Cart button
    #intention: to test add to cart with attributes not selected. expectation is an error
    And we should see "Please select Rod Length"
    And we should see "Please select Power"
    And we select the rod length "7'0" and power "Medium"
    And we wait for 3 seconds
    And we validate available to ship
    #intention: to see if ATC should be successful, is there availability to add to cart
    And we click on Add to Cart button
    And we wait for 5 seconds
    And we should see "ADDED TO CART"
    And we should see Continue Shopping
    And we should see "GO TO CART"
    And we click GO TO CART in safari
    And we should see "1 item"
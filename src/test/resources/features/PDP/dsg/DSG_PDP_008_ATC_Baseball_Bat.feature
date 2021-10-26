Feature: Regression_DSG_PDP_008_ATC_Baseball_Bat
  Background: open page
    Given we are on "baseballBats" page

  @PDP
  @Regression
  @PDP_Smoke
  @PDP_008
  @Batch1
  @PDP_mobile
  @PDP_mobile_ios
  Scenario: Regression_DSG_PDP_008_ATC_Baseball_Bat
    When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
    Given we are on "baseballBats" page
    And we wait for 10 seconds
    And we click  Ship to me
    And we click on the first product in search grid
    And we click on Add to Cart button
    #intention: to test add to cart with attributes not selected. expectation is an error
    And we should see "Please select Length"
    And we should see "Please select Weight"
    And we select bat length 32 and weight 29oz
    #Currently this is not finding the length due to ". need to fix 3/1/21-fixed
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
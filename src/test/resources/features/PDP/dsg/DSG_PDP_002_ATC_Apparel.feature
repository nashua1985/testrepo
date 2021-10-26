Feature: Regression_DSG_PDP_002_ATC_Apparel
  Background: open page
    Given we are on "womensHoodies" page


  @PDP
  @PDP_Smoke
  @Regression
  @PDP_002
  Scenario: Regression_DSG_PDP_002_ATC_Apparel
    When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
    Given we are on "womensHoodies" page
    And we wait for 10 seconds
    And we click  Ship to me
    And we filter by the color "Black" and the size "Medium"
    And we click on the first product in search grid
    And we click on Add to Cart button
    #intention: to test add to cart with attributes not selected. expectation is an error
    And we should see "Please select Color"
    And we should see "Please select Size"
    And we select the color Black
    And we select the size Medium
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
    #intention: should be directed from PDP to cart



  @PDP_mobile
  @PDP_mobile_ios
  @PDP_002_ios
  Scenario: Regression_PDP_002_ATC_Apparel
    When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
    Given we are on "womensHoodies" page
    And we wait for 10 seconds
    And we click  Ship to me
    And we click on the filter button
    And we filter by the color "Black" and the size "Medium"
    And we click on the first product in search grid
    And we click on Add to Cart button
    #intention: to test add to cart with attributes not selected. expectation is an error
    And we should see "Please select Color"
    And we should see "Please select Size"
    And we select the color Black
    And we select the size Medium
    And we wait for 3 seconds
    And we validate available to ship
    #intention: to see if ATC should be successful, is there availability to add to cart
    And we click on Add to Cart button
    And we wait for 5 seconds
    And we should see "ADDED TO CART"
    And we should see "Continue Shopping"
    And we should see "GO TO CART"
    And we click GO TO CART
    And we should see "1 item"
    #intention: should be directed from PDP to cart



Feature: Regression_GG_PDP_001_ATC_Yeti
  Background: open page
    Given we are on "yetiBrandGG" page


  @PDP_GG
  @Regression
  @PDP_001
  @Batch1
  Scenario: Regression_GG_PDP_001_ATC_Yeti
    And we click  Ship to me
    And we filter by the color Blue
    And we click on the first product in search grid
    And we click on Add to Cart button
    #intention: to test add to cart with attributes not selected. expectation is an error
    And we should see "Please select Color"
    And we select the color Navy
    And we wait for 3 seconds
    And we validate available to ship
    #intention: to see if ATC should be successful, is there availability to add to cart
    And we click on Add to Cart button
    And we wait for 5 seconds
    And we should see "ADDED TO CART"
    And we should see "Continue Shopping"
    And we should see "GO TO CART"
    And we click GO TO CART in safari
    Then we should see "1 item"


  @PDP_mobile
  @PDP_mobile_ios
  @Smoke
  @Regression
  @PDP_001_mobile
  Scenario: Regression_PDP_001_ATC_Yeti
    And we click on the filter button
    And we filter by the color Blue
    And we click on the first product in search grid
    And we click on Add to Cart button
    #intention: to test add to cart with attributes not selected. expectation is an error
    And we should see "Please select Color"
    And we select the color Navy
    And we wait for 3 seconds
    And we validate available to ship
    #intention: to see if ATC should be successful, is there availability to add to cart
    And we click on Add to Cart button
    And we wait for 5 seconds
    And we should see "ADDED TO CART"
    And we should see "Continue Shopping"
    And we should see "GO TO CART"
    And we click GO TO CART
    Then we should see "1 item"
    #intention: should be directed from PDP to cart

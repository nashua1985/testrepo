Feature: Regression_DSG_PDP_006_ATC_Shoes
  Background: open page
    Given we are on "mensBasketballShoes" page

  @PDP
  @Regression
  @PDP_Smoke
  @PDP_006
  Scenario: Regression_DSG_PDP_006_ATC_Shoes
    When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
    Given we are on "mensBasketballShoes" page
    And we wait for 10 seconds
    And we click  Ship to me
    And we filter by the color Red and the size 11
    And we click on the first product in search grid
    And we click on Add to Cart button
    #intention: to test add to cart with attributes not selected. expectation is an error
    And we should see "Please select Color"
    And we should see "Please select Shoe Size"
    And we select the color Red
    And we select shoe size 11
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

  @PDP_mobile
  @PDP_mobile_ios
  @PDP_006_mobile
  Scenario: Regression_PDP_006_ATC_Shoes
    When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
    Given we are on "mensBasketballShoes" page
    And we wait for 10 seconds
    And we click  Ship to me
    And we click on the filter button
    And we filter by the color Red and the size 11
    And we click on the first product in search grid
    And we click on Add to Cart button
    #intention: to test add to cart with attributes not selected. expectation is an error
    And we should see "Please select Color"
    And we should see "Please select Shoe Size"
    And we select the color Red
    And we select shoe size 11
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


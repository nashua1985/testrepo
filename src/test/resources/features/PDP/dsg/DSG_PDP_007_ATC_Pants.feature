Feature: Regression_DSG_PDP_007_ATC_Pants
  Background: open page
    Given we are on "golfPants" page

  @PDP
  @PDP_mobile
  @PDP_mobile_ios
  @Regression
  @PDP_Smoke
  @PDP_007
  Scenario: Regression_DSG_PDP_007_ATC_Pants
    When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
    Given we are on "golfPants" page
    And we wait for 10 seconds
    And we click  Ship to me
    #And we filter by the pant size 32 and inseam 32
    #And we wait for 3 seconds
    And we filter by gender "Men"
    And we click on the first product in search grid
    And we click on Add to Cart button
    #intention: to test add to cart with attributes not selected. expectation is an error
    And we should see "Please select Color"
    And we should see "Please select Size"
    And we should see "Please select Inseam"
    And we select the color Black
    And we select pant size 32 and inseam 32
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
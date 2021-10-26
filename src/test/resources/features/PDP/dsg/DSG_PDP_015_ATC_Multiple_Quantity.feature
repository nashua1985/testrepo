Feature: Regression_DSG_PDP_015_ATC_Multiple_Quantity
  Background: open page
    Given we are on "womensHoodies" page

  @PDP
  @PDP_mobile
  @PDP_mobile_ios
  @Regression
  @PDP_Smoke
  @PDP_015
  Scenario: Regression_DSG_PDP_015_ATC_Multiple_Quantity
    When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
    Given we are on "womensHoodies" page
    And we wait for 10 seconds
    And we click  Ship to me
    #And we filter by the color Black and the size Medium
    And we click on the first product in search grid
    And we select the color Black
    And we select the size Large
    And we wait for 3 seconds
    And we change the quantity desired to "3"
    And we validate available to ship
    #intention: to see if ATC should be successful, is there availability to add to cart
    And we click on Add to Cart button
    And we click GO TO CART in safari
    And we should see "3 items"
    And we verify product quantity is "3"
    #curently this is not pulling the value correctly needs to be remedied, need to check with the dev team can see the value in DOM


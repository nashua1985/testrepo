Feature: Regression_CART_007_Verify_Fullfillment_Choice
  Background: open page
    Given we are on "yetiBrand" page

  @CART
  @Smoke
  @Regression
  @CART_007
  @CART_mobile
  Scenario: Regression_CART_007_Verify_Fullfillment_Choice
    When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
    Given we are on "yetiBrand" page
    And we wait for 10 seconds
    And we click  Ship to me
	And we click on the first product in search grid
	And we select the first color option
    And we wait for 3 seconds
    And we validate available to ship
    And we click on Add to Cart button
	And we click Continue Shopping

    And we search for "Womens hoodie" keyword in the search box
    And we filter by the color "Black" and the size "Medium"
    And we click on In store
    And we click on the first product in search grid
    And we select the color Black
    And we select the size Medium
	And we check BOPIS availability
    And we click on Add to Cart button
    And we click GO TO CART
	And we verify that the first yeti has STH fulfillment
	And we verify that the hoodie has BOPIS fulfillment

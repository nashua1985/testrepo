Feature: Regression_CART_010_BOPIS_Free_Shipping
  Background: open page
    Given we are on "yetiBrand" page

  @CART
  @Smoke
  @Regression
  @CART_010
  @CART_mobile
  Scenario: Regression_CART_010_BOPIS_Free_Shipping
    When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
    Given we are on "yetiBrand" page
    And we wait for 10 seconds
    And we click on In store
    And we filter by items less than $50
	And we click on the first product in search grid
	And we select the color Black
	And we check BOPIS availability
    And we click on Add to Cart button
    And we click GO TO CART
	Then the BOPIS radio button is selected for our product
	Then Store Pickup should be Free
	
	And we search for "Nike Headband" keyword in the search box
	And we click on the first product in search grid
	And we select attributes
    And we wait for 3 seconds
    And we validate available to ship
    And we click on Add to Cart button
    And we click GO TO CART
	Then we verify estimated shipping is "$6.99"
	Then Store Pickup should be Free
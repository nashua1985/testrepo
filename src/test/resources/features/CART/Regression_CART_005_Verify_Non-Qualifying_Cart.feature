Feature: Regression_CART_005_Verify_Non-Qualifying_Cart
  Background: open page
    Given we are on "caliaBrand" page

  @CART
  @Smoke
  @Regression
  @CART_005
  Scenario: Regression_CART_005_Verify_Non-Qualifying_Cart
    When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
    Given we are on "caliaBrand" page
    And we wait for 10 seconds
    And we click  Ship to me
	And we filter by items less than $50
	And we click on the first product in search grid
    And we select attributes
    And we wait for 3 seconds
    And we validate available to ship
    And we click on Add to Cart button
    And we click Continue Shopping
	And we search for "Nike Headband" keyword in the search box
	And we click on the first product in search grid
	And we select attributes
    And we wait for 3 seconds
    And we validate available to ship
    And we click on Add to Cart button
    And we click GO TO CART
	And we should see "Free Shipping Plus Free Returns on CALIA!"
	And we see a shipping discount of "-3.50"

  @CART_mobile
  @Regression
  @CART_005
  Scenario: Regression_CART_005_Verify_Non-Qualifying_Cart
    When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
    Given we are on "caliaBrand" page
    And we wait for 10 seconds
    And we click  Ship to me
    And we click on the filter button
    And we filter by items less than $50
    And we click on the first product in search grid
    And we select attributes
    And we wait for 3 seconds
    And we validate available to ship
    And we click on Add to Cart button
    And we click Continue Shopping
    And we search for "Nike Headband" keyword in the search box
    And we click on the first product in search grid
    And we select attributes
    And we wait for 3 seconds
    And we validate available to ship
    And we click on Add to Cart button
    And we click GO TO CART
    And we should see "Free Shipping Plus Free Returns on CALIA!"
    And we see a shipping discount of "-3.50"
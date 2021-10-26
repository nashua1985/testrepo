Feature: Regression_CART_006_Verify_Non-Qualifying_to_Qualifying_Cart
  Background: open page
    Given we are on "nikeHeadbands" page

  @CART
  @Smoke
  @Regression
  @CART_006
  @CART_mobile
  Scenario: Regression_CART_006_Verify_Non-Qualifying_to_Qualifying_Cart
    When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
    Given we are on "nikeHeadbands" page
    And we wait for 10 seconds
    And we click  Ship to me
	And we click on the first product in search grid
	And we select attributes
    And we wait for 3 seconds
    And we validate available to ship
    And we click on Add to Cart button
	And we click GO TO CART
	Then we see a shipping discount of "$6.99"
	
	Given we are on "caliaBrand" page
	And we filter by items less than $50
	And we click on the first product in search grid
    And we select attributes
    And we wait for 3 seconds
    And we validate available to ship
    And we click on Add to Cart button
    And we click GO TO CART
	And we should see "Free Shipping Plus Free Returns on CALIA!"
	Then we see a shipping discount of "-3.50"
	And we remove the "nike headband" item from the cart
	Then we see a shipping discount of "free"
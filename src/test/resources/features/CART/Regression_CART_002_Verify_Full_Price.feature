Feature: Regression_CART_002_Verify_Full_Price
  Background: open page
    Given we are on "yetiBrand" page

  @CART
  @Smoke
  @Regression
  @CART_002
  @CART_mobile
  Scenario: Regression_CART_002_Verify_Full_Price
    When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
    Given we are on "yetiBrand" page
    And we wait for 10 seconds
    And we click  Ship to me
    And we click on the first product in search grid
    And we select the color Black
    And we wait for 3 seconds
    And we validate available to ship
	And we remember the product price
    #intention: to see if ATC should be successful, is there availability to add to cart
    And we click on Add to Cart button
    And we click GO TO CART
    And we verify the product price

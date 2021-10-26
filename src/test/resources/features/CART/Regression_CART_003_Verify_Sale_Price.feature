Feature: Regression_CART_003_Verify_Sale_Price
  Background: open page
    Given we are on "womensHoodies" page

  @CART
  @Smoke
  @Regression
  @CART_003
  Scenario: Regression_CART_003_Verify_Full_Price
    When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
    Given we are on "womensHoodies" page
    And we wait for 10 seconds
    And we click  Ship to me
    And we sort by Price High to Low
    And we filter by sale items
	And we click on the first product in search grid
    And we select attributes for sale item
    And we wait for 3 seconds
    And we validate available to ship
	And we remember the product price
	And we remember the original price
    #intention: to see if ATC should be successful, is there availability to add to cart
    And we click on Add to Cart button
    And we click GO TO CART
    And we verify the discounted product price
	And we verify the original price

  @CART_mobile
  @Regression
  @CART_003
  Scenario: Regression_CART_003_Verify_Full_Price
    When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
    Given we are on "womensHoodies" page
    And we wait for 10 seconds
    And we click  Ship to me
    And we sort by Price High to Low
    And we click on the filter button
    And we filter by sale items
    And we click on the first product in search grid
    And we select attributes for sale item
    And we wait for 3 seconds
    And we validate available to ship
    And we remember the product price
    And we remember the original price
    #intention: to see if ATC should be successful, is there availability to add to cart
    And we click on Add to Cart button
    And we click GO TO CART
    And we verify the discounted product price
    And we verify the original price
Feature: Regression_CART_001_Product_Details
  Background: open page
    Given we are on "womensHoodies" page

  @CART
  @Smoke
  @Regression
  @CART_001
  Scenario: Regression_CART_001_Product_Details
    When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
    Given we are on "womensHoodies" page
    And we wait for 10 seconds
    And we click  Ship to me
    And we filter by the color "Black" and the size "Medium"
    And we click on the first product in search grid
    And we select the color Black
    And we select the size Medium
    And we wait for 3 seconds
    And we validate available to ship
    #intention: to see if ATC should be successful, is there availability to add to cart
    And we click on Add to Cart button
    And we click GO TO CART
    And we click the details section
    And we verify product quantity is "1"
    #currently this is not pulling the value correctly needs to be remedied
	Then we click the details section

  @CART_mobile
  @Regression
  @CART_001_mobile
  Scenario: Regression_CART_001_Product_Details
    When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
    Given we are on "womensHoodies" page
    And we wait for 10 seconds
    And we click  Ship to me
    And we click on the filter button
    And we filter by the color "Black" and the size "Medium"
    And we click on the first product in search grid
    And we select the color Black
    And we select the size Medium
    And we wait for 3 seconds
    And we validate available to ship
    #intention: to see if ATC should be successful, is there availability to add to cart
    And we click on Add to Cart button
    And we click GO TO CART
    And we click the details section
    And we verify product quantity is "1"
    #currently this is not pulling the value correctly needs to be remedied
    Then we click the details section
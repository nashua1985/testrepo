Feature: Regression_CART_004_Verify_Item_Level_Promotion
  Background: open page
    Given we are on "caliaBrand" page

  @CART
  @Smoke
  @Regression
  @CART_004
  @CART_mobile
  Scenario: Regression_CART_004_Verify_Item_Level_Promotion
    When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
    Given we are on "caliaBrand" page
    And we wait for 10 seconds
    And we click  Ship to me
	And we click on the first product in search grid
    And we select attributes
    And we wait for 3 seconds
    And we validate available to ship
    And we click on Add to Cart button
    And we click GO TO CART
    And we should see "Free Shipping Plus Free Returns on CALIA!"
	And we click the item level promotion info link
    And we should see "Promotion Info"
    And we click Close
	And we see a shipping discount of "free"
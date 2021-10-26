Feature: Regression_CART_009_Verify_Order_Level_Promotion
  Background: open page
    Given we are on "yetiBrand" page

  @CART
  @Smoke
  @Regression
  @CART_009
  @CART_mobile
  Scenario: Regression_CART_009_Verify_Order_Level_Promotion
    When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
    Given we are on "yetiBrand" page
    And we wait for 10 seconds
    And we click  Ship to me
    And we filter by items less than $50
	And we click on the first product in search grid
	And we select the color Navy
    And we wait for 3 seconds
    And we validate available to ship
    And we click on Add to Cart button
	And we click GO TO CART
	Then we see a shipping discount of "$6.99"
	
	And we update the Qty of the Navy yeti to "10"
	And we click Tab
    And we wait for 3 seconds
	And we should see "Free Shipping on Orders $65 or More!"
	Then we see a shipping discount of "Free"
    And we click the shipping promotion info link
    Then we should see "Promotion Info"
	And we click outside of the promotion info
	#then the promo info iframe should close

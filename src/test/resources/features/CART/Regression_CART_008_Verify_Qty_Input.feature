Feature: Regression_CART_008_Verify_Qty_Input
  Background: open page
    Given we are on "yetiBrand" page

  @CART
  @Smoke
  @Regression
  @CART_008
  @CART_mobile
  Scenario: Regression_CART_008_Verify_Qty_Input
	  When we add cookies to block medalia popup:
		  |BlockedTags|Medallia|
	  Given we are on "yetiBrand" page
	  And we wait for 10 seconds
  	And we click  Ship to me
	And we click on the first product in search grid
	And we select the color Navy
    And we wait for 3 seconds
    And we validate available to ship
    And we click on Add to Cart button
  	And we click GO TO CART

	
	And we update the Qty of the Navy yeti to "4"
  	And we click Tab
	#And we see Order Summary update
   	Then we should see "4 items"
	
	And we update the Qty of the Navy yeti to "100"
	And we click Tab
	#And we see Order Summary update
	And we should see "We have updated the quantity to the maximum available."
	  Then we should see "99 items"
	#or the qty available
	
	And we update the Qty of the Navy yeti to "1"
	And we click Tab
	#And we see Order Summary update
   	Then we should see "1 item"
	
	And we update the Qty of the Navy yeti to "0"
	And we click Tab
	#And we should NOT see Order Summary update
   	Then we should see "1 item"

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
	
	And we update the Qty of the hoodie to "2"
	And we click Tab
	#And we see Order Summary update
	Then we should see "3 items"
	#if qty available for pickup is >=2
	
	And we update the Qty of the hoodie to "100"
	And we click Tab
	#And we see Order Summary update
	#And we see "We updated this item to ship"
	And we should see "We have updated the quantity to the maximum available"
	#And we verify that the Black yeti has STH fulfillment
	Then we should see "100 items"
	#or the qty available
	
	And we update the Qty of the hoodie to "1"
	And we click Tab
	#And we see Order Summary update
	And we update to BOPIS fulfillment
	#And we see Order Summary update
	Then we should see "2 items"
	
	And we update the Qty of the hoodie to "0"
	And we click Tab
	#And we should NOT see Order Summary update
	And we should see "2 items"
	

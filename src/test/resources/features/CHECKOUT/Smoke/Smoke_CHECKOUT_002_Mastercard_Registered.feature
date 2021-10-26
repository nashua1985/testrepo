Feature: Smoke_CHECKOUT_002_Mastercard_Registered
  Background: open page
    Given we are on "dsg" page


  @Checkout_Smoke
  @CHECKOUT_Smoke_002
  Scenario: Smoke_CHECKOUT_002_Mastercard_Registered
	  When we add cookies to block medalia popup:
		  |BlockedTags|Medallia|
	  Given we are on "dsg" page
	  And we wait for 10 seconds
  	And we add a product "calia headband" to cart
	And we select CHECKOUT
    And we wait for 3 seconds
    
	And we click Sign In
	And we sign in as a registered user
	And we validate Contact and Address info is prefilled
	  #including scorecard
	And we click Continue to Payment
	
	And we add the TE Mastercard
	And we click Place Order
	And we remember the order id
  	Then we should see "Thank you for your order, Test!"

	  Given we send api request to cancel a order
	  Then the order status should be canceled
#	//this next part has to be done in chrome but test above should run across browsers
	  #credentials
	  #web service call to delete order
	#Given we are on solepanel page
  	#And we wait for 3 seconds
	#And we enter our credentials
	#And we search for the order id
	#And we cancel the order
	#Then the order status should be canceled
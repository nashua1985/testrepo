Feature: Smoke_CHECKOUT_004_PayPal_Express
  Background: open page
    Given we are on "dsg" page


  #@Checkout_Smoke
  @CHECKOUT_Smoke_004
  Scenario: Smoke_CHECKOUT_004_PayPal_Express
	  When we add cookies to block medalia popup:
		  |BlockedTags|Medallia|
	  Given we are on "dsg" page
	  And we wait for 10 seconds
	And we add a product "calia headçband" to cart
	And we select PayPal Checkout
    And we wait for 3 seconds

	And we add Paypal Email and click Next
	And we add PayPal Password and click Log In
	And we click Continue
  	And we wait for 7 seconds
	
	And we click Place Order
	And we remember the order id
  	Then we should see "Thank you for your order"


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
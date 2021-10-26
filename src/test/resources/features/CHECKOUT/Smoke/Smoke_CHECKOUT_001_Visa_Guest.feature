Feature: Smoke_CHECKOUT_001_Visa_Guest
  Background: open page
    Given we are on "dsg" page


  @Checkout_Smoke
  @CHECKOUT_Smoke_001
  Scenario: Smoke_CHECKOUT_001_VISA_Guest
  	When we add cookies to block medalia popup:
		|BlockedTags|Medallia|
  	Given we are on "dsg" page
  	And we wait for 10 seconds
  	And we add a product "calia headband" to cart
	And we select CHECKOUT
    And we wait for 3 seconds
    
	And we validate Contact and Address info is not prefilled
	And we add first name "Test"
	And we add last name "Tester"
	And we add email "automation@dcsg.com"
	And we add phone number "7242733400"
	And we add street address "345 Court St"
	And we add zip code "15108"
	And we click Continue to Payment
  	And we wait for 3 seconds
	And we add the TE Visa
	And we click Place Order
  	And we wait for 3 seconds
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
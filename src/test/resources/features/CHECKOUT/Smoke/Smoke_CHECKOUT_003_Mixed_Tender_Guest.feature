Feature: Smoke_CHECKOUT_003_Mixed_Tender_Guest
  Background: open page
    Given we are on "dsg" page


  @Checkout_Smoke
  @CHECKOUT_Smoke_003
  Scenario: Smoke_CHECKOUT_003_Mixed_Tender_Guest
	  When we add cookies to block medalia popup:
		  |BlockedTags|Medallia|
	  Given we are on "dsg" page
	  And we wait for 10 seconds
	  And we add a product "calia headband" to cart
	And we select CHECKOUT
    And we wait for 3 seconds
    
	And we validate Contact and Address info is not prefilled
  	And we uncheck the same billing and shipping address checkbox
	And we add first name "Test"
	And we add last name "Tester"
	And we add email "automation@dcsg.com"
	And we add phone number "7242733400"


  	#And we click Tab
	And we add street address "345 Court St"
	And we add zip code "15108"
	And we add street address "202 Eastview Mall" as shipping address
	And we add zip code "14564" as shipping zip code
	And we click Continue to Payment
	
	And we add TE GC
  	And we should see "Gift Card Applied"
	And we see the Gift Card in the order summary
	And we add the TE Visa
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
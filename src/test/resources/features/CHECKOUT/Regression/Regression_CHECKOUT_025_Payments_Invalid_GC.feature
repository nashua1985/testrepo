Feature: Regression_CHECKOUT_025_Payments_Invalid_GC
	Background: open page


  @CHECKOUT
  @Regression
  @CHECKOUT_025
  Scenario: Regression_CHECKOUT_025_Payments_Invalid_GC
	  Given we are on "dsg" page
	  When we add cookies to block medalia popup:
		  |BlockedTags|Medallia|
	  Given we are on "dsg" page
	  And we wait for 10 seconds
	And we add a product "nike headband" to cart
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
	  And we should see "Contact Info, Billing Address, Items Details"
	
	
	And we add "6168432776392640" as Gift Card Account Number
	And we add "07208810" as Gift Card Pin Code
	#invalid acct number
	Then we should see "There is no remaining balance on this gift card"
	And Gift Card is not added to order summary
	
	And we change "6168432436407186" as Gift Card Account Number
	And we change "00021229" as Gift Card Pin Code
	#invalid pin code
	Then we should see "There is no remaining balance on this gift card"
	And Gift Card is not added to order summary


	@CHECKOUT_DELTA
	@Regression
	@CHECKOUT_DELTA_025
	Scenario: Regression_CHECKOUT_025_Payments_Invalid_GC
		Given we are on "dsgdelta" page
		When we add cookies to block medalia popup:
			|BlockedTags|Medallia|
		When we add cookies to access delta:
			|delta|True|
			|cart |True|
		Given we are on "dsgdelta" page
		And we wait for 10 seconds
		And we select the TEST1 button
		And we add a product "nike headband" to cart
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
		And we should see "Contact Info, Billing Address, Items Details"


		And we add "6168432776392640" as Gift Card Account Number
		And we add "07208810" as Gift Card Pin Code
	#invalid acct number
		Then we should see "There is no remaining balance on this gift card"
		And Gift Card is not added to order summary

		And we change "6168432436407186" as Gift Card Account Number
		And we change "00021229" as Gift Card Pin Code
	#invalid pin code
		Then we should see "There is no remaining balance on this gift card"
		And Gift Card is not added to order summary
	
	
	
	
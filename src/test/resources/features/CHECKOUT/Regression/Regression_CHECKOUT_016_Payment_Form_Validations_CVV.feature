Feature: Regression_CHECKOUT_016_Payment_Form_Validations_CVV
	Background: open page


  @CHECKOUT
  @Regression
  @CHECKOUT_016
  Scenario: Regression_CHECKOUT_016_Payment_Form_Validations_CVV
	  Given we are on "dsg" page
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
	
	And we enter "4250973567565756" in the Credit Card Number field
	And we enter "01/24" in the Exp. date field
	And we enter "3333" in the CVV field
	And we click Place Order
	Then we should see "There was an issue processing your payment information."

	@CHECKOUT_DELTA
	@Regression
	@CHECKOUT_DELTA_016
	Scenario: Regression_DELTA_CHECKOUT_016_Payment_Form_Validations_CVV
		Given we are on "dsgdelta" page
		When we add cookies to block medalia popup:
			|BlockedTags|Medallia|
		When we add cookies to access delta:
			|delta|True|
			|cart |True|
		Given we are on "dsgdelta" page
		And we wait for 10 seconds
		And we select the TEST1 button
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

		And we enter "4250973567565756" in the Credit Card Number field
		And we enter "01/24" in the Exp. date field
		And we enter "3333" in the CVV field
		And we click Place Order
		Then we should see "There was an issue processing your payment information."
Feature: Regression_CHECKOUT_023_Payments_Invalid_RWD
	Background: open page


  @CHECKOUT
  @Regression
  @CHECKOUT_023
  Scenario: Regression_CHECKOUT_023_Payments_Invalid_RWD
	  Given we are on "dsg" page
	  When we add cookies to block medalia popup:
		  |BlockedTags|Medallia|
	  Given we are on "dsg" page
	  And we wait for 10 seconds
	And we add a product "nike headband" to cart
	  And we change the quantity of first item in cart to "2"
	  And we add a product "calia headband" to cart
	  And we change the quantity of first item in cart to "3"
	And we select CHECKOUT
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
	
	And we enter "RWDN2M7G3R2" in the promo code field
	And we click Apply Code
	Then we should see "Promo code RWDN2M7G3R2 is not valid."

	@CHECKOUT_DELTA
	@Regression
	@CHECKOUT_DELTA_023
	Scenario: Regression_DELTA_CHECKOUT_023_Payments_Invalid_RWD
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
		And we change the quantity of first item in cart to "2"
		And we add a product "calia headband" to cart
		And we change the quantity of first item in cart to "3"
		And we select CHECKOUT
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

		And we enter "RWDN2M7G3R2" in the promo code field
		And we click Apply Code
		Then we should see "Promo code RWDN2M7G3R2 is not valid."
	
	
Feature: Regression_CHECKOUT_003_AVS_Same_Billing_Shippping_Invalid_Guest
  Background: open page
    #Given we are on "dsg" page

  @CHECKOUT
  @Regression
  @CHECKOUT_003
  Scenario: Regression_CHECKOUT_003_AVS_Different_Billing_Shippping_Invalid_Shipping_Guest
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
	And we add zip code "30005"
	And we click Continue to Payment
	
	Then we should see "We could not identify your billing address. Please check your Street Address and Zip Code."

	@CHECKOUT_DELTA
	@Regression
	@CHECKOUT_DELTA_003
	Scenario: Regression_DELTA_CHECKOUT_003_AVS_Different_Billing_Shippping_Invalid_Shipping_Guest
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
		And we add zip code "30005"
		And we click Continue to Payment

		Then we should see "We could not identify your billing address. Please check your Street Address and Zip Code."
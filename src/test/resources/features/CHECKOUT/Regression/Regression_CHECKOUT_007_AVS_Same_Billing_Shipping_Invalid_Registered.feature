Feature: Regression_CHECKOUT_007_AVS_Same_Billing_Shipping_Invalid_Registered
  Background: open page


  @CHECKOUT
  @Regression
  @CHECKOUT_007
  Scenario: Regression_CHECKOUT_007_AVS_Same_Billing_Shipping_Invalid_Registered
	  Given we are on "dsg" page
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

	And we change only street address "345 Court St" as billing address
	And we change only zip code "30005" as billing zip code
	And we click Continue to Payment

	Then we should see "We could not identify your billing address. Please check your Street Address and Zip Code."

	@CHECKOUT_DELTA
	@Regression
	@CHECKOUT_DELTA_007
	Scenario: Regression_DELTA_CHECKOUT_007_AVS_Same_Billing_Shipping_Invalid_Registered
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

		And we click Sign In
		And we sign in as a registered user
		And we validate Contact and Address info is prefilled
	  #including scorecard

		And we change only street address "345 Court St" as billing address
		And we change only zip code "30005" as billing zip code
		And we click Continue to Payment

		Then we should see "We could not identify your billing address. Please check your Street Address and Zip Code."
	
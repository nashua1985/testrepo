Feature: Regression_CHECKOUT_006_AVS_Different_Billing_Shipping_Invalid_Shipping_Registered
  Background: open page


  @CHECKOUT
  @Regression
  @CHECKOUT_006
  Scenario: Regression_CHECKOUT_006_AVS_Different_Billing_Shipping_Invalid_Shiping_Registered
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
	  
	And we uncheck the same billing and shipping address checkbox
	And we change street address "345 Court St" as billing address
	And we change zip code "15108" as billing zip code
	And we change street address "9999 Eastview Mall" as shipping address
	And we change zip code "14564" as shipping zip code
	And we click Continue to Payment

	Then we should see "We could not identify your shipping address. Please check your Street Address and Zip Code."

	@CHECKOUT_DELTA
	@Regression
	@CHECKOUT_DELTA_006
	Scenario: Regression_DELTA_CHECKOUT_006_AVS_Different_Billing_Shipping_Invalid_Shiping_Registered
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

		And we uncheck the same billing and shipping address checkbox
		And we change street address "345 Court St" as billing address
		And we change zip code "15108" as billing zip code
		And we change street address "9999 Eastview Mall" as shipping address
		And we change zip code "14564" as shipping zip code
		And we click Continue to Payment

		Then we should see "We could not identify your shipping address. Please check your Street Address and Zip Code."
	
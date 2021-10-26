Feature: Regression_CHECKOUT_012_Tax_Soft_Lines
  Background: open page


  @CHECKOUT
  @Regression
  @CHECKOUT_012
  Scenario: Regression_CHECKOUT_012_Tax_Soft_Lines
	  Given we are on "dsg" page
	  When we add cookies to block medalia popup:
		  |BlockedTags|Medallia|
	  Given we are on "dsg" page
	  And we wait for 10 seconds
	#And we add a soft line product to cart
  	And we add a product "yeti" to cart
	#clothing
	And we select CHECKOUT
    And we wait for 3 seconds
    
	And we validate Contact and Address info is not prefilled
	And we add first name "Test"
	And we add last name "Tester"
	And we add email "automation@dcsg.com"
	And we add phone number "7242733400"

	And we add street address "345 Court St"
	And we add zip code "15108"
  	#And we click enter
	And we click Continue to Payment
	Then we validate that est tax is "0.00"
	
	And we go back to Address Delivery page
	#And we edit address
	And we change street address "770 Pacific Coast Hwy"
	And we change zip code "90245"
	And we click Continue to Payment
	Then we validate that est tax is equal to ".095" multiplied by the order total



	@CHECKOUT_DELTA
	@Regression
	@CHECKOUT_DELTA_012
	Scenario: Regression_DELTA_CHECKOUT_012_Tax_Soft_Lines
		Given we are on "dsgdelta" page
		When we add cookies to block medalia popup:
			|BlockedTags|Medallia|
		When we add cookies to access delta:
			|delta|True|
			|cart |True|
		Given we are on "dsgdelta" page
		And we wait for 10 seconds
		And we select the TEST1 button
	#And we add a soft line product to cart
		And we add a product "yeti" to cart
	#clothing
		And we select CHECKOUT
		And we wait for 3 seconds

		And we validate Contact and Address info is not prefilled
		And we add first name "Test"
		And we add last name "Tester"
		And we add email "automation@dcsg.com"
		And we add phone number "7242733400"

		And we add street address "345 Court St"
		And we add zip code "15108"
  	#And we click enter
		And we click Continue to Payment
		Then we validate that est tax is "0.00"

		And we go back to Address Delivery page
	#And we edit address
		And we change street address "770 Pacific Coast Hwy"
		And we change zip code "90245"
		And we click Continue to Payment
		Then we validate that est tax is equal to ".095" multiplied by the order total
	
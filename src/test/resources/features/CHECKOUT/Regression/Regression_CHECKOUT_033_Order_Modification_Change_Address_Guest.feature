Feature: Regression_CHECKOUT_033_Order_Modification_Change_Address_Guest
	Background: open page


  @CHECKOUT
  @Regression
  @CHECKOUT_033
  Scenario: Regression_CHECKOUT_033_Order_Modification_Change_Address_Guest
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

	Then billing address is "345 Court St Coraopolis, PA 15108-3817"
	Then shipping address is "345 Court St Coraopolis, PA 15108-3817"

	And we go back to Address Delivery page

	  And we uncheck the same billing and shipping address checkbox
	  And we change street address "345 Court St" as billing address
	  And we change zip code "15108" as billing zip code
	  And we change street address "202 Eastview Mall" as shipping address
	  And we change zip code "14564" as shipping zip code
	  And we click Continue to Payment

	  And we wait for 3 seconds
	  And we should see "Contact Info, Billing Address, Items Details"

	Then billing address is "345 Court St Coraopolis, PA 15108-3817"
	Then shipping address is "202 Eastview Mall Victor, NY 14564-1013"


	@CHECKOUT_DELTA
	@Regression
	@CHECKOUT_DELTA_033
	Scenario: Regression_DELTA_CHECKOUT_033_Order_Modification_Change_Address_Guest
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

		Then billing address is "345 Court St Coraopolis, PA 15108-3817"
		Then shipping address is "345 Court St Coraopolis, PA 15108-3817"

		And we go back to Address Delivery page

		And we uncheck the same billing and shipping address checkbox
		And we change street address "345 Court St" as billing address
		And we change zip code "15108" as billing zip code
		And we change street address "202 Eastview Mall" as shipping address
		And we change zip code "14564" as shipping zip code
		And we click Continue to Payment

		And we wait for 3 seconds
		And we should see "Contact Info, Billing Address, Items Details"

		Then billing address is "345 Court St Coraopolis, PA 15108-3817"
		Then shipping address is "202 Eastview Mall Victor, NY 14564-1013"
Feature: Regression_CHECKOUT_034_Order_Modification_Change_Address_Registered
	Background: open page


	@CHECKOUT
  @Regression
  @CHECKOUT_034
  Scenario: Regression_CHECKOUT_034_Order_Modification_Change_Address_Registered
		Given we are on "dsg" page
	  When we add cookies to block medalia popup:
		  |BlockedTags|Medallia|
	  Given we are on "dsg" page
	  And we wait for 10 seconds
	And we add a product "nike headband" to cart
	And we select CHECKOUT
    And we wait for 3 seconds
    
	And we click Sign In
	And we sign in as a registered user
	And we validate Contact and Address info is prefilled
	And we click Continue to Payment
	  And we wait for 3 seconds
	  And we should see "Contact Info, Billing Address, Items Details"
	
	And billing address is "345 Court St Coraopolis, PA 15108-3817"
	And shipping address is "345 Court St Coraopolis, PA 15108-3817"
	
	And we go back to Address Delivery page
	And we modify first name to "Automation"
	And we click Continue to Payment
	  And we wait for 3 seconds
	  And we should see "Contact Info, Billing Address, Items Details"
	
	And we go back to Address Delivery page
	And we uncheck the same billing and shipping address checkbox
	And we change street address "7325 Woodhaven Blvd" as billing address
	And we change zip code "11385" as billing zip code
	And we change street address "200 Eastview Mall" as shipping address
	And we change zip code "14564" as shipping zip code
	And we click Continue to Payment
	  And we wait for 3 seconds
	  And we should see "Contact Info, Billing Address, Items Details"
	
	Then billing address is "7325 Woodhaven Blvd Glendale, NY 11385"
	Then shipping address is "200 Eastview Mall Victor, NY 14564"


	@CHECKOUT_DELTA
	@Regression
	@CHECKOUT_DELTA_034
	Scenario: Regression_DELTA_CHECKOUT_034_Order_Modification_Change_Address_Registered
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

		And we click Sign In
		And we sign in as a registered user
		And we validate Contact and Address info is prefilled
		And we click Continue to Payment
		And we wait for 3 seconds
		And we should see "Contact Info, Billing Address, Items Details"

		And billing address is "345 Court St Coraopolis, PA 15108-3817"
		And shipping address is "345 Court St Coraopolis, PA 15108-3817"

		And we go back to Address Delivery page
		And we modify first name to "Automation"
		And we click Continue to Payment
		And we wait for 3 seconds
		And we should see "Contact Info, Billing Address, Items Details"

		And we go back to Address Delivery page
		And we uncheck the same billing and shipping address checkbox
		And we change street address "7325 Woodhaven Blvd" as billing address
		And we change zip code "11385" as billing zip code
		And we change street address "200 Eastview Mall" as shipping address
		And we change zip code "14564" as shipping zip code
		And we click Continue to Payment
		And we wait for 3 seconds
		And we should see "Contact Info, Billing Address, Items Details"

		Then billing address is "7325 Woodhaven Blvd Glendale, NY 11385"
		Then shipping address is "200 Eastview Mall Victor, NY 14564"
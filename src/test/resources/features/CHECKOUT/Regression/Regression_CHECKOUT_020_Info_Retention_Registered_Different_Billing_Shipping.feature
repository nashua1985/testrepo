Feature: Regression_CHECKOUT_020_Info_Retention_Registered_Different_Billing_Shipping
	Background: open page


	@CHECKOUT
  @Regression
  @CHECKOUT_020
  Scenario: Regression_CHECKOUT_020_Info_Retention_Registered_Different_Billing_Shipping
		Given we are on "dsg" page
	  When we add cookies to block medalia popup:
		  |BlockedTags|Medallia|
	  Given we are on "dsg" page
	  And we wait for 10 seconds
	  And  we add a product "nike headband" to cart
	  And we change the quantity of first item in cart to "2"
	  And we add a product "calia headband" to cart
	  And we change the quantity of first item in cart to "3"
	  And we add a BOPIS product "yeti" to the cart
	  And we remember product name, attributes, and qty for items in cart
	  And we remember BOPIS store name
	  And we select CHECKOUT
	  And we wait for 3 seconds

	  And we click Sign In
	  And we sign in as a registered user
	And we validate Contact and Address info is prefilled
	And we uncheck the same billing and shipping address checkbox
	And we add street address "345 Court St" as billing address
	And we add zip code "15108" as billing zip code
	And we add street address "328 NE Northgate Way" as shipping address
	And we add zip code "98125" as shipping zip code
	And we click Continue to Payment
	  And we wait for 3 seconds
	  And we should see "Contact Info, Billing Address, Items Details"

	And we should see "Test Tester"
	And we should see "automation@dcsg"
	And we should see "(724) 273-3400"
	And billing address is "345 Court St Coraopolis, PA 15108-3817"
	And shipping address is "328 NE Northgate Way Seattle, WA 98125-6047"
	And we validate product name, attributes, and qty for items in cart
	And we validate BOPIS store name
  	And we should see "#L011B2536J9D"


	@CHECKOUT_DELTA
	@Regression
	@CHECKOUT_DELTA_020
	Scenario: Regression_DELTA_CHECKOUT_020_Info_Retention_Registered_Different_Billing_Shipping
		Given we are on "dsgdelta" page
		When we add cookies to block medalia popup:
			|BlockedTags|Medallia|
		When we add cookies to access delta:
			|delta|True|
			|cart |True|
		Given we are on "dsgdelta" page
		And we wait for 10 seconds
		And we select the TEST1 button
		And  we add a product "nike headband" to cart
		And we change the quantity of first item in cart to "2"
		And we add a product "calia headband" to cart
		And we change the quantity of first item in cart to "3"
		And we add a BOPIS product "yeti" to the cart
		And we remember product name, attributes, and qty for items in cart
		And we remember BOPIS store name
		And we select CHECKOUT
		And we wait for 3 seconds

		And we click Sign In
		And we sign in as a registered user
		And we validate Contact and Address info is prefilled
		And we uncheck the same billing and shipping address checkbox
		And we add street address "345 Court St" as billing address
		And we add zip code "15108" as billing zip code
		And we add street address "328 NE Northgate Way" as shipping address
		And we add zip code "98125" as shipping zip code
		And we click Continue to Payment
		And we wait for 3 seconds
		And we should see "Contact Info, Billing Address, Items Details"

		And we should see "Test Tester"
		And we should see "automation@dcsg"
		And we should see "(724) 273-3400"
		And billing address is "345 Court St Coraopolis, PA 15108-3817"
		And shipping address is "328 NE Northgate Way Seattle, WA 98125-6047"
		And we validate product name, attributes, and qty for items in cart
		And we validate BOPIS store name
		And we should see "#L011B2536J9D"
	
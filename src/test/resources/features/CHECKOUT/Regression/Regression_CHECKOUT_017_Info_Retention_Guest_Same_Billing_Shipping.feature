Feature: Regression_CHECKOUT_017_Info_Retention_Guest_Same_Billing_Shipping
	Background: open page


  @CHECKOUT
  @Regression
  @CHECKOUT_017
  Scenario: Regression_CHECKOUT_017_Info_Retention_Guest_Same_Billing_Shipping
	  Given we are on "dsg" page
	  When we add cookies to block medalia popup:
		  |BlockedTags|Medallia|
	  Given we are on "dsg" page
	  And we wait for 10 seconds
	  And we add a product "nike headband" to cart
	  And we change the quantity of items in cart to "2"
	  And we add a product "kayak" to cart
	  And we add a BOPIS product "yeti" to the cart
	#And we add a parcel product to cart
   	# And we add an oversized product to the cart
	#And we add a BOPIS product to the cart
	And we remember product name, attributes, and qty for items in cart
	And we remember BOPIS store name
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

  	And we wait for 5 seconds
	And we should see "Test Tester"
	And we should see "automation@dcsg.com"
	And we should see "(724) 273-3400"
	And billing address is "345 Court St Coraopolis, PA 15108-3817"
	And shipping address is "345 Court St Coraopolis, PA 15108-3817"
	And we validate product name, attributes, and qty for items in cart
	And we validate BOPIS store name


	@CHECKOUT_DELTA
	@Regression
	@CHECKOUT_DELTA_017
	Scenario: Regression_DELTA_CHECKOUT_017_Info_Retention_Guest_Same_Billing_Shipping
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
		And we change the quantity of items in cart to "2"
		And we add a product "kayak" to cart
		And we add a BOPIS product "yeti" to the cart
	#And we add a parcel product to cart
   	# And we add an oversized product to the cart
	#And we add a BOPIS product to the cart
		And we remember product name, attributes, and qty for items in cart
		And we remember BOPIS store name
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

		And we wait for 5 seconds
		And we should see "Test Tester"
		And we should see "automation@dcsg.com"
		And we should see "(724) 273-3400"
		And billing address is "345 Court St Coraopolis, PA 15108-3817"
		And shipping address is "345 Court St Coraopolis, PA 15108-3817"
		And we validate product name, attributes, and qty for items in cart
		And we validate BOPIS store name
	
	
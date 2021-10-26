Feature: Regression_CHECKOUT_029_Order_Modification_Add_Restricted_Product
  Background: open page


  @CHECKOUT
  @Regression
  @CHECKOUT_029
  Scenario: Regression_CHECKOUT_029_Order_Modification_Add_Restricted_Product
	  Given we are on "dsg" page
	  When we add cookies to block medalia popup:
		  |BlockedTags|Medallia|
	  Given we are on "dsg" page
	  And we wait for 10 seconds
	And we add a product "nike headband" to cart
	And we remember product name, attributes, and qty for items in cart
	And we select CHECKOUT
    And we wait for 3 seconds
	
	And we add first name "Test"
	And we add last name "Tester"
	And we add email "automation@dcsg.com"
	And we add phone number "7242733400"
	And we add street address "73-25 Woodhaven Blvd"
	And we add zip code "11385"
	And we click Continue to Payment
	  And we wait for 3 seconds
	  And we should see "Contact Info, Billing Address, Items Details"
	
	And we validate product name, attributes, and qty for items in cart
	
	And we click the DSG Logo
	And we add a product "mace" to cart
	And we remember product name, attributes, and qty for items in cart
	And we select CHECKOUT
    And we wait for 3 seconds
	And we click Continue to Payment
  	And we wait for 3 seconds
	Then we should see "Due to shipping restrictions"


	@CHECKOUT_DELTA
	@Regression
	@CHECKOUT_DELTA_029
	Scenario: Regression_DELTA_CHECKOUT_029_Order_Modification_Add_Restricted_Product
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
		And we remember product name, attributes, and qty for items in cart
		And we select CHECKOUT
		And we wait for 3 seconds

		And we add first name "Test"
		And we add last name "Tester"
		And we add email "automation@dcsg.com"
		And we add phone number "7242733400"
		And we add street address "73-25 Woodhaven Blvd"
		And we add zip code "11385"
		And we click Continue to Payment
		And we wait for 3 seconds
		And we should see "Contact Info, Billing Address, Items Details"

		And we validate product name, attributes, and qty for items in cart

		And we click the DSG Logo
		And we add a product "mace" to cart
		And we remember product name, attributes, and qty for items in cart
		And we select CHECKOUT
		And we wait for 3 seconds
		And we click Continue to Payment
		And we wait for 3 seconds
		Then we should see "Due to shipping restrictions"

	
	
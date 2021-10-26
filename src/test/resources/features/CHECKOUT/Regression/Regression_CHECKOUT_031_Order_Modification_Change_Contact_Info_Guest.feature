Feature: Regression_CHECKOUT_031_Order_Modification_Change_Contact_Info_Guest
	Background: open page


  @CHECKOUT
  @Regression
  @CHECKOUT_031
  Scenario: CHECKOUT_031_Order_Modification_Change_Contact_Info_Guest
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

	And we should see "Test Tester"
	And we should see "automation@dcsg"
	And we should see "(724) 273-3400"
	
	And we go back to Address Delivery page
	And we modify first name to "Automation"
	And we click Continue to Payment
	  And we wait for 3 seconds
	  And we should see "Contact Info, Billing Address, Items Details"
	
	And we should see "Automation Tester"
	And we should see "automation@dcsg"
	And we should see "(724) 273-3400"


	@CHECKOUT_DELTA
	@Regression
	@CHECKOUT_DELTA_031
	Scenario: CHECKOUT_DELTA_031_Order_Modification_Change_Contact_Info_Guest
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

		And we should see "Test Tester"
		And we should see "automation@dcsg"
		And we should see "(724) 273-3400"

		And we go back to Address Delivery page
		And we modify first name to "Automation"
		And we click Continue to Payment
		And we wait for 3 seconds
		And we should see "Contact Info, Billing Address, Items Details"

		And we should see "Automation Tester"
		And we should see "automation@dcsg"
		And we should see "(724) 273-3400"
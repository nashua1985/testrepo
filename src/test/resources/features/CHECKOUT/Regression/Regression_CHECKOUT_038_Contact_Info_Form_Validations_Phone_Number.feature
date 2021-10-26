Feature: Regression_CHECKOUT_038_Contact_Info_Form_Validations_Phone_Number
  Background: open page


  @CHECKOUT
  @Regression
  @CHECKOUT_038
  Scenario: Regression_CHECKOUT_038_Contact_Info_Form_Validations_Phone_Number
    Given we are on "dsg" page
    When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
    Given we are on "dsg" page
    And we wait for 10 seconds
	And we add a product "nike headband" to cart
	And we select CHECKOUT
    And we wait for 3 seconds
	
	And we add first name "automation" 
	And we add last name "tester" 
	And we add email "automation@dcsg.com"
	And enter the following in the phone number field form box should be highlighted in red
      |(724) 333-3333|
      |(111) 111-1111|
      |(000) 000-0000|

	And enter the following in the phone number field form box should NOT be highlighted in red
      |(222) 222-2222|
      |(412) 939-2888|


  @CHECKOUT_DELTA
  @Regression
  @CHECKOUT_DELTA_038
  Scenario: Regression_CHECKOUT_038_Contact_Info_Form_Validations_Phone_Number
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

    And we add first name "automation"
    And we add last name "tester"
    And we add email "automation@dcsg.com"
    And enter the following in the phone number field form box should be highlighted in red
      |(724) 333-3333|
      |(111) 111-1111|
      |(000) 000-0000|

    And enter the following in the phone number field form box should NOT be highlighted in red
      |(222) 222-2222|
      |(412) 939-2888|

	
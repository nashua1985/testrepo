Feature: Regression_CHECKOUT_035_Contact_Info_Form_Validations_First_Name
  Background: open page


  @CHECKOUT
  @Regression
  @CHECKOUT_035
  Scenario: Regression_CHECKOUT_035_Contact_Info_Form_Validations_First_Name
    Given we are on "dsg" page
    When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
    Given we are on "dsg" page
    And we wait for 10 seconds
	And we add a product "nike headband" to cart
	And we select CHECKOUT
    And we wait for 3 seconds
	
	And enter the following in the first name field form box should be highlighted in red
      |t           |
      |234234234   |
      |test.       |
      |test!       |
      |te$t	       |
      |Test (test1)|


	And enter the following in the first name field form box should NOT be highlighted in red
      |test             |
      |automation-tester|
      |test one   	    |



  @CHECKOUT_DELTA
  @Regression
  @CHECKOUT_DELTA_035
  Scenario: Regression_DELTA_CHECKOUT_035_Contact_Info_Form_Validations_First_Name
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

    And enter the following in the first name field form box should be highlighted in red
      |t           |
      |234234234   |
      |test.       |
      |test!       |
      |te$t	       |
      |Test (test1)|


    And enter the following in the first name field form box should NOT be highlighted in red
      |test             |
      |automation-tester|
      |test one   	    |

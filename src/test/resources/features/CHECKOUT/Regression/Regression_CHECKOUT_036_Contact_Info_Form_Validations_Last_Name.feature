Feature: Regression_CHECKOUT_036_Contact_Info_Form_Validations_Last_Name
  Background: open page


  @CHECKOUT
  @Regression
  @CHECKOUT_036
  Scenario: Regression_CHECKOUT_036_Contact_Info_Form_Validations_Last_Name
    Given we are on "dsg" page
    When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
    Given we are on "dsg" page
    And we wait for 10 seconds
	And we add a product "nike headband" to cart
	And we select CHECKOUT
    And we wait for 3 seconds
	
	And we add first name "automation" 
	And enter the following in the last name field form box should be highlighted in red
      |t           |
      |234234234   |
      |test.       |
      |test!       |
      |te$t	       |
      |Test (test1)|


	And enter the following in the last name field form box should NOT be highlighted in red
      |test             |
      |automation-tester|
      |test one   	    |

  @CHECKOUT_DELTA
  @Regression
  @CHECKOUT_DELTA_036
  Scenario: Regression_DELTA_CHECKOUT_036_Contact_Info_Form_Validations_Last_Name
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
    And enter the following in the last name field form box should be highlighted in red
      |t           |
      |234234234   |
      |test.       |
      |test!       |
      |te$t	       |
      |Test (test1)|


    And enter the following in the last name field form box should NOT be highlighted in red
      |test             |
      |automation-tester|
      |test one   	    |

	
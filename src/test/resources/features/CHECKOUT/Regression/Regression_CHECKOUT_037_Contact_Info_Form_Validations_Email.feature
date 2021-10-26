Feature: Regression_CHECKOUT_037_Contact_Info_Form_Validations_Email
  Background: open page


  @CHECKOUT
  @Regression
  @CHECKOUT_037
  Scenario: Regression_CHECKOUT_037_Contact_Info_Form_Validations_Email
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
	And enter the following in the email field form box should be highlighted in red
      |automation.teste   |
      |automation-tester  |
      |automation@	      |
      |automation@dcsg    |


	And enter the following in the email field form box should NOT be highlighted in red
      |automation@dcsg.com        |
      |automation-tester@gmail.com|
      |test.test.test@hotmail.com |
	  |test@psu.edu               |


  @CHECKOUT_DELTA
  @Regression
  @CHECKOUT_DELTA_037
  Scenario: Regression_DELTA_CHECKOUT_037_Contact_Info_Form_Validations_Email
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
    And enter the following in the email field form box should be highlighted in red
      |automation.teste   |
      |automation-tester  |
      |automation@	      |
      |automation@dcsg    |


    And enter the following in the email field form box should NOT be highlighted in red
      |automation@dcsg.com        |
      |automation-tester@gmail.com|
      |test.test.test@hotmail.com |
      |test@psu.edu               |

	
Feature: Regression_CHECKOUT_039_Contact_Info_Form_Validations_Scorecard
  Background: open page


  @CHECKOUT
  @Regression
  @CHECKOUT_039
  Scenario: Regression_CHECKOUT_039_Contact_Info_Form_Validations_Scorecard
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
	And we add phone number "7242733400"
	And enter the following in the scorecard field form box should be highlighted in red
      |3232   |
      |L0192  |
      |test!  |

	And enter the following in the scorecard field form box should NOT be highlighted in red
      |L01TB23KM72W  |
      |L011B2536J9D  |


  @CHECKOUT_DELTA
  @Regression
  @CHECKOUT_DELTA_039
  Scenario: Regression_DELTA_CHECKOUT_039_Contact_Info_Form_Validations_Scorecard
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
    And we add phone number "7242733400"
    And enter the following in the scorecard field form box should be highlighted in red
      |3232   |
      |L0192  |
      |test!  |

    And enter the following in the scorecard field form box should NOT be highlighted in red
      |L01TB23KM72W  |
      |L011B2536J9D  |
	
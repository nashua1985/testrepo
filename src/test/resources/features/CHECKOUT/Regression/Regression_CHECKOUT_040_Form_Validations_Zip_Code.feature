Feature: Regression_CHECKOUT_040_Form_Validations_Zip_Code
  Background: open page


  @CHECKOUT
  @Regression
  @CHECKOUT_040
  Scenario: Regression_CHECKOUT_040_Form_Validations_Zip_Code
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
	And we add street address "345 Court St" 
	And we add zip code "90005" as billing zip code
	
	And enter the following in the zipcode field form box should be highlighted in red
      |3232   |
      |15108-33  |
      |test!  |

    And enter the following in the zipcode field form box should NOT be highlighted in red
      |90005  |
      |15108  |


  @CHECKOUT_DELTA
  @Regression
  @CHECKOUT_DELTA_040
  Scenario: Regression_DELTA_CHECKOUT_040_Form_Validations_Zip_Code
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
    And we add street address "345 Court St"
    And we add zip code "90005" as billing zip code

    And enter the following in the zipcode field form box should be highlighted in red
      |3232   |
      |15108-33  |
      |test!  |

    And enter the following in the zipcode field form box should NOT be highlighted in red
      |90005  |
      |15108  |

	
Feature: Regression_CHECKOUT_009_LTL_Change_Delivery_Options
  Background: open page


  @CHECKOUT
  @Regression
  @CHECKOUT_009
  Scenario: Regression_CHECKOUT_009_LTL_Change_Delivery_Options
    Given we are on "dsg" page
    When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
    Given we are on "dsg" page
    And we wait for 10 seconds
	And we add a product "kayak" to cart
	And we select CHECKOUT
    And we wait for 3 seconds
    
	And we change to Expedited Shipping
	And we validate EDD change
	#EDD should be sooner than standard parcel
	And we validate that shipping is not null
	
	And we change to Express Shipping
	#And we validate EDD change
	#EDD should be sooner than expedited
	#And we validate that shipping is "$24.99"

  @CHECKOUT_DELTA
  @Regression
  @CHECKOUT_DELTA_009
  Scenario: Regression_CHECKOUT_009_LTL_Change_Delivery_Options
    Given we are on "dsgdelta" page
    When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
    When we add cookies to access delta:
      |delta|True|
      |cart |True|
    Given we are on "dsgdelta" page
    And we wait for 10 seconds
    And we select the TEST1 button
    And we add a product "kayak" to cart
    And we select CHECKOUT
    And we wait for 3 seconds

    And we change to Expedited Shipping
    And we validate EDD change
	#EDD should be sooner than standard parcel
    And we validate that shipping is not null

    And we change to Express Shipping
	#And we validate EDD change
	#EDD should be sooner than expedited
	#And we validate that shipping is "$24.99"
	
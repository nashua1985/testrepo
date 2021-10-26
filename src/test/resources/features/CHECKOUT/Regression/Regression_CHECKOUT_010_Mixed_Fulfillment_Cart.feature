Feature: Regression_CHECKOUT_010_Mixed_Fulfillment_Cart
  Background: open page


  @CHECKOUT
  @Regression
  @CHECKOUT_010
  Scenario: Regression_CHECKOUT_010_Mixed_Fulfillment_Cart
	  Given we are on "dsg" page
	  When we add cookies to block medalia popup:
		  |BlockedTags|Medallia|
	  Given we are on "dsg" page
	  And we wait for 10 seconds
	And we add a product "nike headband" to cart
	And we add a product "kayak" to cart
	And we add a BOPIS product "yeti" to the cart
	And we select CHECKOUT
    And we wait for 3 seconds
    
	And we validate product Info for the parcel item
	And we validate EDD for the parcel item
	And we validate product info for the oversized item
	And we validate EDD for the oversized item
	And we validate the product info for the BOPIS item
	And we validate the store infor for the BOPIS item
	And we validate the BOPIS product has no EDD

	@CHECKOUT_DELTA
	@Regression
	@CHECKOUT_DELTA_010
	Scenario: Regression_DELTA_CHECKOUT_010_Mixed_Fulfillment_Cart
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
		And we add a product "kayak" to cart
		And we add a BOPIS product "yeti" to the cart
		And we select CHECKOUT
		And we wait for 3 seconds

		And we validate product Info for the parcel item
		And we validate EDD for the parcel item
		And we validate product info for the oversized item
		And we validate EDD for the oversized item
		And we validate the product info for the BOPIS item
		And we validate the store infor for the BOPIS item
		And we validate the BOPIS product has no EDD
	
	
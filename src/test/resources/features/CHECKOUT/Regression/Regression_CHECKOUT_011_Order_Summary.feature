Feature: Regression_CHECKOUT_011_Order_Summary
  Background: open page


  @CHECKOUT
  @Regression
  @CHECKOUT_011
  Scenario: Regression_CHECKOUT_011_Order_Summary
	  Given we are on "dsg" page
	  When we add cookies to block medalia popup:
		  |BlockedTags|Medallia|
	  Given we are on "dsg" page
	  And we wait for 10 seconds
	#And we add a parcel product to cart
	#And we add an oversized product to the cart
	#And we add a BOPIS product to the cart
  	And we add a product "nike headband" to cart
  	And we add a product "kayak" to cart
  	And we add a BOPIS product "yeti" to the cart
	And we change the quantity of items in cart to "2"
	And we select CHECKOUT
    And we wait for 3 seconds
    
	And we validate subtotal 
	#equals total the current price of all products in cart multiplied by "2"
	And we validate Estimated Order total
	#all order summary lines should add up to the order total
	And we validate store pickup is FREE


	@CHECKOUT_DELTA
	@Regression
	@CHECKOUT_DELTA_011
	Scenario: Regression_DELTA_CHECKOUT_011_Order_Summary
		Given we are on "dsgdelta" page
		When we add cookies to block medalia popup:
			|BlockedTags|Medallia|
		When we add cookies to access delta:
			|delta|True|
			|cart |True|
		Given we are on "dsgdelta" page
		And we wait for 10 seconds
		And we select the TEST1 button
	#And we add a parcel product to cart
	#And we add an oversized product to the cart
	#And we add a BOPIS product to the cart
		And we add a product "nike headband" to cart
		And we add a product "kayak" to cart
		And we add a BOPIS product "yeti" to the cart
		And we change the quantity of items in cart to "2"
		And we select CHECKOUT
		And we wait for 3 seconds

		And we validate subtotal
	#equals total the current price of all products in cart multiplied by "2"
		And we validate Estimated Order total
	#all order summary lines should add up to the order total
		And we validate store pickup is FREE
	
	
Feature: Regression_CART_011_Store_Layer
  Background: open page
    Given we are on "yetiBrand" page

  @CART
  @Smoke
  @Regression
  @CART_011
  @CART_mobile
  Scenario: Regression_CART_011_Store_Layer
	  When we add cookies to block medalia popup:
		  |BlockedTags|Medallia|
	  Given we are on "yetiBrand" page
	  And we wait for 10 seconds
  	And we click on In store
    And we click on the first product in search grid
	And we select the color Black
	And we check BOPIS availability
    And we click on Add to Cart button
    And we click GO TO CART
	And the BOPIS radio button is selected for our product
	
   
	And we click the Change Store link in cart
	And we verify that the Show Stores with Availability checkbox is checked
	And we uncheck the availability checkbox
	And we enter "90005" into the zip code search field
	Then we should see a list of stores
	And we click store details
  	Then store address is visible
	Then we should see "Store Hours"
  	Then we should see "Curbside Hours"
	And we enter "30005" into the zip code search field
	And we select the first available store
	Then we should see a list of stores
 Feature: Regression_DSG_PDP_024_BOPIS_ATC
  Background: open page
    Given we are on "bikes" page

  @PDP
  @Regression
  @PDP_Smoke
  @PDP_024
  @Batch1
  Scenario: Regression_DSG_PDP_024_BOPIS_ATC
    When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
    Given we are on "bikes" page
    And we wait for 10 seconds
    And we click on In store
    And we click on the first product in search grid
    Then we should see "Select Product Options for Availability"
	And we click the Change Store link
	And we verify that the Show Stores with Availability checkbox is checked
	And we enter "15108" into the zip code search field
	And we select the first available store 
	# select store and click set store
	And we select the color Matte Black
    And we select the bike frame size as "15"
    And we wait for 3 seconds
	And we check BOPIS availability
	#here we want to check to make sure that there is availability at our set store or nearby stores. If there are none avail in 100 miles we need to go back and change the attribute selection)
	And we click on Add to Cart button
    And we click GO TO CART in safari
    And we should see "1 item"
	Then the BOPIS radio button is selected for our product

  @PDP_mobile
  @PDP_mobile_ios
  @Smoke
  @Regression
  @PDP_024_mobile
  Scenario: Regression_PDP_024_BOPIS_ATC
    When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
    Given we are on "bikes" page
    And we wait for 10 seconds
    And we click on In store
    And we click on the first product in search grid in mobile
    Then we should see "Select Product Options for Availability" for mobile
    And we click the Change Store link
    And we verify that the Show Stores with Availability checkbox is checked
    And we enter "15108" into the zip code search field
    And we select the first available store
	# select store and click set store
    And we select the color Matte Black
    And we select the bike frame size as "15"
    And we wait for 3 seconds
    And we check BOPIS availability
	#here we want to check to make sure that there is availability at our set store or nearby stores. If there are none avail in 100 miles we need to go back and change the attribute selection)
    And we click on Add to Cart button
    And we click GO TO CART
    And we should see "1 item"
    Then the BOPIS radio button is selected for our product

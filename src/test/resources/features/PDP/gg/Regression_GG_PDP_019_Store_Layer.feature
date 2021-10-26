Feature: Regression_GG_PDP_019_Store_Layer
  Background: open page
    Given we are on "gripGG" page

  @PDP_GG
  @Regression
  @PDP_019
  @Batch1
  Scenario: Regression_GG_PDP_019_Store_Layer
    And we click on In store
    And we click on the first product in search grid
    Then we should see "Select Product Options for Availability"
	And we click the Change Store link
	And we verify that the Show Stores with Availability checkbox is checked
	And we uncheck the availability checkbox
	And we enter "90005" into the zip code search field
	Then we should see "Glendale"
	And we click store details
	Then we should see "200 West Broadway"
	And we enter "30005" into the zip code search field
	And we select the first available store
	Then we should see "ALPHARETTA"

  @Smoke
  @Regression
  @PDP_025_mobile
  @PDP_mobile
  @PDP_mobile_ios
  Scenario: Regression_PDP_025_Store_Layer
    And we click on the first product in search grid
    Then we should see "Select Product Options for Availability" for mobile
    And we click the Change Store link
    And we verify that the Show Stores with Availability checkbox is checked
    And we uncheck the availability checkbox
    And we enter "90005" into the zip code search field
    Then we should see "Glendale"
    And we click store details
    Then we should see "200 West Broadway"
    And we enter "30005" into the zip code search field
    And we select the first available store
    Then we should see "ALPHARETTA"
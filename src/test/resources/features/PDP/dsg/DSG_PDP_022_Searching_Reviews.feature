Feature: Regression_DSG_PDP_022_Searching_Reviews
  Background: open page
    Given we are on "bikes" page

  @PDP
  @Regression
  @PDP_022
  @Batch1
  @PDP_mobile
  @PDP_mobile_ios
  Scenario: Regression_DSG_PDP_022_Searching_Reviews
    When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
    Given we are on "bikes" page
    And we wait for 10 seconds
    And we click on the first product in search grid
    And we click on the average rating link
	And we search reviews for "Pedal"
    And we should see "Search Results"
    And we should see "Pedal"
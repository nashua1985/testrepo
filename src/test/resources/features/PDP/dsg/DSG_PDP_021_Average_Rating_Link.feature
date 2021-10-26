Feature: Regression_DSG_PDP_021_Average_Rating_Link
  Background: open page
    Given we are on "bikes" page

  @PDP
  @Regression
  @PDP_021
  @Batch1
  Scenario: Regression_DSG_PDP_021_Average_Rating_Link
    When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
    Given we are on "bikes" page
    And we wait for 10 seconds
    And we click on the first product in search grid
    And we click on the average rating link
	And we should see "Customer Reviews"
	And we should see "Rating Snapshot"
	#this verifies we are brought to the ratings section of the page and that the ratings are loading
    And we search reviews for "Pedal"
    And we should see "Search Results"
    And we should see "Showing 1"
    And we should see "Pedal"
    And we search reviews again for "Pedaling"

  @PDP_mobile
  @PDP_mobile_ios
  @Smoke
  @Regression
  @PDP_021_mobile
  Scenario: Regression_PDP_021_Average_Rating_Link
    When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
    Given we are on "bikes" page
    And we wait for 10 seconds
    And we click on the first product in search grid
    And we click on the average rating link
    And we should see "Customer Reviews"
    And we should see "Rating Snapshot"
	#this verifies we are brought to the ratings section of the page and that the ratings are loading
    And we search reviews for "Pedal"
    And we should see "Search Results"
    And we should see "Showing 1"
    And we should see "Pedal"
    And we search reviews again for "Pedaling" for mobile
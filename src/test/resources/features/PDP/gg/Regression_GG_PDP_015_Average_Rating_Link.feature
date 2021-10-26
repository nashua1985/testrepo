Feature: Regression_GG_PDP_015_Average_Rating_Link
  Background: open page
    Given we are on "rangefinderGG" page

  @PDP_GG
  @Regression
  @PDP_015
  @Batch1
  Scenario: Regression_GG_PDP_015_Average_Rating_Link
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
Feature: Regression_GG_PDP_016_Searching_Reviews
  Background: open page
    Given we are on "rangefinderGG" page

  @PDP_GG
  @Regression
  @PDP_016
  @Batch1
  @PDP_mobile
  @PDP_mobile_ios
  Scenario: Regression_GG_PDP_016_Searching_Reviews
    And we click on the first product in search grid
    And we click on the average rating link
	And we search reviews for "Pedal"
    And we should see "Search Results"
    And we should see "Pedal"
Feature: Regression_GG_PDP_013_Size_Chart
  Background: open page
    Given we are on "golfPantsGG" page

  @PDP_GG
  @Regression
  @PDP_013
  @Batch1
  @PDP_mobile
  @PDP_mobile_ios
  Scenario: Regression_GG_PDP_013_Size_Chart
    And we click on the first product in search grid
    And we click on the size chart
    Then size chart is visible
	Then we click close
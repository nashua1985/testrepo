Feature: Regression_DSG_PDP_018_Size_Chart
  Background: open page
    Given we are on "womensHoodies" page

  @PDP
  @Regression
  @PDP_018
  @Batch1
  @PDP_mobile
  @PDP_mobile_ios
  Scenario: Regression_DSG_PDP_018_Size_Chart
    When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
    Given we are on "womensHoodies" page
    And we wait for 10 seconds
    And we click on the first product in search grid
    And we click on the size chart
    Then size chart is visible
	Then we click close
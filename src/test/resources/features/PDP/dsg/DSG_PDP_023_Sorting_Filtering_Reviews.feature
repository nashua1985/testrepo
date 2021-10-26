Feature: Regression_DSG_PDP_023_Sorting_Filtering_Reviews
  Background: open page
    Given we are on "bikes" page

  @PDP
  @Regression
  @PDP_023
  Scenario: Regression_DSG_023_Sorting_Filtering_Reviews
    When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
    Given we are on "bikes" page
    And we wait for 10 seconds
    And we click on the first product in search grid
    And we click on the average rating link
	And we click to view 5 star reviews
	Then we should see "5 stars"
	And we select "Most Recent" on review dropdown
	Then we should see "Most Recent"
	And we click the filter button
	And we click the filter "Owned for" and select "1 month or less"
	Then we should see " 1 month or less " button

  @PDP_mobile
  @PDP_mobile_ios
  @Smoke
  @Regression
  @PDP_023_mobile
  Scenario: Regression_PDP_023_Sorting_Filtering_Reviews
    When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
    Given we are on "bikes" page
    And we wait for 10 seconds
    And we click on the first product in search grid
    And we click on the average rating link
    And we click to view 5 star reviews
    Then we should see "5 stars"
    And we select "Most Recent" on review dropdown
    Then we should see "Most Recent"
    And we click the filter button
    And we click the filter "Owned for" and select "1 month or less" for mobile
    Then we should see " 1 month or less " button
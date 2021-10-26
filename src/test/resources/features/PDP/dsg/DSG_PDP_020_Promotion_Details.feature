Feature: Regression_DSG_PDP_020_Promotion_Details
  Background: open page
    Given we are on "caliaBrand" page
  @PDP
  @PDP_mobile
  @PDP_mobile_ios
  @Regression
  @PDP_020
  @Batch1
  Scenario: Regression_DSG_PDP_020_Promotion_Details
    When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
    Given we are on "caliaBrand" page
    And we wait for 10 seconds
	And we click on the first product in search grid
    And we click promotion description text
    Then promotion description is visible
    Then we click close
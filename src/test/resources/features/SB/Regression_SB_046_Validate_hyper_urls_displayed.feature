Feature: Regression_SB_046_Validate_hyper_urls_displayed.

  @SB_Regression
  @SB_046
Scenario: Regression_SB_046_Validate_hyper_urls_displayed.
    Given we are on "dsgHatsFamily" page
    And we wait for 10 seconds
    When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
    Given we are on "dsgHatsFamily" page
    And we wait for 10 seconds
    And we validate if hyper cat is live

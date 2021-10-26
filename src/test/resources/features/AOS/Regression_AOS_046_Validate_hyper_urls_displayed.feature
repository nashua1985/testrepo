Feature: Regression_AOS_046_Validate_hyper_urls_displayed.

  @AOS_Regression
  @AOS_046
Scenario: Regression_AOS_046_Validate_hyper_urls_displayed.
    Given we are on "aos_dsgHatsFamily" page
  When we enter "42" and click submit
    And we validate if hyper cat is live

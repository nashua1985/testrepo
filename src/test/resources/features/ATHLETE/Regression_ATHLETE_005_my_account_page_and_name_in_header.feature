Feature: Regression_ATHLETE_005_my_account_page_and_name_in_header

  @ATHLETE_005
  @ATHLETE_Regression
  @ATHLETE_Smoke_ui_internal
  @ATHLETE_Smoke_run2

  Scenario: Regression_ATHLETE_005_my_account_page_and_name_in_header
  Given we are on "dsg" page
  And we wait for 10 seconds
  When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
  Given we are on "dsg" page
  And we wait for 10 seconds
  And we login to test account
    |automation@dcsg.com|Test1234!|
  And we should land on Sign In page by validating headers
    |Account Summary     |
    |Available Rewards   |
    |Most Recent Purchase|
  And we should see containing text "Test Tester"




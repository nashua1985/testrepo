Feature: Regression_ATHLETE_003_C_SAYT_Validate_CorrectedSearch
  Background: open page

  @ATHLETE_003_C
  @ATHLETE_Regression
  @ATHLETE_Smoke_ui
@ATHLETE_Smoke_run1

  Scenario: Regression_ATHLETE_003_C_SAYT_Validate_CorrectedSearch
  Given we are on "dsg" page
  And we wait for 10 seconds
  When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
  Given we are on "dsg" page
  And we wait for 10 seconds
  And we should see the corrected search for the following:
#    |Invalid search terms|Expected to be corrected|
#    |hocked stick        |hockey stick            |
    |weihgt              |weight                  |
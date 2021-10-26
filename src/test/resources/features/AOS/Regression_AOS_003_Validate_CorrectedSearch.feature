Feature: Regression_AOS_003_Validate_CorrectedSearch
  Background: open page

@AOS_Smoke
@AOS_Regression
@AOS_003

  Scenario: Regression_AOS_003_Validate_CorrectedSearch
  Given we are on "dsg_aos" page
  When we enter "42" and click submit
  And we should see the corrected search for the following:
#    |Invalid search terms|Expected to be corrected|
#    |hocked stick        |hockey stick            |
    |weihgt              |weight                  |

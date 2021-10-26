Feature: Regression_SB_003_Validate_CorrectedSearch
  Background: open page

@SB_Smoke
@SB_Regression
@ProdSupportSmoke
@SB_003
@SB_Smoke_mobile
@SB_Regression_mobile
@SB_003_mobile

  Scenario: Regression_SB_003_Validate_CorrectedSearch
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

  @SB_Smoke_Zeta
  @SB_003_Zeta
  @SB_Regression_Zeta

  @SB_Smoke_Zeta_mobile
  @SB_003_Zeta_mobile
  @SB_Regression_Zeta_mobile
  Scenario: Regression_SB_003_Validate_CorrectedSearch
    Given we are on "dsg_zeta" page
    When we add cookies to access zeta:
      |zeta|true|
    Given we are on "dsg_zeta" page
    And we should see the corrected search for the following:
#    |Invalid search terms|Expected to be corrected|
#      |hocked stick        |hockey stick            |
      |weihgt              |weight                  |
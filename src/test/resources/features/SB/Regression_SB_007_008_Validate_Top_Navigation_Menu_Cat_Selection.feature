Feature: Regression_SB_007_008_Validate_Top_Navigation_Menu_Cat_Selection

@SB_Smoke
@SB_Regression
#@ProdSupportSmoke
@SB_007_008
Scenario: Regression_SB_007_008_Validate_Top_Navigation_Menu_Cat_Selection
  Given we are on "dsg" page
  And we wait for 10 seconds
  When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
  Given we are on "dsg" page
  And we wait for 10 seconds
  And we should see Top Navigation Menu and child submenu

#  @SB_Smoke_Zeta
#  @SB_Regression_Zeta
#  @SB_007_008_Zeta
  Scenario: Regression_SB_007_008_Validate_Top_Navigation_Menu_Cat_Selection
    Given we are on "dsg_zeta" page
    When we add cookies to access zeta:
      |zeta|true|
    Given we are on "dsg_zeta" page
    And we should see Top Navigation Menu and child submenu

#  @SB_Smoke_mobile
#  @SB_Regression_mobile
#  @SB_007_008_mobile
  Scenario: Regression_SB_007_008_Validate_Top_Navigation_Menu_Cat_Selection
  Given we are on "dsg" page
  When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
  Given we are on "dsg" page
    And we should see Top Navigation Menu and child submenu on mobile

        ####_Golf_Galaxy_#####

  @SB_GG_Smoke
  @SB_GG_Regression
  @SB_GG_007_008
  Scenario: Regression_SB_007_008_Validate_Top_Navigation_Menu_Cat_Fam_Selection_GG
    Given we are on "gg" page
    And we wait for 10 seconds
    When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
    Given we are on "gg" page
    And we wait for 10 seconds
    And we should see Top Navigation Menu and child submenu in gg
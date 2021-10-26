Feature: Regression_SB_009_010_Validate_Family_Selection_From_Category_Pages

  #commenting untill a new header
@SB_Smoke
@SB_Regression
@SB_009_010
@SB_009_010_sport
@ProdSupportSmoke

Scenario: Regression_SB_009_010_Validate_Family_Selection_From_Category_Pages - Sport Cat
  Given we are on "dsg" page
  And we wait for 10 seconds
  When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
  Given we are on "dsg" page
  And we wait for 10 seconds
  And we should see some family pages of sport category

@SB_Smoke
@SB_Regression
@SB_009_010
@SB_009_010_women
Scenario: Regression_SB_009_010_Validate_Family_Selection_From_Category_Pages - Women Cat
  Given we are on "dsg" page
  And we wait for 10 seconds
  When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
  Given we are on "dsg" page
  And we wait for 10 seconds
  And we should see some family pages of women category

#  @SB_Smoke_mobile
#  @SB_Regression_mobile
#  @SB_009_010_mobile
#  @SB_009_010_mobile_sport

  Scenario: Regression_SB_009_010_Validate_Family_Selection_From_Category_Pages - Sport Cat
  Given we are on "dsg" page
  And we wait for 10 seconds
  When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
  Given we are on "dsg" page
  And we wait for 15 seconds
    And we should see some family pages of sport category on mobile

#  @SB_Smoke_mobile
#  @SB_Regression_mobile
#  @SB_009_010_mobile
#  @SB_009_010_mobile_w

  Scenario: Regression_SB_009_010_Validate_Family_Selection_From_Category_Pages - Women Cat
  Given we are on "dsg" page
  And we wait for 10 seconds
  When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
  Given we are on "dsg" page
  And we wait for 15 seconds
    And we should see some family pages of women category on mobile

#  @SB_Smoke_Zeta
#  @SB_Regression_Zeta

#  @SB_009_010_Zeta

  Scenario: Regression_SB_009_010_Validate_Family_Selection_From_Category_Pages - Sport Cat
    Given we are on "dsg_zeta" page
    When we add cookies to access zeta:
      |zeta|true|
    Given we are on "dsg_zeta" page
    And we should see some family pages of sport category

#  @SB_Smoke_Zeta
#  @SB_Regression_Zeta

#  @SB_009_010_Zeta
  Scenario: Regression_SB_009_010_Validate_Family_Selection_From_Category_Pages - Women Cat
    Given we are on "dsg_zeta" page
    When we add cookies to access zeta:
      |zeta|true|
    And we should see some family pages of women category


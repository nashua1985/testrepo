Feature: Regression_SB_031_Validate_Quickview_not_Available_For_Customized_Items


  @SB_Smoke
  @SB_Regression
  @SB_031
  @SB_Smoke_mobile
  @SB_Regression_mobile
  @SB_031_mobile

Scenario Outline: Regression_SB_031_Validate_Quickview_not_Available_For_Customized_Items
  Given we are on "dsg" page
  And we wait for 10 seconds
  When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
  Given we are on "dsg" page
  And we wait for 10 seconds
  And we search for "<keyWord>" keyword in the search box
  And we should not see quickView addToCard button

Examples:
  |keyWord|
#  |personalized|
  |personalized golf balls  |



  @SB_Smoke_Zeta
  @SB_031_Zeta
  @SB_Regression_Zeta
  @SB_Smoke_Zeta_mobile
  @SB_031_Zeta_mobile
  @SB_Regression_Zeta_mobile

  Scenario Outline: Regression_SB_031_Validate_Quickview_not_Available_For_Customized_Items
    Given we are on "dsg_zeta" page
    When we add cookies to access zeta:
      |zeta|true|
    Given we are on "dsg_zeta" page
    And we search for "<keyWord>" keyword in the search box
    And we wait for 5 seconds
    And we should not see quickView addToCard button

    Examples:
      |keyWord|
#  |personalized|
      |personalized golf balls  |
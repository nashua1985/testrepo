Feature: Regression_SB_026_Validate_Pagination_in_PLP

  @SB_Regression
  @SB_026
  @SB_Regression_mobile
  @SB_026_mobile
  Scenario: Regression_SB_026_Validate_Pagination_in_PLP-Page_clicking
    Given we are on "baseballCleatsFamily" page
    When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
    Given we are on "baseballCleatsFamily" page
    And we validate pagination on SRLP-PLP by clicking page numbers

  @SB_Regression
  @SB_026
  @SB_Regression_mobile
  @SB_026_mobile
  Scenario: Regression_SB_026_Validate_Pagination_in_PLP-Arrow_clicking
    Given we are on "baseballCleatsFamily" page
    When we add cookies to block medalia popup:
        |BlockedTags|Medallia|
    Given we are on "baseballCleatsFamily" page
    And we validate pagination on SRLP-PLP by clicking arrows

  @SB_026_Zeta
  @SB_Regression_Zeta
  @SB_026_Zeta_mobile
  @SB_Regression_Zeta_mobile
  Scenario: Regression_SB_026_Validate_Pagination_in_PLP-Page_clicking
    Given we are on "baseballCleatsFamily_zeta" page
    When we add cookies to access zeta:
      |zeta|true|
    Given we are on "baseballCleatsFamily_zeta" page
    And we validate pagination on SRLP-PLP by clicking page numbers

  @SB_026_Zeta
  @SB_Regression_Zeta
  @SB_026_Zeta_mobile
  @SB_Regression_Zeta_mobile
  Scenario: Regression_SB_026_Validate_Pagination_in_PLP-Arrow_clicking
    Given we are on "baseballCleatsFamily_zeta" page
    When we add cookies to access zeta:
      |zeta|true|
    Given we are on "baseballCleatsFamily_zeta" page
    And we validate pagination on SRLP-PLP by clicking arrows

                                ####_Golf_Galaxy_#####

  @SB_Regression
  @SB_GG_026
  @SB_GG_Regression_mobile
  @SB_GG_026_mobile
  Scenario: Regression_SB_026_Validate_Pagination_in_PLP-Page_clicking_GG
    Given we are on "gg_drivers" page
    When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
    Given we are on "gg_drivers" page
    And we validate pagination on SRLP-PLP by clicking page numbers

  @SB_GG_Regression
  @SB_GG_026
  @SB_GG_Regression_mobile
  @SB_GG_026_mobile
  Scenario: Regression_SB_026_Validate_Pagination_in_PLP-Arrow_clicking_GG
    Given we are on "gg_drivers" page
    When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
    Given we are on "gg_drivers" page
    And we validate pagination on SRLP-PLP by clicking arrows

  @SB_GG_026_Zeta
  @SB_GG_Regression_Zeta
  @SB_GG_026_Zeta_mobile
  @SB_GG_Regression_Zeta_mobile
  Scenario: Regression_SB_026_Validate_Pagination_in_PLP-Page_clicking_GG
    Given we are on "gg_drivers_zeta" page
    When we add cookies to access zeta:
      |zeta|true|
    When we add cookies to access zeta:
      |tiger|woods|
    Given we are on "gg_drivers_zeta" page
    And we validate pagination on SRLP-PLP by clicking page numbers

  @SB_GG_026_Zeta
  @SB_GG_Regression_Zeta
  @SB_GG_026_Zeta_mobile
  @SB_GG_Regression_Zeta_mobile
  Scenario: Regression_SB_026_Validate_Pagination_in_PLP-Arrow_clicking_GG
    Given we are on "gg_drivers_zeta" page
    When we add cookies to access zeta:
      |zeta|true|
    When we add cookies to access zeta:
      |tiger|woods|
    Given we are on "gg_drivers_zeta" page
    And we validate pagination on SRLP-PLP by clicking arrows

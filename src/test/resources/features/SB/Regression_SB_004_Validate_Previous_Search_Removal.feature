Feature: Regression_SB_004_Validate_Previous_Search_Removal

@SB_Regression
@SB_004
@SB_Regression_mobile
@SB_004_mobile
Scenario Outline: Regression_SB_004_Validate_Previous_Search_Removal
  Given we are on "dsg" page
  And we wait for 10 seconds
  When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
  Given we are on "dsg" page
  And we wait for 10 seconds
  When we search for "<searchTerm>" keyword in the search box
  And we wait for 10 seconds
  Then we clear the search box and should not see "<searchTerm>"

  Examples:
    |searchTerm |
    |xxxxxxxxx  |
#    |basketball |

  @SB_004_Zeta
  @SB_Regression_Zeta
  @SB_004_Zeta_mobile
  @SB_Regression_Zeta_mobile
  Scenario Outline: Regression_SB_004_Validate_Previous_Search_Removal
    Given we are on "dsg_zeta" page
    When we add cookies to access zeta:
      |zeta|true|
    Given we are on "dsg_zeta" page
    When we search for "<searchTerm>" keyword in the search box
    And we wait for 10 seconds
    Then we clear the search box and should not see "<searchTerm>"

    Examples:
      |searchTerm |
      |xxxxxxxxx  |
#    |basketball |

      ####_Golf_Galaxy_#####

    @SB_GG_Regression
    @SB_GG_004
    @SB_GG_Regression_mobile
    @SB_GG_004_mobile
  Scenario Outline: Regression_SB_004_Validate_Previous_Search_Removal_GG
    Given we are on "gg" page
    And we wait for 10 seconds
    When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
    Given we are on "gg" page
    And we wait for 10 seconds
    When we search for "<searchTerm>" keyword in the search box
    And we wait for 10 seconds
    Then we clear the search box and should not see "<searchTerm>"

    Examples:
      |searchTerm |
      |xxxxxxxxx  |
#    |basketball |

        ####_Public_Lands_#####

    @SB_PL_Regression
    @SB_PL_004
    @SB_PL_Regression_mobile
    @SB_PL_004_mobile
  Scenario Outline: Regression_SB_004_Validate_Previous_Search_Removal_PL
    Given we are on "pl" page
    And we wait for 10 seconds
    When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
      |beta       |true    |
    Given we are on "pl" page
    And we wait for 10 seconds
    When we search for "<searchTerm>" keyword in the search box
    And we wait for 10 seconds
    Then we clear the search box and should not see "<searchTerm>"

    Examples:
      |searchTerm |
      |xxxxxxxxx  |

    @SB_PL_004_Zeta
    @SB_PL_Regression_Zeta
    @SB_PL_004_Zeta_mobile
    @SB_PL_Regression_Zeta_mobile
  Scenario Outline: Regression_SB_004_Validate_Previous_Search_Removal_PL_Zeta
    Given we are on "pl_zeta" page
    When we add cookies to access zeta:
      |zeta|true|
      |public|lands|
    Given we are on "pl_zeta" page
    When we search for "<searchTerm>" keyword in the search box
    And we wait for 10 seconds
    Then we clear the search box and should not see "<searchTerm>"

    Examples:
      |searchTerm |
      |xxxxxxxxx  |
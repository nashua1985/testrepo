Feature: Regression_SB_002_Validate_No_Result_Search

@SB_Regression
@SB_002
@SB_Regression_mobile
@SB_002_mobile
Scenario Outline: Regression_SB_002_Validate_No_Result_Search
  Given we are on "dsg" page
  And we wait for 10 seconds
  When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
  Given we are on "dsg" page
  And we wait for 10 seconds
  When we search for "<searchTerm>" keyword in the search box
  Then we should see 0 results for "<searchTerm>"

  Examples:
    |searchTerm |
    |xxxxxxxxx  |
#    |basketball |

@SB_Regression_Zeta
@SB_002_Zeta
@SB_Regression_Zeta_mobile
@SB_002_Zeta_mobile

  Scenario Outline: Regression_SB_002_Validate_No_Result_Search
  Given we are on "dsg_zeta" page
  When we add cookies to access zeta:
    |zeta|true|
  Given we are on "dsg_zeta" page
  When we search for "<searchTerm>" keyword in the search box
  Then we should see 0 results for "<searchTerm>"
    Examples:
      |searchTerm |
      |xxxxxxxxx  |
#    |basketball |

####_Golf_Galaxy_#####

    @SB_GG_Regression
    @SB_GG_002
    @SB_GG_Regression_mobile
    @SB_GG_002_mobile
  Scenario Outline: Regression_SB_002_Validate_No_Result_Search_GG
    Given we are on "gg" page
    And we wait for 10 seconds
    When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
    Given we are on "gg" page
    And we wait for 10 seconds
    When we search for "<searchTerm>" keyword in the search box
    Then we should see 0 results for "<searchTerm>"
    Examples:
      |searchTerm |
      |xxxxxxxxx  |
#    |basketball |

####_Public_Lands_#####

    @SB_PL_Regression
    @SB_PL_002
    @SB_PL_Regression_mobile
    @SB_PL_002_mobile
  Scenario Outline: Regression_SB_002_Validate_No_Result_Search_PL
    Given we are on "pl" page
    And we wait for 10 seconds
    When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
      |beta       |true    |
    Given we are on "pl" page
    And we wait for 10 seconds
    When we search for "<searchTerm>" keyword in the search box
    Then we should see 0 results for "<searchTerm>"
    Examples:
      |searchTerm |
      |xxxxxxxxx  |
#    |basketball |

    @SB_PL_Regression_Zeta
    @SB_PL_002_Zeta
    @SB_PL_Regression_Zeta_mobile
    @SB_PL_002_Zeta_mobile

  Scenario Outline: Regression_SB_002_Validate_No_Result_Search_Zeta_PL
    Given we are on "pl_zeta" page
    When we add cookies to access zeta:
      |zeta  |true |
      |public|lands|
    Given we are on "pl_zeta" page
    When we search for "<searchTerm>" keyword in the search box
    Then we should see 0 results for "<searchTerm>"
    Examples:
      |searchTerm |
      |xxxxxxxxx  |
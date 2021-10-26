Feature: Regression_SB_42_Validate_Please_Select_A_Store_with_No_Store_Set

  @SB_Regression
  @SB_042
  @SB_Regression_mobile
  @SB_042_mobile
Scenario Outline: Regression_SB_42_Validate_Please_Select_A_Store_with_No_Store_Set
  Given we are on "dsg" page
  And we wait for 10 seconds
  When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
  Given we are on "dsg" page
  And we wait for 10 seconds
  And we search for "<keyWord>" keyword in the search box
  And we clear all filter and validate shipToMe and BOPIS not available
  And we click on first addToCart in search grid
  And we should see storePickup not available
  Examples:
  |keyWord   |
  |yeti      |

    @SB_042_Zeta
    @SB_Regression_Zeta
    @SB_042_Zeta_mobile
      #fails in zeta, need to work on it
    @SB_Regression_Zeta_mobile
  Scenario Outline: Regression_SB_42_Validate_Please_Select_A_Store_with_No_Store_Set
    Given we are on "dsg_zeta" page
    When we add cookies to access zeta:
      |zeta|true|
    Given we are on "dsg_zeta" page
    And we search for "<keyWord>" keyword in the search box
    And we clear all filter and validate shipToMe and BOPIS not available
    And we click on first addToCart in search grid
    And we should see storePickup not available
    Examples:
      |keyWord   |
      |yeti      |

                                     ####_Golf_Galaxy_#####

    @SB_GG_Regression
    @SB_GG_042
    @SB_GG_Regression_mobile
    @SB_GG_042_mobile
  Scenario Outline: Regression_SB_42_Validate_Please_Select_A_Store_with_No_Store_Set_GG
    Given we are on "gg" page
    And we wait for 10 seconds
    When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
    Given we are on "gg" page
    And we wait for 10 seconds
    And we search for "<keyWord>" keyword in the search box
    And we clear all filter and validate shipToMe and BOPIS not available
    And we click on first addToCart in search grid
    And we should see storePickup not available
    Examples:
      |keyWord   |
      |golf shoe |

    @SB_GG_042_Zeta
    @SB_GG_Regression_Zeta
    @SB_GG_042_Zeta_mobile
    @SB_GG_Regression_Zeta_mobile
  Scenario Outline: Regression_SB_42_Validate_Please_Select_A_Store_with_No_Store_Set_GG
    Given we are on "gg_zeta" page
    When we add cookies to access zeta:
      |zeta|true|
    When we add cookies to access zeta:
      |tiger|woods|
    Given we are on "gg_zeta" page
    And we search for "<keyWord>" keyword in the search box
    And we clear all filter and validate shipToMe and BOPIS not available
    And we click on first addToCart in search grid
    And we should see storePickup not available
    Examples:
      |keyWord   |
      |golf shoe |

                                           ####_Public_Lands_#####

    @SB_PL_Regression
    @SB_PL_042
    @SB_PL_Regression_mobile
    @SB_PL_042_mobile
  Scenario Outline: Regression_SB_42_Validate_Please_Select_A_Store_with_No_Store_Set_PL
    Given we are on "pl" page
    And we wait for 10 seconds
    When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
      |beta       |true    |
    Given we are on "pl" page
    And we wait for 10 seconds
    And we search for "<keyWord>" keyword in the search box
    And we clear all filter and validate shipToMe and BOPIS not available
    And we click on first addToCart in search grid
    And we should see storePickup not available
    Examples:
      |keyWord   |
      |FISHING ROD     |

    @SB_PL_042_Zeta
    @SB_PL_Regression_Zeta
    @SB_PL_042_Zeta_mobile
    @SB_PL_Regression_Zeta_mobile
  Scenario Outline: Regression_SB_42_Validate_Please_Select_A_Store_with_No_Store_Set_PL
    Given we are on "pl_zeta" page
    When we add cookies to access zeta:
      |zeta|true|
      |public|lands|
    Given we are on "pl_zeta" page
    And we search for "<keyWord>" keyword in the search box
    And we clear all filter and validate shipToMe and BOPIS not available
    And we click on first addToCart in search grid
    And we should see storePickup not available
    Examples:
      |keyWord   |
      |FISHING ROD     |

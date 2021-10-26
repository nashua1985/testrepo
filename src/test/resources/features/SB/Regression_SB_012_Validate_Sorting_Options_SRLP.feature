Feature: Regression_SB_012_Validate_Sorting_Options_SRLP

@SB_Regression
@SB_012
@SB_Regression_mobile
@SB_012_mobile

Scenario Outline: Regression_SB_012_Validate_Sorting_Options_SRLP_Low_To_High
  Given we are on "dsg" page
  And we wait for 10 seconds
  When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
  Given we are on "dsg" page
  And we wait for 10 seconds
  And we search for "<keyWord>" keyword in the search box
  And we validate price sorting from low to high
  Examples:
  |keyWord |
  |shoes   |
#  |kayak   |
#  |flyknit running shoes   |

@SB_Regression
@SB_012
@SB_Regression_mobile
@SB_012_mobile

Scenario Outline: Regression_SB_012_Validate_Sorting_Options_SRLP_High_To_Low
  Given we are on "dsg" page
  And we wait for 10 seconds
  When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
  Given we are on "dsg" page
  And we wait for 10 seconds
  And we search for "<keyWord>" keyword in the search box
 And we validate price sorting from high to low
 Examples:
  |keyWord |
  |shoes   |
#  |kayak   |
#  |flyknit running shoes   |


    @SB_012_Zeta
    @SB_Regression_Zeta
    @SB_012_Zeta_mobile
    @SB_Regression_Zeta_mobile
  Scenario Outline: Regression_SB_012_Validate_Sorting_Options_SRLP_Low_To_High
    Given we are on "dsg_zeta" page
    When we add cookies to access zeta:
      |zeta|true|
    Given we are on "dsg_zeta" page
    And we search for "<keyWord>" keyword in the search box
    And we validate price sorting from low to high
    Examples:
      |keyWord |
      |shoes   |
#  |kayak   |
#  |flyknit running shoes   |

    @SB_012_Zeta
    @SB_Regression_Zeta
    @SB_012_Zeta_mobile
    @SB_Regression_Zeta_mobile
  Scenario Outline: Regression_SB_012_Validate_Sorting_Options_SRLP_High_To_Low
    Given we are on "dsg_zeta" page
    When we add cookies to access zeta:
      |zeta|true|
    Given we are on "dsg_zeta" page
    And we search for "<keyWord>" keyword in the search box
    And we validate price sorting from high to low
    Examples:
      |keyWord |
      |shoes   |
#  |kayak   |
#  |flyknit running shoes   |

    ####_Golf_Galaxy_#####
    @SB_GG_Regression
    @SB_GG_012
    @SB_GG_Regression_mobile
    @SB_GG_012_mobile
  Scenario Outline: Regression_SB_012_Validate_Sorting_Options_SRLP_Low_To_High_GG
    Given we are on "gg" page
    And we wait for 10 seconds
    When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
    Given we are on "gg" page
    And we wait for 10 seconds
    And we search for "<keyWord>" keyword in the search box
    And we validate price sorting from low to high
    Examples:
      |keyWord  |
      |push cart|

    @SB_GG_Regression
    @SB_GG_012
    @SB_GG_Regression_mobile
    @SB_GG_012_mobile

  Scenario Outline: Regression_SB_012_Validate_Sorting_Options_SRLP_High_To_Low_GG
    Given we are on "gg" page
    And we wait for 10 seconds
    When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
    Given we are on "gg" page
    And we wait for 10 seconds
    And we search for "<keyWord>" keyword in the search box
    And we validate price sorting from high to low
    Examples:
      |keyWord  |
      |push cart|

       ####_Public_Lands_#####
    @SB_PL_Regression
    @SB_PL_012
    @SB_PL_Regression_mobile
    @SB_PL_012_mobile
  Scenario Outline: Regression_SB_012_Validate_Sorting_Options_SRLP_Low_To_High_PL
    Given we are on "pl" page
    And we wait for 10 seconds
    When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
      |beta       |true    |
    Given we are on "pl" page
    And we wait for 10 seconds
    And we search for "<keyWord>" keyword in the search box
    And we validate price sorting from low to high
    Examples:
      |keyWord  |
      |FISHING ROD |

    @SB_PL_Regression
    @SB_PL_012
    @SB_PL_Regression_mobile
    @SB_PL_012_mobile

  Scenario Outline: Regression_SB_012_Validate_Sorting_Options_SRLP_High_To_Low_PL
    Given we are on "pl" page
    And we wait for 10 seconds
    When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
      |beta       |true    |
    Given we are on "pl" page
    And we wait for 10 seconds
    And we search for "<keyWord>" keyword in the search box
    And we validate price sorting from high to low
    Examples:
      |keyWord  |
      |FISHING ROD |

    @SB_PL_012_Zeta
    @SB_PL_Regression_Zeta
    @SB_PL_012_Zeta_mobile
    @SB_PL_Regression_Zeta_mobile
  Scenario Outline: Regression_SB_012_Validate_Sorting_Options_SRLP_Low_To_High_PL_Zeta
    Given we are on "pl_zeta" page
    When we add cookies to access zeta:
      |zeta|true|
      |public|lands|
    Given we are on "pl_zeta" page
    And we search for "<keyWord>" keyword in the search box
    And we validate price sorting from low to high
    Examples:
      |keyWord |
      |FISHING ROD |
#  |kayak   |
#  |flyknit running shoes   |

    @SB_PL_012_Zeta
    @SB_PL_Regression_Zeta
    @SB_PL_012_Zeta_mobile
    @SB_PL_Regression_Zeta_mobile
  Scenario Outline: Regression_SB_012_Validate_Sorting_Options_SRLP_High_To_Low_PL_Zeta
    Given we are on "pl_zeta" page
    When we add cookies to access zeta:
      |zeta|true|
      |public|lands|
    Given we are on "pl_zeta" page
    And we search for "<keyWord>" keyword in the search box
    And we validate price sorting from high to low
    Examples:
      |keyWord |
      |FISHING ROD |

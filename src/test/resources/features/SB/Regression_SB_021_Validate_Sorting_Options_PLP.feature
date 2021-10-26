Feature: Regression_SB_021_Validate_Sorting_Options_PLP

  @SB_Regression
  @SB_021
  @SB_Regression_mobile
  @SB_021_mobile

#  using same java file SB_012 since same logic
Scenario Outline: Regression_SB_021_Validate_Sorting_Options_PLP_Low_High
  Given we are on "baseballCleatsFamily" page
  When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
 Given we are on "baseballCleatsFamily" page
#  And we search for "<keyWord>" keyword in the search box
  And we validate price sorting from low to high
  Examples:
  |keyWord |
  |shoes   |
#  |kayak   |
#  |flyknit running shoes   |

  @SB_Regression
  @SB_021
  @SB_Regression_mobile
  @SB_021_mobile
Scenario Outline: Regression_SB_021_Validate_Sorting_Options_PLP_High_Low
  Given we are on "baseballCleatsFamily" page
  When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
 Given we are on "baseballCleatsFamily" page
# And we search for "<keyWord>" keyword in the search box
 And we validate price sorting from high to low
 Examples:
  |keyWord |
#  |shoes   |
  |kayak   |
#  |flyknit running shoes   |

      @SB_Regression_Zeta
      @SB_021_Zeta
      @SB_021_Zeta_mobile
      @SB_Regression_Zeta_mobile
#  using same java file SB_012 since same logic
  Scenario: Regression_SB_021_Validate_Sorting_Options_PLP_Low_High
    Given we are on "baseballCleatsFamily_zeta" page
    When we add cookies to access zeta:
      |zeta|true|
    Given we are on "baseballCleatsFamily_zeta" page
#  And we search for "<keyWord>" keyword in the search box
    And we validate price sorting from low to high

      @SB_Regression_Zeta
      @SB_021_Zeta
      @SB_021_Zeta_mobile
      @SB_Regression_Zeta_mobile
  Scenario Outline: Regression_SB_021_Validate_Sorting_Options_PLP_High_Low
    Given we are on "baseballCleatsFamily_zeta" page
    When we add cookies to access zeta:
      |zeta|true|
    Given we are on "baseballCleatsFamily_zeta" page
# And we search for "<keyWord>" keyword in the search box
    And we validate price sorting from high to low
    Examples:
      |keyWord |
      |kayak   |

                ####_Golf_Galaxy_#####

    @SB_GG_Regression
    @SB_GG_021
    @SB_GG_Regression_mobile
    @SB_GG_021_mobile

#  using same java file SB_012 since same logic
  Scenario: Regression_SB_021_Validate_Sorting_Options_PLP_Low_High_GG
    Given we are on "gg_clubs_family" page
    When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
    Given we are on "gg_clubs_family" page
    And we validate price sorting from low to high

    @SB_GG_Regression
    @SB_GG_021
    @SB_GG_Regression_mobile
    @SB_GG_021_mobile
  Scenario: Regression_SB_021_Validate_Sorting_Options_PLP_High_Low_GG
    Given we are on "gg_clubs_family" page
    When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
    Given we are on "gg_clubs_family" page
    And we validate price sorting from high to low

Feature: Regression_SB_019_Validate_48_96_144_Products_Per_Page_SRLP

@SB_Regression
@SB_019
# Not applicable for mobile as page view 48, 96, 144 does not exist
# Search grid should have >144 items for the script to work. So, use broader keywords like 'shoes'
Scenario Outline: Regression_SB_019_Validate_48_96_144_Products_Per_Page_SRLP
  Given we are on "dsg" page
  And we wait for 10 seconds
  When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
  Given we are on "dsg" page
  And we wait for 10 seconds
  And we search for "<keyWord>" keyword in the search box
  And we validate srlp-plp page selecting different numbers
  Examples:
  |keyWord |
#  |shoes   |
#  |yeti    |
#  |treadmill    |
  |dodgers    |

    @SB_019_Zeta
    @SB_Regression_Zeta

#  Search grid should have >144 items for the script to work. So, use broader keywords like 'shoes'
  Scenario Outline: Regression_SB_019_Validate_48_96_144_Products_Per_Page_SRLP
    Given we are on "dsg_zeta" page
    When we add cookies to access zeta:
      |zeta|true|
    Given we are on "dsg_zeta" page
    And we search for "<keyWord>" keyword in the search box
    And we validate srlp-plp page selecting different numbers
    Examples:
      |keyWord |
#  |shoes   |
#  |yeti    |
#  |treadmill    |
      |dodgers    |

            ####_Golf_Galaxy_#####

    @SB_GG_Regression
    @SB_GG_019
# Not applicable for mobile as page view 48, 96, 144 does not exist
# Search grid should have >144 items for the script to work. So, use broader keywords like 'golf shoe'
  Scenario Outline: Regression_SB_019_Validate_48_96_144_Products_Per_Page_SRLP_GG
    Given we are on "gg" page
    And we wait for 10 seconds
    When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
    Given we are on "gg" page
    And we wait for 10 seconds
    And we search for "<keyWord>" keyword in the search box
    And we validate srlp-plp page selecting different numbers
    Examples:
      |keyWord  |
      |golf shoe|

      ####_Public_Lands_#####

    @SB_PL_Regression
    @SB_PL_019
# Not applicable for mobile as page view 48, 96, 144 does not exist
# Search grid should have >144 items for the script to work. So, use broader keywords like 'golf shoe'
  Scenario Outline: Regression_SB_019_Validate_48_96_144_Products_Per_Page_SRLP_PL
    Given we are on "pl" page
    And we wait for 10 seconds
    When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
      |beta       |true    |
    Given we are on "pl" page
    And we wait for 10 seconds
    And we search for "<keyWord>" keyword in the search box
    And we validate srlp-plp page selecting different numbers
    Examples:
      |keyWord  |
      |FISHING  |

    @SB_PL_019_Zeta
    @SB_PL_Regression_Zeta
#  Search grid should have >144 items for the script to work. So, use broader keywords like 'shoes'
  Scenario Outline: Regression_SB_019_Validate_48_96_144_Products_Per_Page_SRLP_PL_Zeta
    Given we are on "pl_zeta" page
    When we add cookies to access zeta:
      |zeta|true|
      |public|lands|
    Given we are on "pl_zeta" page
    And we search for "<keyWord>" keyword in the search box
    And we validate srlp-plp page selecting different numbers
    Examples:
      |keyWord |
      |FISHING |

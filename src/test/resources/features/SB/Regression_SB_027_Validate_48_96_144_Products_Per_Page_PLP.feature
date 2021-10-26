Feature: Regression_SB_027_Validate_48_96_144_Products_Per_Page_PLP


  @SB_Regression
  @SB_027
# Not applicable for mobile as page view 48, 96, 144 does not exist
#  Search grid should have >144 items for the script to work. So, use broader keywords like 'shoes'
Scenario: Regression_SB_027_Validate_48_96_144_Products_Per_Page_PLP
    Given we are on "baseballCleatsFamily" page
    When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
    Given we are on "baseballCleatsFamily" page
    And we validate srlp-plp page selecting different numbers

  @SB_027_Zeta
  @SB_Regression_Zeta

#  Search grid should have >144 items for the script to work. So, use broader keywords like 'shoes'
  Scenario: Regression_SB_027_Validate_48_96_144_Products_Per_Page_PLP
    Given we are on "dsgHatsFamily_zeta" page
    When we add cookies to access zeta:
      |zeta|true|
#    Given we are on "dsgHatsFamily" page
    When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
    Given we are on "dsgHatsFamily" page
    Given we are on "baseballCleatsFamily_zeta" page
    And we validate srlp-plp page selecting different numbers

                                ####_Golf_Galaxy_#####

  @SB_GG_Regression
  @SB_GG_027
# Not applicable for mobile as page view 48, 96, 144 does not exist
#  Search grid should have >144 items for the script to work. So, use broader keywords like 'shoes'
  Scenario: Regression_SB_027_Validate_48_96_144_Products_Per_Page_PLP_GG
    Given we are on "gg_drivers" page
    When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
    Given we are on "gg_drivers" page
    And we validate srlp-plp page selecting different numbers

  @SB_GG_027_Zeta
  @SB_GG_Regression_Zeta

#  Search grid should have >144 items for the script to work. So, use broader keywords like 'shoes'
  Scenario: Regression_SB_027_Validate_48_96_144_Products_Per_Page_PLP_GG
    Given we are on "gg_drivers_zeta" page
    When we add cookies to access zeta:
      |zeta|true|
    When we add cookies to access zeta:
      |tiger|woods|
    Given we are on "gg_drivers_zeta" page
    And we validate srlp-plp page selecting different numbers
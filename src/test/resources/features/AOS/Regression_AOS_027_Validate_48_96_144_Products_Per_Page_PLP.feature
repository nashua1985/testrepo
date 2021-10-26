Feature: Regression_AOS_027_Validate_48_96_144_Products_Per_Page_PLP


  @AOS_Regression
  @AOS_027
# Not applicable for mobile as page view 48, 96, 144 does not exist
#  Search grid should have >144 items for the script to work. So, use broader keywords like 'shoes'
Scenario: Regression_AOS_027_Validate_48_96_144_Products_Per_Page_PLP
  Given we are on "aos_baseballCleatsFamily" page
  When we enter "42" and click submit
    And we validate srlp-plp page selecting different numbers
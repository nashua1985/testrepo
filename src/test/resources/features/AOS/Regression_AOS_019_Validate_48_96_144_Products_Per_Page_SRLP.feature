Feature: Regression_AOS_019_Validate_48_96_144_Products_Per_Page_SRLP

@AOS_Regression
@AOS_019
# Not applicable for mobile as page view 48, 96, 144 does not exist
# Search grid should have >144 items for the script to work. So, use broader keywords like 'shoes'
Scenario Outline: Regression_AOS_019_Validate_48_96_144_Products_Per_Page_SRLP
  Given we are on "dsg_aos" page
  When we enter "42" and click submit
  And we search for "<keyWord>" keyword in the search box
  And we validate srlp-plp page selecting different numbers
  Examples:
  |keyWord |
#  |shoes   |
#  |yeti    |
#  |treadmill    |
  |dodgers    |

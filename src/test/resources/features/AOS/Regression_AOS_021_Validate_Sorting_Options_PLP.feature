Feature: Regression_AOS_021_Validate_Sorting_Options_PLP

  @AOS_Regression
  @AOS_021

#  using same java file AOS_012 since same logic
Scenario Outline: Regression_AOS_021_Validate_Sorting_Options_PLP_Low_High
Given we are on "aos_baseballCleatsFamily" page
  When we enter "42" and click submit
#  And we search for "<keyWord>" keyword in the search box
  And we validate price sorting from low to high
  Examples:
  |keyWord |
  |shoes   |
#  |kayak   |
#  |flyknit running shoes   |

  @AOS_Regression
  @AOS_021
Scenario Outline: Regression_AOS_021_Validate_Sorting_Options_PLP_High_Low
Given we are on "aos_baseballCleatsFamily" page
  When we enter "42" and click submit
# And we search for "<keyWord>" keyword in the search box
 And we validate price sorting from high to low
 Examples:
  |keyWord |
#  |shoes   |
  |kayak   |
#  |flyknit running shoes   |


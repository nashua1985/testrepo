Feature: Regression_AOS_012_Validate_Sorting_Options_SRLP

@AOS_Regression
@AOS_012

Scenario Outline: Regression_AOS_012_Validate_Sorting_Options_SRLP_Low_To_High
  Given we are on "dsg_aos" page
  When we enter "42" and click submit
  And we search for "<keyWord>" keyword in the search box
  And we validate price sorting from low to high
  Examples:
  |keyWord |
  |shoes   |
#  |kayak   |
#  |flyknit running shoes   |

@AOS_Regression
@AOS_012

Scenario Outline: Regression_AOS_012_Validate_Sorting_Options_SRLP_High_To_Low
  Given we are on "dsg_aos" page
  When we enter "42" and click submit
  And we search for "<keyWord>" keyword in the search box
 And we validate price sorting from high to low
 Examples:
  |keyWord |
  |shoes   |
#  |kayak   |
#  |flyknit running shoes   |

Feature: Regression_AOS_004_Validate_Previous_Search_Removal

@AOS_Regression
@AOS_004
Scenario Outline: Regression_AOS_004_Validate_Previous_Search_Removal
  Given we are on "dsg_aos" page
  When we enter "42" and click submit
  When we search for "<searchTerm>" keyword in the search box
  And we wait for 10 seconds
  Then we clear the search box and should not see "<searchTerm>"

  Examples:
    |searchTerm |
    |xxxxxxxxx  |
#    |basketball |

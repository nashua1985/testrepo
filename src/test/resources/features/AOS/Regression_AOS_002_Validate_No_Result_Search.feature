Feature: Regression_AOS_002_Validate_No_Result_Search

@AOS_Regression
@AOS_002
Scenario Outline: Regression_AOS_002_Validate_No_Result_Search
  Given we are on "dsg_aos" page
  When we enter "42" and click submit
  When we search for "<searchTerm>" keyword in the search box
  Then we should see 0 results for "<searchTerm>"

  Examples:
    |searchTerm |
    |xxxxxxxxx  |
#    |basketball |

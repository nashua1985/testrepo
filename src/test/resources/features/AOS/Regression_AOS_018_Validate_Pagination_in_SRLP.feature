Feature: Regression_AOS_018_Validate_Pagination_in_SRLP

  @AOS_Regression
  @AOS_018

Scenario Outline: Regression_AOS_018_Validate_Pagination_in_SRLP-Page_clicking
  Given we are on "dsg_aos" page
  When we enter "42" and click submit
  And we search for "<keyWord>" keyword in the search box
  And we wait for 10 seconds
  And we validate pagination on SRLP-PLP by clicking page numbers

  Examples:
  |keyWord |
  |yeti    |

  @AOS_Regression
  @AOS_018
  @AOS_018_arrow
Scenario Outline: Regression_AOS_018_Validate_Pagination_in_SRLP-Arrow_clicking
  Given we are on "dsg_aos" page
  When we enter "42" and click submit
  And we search for "<keyWord>" keyword in the search box
  And we validate pagination on SRLP-PLP by clicking arrows
 Examples:
  |keyWord |
  |yeti    |

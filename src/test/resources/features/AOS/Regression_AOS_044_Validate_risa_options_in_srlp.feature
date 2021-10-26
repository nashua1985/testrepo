Feature: Regression_AOS_044_Validate_risa_options_in_srlp

  @AOS_Regression
  @AOS_044
Scenario Outline: Regression_AOS_044_Validate_risa_options_in_srlp
  Given we are on "dsg_aos" page
  When we enter "42" and click submit
  And we search for "<keyWord>" keyword in the search box
  And we enter zip "<zipCode>" in store view
  And we select the store in store layer "<storeName>"
  And we validate if risa options are displayed correctly
  Examples:
  |keyWord  |zipCode|storeName            |
  |yeti     |19115  |DICK’S Warehouse Sale|

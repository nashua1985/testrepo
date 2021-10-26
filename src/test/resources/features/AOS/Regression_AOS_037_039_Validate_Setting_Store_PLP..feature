Feature: Regression_AOS_037_039_Validate_Setting_Store_PLP

  #@AOS_Regression
  @AOS_037_039

Scenario Outline: Regression_AOS_037_039_Validate_Setting_Store_PLP
  Given we are on "aos_dsgHatsFamily" page
  When we enter "42" and click submit
  And we wait for 5 seconds
  Then we validate store layer zip code:
    |111111               |
  And we validate stores within hundred miles "<zipCode>"
  And we select the store in store layer "<storeName>"
  And we clear the store and validate it is removed "<storeName>"
Examples:
    |searchTerm|zipCode|storeName            |
    |yeti      |19115  |DICK’S Warehouse Sale|
Feature: Regression_AOS_033_035_Validate_Setting_Store_SRLP

  @AOS_Regression
  @AOS_033_035

Scenario Outline: Regression_AOS_033_035_Validate_Setting_Store_SRLP
  Given we are on "dsg_aos" page
  When we enter "42" and click submit
  When we search for "<searchTerm>" keyword in the search box
  Then we validate store layer zip code:
    |111111               |
  And we validate stores within hundred miles "<zipCode>"
  And we select the store in store layer "<storeName>"
  And we clear the store and validate it is removed "<storeName>"
Examples:
    |searchTerm|zipCode|storeName            |
    |yeti      |19115  |DICK’S Warehouse Sale|

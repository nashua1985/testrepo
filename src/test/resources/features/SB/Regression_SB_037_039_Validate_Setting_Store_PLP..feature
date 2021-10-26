Feature: Regression_SB_037_039_Validate_Setting_Store_PLP

  #@SB_Regression
  @SB_037_039
  @SB_Regression_mobile
  @SB_037_039_mobile

Scenario Outline: Regression_SB_037_039_Validate_Setting_Store_PLP
  Given we are on "dsgHatsFamily" page
  When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
  Given we are on "dsgHatsFamily" page
  And we wait for 5 seconds
  Then we validate store layer zip code:
    |111111               |
  And we validate stores within hundred miles "<zipCode>"
  And we select the store in store layer "<storeName>"
  And we clear the store and validate it is removed "<storeName>"
Examples:
    |searchTerm|zipCode|storeName            |
    |yeti      |19115  |DICK’S Warehouse Sale|

      @SB_037_039_Zeta
      @SB_Regression_Zeta
      @SB_037_039_Zeta_mobile
      @SB_Regression_Zeta_mobile
  Scenario Outline: Regression_SB_037_039_Validate_Setting_Store_PLP
    Given we are on "dsgHatsFamily_zeta" page
    When we add cookies to access zeta:
      |zeta|true|
    Given we are on "dsgHatsFamily_zeta" page
    Then we validate store layer zip code:
      |111111               |
    And we validate stores within hundred miles "<zipCode>"
    And we select the store in store layer "<storeName>"
    And we clear the store and validate it is removed "<storeName>"
    Examples:
      |searchTerm|zipCode|storeName            |
      |yeti      |19115  |DICK’S Warehouse Sale|

                               ####_Golf_Galaxy_#####
    @SB_GG_Regression
    @SB_GG_037_039
    @SB_GG_Regression_mobile
    @SB_GG_037_039_mobile

    Scenario Outline: Regression_SB_037_039_Validate_Setting_Store_PLP_GG
      Given we are on "gg_drivers" page
      When we add cookies to block medalia popup:
        |BlockedTags|Medallia|
      Given we are on "gg_drivers" page
      And we wait for 5 seconds
      Then we validate store layer zip code:
        |111111               |
      And we validate stores within hundred miles "<zipCode>"
      And we select the store in store layer "<storeName>"
      And we clear the store and validate it is removed "<storeName>"
    Examples:
      |searchTerm|zipCode|storeName   |
      |gold shoe |19115  |MOUNT LAUREL|

    @SB_GG_037_039_Zeta
    @SB_GG_Regression_Zeta
    @SB_GG_037_039_Zeta_mobile
    @SB_GG_Regression_Zeta_mobile
    Scenario Outline: Regression_SB_037_039_Validate_Setting_Store_PLP_GG_Zeta
    Given we are on "gg_zeta" page
    And we wait for 10 seconds
    When we add cookies to access zeta:
      |zeta|true|
    When we add cookies to access zeta:
      |tiger|woods|
    Given we are on "gg_zeta" page
    And we wait for 10 seconds
    When we search for "<searchTerm>" keyword in the search box
    Then we validate store layer zip code:
      |111111               |
    And we validate stores within hundred miles "<zipCode>"
    And we select the store in store layer "<storeName>"
    And we clear the store and validate it is removed "<storeName>"
    Examples:
      |searchTerm|zipCode|storeName   |
      |gold shoe |19115  |MOUNT LAUREL|
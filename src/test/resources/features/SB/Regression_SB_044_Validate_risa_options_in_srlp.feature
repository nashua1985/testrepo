Feature: Regression_SB_044_Validate_risa_options_in_srlp

  @SB_Regression
  @SB_044
Scenario Outline: Regression_SB_044_Validate_risa_options_in_srlp
  Given we are on "dsg" page
  And we wait for 10 seconds
  When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
  Given we are on "dsg" page
  And we wait for 10 seconds
  And we search for "<keyWord>" keyword in the search box
  And we enter zip "<zipCode>" in store view
  And we select the store in store layer "<storeName>"
  And we validate if risa options are displayed correctly
  Examples:
  |keyWord  |zipCode|storeName            |
  |yeti     |19115  |DICK’S Warehouse Sale|

    @SB_044_Zeta
    @SB_Regression_Zeta
  Scenario Outline: Regression_SB_044_Validate_risa_options_in_srlp_Zeta
    Given we are on "dsg_zeta" page
    When we add cookies to access zeta:
      |zeta|true|
    Given we are on "dsg_zeta" page
      And we search for "<keyWord>" keyword in the search box
      And we enter zip "<zipCode>" in store view
      And we select the store in store layer "<storeName>"
      And we validate if risa options are displayed correctly
      Examples:
        |keyWord  |zipCode|storeName            |
        |yeti     |19115  |DICK’S Warehouse Sale|

                                     ####_Golf_Galaxy_#####
#  GG doesn have risa
#    @SB_GG_Regression
#    @SB_GG_044
  Scenario Outline: Regression_SB_044_Validate_risa_options_in_srlp_GG
    Given we are on "gg" page
    And we wait for 10 seconds
    When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
    Given we are on "gg" page
    And we wait for 10 seconds
      And we search for "<keyWord>" keyword in the search box
      And we enter zip "<zipCode>" in store view
      And we select the store in store layer "<storeName>"
      And we validate if risa options are displayed correctly
      Examples:
        |keyWord  |zipCode|storeName   |
        |golf shoe|19115  |MOUNT LAUREL|

#    @SB_GG_044_Zeta
#    @SB_GG_Regression_Zeta

  Scenario Outline: Regression_SB_044_Validate_risa_options_in_srlp_GG_Zeta
    Given we are on "gg_zeta" page
    When we add cookies to access zeta:
      |zeta|true|
    When we add cookies to access zeta:
      |tiger|woods|
    Given we are on "gg_zeta" page
      And we search for "<keyWord>" keyword in the search box
      And we enter zip "<zipCode>" in store view
      And we select the store in store layer "<storeName>"
      And we validate if risa options are displayed correctly
      Examples:
        |keyWord  |zipCode|storeName   |
        |golf shoe|19115  |MOUNT LAUREL|

      #Mobile
    @SB_Regression_mobile
    @SB_044_mobile
  Scenario Outline: Regression_SB_044_Validate_risa_options_in_srlp_MOBILE
    Given we are on "dsg" page
    And we wait for 10 seconds
    When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
    Given we are on "dsg" page
    And we wait for 10 seconds
    And we search for "<keyWord>" keyword in the search box
    And we enter zip "<zipCode>" in store view
    And we select the store in store layer "<storeName>"
    And we validate if risa options are displayed correctly in mobile
    Examples:
      |keyWord  |zipCode|storeName            |
      |yeti     |19115  |DICK’S Warehouse Sale|

    @SB_044_Zeta_mobile
    @SB_Regression_Zeta_mobile
  Scenario Outline: Regression_SB_044_Validate_risa_options_in_srlp_MOBILE_ZETA
    Given we are on "dsg_zeta" page
    When we add cookies to access zeta:
      |zeta|true|
    Given we are on "dsg_zeta" page
    And we search for "<keyWord>" keyword in the search box
    And we enter zip "<zipCode>" in store view
    And we select the store in store layer "<storeName>"
    And we validate if risa options are displayed correctly in mobile
    Examples:
      |keyWord  |zipCode|storeName            |
      |yeti     |19115  |DICK’S Warehouse Sale|

                                     ####_Golf_Galaxy_#####

#    @SB_GG_Regression_mobile
#    @SB_GG_044_mobile
  Scenario Outline: Regression_SB_044_Validate_risa_options_in_srlp_GG_MOBILE
    Given we are on "gg" page
    And we wait for 10 seconds
    When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
    Given we are on "gg" page
    And we wait for 10 seconds
    And we search for "<keyWord>" keyword in the search box
    And we enter zip "<zipCode>" in store view
    And we select the store in store layer "<storeName>"
    And we validate if risa options are displayed correctly in mobile
    Examples:
      |keyWord  |zipCode|storeName   |
      |golf shoe|19115  |MOUNT LAUREL|

#    @SB_GG_044_Zeta_mobile
#    @SB_GG_Regression_Zeta_mobile
  Scenario Outline: Regression_SB_044_Validate_risa_options_in_srlp_GG_MOBILE_ZETA
    Given we are on "gg_zeta" page
    When we add cookies to access zeta:
      |zeta|true|
    When we add cookies to access zeta:
      |tiger|woods|
    Given we are on "gg_zeta" page
    And we search for "<keyWord>" keyword in the search box
    And we enter zip "<zipCode>" in store view
    And we select the store in store layer "<storeName>"
    And we validate if risa options are displayed correctly in mobile
    Examples:
      |keyWord  |zipCode|storeName   |
      |golf shoe|19115  |MOUNT LAUREL|
Feature: Regression_SB_005_Validate_SearchSuggest

@SB_Smoke
@SB_Regression
@ProdSupportSmoke
@SB_005
@SB_Smoke_mobile
@SB_Regression_mobile
@SB_005_mobile

Scenario: Regression_SB_005_Validate_SearchSuggest
  Given we are on "dsg" page
  And we wait for 10 seconds
  When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
  Given we are on "dsg" page
  And we wait for 10 seconds
  And we should see the suggested search for the following:
    |treadmill           |
    |dodgers             |
    |los angeles dodgers |
    |jordan 1            |
    |yeti                |
    |north face	         |
    |dumbbell            |
    |weights             |
#    |basketball shoes	 | have only basketball shoe (there is a cat 'Basketball Shoes"
    |carhartt            |


  @SB_Smoke_Zeta
  @SB_005_Zeta
  @SB_Regression_Zeta
  @SB_Smoke_Zeta_mobile
  @SB_005_Zeta_mobile
  @SB_Regression_Zeta_mobile
  Scenario: Regression_SB_005_Validate_SearchSuggest
    Given we are on "dsg_zeta" page
    When we add cookies to access zeta:
      |zeta|true|
    Given we are on "dsg_zeta" page
    And we should see the suggested search for the following:
      |treadmill           |
      |dodgers             |
      |los angeles dodgers |
      |jordan 1            |
      |yeti                |
      |north face	         |
      |dumbbell            |
      |weights             |
#    |basketball shoes	 | have only basketball shoe (there is a cat 'Basketball Shoes"
      |carhartt            |

    ####_Golf_Galaxy_#####

  @SB_GG_Smoke
  @SB_GG_Regression
  @SB_GG_005
  @SB_GG_Smoke_mobile
  @SB_GG_Regression_mobile
  @SB_GG_005_mobile

  Scenario: Regression_SB_005_Validate_SearchSuggest_GG
    Given we are on "gg" page
    And we wait for 10 seconds
    When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
    Given we are on "gg" page
    And we wait for 10 seconds
    And we should see the suggested search for the following:
      |push cart           |
      |scotty cameron      |
      |grip                |
      |ping g425           |
      |golf shoes	       |
      |rangefinder         |
      |putter grip         |
      |golf shoe    	   |

     ####_Public_Lands_#####

  @SB_PL_Smoke
  @SB_PL_Regression
  @SB_PL_005
  @SB_PL_Smoke_mobile
  @SB_PL_Regression_mobile
  @SB_PL_005_mobile

  Scenario: Regression_SB_005_Validate_SearchSuggest_PL
    Given we are on "pl" page
    And we wait for 10 seconds
    When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
      |beta       |true    |
    Given we are on "gg" page
    And we wait for 10 seconds
    And we should see the suggested search for the following:
      |FISHING ROD         |

  @SB_PL_Smoke_Zeta
  @SB_PL_005_Zeta
  @SB_PL_Regression_Zeta
  @SB_PL_Smoke_Zeta_mobile
  @SB_PL_005_Zeta_mobile
  @SB_PL_Regression_Zeta_mobile
  Scenario: Regression_SB_005_Validate_SearchSuggest_PL_Zeta
    Given we are on "pl_zeta" page
    When we add cookies to access zeta:
      |zeta|true|
      |public|lands|
    Given we are on "pl_zeta" page
    And we should see the suggested search for the following:
      |FISHING ROD         |
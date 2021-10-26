Feature: Regression_SB_001_Validate_Top_Search_Keys

  @SB_Smoke
  @SB_Regression
  #@ProdSupportSmoke
  @SB_001

  Scenario: Regression_SB_001_Validate_Top_Search_Keys
  Given we are on "dsg" page
  And we wait for 10 seconds
  When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
  Given we are on "dsg" page
  And we wait for 10 seconds
    When we search for top10 keywords in the search box:
      |treadmill           |
      |dodgers             |
      |los angeles dodgers |
      |jordan 1            |
      |yeti                |
      |north face	       |
      |dumbbell            |
      |weights             |
      |basketball shoes	   |
      |carhartt            |

@SB_Smoke_Zeta
@SB_Regression_Zeta
@SB_001_Zeta

Scenario: Regression_SB_001_Validate_Top_Search_Keys
  Given we are on "dsg_zeta" page
  When we add cookies to access zeta:
      |zeta|true|
  Given we are on "dsg_zeta" page
  When we search for top10 keywords in the search box:
    |treadmill           |
    |dodgers             |
    |los angeles dodgers |
    |jordan 1            |
    |yeti                |
    |north face	         |
    |dumbbell            |
    |weights             |
    |basketball shoes	 |
    |carhartt            |
  @SB_Smoke_mobile
  @SB_Regression_mobile
  @SB_001_mobile
  Scenario: Regression_SB_001_Validate_Top_Search_Keys
  Given we are on "dsg" page
  And we wait for 10 seconds
  When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
  Given we are on "dsg" page
  And we wait for 10 seconds
    When we search for top10 keywords in the search box on mobile:
      |treadmill           |
      |dodgers             |
      |los angeles dodgers |
      |jordan 1            |
      |yeti                |
      |north face	       |
      |dumbbell            |
      |weights             |
      |basketball shoes	   |
      |carhartt            |
  @SB_Smoke_Zeta_mobile
  @SB_Regression_Zeta_mobile
  @SB_001_Zeta_mobile
  Scenario: Regression_SB_001_Validate_Top_Search_Keys
    Given we are on "dsg_zeta" page
    When we add cookies to access zeta:
      |zeta|true|
    Given we are on "dsg_zeta" page
    When we search for top10 keywords in the search box on mobile:
      |treadmill           |
      |dodgers             |
      |los angeles dodgers |
      |jordan 1            |
      |yeti                |
      |north face	         |
      |dumbbell            |
      |weights             |
      |basketball shoes	 |
      |carhartt            |

    ####_Golf_Galaxy_#####

  @SB_GG_Smoke
  @SB_GG_Regression
  @SB_GG_001

  Scenario: Regression_SB_001_Validate_Top_Search_Keys
    Given we are on "gg" page
    And we wait for 10 seconds
    When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
    Given we are on "gg" page
    And we wait for 10 seconds
    When we search for top10 keywords in the search box:
      |push cart           |
      |scotty cameron      |
      |grip                |
      |ping g425           |
      |golf shoes	       |
      |rangefinder         |
      |putter grip         |
      |golf shoe    	   |
  @SB_GG_Smoke_mobile
  @SB_GG_Regression_mobile
  @SB_GG_001_mobile

  Scenario: Regression_SB_001_Validate_Top_Search_Keys
    Given we are on "gg" page
    And we wait for 10 seconds
    When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
    Given we are on "gg" page
    And we wait for 10 seconds
    When we search for top10 keywords in the search box on mobile:
      |push cart           |
      |scotty cameron      |
      |grip                |
      |ping g425           |
      |golf shoes	       |
      |rangefinder         |
      |putter grip         |
      |golf shoe    	   |

    #not finished, need to send cookies
  @SB_GG_Smoke_Zeta
  @SB_GG_Regression_Zeta
  @SB_GG_001_Zeta

  Scenario: Regression_SB_001_Validate_Top_Search_Keys_GG
    Given we are on "gg_zeta" page
    When we add cookies to access zeta:
      |zeta |true |
      |tiger|woods|
    Given we are on "gg_zeta" page
    When we search for top10 keywords in the search box:
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
  @SB_PL_001

  Scenario: Regression_SB_001_Validate_Top_Search_Keys
    Given we are on "pl" page
    And we wait for 10 seconds
    When we add cookies to block medalia popup:
      |beta|true|
    Given we are on "pl" page
    And we wait for 10 seconds
    When we search for top10 keywords in the search box:
      |FISHING ROD         |

  @SB_PL_Smoke_mobile
  @SB_PL_Regression_mobile
  @SB_PL_001_mobile

  Scenario: Regression_SB_001_Validate_Top_Search_Keys_PL
    Given we are on "pl" page
    And we wait for 10 seconds
    When we add cookies to block medalia popup:
      |beta|true|
    Given we are on "pl" page
    And we wait for 10 seconds
    When we search for top10 keywords in the search box on mobile:
      |FISHING ROD       |

    #not finished, need to send cookies
  @SB_PL_Smoke_Zeta
  @SB_PL_Regression_Zeta
  @SB_PL_001_Zeta
  @SB_PL_001_Zeta_mobile

  Scenario: Regression_SB_001_Validate_Top_Search_Keys_PL_Zeta
    Given we are on "pl_zeta" page
    When we add cookies to access zeta:
      |zeta |true |
      |public|lands|
    Given we are on "pl_zeta" page
    When we search for top10 keywords in the search box:
      |FISHING ROD          |
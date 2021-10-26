Feature: Regression_AOS_005_Validate_SearchSuggest

@AOS_Smoke
@AOS_Regression
@AOS_005

Scenario: Regression_AOS_005_Validate_SearchSuggest
  Given we are on "dsg_aos" page
  When we enter "42" and click submit
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

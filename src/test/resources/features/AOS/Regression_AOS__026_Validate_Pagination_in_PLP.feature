Feature: Regression_AOS_026_Validate_Pagination_in_PLP

  @AOS_Regression
  @AOS_026

  Scenario: Regression_AOS_026_Validate_Pagination_in_PLP-Page_clicking
  Given we are on "aos_baseballCleatsFamily" page
  When we enter "42" and click submit
    And we validate pagination on SRLP-PLP by clicking page numbers

  @AOS_Regression
  @AOS_026

  Scenario: Regression_AOS_026_Validate_Pagination_in_PLP-Arrow_clicking
  Given we are on "aos_baseballCleatsFamily" page
  When we enter "42" and click submit
    And we validate pagination on SRLP-PLP by clicking arrows

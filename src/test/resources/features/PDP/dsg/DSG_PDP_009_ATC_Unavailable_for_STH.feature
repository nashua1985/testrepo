Feature: Regression_DSG_PDP_009_ATC_Unavailable_for_STH
  Background: open page
    #Given we are on "shotguns" page
    Given we are on "bikes" page

  @PDP
  @PDP_mobile
  @PDP_mobile_ios
  @Regression
  @PDP_Smoke
  @PDP_009
  Scenario: Regression_DSG_PDP_009_ATC_Unavailable_for_STH
    When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
    Given we are on "bikes" page
    And we wait for 10 seconds
    And we change the store to "Robinson"
    And we wait for 5 seconds
    And we search for "Bolt Action rifle" keyword in the search box
    And we wait for 5 seconds
    And we click on the first product in search grid
    #intention: to test add to cart with attributes not selected. expectation is an error
    And we should see "Not Available to Purchase Online"
    #need check for inactive atc button


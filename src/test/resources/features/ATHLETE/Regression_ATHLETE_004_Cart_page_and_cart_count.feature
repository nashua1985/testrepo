Feature: Regression_ATHLETE_004_Cart_page_and_cart_count

  @ATHLETE_004
  @ATHLETE_Regression
  @ATHLETE_Smoke_ui_internal
  @ATHLETE_Smoke_run2

  Scenario Outline: Regression_ATHLETE_004_Cart_page_and_cart_count
  Given we are on "dsg" page
  And we wait for 10 seconds
  When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
  Given we are on "dsg" page
  And we wait for 10 seconds
  And we login to test account
    |automation@dcsg.com|Test1234!|
  And we search for "<item>" keyword in the search box
  And we add the item to the cart and should see cart count_page
    Examples:
    |item|
    |yeti|


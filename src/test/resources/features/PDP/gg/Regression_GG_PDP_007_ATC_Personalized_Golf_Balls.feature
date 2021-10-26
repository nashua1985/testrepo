Feature: Regression_GG_PDP_007_ATC_Personalized_Golf_Balls
  Background: open page
    Given we are on "personalGolfBallsGG" page

  @PDP_GG
  @PDP_mobile
  @PDP_mobile_ios
  @Regression
  @PDP_007
  Scenario: Regression_GG_PDP_007_ATC_Personalized_Golf_Balls
    And we click  Ship to me
    And we click on the first product in search grid
    And we click on Add to Cart button
    #intention: to test add to cart with attributes not selected. expectation is an error
    Then we should see "This field is required"
    And we select the color Red
    And I write  "Line1" with "Line2" and "Line3" and "14"
    #And we type "Line1" in Text Line One
    #And we type "Line2" in Text Line Two
    #And we type "Line3" in Text Line Three
    And we wait for 3 seconds
    And we validate available to ship
    #intention: to see if ATC should be successful, is there availability to add to cart
    And we click on Add to Cart button
    And we wait for 5 seconds
    Then we should see "ADDED TO CART"
    And we click GO TO CART in safari
    And we click the details section
    Then we should see "1 item"
    Then we should see "Red"
    Then we should see "LINE1"
    Then we should see "LINE2"
    Then we should see "LINE3"



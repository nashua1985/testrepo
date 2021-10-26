Feature: Regression_GG_PDP_004_ATC_Wood
  Background: open page
    Given we are on "woodGG" page


  @PDP_GG
  @Regression
  @PDP_004
  @PDP_003
  @Batch1
  @PDP_mobile
  @PDP_mobile_ios
  Scenario: Regression_GG_PDP_004_ATC_Wood
    And we click on the first product in search grid
    And we wait for 5 seconds
    And we select Flex
    And we select Hand
    And we select Loft
    #And we select any available Shaft
    And we validate available to ship
    And we click on Add to Cart button
    And we wait for 5 seconds
    And we should see "ADDED TO CART"
    And we should see "Continue Shopping"
    And we should see "GO TO CART"
    And we click GO TO CART in safari
    And we should see "1 item"
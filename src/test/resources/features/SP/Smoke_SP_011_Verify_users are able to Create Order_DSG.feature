Feature: Smoke_SP_011_Verify_users_are_able_to_Create_Order_DSG
  Background: open page
    Given we are on "oktahub" page

@SP
@Smoke
@Regression
@SP_011
Scenario Outline: Smoke_SP_011_Verify_users_are_able_to_Create_Order_DSG
  When we login to Solepanel username "<username>" password "<password>"
  When users click on Create an Order in Solepanel DSG link
  Then users should be navigated to DSG home page 
  And  users should be able to browse,select, add items to cart, place order

  Examples:
    |username	| password	|
    |Lakshmi.Haritheertham@dcsg.com|Iamindu14?|

Feature: Smoke_SP_012_Verify_users_are_able_to_Create_Order_GG
  Background: open page
	Given we are on "oktahub" page

@SP
@Smoke
@Regression
@SP_012
Scenario Outline: Smoke_SP_012_Verify_users_are_able_to_Create_Order_GG
  When we login to Solepanel username "<username>" password "<password>"
  When users click on Create an Order in Solepanel GG link
  Then users should be navigated to GG home page
  And  users should be able to browse,select, add items to cart, place order in Golf Galaxy

  Examples:
    |username	| password	|
    |Lakshmi.Haritheertham@dcsg.com|Iamindu14?|
Feature: Smoke_SP_008_Verify_users_are_able_to_view_cancel_apply_Adjust_Item
  Background: open page
    Given we are on "oktahub" page
@SP
@Smoke
@Regression
@SP_008
Scenario Outline: Smoke_SP_008_Verify_users are able to view_cancel_apply Adjust Item
    When we login to Solepanel username "<username>" password "<password>"
    And users search for an Order using email "<email>" in Order Look Up container
	And users click on Adjust Item button in Solepanel Order details page
  	Then users should be able to view,click,cancel and apply Adjustment on Item

  Examples:
    |username	| password	|email	|
    |Lakshmi.Haritheertham@dcsg.com|Iamindu14?|jay.nagel@gmail.com|
  
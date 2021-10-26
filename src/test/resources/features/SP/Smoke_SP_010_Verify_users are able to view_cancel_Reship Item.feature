Feature: Smoke_SP_010_Verify_users_are_able_to_view_cancel_Reship_Item
  Background: open page
	Given we are on "oktahub" page
@SP
@Smoke
@Regression
@SP_010
Scenario Outline: Smoke_SP_010_Verify_users are able to view_cancel_Reship Item
	When we login to Solepanel username "<username>" password "<password>"
	When users search for Order using "<order_number>" in Order Look Up container for Reship Item
  	And users click on Reship Item button in Solepanel Order details page
  	Then users should be able to view,click,cancel and Reship Item


	Examples:
		|username	| password	|order_number	|
		|Lakshmi.Haritheertham@dcsg.com|Iamindu14?|10350024936|
  
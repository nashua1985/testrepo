Feature: Smoke_SP_009_Verify_users_are_able_to_view_cancel_apply_Adjust_Shipment
  Background: open page
	Given we are on "oktahub" page
@SP
@Smoke
@Regression
@SP_009
Scenario Outline: Smoke_SP_009_Verify_users_are_able_to_view_cancel_apply_Adjust_Shipment
        When we login to Solepanel username "<username>" password "<password>"
        And users search for an Order using order number "<order_number>" in Order Look Up container
 	 	And users click on Adjust Shipment button in Solepanel Order details page
  		Then users should be able to view,click,cancel and apply Adjust Shipment

  Examples:
    |username	| password	|order_number	|
    |Lakshmi.Haritheertham@dcsg.com|Iamindu14?|10350024936|
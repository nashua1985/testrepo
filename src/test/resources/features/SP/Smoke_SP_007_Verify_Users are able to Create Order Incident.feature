Feature: Smoke_SP_007_Verify_Users_are_able_to_Create_Order_Incident
  Background: open page
    Given we are on "oktahub" page
@SP
@Smoke
@Regression
@SP_007
Scenario Outline: Smoke_SP_007_Verify_Users_are_able_to_Create_Order_Incident
    When we login to Solepanel username "<username>" password "<password>"
    And users search for Order using phone number "<phone_number>" in Order Look Up container
  	And users click on Create Order Incident button in Solepanel Order details page
  	Then users should be able to view,click,cancel and Create Order Incident 
  	
Examples:
      |username	| password	|phone_number	|
      |Lakshmi.Haritheertham@dcsg.com|Iamindu14?|412-877-4784	|

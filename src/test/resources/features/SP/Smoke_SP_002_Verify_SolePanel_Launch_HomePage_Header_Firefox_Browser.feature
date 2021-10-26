Feature: Smoke_SP_002_Verify_SolePanel_Launch_HomePage_Header_Firefox_Browser
  Background: open page
    Given we are on "oktahub" page
@SP
@Smoke
@Regression
@SP_002
Scenario Outline: Smoke_SP_002_Verify_SolePanel_Launch_HomePage_Header_Firefox_Browser
    When we login to Solepanel username "<username>" password "<password>"
    And we wait for 5 seconds
    When users click on Solepanel and Header Links in Sole Panel home page in Firefox Browser

    Examples:
      |username	| password	|
      |Lakshmi.Haritheertham@dcsg.com|Iamindu14?|

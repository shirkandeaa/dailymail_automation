Feature: To verify basic functionality on Home Page

 @runSmoke
 Scenario: To Verify date on home page
 Given I am on dailymail website home page
 When I see date component at top of home page
 Then Current date should be displayed


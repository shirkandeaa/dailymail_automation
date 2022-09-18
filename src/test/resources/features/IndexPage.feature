Feature: To verify functionality on Index Page

   @runSmoke
 Scenario Outline: To Verify navigation bar's colour
    Given I am on dailymail website home page
    When I navigate to "<Channel>" Page
    Then Primary nav bar and secondary nav bar should have background colour for channel "<Channel>"

       Examples:
       |Channel|
       |Sport  |

   @runSmoke
   Scenario: To Verify gallery arrows
      Given I am on gallery page
      And I can see atleast one gallery icon with count of images displayed
      When I click on first gallery icon
      Then Gallery is loaded with full screen
      And Gallery has Previous and Next arrows


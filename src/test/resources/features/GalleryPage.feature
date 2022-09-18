Feature: To verify functionality on Gallery Page

  @runSmoke
  Scenario: To Verify Gallery Component
    Given I am on gallery page
    And I can see atleast one gallery icon with count of images displayed
    When I click on first gallery icon
    Then Gallery is loaded with full screen
    And Gallery has Previous and Next arrows

  @runSmoke
  Scenario: To Verify facebook modal
    Given I am on gallery page
    And I can see atleast one gallery icon with count of images displayed
    When I click on facebook share icon
    Then Facebook modal dialog should open

  @runSmoke
  Scenario: To Verify video fullscreen
    Given I am on gallery page
    When I click on full screen button of first video
    Then Video is displayed in fullscreen
    And I click on collapse fullscreen button
    And Video is not displayed in fullscreen

  @runSmoke
  Scenario Outline: To display team ranking
    Given I am on gallery page
    When I see premier league table at bottom right side
    Then I can see ranking for team "<Team>"

    Examples:
      |Team       |
      |Liverpool  |
@tag
Feature: Schoology login

  @regression
  Scenario: As a user of Schoology, user should be able to login with correct usernmae and password
    # for inter explorer use ie, for firfox use ff for chrome use cr
    Given User opens a browser "ls"
    And Navigates to the app "";
    And User clicks login
    When User enters information
      | email                     | password |
      | qatesterteamtwo@gmail.com | qatester |
    And User is able to see home page
    And User closes browser

  @tag
  Scenario: As a user of Schoology, user should not able to login with correct usernmae and password
    # for inter explorer use ie, for firfox use ff for chrome use cr
    Given User opens a browser "ff"
   	And Navigates to the app "https://www.schoology.com"
    And User clicks login
    When User enters information
      | email                      | password  |
      | qatersterteamone@gmail.com | qatester2 |
    And User is asked to login
    And User closes browser

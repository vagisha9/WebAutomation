Feature: Verify Google search scenario and links on touchtunes press website

  Scenario: Validate google search results after entering touchtunes as a keyword
    When User navigates to google
    And User enters touchtunes in search box
    And User clicks google search
    Then User should see touchtunes results are displayed

  Scenario: Validate links on touchtunes press page
    When User navigates to touchtunes press page
    And User gets and logs all links
    Then User checks and prints broken links
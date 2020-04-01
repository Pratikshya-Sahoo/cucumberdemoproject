Feature: Demo Web Shop login
  
  Demo Web Shop login feature

  Scenario Outline: login site
    Given user launched chrome
    And user provides valid url
    And clicks on login hyperlink
    Given the email id is "<emailid>"
    When the password is "<password>"
    And clicks on Login button
    Then clicks on Logout button
    And see welcome message

    Examples: 
      | emailid              | password   |
      | karthik456@gmail.com | karthik456 |
      | karthik456@gmail.com | karthik456 |
@entirefeature
Feature: Title of your feature
  
  I want to use this template for my feature file

  @login @regression
  Scenario: login to demowebshop
    Given Amy launched chrome browser
    And provided valid URL
    When Amy provides valid credentials
    And click on login
    Then Amy shall see the home page

  @searchprdcts
  Scenario: search products in demowebshop
    Given Amy is on home page
    When Amy searches for a product
    Then she shall see list of products displayed

  @register @regression
  Scenario: registration of user in demowebshop
    Given Amy is on registration page
    When Amy provides all the details
    Then she shall be registered successfully

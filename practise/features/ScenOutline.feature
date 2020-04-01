Feature: Employee Appraisal process
  
  I want to use this template for my feature file

  Scenario Outline: employee appraisal
    Given the employee name is "<empname>"
    When he gets rating as <rating>
    Then he shall recieve hike percent as <hikepercent>

    Examples: 
      | empname | rating | hikepercent |
      | Sri     |      1 |          90 |
      | Raj     |      3 |          80 |

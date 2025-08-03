@all
Feature:User Login
  Background:
    Given user navigates to the application
    When user clicks on signup or login link
    Then signup or login page should be displayed
  @smoke
  Scenario:pass test data inline
    And user enters username as "QAAutomationClasses@gmail.com " and password as "QAAutomationClasses"
    And user clicks on login button
    Then application should navigate to logged in user home page
    And user clicks on logout link
@smoke
  Scenario Outline:Scenario outline demo
    And user enters username as "<userName>" and password as "<password>"
    And user clicks on login button
    Then application should navigate to logged in user home page
    And user clicks on logout link
    @positiveLoginScenario
    Examples:
      | userName                       | password             |
      | QAAutomationClasses@gmail.com  | QAAutomationClasses  |
    @negativeLoginScenario
    Examples:
      | userName                       | password             |
      | QAAutomationClasses1@gmail.com | QAAutomationClasses1 |

#  @smoke @regression
#  Scenario:Data table as Lists
#    And user enters username  and password as below
#      |QAAutomationClasses@gmail.com|QAAutomationClasses|
#      |QAAutomationClasses1@gmail.com|QAAutomationClasses1|
#      |QAAutomationClasses2@gmail.com|QAAutomationClasses2|
#      |QAAutomationClasses3@gmail.com|QAAutomationClasses3|
#    And user clicks on login button
#    Then application should navigate to logged in user home page
#    And user clicks on logout link
#    And user closes the browser
#
#  Scenario:Data table as Map
#    And user enters username  and password
#    |username|password|
#    |QAAutomationClasses@gmail.com|QAAutomationClasses|
#    |QAAutomationClasses1@gmail.com|QAAutomationClasses1|
#    |QAAutomationClasses2@gmail.com|QAAutomationClasses2|
#    |QAAutomationClasses3@gmail.com|QAAutomationClasses3|
#    And user clicks on login button
#    Then application should navigate to logged in user home page
#    And user clicks on logout link
#    And user closes the browser
#

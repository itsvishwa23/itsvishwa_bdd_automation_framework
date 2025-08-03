Feature:  Validate OrangeHRM Login

  @validate_login
  Scenario Outline: Successful login with valid credentials
    Given User is on the OrangeHRM login page
    When User enters username "<username>" and password "<password>"
    And User clicks on the login button
    Then User should be navigated to the dashboard

    Examples:
      | username | password  |
      | Admin    | admin123  |

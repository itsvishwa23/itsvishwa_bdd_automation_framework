Feature:Open SignUp or Login Page
  @smoke
  Scenario:Navigate to signup or Login Page
    Given user navigates to the application
    When user clicks on signup or login link
    Then signup or login page should be displayed
    #And user closes the browser


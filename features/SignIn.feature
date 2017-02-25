Feature: SingIn Scenario
    If there is no user in the database the SingIn should not processed

  Scenario: Login with invalid data
    Given User is on Home Page
    When User Navigate to SignIn Page
    And User enters Credentials to LogIn
      | testuser_1 | Test@153 |
    Then Message displayed Login Successfully

  Scenario Outline: Successful Login with Valid Credentials
    Given User is on Home Page
    When User Navigate to LogIn Page
    And User enters "<username>" and "<password>"
    Then Message displayed Login Successfully

    Examples: 
      | username   | password |
      | testuser_1 | Test@153 |
      | testuser_2 | Test@153 |

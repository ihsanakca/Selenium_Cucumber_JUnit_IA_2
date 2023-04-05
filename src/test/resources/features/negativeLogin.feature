Feature: Negative Login Tests


  Scenario Outline: Negative Login Test
    Given The user is on the login page
    When The user type in valid credentials: "<userEmail>" and "<password>"
    Then The warning message contains "<message>"
    Examples:
      | userEmail        | password   | message                                  |
      | sgezer@gmail.com | wrongpass  | Password is incorrect. Please check      |
      | wrongEmail       | sg12345678 | Email address is incorrect. Please check |
      | wrongEmail       | wrongpass  | Email address is incorrect. Please check |
      |                  | sg12345678 | Please enter your email.                 |
      | sgezer@gmail.com |            | Please enter your password!              |
      |                  |            | Please enter your email.                 |
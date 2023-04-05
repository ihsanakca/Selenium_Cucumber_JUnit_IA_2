Feature: Dashboard Controls


  Scenario: Using List with Cucumber
    Given The user is on the login page
    When The user type in valid credentials: "sgezer@gmail.com" and "sg12345678"
    Then The user should be able to see all tabs that shown on the page
      | Dashboard   |
      | Developers  |
      | Components  |
      | Forms       |
      | JavaScript  |
      | Selim Gezer |

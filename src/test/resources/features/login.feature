@login
Feature: Login Functionality
  #As a user I should be able to login so I can see my account
  Background:
    Given The user is on the login page

  @smoke @regression
  Scenario: Login as Selim
    #Given The user is on the login page
    When The user type in Selim credentials
    Then The user should be able to login successfully

  @regression
  Scenario: Login as Rosa
   # Given The user is on the login page
    When The user type in Rosa credentials
    Then The user should be able to login successfully

  @smoke
  Scenario: Login as Ramanzi
  #  Given The user is on the login page
    When The user type in Ramanzi credentials
    Then The user should be able to login successfully

  Scenario: Login with parameters
   # Given The user is on the login page
    When The user type in valid credentials: "sgezer@gmail.com" and "sg12345678"
    Then The user should be able to login successfully
    And The user should be able to see "Selim Gezer"

  Scenario: Login with parameters
 #   Given The user is on the login page
    When The user type in valid credentials: "rosa@test.com" and "Test123456"
    Then The user should be able to login successfully
    And The user should be able to see "Rosa"
  @rerun
  Scenario: Login with parameters
  #  Given The user is on the login page
    When The user type in valid credentials: "Ramanzi@test.com" and "Test123456"
    Then The user should be able to login successfully
    And The user should be able to see "Mansimmo61"

@rerun
  Scenario:Login with map
  #  Given The user is on the login page
    Then The user type in valid credentials and verify successful login with user name
      | userEmail | sgezer@gmail.com |
      | password  | sg12345678       |
      | userName  | Selim Gezer      |


  Scenario:Login with list
  #  Given The user is on the login page
    Then The user type in valid credentials via list and verify successful login with user name
      | sgezer@gmail.com |
      | sg12345678       |
      | Selim Gezer      |


  Scenario Outline: Login with different user using scenario outline
    When The user type in valid credentials: "<userEmail>" and "<password>"
    Then The user should be able to see "<userName>"
    Examples:
      | userEmail        | password   | userName    |
      | Ramanzi@test.com | Test123456 | Mansimmo    |
      | rosa@test.com    | Test123456 | Rosa        |
      | sgezer@gmail.com | sg12345678 | Selim Gezer |



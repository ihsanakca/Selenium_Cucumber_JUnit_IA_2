Feature: Profile Page Tests

  @rerun
  Scenario: The user navigates to Add Education Page
    Given The user is on the login page
    When The user type in valid credentials: "sgezer@gmail.com" and "sg12345678"
    Then The user should be able to see "Selim Gezer"
    When The user navigate to "Selim Gezer" and "My Profile"
    Then The user should be able to see overview page
    When The user navigate to my profile tab: "Add Education"
    Then The user should be able to see add education page


  Scenario: The user navigates to Add Education Page and fill the add education form
    Given The user is on the login page
    When The user type in valid credentials: "rosa@test.com" and "Test123456"
    Then The user should be able to see "Rosa"
    When The user navigate to "Rosa" and "My Profile"
    Then The user should be able to see overview page
    When The user navigate to my profile tab: "Add Education"
    Then The user should be able to see add education page
    When The user fill the form with the followings "Dicle", "Master", "Law", "11122020", "12122022", "nice program"
    Then The user should see added education record with school name :"Dicle"
    And The user should be able to delete education record with school name :"Dicle"

  Scenario: The user navigates to Add Education Page and fill the add education form
    Given The user is on the login page
    When The user type in valid credentials: "rosa@test.com" and "Test123456"
    Then The user should be able to see "Rosa"
    When The user navigate to "Rosa" and "My Profile"
    Then The user should be able to see overview page
    When The user navigate to my profile tab: "Add Education"
    Then The user should be able to see add education page
    When The user fill the form with the following list
      | 18 Mart University |
      | Bachelor Degree    |
      | Medicine           |
      | 11122020           |
      | 12122022           |
      | Hard program       |
    Then The user should see added education record with school name :"18 Mart University"
    And The user should be able to delete education record with school name :"18 Mart University"

  @wip
  Scenario Outline: Add Experience to "<userName>" with scenario outline
    Given The user is on the login page
    When The user type in valid credentials: "<userEmail>" and "<password>"
    Then The user should be able to see "<userName>"
    When The user navigate to "<userName>" and "<moduleName>"
    Then The user should be able to see overview page
    When The user navigate to my profile tab: "<myProfileTab>"
    Then The user should be able to see related page with submit button: "<submitButton>" page
    When The user fill the add experience form with "<jobTitle>", "<company>", "<location>", "<fromDate>", "<toDate>", "<jobDescription>"
    Then The user should be able see last added experience with "<jobTitle>"
    And The user should be able to delete education record with school name :"<jobTitle>"
    Examples:
      | userEmail        | password   | userName    | moduleName | myProfileTab   | submitButton   | jobTitle  | company | location | fromDate | toDate   | jobDescription |
      | sgezer@gmail.com | sg12345678 | Selim Gezer | My Profile | Add Experience | Add Experience | SDET      | Apple   | Adana    | 11122020 | 12122021 | good job       |
      | rosa@test.com    | Test123456 | Rosa        | My Profile | Add Experience | Add Experience | Developer | Telnet  | Urfa     | 11122020 | 12122021 | nice job       |
      | Ramanzi@test.com | Test123456 | Mansimmo    | My Profile | Add Experience | Add Experience | PO        | Doruk   | Bolu     | 11122020 | 12122021 | very good job  |
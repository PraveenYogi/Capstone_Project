Feature: Login Test

@LoginTest
  Scenario: Validating login functionality with valid credentials
  
  	Given browser is launched
    Given user navigates to the saucedemo login page
    When user enters valid "Valid_UserName" and "Valid_Password"
    And clicks on login button
    Then I validate the page title after successful login


@LoginTest
  Scenario: Validating login functionality with Invalid credentials
  
  	Given browser is launched
    Given user navigates to the saucedemo login page
    When user enters valid "Invalid_UserName" and "Invalid_Password"
    And clicks on login button
    Then I validate the page title after successful login
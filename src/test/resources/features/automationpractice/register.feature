Feature: Registration
  As a new user
  I want to register with automationpractice.com
  So that I can shop till I drop

  Scenario: Register successfully
    Given I am on the homepage
    When I sign in
    And enter an email address to create an account
    And I fill in the registration form
    Then I am registered and logged in

  Scenario: Submit empty registration form
    Given I am on the homepage
    When I sign in
    And enter an email address to create an account
    And try to create account without filling in the form
    Then I will get an error

  Scenario: Log in using my new credentials
    Given I am a registered user
    But I am signed out
    And I am on the homepage
    When I sign in
    And enter an email address and password to log in
    Then I am successfully logged in

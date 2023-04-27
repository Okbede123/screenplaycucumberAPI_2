Feature: About environment

  @getAllEnvironment
  Scenario: Get all environment
    Given Get all environment
    Then Verify all environment "Postman 30 Day Environment" and get id
    When get single environment with id on step above
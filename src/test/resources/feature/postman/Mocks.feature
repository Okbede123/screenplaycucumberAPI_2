Business Need: about feature

  @createMockandUpdate
  Scenario Outline: Create mock
    Given run api create mock with Name "<name>"
    Then verify mock created
    When update mock of "<name>"
    Then Verify mock update of "<name>"
    Examples:
      |name  |
      |mock create 1|
      |mock create 2|

  @getAllMock
  Scenario: get All Mock
    Given run Api get all mock
    Then verify all mock list

  @getSingleMock
  Scenario: get single id of mock
    Given get single id "779e31f3-2225-479f-9509-4d4bb4eafc95" of mock
    Then verify this mock with id



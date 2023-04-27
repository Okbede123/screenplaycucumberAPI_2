Feature: Cac Scenario ve Collection

  @getListCollection
  Scenario: Get List Collection
    Given Go To Get List All Collection
    Then Get Name of All Collection


    @CreateCollection
  Scenario: Create random Collection
    Given Create random collection
    Then Verify collection created
      When Delete this collection
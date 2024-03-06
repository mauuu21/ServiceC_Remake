Feature: Registration & Login

  Scenario: Registration - Happy Path returns Success
    Given the environment is ready
    And the user "Bela" registers with password "testPassword"

    When the user "Bela" logs in with password "testPassword"
    Then the user receives a token

    When the user "Bela" sends an empty form as "BaseEmptyForm"
    Then the Forms end-point returns HTTP status code 201

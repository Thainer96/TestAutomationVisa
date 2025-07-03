Feature: create user

  @createuser
  Scenario Outline: create a new user <username>
    Given a user build to payload "<payload>"
      | id   | username   | firstName   | lastName   | email   | password   | phone   | userStatus   |
      | <id> | <username> | <firstName> | <lastName> | <email> | <password> | <phone> | <userStatus> |
    When send POST a "/user"
    Then  the response code status should be 200
    And the response "username" should be "<username>"
    And the response time should be less than 5000 ms

    Examples:
      | payload    | id  | username   | firstName | lastName | email          | password | phone | userStatus |
      | createUser | 10  | Thainer123 | John      | James    | john@email.com | 12345    | 12345 | 1          |
      | createUser | 210 | Andres321  | John      | James    | john@email.com | 12345    | 12345 | 1          |

    @getByUser
    Scenario Outline: search a user
      Given I send a GET request to "user/<user>"
      Then the response code status should be 200
      Examples:
      |user|
      | Thainer123   |
      | Andres   |
      | 123Thainer   |
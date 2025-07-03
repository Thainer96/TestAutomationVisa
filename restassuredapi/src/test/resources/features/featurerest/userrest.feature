Feature: create user

  @createuser
  Scenario Outline: Crear usuario <username>
    Given a requet with parameters:
      | id         | <id>         |
      | username   | <username>   |
      | firstName  | <firstName>  |
      | lastName   | <lastName>   |
      | email      | <email>      |
      | password   | <password>   |
      | phone      | <phone>      |
      | userStatus | <userStatus> |
    When send POST a "/user"
    Then  the response statys should be  200
    And el campo "username" debe ser igual a "<username>"
    And el campo "userStatus" debe ser igual a <userStatus>

    Examples:
      | id  | username   | firstName | lastName | email          | password | phone | userStatus |
      | 10  | Thainer123 | John      | James    | john@email.com | 12345    | 12345 | 1          |
      | 210 | Andres321  | John      | James    | john@email.com | 12345    | 12345 | 1          |

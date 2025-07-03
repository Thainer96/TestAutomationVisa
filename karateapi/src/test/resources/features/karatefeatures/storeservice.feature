Feature: all feature for store services

  Background:
    * url urlBase

  @user @regression
  Scenario Outline: api service create user <username>
    * path 'user'
    * def requestBody =
    """
    {
      "id": <id>,
      "username": "<username>",
      "firstName": "<firstName>",
      "lastName": "<lastName>",
      "email": "<email>",
      "password": "<password>",
      "phone": "<phone>",
      "userStatus": <userStatus>
    }
    """
    * request requestBody
    When method post
    Then status 200
    And match response contains requestBody
    And match response.userStatus == '#number'
    And match response.username == '#string'
    Examples:
      | id  | username   | firstName | lastName | email          | password | phone | userStatus |
      | 10  | Thainer123 | John      | James    | john@email.com | 12345    | 12345 | 1          |
      | 210 | Andres321  | John      | James    | john@email.com | 12345    | 12345 | 1          |
      | two | 1000  | John      | James    | john@email.com | 12345    | 12345 | 2          |

  @user/login @regression
  Scenario Outline: api service user/login with user <user>
    * path 'user', 'login'
    * param username = user
    * param password = password
    When method get
    Then status 200
    And match header Content-Type == 'application/json'
    And match response contains 'Logged in user session:'


    Examples:
      | user    | password |
      | 12345   | 12345    |
      | userOne | password |


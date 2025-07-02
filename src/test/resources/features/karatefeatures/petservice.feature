Feature: all feature for store services

  Background:
    * url urlBase

    @getMultiplePets @regression
  Scenario Outline: search a multiple pet
    * path 'pet/<petNumber>'
    When method get
    And status 200
    And match header Content-Type == 'application/json'
    And match response contains deep {status:<status>}
    And match response.name == name
    * print 'printing response', response
    Examples:
      | petNumber |name|status|
      | 100       |cat|available|
      | 6         |doggie|available|
      | 10        |bird|sold|
      | 5         |Dog 2|sold|

  @updatePet @regression
  Scenario Outline: use response from another scenario and update the petId <petId> with name <newName>
    * path 'pet'
    * def result = call read('classpath:features/callpet.feature') { petId: <petId> }
    * def response = result.response
    * print response
    * set response.name = newName
    * request response
    When method put
    Then status 200

    Examples:
    |petId|newName|
    |6|  micky  |
    |7|  minny  |

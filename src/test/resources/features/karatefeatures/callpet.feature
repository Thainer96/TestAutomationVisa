Feature: all feature for store services

  Background:
    * url urlBase


Scenario: search a pet
    * path 'pet', petId
    When method get
    And status 200
    And match header Content-Type == 'application/json'
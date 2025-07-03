# QA Automation Project

This repository shows the solution to the given challenge. The goal was to complete two parts: API testing and performance testing.

For the API tests, I used two different tools but tested the same group of endpoints with different approaches:
 
- **Karate**: A BDD-based framework to test REST APIs.
- **Rest Assured**: A Java library for functional tests using Cucumber.

For the performance tests, I used the tool K6:

- **K6**: A performance testing tool for load and stress testing.

---

## Project Structure

```
TestautomationVisa/
├── k6performance/
├── karateapi/
├── restassuredapi/
```

---

## Karate
Karate allows you to write API tests in a simple way using Gherkin-like language:

```gherkin
Scenario: search a pet
  * path 'pet', petId
  When method get
  And status 200
  And match header Content-Type == 'application/json'
```

---

## Rest Assured + Cucumber

Cucumber was used to define the scenarios, and Rest Assured was used to send the requests:

```gherkin
@getByUser
Scenario Outline: search a user
  Given I send a GET request to "user/<user>"
  Then the response code status should be 200
  Examples:
  |user|
  | Thainer123   |
  | Andres   |
  | 123Thainer   |
```

```java
@Given("I send a GET request to {string}")
public void iSendAGETRequestTo(String url) {
    userRequest.getUser(url);
    userCreateResponse = ResponseManager.getResponseBody(UserCreateResponse.class);
}
```

---

## K6

K6 lets you simulate many users accessing the API at the same time:

```javascript
export default function () {
  const res = http.get('http://localhost:8080/api/v3/pet/findByStatus?status=available');

  check(res, {
    'status is 200': (r) => r.status === 200,
    'response is array': (r) => Array.isArray(r.json()),
  });
}
```

To run a load test:

```bash
mvn test -Porderstress
```

---

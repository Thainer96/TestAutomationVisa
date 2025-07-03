package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utilities.ResponseManager;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class CommonStepDefinition {

    @Then("the response code status should be {int}")
    public void verifyStatusCode(int expectedStatusCode) {
        ResponseManager.verifyStatusCode(expectedStatusCode);
    }

    @And("the response {string} should be {string}")
    public void theResponseStatusShouldBe(String valueResponse, String expectedStatus) {
        ResponseManager.verifyStatusText(valueResponse, expectedStatus);
    }

    @And("the value of Json {string} is different null")
    public void theValueOfJsonIsDifferentNull(String propertyJson) {
        ResponseManager.isPropertyNull(propertyJson);
    }

    @And("the response time should be less than {int} ms")
    public void verifyResponseTime(int maxResponseTime) {
        ResponseManager.verifyResponseTime(maxResponseTime);
    }

}

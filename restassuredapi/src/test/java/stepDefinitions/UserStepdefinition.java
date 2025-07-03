package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import jsonProcess.BodyJsonManager;
import models.UserCreateResponse;
import request.UserRequest;
import utilities.ResponseManager;

import java.util.Map;

public class UserStepdefinition {

    private final BodyJsonManager bodyJsonManager = new BodyJsonManager();
    private final UserRequest userRequest = new UserRequest();

    private UserCreateResponse userCreateResponse;


    @Given("a user build to payload {string}")
    public void aUserBuildToPayload(String bodyName, DataTable featureData) {
        Map<String, String> data = featureData.transpose().asMap(String.class, String.class);
        String bodyBuild = bodyJsonManager.buildBodyWithData(bodyName, data);
        userRequest.creteUser(bodyBuild,"user");
        userCreateResponse = ResponseManager.getResponseBody(UserCreateResponse.class);
    }

    @When("send POST a {string}")
    public void sendPostUser(String path) {

    }

    @Given("I send a GET request to {string}")
    public void iSendAGETRequestTo(String url) {
        userRequest.getUser(url);
        userCreateResponse = ResponseManager.getResponseBody(UserCreateResponse.class);
    }
}

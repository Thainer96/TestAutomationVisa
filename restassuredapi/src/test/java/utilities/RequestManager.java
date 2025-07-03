package utilities;

import io.restassured.specification.RequestSpecification;

public class RequestManager {
    public static void initRequest(){
            RequestSpecification defaultRequest = io.restassured.RestAssured.given()
                    .baseUri("http://localhost:8080/api/v3/")
                    .header("Accept", "application/json")
                    .contentType("application/json");
        new RequestProvider().set(defaultRequest);
    }

}

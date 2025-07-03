package utilities;

import io.restassured.specification.RequestSpecification;

public class BaseRequest {
    protected RequestSpecification getRequest(){
        RequestSpecification request = new RequestProvider().get();
        if (request == null) {
            RequestManager.initRequest();
            request = new RequestProvider().get();
        }
        return request;
    }
}

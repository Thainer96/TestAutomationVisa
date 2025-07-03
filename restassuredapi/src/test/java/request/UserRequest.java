package request;

import utilities.BaseRequest;
import utilities.ResponseManager;

public class UserRequest extends BaseRequest {

    public void creteUser(String userRequest, String url){
        var response = getRequest()
                .body(userRequest)
                .when()
                .post(url);
        ResponseManager.setResponse(response);
    }

    public void getUser(String url){
        var response = getRequest().get(url);
        ResponseManager.setResponse(response);
        ResponseManager.verifyStatusCode(200);
    }

}

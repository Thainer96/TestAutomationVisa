package utilities;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;

public class ResponseManager {
    private static Response response;

    public static void verifyStatusCode(int expectedStatusCode){
        Assert.assertEquals("Expected status code did not match", response.getStatusCode(), expectedStatusCode);
    }

    public static void verifyStatusText(String valueResponse, String expectedStatusText){
        System.out.println(getValueJson(valueResponse));
        Assert.assertEquals(getValueJson(valueResponse), expectedStatusText);

    }

    public static void verifyResponseTime(int maxResponseTime){
        Assert.assertTrue(response.getTime()<maxResponseTime);
    }


    public static <T> T getResponseBody(Class<T> clazz){
        return response.body().as(clazz);
    }

    public static String getPathAsString(String path){
        return response.path(path).toString();
    }

    public static void setResponse(Response response){
        ResponseManager.response = response;
    }

    public static void isPropertyNull(String propertyJson){
        String valueJson = getValueJson(propertyJson);
        Assert.assertNotNull(String.format("Error the next property %s is empty ", propertyJson), valueJson);
    }

    public static String getValueJson(String propertyJson){
        String responseBody = response.getBody().asString();
        System.out.println(responseBody);
        JsonPath jsonPath = new JsonPath(responseBody);
        return jsonPath.getString(propertyJson);

    }


}

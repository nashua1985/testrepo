package com.dsg.cucumber.step_definitions;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;

import static io.restassured.RestAssured.*;

public class Api_ProjectStepDefinition {
    private static final Logger logger = Logger.getLogger(Api_ProjectStepDefinition.class);

    public void getResponseCode(String uri, int statusCode) {
            given().when().get(uri).then().assertThat().statusCode(statusCode);
    }
    public int getResponseCodeToInt(String uri) {
        int getStatusCode = given().get(uri).statusCode();
        return getStatusCode;
    }
    public void getResponseBody(String url) {
        given().when().get(url).then().log().body();
    }
    public void getResponseHeaders(String url) {
        given().when().get(url).then().log().headers();
    }



    public Response getResponseBodyPostRequest(String url, JSONObject requestBody, String username,String password) {
        System.out.println(url);
        Response response= given()
                .auth()
                .preemptive()
                .basic(username, password)
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post(url)
                .then()
                .log().all()
                .extract().response();
        return response;

    }
}



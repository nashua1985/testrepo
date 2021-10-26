package com.dsg.cucumber.step_definitions.sb.dsg;

import com.dsg.cucumber.step_definitions.Api_ProjectStepDefinition;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.asserts.Assertion;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Simple_api_test {
    private static final Logger logger = Logger.getLogger(Simple_api_test.class);
    Api_ProjectStepDefinition apiMethods = new Api_ProjectStepDefinition();

    @When("we send api request to get a status code:")
    public void getResponseCodeTest(Map<String, List<Integer>> uriAndStatusCode) {
                for (Map.Entry<String, List<Integer>> inputs : uriAndStatusCode.entrySet()) {
                    String getUri = inputs.getKey();
                    List<Integer> listOfStatusCodes = inputs.getValue();
                    for(int i=0;i<listOfStatusCodes.size()-1;i++){
                        int getStatusCode = apiMethods.getResponseCodeToInt(getUri);
                        System.out.println("Status code: "+getStatusCode);
                        if(getStatusCode == listOfStatusCodes.get(i)
                                || getStatusCode == listOfStatusCodes.get(i+1)){
                            //successful call
                        }else{
                            Assert.fail("Expected: "+listOfStatusCodes.get(i)+", Found: "+getStatusCode+
                                    ", Broken URL: "+getUri);
                        }
                    }
                }
            }

    @When("we send api request to get a body {string}")
    public void getResponseBodyTest(String url) {
        apiMethods.getResponseBody(url);
    }
    @When("we send api request to get a header {string}")
    public void getResponseHeadersTest(String url) {
        apiMethods.getResponseHeaders(url);
    }
}

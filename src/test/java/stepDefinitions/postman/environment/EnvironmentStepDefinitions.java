package stepDefinitions.postman.environment;

import common.postmanAPI.Environment.EnvironmentsAPI;
import common.ultility.CommonSupport;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import net.serenitybdd.core.Serenity;

public class EnvironmentStepDefinitions {

    @Given("Get all environment")
    public void getAllEnvironment() {
     Response response = EnvironmentsAPI.getAllEnvironments(CommonSupport.TOKEN_API_POSTMAN);
        Serenity.setSessionVariable("response").to(response);
    }

    @Then("Verify all environment {string} and get id")
    public void verifyAllEnvironment(String environment) {
        Response response = Serenity.sessionVariableCalled("response");
        JsonPath jsonPath = response.jsonPath();
       int size = jsonPath.get("environments.size()");
        for (int i = 0; i < size; i++) {
           String name = jsonPath.get(String.format("environments[%d].name",i));
           if(name.contains(environment)){
               String id = jsonPath.get(String.format("environments[%d].id",i));
               Serenity.setSessionVariable("id").to(id);
               break;
           }
        }
    }


    @When("get single environment with id on step above")
    public void getSingleEnvironmentWithIdOnStepAbove() {
        String id = Serenity.sessionVariableCalled("id");
      Response response =  EnvironmentsAPI.getSingleEnvironments(CommonSupport.TOKEN_API_POSTMAN,id);
      JsonPath jsonPath = response.jsonPath();
     int sizeValue = jsonPath.get("environment.values.size()");
        for (int i = 0; i < sizeValue; i++) {
            String value = jsonPath.get(String.format("environment.values[%d].value",i));
            if(value.contains("https://postman-echo.com")){
                System.out.println("value lay duoc la "+ value);
                break;
            }
        }
    }
}

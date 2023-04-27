package stepDefinitions.postman.fork;

import common.postmanAPI.fork.ForkAPI;
import common.ultility.CommonSupport;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import net.serenitybdd.core.Serenity;
import org.json.JSONObject;

public class ForkStepDefinitions {

    @Given("Create a fork")
    public void createAFork() {
        JSONObject  jsonObject = new JSONObject();
        jsonObject.put("label","Fork label");
       Response response = ForkAPI.createCollection(CommonSupport.TOKEN_API_POSTMAN,jsonObject,CommonSupport.COLLECTIONS_ID,CommonSupport.WORKSPACE_ID);
        Serenity.setSessionVariable("response").to(response);
    }

    @Then("Verify created fork")
    public void verifyCreatedFork() {
        Response response = Serenity.sessionVariableCalled("response");
        response.prettyPrint();
    }

}

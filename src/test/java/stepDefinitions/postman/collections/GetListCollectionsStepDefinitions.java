package stepDefinitions.postman.collections;


import common.postmanAPI.collections.CollectionsAPI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import net.serenitybdd.core.Serenity;

import java.util.ArrayList;

public class GetListCollectionsStepDefinitions {

    @Given("Go To Get List All Collection")
    public void goToGetListAllCollection() {
      Response responseAllCollection = CollectionsAPI.getListAllCollections("PMAK-64032f29aa0bed48225a64f7-bb96ac5aae72ef0d12d1c0f6d2ba490838");
        Serenity.setSessionVariable("response").to(responseAllCollection);
    }

    @Then("Get Name of All Collection")
    public void getNameOfAllCollection() {
        ArrayList<String> collectionList = new ArrayList<>();
        Response response = Serenity.sessionVariableCalled("response");
        JsonPath jsonPath = response.jsonPath();
       int size = jsonPath.get("collections.size()");
        for (int i = 0; i < size; i++) {
           collectionList.add(jsonPath.get(String.format("collections[%d].name",i)));
            System.out.println(collectionList.get(i));
        }
    }
}

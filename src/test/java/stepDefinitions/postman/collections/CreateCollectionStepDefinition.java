package stepDefinitions.postman.collections;

import bodyPojo.postman.collection.*;
import common.postmanAPI.collections.CollectionsAPI;
import common.ultility.CommonSupport;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import net.serenitybdd.core.Serenity;

import java.util.Arrays;
import java.util.List;

public class CreateCollectionStepDefinition {

    @Given("Create random collection")
    public void createRandomCollection() {
        Info info = new Info();
        info.setName("collection create test "+ CommonSupport.getRandomNum());
        info.setDescription("This is just a sample collection.");
        info.setSchema("https://schema.getpostman.com/json/collection/v2.1.0/collection.json");
        Item itemcon1 = new Item();
        Request request = new Request();
        Header header = new Header();
        header.setKey("Content-Type");
        header.setValue("application/json");
        List<Header> addHeader = Arrays.asList(header);
        Body body = new Body();
        body.setMode("raw");
        body.setRaw("{\"data\": \"123\"}");
        request.setUrl("https://postman-echo.com/post");
        request.setMethod("POST");
        request.setHeader(addHeader);
        request.setBody(body);
        request.setDescription("This is a sample POST Request");
        itemcon1.setName("Sample POST Request");
        itemcon1.setRequest(request);
        Item itemcon2 = new Item();
        itemcon2.setName("Sample GET Request");
        Request request2 = new Request();
        List<Header> addHeader2 = Arrays.asList();
        request2.setUrl("https://postman-echo/get");
        request2.setMethod("GET");
        request2.setDescription("This is a sample GET Request");
        request2.setHeader(addHeader2);
        List<Item> addItems = Arrays.asList(itemcon1);
        Item itemCha = new Item();
        itemCha.setItem(addItems);
        itemCha.setName("this is folder");
        Item itemMe = new Item();
        itemMe.setName("Sample GET Request");
        itemMe.setRequest(request2);
        List<Item> addItemsOng = Arrays.asList(itemCha,itemMe);
        Collection collection = new Collection();
        collection.setInfo(info);
        collection.setItem(addItemsOng);
        ChuaCollection chuaCollection = new ChuaCollection();
        chuaCollection.setCollection(collection);
       Response response = CollectionsAPI.createCollection(CommonSupport.TOKEN_API_POSTMAN, chuaCollection);
        Serenity.setSessionVariable("response").to(response);
    }

    @Then("Verify collection created")
    public void verifyCollectionCreated() {
       Response response = Serenity.sessionVariableCalled("response");
       response.prettyPrint();
    }

    @When("Delete this collection")
    public void deleteThisCollection() {
        Response response = Serenity.sessionVariableCalled("response");
       JsonPath jsonPath = response.jsonPath();
      String uid = jsonPath.get("collection.uid");
        System.out.println(uid);
      Response responseDelete =  CollectionsAPI.deleteCollection(CommonSupport.TOKEN_API_POSTMAN,uid);
      responseDelete.prettyPrint();
    }
}

package stepDefinitions.postman.mock;

import bodyPojo.postman.mock.Mock;
import bodyPojo.postman.mock.OutMock;
import common.postmanAPI.mocks.MockAPI;
import common.ultility.CommonSupport;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import net.serenitybdd.core.Serenity;

public class MockStepDefinitions {


    @Given("run api create mock with Name {string}")
    public void runApiCreateMockWithName(String name) {
        Mock mock = new Mock();
        mock.setCollection(CommonSupport.COLLECTION_ID_MOCK);
        mock.setEnvironment(CommonSupport.ENVIRONMENT_ID);
        mock.setDescription("check des");
        mock.setPrivateCheck(false);
        mock.setVersionTag("tag");
        mock.setName(name);
        OutMock outMock = new OutMock(mock);
        Response response = MockAPI.createMockServer(CommonSupport.TOKEN_API_POSTMAN,outMock);
        Serenity.setSessionVariable("response").to(response);
    }

    @Then("verify mock created")
    public void verifyMockCreated() {
        Response response = Serenity.sessionVariableCalled("response");
       JsonPath jsonPath = response.jsonPath();
      String uidMock = jsonPath.get("mock.uid");
      Serenity.setSessionVariable("uidmock").to(uidMock);
    }

    @When("update mock of {string}")
    public void updateMockOf(String name) {
        Mock mock = new Mock();
        mock.setName(name + " update");
        mock.setDescription("cap nhap des");
        mock.setPrivateCheck(false);
        mock.setVersionTag("test");
        OutMock outMock = new OutMock(mock);
        mock.setEnvironment(CommonSupport.ENVIRONMENT_ID);
        String uidMock = Serenity.sessionVariableCalled("uidmock");
       Response response = MockAPI.putMock(CommonSupport.TOKEN_API_POSTMAN,uidMock,outMock);
       Serenity.setSessionVariable("responseUpdateMock").to(response);
    }

    @Then("Verify mock update of {string}")
    public void verifyMockUpdateOf(String name) {
        Response response = Serenity.sessionVariableCalled("responseUpdateMock");
        response.prettyPrint();
    }

    @Given("run Api get all mock")
    public void runApiGetAllMock() {
      Response response =  MockAPI.getAllMock(CommonSupport.TOKEN_API_POSTMAN);
      Serenity.setSessionVariable("responseAllMock").to(response);
    }

    @Then("verify all mock list")
    public void verifyAllMockList() {
        Response response = Serenity.sessionVariableCalled("responseAllMock");
        JsonPath jsonPath = response.jsonPath();
        jsonPath.prettyPrint();
    }

    @Given("get single id {string} of mock")
    public void getSingleIdOfMock(String arg0) {
       Response response = MockAPI.getSingleMock(CommonSupport.TOKEN_API_POSTMAN,arg0);
       JsonPath jsonPath = response.jsonPath();
       Serenity.setSessionVariable("responseSingleMock").to(jsonPath);
    }

    @Then("verify this mock with id")
    public void verifyThisMockWithId() {
        JsonPath jsonPath = Serenity.sessionVariableCalled("responseSingleMock");
        jsonPath.prettyPrint();
    }
}

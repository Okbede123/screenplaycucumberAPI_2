package stepDefinitions.gorest;

import bodyPojo.gorestuser.UserResponse;
import com.google.gson.Gson;
import common.gorestAPI.callGetListUserAPI.GetListUserAPI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import org.junit.Assert;
import requestURL.gorest.BaseURL;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class GetListDefinitions {

    List<UserResponse> listUsers;
    @When("Gọi Api Get Líst User")
    public void calApiListUser() {
        String token = Serenity.sessionVariableCalled("token");
        Response response = GetListUserAPI.getListUSer(BaseURL.CREATE_USER,token);
       String check = response.then().extract().response().asString();
        //khai báo kiểu này để handle vấn đề mảng ko có tên đại diện
        //cách 2
      List<UserResponse> userResponseList = Arrays.asList(response.then().extract().response().as(UserResponse[].class));
       //khai báo kiểu này để handle vấn đề mảng ko có tên đại diện
        //cách 1
        Gson gson = new Gson();
        listUsers = Arrays.asList(gson.fromJson(check, UserResponse[].class));
    }

    @Then("Verify List Ket qua")
    public void verifyListKetQua() {
        String num = "5";
        Actor actor = new Actor("test");
        for (int i = 0; i < listUsers.size(); i++) {
            if(listUsers.get(i).getEmail().contains(Serenity.sessionVariableCalled("email"))){
                Assert.assertTrue(listUsers.get(i).getEmail().contains(Serenity.sessionVariableCalled("email")));
            }
        }
    }

}

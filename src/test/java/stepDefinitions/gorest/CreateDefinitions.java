package stepDefinitions.gorest;

import bodyPojo.gorestuser.User;
import bodyPojo.gorestuser.UserResponse;
import common.gorestAPI.requestCreateUserApi.CreateUserAPI;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import net.serenitybdd.core.Serenity;
import org.junit.Assert;
import requestURL.gorest.BaseURL;
import stepDefinitions.Hooks;

import java.util.Map;
import java.util.Random;

import static io.restassured.RestAssured.given;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class CreateDefinitions {

    String email;


    @DataTableType
    public User CreateUser(Map<String, String> row) {

        return new User(
                row.get("name"),
                row.get("gender"),
                row.get("email"),
                row.get("status")
        );
    }

//    @DataTableType
//    public UserResponse ResponseUser(Map<String, String> row) {
//
//        return new UserResponse(
//                row.get("id"),
//                row.get("name"),
//                row.get("gender"),
//                row.get("email"),
//                row.get("status")
//        );
//    }

    @Given("Gọi Api tạo user")
    public void callApiCreateUser() {
        //step nay ko can thiet
        Hooks.set_the_stage();

    }

    @When("Bắt đầu tạo user với các thông tin là")
    public void CreateUserWithInformation(User user) {
        user.setEmail("bddfae@gmail.com" + randomNum());
        email = user.getEmail();
        Serenity.setSessionVariable("email").to(email);
        String token = "170f3e0de688856993ba353e34909f818cccfd5cc98898fee8100cdc6c2575ca";
        Serenity.setSessionVariable("token").to(token);
        Response response = CreateUserAPI.CreateUserAPI(BaseURL.CREATE_USER,token,user);
        Serenity.setSessionVariable("response").to(response);
    }

    @Then("Verify kết quả chuẩn đã được tạo")
    public void verifyResponse(UserResponse userResponse) {
        userResponse.setEmail(email);
        Response response = Serenity.sessionVariableCalled("response");
        response.prettyPrint();
      JsonPath jsonPath =  response.then().assertThat().statusCode(201).extract().jsonPath();
      String email = jsonPath.get("email");
      Assert.assertTrue(email.equals(userResponse.getEmail()));
    }

    public static int randomNum(){
        Random random = new Random();
        int rand = random.nextInt(999);
        return rand;
    }

}

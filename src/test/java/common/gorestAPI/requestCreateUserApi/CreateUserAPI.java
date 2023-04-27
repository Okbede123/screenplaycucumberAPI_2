package common.gorestAPI.requestCreateUserApi;

import bodyPojo.gorestuser.User;
import common.requestSpecification.gorestAPI.CreateUserSpecification;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class CreateUserAPI {

    public static Response CreateUserAPI(String pathUrl, String token, User user){
        return given().spec(CreateUserSpecification.CreateUser(token)).log().all().body(user)
                .post(pathUrl).then().extract().response();
    }
}

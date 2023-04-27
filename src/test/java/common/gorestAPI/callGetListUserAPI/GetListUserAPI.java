package common.gorestAPI.callGetListUserAPI;

import common.requestSpecification.gorestAPI.CreateUserSpecification;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class GetListUserAPI {

    public static Response getListUSer(String pathUrl, String token){
        return given().spec(CreateUserSpecification.CreateUser(token)).header("Content-Type","application/json").contentType(ContentType.JSON).log().all()
                .get(pathUrl).then().extract().response();
    }
}

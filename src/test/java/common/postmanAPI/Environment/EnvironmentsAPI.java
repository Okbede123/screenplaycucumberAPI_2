package common.postmanAPI.Environment;

import common.requestSpecification.postmanAPI.CommonSpecification;
import io.restassured.response.Response;
import requestURL.postman.BaseURL;

import static io.restassured.RestAssured.given;

public class EnvironmentsAPI {

    public static Response getAllEnvironments(String token){
        return given().spec(CommonSpecification.CommonAPI(token)).log().all()
                .get(BaseURL.ENVIRONMENTS).then().extract().response();
    }

    public static Response getSingleEnvironments(String token,String idEnvironment){
        return given().spec(CommonSpecification.CommonAPI(token)).log().all()
                .get(BaseURL.ENVIRONMENTS+ "/"+ idEnvironment).then().extract().response();
    }
}

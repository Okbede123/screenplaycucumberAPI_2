package common.postmanAPI.mocks;

import common.requestSpecification.postmanAPI.CommonSpecification;
import io.restassured.response.Response;
import requestURL.postman.BaseURL;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

public class MockAPI {

    public static Response createMockServer(String token, Object body){
        return given().log().all().spec(CommonSpecification.CommonAPI(token)).body(body)
                .post(BaseURL.MOCKS).then().extract().response();
    }

    public static Response getAllMock(String token){
        return given().log().all().spec(CommonSpecification.CommonAPI(token)).get(BaseURL.MOCKS)
                .then().extract().response();
    }

    public static Response getSingleMock(String token,String mockId){
        return given().log().all().spec(CommonSpecification.CommonAPI(token))
                .get(BaseURL.MOCKS+"/"+mockId).then().extract().response();
    }

    public static Response putMock(String token,String mockId,Object body){
        return given().log().all().spec(CommonSpecification.CommonAPI(token)).body(body)
                .put(BaseURL.MOCKS+"/"+mockId).then().extract().response();
    }

    public static Response deleteMock(String token,String mockId){
        return given().log().all().spec(CommonSpecification.CommonAPI(token))
                .delete(BaseURL.MOCKS+"/"+mockId).then().extract().response();
    }
}

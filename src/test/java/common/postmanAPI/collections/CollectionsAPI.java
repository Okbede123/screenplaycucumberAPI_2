package common.postmanAPI.collections;


import bodyPojo.postman.collection.ChuaCollection;
import common.requestSpecification.postmanAPI.CommonSpecification;
import io.restassured.response.Response;
import requestURL.postman.BaseURL;

import static io.restassured.RestAssured.given;

public class CollectionsAPI {

    public static Response createCollection(String token, ChuaCollection chuaCollection){
        return given().spec(CommonSpecification.CommonAPI(token)).log().all()
                .body(chuaCollection).post(BaseURL.PATH_COLLECTIONS).then().assertThat().statusCode(200)
                .extract().response();
    }

    public static Response deleteCollection(String token,String uid){
        return given().spec(CommonSpecification.CommonAPI(token)).pathParam("apikey",uid).log().all()
                .delete(BaseURL.PATH_COLLECTIONS+"/{apikey}").then().assertThat().statusCode(200)
                .extract().response();
    }

    public static Response getListAllCollections(String token){
        return given().spec(CommonSpecification.CommonAPI(token)).log().all()
                .get(BaseURL.PATH_COLLECTIONS).then().extract().response();
    }
}

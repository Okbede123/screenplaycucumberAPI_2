package common.postmanAPI.fork;

import common.requestSpecification.postmanAPI.CommonSpecification;
import io.restassured.response.Response;
import org.json.JSONObject;
import requestURL.postman.BaseURL;

import static io.restassured.RestAssured.given;

public class ForkAPI {

    //case này fail do postman, hoặc chưa biết dùng
    public static Response createCollection(String token, JSONObject object, String collectionId, String workspaceId){
        return given().spec(CommonSpecification.CommonAPI(token)).pathParam("collectionId",collectionId).pathParam("workspace_id",workspaceId).log().all()
                .body(object.toString()).post(BaseURL.PATH_COLLECTIONS_FORK+"{collectionId}?workspace={workspace_id}").then().assertThat().statusCode(200)
                .extract().response();
    }

}

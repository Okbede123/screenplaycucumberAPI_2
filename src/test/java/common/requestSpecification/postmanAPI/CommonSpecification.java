package common.requestSpecification.postmanAPI;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import requestURL.postman.BaseURL;

public class CommonSpecification {

    public static RequestSpecification CommonAPI(String token){
        return new RequestSpecBuilder().setContentType(ContentType.JSON)
                .setBaseUri(BaseURL.BASE_URL_POSTMAN)
                .addHeader("X-API-Key",token)
                .build();
    }
}

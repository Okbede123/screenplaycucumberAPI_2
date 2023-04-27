package common.requestSpecification.gorestAPI;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import requestURL.gorest.BaseURL;



public class CreateUserSpecification {

    public static RequestSpecification CreateUser(String token){
        return new RequestSpecBuilder().setContentType(ContentType.JSON)
                .setBaseUri(BaseURL.BASE_URL)
                .addHeader("Authorization","Bearer "+token)
                .build();
    }

}

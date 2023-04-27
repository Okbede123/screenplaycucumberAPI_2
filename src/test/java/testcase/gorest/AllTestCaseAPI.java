package testcase.gorest;

import io.restassured.RestAssured;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class AllTestCaseAPI {

    @Test
    public void TC_01(){
        RestAssured.baseURI = "https://api.apilayer.com";
        given().log().all().header("apikey","i00vxovfF5Q2CB4faasQUPmY8hNm2tJj")
                .get("/number_verification/countries").then().extract()
                .response().prettyPrint();
    }
}

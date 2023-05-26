package api.steps;

import api.models.*;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ReqresSteps {

    public static Tariff getTariffsSuccess(){
        return given()
                .spec(SpecHelper.getRequestSpec())
                .when()
                .get("getTariffs")
                .then()
                .spec(SpecHelper.getResponseSpec(200))
                .extract().body().jsonPath().getObject(".", Tariff.class);
    }

    public static Response authUserSuccess(Authentication auth){
        return given()
                .spec(SpecHelper.getRequestSpec())
                .when()
                .body(auth)
                .post("auth/authenticate")
                .then()
                .spec(SpecHelper.getResponseSpec(200))
                .extract()
                .response();
    }



}

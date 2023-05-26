package loan_service;

import api.models.Authentication;
import api.models.Tariff;
import api.steps.ReqresSteps;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class LoanServiceTest {
    private final static String URL = "http://localhost:8080/loan-service/";
    private final ReqresSteps reqresSteps = new ReqresSteps();


    @Test
    public void successGetTariffs(){
        List<Tariff> tariffs = given()
                .when()
                .contentType(ContentType.JSON)
                .get( URL + "getTariffs")
                .then()
                .log().all()
                .extract().body().jsonPath().getList("tariffs", Tariff.class);
    }

    @Test
    public void successGetToken() {
        Authentication auth = new Authentication("ivanov@mail.ru", "1234");
        Response response = reqresSteps.authUserSuccess(auth);
    }

}

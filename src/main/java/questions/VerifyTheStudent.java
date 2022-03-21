package questions;

import io.restassured.RestAssured;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.HashMap;

public class VerifyTheStudent implements Question<Boolean> {

    private final String firstName;

    public VerifyTheStudent(String firstName) {
        this.firstName = firstName;
    }


    @Override
    public Boolean answeredBy(Actor actor) {

        boolean answer;
        HashMap<String, Object> value = RestAssured.given()
                .when()
                .baseUri("http://localhost:8080/student")
                .get("/list")
                .then()
                .log()
                .all()
                .statusCode(200)
                .extract()
                .path("findAll{it.firstName=='" + firstName + "'}.get(0)");

        if (value.isEmpty()) {
            answer = false;
        } else {
            answer = true;
        }
        return answer;
    }

    public static VerifyTheStudent wasCreate(String firstName) {
        return new VerifyTheStudent(firstName);
    }
}

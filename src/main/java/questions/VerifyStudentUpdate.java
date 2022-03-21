package questions;

import io.restassured.RestAssured;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.HashMap;

public class VerifyStudentUpdate implements Question<Boolean> {

    private final String firstName;
    private final String email;

    public VerifyStudentUpdate(String firstName, String email) {
        this.firstName = firstName;
        this.email = email;
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        boolean answer = false;
        HashMap<String, Object> value = RestAssured.given()
                .when()
                .baseUri("http://localhost:8080/student")
                .get("/list")
                .then()
                .log()
                .all()
                .statusCode(200)
                .extract()
                .path("findAll{it.email=='" + email + "'}.get(0)");

        if(value.containsValue(firstName)){
            answer = true;
        }

        return answer;
    }

    public static VerifyStudentUpdate wasSuccessfully(String firstName, String email){
        return new VerifyStudentUpdate(firstName, email);
    }
}

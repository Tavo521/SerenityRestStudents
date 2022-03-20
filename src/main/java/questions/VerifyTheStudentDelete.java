package questions;

import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class VerifyTheStudentDelete implements Question<ValidatableResponse> {

    private final int studentId;

    public VerifyTheStudentDelete(int studentId) {
        this.studentId = studentId;
    }

    @Override
    public ValidatableResponse answeredBy(Actor actor) {

        return SerenityRest
                .rest()
                .given()
                .when()
                .baseUri("http://localhost:8080/student")
                .get("/" + studentId)
                .then()
                .log()
                .all()
                .statusCode(404);

    }

    public static VerifyTheStudentDelete wasSuccessfully(int studentId) {
        return new VerifyTheStudentDelete(studentId);
    }
}

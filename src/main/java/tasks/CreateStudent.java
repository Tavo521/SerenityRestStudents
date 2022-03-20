package tasks;

import io.restassured.http.ContentType;
import models.Student;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import utils.TestBase;

public class CreateStudent extends TestBase implements Task {

    private final Student student;

    public CreateStudent(Student student) {
        this.student = student;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        SerenityRest.given()
                .contentType(ContentType.JSON)
                .when()
                .body(student)
                .baseUri("http://localhost:8080/student")
                .post()
                .then()
                .log()
                .all()
                .statusCode(201);
    }

    public static CreateStudent withStudentInformation(Student studentInformation){

        return Tasks.instrumented(CreateStudent.class, studentInformation);
    }
}

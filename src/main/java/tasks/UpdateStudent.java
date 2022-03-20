package tasks;

import io.restassured.http.ContentType;
import models.Student;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class UpdateStudent implements Task {

    private final Student student;

    public UpdateStudent(Student student) {
        this.student = student;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        SerenityRest.rest().given()
                .contentType(ContentType.JSON)
                .when()
                .body(student)
                .baseUri("http://localhost:8080/student")
                .put("/" + student.getId())
                .then()
                .log()
                .all();

    }

    public static UpdateStudent withTheInformation(Student studentInformation){
        return Tasks.instrumented(UpdateStudent.class, studentInformation);

    }

}

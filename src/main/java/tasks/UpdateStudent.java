package tasks;

import io.restassured.http.ContentType;
import models.Student;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class UpdateStudent implements Task {

    private final Student student;
    private final int studentId;

    public UpdateStudent(Student student, int studentId) {
        this.student = student;
        this.studentId = studentId;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        SerenityRest.rest().given()
                .contentType(ContentType.JSON)
                .when()
                .body(student)
                .baseUri("http://localhost:8080/student")
                .put("/" + studentId)
                .then()
                .log()
                .all();

    }

    public static UpdateStudent withTheInformation(Student studentInformation, int studentId){
        return Tasks.instrumented(UpdateStudent.class, studentInformation, studentId);

    }

}

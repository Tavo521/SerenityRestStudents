package tasks;

import io.restassured.RestAssured;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class DeleteStudent implements Task {

    private final int studentId;

    public DeleteStudent(int studentId) {
        this.studentId = studentId;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        RestAssured
                .given()
                .when()
                .baseUri("http://localhost:8080/student")
                .delete("/" + studentId);

    }

    public static DeleteStudent withId(int studentId){
        return Tasks.instrumented(DeleteStudent.class, studentId);
    }
}

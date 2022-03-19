package tasks;

import models.Student;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import utils.TestBase;

import java.util.ArrayList;

public class CreateStudent extends TestBase implements Task {

    private static String firstName;
    private static String lastName;
    private static String programme;
    private static String email;
    private static int studentId;
    ArrayList<String> courses = new ArrayList<String>();

    @Override
    public <T extends Actor> void performAs(T actor) {

        Student student = new Student();


    }

    public static CreateStudent createNewStudent(){

        return null;
    }
}

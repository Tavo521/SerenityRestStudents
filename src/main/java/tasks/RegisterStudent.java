package tasks;

import models.Student;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import java.util.ArrayList;

public class RegisterStudent implements Task {

    private final String firstName;
    private final String lastName;
    private final String email;
    private final String programme;
    private final Integer studentId;

    public RegisterStudent(String firstName, String lastName, String email, String programme, Integer studentId){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.programme = programme;
        this.studentId = studentId;

    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        ArrayList<String> courses = new ArrayList<>();
        courses.add("Java");
        courses.add("JavaScript");

        Student student = new Student();
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setEmail(email);
        student.setProgramme(programme);
        student.setCourses(courses);
        if(!studentId.equals(null)){
            student.setId(studentId);
        }
        actor.remember("Student", student);

    }

    public static RegisterStudent withTheInformation(String firstName, String lastName, String email, String programme){

        return Tasks.instrumented(RegisterStudent.class, firstName, lastName, email, programme);

    }

    public static RegisterStudent withTheInformation(String firstName, String lastName, String email, String programme,
                                                     Integer studentId){

        return Tasks.instrumented(RegisterStudent.class, firstName, lastName, email, programme, studentId);

    }

}

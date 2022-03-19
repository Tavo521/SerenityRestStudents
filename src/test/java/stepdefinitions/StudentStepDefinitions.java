package stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.Student;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import tasks.CreateStudent;
import tasks.RegisterStudent;

public class StudentStepDefinitions {

    @Before
    public void prepareStage() {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("Student");
    }

    @Given("I have a new student with the information (.*) (.*) (.*) (.*)")
    public void iHaveANewStudentWithTheInformation(String firstName, String lastName, String email, String programme) {

        OnStage.theActorInTheSpotlight().attemptsTo(RegisterStudent.withTheInformation(firstName, lastName, email, programme));

    }

    @When("I create a new student with the information")
    public void iCreateANewStudentWithTheInformation() {

        Student student = new Student();
        OnStage.theActorInTheSpotlight().attemptsTo(CreateStudent.withStudentInformation(student));
    }

    @Then("I verify that it student was create successfully")
    public void iVerifyThatItStudentWasCreateSuccessfully() {

    }

}

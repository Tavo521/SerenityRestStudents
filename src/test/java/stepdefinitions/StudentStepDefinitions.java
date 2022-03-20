package stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import questions.VerifyTheStudent;
import tasks.CreateStudent;
import tasks.RegisterStudent;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class StudentStepDefinitions {

    @Before
    public void prepareStage() {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("Student");
    }

    @Given("^I have a new student to register with the information (.*) (.*) (.*) (.*)$")
    public void iHaveANewStudentToRegisterWithTheInformation(String firstName, String lastName, String email, String programme) {

        theActorInTheSpotlight().attemptsTo(RegisterStudent.withTheInformation(firstName, lastName, email, programme));
    }

    @When("I create a new student in the list with the information")
    public void iCreateANewStudentInTheListWithTheInformation() {

        theActorInTheSpotlight().attemptsTo(CreateStudent.withStudentInformation(OnStage.theActorInTheSpotlight().recall("Student")));
    }

    @Then("^I verify that it student (.*) was create successfully$")
    public void iVerifyThatItStudentWasCreateSuccessfully(String firstName) {

        theActorInTheSpotlight().should(seeThat(VerifyTheStudent.wasCreate(firstName)));

    }

}

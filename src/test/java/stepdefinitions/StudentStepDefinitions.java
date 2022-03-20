package stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import questions.VerifyStudentUpdate;
import questions.VerifyTheStudent;
import tasks.CreateStudent;
import tasks.RegisterStudent;
import tasks.UpdateStudent;

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

    @Given("^I have a student that needs to update your information (.*) (.*) (.*) (.*) (.*)$")
    public void iHaveAStudentThatNeedsToUpdateYourInformation(String firstName, String lastName, String email,
                                                              String programme, Integer studentId) {

        theActorInTheSpotlight().attemptsTo(RegisterStudent.withTheInformation(firstName, lastName, email, programme, studentId));

    }

    @When("I update the student information in the list")
    public void iUpdateTheStudentInformationInTheList() {

        theActorInTheSpotlight().attemptsTo(UpdateStudent.withTheInformation(theActorInTheSpotlight().recall("Student")));

    }
    @Then("^I Verify that it student (.*) with email (.*) was update$")
    public void iVerifyThatItStudentWithIdWasUpdate(String firstName, String email) {

        theActorInTheSpotlight().should(seeThat(VerifyStudentUpdate.wasSuccessfully(firstName, email)));

    }

}

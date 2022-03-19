package stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

public class StudentStepDefinitions {

    @Before
    public void prepareStage() {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("Student");
    }

    @When("I create a new student with the information (.*) (.*) (.*) (.*) (.*)")
    public void iCreateANewStudentWithTheInformation(String firstName, String lastName, String email, String programme,
                                                     String courses) {

        OnStage.theActorInTheSpotlight().attemptsTo();

    }
    @Then("I verify that it student was create successfully")
    public void iVerifyThatItStudentWasCreateSuccessfully() {

    }





}

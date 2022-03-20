package runners;

import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/student.feature",
        glue = {"stepdefinitions"},
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        tags = "@tag")

public class Student {

}

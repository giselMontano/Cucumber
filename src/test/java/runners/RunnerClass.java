package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        //ONLY ONE RUNNER CLASS CAN HANDLE THE ENTIRE FRAMEWORK

        //"features" is a keyword that we use to provide the path of all the features file.
        features = "src/test/resources/features/Login.feature",//this path is taken from hierarchy from "scr" and so on till the desire folder
                                               //Test.feature->you can always run the other test by changing the test name->AnotherStepsPage execute this
                                               //EmployeeSearch.feature->you need ti change this to run and get the steps definition for java
        //glue is where we find implementations for gherkin steps
        //we provide the path of package where we defined all the steps INSIDE KEYWORD->GLUE
        glue = "steps",//YOU MUST MENTION THE NAME OF THE PACKAGE-NOT THE CLASS, IN ORDER FOR CUCUMBER TO FIND THE DEFINITION TO BE RUN
        //if we set dry run to true, it stops the actual execution and quickly
        //scan all the steps whether they are implemented or not
        //to execute the script, set dry run to false
        dryRun = false,
        //it cleans your console output for cucumber test if it has
        //irrelevant or unreadable character in it
        //recommended is, set it to true always
        monochrome = true,
        tags = "@regression"
)
public class RunnerClass {

}

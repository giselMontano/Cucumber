package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import utils.CommonMethods;

public class  AnotherStepsPage extends CommonMethods {
                     //FIRST THING FIRST EXTEND COMMON METHODS
    //this is the code for Test.feature test from--> resources/features/Test.feature

    //WE DO NOT NEED TO RUN "GIVEN" AGAIN IT SINCE IS ALREADY DECLARED IN LOGIN CLASS. ONLY ONE TIME STEP DEFINITION

    //@Given("user is navigated to HRMS application")
    //public void user_is_navigated_to_hrms_application() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
            /*WebDriverManager.chromedriver().setup();//THIS IS HOW INITIALIZED THE BROWSER WITH WebDriverManager
            driver = new ChromeDriver();
            driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/leave/viewLeaveList");
            Thread.sleep(2000);*/
     //   openBrowserAndLaunchApplication();//this is the only thing you need since you have everything in CommunMethods->utils package}


    //to get this part first we execute in RunnerClass with the name of the file in file path and it will give us this part to be implemented in java
    //after implementing the highlighting in the test script will disappear
    @When("user enters invalid username and password")
    public void user_enters_invalid_username_and_password() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}

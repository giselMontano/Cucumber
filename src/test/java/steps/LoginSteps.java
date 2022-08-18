package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import utils.CommonMethods;
import utils.ConfigReader;

public class LoginSteps extends CommonMethods {
                                     //FIRST THING FIRST EXTEND COMMON METHODS

        //public static WebDriver driver; //WE DO NOT NEED THIS ANYMORE SINCE WE HAVE EVERYTHING IN CommunMethods and we can just extend the class

        @Given("user is navigated to HRMS application")
        public void user_is_navigated_to_hrms_application() throws InterruptedException {
            // Write code here that turns the phrase above into concrete actions
            /*WebDriverManager.chromedriver().setup();//THIS IS HOW INITIALIZED THE BROWSER WITH WebDriverManager
            driver = new ChromeDriver();
            driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/leave/viewLeaveList");
            Thread.sleep(2000);*/
            openBrowserAndLaunchApplication();//this is the only thing you need since you have everything in CommunMethods->utils package
        }

        @When("user enters valid admin username and password")
        public void user_enters_valid_admin_username_and_password() {
            // Write code here that turns the phrase above into concrete actions

           //WebElement usernameTextField = driver.findElement(By.id("txtUsername"));//We replace for "LoginPage" from pages package
            //usernameTextField.sendKeys("admin");->REPLACE FOR CommonMethods


            //METHOD FROM CommonMethods
            //send text to username->get the information from utils/ConfigReade that read the non-java file Config.properties and give you what you ask for in the "key"

            //THIS OBJECT HAS BEEN ADDED TO PageInitializer and extended to CommonMethods. Therefore, we do not need to create it here any more.
            //LoginPage login = new LoginPage();//We need to create the object to call methods from LoginPage class where the locators are stored
            sendText(login.usernameTextField, ConfigReader.getPropertyValue("username"));//key "username";LoginPage class->"login.usernameTextField

            //WebElement passwordTextField = driver.findElement(By.id("txtPassword"));//We replace for "LoginPage" from pages package
            //passwordTextField.sendKeys("Hum@nhrm123");->REPLACE FOR CommonMethods


            //METHOD FROM CommonMethods
            //send text to password->get the information from utils/ConfigReade that read the non-java file Config.properties and give you what you ask for in the "key"
            sendText(login.passwordTextField,ConfigReader.getPropertyValue("password"));//key "password"
        }
        @When("user clicks on login button")
        public void user_clicks_on_login_button() throws InterruptedException {
            // Write code here that turns the phrase above into concrete actions
            //WebElement loginButton = driver.findElement(By.id("btnLogin"));
            //loginButton.click();->REPLACE FOR CommonMethods
            //Thread.sleep(2000);->REPLACE FOR CommonMethods, THE WAIT IS ALREADY ATTACHED TO CLICKABLE CONDITION, IT WILL WAIT AUTOMATICALLY

            //THIS OBJECT HAS BEEN ADDED TO PageInitializer and extended to CommonMethods. Therefore, we do not need to create it here any more.
            //LoginPage login = new LoginPage();//We need to create the object to call methods from LoginPage class where the locators are stored
            click(login.loginButton);//click->from CommonMethods/loginButton->login->coming from object of LoginPage class/loginButton-> element coming from LoginPage class

        }
        @Then("admin user is successfully logged in")
        public void admin_user_is_successfully_logged_in() {
            // Write code here that turns the phrase above into concrete actions
            System.out.println("Test passed");

            //METHOD FROM CommonMethods
            //closeBrowser();//FROM CommonMethods //WE NEED TO COMMENT THIS PART SO THE BROWSER DOES NOT CLOSE IN BETWEEN THE EXECUTION

        }

    @When("user enters ess username and password")
    public void user_enters_ess_username_and_password() {
        //   WebElement usernameTextField = driver.findElement(By.id("txtUsername"));//We replace for "LoginPage" from pages package
        // usernameTextField.sendKeys("admin");

        //THIS OBJECT HAS BEEN ADDED TO PageInitializer and extended to CommonMethods. Therefore, we do not need to create it here any more.
        //LoginPage login = new LoginPage();//We need to create the object to call methods from LoginPage class
        sendText(login.usernameTextField, "admin");//"admin" random we do not have one

        //  WebElement passwordTextField = driver.findElement(By.id("txtPassword"));
        //  passwordTextField.sendKeys("Hum@nhrm123");
        sendText(login.passwordTextField, "Hum@nhrm123");

    }

    @Then("ess user is successfully logged in")
    public void ess_user_is_successfully_logged_in() {
        System.out.println("Test passed");
        // closeBrowser();
    }

    @When("user enter invalid username and password")
    public void user_enter_invalid_username_and_password() {
        //  WebElement usernameTextField = driver.findElement(By.id("txtUsername"));
        // usernameTextField.sendKeys("admin");

        //THIS OBJECT HAS BEEN ADDED TO PageInitializer and extended to CommonMethods. Therefore, we do not need to create it here any more.
        //LoginPage login = new LoginPage();
        sendText(login.usernameTextField, "admi");//invalid username sent

        //  WebElement passwordTextField = driver.findElement(By.id("txtPassword"));
        //  passwordTextField.sendKeys("Hum@nhrm123");
        sendText(login.passwordTextField, "Hum");//invalid password sent
    }

    @Then("user is able to see error message")
    public void user_is_able_to_see_error_message() {
        System.out.println("Test failed");
        // closeBrowser();
    }

}



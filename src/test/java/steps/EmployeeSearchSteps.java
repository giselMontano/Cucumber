package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.CommonMethods;

public class EmployeeSearchSteps extends CommonMethods {
    //FIRST THING FIRST EXTEND COMMON METHODS
//THIS IS COMING AFTER RUNNING THE TEST SCRIPT EmployeeSearch.feature IN RUNNERS CLASS
//AND GETTING THE STEPS FROM CONSOLE, WE JUST NEED TO PASTE THEM HERE AND FIX THEM.
    @When("user clicks on PIM option")
    public void user_clicks_on_pim_option() {

        //THIS OBJECT HAS BEEN ADDED TO PageInitializer and extended to CommonMethods. Therefore, we do not need to create it here any more.
        //   DashboardPage dash = new DashboardPage();//IN ORDER TO ACCESS TO DashboardPage class we need to create the object
        click(dash.pimOption);
        //click-> from common methods/dash-> from the object from "PageInitializer class" that extends "CommonMethods"/pimOption->element available in "DashboardPage class"
    }

    @When("user clicks on employee list option")
    public void user_clicks_on_employee_list_option() {

        //THIS OBJECT HAS BEEN ADDED TO PageInitializer and extended to CommonMethods. Therefore, we do not need to create it here any more.
        //    DashboardPage dash = new DashboardPage();
        click(dash.employeeListOption);
        //click-> from common methods/dash-> from the object from "PageInitializer class" that extends CommonMethods/employeeListOption->element available in "DashboardPage class"
    }

    @When("user enters valid employee id")
    public void user_enters_valid_employee_id() {

        //THIS OBJECT HAS BEEN ADDED TO PageInitializer and extended to CommonMethods. Therefore, we do not need to create it here any more.
        //  EmployeeInformationPage emp = new EmployeeInformationPage();//IN ORDER TO ACCESS TO "EmployeeInformationPage class" we need to create the object
        //this line will search the employee whose locator is available on empl info page
        //send text method, we are calling from common methods
        sendText(emp.idEmployeeSearch, "30249233");
        //sendText->from common methods/emp->from the object from "PageInitializer class" that extends "CommonMethods"/idEmployeeSearch->element available in "EmployeeInformationPage class"
    }

    @When("user clicks on search button")
    public void user_clicks_on_search_button() {

        //THIS OBJECT HAS BEEN ADDED TO PageInitializer and extended to CommonMethods. Therefore, we do not need to create it here any more.
        //   EmployeeInformationPage emp = new EmployeeInformationPage();//IN ORDER TO ACCESS TO "EmployeeInformationPage class" we need to create the object
        //this line will click on search button whose locator is available on empl infor page
        click(emp.searchButton);
        // click-> from common methods/emp-> from the object from "PageInitializer class" that extends "CommonMethods"/searchButtonn->element available in "EmployeeInformationPage class"

    }

    @Then("user is able to see the employee")
    public void user_is_able_to_see_the_employee() {
        //homework - verify the employee is present
        System.out.println("Employee is available");
    }
}

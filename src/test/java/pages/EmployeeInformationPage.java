package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class EmployeeInformationPage extends CommonMethods {
                          //FIRST THING FIRST EXTEND COMMON METHODS
    //THESE ARE THE LOCATORS FROM THE SCREEN TO SEARCH FOR A EMPLOYEE AND THE LOCATORS FOR resources/features/EmployeeSearch.feature

    @FindBy(id="empsearch_id")//ID
    public WebElement idEmployeeSearch;

    @FindBy(id="empsearch_employee_name_empName")//NAME
    public WebElement nameEmployeeSearch;

    @FindBy(id="searchBtn")//search button
    public WebElement searchButton;

    public EmployeeInformationPage(){
        PageFactory.initElements(driver, this);
    }}
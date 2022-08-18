package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class LoginPage extends CommonMethods {
    //FIRST THING FIRST EXTEND COMMON METHODS
//OBJECT REPOSITORY->IF DEVELOPERS CHANGE SOMETHING IN THE LOCATORS
//AND WE ARE USING THESE IN MANY TEST CASES WE JUST NEED TO MAKE THE ADJUSTMENT IN HERE

    @FindBy(id="txtUsername")
    public WebElement usernameTextField;

    @FindBy(id="txtPassword")
    public WebElement passwordTextField;

    @FindBy(id="btnLogin")
    public WebElement loginButton;


    //IMPLEMENT A CONSTRUCTOR->CONSTRUCTOR IS A BLOCK OF CODE, HAVE SAME NAME AS THE CLASS NAME, LOOKS LIKE A METHOD.
    // ACCESS MODIFIER "PUBLIC" TO BE AVAILABLE THROWOUT MY PROJECT
    public LoginPage(){
        PageFactory.initElements(driver, this);//DRIVER IS COMING FROM CommonMethods, this refers to the classs you are in
    }
}

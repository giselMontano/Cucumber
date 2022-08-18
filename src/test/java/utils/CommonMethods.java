package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.PageInitializer;

import java.util.concurrent.TimeUnit;

public class CommonMethods extends PageInitializer {

    //THE ORDER OF EXECUTION IS NOT TOP TO BOTTOM IN THIS, BECAUSE ANY OTHER CLASS CALLS ONLY THE METHOD NEEDED, THE CLASS IS NOT EXECUTED
    public static WebDriver driver;
//ALL THIS CODE IS CONNECTED FROM the classes-> ConfigReader and constants in utils package. THIS WAY WE AVOID HARDCODING
//ConfigReader->READS FILE FROM resources->config->config.properties
// AND GIVES US WHATEVER WE SPECIFY IN THE KEY ConfigReader.getPropertyValue("KEY"),
// THIS KEY CAN BE BROWSER,USERNAME,PASSWORD, OR ANYTHING WE HAVE IN THE FILE
    public static void openBrowserAndLaunchApplication(){
        ConfigReader.readProperties(Constants.CONFIGURATION_FILEPATH);
        //cross browser testing, we have defined the browser in
        // non java resources file -> config->"Config.properties"
        // and to read that File we need java ConfigReader class in the file utils
        switch (ConfigReader.getPropertyValue("browser")){//this key you can find it in the class utils->ConfigReader that read the file from resources->config->config.properties
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                throw new RuntimeException("Invalid browser name");//we write this exception because sometimes in the file where all the information is defined "Config.properties"
                                                                   //the spelling can be incorrect, and we need to show the end user where is the error
        }

        driver.manage().window().maximize();//we use this so when we are navigating to a browser the execution or a functionality does not get effect by the small window
        driver.get(ConfigReader.getPropertyValue("url"));//this key you can find it in the class utils->ConfigReader that read the file from resources->config->config.properties
        driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);//we use IMPLICIT_WAIT from "constant class" in utils package, this way we do not hardcode
        //this method is used to initialize all the objects of the pages at the very beginning
        initializePageObjects();//THIS IS COMING FROM PARENT CLASS "PageInitializer" from "steps" package that is also extending this class
    }

    public static void closeBrowser(){
        driver.quit();
    }

    public static void sendText(WebElement element, String textToSend){//We will need to send keys along the tests. Therefore we use
                                                                     //WebElement as data type for the locator's element->can be any name, and String because the locators will always be Strings
                                                                     //THIS CAN BE OVERRIDE ANYWHERE IN THE CODE
        element.clear();//since we will be using this code everywhere in the code we need to clear the data just in case this element has already a value
        element.sendKeys(textToSend);
    }
    //it will return 20 sec wait
    //CREATING THE EXPLICIT WAIT
    public static WebDriverWait getWait(){//EXPLICIT WAIT THAT RELATES IN CONDITION, WebDriverWait this is a class from selenium
        WebDriverWait wait = new WebDriverWait(driver, Constants.EXPLICIT_WAIT);//EXPLICIT_WAIT->got it from Constants class that assigned 20 sec wait
        return wait;
    }

    //it will wait till the time element becomes clickable
    //ADDING THE EXPLICIT WAIT TO METHOD
    public static void waitForClickability(WebElement element){
        getWait().until(ExpectedConditions.elementToBeClickable(element));//ExpectedConditions.elementToBeClickable CLASS FROM SELENIUM,
                                                             // element FROM METHOD LINE 54 sendText(WebElement element
    }

    //to perform click operation
    //APPLYING THE EXPLICIT WAIT METHOD TO A CONDITION, IT WILL WAIT TILL IS THE ELEMENT IS CLICKABLE
    public static void click(WebElement element){
        waitForClickability(element);//APPLYING THE WAIT WE CREATE IN THE METHOD ABOVE "public static void waitForClickability(WebElement element){"
        element.click();
    }

    //select class for dropdown, BY VISIBLE TEXT
    public static void selectDropdown(WebElement element, String text){
        Select s = new Select(element);
        s.selectByVisibleText(text);
    }

    //CREATING js click/JAVASCRIPT Executor method TO CLICK IF REGULAR CLICK DOES NOT WORK
    public static JavascriptExecutor getJSExecutor(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return js;
    }

    //APPLYING JAVASCRIPT Executor method to perform click
    public static void jsClick(WebElement element){
        getJSExecutor().executeScript("arguments[0].click();", element);//"arguments[0].click();" this is a script meaning stays the same always
    }


}

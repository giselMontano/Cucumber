package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openxmlformats.schemas.presentationml.x2006.main.CTCommonSlideData;
import utils.CommonMethods;

public class DashboardPage extends CommonMethods {
                    //FIRST THING FIRST EXTEND COMMON METHODS
    //THESE ARE THE LOCATORS FROM DASHBOARD SCREEN SUCH AS: PIM--> EMPLOYEE LIST

    @FindBy(id = "menu_pim_viewPimModule")
    public WebElement pimOption;

    @FindBy(id = "menu_pim_viewEmployeeList")
    public WebElement employeeListOption;

    public DashboardPage() {
        PageFactory.initElements(driver, this);
    }
}
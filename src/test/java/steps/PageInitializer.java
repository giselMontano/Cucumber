package steps;

import pages.DashboardPage;
import pages.EmployeeInformationPage;
import pages.LoginPage;

public class PageInitializer {
    //PARENT OF COMMON METHODS
//WE DO NOT NEED TO EXTEND COMMON METHODS, BECAUSE THIS IS THE ONLY CLASS THAT COMMON METHODS WILL EXTEND
// SO THIS WAY COMMON METHODS CAN PROVIDE ALL THESE PAGE OBJECTS TO ALL THE CLASSES

    //CREATION OF OBJECTS
    public static LoginPage login;
    public static DashboardPage dash;
    public static EmployeeInformationPage emp;


    //INITIALIZE ALL THE OBJECTS
    public static void initializePageObjects(){
        login = new LoginPage();
        dash = new DashboardPage();
        emp = new EmployeeInformationPage();
    }
}

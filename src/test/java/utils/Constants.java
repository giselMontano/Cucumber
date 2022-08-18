package utils;

public class Constants {

    //THIS System.getProperty("user.dir") replace C:\User\gisel,susan,karen  or anything;
    // this way the path is not unique and can read any path from any computer.

    //"/src/test/resources/config/Config.properties";<--//this path is taken from hierarchy from "scr" and so on till the desire folder
    //CONSTANT METHODS ARE THINGS THAT WILL NOT CHANGE AND IS WRITTEN IN CAPITAL LETTERS
    public static final String CONFIGURATION_FILEPATH = System.getProperty("user.dir") + "/src/test/resources/config/Config.properties";
    public static final int IMPLICIT_WAIT = 10;
    public static final int EXPLICIT_WAIT = 20;


}

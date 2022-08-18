package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    static Properties prop;

//REUSE THE CODE FROM JAVA
    //THIS CODE READ THE PATH FROM THE FILE WHERE YOU STORE URL,USERNAME,ETC. resorses->config-> Config.properties.
     //important this path is CONSTANT it will not change the location therefore we need to declare it in Constant class inside the Utils

    public static Properties readProperties(String filePath){//this read any line/information from the file Config.properties against the key down bellow and return what you need
        try {
            FileInputStream fis = new FileInputStream(filePath);
            prop = new Properties();
            prop.load(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }

    public static String getPropertyValue(String key){//this key can be browser, url, username
        return prop.getProperty(key);
    }


}

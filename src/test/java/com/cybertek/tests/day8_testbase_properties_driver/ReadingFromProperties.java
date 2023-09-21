package com.cybertek.tests.day8_testbase_properties_driver;

import com.cybertek.utilities.ConfigurationReader;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadingFromProperties {

    @Test
    public void reading_from_properties() throws IOException {

        //1- Create properties class object
        Properties properties = new Properties();

        //2- Open the file in JVM memory and pass the path of the file
        String path = "configuration.properties";

        FileInputStream file = new FileInputStream(path);

        //3- Load the opened file into th Properties object.
        properties.load(file);

        // read some values from the file
        System.out.println("properties.getProperty(\"browser\") = " + properties.getProperty("browser"));

        // write a statement that is returning johndoe
        System.out.println("properties.getProperty(\"username\") = " + properties.getProperty("username"));


    }

    @Test
    public void using_properties_util_method(){

        ConfigurationReader.getProperty("browser");
        ConfigurationReader.getProperty("url");
    }
}

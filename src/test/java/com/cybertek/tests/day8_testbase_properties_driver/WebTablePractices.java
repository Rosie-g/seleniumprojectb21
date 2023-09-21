package com.cybertek.tests.day8_testbase_properties_driver;

import com.cybertek.tests.base.TestBase;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.WebOrderUtils;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class WebTablePractices extends TestBase {

        @Test
    public void verify_order_test() throws IOException {

            Properties properties = new Properties();

            //2- Open the file in JVM memory and pass the path of the file
            String path = "configuration.properties";

            FileInputStream file = new FileInputStream(path);

            //3- Load the opened file into th Properties object.
            properties.load(file);

            String url = properties.getProperty("webOrderURL");

            driver.get(url);

            WebOrderUtils.loginToSmartBear(driver);
            BrowserUtils.sleep(1);

            //Verify "Mark Smith" is in the list
            WebOrderUtils.verifyOrder(driver,"Mark Smith");

    }


}

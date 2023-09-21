package com.cybertek.tests.day9_driver_actions_uploads;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DriverUtilsPractice {

    @Test
    public void simple_google_search_test() {

        // Go to google.com
        // Search for a value
        // Assert title contains the value

        Driver.getDriver().get(ConfigurationReader.getProperty("googleUrl"));

        //Search for a value

        WebElement searchBox = Driver.getDriver().findElement(By.name("q"));

        String searchValue = ConfigurationReader.getProperty("searchValue");
        searchBox.sendKeys(searchValue + Keys.ENTER);

        //Assert title contains the value

        // actual --> actual page,browser
        String actualTitle = Driver.getDriver().getTitle();

        // expected --> comes from documentation
        String expectedInTitle = searchValue;

        Assert.assertTrue(actualTitle.contains(expectedInTitle));

        // calling the custom method we created to close the browser from Driver class
        Driver.closeDriver();


    }


}

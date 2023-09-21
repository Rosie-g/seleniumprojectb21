package com.cybertek.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class WebOrderUtils {

     /*
        Make the method static so that we don't have to create
        instance of the class.
     */

    public static void loginToSmartBear(WebDriver driver){


        // Enter Username: "Tester"
        WebElement inputUserName = driver.findElement(By.id("ctl00_MainContent_username"));
        inputUserName.sendKeys("Tester");

        // Enter Password: "test"
        WebElement inputPassword = driver.findElement(By.id("ctl00_MainContent_password"));
        inputPassword.sendKeys("test");

        // Click to Login Button:
        WebElement loginButton = driver.findElement(By.id("ctl00_MainContent_login_button"));
        loginButton.click();
    }

    public static void verifyOrder(WebDriver driver,String expectedName){

        //PRACTICE #4: Method: verifyOrder
        // •Create a method named verifyOrder in SmartBearUtils class.
        // •Method takes WebDriver object and String(name).
        // •Method should verify if given name exists in orders.
        // •This method should simply accepts a name(String), and assert whether given name is in the list or not.
        // •Create a new TestNG test to test if the method is working as expected.


        List<WebElement> allNames = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr//td[2]"));

        // we need to loop through 'allNames' List of WebElement and make sure 'expectedName' is in there

        for (WebElement each: allNames){
            if (each.getText().equals(expectedName)) {
                Assert.assertTrue(each.getText().equals(expectedName));
                return;
            }
        }

        //Assert.fail() method will fail thr test no matter what.
        Assert.fail();

    }


}

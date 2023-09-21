package com.cybertek.tests.practice;

import com.cybertek.pages.LoginPage;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SmartBNeg {

    public LoginPage loginPage = new LoginPage();

    @Test
    public void smart_bear_incorrect_password(){

        //TC #1: SmartBear negative test case scenario : Wrong password

        //1. Go to: http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
        Driver.getDriver().get(ConfigurationReader.getProperty("webOrderURL"));
        //2. Enter correct username

        String username =ConfigurationReader.getProperty("usernameSmartBear");
        loginPage.inputUsername.sendKeys(username);

        //3. Enter incorrect password
        loginPage.inputPassword.sendKeys("hope");
        loginPage.loginButton.click();

        //4. Verify error message is displayed
        Assert.assertTrue(loginPage.errorMessage.isDisplayed());
    }

    @Test
    public void smart_bear_incorrect_username(){

        //1. Go to: http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
        Driver.getDriver().get(ConfigurationReader.getProperty("webOrderURL"));

        //2. Enter incorrect username
        loginPage.inputUsername.sendKeys("post");

        //3. Enter correct password
        String password = ConfigurationReader.getProperty("passwordSmartBear");
        loginPage.inputPassword.sendKeys(password);
        loginPage.loginButton.click();

        //4. Verify error message is displayed
        Assert.assertTrue(loginPage.errorMessage.isDisplayed());


    }


}

package com.cybertek.tests.day10_pom_synchronization_jsExecutor;

import com.cybertek.pages.LoginPage;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.testng.annotations.Test;

public class PageObjectModelPractices {

    @Test
    public void login_page_smartBear(){

        String url= ConfigurationReader.getProperty("webOrderURL");
        Driver.getDriver().get(url);

        //When we create object of this class,the object and driver instance will be
        // already initialized(recognize each other)
        LoginPage loginPage = new LoginPage();

        //We are allowed to use object of this class to reach web elements and use selenium methods

        //Sending username using object of LoginPage and web element (that has been located in LoginPage)
        String username = ConfigurationReader.getProperty("usernameSmartBear");
        loginPage.inputUsername.sendKeys(username);

        String password = ConfigurationReader.getProperty("passwordSmartBear");
        loginPage.inputPassword.sendKeys(password);

        loginPage.loginButton.click();



    }
}

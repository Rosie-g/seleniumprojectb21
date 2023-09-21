package com.cybertek.tests.practice;

import com.cybertek.pages.DynamicPage;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DynamicallyLoaded {

    @Test
    public void dynamic_loaded() {

        //TC#41 : Dynamically Loaded Page Elements 1
        //1. Go to http://practice.cybertekschool.com/dynamic_loading/1
        Driver.getDriver().get("http://practice.cybertekschool.com/dynamic_loading/1");

        //2. Click to start
        DynamicPage dynamicPage = new DynamicPage();

        dynamicPage.startButton.click();

        //3. Wait until loading bar disappears
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);

        wait.until(ExpectedConditions.visibilityOf(dynamicPage.helloWorld));

        //4. Assert username inputbox is displayed
        Assert.assertTrue(dynamicPage.username.isDisplayed());

        //5. Enter username: tomsmith
        dynamicPage.username.sendKeys("tomsmith");

        //6. Enter password: incorrectpassword
        dynamicPage.password.sendKeys("incorrectpassword");

        //7. Click to Submit button
        dynamicPage.submitButton.click();

        //8. Assert “Your password is invalid!” text is displayed.
        Assert.assertTrue(dynamicPage.errorMessage.isDisplayed());

        //Note: Follow POM Design Pattern


    }
}

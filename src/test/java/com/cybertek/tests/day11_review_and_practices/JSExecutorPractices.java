package com.cybertek.tests.day11_review_and_practices;

import com.cybertek.pages.SignUpPage;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class JSExecutorPractices {

    @Test
    public void fill_form_using_jsExecutor(){

        //getting the page
        Driver.getDriver().get("http://practice.cybertekschool.com/sign_up");

        //Create instance of JSExecutor and cast our WebDriver type to it
        JavascriptExecutor js =(JavascriptExecutor) Driver.getDriver();

        // Creating the object to be able to use WebElements from it
        SignUpPage signUpPage = new SignUpPage();

        //Use .setAttribute function from JavaScript to sendKeys
        BrowserUtils.sleep(1);
        js.executeScript("arguments[0].setAttribute('value','jane doe')",signUpPage.inputFullName);

        // sending email using JSExecutor
        BrowserUtils.sleep(1);
        js.executeScript("arguments[0].setAttribute('value','something@gmail.com')",signUpPage.inputEmail);

        //clicking using JSExecutor
        BrowserUtils.sleep(1);
        js.executeScript("arguments[0].click();",signUpPage.signUpButton);




    }

    @Test
    public void opening_tabs_using_jsExecutor(){

        //getting the page
        Driver.getDriver().get("http://amazon.com");

        //Downcasting our driver type directly in one line
        ((JavascriptExecutor) Driver.getDriver()).executeScript("window.open('https://google.com','_balnk');");
        ((JavascriptExecutor) Driver.getDriver()).executeScript("window.open('https://etsy.com','_balnk');");
        ((JavascriptExecutor) Driver.getDriver()).executeScript("window.open('https://facebook.com','_balnk');");




    }
}

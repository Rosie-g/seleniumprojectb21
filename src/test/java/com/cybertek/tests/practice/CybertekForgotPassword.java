package com.cybertek.tests.practice;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CybertekForgotPassword {

    public static void main(String[] args) {

        //TC #1: PracticeCybertek.com_ForgotPassword WebElement verification
        // 1. Open Chrome browser
        // 2. Go to http://practice.cybertekschool.com/forgot_password
        // 3. Locate all the WebElements on the page using XPATH and/or CSS locator only (total of 6)
        //    a. “Home” link
        //    b. “Forgot password” header
        //    c. “E-mail” text
        //    d. E-mail input box
        //    e. “Retrieve password” button
        //    f. “Powered by Cybertek School” text
        // 4. Verify all WebElements are displayed


        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");
        WebElement home =  driver.findElement(By.xpath("//a[.='Home']"));

        if (home.isDisplayed()){
            System.out.println("Home link is displayed");
        }else{
            System.out.println("Home link is not displayed");
        }

        WebElement forgotPassword = driver.findElement(By.xpath("//h2[.='Forgot Password']"));

        if (forgotPassword.isDisplayed()){
            System.out.println("Forgot Password is displayed");
        }else{
            System.out.println("Forgot Password is not displayed");
        }

        WebElement eMailText = driver.findElement(By.xpath("//label[@for='email']"));

        if (eMailText.isDisplayed()){
            System.out.println("Email Text is Displayed");
        }else{
            System.out.println("Email Text is not Displayed");
        }

        WebElement emailInputBox = driver.findElement(By.cssSelector("input[type='text']"));

        if (emailInputBox.isDisplayed()){
            System.out.println("Email Input Box is displayed");
        }else{
            System.out.println("Email Input Box is not displayed");
        }

        WebElement retrievePasswordButton = driver.findElement(By.xpath("//button[id='form_submit']"));

        if (retrievePasswordButton.isDisplayed()){
            System.out.println("Retrieve Password Button is displayed");
        }else{
            System.out.println("Retrieve Password Button is not displayed");
        }

        WebElement poweredBy = driver.findElement(By.xpath("//div[.='Powered by']"));

        if (poweredBy.isDisplayed()){
            System.out.println("Powered by is Displayed ");
        }else{
            System.out.println("Powered by is not displayed");
        }

        driver.close();


    }
}

package com.cybertek.tests.day3_cssSelector_xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WT_CybertekLinkVerification {

    public static void main(String[] args) {

        /*
         //TC #3: PracticeCybertek/ForgotPassword URL verification
        //1. Open Chrome browser
        //2. Go to http://practice.cybertekschool.com/forgot_password
        //3. Enter any email into input box
        //4. Click on Retrieve password
        //5. Verify URL contains:
        //Expected: “email_sent”
        //6. Verify text box displayed the content as expected.
        //Expected: “Your e-mail’s been sent!”
         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/forgot_password");
        driver.findElement(By.name("email")).sendKeys("ruz0408@gmail.com");
        driver.findElement(By.id("form_submit")).click();

        String expectedURL = "email_sent";
        String actualURL = driver.getCurrentUrl();

        if(actualURL.contains(expectedURL)){
            System.out.println("Passed");
       }else{
            System.out.println("Failed");
        }

//        String expectedResult = "Your e-mail's been sent!";
//        String actualResult = driver.findElement(By.name("confirmation_message")).getText();
//
//        if(actualResult.contains(expectedResult)){
//            System.out.println("Displayed");
//        }else{
//            System.out.println("Not Displayed");
//        }

        //6. Verify textbox displayed the content as expected.

        WebElement confirmation_message = driver.findElement(By.name("confirmation_message"));

        //First verification is to check if it is displayed on the page or not.

        if(confirmation_message.isDisplayed()){
            System.out.println("Confirmation displayed");
        }else {
            System.out.println("Confirmation Failed");
        }

        //Second verification : is to check the content of the confirmation_message web element
        //Expected: “Your e-mail’s been sent!”

        String expectedMessage = "Your e-mail's been sent!";
        //String actualMessage = driver.findElement(By.name("confirmation_message")).getText();
        String actualMessage = confirmation_message.getText();

        if (actualMessage.equals(expectedMessage)){
            System.out.println("Message verification PASSED!");
        }else{
            System.out.println("Message verification FAILED!!!");
            System.out.println("expectedMessage = " + expectedMessage);
            System.out.println("actualMessage = " + actualMessage);
        }

        driver.close();




   }
}

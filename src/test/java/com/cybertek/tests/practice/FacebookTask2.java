package com.cybertek.tests.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookTask2 {

    public static void main(String[] args) throws InterruptedException {

        /*
         TC #2: Facebook incorrect login title verification
   1.Open Chrome browser
   2.Go to https://www.facebook.com
   3.Enter incorrect username
   4.Enter incorrect password
   5.Verify title changed to: Expected: “Log into Facebook | Facebook”
         */

        // setup
        WebDriverManager.chromedriver().setup();

        //open browser
        WebDriver driver = new ChromeDriver();

        // Go to https://www.facebook.com
        driver.get("https://www.facebook.com");

        // Enter incorrect username
        driver.findElement(By.id("email")).sendKeys("some@gmail.com");

        // Enter incorrect password
        driver.findElement(By.id("pass")).sendKeys("rtyuio"+ Keys.ENTER);

        // Verify title changed to: Expected: “Log into Facebook | Facebook”


        String expectedResult = "Log into Facebook";
        Thread.sleep(5000);
        String actualResult = driver.getTitle();

        if(actualResult.equals(expectedResult)){
            System.out.println("Title verification PASSED");
        }else{
            System.err.println("Title verification FAILED");
        }


    }
}

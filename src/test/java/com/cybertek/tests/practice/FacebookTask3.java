package com.cybertek.tests.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookTask3 {

    public static void main(String[] args) {

        /*
        TC #3: Facebook header verification
        1.Open Chrome browser
        2.Go to https://www.facebook.com
        3.Verify header text is as expected: Expected: “Connect with friends and the world around you on Facebook.”


         */

        // setup
        WebDriverManager.chromedriver().setup();

        // open browser
        WebDriver driver = new ChromeDriver();

        // Go to https://www.facebook.com
        driver.get("https://www.facebook.com");

        // Verify header text is as expected:
        // Expected: “Connect with friends and the world around you on Facebook.”

        String expectedHeader = "Connect with friends and the world around you on Facebook.";
        String actualHeader = driver.findElement(By.className("_8eso")).getText();

        if(expectedHeader.equals(actualHeader)){
            System.out.println("Good job");

        }else {
            System.out.println("sorry");
            System.out.println("Your expected result: "+expectedHeader);
            System.out.println("Your actual result: "+actualHeader);
        }

        driver.close();

    }
}

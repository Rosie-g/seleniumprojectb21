package com.cybertek.tests.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookTask1 {

    public static void main(String[] args) {

/*
        TC #1: Facebook title verification
        1.Open Chrome browser
        2.Go to https://www.facebook.com
        3. Verify title: Expected: “Facebook -Log In or Sign Up”TC


 */
        // setup
        WebDriverManager.chromedriver().setup();
        // open browser
        WebDriver driver = new ChromeDriver();

        //  Go to https://www.facebook.com
        driver.get("https://www.facebook.com");

        // Verify title: Expected: “Facebook -Log In or Sign Up”

        String expectedResult ="Facebook - Log In or Sign Up";
        String actualResult = driver.getTitle();

        if(expectedResult.equals(actualResult)){
            System.out.println("Title verification PASSED");
        }else{
            System.err.println("Title verification FAILED");
        }

        driver.close();


    }
}
/*


   •Create new class for each task.
   •There are some tips in the 2nd page for whoever needs it.
   •Please try to solve yourself first before moving to the tips.
 */
package com.cybertek.tests.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookTask4 {

    public static void main(String[] args) {

        /*
        TC #4: Facebook header verification
        1.Open Chrome browser
        2.Go to https://www.facebook.com
        3.Verify “Create a page” link href value contains text: Expected: “registration_form”
         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com");

        String expectedHref = "registration_form";
       String actualHref = driver.findElement(By.linkText("Create a Page")).getAttribute("href");

        System.out.println("actualHref = " + actualHref);
        System.out.println("expectedHref = " + expectedHref);

        if (actualHref.contains(expectedHref)) {
            System.out.println("good");
        } else {
            System.out.println("failed");
            System.out.println("Exp res: "+expectedHref+" actual: "+actualHref);
        }

    }
}

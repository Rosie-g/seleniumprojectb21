package com.cybertek.tests.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ZeroBankTask2 {

    public static void main(String[] args) {

        /*
        TC #2: Zero Bank link text verification
        1.Open Chrome browser
        2.Go to http://zero.webappsecurity.com/login.html
        3.Verify link text from top left:
        Expected: “Zero Bank”
        4.Verify link href attribute value contains:
        Expected: “index.html”
         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://zero.webappsecurity.com/login.html");


        String expectedLinkText = "Zero Bank";
        String actualLinkText = driver.findElement(By.className("brand")).getText();

        if (expectedLinkText.equals(actualLinkText)) {
            System.out.println("Valid Text");
        }else {
            System.out.println("Invalid Text");
        }

        String expectedInHref = "index.html";
        String actualHref = driver.findElement(By.linkText("Zero Bank")).getAttribute("href");

        if(actualHref.contains(expectedInHref)){
            System.out.println("Verified");
        }else{
            System.out.println("Not verified");
        }

        driver.close();

    }
}
